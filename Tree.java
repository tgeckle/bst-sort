/**
 * Filename: Tree.java
 * Author: Tea
 * Date: Sep 28, 2016
 * Purpose: 
 */
public class Tree<T> {
    private Node root;
    
    public void buildIntTree(String input) {
        char[] chars = input.toCharArray();
        int storedNum = 0;
        
        for (int i=0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                if ((i+1 != chars.length) && 
                        Character.isDigit(chars[i+1])) {
                    storedNum = storedNum * 10 + Character.getNumericValue(
                            chars[i]);
                }
                
                else {
                    storedNum = storedNum * 10 + Character.getNumericValue(
                            chars[i]);
                    if (root == null) {
                        root = new Node<>(new Integer(storedNum));
                    }
                    
                    else {
                        root.addToSubtree(new Integer(storedNum));
                    }
                    
                    storedNum = 0;
                }
                
            }
            
            else if (chars[i] == ' ') {
            }
            
            else {
                throw new NumberFormatException();
            }
        }
    }
    
    public void buildFracTree(String input) {
        char[] chars = input.toCharArray();
        boolean previousNum = false;
        int storedNum = -1;
        int numerator = -1;
        
        for (int i=0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                if (previousNum) {
                    storedNum = storedNum * 10 + Character.getNumericValue(chars[i]);
                }
                
                else {
                    storedNum = Character.getNumericValue(chars[i]);;
                }
                previousNum = true;
                
            }
            
            else if (chars[i] == '/') {
                if (numerator >= 0) {
                    System.out.println(numerator);
                    throw new NumberFormatException();
                }
                else {
                    numerator = storedNum;
                    storedNum = -1;
                }
                previousNum = false;
            }
            
            else if (chars[i] == ' ') {
                if (storedNum <= 0) {
                    throw new NumberFormatException();
                }
                else if (root == null) {
                    root = new Node<>(new Fraction(numerator, storedNum));
                    storedNum = -1;
                    numerator = -1;
                }
                
                else {
                    root.addToSubtree(new Fraction(numerator, 
                            storedNum));
                    storedNum = -1;
                    numerator = -1;
                }
                
                previousNum = false;
            }
            
            else {
                throw new NumberFormatException();
            }
        }
        
        if (storedNum > 0 && numerator >= 0) {
            if (root == null) {
                root = new Node<>(new Fraction(numerator, storedNum));
            }

            else {
                root.addToSubtree(new Fraction(numerator, 
                        storedNum));
            }
                
            }
        
    }
    
    public Node getRoot() {
        return root;
    }

}
