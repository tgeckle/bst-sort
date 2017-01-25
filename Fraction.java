/**
 * Filename: Fraction.java
 * Author: Tea
 * Date: Sep 28, 2016
 * Purpose: 
 */
public class Fraction implements Comparable<Fraction>{
    public int numerator;
    public int denominator; 
    
    public Fraction(int num, int den) {
        numerator = num;
        denominator = den;
    }
    
    public int compareTo(Fraction fraction) {
        double thisValue = new Double(numerator) / denominator;
        double otherValue = new Double(fraction.numerator) / fraction.denominator;
        
        if (otherValue > thisValue) {
            return -1;
        }
        else if (otherValue == thisValue) {
            return 0;
        }
        else {
            return 1;
        }
    }
    
    public String toString() {
        return numerator + "/" + denominator;
    }
}
