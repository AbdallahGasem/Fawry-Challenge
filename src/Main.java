
//                                                      بسم الله الرحمن الرحيم                                                 //
// Program: Main.java
// Description: 
// Author: Abdallah Gasem
// Date: 05-07-2025
// Version: 1.0
/* File run command: javac Main.java; java Main */
// ----------------------------------------------------------------------------------------------------------------------------- //
import base.Cart;
import base.Customer;
import base.Product;
import base.ShippingService;
import categories.Edible;
import categories.Electronic;
import categories.Other;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, Fawry Challenge!");

        // Parse the expiry date string to a java.util.Date
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy");
        java.util.Date expiryDate = null;
        try {
            expiryDate = sdf.parse("2020");
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        /* setting products */
        Product cheese = new Edible("cheese", 5.5, 600, 0.250, expiryDate);
        Product chocobons = new Edible("chocobons", 26.0, 25, 0.100, expiryDate);
        Product samTv = new Electronic("SamsungTV", 3.0, 8000, 6.0);
        Product scratchCard = new Other("scratchCard", 100.0, 3);

        /* setting a Customer */
        Customer customer = new Customer("Abdallah Gasem", 5000.0);

        /* setting a shipping service */
        ShippingService shippingService = new ShippingService(5.0);

        /* setting a cart */
        Cart cart = new Cart(customer);

        // 1- add the Products to the cart
        cart.add(1.0, samTv);
        cart.add(1.0, chocobons);
        cart.add(2.0, cheese);
        cart.add(2.0, scratchCard);

        // 2- remove the cheese from the cart
        cart.remove("cheese");

        // 3- proceed to checkout
        cart.checkout(shippingService);

    }
}
