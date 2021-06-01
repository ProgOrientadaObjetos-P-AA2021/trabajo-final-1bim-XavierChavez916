/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author xavierchavez
 */
public class EscrituraArchivoCasa {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Casa registroCasa;
    private ArrayList<Casa> listaCasa;

    public EscrituraArchivoCasa(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerListaCasa();

        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));

            if (obtenerListaCasa().size() > 0) {
                for (int i = 0; i < obtenerListaCasa().size(); i++) {
                    establecerRegistroCasa(obtenerListaCasa().get(i));
                    establecerSalida();
                }
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        } // fin de catch
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRegistroCasa(Casa p) {
        registroCasa = p;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroCasa);

        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerListaCasa() {
        LecturaArchivoCasa l = new LecturaArchivoCasa(obtenerNombreArchivo());
        l.establecerListaCasa();
        listaCasa = l.obtenerListaCasa();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Casa> obtenerListaCasa() {
        return listaCasa;
    }

    public ObjectOutputStream obtenerSalida() {
        return salida;
    }

    public void cerrarArchivo() {
        try {
            if (salida != null) {
                salida.close();
            }
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");

        }
    }

}
   

