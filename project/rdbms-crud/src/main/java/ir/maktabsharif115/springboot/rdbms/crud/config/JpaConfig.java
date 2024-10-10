package ir.maktabsharif115.springboot.rdbms.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.ZonedDateTime;
import java.util.Optional;

@Configuration
@EnableJpaAuditing(dateTimeProviderRef = JpaConfig.DATE_TIME_PROVIDER)
public class JpaConfig {

    public static final String DATE_TIME_PROVIDER = "DateTimeProvider";

    @Bean(JpaConfig.DATE_TIME_PROVIDER)
    @Primary
    public DateTimeProvider auditingDateTimeProvider() {
        return () -> Optional.of(ZonedDateTime.now());
    }
}
