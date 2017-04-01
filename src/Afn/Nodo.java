/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Afn;


public class Nodo {
    
    public int id;
    public String transicion;
    public Nodo dcho;
    public Nodo izdo;
    public boolean usada;

    public Nodo(int id, String transicion) {
        this.id = id;
        this.transicion = transicion;
    }

    public Nodo(int id) {
        this.id = id;
    }

    public Nodo(String transicion) {
        this.transicion = transicion;
    }

    public Nodo() {

    }
}
