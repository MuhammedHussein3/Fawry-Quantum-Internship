package utility;

import entity.Product;

import java.time.LocalDateTime;

public class ShippableAndExpirableProduct extends Product {

    private final LocalDateTime expirationDate;
    private final double weight;

    public ShippableAndExpirableProduct(String name, double price, int quantity, LocalDateTime createdAt, double weight, LocalDateTime expirationDate) {
        super(name, price, quantity, createdAt);
        this.weight = weight;
        this.expirationDate = expirationDate;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean isExpire() {
        return LocalDateTime.now().isAfter(expirationDate);
    }

    @Override
    public boolean isShipping() {
        return true;
    }
}
