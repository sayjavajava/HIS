package com.sd.his.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .anonymous().disable()
                .authorizeRequests()

                .antMatchers("/api-docs/**").permitAll()
                .antMatchers("/api/oauth/token").permitAll()
                .antMatchers("/api/logout").permitAll()

                .antMatchers("/api/addpermissions/**").permitAll()

                //	.antMatchers("/api").access("hasRole('ADMIN')")
                //    .antMatchers("/user/**").access("hasRole('ADMIN')")
                //	.antMatchers("/users/**").access("hasRole('ADMIN')")
                //	.antMatchers("/product/**").access("hasAuthority('ADMIN')")
                // .antMatchers("/product/**").access("hasPermission('api')")
             //   .anyRequest().authenticated()
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }

}