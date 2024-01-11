package model;

import java.io.Serializable;

public class CustomerType implements Serializable {
    private static final String CUSTOMER_TYPE="src/data/Customer.txt";
    private static final long serialVersionUID = 9042L;
    private int id;
    private String name;

    public CustomerType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CustomerType() {
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
        return "CustomerType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
