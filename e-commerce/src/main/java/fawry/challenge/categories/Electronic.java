//                                                      بسم الله الرحمن الرحيم                                                 //
// Program: Electronic.java
// Description: 
// Author: Abdallah Gasem
// Date: 05-07-2025
// Version: 1.0
/* File run command: javac Expirable.java; java Expirable */
//-------------------------------------------------------------------------------------------------------------------------------//
package fawry.challenge.categories;

import fawry.challenge.base.Product;
import fawry.challenge.interfaces.Shippable;

public class Electronic extends Product implements Shippable {

    // Data
    private Double weight;

    // constructor
    public Electronic(String name, Double qty, double price, double weight) {
        super(name, qty, price);
        this.weight = weight;
    }

    // setters
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    // shippable methods
    @Override
    public String getName() {
        return this.getPName();
    }

    @Override
    public Double getWeight() {
        return this.weight;
    }

}
