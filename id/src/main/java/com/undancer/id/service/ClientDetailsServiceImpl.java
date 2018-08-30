package com.undancer.id.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;

/**
 * Created by undancer on 2017/5/24.
 */
public class ClientDetailsServiceImpl implements ClientDetailsService, InitializingBean {

    private Properties properties;

    @Override
    public void afterPropertiesSet() throws Exception {
        properties = new Properties();
        properties.setProperty("client", "secret");
    }

    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        BaseClientDetails details = new BaseClientDetails();
        String clientSecret = this.properties.getProperty(clientId, clientId);
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        details.setResourceIds(details.getResourceIds());
        details.setAutoApproveScopes(Arrays.asList(".*"));
        details.setScope(Arrays.asList("read", "write"));
        details.setAuthorizedGrantTypes(Arrays.asList("authorization_code",
                "password", "client_credentials", "implicit", "refresh_token"));
        details.setAuthorities(
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
        details.setRegisteredRedirectUri(new HashSet<>(Arrays.asList("http://ui:8080/login")));
//                details.setAccessTokenValiditySeconds(null);
//                details.setRefreshTokenValiditySeconds(null);
        return details;
    }
}
