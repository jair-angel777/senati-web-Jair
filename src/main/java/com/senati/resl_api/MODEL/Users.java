package com.senati.resl_api.MODEL;


import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class Users {
    @Id
    private int id;
    private String name;
    private String lastname;

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(Integer Id) {
        this.id = Id;
    }
}
