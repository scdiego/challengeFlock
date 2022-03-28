package com.flockit.ejercicio.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.flockit.ejercicio.utils.Crypto;

@Entity
@Table(name = "user")
public class User {

    @Id
    private int id;

    private String username;

    private String password;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Crypto.decrypt(this.password, this.username);
    }

    public void setPassword(String password) {
        this.password = Crypto.encrypt(password, this.username);
    }
    
}
