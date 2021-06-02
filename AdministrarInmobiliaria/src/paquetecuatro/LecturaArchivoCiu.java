/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecuatro;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author xavierchavez
 */
public class LecturaArchivoCiu {

    private ObjectInputStream entrada;
    private ArrayList<Ciudad> ciudad;
    private String nombreArchivo;
    private Ciudad objetoBuscado;
    private boolean booleanBuscado;

    public LecturaArchivoCiu(String n) {
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

    public void establecerListaCiudad() {
        // 
        ciudad = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Ciudad registro = (Ciudad) entrada.readObject();
                    ciudad.add(registro);
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
        establecerListaCiudad();
        ArrayList<Ciudad> listaPropietario = obtenerListaCiudad();
        for (int i = 0; i < listaPropietario.size(); i++) {
            Ciudad c = listaPropietario.get(i);
            if (c.obtenerNomCiudad().equals(n)) {
                objetoBuscado = c;
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

    public ArrayList<Ciudad> obtenerListaCiudad() {
        return ciudad;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public Ciudad obtenerObjetoBuscado() {
        return objetoBuscado;
    }

    public boolean obtenerBooleanBuscado() {
        return booleanBuscado;
    }

    @Override
    public String toString() {
        String cadena = "===================================================\n"
                + "\t\tLista de Ciudades\n"
                + "===================================================\n";
        for (int i = 0; i < obtenerListaCiudad().size(); i++) {
            Ciudad p = obtenerListaCiudad().get(i);
            cadena = String.format("%sCiudad %s\n"
                    + "*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n"
                    + "Número de la ciudad: %s\nNombre de la provincia: %s\n"
                    + "*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n",
                    cadena, i + 1,
                    p.obtenerNomCiudad(),
                    p.obtenerNomProvincia());

        }

        return cadena;
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    }
}
