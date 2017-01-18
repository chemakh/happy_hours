package com.ch.happyhours.auth.config;

import com.ch.happyhours.auth.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter
{

    @Value("${happy-hours.security.authentication.oauth.clientid}")
    private String oauthClientId;

    @Value("${happy-hours.security.authentication.oauth.secret}")
    private String oauthClientSecret;

    @Value("${happy-hours.security.authentication.oauth.scope}")
    private String scope;

    @Value("${happy-hours.security.authentication.oauth.tokenValidityInSeconds}")
    private int tokenValidityInSeconds;

    @Value("${happy-hours.security.authentication.oauth.jwtKeystoreSecret}")
    private String jwtConverterKeystoreSecret;

    @Value("${happy-hours.security.oauth2.communication.clientid}")
    private String communicationClientId;

    @Value("${happy-hours.security.oauth2.communication.secret}")
    private String communicationSecret;

    @Value("${happy-hours.security.oauth2.service.clientid}")
    private String serviceClientId;

    @Value("${happy-hours.security.oauth2.service.secret}")
    private String serviceSecret;


    @Bean
    protected JwtAccessTokenConverter jwtTokenEnhancer()
    {
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("happy-hours.jks"), jwtConverterKeystoreSecret.toCharArray());
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("happy-hours"));
        return converter;
    }

    @Bean
    public TokenEnhancer tokenEnhancer()
    {
        return new CustomTokenEnhancer();
    }

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception
    {
        clients.inMemory()
                .withClient(oauthClientId)
                .secret(oauthClientSecret)
                .accessTokenValiditySeconds(tokenValidityInSeconds)
                .authorizedGrantTypes("authorization_code", "refresh_token",
                        "password", "implicit").scopes("read", "write")
                .and()
                .withClient(communicationClientId)
                .secret(communicationSecret)
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("server")
                .and()
                .withClient(serviceClientId)
                .secret(serviceSecret)
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("server");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
            throws Exception
    {
        endpoints
                .accessTokenConverter(jwtTokenEnhancer())
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .approvalStoreDisabled();
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer)
            throws Exception
    {
        oauthServer.allowFormAuthenticationForClients();
    }

}

