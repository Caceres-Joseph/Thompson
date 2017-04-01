/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Afn;

import java.util.ArrayList;

public class Operadores {
 public String cadenaGraphivz = "";
    public ArrayList<Nodo> Interrogacion(int inicial, String a) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo nodo1 = new Nodo(inicial);
        Nodo nodo2 = new Nodo(inicial + 1, "ε");
        Nodo nodo3 = new Nodo(inicial + 2, a);
        Nodo nodo4 = new Nodo(inicial + 3, "ε");
        Nodo nodo5 = new Nodo(inicial + 3, "ε");

        nodo1.izdo = nodo2;
        grafoAfn(nodo1, nodo2);
        nodo1.dcho = nodo5;
        grafoAfn(nodo1, nodo5);

        nodo2.izdo = nodo3;
        grafoAfn(nodo2, nodo3);

        nodo3.izdo = nodo4;
        grafoAfn(nodo3, nodo4);

        listaNodos.add(nodo1);
        listaNodos.add(nodo4);

        return listaNodos;
    }

    public ArrayList<Nodo> Interrogacion(int inicial, ArrayList<Nodo> list_a) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo nodo1 = new Nodo(inicial);
        Nodo nodo2 = list_a.get(0);
        nodo2.transicion = "ε";
        Nodo nodo3 = list_a.get(1);
        Nodo nodo4 = new Nodo(inicial + 1, "ε");
        Nodo nodo5 = new Nodo(inicial + 1, "ε");

        nodo1.izdo = nodo2;
        grafoAfn(nodo1, nodo2);
        nodo1.dcho = nodo5;
        grafoAfn(nodo1, nodo5);

        nodo3.izdo = nodo4;
        grafoAfn(nodo3, nodo4);

        listaNodos.add(nodo1);
        listaNodos.add(nodo4);

        return listaNodos;
    }

    public ArrayList<Nodo> Mas(int inicial, String a) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo nodo1 = new Nodo(inicial);
        Nodo nodo2 = new Nodo(inicial + 1, "ε");
        Nodo nodo3 = new Nodo(inicial + 2, a);
        Nodo nodo4 = new Nodo(inicial + 3, "ε");

        Nodo nodo6 = new Nodo(inicial + 1, "ε");

        nodo1.izdo = nodo2;
        grafoAfn(nodo1, nodo2);

        nodo2.izdo = nodo3;
        grafoAfn(nodo2, nodo3);

        nodo3.izdo = nodo4;
        grafoAfn(nodo3, nodo4);
        nodo3.dcho = nodo6;
        grafoAfn(nodo3, nodo6);

        listaNodos.add(nodo1);
        listaNodos.add(nodo4);

        return listaNodos;
    }

    public ArrayList<Nodo> Mas(int inicial, ArrayList<Nodo> list_a) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo nodo1 = new Nodo(inicial);
        Nodo nodo2 = list_a.get(0);
        nodo2.transicion = "ε";
        Nodo nodo3 = list_a.get(1);
        Nodo nodo4 = new Nodo(inicial + 1, "ε");
        Nodo nodo6 = new Nodo(nodo2.id, "ε");

        nodo1.izdo = nodo2;
        grafoAfn(nodo1, nodo2);

        nodo3.izdo = nodo4;
        grafoAfn(nodo3, nodo4);
        nodo3.dcho = nodo6;
        grafoAfn(nodo3, nodo6);

        listaNodos.add(nodo1);
        listaNodos.add(nodo4);

        return listaNodos;
    }

    public ArrayList<Nodo> Asterisco(int inicial, ArrayList<Nodo> list_a) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo nodo1 = new Nodo(inicial);
        Nodo nodo2 = list_a.get(0);
        nodo2.transicion = "ε";
        Nodo nodo3 = list_a.get(1);
        Nodo nodo4 = new Nodo(inicial + 1, "ε");
        Nodo nodo5 = new Nodo(inicial + 1, "ε");
        Nodo nodo6 = new Nodo(nodo2.id, "ε");
