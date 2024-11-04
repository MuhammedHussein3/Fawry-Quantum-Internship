package service;

import entity.OrderItem;

import java.util.List;

public interface ShippingService {
    double calculateShipping(List<OrderItem> products);
}
