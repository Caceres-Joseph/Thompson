/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thompsonmejorado;

import Afd.Afd;
import Analizadores.*;
import java.io.StringReader;


public class ThompsonMejorado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String expresionRegular=".+|?a+b|c+d";//en notación polaca
        
        new Sintactico(new Scanner(new StringReader(expresionRegular))).parse();
        System.out.println("=============AFN==========");
        //System.out.println(Variables.graph.operador.cadenaGraphivz);
        System.out.println(Variables.graph.operador.cadenaGraphivz);
        
         System.out.println("============AFD==========");
         
         Afd afd = new Afd(Variables.graph.pila.pop());//le paso el AFN
         System.out.println("============Valuando Cadena=======");
         System.out.println("Cadena aceptada = "+afd.evaluarCadena("c"));
        
    }
    
}
