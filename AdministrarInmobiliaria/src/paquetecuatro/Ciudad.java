/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecuatro;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Ciudad implements Serializable{
    
    private String nomCiudad;
    private String nomProvincia;
    
    public Ciudad(){
    }
    
    public Ciudad(String ciu, String prov){
        nomCiudad = ciu;
        nomProvincia = prov;
    }
    
    public void establecerNomciudad(String c){
        nomCiudad = c;
    }
    
    public void establecerNomProvincia(String c){
        nomProvincia = c;
    }
    
    public String obtenerNomCiudad(){
        return nomCiudad;
    }
    
    public String obtenerNomProvincia(){
        return nomProvincia;
    }
    
}
