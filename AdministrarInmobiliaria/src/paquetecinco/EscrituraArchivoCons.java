/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecinco;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author xavierchavez
 */
public class EscrituraArchivoCons {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Constructora registroConstructora;
    private ArrayList<Constructora> listaConstructora;

    public EscrituraArchivoCons(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerListaConstructora();

        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));

            if (obtenerListaConstructora().size() > 0) {
                for (int i = 0; i < obtenerListaConstructora().size(); i++) {
                    establecerRegistroConstructora(obtenerListaConstructora().get(i));
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

    public void establecerRegistroConstructora(Constructora p) {
        registroConstructora = p;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroConstructora);

        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerListaConstructora() {
        LecturaArchivoCons l = new LecturaArchivoCons(obtenerNombreArchivo());
        l.establecerListaConstructora();
        listaConstructora = l.obtenerListaConstructora();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Constructora> obtenerListaConstructora() {
        return listaConstructora;
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
