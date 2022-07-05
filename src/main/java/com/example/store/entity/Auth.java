package com.example.store.entity;

import java.util.Objects;

public class Auth {
    private int id;
    private String login;
    private String password;
    private Long idEmpl;

    public Auth() {
    }

    public Auth(int id, String login, String password, Long idEmpl) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.idEmpl = idEmpl;
    }

    public Auth(String login, String password, Long idEmpl) {
        this.login = login;
        this.password = password;
        this.idEmpl = idEmpl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getIdEmpl() {
        return idEmpl;
    }

    public void setIdEmpl(Long idEmpl) {
        this.idEmpl = idEmpl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auth auth = (Auth) o;
        return id == auth.id && Objects.equals(idEmpl, auth.idEmpl) && login.equals(auth.login) && password.equals(auth.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, idEmpl);
    }

    @Override
    public String toString() {
        return "Auth{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", idEmpl=" + idEmpl +
                '}';
    }
}
