/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.swing.JList;

/**
 *
 * @author carlos
 */
@WebService(serviceName = "ServicioDiccionario")
public class ServicioDiccionario {

    ArrayList<String> palabras=new ArrayList();
        Map<String, String> dicio = new HashMap<>();


    /**
     * Web service operation
     */
    @WebMethod(operationName = "Diccionario")
    public String Diccionario(@WebParam(name = "palabra") String palabra) {
        
        dicio.put("casa", "lugar donde viven las personas");
        dicio.put("escuela", "lugar donde estudian los niños");
        dicio.put("silla", "donde nos sentamos");
        dicio.put("calculadora", "dispositivo para realizar calculos");
        dicio.put("laptop", "computador portatil");

        for (Map.Entry<String, String> dicio1 : dicio.entrySet()) {
            if (dicio1.getKey().equalsIgnoreCase(palabra)) {
                palabra = dicio1.getValue();

            }
        }
        return palabra;
               

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "imprimir")
    public String imprimir() {
        
        String respuesta=dicio.keySet().toString();
        return respuesta;
        

    }
    
    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregarpalabra")
    public String agregarpalabra(@WebParam(name = "key") String key, @WebParam(name = "significado") String significado) {
        
        return dicio.put(key, significado);
    }
    
        @WebMethod(operationName = "palabras")
        public ArrayList<String>palabras(){
            
            palabras.add("CASA");
            palabras.add("ESCUELA");
            palabras.add("SILLA");
            palabras.add("CALCULADORA");
            palabras.add("LAPTOP");
            return palabras;
        }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregarpalabras")
    public Boolean agregarpalabras(@WebParam(name = "palabra") String palabra) {
        //TODO write your implementation code here:
        return palabras.add(palabra);
    }
}
