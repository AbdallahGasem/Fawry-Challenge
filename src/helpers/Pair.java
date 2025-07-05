//                                                      بسم الله الرحمن الرحيم                                                 //
// Program: Pair.java
// Description: 
// Author: Abdallah Gasem
// Date: 05-07-2025
// Version: 1.0
/* File run command: javac Pair.java; java Pair */
// ----------------------------------------------------------------------------------------------------------------------------- //

package helpers;

// implementing the pair DS as in CPP! it represents a pair of quantity & product
public class Pair<K, V> {

    public K first;
    public V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

}
