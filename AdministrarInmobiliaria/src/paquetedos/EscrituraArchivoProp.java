/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetedos;

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
public class EscrituraArchivoProp {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Propietario registroPropietario;
    private ArrayList<Propietario> listaPropietarios;

    public EscrituraArchivoProp(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerListaPropietarios();

        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));

            if (obtenerListaPropietarios().size() > 0) {
                for (int i = 0; i < obtenerListaPropietarios().size(); i++) {
                    establecerRegistroPropietario(obtenerListaPropietarios().get(i));
                    establecerSalida();
                }
            }
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRegistroPropietario(Propietario p) {
        registroPropietario = p;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroPropietario);

        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerListaPropietarios() {
        LecturaArchivoProp l = new LecturaArchivoProp(obtenerNombreArchivo());
        l.establecerListaPropietarios();
        listaPropietarios = l.obtenerListaPropietarios();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Propietario> obtenerListaPropietarios() {
        return listaPropietarios;
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
