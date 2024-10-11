package it.example.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

    private AuthorizationProperties authorization;

    public AuthorizationProperties getAuthorization() {
        return authorization;
    }

    public void setAuthorization(AuthorizationProperties authorization) {
        this.authorization = authorization;
    }

    public static class AuthorizationProperties {
        private List<Object> whitelist;

        public List<Object> getWhitelist() {
            return whitelist;
        }
        public void setWhitelist(List<Object> whitelist) {
            this.whitelist = whitelist;
        };

    }

    public String[] authWhitelist() {
        Set<String> ret = authorization.getWhitelist().stream().map(o -> String.valueOf(o).trim()).collect(Collectors.toSet());
        return ret.toArray(new String[ret.size()]);
    }

}
