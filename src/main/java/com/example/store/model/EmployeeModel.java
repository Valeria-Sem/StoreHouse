package com.example.store.model;

import java.util.Objects;

public class EmployeeModel {
    private int id;
    private String login;
    private String password;
    private String fio;
    private String position;

    public EmployeeModel() {
    }

    public EmployeeModel(int id, String login, String password, String fio, String position) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.fio = fio;
        this.position = position;
    }

    public EmployeeModel(String login, String password, String fio, String position) {
        this.login = login;
        this.password = password;
        this.fio = fio;
        this.position = position;
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

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeModel that = (EmployeeModel) o;
        return id == that.id && login.equals(that.login) && password.equals(that.password) && fio.equals(that.fio) && position.equals(that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, fio, position);
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", fio='" + fio + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
