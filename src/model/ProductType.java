package model;

import java.io.Serializable;

public class ProductType implements Serializable {
    private static final long serialVersionUID = 234L;
    private int id;
    private String name;

    public ProductType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductType() {
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

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
