package com.example.store.entity;

import java.time.LocalDate;
import java.util.Objects;

public class StoreProduct {
    private Long id;
    private int idStore;
    private int idProduct;
    private int amount;
    private LocalDate date;

    public StoreProduct() {
    }

    public StoreProduct(Long id, int idStore, int idProduct, int amount, LocalDate date) {
        this.id = id;
        this.idStore = idStore;
        this.idProduct = idProduct;
        this.amount = amount;
        this.date = date;
    }

    public StoreProduct(int idStore, int idProduct, int amount, LocalDate date) {
        this.idStore = idStore;
        this.idProduct = idProduct;
        this.amount = amount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreProduct that = (StoreProduct) o;
        return idStore == that.idStore && idProduct == that.idProduct && amount == that.amount && id.equals(that.id) && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idStore, idProduct, amount, date);
    }

    @Override
    public String toString() {
        return "StoreProduct{" +
                "id=" + id +
                ", idStore=" + idStore +
                ", idProduct=" + idProduct +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
