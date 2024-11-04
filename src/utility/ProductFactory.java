package utility;

import entity.Product;

import java.time.LocalDateTime;

public class ProductFactory {
    public static Product createProduct(String productType, String name, double price, int quantity, LocalDateTime createdAt, double weight) {
        if (productType.equalsIgnoreCase("shippable")) {
            return new ShippableProduct(name, price, quantity, createdAt, weight);
        } else if (productType.equalsIgnoreCase("nonShippable")) {
            return new NonShippableProduct(name, price, quantity, createdAt);
        }
        return null;
    }
}
