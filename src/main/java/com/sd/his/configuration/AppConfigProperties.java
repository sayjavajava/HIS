package com.sd.his.configuration;

import com.sd.his.model.Permission;
import com.sd.his.model.Properties;
import com.sd.his.repositiories.PermissionRepo;
import com.sd.his.repositiories.PropertiesRepo;
import com.sd.his.service.userService;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import net.bull.javamelody.MonitoringSpringAdvisor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.activation.DataSource;
import javax.annotation.PostConstruct;
import java.sql.SQLException;


@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="app")
public class AppConfigProperties  {
    private String client_id;
    private String client_secret;
    private String auth_server_scheme;

    public AppConfigProperties(){}


    @Autowired
    private PropertiesRepo propertiesRepo;

    @PostConstruct
    public void init(){
        Properties properties = propertiesRepo.findById(1);
        this.setClient_id(properties.getClient_id());
        this.setClient_secret(properties.getClient_secret());
        this.setAuth_server_scheme(properties.getAuth_server_schem());
    }

    private final Logger logger = LoggerFactory.getLogger(AppConfigProperties.class);
    public AppConfigProperties(String client_id, String client_secret, String auth_server_scheme) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.auth_server_scheme = auth_server_scheme;
    }



    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getAuth_server_scheme() {
        return auth_server_scheme;
    }

    public void setAuth_server_scheme(String auth_server_scheme) {
        this.auth_server_scheme = auth_server_scheme;
    }

}
