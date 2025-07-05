//                                                      بسم الله الرحمن الرحيم                                                 //
// Program: ShippingServiceTest.java
// Description: 
// Author: Abdallah Gasem
// Date: 05-07-2025
// Version: 1.0
/* File run command: javac ShippingServiceTest.java; java ShippingServiceTest */
// ----------------------------------------------------------------------------------------------------------------------------- //
package services;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import fawry.challenge.base.Product;
import fawry.challenge.categories.Electronic;
import fawry.challenge.categories.Other;
import fawry.challenge.helpers.Pair;
import fawry.challenge.services.ShippingService;

public class ShippingServiceTest {

    // testing the ship funcition
    
    @Test
    public void testShippingWithShippableProduct() {
        ShippingService service = new ShippingService(10.0);

        Electronic tv = new Electronic("TV", 5000.0, 2, 10.0); // 10kg per item
        Pair<Double, Product> pair = new Pair<>(2.0, tv);

        ArrayList<Pair<Double, Product>> items = new ArrayList<>();
        items.add(pair);

        double result = service.ship(items); // Should be 2 * 10 * 10 = 200

        assertEquals(200.0, result);
    }

    @Test
    public void testShippingWithNonShippableProduct() {
        ShippingService service = new ShippingService(10.0);

        Other scratchCard = new Other("Mobile Scratch Card", 10.0, 10);
        Pair<Double, Product> pair = new Pair<>(5.0, scratchCard);

        ArrayList<Pair<Double, Product>> items = new ArrayList<>();
        items.add(pair);

        double result = service.ship(items); // Should be 0.0

        assertEquals(0.0, result);
    }

    @Test
    public void testShippingWithZeroWeight() {
        ShippingService service = new ShippingService(10.0);

        Electronic fridge = new Electronic("Fridge", 8000.0, 1, 0.0); // 0 kg weight
        Pair<Double, Product> pair = new Pair<>(1.0, fridge);

        ArrayList<Pair<Double, Product>> items = new ArrayList<>();
        items.add(pair);

        double result = service.ship(items); // Should skip, so 0.0

        assertEquals(0.0, result);
    }

    @Test
    public void testShippingWithMixedProducts() {
        ShippingService service = new ShippingService(10.0);

        Electronic tv = new Electronic("TV", 5000.0, 2, 10.0); // Shippable
        Other scratchCard = new Other("Scratch", 5.0, 10);      // Not shippable

        ArrayList<Pair<Double, Product>> items = new ArrayList<>();
        items.add(new Pair<>(2.0, tv));         // 2 × 10kg = 20kg
        items.add(new Pair<>(3.0, scratchCard)); // Ignored

        double result = service.ship(items); // 20kg × 10 = 200

        assertEquals(200.0, result);
    }

    @Test
    public void testShippingWithEmptyList() {
        ShippingService service = new ShippingService(10.0);

        ArrayList<Pair<Double, Product>> items = new ArrayList<>();

        double result = service.ship(items);

        assertEquals(0.0, result);
    }

}
