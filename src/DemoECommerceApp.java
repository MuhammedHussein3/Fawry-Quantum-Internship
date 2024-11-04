import entity.Cart;
import entity.Customer;
import entity.Product;
import service.PaymentService;
import service.impl.PaymentServiceImpl;
import utility.ProductExpirationFactory;
import utility.ProductFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DemoECommerceApp {
    public static void main(String[] args) {

        Customer customer = new Customer("muhammad hussein",
                "muhammadhussein2312@gmail.com",
                new BigDecimal(100000));


        Product cheese = ProductExpirationFactory.createProduct("shippableAndExpire",
                "cheese",
                200,
                4,
                LocalDateTime.now(),
                200d,
                LocalDateTime.now().plusDays(30)
        );
        Product tv = ProductFactory.createProduct("shippable",
                "TV",
                2500,
                4, LocalDateTime.now(),
                7000d);
        Product scratchCard = ProductFactory.createProduct("nonShippable",
                "scratchCard",
                1000,
                4,
                LocalDateTime.now(), 0d);



        Cart cart = new Cart();
        assert cheese != null;
        cart.add(cheese, 3);
        assert tv != null;
        cart.add(tv, 2);
        assert scratchCard != null;
        cart.add(scratchCard, 2);


        PaymentService paymentService = new PaymentServiceImpl();
        paymentService.checkout(customer, cart);



    }
}