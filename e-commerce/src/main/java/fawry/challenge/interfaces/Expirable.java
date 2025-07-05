//                                                      بسم الله الرحمن الرحيم                                                 //
// Program: Expirable.java
// Description: 
// Author: Abdallah Gasem
// Date: 05-07-2025
// Version: 1.0
/* File run command: javac Expirable.java; java Expirable */
// ----------------------------------------------------------------------------------------------------------------------------- //
package fawry.challenge.interfaces;

import java.util.Date;

public interface Expirable {

    public Boolean isExpired();

    public Date getExpiredDate();
}
