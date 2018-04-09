package com.sd.his.service;

import com.sd.his.configuration.AppConfigProperties;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CustomConfigService {

    private AppConfigProperties appConfigProperties;

    CustomConfigService(AppConfigProperties appConfigProperties){
        this.appConfigProperties = appConfigProperties;
    }

    public List<String> getConfigDetail(){
        appConfigProperties.getClient_id();
        return Stream.
                of(appConfigProperties.getClient_id(), appConfigProperties.getAuth_server_scheme(),
                        appConfigProperties.getClient_secret()
                ).collect(Collectors.toList());
    }
}
