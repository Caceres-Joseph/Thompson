/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Afn.Nodo;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author joseph
 */
public class OperacionesAfn {
    Nodo raiz;
     Queue<Nodo> cola = new LinkedList<>();
    public OperacionesAfn(Nodo raiz){//recibe la raiz
        this.raiz= raiz;
    }
    public void anchura() {
        Nodo aux;
        if (raiz != null) {
            cola.add(raiz);//insertando la cabeza
            while (!cola.isEmpty()) {
                aux = cola.poll();
                System.out.println(aux.id);
                if (!(aux.izdo == null)) {
                    cola.add(aux.izdo);
                }
                if (!(aux.dcho == null)) {
                    cola.add(aux.dcho);
                }
            }
        }
    }

    public void LimpiarEnAnchura() {
        Nodo aux;
        if (raiz != null) {
            cola.add(raiz);//insertando la cabeza
            while (!cola.isEmpty()) {
                aux = cola.poll();
                aux.usada = false;
                if (!(aux.izdo == null)) {
                    cola.add(aux.izdo);
                }
                if (!(aux.dcho == null)) {
                    cola.add(aux.dcho);
                }
            }
        }
    }
}
