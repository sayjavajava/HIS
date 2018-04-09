package com.sd.his.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "contact")
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date created_on;
    private Date updated_on;

    @OneToOne
    @JsonBackReference
    private User updated_by;

    @OneToOne
    @JoinColumn(name = "created_by")
    @JsonBackReference
    private User created_by;

    public Contact(Date created_on, Date updated_on, User updated_by, User created_by) {
        this.created_on = created_on;
        this.updated_on = updated_on;
        this.updated_by = updated_by;
        this.created_by = created_by;
    }

    public Contact(Date created_on, User created_by) {
        this.created_on = created_on;
        this.created_by = created_by;
    }

    public Contact() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public Date getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(Date updated_on) {
        this.updated_on = updated_on;
    }

    public User getCreated_by() {
        return created_by;
    }

    public void setCreated_by(User created_by) {
        this.created_by = created_by;
    }

    public User getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(User updated_by) {
        this.updated_by = updated_by;
    }

}