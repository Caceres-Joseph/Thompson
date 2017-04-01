/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Afd;

import Afn.Nodo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

  public class Estado {

        String nombre;
        Stack<Integer> eps = new Stack<>();
        ArrayList<Mueve> lstMueve = new ArrayList<>();

        public void insertarEpsilon(int numero) {
            Iterator< Integer> iterador = eps.iterator();
            boolean busqueda = false;//para no ingresar número repetidos
            while (iterador.hasNext()) {
                Integer a = iterador.next();
                if (a == numero) {
                    busqueda = true;
                }
            }
            if (!busqueda) {
                eps.push(numero);
            }

        }

        public void Mueve(String transicion, Nodo nod) {//aquí recibe el nodo

            if (lstMueve.isEmpty()) {//se inicializa la lista
                Mueve muv = new Mueve();
                muv.transicion = transicion;
//                muv.listNumeros.add(nod);
                muv.insert(nod);//agregando el sub-árbol a los mueve
                lstMueve.add(muv);
            } else {
                Iterator< Mueve> iterador = lstMueve.iterator();
                while (iterador.hasNext()) {
                    iterador.next();
                    if (!buscarTransicion(transicion, nod)) {//no lo encontró

                        Mueve muv = new Mueve();
                        muv.transicion = transicion;
//                        muv.listNumeros.add(nod);
                        muv.insert(nod);//se agrega el nodo-arbol a la lista del mueve
                        lstMueve.add(muv);
                        break;
                    } else {
                        break;
                    }
                }
            }

        }

        public boolean buscarTransicion(String transicion, Nodo nod) {
            boolean retorno = false;
            Iterator< Mueve> iterador = lstMueve.iterator();
            while (iterador.hasNext()) {
                Mueve elemento = iterador.next();
                if (elemento.transicion.equals(transicion)) {//lo encontró, aquí debe de ingresarlo
                    elemento.insert(nod);
                    //  elemento.listNumeros.push(numero);
                    //  lstMueve.get(i).list.add(numero);//debe de insertar en la lstMueve
                    retorno = true;
                    break;
                }
            }
            return retorno;
        }

        public void imprimirMueve1() {//se puede borrar

            Iterator<Mueve> iterador = lstMueve.iterator();
            while (iterador.hasNext()) {
                Mueve elemento = iterador.next();
                System.out.println(elemento.imprimir1());
            }
        }

        public void imprimirMueve() {

            Iterator<Mueve> iterador = lstMueve.iterator();
            while (iterador.hasNext()) {
                Mueve elemento = iterador.next();
                System.out.println(elemento.transicion + elemento.imprimir());
            }
        }

        public void imprimirCerradura() {
            String cadena = nombre + " -> ";
            while (!eps.isEmpty()) {
                cadena = cadena + "|" + eps.pop();
            }
            System.out.println(cadena);
        }
    }
