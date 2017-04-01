/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.util.Stack;


public class OrdenarPila {
  public  Stack<Integer> ordenar(Stack<Integer> s) {//ordenar pilas enteras de mayor a menor

        if (s.isEmpty()) {
            return s;
        }
        int pivot = s.pop();
        // partition
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        while (!s.isEmpty()) {
            int y = s.pop();
            if (y < pivot) {
                left.push(y);
            } else {
                right.push(y);
            }
        }
        ordenar(left);
        ordenar(right);

        // merge
        Stack<Integer> tmp = new Stack<>();
        while (!right.isEmpty()) {
            tmp.push(right.pop());
        }
        tmp.push(pivot);
        while (!left.isEmpty()) {
            tmp.push(left.pop());
        }
        while (!tmp.isEmpty()) {
            s.push(tmp.pop());
        }
        return s;
    }
   public <T> boolean CompararPila(Stack<T> a, Stack<T> b) {
        if (a.isEmpty() != b.isEmpty()) {
            return false;
        }
        if (a.isEmpty() && b.isEmpty()) {
            return true;
        }
        T element_a = a.pop();
        T element_b = b.pop();
        try {
            if (((element_a == null) && (element_b != null)) || (!element_a.equals(element_b))) {
                return false;
            }
            return CompararPila(a, b);
        } finally { // restore elements
            a.push(element_a);
            b.push(element_b);
        }
    }
}
