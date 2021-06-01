/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;

import paquetecinco.Constructora;
import paquetecuatro.Ciudad;
import paquetedos.Propietario;
import paquetetres.Ubicacion;

/**
 *
 * @author reroes
 */
public class Departamento {

    private Propietario propietario; 
    private double precMetCuadrado; 
    private int numMetCuadrado; 
    private double valAliMensual;
    private double costoFinal; 
    private double precio; 
    private Ubicacion ubicacion; 
    private Ciudad ciudad; 
    private String nomEdificio; 
    private String ubiDepartamento; 
    private Constructora constructora; 

    public Departamento(Propietario a, double b, int c, double d, double e, 
            Ubicacion f, Ciudad g, String h, String i, Constructora j) {
        propietario = a;
        precMetCuadrado =b;
        numMetCuadrado = c;
        valAliMensual = d;
        precio = e;
        ubicacion =f;
        ciudad = g;
        nomEdificio = h;
        ubiDepartamento = i;
        constructora = j;
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

    public void establecerValAliMensual(double n) {
        valAliMensual = n;
    }

    public void establecerCostoFinal() {
        costoFinal = (numMetCuadrado * precMetCuadrado) + (valAliMensual * 12);
    }

    public void establecerPrecio(double n) {
        precio = n;
    }

    public void establecerUbicacion(Ubicacion n) {
        ubicacion = n;
    }

    public void establecerCiudad(Ciudad n) {
        ciudad = n;
    }

    public void establecerNomEdificio(String n) {
        nomEdificio = n;
    }

    public void establecerUbiDepartamento(String n) {
        ubiDepartamento = n;
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

    public int obtenerNumMetCuadrado() {
        return numMetCuadrado;
    }

    public double obtenerValAliMensual() {
        return valAliMensual;
    }

    public double obtenerCostoFinal() {
        return costoFinal;
    }

    public double obtenerPrecio() {
        return precio;
    }

    public Ubicacion obtenerUbicacion() {
        return ubicacion;
    }

    public Ciudad obtenerCiudad() {
        return ciudad;
    }

    public String obtenerNomEdificio() {
        return nomEdificio;
    }

    public String obtenerUbiDepartamento() {
        return ubiDepartamento;
    }

    public Constructora obtenerConstructora() {
        return constructora;
    }

}
