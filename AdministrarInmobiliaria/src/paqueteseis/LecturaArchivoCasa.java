/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;

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
public class LecturaArchivoCasa {

    private ObjectInputStream entrada;
    private ArrayList<Casa> casa;
    private String nombreArchivo;

    public LecturaArchivoCasa(String n) {
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

    public void establecerListaCasa() {
        // 
        casa = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Casa registro = (Casa) entrada.readObject();
                    casa.add(registro);
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

    public ArrayList<Casa> obtenerListaCasa() {
        return casa;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
       
        String cadena = "===================================================\n"
                + "\t\tLista de Casas\n"
                + "===================================================\n";
        
        for (int i = 0; i < obtenerListaCasa().size(); i++) {
            Casa p = obtenerListaCasa().get(i);
            cadena = String.format("%s\nCasa %s\n"
                    + "*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n"
                    + "Propietario: \n\tNombre del propietario: %s\n"
                    + "\tApellido del propietario: %s\n"
                    + "\tIdentificacion del propietario: %s\n"
                    + "Precio del metro cuadrado: %.2f\n"
                    + "Número de metros cuadrados: %s\n"
                    + "Costo final: %.2f\n"
                    + "Ubicacion:\n\tNombre del barrio: %s\n\tReferencia: %s\n"
                    + "Ciudad:\n\tNombre de la ciudad: %s\n\tProvincia: %s\n"
                    + "Número de cuartos: %s\n"
                    + "Constructora:\n\tNombre Constructora: %s\n"
                    + "\tId de la empresa: %s\n"
                    + "*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n", 
                    cadena, i + 1,
                    p.obtenerPropietario().obtenerNombre(),
                    p.obtenerPropietario().obtenerApellido(),
                    p.obtenerPropietario().obtenerIdentificacion(),
                    p.obtenerPrecMetCuadrado(),
                    p.obtenerNumMetroCuadrado(),
                    p.obtenerCostFinal(),
                    p.obtenerUbicacion().obtenerNomBarrio(),
                    p.obtenerUbicacion().obtenerReferencia(),
                    p.obtenerCiudad().obtenerNomCiudad(),
                    p.obtenerCiudad().obtenerNomProvincia(),
                    p.obtenerNumCuartos(),
                    p.obtenerConstructora().obtenerNomConstructora(),
                    p.obtenerConstructora().obtenerIdEmpresa());
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
