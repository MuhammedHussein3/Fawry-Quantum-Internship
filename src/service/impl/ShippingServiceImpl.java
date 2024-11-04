package service.impl;

import entity.OrderItem;
import service.ShippingService;
import utility.ShippableAndExpirableProduct;
import utility.ShippableProduct;

import java.util.List;

public class ShippingServiceImpl implements ShippingService {

    private double totalWeight = 0.0d;
    @Override
    public double calculateShipping(List<OrderItem> items) {
        for (OrderItem orderItem : items){
             if (orderItem.product() instanceof ShippableProduct){
                 totalWeight += ((ShippableProduct)orderItem.product()).getWeight();
             }else if (orderItem.product() instanceof ShippableAndExpirableProduct)
                 totalWeight += ((ShippableAndExpirableProduct)orderItem.product()).getWeight();
        }
        return totalWeight;
    }
}