//"ε"
        nodo1.izdo = nodo2;
        grafoAfn(nodo1, nodo2);
        nodo1.dcho = nodo5;
        grafoAfn(nodo1, nodo5);

        nodo3.izdo = nodo4;
        grafoAfn(nodo3, nodo4);
        nodo3.dcho = nodo6;
        grafoAfn(nodo3, nodo6);

        listaNodos.add(nodo1);
        listaNodos.add(nodo4);

        return listaNodos;
    }

    public ArrayList<Nodo> Asterisco(int inicial, String a) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo nodo1 = new Nodo(inicial);
        Nodo nodo2 = new Nodo(inicial + 1, "ε");
        Nodo nodo3 = new Nodo(inicial + 2, a);
        Nodo nodo4 = new Nodo(inicial + 3, "ε");
        Nodo nodo5 = new Nodo(inicial + 3, "ε");
        Nodo nodo6 = new Nodo(inicial + 1, "ε");

        nodo1.izdo = nodo2;
        grafoAfn(nodo1, nodo2);
        nodo1.dcho = nodo5;
        grafoAfn(nodo1, nodo5);

        nodo2.izdo = nodo3;
        grafoAfn(nodo2, nodo3);

        nodo3.izdo = nodo4;
        grafoAfn(nodo3, nodo4);
        nodo3.dcho = nodo6;
        grafoAfn(nodo3, nodo6);

        listaNodos.add(nodo1);
        listaNodos.add(nodo4);

        return listaNodos;
    }

    public ArrayList<Nodo> Punto(int inicial, String a, String b) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo cabezaOr;

        Nodo nodo1 = new Nodo(inicial);
        Nodo nodo2 = new Nodo(inicial + 1, a);
        Nodo nodo3 = new Nodo(inicial + 2, b);

        cabezaOr = nodo1;

        cabezaOr.izdo = nodo2;
        grafoAfn(cabezaOr, nodo2);
        nodo2.izdo = nodo3;
        grafoAfn(nodo2, nodo3);

        listaNodos.add(cabezaOr);
        listaNodos.add(nodo3);

        return listaNodos;
    }

    public ArrayList<Nodo> Punto(int inicial, ArrayList<Nodo> list, String b) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo cabezaOr;

        Nodo nodo1 = list.get(0);
        Nodo nodo2 = list.get(1);
        Nodo nodo3 = new Nodo(inicial, b);

        cabezaOr = nodo1;
        nodo2.izdo = nodo3;
        grafoAfn(nodo2, nodo3);

        listaNodos.add(cabezaOr);
        listaNodos.add(nodo3);

        return listaNodos;
    }

    public ArrayList<Nodo> Punto(int inicial, String b, ArrayList<Nodo> list) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo cabezaOr;

        Nodo nodo2 = list.get(0);
        nodo2.transicion = b;
        Nodo nodo3 = list.get(1);
        Nodo nodo1 = new Nodo(inicial, null);

        cabezaOr = nodo1;
        nodo1.izdo = nodo2;

        grafoAfn(nodo1, nodo2);

        listaNodos.add(cabezaOr);
        listaNodos.add(nodo3);

        return listaNodos;
    }

    public ArrayList<Nodo> Punto(int inicial, ArrayList<Nodo> list_a, ArrayList<Nodo> list_b) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo nodo1 = list_a.get(0);

        Nodo nodo2 = list_a.get(1);
        Nodo nodo3 = list_b.get(0);
        nodo3.transicion = "ε";
        Nodo nodo4 = list_b.get(1);

        nodo2.izdo = nodo3;
        grafoAfn(nodo2, nodo3);

        listaNodos.add(nodo1);
        listaNodos.add(nodo4);
        return listaNodos;
    }

    public ArrayList<Nodo> Or(int inicial, String a, String b) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();
        Nodo cabezaOr;

        Nodo nodo1 = new Nodo(inicial);
        Nodo nodo2 = new Nodo(inicial + 1, "ε");
        Nodo nodo3 = new Nodo(inicial + 2, "ε");
        Nodo nodo4 = new Nodo(inicial + 3, a);
        Nodo nodo5 = new Nodo(inicial + 4, b);
        Nodo nodo6 = new Nodo(inicial + 5, "ε");
        Nodo nodo7 = new Nodo(inicial + 5, "ε");

        cabezaOr = nodo1;

        cabezaOr.izdo = nodo2;
        grafoAfn(cabezaOr, nodo2);

        nodo2.izdo = nodo4;
        grafoAfn(nodo2, nodo4);

        nodo4.izdo = nodo6;
        grafoAfn(nodo4, nodo6);

        cabezaOr.dcho = nodo3;
        grafoAfn(cabezaOr, nodo3);

        nodo3.izdo = nodo5;
        grafoAfn(nodo3, nodo5);

        nodo5.izdo = nodo7;
        grafoAfn(nodo5, nodo7);

        listaNodos.add(cabezaOr);
        listaNodos.add(nodo6);

        return listaNodos;
    }

    public ArrayList<Nodo> Or(int inicial, ArrayList<Nodo> list, String b) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo cabezaOr;

        Nodo nodo1 = new Nodo(inicial);
        Nodo nodo2 = list.get(0);
        nodo2.transicion = "ε";
        Nodo nodo3 = new Nodo(inicial + 1, "ε");
        Nodo nodo4 = list.get(1);
        Nodo nodo5 = new Nodo(inicial + 2, b);
        Nodo nodo6 = new Nodo(inicial + 3, "ε");
        Nodo nodo7 = new Nodo(inicial + 3, "ε");

        cabezaOr = nodo1;

        cabezaOr.izdo = nodo2;
        grafoAfn(cabezaOr, nodo2);

        nodo4.izdo = nodo6;
        grafoAfn(nodo4, nodo6);

        cabezaOr.dcho = nodo3;
        grafoAfn(cabezaOr, nodo3);
        nodo3.izdo = nodo5;
        grafoAfn(nodo3, nodo5);
        nodo5.izdo = nodo7;
        grafoAfn(nodo5, nodo7);

        listaNodos.add(cabezaOr);
        listaNodos.add(nodo6);

        return listaNodos;
    }

    public ArrayList<Nodo> Or(int inicial, ArrayList<Nodo> list_a, ArrayList<Nodo> list_b) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo cabezaOr;
        Nodo nodo1 = new Nodo(inicial);
        Nodo nodo2 = list_a.get(0);
        nodo2.transicion = "ε";
        Nodo nodo3 = list_b.get(0);
        nodo3.transicion = "ε";

        Nodo nodo4 = list_a.get(1);
        Nodo nodo5 = list_b.get(1);

        Nodo nodo6 = new Nodo(inicial + 1, "ε");
        Nodo nodo7 = new Nodo(inicial + 1, "ε");

        cabezaOr = nodo1;

        cabezaOr.dcho = nodo3;
        grafoAfn(cabezaOr, nodo3);
        cabezaOr.izdo = nodo2;
        grafoAfn(cabezaOr, nodo2);

        nodo4.izdo = nodo6;
        grafoAfn(nodo4, nodo6);
        nodo5.izdo = nodo7;
        grafoAfn(nodo5, nodo7);

        listaNodos.add(cabezaOr);
        listaNodos.add(nodo6);

        return listaNodos;
    }
   

    public void grafoAfn(Nodo a, Nodo b) {
        cadenaGraphivz = cadenaGraphivz + String.valueOf(a.id) + " -> " + String.valueOf(b.id) + " [label=\"" + b.transicion + "\"];\n";

    }
}
