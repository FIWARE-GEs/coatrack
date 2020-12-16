package eu.coatrack.admin.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

public class PublicApiTokenAccessFilter extends OAuth2AuthenticationProcessingFilter {

    public PublicApiTokenAccessFilter(ResourceServerTokenServices resourceServerTokenServices) {

        super();
        setStateless(false);
        setAuthenticationManager(oauthAuthenticationManager(resourceServerTokenServices));
    }

    private AuthenticationManager oauthAuthenticationManager(ResourceServerTokenServices tokenServices) {

        OAuth2AuthenticationManager oauthAuthenticationManager = new OAuth2AuthenticationManager();

        oauthAuthenticationManager.setResourceId("oauth2-resource");
        oauthAuthenticationManager.setTokenServices(tokenServices);
        oauthAuthenticationManager.setClientDetailsService(null);

        return oauthAuthenticationManager;
    }
}