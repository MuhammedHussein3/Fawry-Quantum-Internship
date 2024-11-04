package entity;


import java.time.LocalDateTime;

public abstract class Product {

    private String name;

    private double price;

    private int quantity;

    private LocalDateTime createdAt;





    public Product(String name, double price, int quantity, LocalDateTime createdAt) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.createdAt = createdAt;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public abstract boolean isExpire();
    public abstract boolean isShipping();

}
