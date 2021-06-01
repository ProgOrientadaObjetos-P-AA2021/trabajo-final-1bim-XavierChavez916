/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.util.Scanner;
import paquetecinco.Constructora;
import paquetecinco.EscrituraArchivoCons;
import paquetecinco.LecturaArchivoCons;
import paquetecuatro.Ciudad;
import paquetecuatro.EscrituraArchivoCiu;
import paquetecuatro.LecturaArchivoCiu;
import paquetedos.EscrituraArchivoProp;
import paquetedos.LecturaArchivoProp;
import paquetedos.Propietario;
import paqueteseis.Casa;
import paqueteseis.Departamento;
import paqueteseis.EscrituraArchivoCasa;
import paqueteseis.EscrituraArchivoDepa;
import paqueteseis.LecturaArchivoCasa;
import paqueteseis.LecturaArchivoDepa;
import paquetetres.EscrituraArchivoUbi;
import paquetetres.LecturaArchivoUbi;
import paquetetres.Ubicacion;

/**
 *
 * @author reroes
 */
public class Ejecutor {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("*-*-* Sistema de gestion de una inmobiliaria -*-*");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        boolean bandera = true;
        int opcion, datosIngresar;
        

        while (bandera) {
            System.out.printf("Escoja la opcion que desea ingresar\n"
                    + "1) Digite 1 si desea ingresar una Casa\n"
                    + "2) Digite 2 si desea ingresar un Departamento\n"
                    + "3) Digite 3 si desea ingresar propietarios\n"
                    + "4) Digite 4 si desea ingresar ubicaciones\n"
                    + "5) Digite 5 si desea ingresar ciudades\n"
                    + "6) Digite 6 si desea ingresar constructoras\n"
                    + "7) Digite 7 si desea ver los datos ingresados\n"
                    + "8) Digite 8 si desea salir\n");
            opcion = entrada.nextInt();
            entrada.nextLine();
            if (opcion == 1) {
                System.out.println("Digite cuantos casas desea ingresar");
                datosIngresar = entrada.nextInt();
                entrada.nextLine();
                for (int i = 0; i < datosIngresar; i++) {
                    ingreseCasa();
                }         
            } else if (opcion == 2) {
                System.out.println("Digite cuantos Departamentos desea ingresar");
                datosIngresar = entrada.nextInt();
                entrada.nextLine();
                for (int i = 0; i < datosIngresar; i++) {
                    ingreseDepartamento();
                }         
            } else if (opcion == 3) {
                System.out.println("Digite cuantos propietarios desea ingresar");
                datosIngresar = entrada.nextInt();
                entrada.nextLine();
                for (int i = 0; i < datosIngresar; i++) {
                    ingresePropietario();
                }         
            } else if (opcion == 4) {
                System.out.println("Digite cuantas ubicaciones desea ingresar");
                datosIngresar = entrada.nextInt();
                entrada.nextLine();
                for (int i = 0; i < datosIngresar; i++) {
                    ingreseUbicacion();
                }                
            } else if (opcion == 5) {
                System.out.println("Digite cuantas ciudades desea ingresar");
                datosIngresar = entrada.nextInt();
                entrada.nextLine();
                for (int i = 0; i < datosIngresar; i++) {
                    ingreseCiudad();
                }                    
            } else if (opcion == 6) {
                System.out.println("Digite cuantas constructoras desea ingresar");
                datosIngresar = entrada.nextInt();
                entrada.nextLine();
                for (int i = 0; i < datosIngresar; i++) {
                     ingreseConstructora();
                }                
            } else if (opcion == 7) {
                mostrarDatos();
            } else if (opcion == 8) {
                bandera = false;
            }

        }

    }

    public static Propietario ingresePropietario() {
        Scanner entrada = new Scanner(System.in);
        String nomArchivoProp = "datos/propietarios.txt";
        Propietario p = new Propietario();
        String iden, verDatos, nom, apell;
        
        LecturaArchivoProp lecturaProp = new LecturaArchivoProp(nomArchivoProp);
        EscrituraArchivoProp archivoProp = new EscrituraArchivoProp(nomArchivoProp);

        System.out.println("Ingrese su identificacion");
        iden = entrada.nextLine();
        lecturaProp.establecerObjetoBuscado(iden);
        lecturaProp.establecerBooleanBuscado();
        if (!lecturaProp.obtenerBooleanBuscado()) {
            System.out.printf("La identificacion con el numero %s ya "
                    + "se encuentra registrada\n"
                    + "Digite (si) si desea ver los datos\n", iden);
            verDatos = entrada.nextLine();
            p = new Propietario(lecturaProp.obtenerObjetoBuscado().obtenerNombre(), 
                    lecturaProp.obtenerObjetoBuscado().obtenerApellido(), iden);
            if (verDatos.equals("si")) {
                System.out.printf("Nombre : %s\n"
                        + "Apellido: %s\n",
                        lecturaProp.obtenerObjetoBuscado().obtenerNombre(),
                        lecturaProp.obtenerObjetoBuscado().obtenerApellido());
            }
        } else if (lecturaProp.obtenerBooleanBuscado()) {
            System.out.println("Ingrese el nombre");
            nom = entrada.nextLine();
            System.out.println("Ingrese su apellido");
            apell = entrada.nextLine();
            p = new Propietario(nom, apell, iden);
            archivoProp.establecerRegistroPropietario(p);
            archivoProp.establecerSalida();
            archivoProp.cerrarArchivo();
        }

        return p;
    }

    public static Ubicacion ingreseUbicacion() {
        Scanner entrada = new Scanner(System.in);
        String nomArchivoUbi = "datos/ubicacion.txt";
        String verDatos, nomBarrio, numCasa, refe;
        Ubicacion u = new Ubicacion();
        EscrituraArchivoUbi archivoUbi = new EscrituraArchivoUbi(nomArchivoUbi);
        LecturaArchivoUbi lecturaUbi = new LecturaArchivoUbi(nomArchivoUbi);
        System.out.println("Ingrese el número de casa");
        numCasa = entrada.nextLine();
        lecturaUbi.establecerObjetoBuscado(numCasa);
        lecturaUbi.establecerBooleanBuscado();
        if (!lecturaUbi.obtenerBooleanBuscado()) {
            System.out.printf("El numero de casa %s ya "
                    + "se encuentra registrada\n"
                    + "Digite (si) si desea ver los datos\n", numCasa);
            verDatos = entrada.nextLine();
            if (verDatos.equals("si")) {
                System.out.printf("Barrio: %s\n"
                        + "Referencia: %s\n",
                        lecturaUbi.obtenerObjetoBuscado().obtenerNomBarrio(),
                        lecturaUbi.obtenerObjetoBuscado().obtenerReferencia());
            }
        } else if (lecturaUbi.obtenerBooleanBuscado()) {
            System.out.println("Ingrese el nombre de barrio");
            nomBarrio = entrada.nextLine();
            System.out.println("Ingrese una referencia");
            refe = entrada.nextLine();
            u = new Ubicacion(numCasa, nomBarrio, refe);
            archivoUbi.establecerRegistroUbicacion(u);
            archivoUbi.establecerSalida();
            archivoUbi.cerrarArchivo();
        }
        return u;
    }

    public static Ciudad ingreseCiudad() {
        Scanner entrada = new Scanner(System.in);
        String nomArchivoCiu = "datos/ciudades.txt";
        Ciudad c = new Ciudad();
        String nomCiudad, verDatos, nomProvincia;
        EscrituraArchivoCiu archivoCiu = new EscrituraArchivoCiu(nomArchivoCiu);
        LecturaArchivoCiu lecturaCiu = new LecturaArchivoCiu(nomArchivoCiu);
        System.out.println("Ingrese el nombre de la ciudad");
        nomCiudad = entrada.nextLine();
        lecturaCiu.establecerObjetoBuscado(nomCiudad);
        lecturaCiu.establecerBooleanBuscado();
        if (!lecturaCiu.obtenerBooleanBuscado()) {
            System.out.printf("La ciudad %s ya "
                    + "se encuentra registrada\n"
                    + "Digite (si) si desea ver los datos\n", nomCiudad);
            verDatos = entrada.nextLine();
            if (verDatos.equals("si")) {
                System.out.printf("Provincia: %s\n",
                        lecturaCiu.obtenerObjetoBuscado().obtenerNomProvincia());

            }
        } else if (lecturaCiu.obtenerBooleanBuscado()) {
            System.out.println("Ingrese el nombre de la provinvia");
            nomProvincia = entrada.nextLine();
            c = new Ciudad(nomCiudad, nomProvincia);
            archivoCiu.establecerRegistroCiudad(c);
            archivoCiu.establecerSalida();
            archivoCiu.cerrarArchivo();
        }
        return c;

    }

    public static Constructora ingreseConstructora() {
        Scanner entrada = new Scanner(System.in);
        String nomArchivoCons = "datos/constructoras.txt";
        Constructora cons = new Constructora();
        EscrituraArchivoCons archivoCons = new EscrituraArchivoCons(nomArchivoCons);
        LecturaArchivoCons lecturaCons = new LecturaArchivoCons(nomArchivoCons);
        String nomCons, idEmpresa, verDatos;
        System.out.println("Ingrese el Id de la empresa");
        idEmpresa = entrada.nextLine();
        lecturaCons.establecerObjetoBuscado(idEmpresa);
        lecturaCons.establecerBooleanBuscado();
        if (!lecturaCons.obtenerBooleanBuscado()) {
            System.out.printf("El numero de casa %s ya "
                    + "se encuentra registrada\n"
                    + "Digite (si) si desea ver los datos\n", idEmpresa);
            verDatos = entrada.nextLine();
            if (verDatos.equals("si")) {
                System.out.printf("Constructora: %s\n",
                        lecturaCons.obtenerObjetoBuscado().obtenerNomConstructora());

            }
        } else if (lecturaCons.obtenerBooleanBuscado()) {
            System.out.println("Ingrese el nombre de la constructora");
            nomCons = entrada.nextLine();
            cons = new Constructora(idEmpresa, nomCons);
            archivoCons.establecerRegistroConstructora(cons);
            archivoCons.establecerSalida();
            archivoCons.cerrarArchivo();
        }
        return cons;
    }

    public static void ingreseCasa() {
        Scanner entrada = new Scanner(System.in);
        String nomArchivoCasa = "datos/casas.txt";
        double precioCuadrado;
        int numMetCuadrado, numCuartos;
        EscrituraArchivoCasa archivoCasa = new EscrituraArchivoCasa(nomArchivoCasa);
        Propietario p = ingresePropietario();
        System.out.println("Ingrese el precio por metro cuadrado");
        precioCuadrado = entrada.nextDouble();
        System.out.println("Ingrese el numero de metros cuadrados");
        numMetCuadrado = entrada.nextInt();
        Ubicacion u = ingreseUbicacion();
        Ciudad c = ingreseCiudad();
        System.out.println("Ingrese el numero de cuartos");
        numCuartos = entrada.nextInt();
        Constructora cons = ingreseConstructora();
        Casa cs = new Casa(p, precioCuadrado, numMetCuadrado, u,
                c, numCuartos, cons);
        cs.establecerCostFinal();
        archivoCasa.establecerRegistroCasa(cs);
        archivoCasa.establecerSalida();
        archivoCasa.cerrarArchivo();
    }

    public static void ingreseDepartamento() {
        Scanner entrada = new Scanner(System.in);
        double precioCuadrado, valAliMens, precio;
        int numMetCuadrado;
        String nomEdi, ubiEdi;
        String nomArchivoDepa = "data/departamento.txt";
        EscrituraArchivoDepa archivoDepa = new EscrituraArchivoDepa(nomArchivoDepa);
        Propietario p = ingresePropietario();
        System.out.println("Ingrese el precio por metro cuadrado");
        precioCuadrado = entrada.nextDouble();
        System.out.println("Ingrese el numero de metros cuadrados");
        numMetCuadrado = entrada.nextInt();
        System.out.println("Ingrese el valor alicuota mensual");
        valAliMens = entrada.nextDouble();
        System.out.println("Ingrese el precio");
        precio = entrada.nextDouble();
        Ubicacion u = ingreseUbicacion();
        Ciudad c = ingreseCiudad();
        System.out.println("Ingrese el nombre del edificio");
        nomEdi = entrada.nextLine();
        System.out.println("Ingrese ubicacion del departamento del edificio");
        ubiEdi = entrada.nextLine();
        Constructora cons = ingreseConstructora();
        Departamento depa = new Departamento(p, precioCuadrado,
                numMetCuadrado, valAliMens, precio, u, c, nomEdi, ubiEdi, cons);
        archivoDepa.establecerRegistroDepa(depa);
        archivoDepa.establecerSalida();
        archivoDepa.cerrarArchivo();
    }

    public static void mostrarDatos() {
        String nomArchivoCasa = "datos/casas.txt";
        LecturaArchivoCasa lecturaCasa = new LecturaArchivoCasa(nomArchivoCasa);
        lecturaCasa.establecerListaCasa();
        String nomArchivoDepa = "data/departamento.txt";
        LecturaArchivoDepa lecturaDepa = new LecturaArchivoDepa(nomArchivoDepa);
        lecturaDepa.establecerListaDepa();
        String nomArchivoCons = "datos/constructoras.txt";
        LecturaArchivoCons lecturaCons = new LecturaArchivoCons(nomArchivoCons);
        lecturaCons.establecerListaConstructora();
        String nomArchivoCiu = "datos/ciudades.txt";
        LecturaArchivoCiu lecturaCiu = new LecturaArchivoCiu(nomArchivoCiu);
        lecturaCiu.establecerListaCiudad();
        String nomArchivoUbi = "datos/ubicacion.txt";
        LecturaArchivoUbi lecturaUbi = new LecturaArchivoUbi(nomArchivoUbi);
        lecturaUbi.establecerListaUbicacion();
        String nomArchivoProp = "datos/propietarios.txt";
        LecturaArchivoProp lecturaProp = new LecturaArchivoProp(nomArchivoProp);
        lecturaProp.establecerListaPropietarios();
        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n", lecturaCasa,
                lecturaDepa, lecturaCons, lecturaCiu, lecturaUbi, lecturaProp);

    }

}
