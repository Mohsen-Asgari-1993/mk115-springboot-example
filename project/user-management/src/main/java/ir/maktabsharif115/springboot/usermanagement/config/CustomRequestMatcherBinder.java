package ir.maktabsharif115.springboot.usermanagement.config;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustomRequestMatcherBinder implements RequestMatchersBinder {

    @Override
    public String[] getPermitAllUrls() {
        return new String[]{
                "/swagger-ui/**",
                "/v3/api-docs/**",
        };
    }

    @Override
    public Collection<RequestMatcherAuthorityPair> getAuthorityPairs() {
        return null;
    }
}
