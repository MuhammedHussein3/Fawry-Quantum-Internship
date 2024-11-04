package utility;

import entity.Product;

import java.time.LocalDateTime;

public class NonShippableAndExpirableProduct extends Product {

    private final LocalDateTime expirationDate;
    public NonShippableAndExpirableProduct(String name, double price, int quantity, LocalDateTime createdAt, LocalDateTime expirationDate) {
        super(name, price, quantity, createdAt);
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean isExpire() {
        return LocalDateTime.now().isAfter(expirationDate);
    }

    @Override
    public boolean isShipping() {
        return false;
    }
}
