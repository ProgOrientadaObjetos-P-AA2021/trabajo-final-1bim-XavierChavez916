/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;

import java.io.Serializable;
import paquetecinco.Constructora;
import paquetecuatro.Ciudad;
import paquetedos.Propietario;
import paquetetres.Ubicacion;

/**
 *
 * @author reroes
 */
public class Casa implements Serializable {

    private Propietario propietario;
    private double precMetCuadrado;
    private int numMetCuadrado;
    private double costFinal;
    private Ubicacion ubicacion;
    private Ciudad ciudad;
    private int numCuartos;
    private Constructora constructora;

    public Casa(Propietario prop, double precMet, int numMet,
            Ubicacion ubica, Ciudad ciu, int numeroCuar, Constructora constru) {
        propietario = prop;
        precMetCuadrado = precMet;
        numMetCuadrado = numMet;
        ubicacion = ubica;
        ciudad = ciu;
        numCuartos = numeroCuar;
        constructora = constru;
    }

    public void establecerPropietario(Propietario n) {
        propietario = n;
    }

    public void establecerPrecMetCuadrado(double n) {
        precMetCuadrado = n;
    }

    public void establecerNumMetCuadrado(int n) {
        numMetCuadrado = n;
    }

    public void establecerCostFinal() {
        costFinal = numMetCuadrado * precMetCuadrado;
    }

    public void establecerUbicacion(Ubicacion n) {
        ubicacion = n;
    }

    public void establecerCiudad(Ciudad n) {
        ciudad = n;
    }

    public void establecerNumCuartos(int n) {
        numCuartos = n;
    }

    public void establecerConstructora(Constructora n) {
        constructora = n;
    }

    public Propietario obtenerPropietario() {
        return propietario;
    }

    public double obtenerPrecMetCuadrado() {
        return precMetCuadrado;
    }

    public int obtenerNumMetroCuadrado() {
        return numMetCuadrado;
    }

    public double obtenerCostFinal() {
        return costFinal;
    }

    public Ubicacion obtenerUbicacion() {
        return ubicacion;
    }

    public Ciudad obtenerCiudad() {
        return ciudad;
    }

    public int obtenerNumCuartos() {
        return numCuartos;
    }

    public Constructora obtenerConstructora() {
        return constructora;
    }

}
