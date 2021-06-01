/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecinco;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Constructora implements Serializable{
    
    private String nomConstructora;
    private String idEmpresa;
    
    public Constructora(){
    }
    
    public Constructora(String construc, String idEmpre){
        nomConstructora = construc;
        idEmpresa = idEmpre;
    }
    
    
    public void establecerNomConstructora(String c){
        nomConstructora = c;
    }
    
    public void establecerIdEmpresa(String c){
        idEmpresa = c;
    }
    
    public String obtenerNomConstructora(){
        return nomConstructora;
    }
    
    public String obtenerIdEmpresa(){
        return idEmpresa;
    }
    
}
