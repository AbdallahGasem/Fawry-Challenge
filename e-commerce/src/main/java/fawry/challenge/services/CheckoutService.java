//                                                      بسم الله الرحمن الرحيم                                                 //
// Program: CheckoutService.java
// Description: 
// Author: Abdallah Gasem
// Date: 05-07-2025
// Version: 1.0
/* File run command: javac CheckoutService.java; java CheckoutService */
// ----------------------------------------------------------------------------------------------------------------------------- //
package fawry.challenge.services;

import java.util.ArrayList;

import fawry.challenge.base.Cart;
import fawry.challenge.base.Customer;
import fawry.challenge.base.Product;
import fawry.challenge.helpers.Pair;

public class CheckoutService {

    public static boolean checkout(ShippingService service, Customer customer, Cart cart) {

        ArrayList<Pair<Double, Product>> items = cart.getitems(); 
        // if the cart is empty stop the operation
        if (items.isEmpty()) {
            System.err.println("ERROR: the Cart is Empty Cant checkout an Empty Cart!");
            return false;
        }

        System.out.println("\n** Shipment Notice **\n");

        // pass the items to the shipService to see which is going to be shipped and calc the weights!
        Double shipping = service.ship(items);
        System.out.println("\n** Checkout Receipt **\n");

        // calc the cost of the order
        Double subTotal = 0.0;
        for (Pair<Double, Product> item : items) {

            subTotal = subTotal + (item.first * item.second.getPrice());
            System.out.println(item.first + "X " + item.second.getPName() + "\t\t" + (item.first * item.second.getPrice()));

        }

        System.out.println("-----------------------------------------------------");
        System.out.println("SubTotal: " + subTotal);
        System.out.println("Shipping: " + shipping);
        System.out.println("Amount: " + (shipping + subTotal));
        boolean paymentState = customer.pay((shipping + subTotal));
        if (paymentState) {
            items.clear();  // can keep history for tracking the orders! but skip for now
        } else {
            System.err.println("Mr\\Ms " + customer.getName() + " Please recharge or use different Payment method");
        }

        return true;

    }
}
