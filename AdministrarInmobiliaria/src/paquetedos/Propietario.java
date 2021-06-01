/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetedos;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Propietario implements Serializable{
    private String nombre;
    private String apellido;
    private String identificacion;
    
    
    public Propietario(){
        
    }
    public Propietario(String nom, String apell, String iden){
        nombre = nom;
        apellido = apell;
        identificacion = iden;
    }
    
    public void establecerNombre(String c) {
        nombre = c;
    }

    public void establecerApellido(String c) {
        apellido = c;
    }

    public void establecerIdentificacion(String c) {
        identificacion = c;
    }

    // public void establecerValorFactura(){
    

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerApellido() {
        return apellido;
    }

    public String obtenerIdentificacion() {
        return identificacion;
    }

    
}
