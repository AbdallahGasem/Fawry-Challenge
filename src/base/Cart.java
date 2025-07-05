//                                                      بسم الله الرحمن الرحيم                                                 //
// Program: Cart.java
// Description: 
// Author: Abdallah Gasem
// Date: 05-07-2025
// Version: 1.0
/* File run command: javac Cart.java; java Cart */
// ----------------------------------------------------------------------------------------------------------------------------- //
package base;

import helpers.Pair;
import java.util.ArrayList;

public class Cart {

    // Data
    private Customer customer; // high coupling but shar w labod mno! :(
    private ArrayList<Pair<Double, Product>> items;

    // constructor
    public Cart(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    // getter for the arraylist
    public ArrayList<Pair<Double, Product>> getitems() {
        return this.items;
    }

    // add to cart
    public boolean add(Double qty, Product product) {
        System.out.println("add(" + qty + ", " + product.getPName() + ")\n");    // to see results in the console
        if (product.getQty() >= qty) {
            items.add(new Pair<>(qty, product));
            return true;
        }
        System.out.println("Unsufficient Quantity of product: " + product.getPName() + ",  " + product.getQty() + " Quantity availale!");
        return false;
    }

    // remove from cart
    public boolean remove(String pName) {
        System.out.println("remove(" + pName + ")\n");    // to see results in the console
        boolean removed = items.removeIf(pair -> pair.second.getPName().equals(pName));
        if (!removed) {
            System.out.println("Product with name '" + pName + "' not found in cart!");
        }
        return removed;
    }

    /* could be moved into a checkout service to achieve with SRP!!? */
    // send the shippable to the ShippingService
    // calc quantities and price per each
    // check cust balance!
    // print notice review the PDF!
    public void checkout() {

        System.out.println("** Shipment Notice **\n");
        // pass the items to the shipService to see which is going to be shipped and calc the weights!
        // Double shipping = shipp() // returns the ship cost and total weights!
        System.out.println("** Checkout Receipt **\n");

        // calc the cost of the order
        Double subTotal = 0.0;
        for (Pair<Double, Product> item : items) {

            subTotal = subTotal + (item.first * item.second.getPrice());
            System.out.println(item.first + "X " + item.second.getPName() + "\t" + (item.first * item.second.getPrice()) + "\n");

        }
        System.out.println("-----------------------------------------------------");
        System.out.println("SubTotal: " + subTotal);
        // System.out.println("Shipping: " + );
        // System.out.println("Amount: " + (shipping + subTotal ));
        // boolean paymentState = customer.pay((shipping + subTotal ));
        // if (paymentState) {
        //     items.clear();  // can keep history for tracking the orders! but skip for now
        // }
        // else{
        //     System.out.println("Mr\Ms "+ customer.getName() + " Please recharge or use different Payment method");
        // }

    }

}
