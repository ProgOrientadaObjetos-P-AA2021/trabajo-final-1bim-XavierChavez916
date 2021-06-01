/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetetres;

/**
 *
 * @author xavierchavez
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;




/**
 *
 * @author reroes
 */
public class EscrituraArchivoUbi {

    private String nombreArchivo;
    private ObjectOutputStream salida; 
    private Ubicacion registroUbicacion;
    private ArrayList<Ubicacion> listaUbicacion;
    private String buscarArchivo;

    public EscrituraArchivoUbi(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerListaUbicacion(); 
                                    
        try 
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            
            if (obtenerListaUbicacion().size() > 0) {
                for (int i = 0; i < obtenerListaUbicacion().size(); i++) {
                    establecerRegistroUbicacion(obtenerListaUbicacion().get(i));
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

    public void establecerRegistroUbicacion(Ubicacion p) {
        registroUbicacion = p;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroUbicacion); 
                                                  
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    
    public void establecerListaUbicacion() {
        LecturaArchivoUbi l = new LecturaArchivoUbi(obtenerNombreArchivo());
        l.establecerListaUbicacion();
        listaUbicacion = l.obtenerListaUbicacion();
    }
    public void establecerBuscarArchiv(){
    }

    public String obtenerNombreArchivo(){
        return nombreArchivo;
    }
    
    
    public ArrayList<Ubicacion> obtenerListaUbicacion() {
        return listaUbicacion;
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
    public String obtenerBuscarArchivo(){
        return buscarArchivo;
    }

}

