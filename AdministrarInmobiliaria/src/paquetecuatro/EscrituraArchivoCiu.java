/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecuatro;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 *
 * @author xavierchavez
 */
public class EscrituraArchivoCiu {

    private String nombreArchivo;
    private ObjectOutputStream salida; 
    private Ciudad registroCiudad;
    private ArrayList<Ciudad> listaCiudad;

    public EscrituraArchivoCiu(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerListaCiudad(); 
                                    
        try 
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            
            if (obtenerListaCiudad().size() > 0) {
                for (int i = 0; i < obtenerListaCiudad().size(); i++) {
                    establecerRegistroCiudad(obtenerListaCiudad().get(i));
                    establecerSalida();
                }
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        } // fin de catch
    }
    
    public void establecerNombreArchivo(String n){
        nombreArchivo = n;
    }

    public void establecerRegistroCiudad(Ciudad p) {
        registroCiudad = p;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroCiudad); 
                                                  
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    
    public void establecerListaCiudad() {
        LecturaArchivoCiu l = new LecturaArchivoCiu(obtenerNombreArchivo());
        l.establecerListaCiudad();
        listaCiudad = l.obtenerListaCiudad();
    }

    public String obtenerNombreArchivo(){
        return nombreArchivo;
    }
    
    public ArrayList<Ciudad> obtenerListaCiudad() {
        return listaCiudad;
    }

    public ObjectOutputStream obtenerSalida(){
        return salida;
    }
    public void cerrarArchivo() {
        try 
        {
            if (salida != null) {
                salida.close();
            }
        } 
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            
        } 
    } 

}

