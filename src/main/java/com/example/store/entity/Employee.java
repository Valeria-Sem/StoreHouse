package com.example.store.entity;

import java.util.Objects;

public class Employee {
    private Long id;
    private String fio;
    private int idPosition;

    public Employee() {
    }

    public Employee(Long id, String fio, int idPosition) {
        this.id = id;
        this.fio = fio;
        this.idPosition = idPosition;
    }

    public Employee(String fio, int idPosition) {
        this.fio = fio;
        this.idPosition = idPosition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return idPosition == employee.idPosition && id.equals(employee.id) && fio.equals(employee.fio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fio, idPosition);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", idPosition=" + idPosition +
                '}';
    }
}
