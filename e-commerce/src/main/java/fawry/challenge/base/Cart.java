//                                                      بسم الله الرحمن الرحيم                                                 //
// Program: Cart.java
// Description: 
// Author: Abdallah Gasem
// Date: 05-07-2025
// Version: 1.0
/* File run command: javac Cart.java; java Cart */
// ----------------------------------------------------------------------------------------------------------------------------- //
package fawry.challenge.base;

import java.util.ArrayList;

import fawry.challenge.helpers.Pair;
import fawry.challenge.interfaces.Expirable;

public class Cart {

    // Data
    private ArrayList<Pair<Double, Product>> items;

    // constructor
    public Cart() {
        this.items = new ArrayList<>();
    }

    // getter for the arraylist
    public ArrayList<Pair<Double, Product>> getitems() {
        return this.items;
    }

    public void emptyCart() {
        this.items.clear();
    }

    // add to cart - vvvimp. see of the item isexpired!
    public boolean add(Double qty, Product product) {
        System.out.println("add(" + qty + ", " + product.getPName() + ")");    // to see results in the console
        if (product.getQty() >= qty) {

            // is the item expired or not
            if (product instanceof Expirable) {
                Expirable ExpItem = (Expirable) product;
                if (ExpItem.isExpired()) {
                    System.err.println("Expired Item: " + product.getPName() + " removing from cart...");
                    return false;
                }
            }
            items.add(new Pair<>(qty, product));
            return true;

        }
        System.err.println("Unsufficient Quantity of product: " + product.getPName() + ",  " + product.getQty() + " Quantity availale!");
        return false;
    }

    // remove from cart
    public boolean remove(String pName) {
        System.out.println("remove(" + pName + ")");    // to see results in the console
        boolean removed = items.removeIf(pair -> pair.second.getPName().equals(pName));
        if (!removed) {
            System.out.println("Product with name '" + pName + "' not found in cart!");
        }
        return removed;
    }

    /* could be moved into a checkout service to achieve SRP!!? */
    // send the shippable to the ShippingService
    // calc quantities and price per each
    // check cust balance!
    // print notice review the PDF!
    // public void checkout(ShippingService service) {

    //     // if the cart is empty stop the operation
    //     if (this.items.isEmpty()) {
    //         System.err.println("ERROR: the Cart is Empty Cant checkout an Empty Cart!");
    //         return;
    //     }

    //     System.out.println("\n** Shipment Notice **\n");

    //     // pass the items to the shipService to see which is going to be shipped and calc the weights!
    //     Double shipping = service.ship(this.items);
    //     System.out.println("\n** Checkout Receipt **\n");

    //     // calc the cost of the order
    //     Double subTotal = 0.0;
    //     for (Pair<Double, Product> item : items) {

    //         subTotal = subTotal + (item.first * item.second.getPrice());
    //         System.out.println(item.first + "X " + item.second.getPName() + "\t\t" + (item.first * item.second.getPrice()));

    //     }

    //     System.out.println("-----------------------------------------------------");
    //     System.out.println("SubTotal: " + subTotal);
    //     System.out.println("Shipping: " + shipping);
    //     System.out.println("Amount: " + (shipping + subTotal));
    //     boolean paymentState = customer.pay((shipping + subTotal));
    //     if (paymentState) {
    //         items.clear();  // can keep history for tracking the orders! but skip for now
    //     } else {
    //         System.err.println("Mr\\Ms " + customer.getName() + " Please recharge or use different Payment method");
    //     }

    // }

}
