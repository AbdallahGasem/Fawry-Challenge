//                                                      بسم الله الرحمن الرحيم                                                 //
// Program: Main.java
// Description: 
// Author: Abdallah Gasem
// Date: 05-07-2025
// Version: 1.0
/* File run command: javac Main.java; java Main */
// ----------------------------------------------------------------------------------------------------------------------------- //
package fawry.challenge;
import fawry.challenge.base.Cart;
import fawry.challenge.base.Customer;
import fawry.challenge.base.Product;
import fawry.challenge.categories.Edible;
import fawry.challenge.categories.Electronic;
import fawry.challenge.categories.Other;
import fawry.challenge.services.CheckoutService;
import fawry.challenge.services.ShippingService;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, Fawry Challenge!\n");

        // Parse the expiry date string to a java.util.Date
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy");
        java.util.Date expiryDate = null;
        java.util.Date expiryDate2 = null;
        try {
            expiryDate = sdf.parse("2026");
            expiryDate2 = sdf.parse("2020");
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        // ----------------------------------------------------[Normal scenario]--------------------------------------------------//
        System.out.println("\n Normal scenario: \n");
        /* setting products */
        Product cheese = new Edible("cheese", 5.5, 600, 0.250, expiryDate);
        Product chocobons = new Edible("chocobons", 26.0, 25, 0.100, expiryDate);
        Product samTv = new Electronic("SamsungTV", 3.0, 8000, 6.0);
        Product scratchCard = new Other("scratchCard", 100.0, 3);

        /* setting a Customer */
        Customer customer = new Customer("Abdallah Gasem", 25000.0);

        /* setting a shipping service and a Checkout service*/
        ShippingService shippingService = new ShippingService(5.0);

        /* setting a cart */
        Cart cart = new Cart();

        // 1- add the Products to the cart
        cart.add(1.0, samTv);
        cart.add(1.0, chocobons);
        cart.add(2.0, cheese);
        cart.add(2.0, scratchCard);

        // 2- remove the cheese from the cart
        cart.remove("cheese");

        // 3- proceed to checkout
        CheckoutService.checkout(shippingService, customer, cart);
        
        // ------------------------------------------------[No sufficient Balance]-----------------------------------------------//
        System.out.println("\n No sufficient Balance: \n");
        Customer customer2 = new Customer("Wagdy", 250.0);
        Cart cart2 = new Cart();
        cart2.add(1.0, samTv);
        cart2.add(1.0, cheese);
        CheckoutService.checkout(shippingService, customer2, cart2);

        // -----------------------------------------------------[ُEmpty Cart]-----------------------------------------------------//
        System.out.println("\n Empty Cart: \n");
        Cart cart3 = new Cart();
        CheckoutService.checkout(shippingService, customer, cart3);

        // ----------------------------------------------------[ُExpired Item]----------------------------------------------------//
        System.out.println("\n Expired Item: \n");
        Product bigCola = new Edible("bigCola", 24.0, 15, 0.200, expiryDate2);
        cart3.add(1.0, bigCola);
        cart3.add(1.0, chocobons);
        CheckoutService.checkout(shippingService, customer, cart3);

        // ----------------------------------------------------[ُout of stock]----------------------------------------------------//
        System.out.println("\n out of stock: \n");
        cart3.emptyCart();
        Product scratchFawryCard = new Other("scratchFawryCard", 0.0, 28);
        cart3.add(2.0, scratchFawryCard);
        cart3.add(1.0, chocobons);
        CheckoutService.checkout(shippingService, customer, cart3);

        // ----------------------------------------------[ُShippable of weight Zero]-----------------------------------------------//
        System.out.println("\n Shippable of weight Zero: \n");
        cart3.emptyCart();
        Product test = new Electronic("test", 25.0, 100, 0);
        cart3.add(1.0, test);
        cart3.add(1.0, samTv);
        cart3.add(1.0, chocobons);
        CheckoutService.checkout(shippingService, customer, cart3);

        // -------------------------------------------------[ُNothing is Shippable]------------------------------------------------//
        System.out.println("\n Nothing is Shippable: \n");
        cart3.emptyCart();
        Product p1 = new Other("p1", 5.0, 28);
        Product p2 = new Other("p2", 5.0, 250);
        Product p3 = new Other("p3", 5.0, 250);
        cart3.add(1.0, p1);
        cart3.add(1.0, p2);
        cart3.add(1.0, p3);
        CheckoutService.checkout(shippingService, customer, cart3);
    }
}
