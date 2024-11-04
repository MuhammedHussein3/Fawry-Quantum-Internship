package service;

import entity.Cart;
import entity.Customer;

public interface PaymentService {
      void checkout(Customer customer, Cart cart);
}
