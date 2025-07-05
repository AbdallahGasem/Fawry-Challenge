//                                                      بسم الله الرحمن الرحيم                                                 //
// Program: Customer.java
// Description: 
// Author: Abdallah Gasem
// Date: 05-07-2025
// Version: 1.0
/* File run command: javac Customer.java; java Customer */
// ----------------------------------------------------------------------------------------------------------------------------- //

package fawry.challenge.base;

public class Customer {

    // Data
    private String name;
    private Double balance;

    // constructor
    public Customer(String name, Double balance) {
        this.name = name;
        this.balance = balance;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    // getters
    public String getName() {
        return this.name;
    }

    public Double getBalance() {
        return this.balance;
    }

    // paying at checkout
    public boolean pay(Double amt) {
        if (this.balance >= amt) {
            this.balance = this.balance - amt;
            System.out.println("Transaction successfully Completed");
            System.out.println("current Balance for " + this.name + " is: " + this.balance);
            return true;
        }

        System.out.println("Transaction Failed! Not enough balance: " + this.balance);
        return false;
    }
}
