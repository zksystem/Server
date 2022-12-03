package com.ferradesign.server.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class User {

    int id;
    String login;
    String password;
    int role;
    String email;
    Date created;

    public User(int id, String login, String password, int role, String email, Date created) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.email = email;
        this.created = created;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", created=" + created +
                '}';
    }
}
