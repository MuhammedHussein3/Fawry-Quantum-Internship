package entity;

import java.math.BigDecimal;

public class Customer {

    private String name;
    private String email;
    private BigDecimal balance;

    public Customer(String name, String email, BigDecimal balance) {
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }
    public void deductBalance(BigDecimal amount) {
        this.balance = balance.subtract(amount);
    }
}
