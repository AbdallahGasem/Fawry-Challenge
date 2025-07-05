//                                                      بسم الله الرحمن الرحيم                                                 //
// Program: Edible.java
// Description: 
// Author: Abdallah Gasem
// Date: 05-07-2025
// Version: 1.0
/* File run command: javac Edible.java; java Edible */
// ----------------------------------------------------------------------------------------------------------------------------- //
package categories;

import base.Product;
import interfaces.Expirable;
import interfaces.Shippable;
import java.util.Date;

public class Edible extends Product implements Shippable, Expirable {

    // Data
    private Double weight;
    private Date ExpDate;

    // constructor
    public Edible(String name, Double qty, double price, double weight, Date ExpDate) {
        super(name, qty, price);
        this.weight = weight;
        this.ExpDate = ExpDate;
    }

    // setters
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setExpDate(Date ExpDate) {
        this.ExpDate = ExpDate;
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

    // Expirable methods
    @Override
    public Boolean isExpired() {
        return new Date().after(this.ExpDate);
    }

    @Override
    public Date getExpiredDate() {
        return this.ExpDate;
    }

}
