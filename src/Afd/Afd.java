/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Afd;

import Afn.Nodo;
import Metodos.OrdenarPila;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author joseph
 */
public final class Afd {

    OrdenarPila operacionPila = new OrdenarPila();
    Nodo raiz;
    Queue<Nodo> cola = new LinkedList<>();
    ArrayList<String> listaDeEstadosDeAceptacion = new ArrayList<>();
    public ArrayList<Cerradura> listaCerraduras = new ArrayList<>();
    ArrayList<Estado> listaDeEstados = new ArrayList<>();
    int contadorDeEstados = 1;

    public Afd(ArrayList<Nodo> raize) {
        this.raiz = raize.get(0);
        Estado So = new Estado();
        So.nombre = "S0";
        HacerCerradura(raiz, So);
        So.eps = operacionPila.ordenar(So.eps); //ordena
        LimpiarEnAnchura();
        recorrerTrue(So);
        estadosDeAceptacion();
    }

    public void recorrerTrue(Estado estdo) {//este estado ya tiene que venir con cerraduras
        Cerradura cerr = new Cerradura();
        cerr.estado = estdo.nombre;
        cerr.num = estdo.eps;
        listaCerraduras.add(cerr);
        listaDeEstados.add(estdo);
        Iterator<Mueve> itMuv = estdo.lstMueve.iterator(); //recorriendo los mueve, para hacer mas estados, o cerraduras
        while (itMuv.hasNext()) {//aquí creo los estados nuevos//primer mueve
            Mueve muv = itMuv.next();//avanzo con cada mueve
            Estado estd = retornoEstado(muv);//el nuevo estado
            if (estd != null) {//vuelve a recorrer el estado
                Iterator<Nodo> itNodo = muv.listNum.iterator();//recorriendo los nodos del muevee
                //aquí limpio
                while (itNodo.hasNext()) {
                    Nodo nod = itNodo.next();

                    HacerCerradura(nod, estd);
                    estd.eps = operacionPila.ordenar(estd.eps);
                }
                LimpiarEnAnchura();
                contadorDeEstados++;//incrementamos el contador de esatados;
                recorrerTrue(estd);

            }
            String dot = "";
            dot = "\"" + estdo.nombre + "\" -> " + muv.imprimir();
            System.out.println(dot);
        }
    }

    public Estado retornoEstado(Mueve mueve) {//aqui le pongo a donde va el muv
        Estado retorno = null;
        Iterator<Nodo> itNodo = mueve.listNum.iterator();//recorriendo los nodos del muevee
        Estado estadoPrueba = new Estado();
        while (itNodo.hasNext()) {//lista de subarboles
            Nodo nod = itNodo.next();
            HacerCerradura(nod, estadoPrueba);
            LimpiarEnAnchura();
        }
        estadoPrueba.eps = operacionPila.ordenar(estadoPrueba.eps);

        if (estadoPrueba.eps != null) {
            boolean loEncontro = false;
            Iterator<Cerradura> iter = listaCerraduras.iterator();
            while (iter.hasNext()) {
                Cerradura cer = iter.next();
                Stack<Integer> temp = cer.num;

                if (operacionPila.CompararPila(temp, estadoPrueba.eps)) {
                    loEncontro = true;
                    mueve.estado = cer.estado;
                    break;
                }
            }
            if (loEncontro) {

                retorno = null;

            } else {//aquí hay que crear un nuevo estado
                Estado nuevoEstado = new Estado();
                nuevoEstado.nombre = "S" + String.valueOf(contadorDeEstados);
                mueve.estado = "S" + String.valueOf(contadorDeEstados);
                retorno = nuevoEstado;
            }

        }

        return retorno;
    }

    public void HacerCerradura(Nodo nodo, Estado estado) {
        Nodo aux;
        if (nodo != null) {
            Queue<Nodo> cola = new LinkedList<>();
            cola.add(nodo);//insertando la cabeza a una coola
            while (!cola.isEmpty()) {//recorre en anchura
                aux = cola.poll();//saca de la cola
                estado.insertarEpsilon(aux.id);//lo meto a la pila de epsilon del estado

                if (aux.izdo == null && aux.dcho == null && aux.usada == false) {//este nodo es el último
                    aux.usada = true;//bandera para no volver a recorrerlo
                    Nodo temporal = buscar(aux.id);//hace la búsqueda

                    if (temporal == null) {//no lo encontró

                    } else if (temporal.transicion.equals("ε")) {

                        HacerCerradura(temporal, estado);

                    }
                } else {
                    if (!(aux.izdo == null)) {//para las hojas izquierdas
                        if (aux.izdo.transicion.equals("ε")) {
                            cola.add(aux.izdo);
                        } else {
                            estado.Mueve(aux.izdo.transicion, aux.izdo);//ingresando a los mueve del estado en nodo completo
                        }
                    }
                    if (!(aux.dcho == null)) {//para las hojas derechas
                        if (aux.dcho.transicion.equals("ε")) {
                            cola.add(aux.dcho);
                        } else {
                            estado.Mueve(aux.dcho.transicion, aux.dcho);//enviando todo el nodo

                        }
                    }
                }
            }
        }
    }

