package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private int limit;
    private int balance;

    private Pincode pincode;

    @ManyToOne
    private Bank owningBank;

    public int getNumber() {
        return this.number;
    }

    public int getBalance() {
        return this.balance;
    }

    public int getLimit() {
        return this.limit;
    }

    public Pincode getPincode() {
        return this.pincode;
    }

    public Bank getOwningBank() {
        return this.owningBank;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }

    public void setOwningBank(Bank owningBank) {
        this.owningBank = owningBank;
    }
}
