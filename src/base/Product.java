//                                                      بسم الله الرحمن الرحيم                                                 //
// Program: Product.java
// Description: 
// Author: Abdallah Gasem
// Date: 05-07-2025
// Version: 1.0
/* File run command: javac Product.java; java Product */
// ----------------------------------------------------------------------------------------------------------------------------- //

package base;

public abstract class Product {

    // Data
    protected String name;
    protected Double qty;
    protected Double price;

    // Constructor
    public Product(String name, Double qty, Double price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Getters
    public String getPName() {
        return name;
    }

    public Double getQty() {
        return qty;
    }

    public Double getPrice() {
        return price;
    }

}

