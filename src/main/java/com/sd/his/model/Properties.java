package com.sd.his.model;

import javax.persistence.*;

@Entity
@Table(name = "properties")
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String client_id;
    private String client_secret;
    private String auth_server_schem;

    public Properties(String client_id, String client_secret, String auth_server_schem) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.auth_server_schem = auth_server_schem;
    }
    public Properties(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAuth_server_schem() {
        return auth_server_schem;
    }

    public void setAuth_server_schem(String auth_server_schem) {
        this.auth_server_schem = auth_server_schem;
    }
}
