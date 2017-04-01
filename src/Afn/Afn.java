/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Afn;

import java.util.ArrayList;
import java.util.Stack;

public class Afn {

    Nodo cabeza;
    ArrayList<Nodo> aux;//nodo temporal
    public Stack<ArrayList<Nodo>> pila = new Stack<>();//Sirve para armar el arbol
    int indice = 1;//el id de cada nodo
    public Operadores operador=new Operadores();

    public void hacerGrafo(String token_a, String token_b, String operacion) {

        String primer_a = token_a.substring(0, 1);
        String primer_b = token_b.substring(0, 1);

        switch (operacion) {
            case "And":
                if (!primer_a.equals("(") && !primer_b.equals("(")) {
                    aux = operador.Punto(indice, token_a, token_b);
                    pila.push(aux);
                    indice = aux.get(1).id + 1;
                } else if (primer_a.equals("(") && !primer_b.equals("(")) {
                    aux = operador.Punto(indice, pila.pop(), token_b);
                    pila.push(aux);
                    indice = aux.get(1).id + 1;
                } else if (!primer_a.equals("(") && primer_b.equals("(")) {
//                    aux = And_1(indice, pila.pop(), token_a);
                    aux = operador.Punto(indice, token_a, pila.pop());
                    pila.push(aux);
                    indice = aux.get(1).id + 1;
                } else if (primer_a.equals("(") && primer_b.equals("(")) {
                    ArrayList<Nodo> primero = pila.pop();
                    ArrayList<Nodo> segundo = pila.pop();

                    aux = operador.Punto(indice, segundo, primero);
                    pila.push(aux);
                    indice = aux.get(1).id + 1;
                }
                break;
            case "Or":
                if (!primer_a.equals("(") && !primer_b.equals("(")) {
                    aux = operador.Or(indice, token_a, token_b);
                    pila.push(aux);
                    indice = aux.get(1).id + 1;
                } else if (primer_a.equals("(") && !primer_b.equals("(")) {
                    aux = operador.Or(indice, pila.pop(), token_b);
                    pila.push(aux);
                    indice = aux.get(1).id + 1;
                } else if (!primer_a.equals("(") && primer_b.equals("(")) {
                    aux = operador.Or(indice, pila.pop(), token_a);
                    pila.push(aux);
                    indice = aux.get(1).id + 1;
                } else if (primer_a.equals("(") && primer_b.equals("(")) {
                    aux = operador.Or(indice, pila.pop(), pila.pop());
                    pila.push(aux);
                    indice = aux.get(1).id + 1;
                }
                break;
            case "Aster":
                if (!primer_a.equals("(")) {
                    aux = operador.Asterisco(indice, token_a);
                    pila.push(aux);
                    indice = aux.get(1).id + 1;
                } else if (primer_a.equals("(")) {
                    aux = operador.Asterisco(indice, pila.pop());
//                    Limpiar();
                    pila.push(aux);
                    indice = aux.get(1).id + 1;
                }
                break;
            case "Interrog":
                if (!primer_a.equals("(")) {
                    aux = operador.Interrogacion(indice, token_a);
                    pila.push(aux);
                    indice = aux.get(1).id + 1;
                } else if (primer_a.equals("(")) {
                    aux = operador.Interrogacion(indice, pila.pop());
                    pila.push(aux);
                    indice = aux.get(1).id + 1;
                }
                break;
            case "Mas":
                if (!primer_a.equals("(")) {
                    aux = operador.Mas(indice, token_a);
                    pila.push(aux);
                    indice = aux.get(1).id + 1;
                } else if (primer_a.equals("(")) {
                    aux = operador.Mas(indice, pila.pop());
                    pila.push(aux);
                    indice = aux.get(1).id + 1;
                }
                break;
            default:
                break;
        }
    }

}
