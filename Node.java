import java.util.*;

/**
 * Filename: Node.java
 * Author: Tea
 * Date: Sep 28, 2016
 * Purpose: 
 */
public class Node<T extends Comparable> {
    private Node<T> parent;
    private Node<T> lChild;
    private Node<T> rChild;
    private T value;
    
    public Node(T value){
        this.value = value;
    }
    
    public Node() {
        parent = null;
        value = null;
    }
    
    public Node(T value, Node parent) {
        this.value = value;
        this.parent = parent;
    }
    
    public void addToSubtree(T newValue) {
        if (newValue.compareTo(value) <= 0) {
            if (getLChild() == null) {
                setLChild(new Node<T>(newValue, this));
            }
            
            else {
                getLChild().addToSubtree(newValue);
            }
        }
        
        else {
            if (getRChild() == null) {
                setRChild(new Node<T>(newValue, this));
            }
            
            else {
                getRChild().addToSubtree(newValue);
            }
        }
    }
    
    public Node<T> getParent() {
        return parent;
    }
    
    public T getValue() {
        return value;
    }
    
    public Node getLChild() {
        return lChild;
    }
    
    public Node getRChild() {
        return rChild;
    }
    
    public ArrayList <Node> getChildren() {
        ArrayList childList = new ArrayList();
        if (getRChild() != null) {
            childList.add(getRChild());
        }
        if (getLChild() != null) {
            childList.add(getLChild());
        }
        
        return childList;
    }
    
    public boolean hasChildren() {
        return (getLChild() != null || getRChild() != null);
    }
    
    public String inOrder() {
        String result = "";
        if (!hasChildren()) {
            result += toString();
        }
        
        else if (getLChild() == null) {
            result += toString() + " ";
            result += getRChild().inOrder();
        }
        
        else if (getRChild() == null) {
            result += getLChild().inOrder() + " ";
            result += toString();
        }
        
        else {
            result += getLChild().inOrder() + " ";
            result += toString() + " ";
            result += getRChild().inOrder();
        }
        
        return result;
    }
    public String reverseOrder() {
        String result = "";
        if (!hasChildren()) {
            result += toString();
        }
        
        else if (getLChild() == null) {
            result += getRChild().reverseOrder() + " ";
            result += toString();
        }
        
        else if (getRChild() == null) {
            result += toString() + " ";
            result += getLChild().reverseOrder();
        }
        
        else {
            result += getRChild().reverseOrder() + " ";
            result += toString() + " ";
            result += getLChild().reverseOrder();
        }
        
        return result;
    }
    
    public void setParent(Node<T> newParent) {
        parent = newParent;
    }
    
    public void setValue(T newValue) {
        value = newValue;
    }
    
    public void setLChild(Node child) {
        lChild = child;
    }
    
    public void setRChild(Node child) {
        rChild = child;
    }
    
    public String toString() {
        return value.toString();
    }
    
}
