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
public class EscrituraArchivoDepa {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Departamento registroDepa;
    private ArrayList<Departamento> listaDepa;

    public EscrituraArchivoDepa(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerListaDepa();

        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));

            if (obtenerListaDepa().size() > 0) {
                for (int i = 0; i < obtenerListaDepa().size(); i++) {
                    establecerRegistroDepa(obtenerListaDepa().get(i));
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

    public void establecerRegistroDepa(Departamento d) {
        registroDepa = d;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroDepa);

        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerListaDepa() {
        LecturaArchivoDepa l = new LecturaArchivoDepa(obtenerNombreArchivo());
        l.establecerListaDepa();
        listaDepa = l.obtenerListaDepa();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Departamento> obtenerListaDepa() {
        return listaDepa;
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
