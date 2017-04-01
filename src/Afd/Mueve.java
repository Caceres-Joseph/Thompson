/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Afd;

import Afn.Nodo;
import java.util.Iterator;
import java.util.Stack;

public class Mueve {

    String transicion;
    String estado;
    Stack<Nodo> listNum = new Stack<>();

    public String imprimir() {
        String retorno = "\"" + estado + "\"" + "[label =" + "\"" + transicion + "\"];";
        return retorno;
    }

    public String imprimir1() {//se puede eliminar
        String retorno = transicion + " -> ";
        Iterator<Nodo> iterador = listNum.iterator();

        while (iterador.hasNext()) {
            retorno = retorno + " | " + iterador.next().id;
            iterador.next();
        }
        return retorno;
    }

    public void insert(Nodo nodoNuevo) {
        Iterator<Nodo> iterador = listNum.iterator();
        boolean busqueda = false;//para no ingresar número repetidos
        while (iterador.hasNext()) {
            Integer a = iterador.next().id;
            if (a == nodoNuevo.id) {
                busqueda = true;
            }
        }
        if (!busqueda) {
            listNum.push(nodoNuevo);
        }
    }
}
