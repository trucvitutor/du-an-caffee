package model;

public class OrderDetail {
    private int id;
    private Product product;
    private int quantity;
    private int price;
    private Customer customer;

    public OrderDetail(int id, Product product, int quantity, int price, Customer customer) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.customer = customer;
    }

    public OrderDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                ", customer=" + customer +
                '}';
    }
}
