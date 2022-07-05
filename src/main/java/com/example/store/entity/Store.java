package com.example.store.entity;

import java.util.Objects;

public class Store {
    private Long id;
    private String address;
    private int freeSpace;
    private int idCategory;

    public Store() {
    }

    public Store(Long id, String address, int freeSpace, int idCategory) {
        this.id = id;
        this.address = address;
        this.freeSpace = freeSpace;
        this.idCategory = idCategory;
    }

    public Store(String address, int freeSpace, int idCategory) {
        this.address = address;
        this.freeSpace = freeSpace;
        this.idCategory = idCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(int freeSpace) {
        this.freeSpace = freeSpace;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return freeSpace == store.freeSpace && idCategory == store.idCategory && id.equals(store.id) && address.equals(store.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, freeSpace, idCategory);
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", freeSpace=" + freeSpace +
                ", idCategory=" + idCategory +
                '}';
    }
}
