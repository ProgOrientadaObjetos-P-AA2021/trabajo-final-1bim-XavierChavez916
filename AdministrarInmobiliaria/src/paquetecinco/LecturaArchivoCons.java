/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecinco;

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
public class LecturaArchivoCons {

    private ObjectInputStream entrada;
    private ArrayList<Constructora> constructora;
    private String nombreArchivo;
    private Constructora objetoBuscado;
    private boolean booleanBuscado;

    public LecturaArchivoCons(String n) {
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

    public void establecerListaConstructora() {
        // 
        constructora = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Constructora registro = (Constructora) entrada.readObject();
                    constructora.add(registro);
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
        establecerListaConstructora();
        ArrayList<Constructora> listaPropietario = obtenerListaConstructora();
        for (int i = 0; i < listaPropietario.size(); i++) {
            Constructora cons = listaPropietario.get(i);
            if (cons.obtenerIdEmpresa().equals(n)) {
                objetoBuscado = cons;
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

    public ArrayList<Constructora> obtenerListaConstructora() {
        return constructora;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public Constructora obtenerObjetoBuscado() {
        return objetoBuscado;
    }

    public boolean obtenerBooleanBuscado() {
        return booleanBuscado;
    }

    @Override
    public String toString() {
        String cadena = "Lista de Constructoras\n";
        for (int i = 0; i < obtenerListaConstructora().size(); i++) {
            Constructora p = obtenerListaConstructora().get(i);
            cadena = String.format("%s-------------------------------------\n"
                    + "Id de la empresa: %s\nNombre Constructora: %s\n"
                    + "-------------------------------------\n", cadena,
                    p.obtenerIdEmpresa(),
                    p.obtenerNomConstructora());

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
