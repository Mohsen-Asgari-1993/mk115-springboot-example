package ir.maktabsharif115.springboot.usermanagement.config;

import lombok.SneakyThrows;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;

@Configuration
@EnableMethodSecurity
public class ProjectConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @SneakyThrows
    public SecurityFilterChain securityFilterChain(HttpSecurity http, RequestMatchersBinder requestMatchersBinder) {
        http.csrf(AbstractHttpConfigurer::disable);
        http.cors(AbstractHttpConfigurer::disable);

        http.authorizeHttpRequests(
                        request -> {
                            String[] permitAllUrls = requestMatchersBinder.getPermitAllUrls();
                            if (permitAllUrls != null && permitAllUrls.length > 0) {
                                request.requestMatchers(permitAllUrls)
                                        .permitAll();
                            }
                            Collection<RequestMatchersBinder.RequestMatcherAuthorityPair> authorityPairs =
                                    requestMatchersBinder.getAuthorityPairs();
                            if (CollectionUtils.isNotEmpty(authorityPairs)) {
                                for (RequestMatchersBinder.RequestMatcherAuthorityPair pair : authorityPairs) {
                                    request.requestMatchers(pair.getUrls())
                                            .hasAnyAuthority(pair.getAuthorities());
                                }
                            }
                            request.anyRequest().authenticated();
                        }
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    @ConditionalOnMissingBean
    public RequestMatchersBinder requestMatchersBinder() {
        return new DefaultRequestMatchersBinder();
    }

}
