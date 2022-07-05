package com.example.store.entity;

import java.util.Objects;

public class Shipment {
    private int id;
    private int idProduct;
    private int count;

    public Shipment() {
    }

    public Shipment(int id, int id_product, int count) {
        this.id = id;
        this.idProduct = id_product;
        this.count = count;
    }

    public Shipment(int id_product, int count) {
        this.idProduct = id_product;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipment shipment = (Shipment) o;
        return id == shipment.id && idProduct == shipment.idProduct && count == shipment.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idProduct, count);
    }
}
