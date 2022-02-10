package com.revature.models;

import com.revature.daka.persistence.Column;
import com.revature.daka.persistence.Entity;
import com.revature.daka.persistence.Id;
import com.revature.daka.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id(type = "default")
    @Column(name = "p_id")
    private int id;
    @Column(name = "p_name")
    private String productName;
    @Column(name = "p_type")
    private String productType;
    @Column(name = "cost")
    private int cost;
    @Column(name = "available")
    private boolean available;

    public Product() {
    }

    public Product(String productName, String productType, int cost, boolean available) {
        this.productName = productName;
        this.productType = productType;
        this.cost = cost;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", cost=" + cost +
                ", available=" + available +
                '}';
    }
}
