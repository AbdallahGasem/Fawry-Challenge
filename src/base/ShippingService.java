//                                                      بسم الله الرحمن الرحيم                                                 //
// Program: ShippingService.java
// Description: 
// Author: Abdallah Gasem
// Date: 05-07-2025
// Version: 1.0
/* File run command: javac ShippingService.java; java ShippingService */
// ----------------------------------------------------------------------------------------------------------------------------- //
package base;

import helpers.Pair;
import interfaces.Shippable;
import java.util.ArrayList;

public class ShippingService {

    // Data
    private Double RatePerKilo;

    // constructor
    public ShippingService(Double RatePerKilo) {
        this.RatePerKilo = RatePerKilo;
    }

    // setter
    public void setRate(Double RatePerKilo) {
        this.RatePerKilo = RatePerKilo;
    }

    // getter
    public Double getRate() {
        return this.RatePerKilo;
    }

    // shipment logic
    public Double ship(ArrayList<Pair<Double, Product>> items) {

        Double totKilos = 0.0;

        for (Pair<Double, Product> item : items) {
            // filter the shippable items 
            if (item.second instanceof Shippable) {

                Shippable shipItem = (Shippable) item.second;
                totKilos += item.first * shipItem.getWeight();
                System.out.println(item.first + "X " + item.second.getPName() + "\t" + (item.first * shipItem.getWeight()));

            }

        }
        System.out.println("Total package weight " + totKilos + "kg");
        return totKilos * this.RatePerKilo;
    }
}
