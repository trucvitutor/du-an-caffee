package model;

import java.io.Serializable;

public class Product implements Serializable {

    private static final long serialVersionUID = 234L;
    private int id;
    private String name;
    private double price;
    private ProductType productType;

    public Product(int id, String name, double price, ProductType productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", productType=" + productType +
                '}';
    }
}
