package com.example.store.entity;

import java.util.Objects;

public class Supplier {
    private Long id;
    private String name;

    public Supplier() {
    }

    public Supplier(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Supplier(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return id.equals(supplier.id) && name.equals(supplier.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
