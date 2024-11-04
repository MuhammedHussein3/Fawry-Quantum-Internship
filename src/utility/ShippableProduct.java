package utility;

import entity.Product;

import java.time.LocalDateTime;

public class ShippableProduct extends Product {
    private final double weight;

    public ShippableProduct(String name, double price, int quantity, LocalDateTime createdAt, double weight) {
        super(name, price, quantity, createdAt);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean isExpire() {
        return false;
    }

    @Override
    public boolean isShipping() {
        return true;
    }
}
