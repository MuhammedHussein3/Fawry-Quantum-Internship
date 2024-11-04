package entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<OrderItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {

        if (product.getQuantity() < quantity) {
            System.out.println("Not found enough quantity for " + product.getName());
            return;
        }

        OrderItem orderItem = new OrderItem(product, quantity);
        items.add(orderItem);
        reduceQuantity(product, quantity);

    }

    private void reduceQuantity(Product product, int quantity){
        if (product.getQuantity() >= quantity) {
            product.setQuantity(product.getQuantity() - quantity);
        } else {
            throw new IllegalArgumentException("Not enough stock available.");
        }
    }


    public List<OrderItem> getItems() {
        return items;
    }


    public boolean isEmpty() {
        return items.isEmpty();
    }


    public double calculateSubtotal() {
        double subtotal = 0;
        for (OrderItem item : items) {
            subtotal += item.product().getPrice() * item.quantity();
        }
        return subtotal;
    }


    public List<OrderItem> getShippableProduct(){
        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItem orderItem : items){
            if (orderItem.product().isShipping()){
                orderItems.add(orderItem);
            }
        }
        return orderItems;
    }
}
