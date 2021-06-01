/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetetres;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Ubicacion implements Serializable{
    
    private String numeroCasa;
    private String nomBarrio;
    private String referencia;
    public Ubicacion(){
        
    }
    
    public Ubicacion(String numCasa, String nombreBarrio, String refe){
        numeroCasa = numCasa;
        nomBarrio = nombreBarrio;
        referencia = refe;
    }
    
    public void establecerNumeroCasa(String c) {
        numeroCasa = c;
    }

    public void establecerNomBarrio(String c) {
        nomBarrio = c;
    }

    public void establecerReferencia(String c) {
        referencia = c;
    }

    public String obtenerNumeroCasa() {
        return numeroCasa;
    }

    public String obtenerNomBarrio() {
        return nomBarrio;
    }

    public String obtenerReferencia() {
        return referencia;
    }
    
    @Override
    public String toString() {
        String cadena = String.format("DATOS DE LA UBICACIÓN\n"
                + "Número de casa: %s\n"
                + "Nombre del barrio: %s\n"
                + "Referencia: %s\n",
                obtenerNumeroCasa(),
                obtenerNomBarrio(),
                obtenerReferencia());
        return cadena;
    }
    
}
