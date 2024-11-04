package utility;

import entity.Product;

import java.time.LocalDateTime;

public class ProductExpirationFactory {

    public static Product createProduct(String productType, String name, double price, int quantity, LocalDateTime createdAt, double weight, LocalDateTime expirationDate) {
        if (productType.equalsIgnoreCase("shippableAndExpire")) {
            return new ShippableAndExpirableProduct(name, price, quantity, createdAt, weight, expirationDate);
        } else if (productType.equalsIgnoreCase("nonShippableAndExpire")) {
            return new NonShippableAndExpirableProduct(name, price, quantity, createdAt, expirationDate);
        }
        return null;
    }
}
