//                                                      بسم الله الرحمن الرحيم                                                 //
// Program: CartTest.java
// Description: 
// Author: Abdallah Gasem
// Date: 05-07-2025
// Version: 1.0
/* File run command: javac CartTest.java; java CartTest */
// ----------------------------------------------------------------------------------------------------------------------------- //

package base;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import fawry.challenge.base.Cart;
import fawry.challenge.base.Product;
import fawry.challenge.categories.Electronic;

public class CartTest {
    // test add
    @Test
    public void testAddToCart(){
        // Product tv = new Electronic("tv", 7.0, 2500, 6.0);
        Cart cart = new Cart();
        // Product tablet = new Electronic("tablet", 2.0, 5000, 4.0);
        Product cheese = new Electronic("cheese", 3.5, 600, 0.250);
        boolean state = cart.add(1.0, cheese);
        assertTrue(state);
        
    }
    
    @Test
    public void testAddToCartWithUnsufficientQty(){
        Cart cart = new Cart();
        Product tv = new Electronic("tv", 0.0, 2500, 6.0);

        boolean state = cart.add(1.0, tv);
        assertFalse(state);
    }
    
    // test remove
    @Test
    public void testRemoveFromCartItemExist(){
        Cart cart = new Cart();
        Product tv = new Electronic("tv", 3.5, 600, 0.250);
        cart.add(1.0, tv);
        boolean state = cart.remove("tv");
        assertTrue(state);
    }

    @Test
    public void testRemoveFromCartItemNotExist(){
        Cart cart = new Cart();
        Product tv = new Electronic("tv", 3.5, 600, 0.250);
        cart.add(1.0, tv);
        boolean state = cart.remove("cheese");
        assertFalse(state);
    }
}
