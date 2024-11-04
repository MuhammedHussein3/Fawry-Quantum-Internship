package utility;

import entity.Product;

import java.time.LocalDateTime;

public class NonShippableProduct extends Product {

    public NonShippableProduct(String name, double price, int quantity, LocalDateTime createdAt) {
        super(name, price, quantity, createdAt);
    }

    @Override
    public boolean isExpire() {
        return false;
    }

    @Override
    public boolean isShipping() {
        return false;
    }
}
