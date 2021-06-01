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
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author reroes
 */
public class LecturaArchivoProp {

    private ObjectInputStream entrada;
    private ArrayList<Propietario> propietarios;
    private String nombreArchivo;
    private Propietario objetoBuscado;
    private boolean booleanBuscado;

    public LecturaArchivoProp(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } catch (IOException ioException) {
                System.err.println("Error al abrir el archivo.");

            }
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaPropietarios() {
        // 
        propietarios = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Propietario registro = (Propietario) entrada.readObject();
                    propietarios.add(registro);
                } catch (EOFException endOfFileException) {
                    return;

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);
                    break;
                }
            }
        }

    }

    public void establecerObjetoBuscado(String n) {
        establecerListaPropietarios();
        ArrayList<Propietario> listaPropietario = obtenerListaPropietarios();
        for (int i = 0; i < listaPropietario.size(); i++) {
            Propietario p = listaPropietario.get(i);
            if (p.obtenerIdentificacion().equals(n)) {
                objetoBuscado = p;
            }
        }
    }

    public void establecerBooleanBuscado() {
        boolean bandera = true;
        if (objetoBuscado != null) {
            bandera = false;
        }
        booleanBuscado = bandera;
    }

    public ArrayList<Propietario> obtenerListaPropietarios() {
        return propietarios;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public Propietario obtenerObjetoBuscado() {
        return objetoBuscado;
    }

    public boolean obtenerBooleanBuscado() {
        return booleanBuscado;
    }

    @Override
    public String toString() {
        String cadena = "Lista de Propietarios\n";
        for (int i = 0; i < obtenerListaPropietarios().size(); i++) {
            Propietario p = obtenerListaPropietarios().get(i);
            cadena = String.format("%s-------------------------------------\n"
                    + "Identificacion: %s\nNombre: %s\n"
                    + "Apellido: %s\n"
                    + "-------------------------------------\n", cadena,
                    p.obtenerIdentificacion(),
                    p.obtenerNombre(),
                    p.obtenerApellido());
        }

        return cadena;
    }

    // cierra el archivo y termina la aplicación
    public void cerrarArchivo() {
        try // cierra el archivo y sale
        {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método cerrarArchivo
}
