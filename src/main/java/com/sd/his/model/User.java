package com.sd.his.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    @NotNull
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private boolean isActive;

    @Column
    private boolean isDeleted;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "User_Role",
            joinColumns = {@JoinColumn(name = "User_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "Role_ID", referencedColumnName = "ID")})
    private List<Role> Role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public User(String username, String password, String email, boolean isActive, boolean isDeleted, List<com.sd.his.model.Role> role, Contact contact) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        Role = role;
        this.contact = contact;
    }

    public User() {
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public List<com.sd.his.model.Role> getRole() {
        return Role;
    }

    public void setRole(List<com.sd.his.model.Role> role) {
        Role = role;
    }

}
