//                                                      بسم الله الرحمن الرحيم                                                 //
// Program: CheckoutServiceTest.java
// Description: 
// Author: Abdallah Gasem
// Date: 05-07-2025
// Version: 1.0
/* File run command: javac CheckoutServiceTest.java; java CheckoutServiceTest */
// ----------------------------------------------------------------------------------------------------------------------------- //

package services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import fawry.challenge.base.Cart;
import fawry.challenge.base.Customer;
import fawry.challenge.services.CheckoutService;
import fawry.challenge.services.ShippingService;

public class CheckoutServiceTest {
    
    @Test
    public void testEmptyCart(){
        Cart cart = new Cart();
        ShippingService shippingService = new ShippingService(10.0);
        Customer customer = new Customer("Abdallah", 2000.0);

        boolean state = CheckoutService.checkout(shippingService, customer, cart);
        assertFalse(state);

    }
}