    /**
     * **********************
     * Operaciones con el AFD
     *
     * @param busq
     * @return
     */
    public Nodo buscar(int busq) {//recorre todo el árbol en búsca del nuevo nodo
        Queue<Nodo> cola1 = new LinkedList<>();
        Nodo retorno = null;
        Nodo aux;
        if (raiz != null) {
            cola1.add(raiz);//insertando la cabeza
            while (!cola1.isEmpty()) {
                aux = cola1.poll();
                if (aux.id == busq && aux.usada == false) {//lo encontró
                    retorno = aux;
                    break;
                }
                if (!(aux.izdo == null)) {
                    cola1.add(aux.izdo);
                }
                if (!(aux.dcho == null)) {
                    cola1.add(aux.dcho);
                }
            }
        }
        return retorno;
    }

    public int elMasGrande() {
        int retorno = 0;

        Iterator<Cerradura> it = listaCerraduras.iterator();
        while (it.hasNext()) {
            Cerradura cer = it.next();
            Iterator<Integer> itNum = cer.num.iterator();
            while (itNum.hasNext()) {
                int num = itNum.next();
                if (num > retorno) {
                    retorno = num;
                }
            }
        }
        return retorno;
    }

    /**
     * **********************
     * Operaciones para valuar la cadena de entrada
     */
    public boolean evaluarCadena(String cadena) {
        Stack<Estado> pilaEstado = new Stack<>();
        pilaEstado.push(BuscarEstado("S0"));//inicio con el primer estado
        boolean retorno = false;
        boolean bandera2 = true;
        for (int i = 0; i < cadena.length(); i++) {
//            System.out.println("Caracter " + i + ": " + cadena.charAt(i));
            Estado est = pilaEstado.pop();
            Boolean bandera = false;
            Iterator<Mueve> it = est.lstMueve.iterator();

            while (it.hasNext()) {
                Mueve muv = it.next();

                if (muv.transicion.equals(String.valueOf(cadena.charAt(i)))) {//encontro la transicion
                   
                    pilaEstado.push(BuscarEstado(muv.estado));
                    bandera = true;
                    break;
                }
            }
            if (!bandera) {
                bandera2 = false;
                pilaEstado.push(est);
            }

        }

        if (esEstadoDeAceptacion(pilaEstado.pop().nombre) && bandera2) {
            retorno = true;
        }

        return retorno;
    }
    
    public void estadosDeAceptacion() {
        System.out.println("===========Estados de Aceptacion==========");
        int ultimoNumero = elMasGrande();
        String estadosDeAceptacion = "";
        Iterator<Cerradura> it = listaCerraduras.iterator();
        while (it.hasNext()) {//recorriendo lista de cerraduras
            Cerradura cer = it.next();

            Iterator<Integer> itNum = cer.num.iterator();
            boolean esDeAceptacion = false;
            while (itNum.hasNext()) {
                int num = itNum.next();
                if (num == ultimoNumero) {
                    esDeAceptacion = true;
                }
            }
            if (esDeAceptacion) {
                listaDeEstadosDeAceptacion.add(cer.estado);
                estadosDeAceptacion = estadosDeAceptacion + "|" + cer.estado;
            }

        }
        System.out.println(estadosDeAceptacion);
    }

    public Estado BuscarEstado(String estadoABuscar) {
        Iterator<Estado> it = listaDeEstados.iterator();
        Estado retorno = null;
        while (it.hasNext()) {
            Estado est = it.next();
            if (estadoABuscar.equals(est.nombre)) {
                retorno = est;
                break;
            }

        }
        return retorno;
    }

    public boolean esEstadoDeAceptacion(String estado) {
        boolean retorno = false;
        if (listaDeEstadosDeAceptacion.isEmpty()) {
            estadosDeAceptacion();//llenando la lista de estados de aceptacion
        }
        Iterator<String> it = listaDeEstadosDeAceptacion.iterator();
        while (it.hasNext()) {
            String dato = it.next();
            if (dato.equals(estado)) {
                retorno = true;
                break;
            }
        }
        return retorno;
    }

    /**
     * **********************
     * Operaciones con el AFN
     */
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
