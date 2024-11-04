package service.impl;

import entity.Cart;
import entity.Customer;
import entity.OrderItem;
import entity.exception.InsufficientBalanceExceptionError;
import service.PaymentService;
import service.ShippingService;
import utility.ShippableAndExpirableProduct;
import utility.ShippableProduct;

import java.math.BigDecimal;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {


    @Override
    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is Empty");
            return;
        }

        double subtotal = cart.calculateSubtotal();
        final double shippingFees = 30;
        double totalAmount = subtotal + shippingFees;

        if (customer.getBalance().doubleValue() < totalAmount) {
           throw new InsufficientBalanceExceptionError(String.format("Insufficient balance for checkout : %s", customer.getBalance().doubleValue()));
        }

        for (OrderItem item : cart.getItems()){

            if (item.product().getQuantity() < 0){
                throw new RuntimeException("Not Found Enough Quantity");
            }
        }

        customer.deductBalance(new BigDecimal(totalAmount));

        List<OrderItem> shippableItems = cart.getShippableProduct();

        if (!shippableItems.isEmpty()) {
            ShippingService shippingService = new ShippingServiceImpl();
            shippingService.calculateShipping(shippableItems);
            System.out.println("** Shipment notice **");
            double totalWeight = 0;

            for (OrderItem item : shippableItems) {
                if (item.product() instanceof ShippableProduct){
                    System.out.printf("%dx %s\t%.0fg\n", item.quantity(), item.product().getName(), (item.quantity() * ((ShippableProduct)item.product()).getWeight()));
                    totalWeight += (item.quantity() * ((ShippableProduct)item.product()).getWeight());
                }else if (item.product() instanceof ShippableAndExpirableProduct){
                    System.out.printf("%dx %s\t%.0fg\n", item.quantity(), item.product().getName(), (item.quantity() * ((ShippableAndExpirableProduct)item.product()).getWeight()));
                    totalWeight += (item.quantity() * ((ShippableAndExpirableProduct)item.product()).getWeight());
                }

            }
                System.out.printf("Total package weight %.1fkg\n", totalWeight / 1000);
        }




        System.out.println("\n** Checkout receipt **");
        for (OrderItem item : cart.getItems()) {
            System.out.printf("%dx %s\t%.0f\n", item.quantity(), item.product().getName(), item.product().getPrice() * item.quantity());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal         %.0f\n", subtotal);
        System.out.printf("Shipping         %.0f\n", shippingFees);
        System.out.printf("Amount           %.0f\n", totalAmount);
        System.out.printf("Customer balance :  %.0f\n", customer.getBalance());

    }


}
