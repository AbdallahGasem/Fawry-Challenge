//                                                      بسم الله الرحمن الرحيم                                                 //
// Program: CustomerTest.java
// Description: 
// Author: Abdallah Gasem
// Date: 05-07-2025
// Version: 1.0
/* File run command: javac CustomerTest.java; java CustomerTest */
// ----------------------------------------------------------------------------------------------------------------------------- //
package base;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import fawry.challenge.base.Customer;

public class CustomerTest {

    // testing pay function and unsufficent balance
    @Test
    public void testNormalPayScenarioWithSuffiecntFund() {
        Customer customer = new Customer("Abdallah", 2500.0);
        boolean state = customer.pay(2000.0);
        assertTrue(state);
    }

    @Test
    public void testPayWithUnsuffiecntFund() {
        Customer customer = new Customer("Abdallah", 2500.0);
        boolean state = customer.pay(4000.0);
        assertFalse(state);
    }

}
