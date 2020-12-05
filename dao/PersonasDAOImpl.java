package dao;

import idao.IPersonas;
import model.Personas;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Clase Implementación de Personas que contiene los atributos, instacias y metodos para gestionar las personas
 * que hacen parte del proceso de las votaciones
 * @author David Alejandro Tobon Ortiz
 */
public class PersonasDAOImpl implements IPersonas {

    //Variables e instancias
    private Personas persona;
    private VotacionesDAOImpl votacionesP;
    private boolean puedeVotar;
    private boolean estaEnLista;
    private ArrayList<Personas> listaPersonas = new ArrayList<Personas>();
    private Scanner teclado = new Scanner(System.in);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate fechaActual = LocalDate.now();


    /**
     * Contructor de la implementación de Personas, que llama al metodo insertarListadoPersonas para cargar
     * el listado de las personas que pueden votar
     */
    public PersonasDAOImpl() {

        insertarListadoPersonas();
    }

    /**
     * Metodo encargado de cargar y crear el listado de personas que pueden votar, se valida que no se repitan
     * registros en la lista
     */
    public void insertarListadoPersonas() {

        persona = new Personas("CC", 456, "Laura", "1985-08-04");
        buscarNumIdentificacion(persona.getNumIdentificacion());
        addOrRemovePersona();

        persona = new Personas("CC", 182, "David", "1986-12-18");
        buscarNumIdentificacion(persona.getNumIdentificacion());
        addOrRemovePersona();

        persona = new Personas("RC", 789, "Felipe", "2020-01-16");
        buscarNumIdentificacion(persona.getNumIdentificacion());
        addOrRemovePersona();

        persona = new Personas("CC", 182, "David", "1900-01-30");
        buscarNumIdentificacion(persona.getNumIdentificacion());
        addOrRemovePersona();

        persona = new Personas("CC", 112, "Daniel", "1995-06-14");
        buscarNumIdentificacion(persona.getNumIdentificacion());
        addOrRemovePersona();

        persona = new Personas("CC", 123, "David", "2000-30-17");
        buscarNumIdentificacion(persona.getNumIdentificacion());
        addOrRemovePersona();

        persona = new Personas("CC", 456, "Laura", "1840-11-14");
        buscarNumIdentificacion(persona.getNumIdentificacion());
        addOrRemovePersona();

        persona = new Personas("CE", 402, "Marta", "1980-01-06");
        buscarNumIdentificacion(persona.getNumIdentificacion());
        addOrRemovePersona();

        persona = new Personas("CC", 479, "Emma", "1979-11-04");
        buscarNumIdentificacion(persona.getNumIdentificacion());
        addOrRemovePersona();

        persona = new Personas("CC", 100, "Aurelio", "1979-12-11");
        buscarNumIdentificacion(persona.getNumIdentificacion());
        addOrRemovePersona();

        persona = new Personas("TI", 947, "Yerson", "1980-12-04");
        buscarNumIdentificacion(persona.getNumIdentificacion());
        addOrRemovePersona();

        persona = new Personas("DS", 666, "Lucifer", "0001-01-08");
        buscarNumIdentificacion(persona.getNumIdentificacion());
        addOrRemovePersona();

        persona = new Personas("DS", 777, "God", "0001-01-01");
        buscarNumIdentificacion(persona.getNumIdentificacion());
        addOrRemovePersona();

        persona = new Personas("CC", 984, "Estefania", "1994-12-06");
        buscarNumIdentificacion(persona.getNumIdentificacion());
        addOrRemovePersona();

        persona = new Personas("CE", 560, "Max Payne", "1997-06-23");
        buscarNumIdentificacion(persona.getNumIdentificacion());
        addOrRemovePersona();

        persona = new Personas("CC", 445, "Alexandra", "1998-03-24");
        buscarNumIdentificacion(persona.getNumIdentificacion());
        addOrRemovePersona();

        persona = new Personas("CC", 791, "Paola", "1814-02-18");
        buscarNumIdentificacion(persona.getNumIdentificacion());
        addOrRemovePersona();
    }

    /**
     * Metodo que permite capturar los datos de la persona que desea votar, se valida si ya voto, si es mayor de
     * edad o si la persona esta en la lista de personas disponibles para votar
     */
    @Override
    public void capturarDatosPersona() {
        String feNa = "";
        int numId = 0;
        String tipoId = "";
        String nom = "";
        boolean puedeVotarEdad = false;
        boolean puedeVotarLista = false;
        boolean yaVoto = false;
        votacionesP = new VotacionesDAOImpl();

        System.out.println("Ingrese el número de Identificación: ");
        try {
            numId = teclado.nextInt();
            puedeVotarLista = buscarNumIdentificacion(numId);
            if (puedeVotarLista != true) {
                votacionesP.votosNoVotantes();
                System.out.println("La persona no puede votar porque no se encuentra registrado");
                System.out.println("");
                votacionesP.menuPrincipal();
            }
            yaVoto = votacionesP.yaVotoPersona(numId);
            if (yaVoto == true) {
                votacionesP.intentoVoto();
                System.out.println("La persona ya realizó su voto");
                System.out.println("");
                votacionesP.menuPrincipal();
            }
        } catch (Exception e) {
            System.out.println("Ingrese un valor númerico para número de Identificación");
            System.out.println("");
            votacionesP.menuPrincipal();
        }

        teclado.skip("\n");
        System.out.println("Ingrese su tipo de identificación: ");
        tipoId = teclado.nextLine();

        teclado.nextLine();
        System.out.println("Ingrese su Nombre Completo: ");
        nom = teclado.nextLine();

        System.out.println("Ingrese su Fecha de Nacimiento: (AAAA-MM-DD)");
        try {
            feNa = teclado.nextLine();
            puedeVotarEdad = validarEdadPersona(calcularEdad(feNa));
            if (puedeVotarEdad != true) {
                votacionesP.votosNoVotantes();
                System.out.println("Eres menor de Edad, por lo tanto, no puedes votar");
                System.out.println(" ");
                votacionesP.menuPrincipal();
            }
        } catch (Exception e) {
            System.out.println("Debe ingresar la fecha de Nacimiento con el formato adecuado AAAA-MM-DD");
            System.out.println("");
            capturarDatosPersona();
        }

        teclado.skip("\n");
        persona = new Personas(tipoId, numId, nom, feNa);
    }

    /**
     * Metodo que valida si la persona es mayor de edad según el parametro recibido de la edad y retorna la respuesta
     * @param edad
     * @return puedeVotar
     */
    @Override
    public boolean validarEdadPersona(int edad) {

        if (edad >= 18) {
            puedeVotar = true;
        } else {
            puedeVotar = false;
        }
        return puedeVotar;
    }

    /**
     * Metodo que permite calcular la edad de la persona que desea votar a partir de su fecha de nacimiento
     * que se recibe como parametro y retorna la edad de la persona en años
     * @param FechaNac
     * @return periodo.getYears()
     */
    @Override
    public int calcularEdad(String FechaNac) {
        LocalDate fechaNacimiento = LocalDate.parse(FechaNac, formatter);
        Period periodo = Period.between(fechaNacimiento, fechaActual);

        return periodo.getYears();
    }

    /**
     * Metodo que permite validar si se adiciona o no personas en la lista listaPersonas
     */
    @Override
    public void addOrRemovePersona() {
        if (estaEnLista != true) {
            listaPersonas.add(persona);
        } else {
            listaPersonas.remove(persona);
        }
    }

    /**
     * Metodo que permite ordenar la lista de personas disponibles para votar de manera ascendente por
     * su número de identificación
     */
    @Override
    public void orderArrayListPersonas() {

        Collections.sort(listaPersonas, new ordenarPersonas());
    }

    /**
     * Metodo que permite imprimir la lista listaPersonas de las personas que estan disponibles para votar
     */
    public void arrayPersonasOrdenado() {

        System.out.println("Nro. Identificación - Nombre");
        for (int i = 0; i < listaPersonas.size(); i++) {
            System.out.println(listaPersonas.get(i).getNumIdentificacion() + " - " + listaPersonas.get(i).getNombre());
        }
    }

    /**
     * Metodo encargado de validar si un número de identificación de una persona se encuentra en el listado de
     * personas disponibles para votar listaPersonas, retorna si la persona está o no en la lista
     * @param valorID
     * @return estaEnLista
     */
    @Override
    public boolean buscarNumIdentificacion(int valorID) {
        estaEnLista = false;

        for (int k = 0; k < listaPersonas.size(); k++) {
            if (valorID == listaPersonas.get(k).getNumIdentificacion()) {
                estaEnLista = true;
                break;
            }
        }
        return estaEnLista;
    }

    /**
     * Getter y Setter de la implementacion clase PersonasDAOImpl
     */
    public String getTipoIdentificacion() {

        return persona.getTipoIdentificacion();
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        persona.setTipoIdentificacion(tipoIdentificacion);
    }

    public int getNumIdentificacion() {
        return persona.getNumIdentificacion();
    }

    public void setNumIdentificacion(int numIdentificacion) {
        persona.setNumIdentificacion(numIdentificacion);
    }

    public String getNombre() {
        return persona.getNombre();
    }

    public void setNombre(String nombre) {
        persona.setNombre(nombre);
    }

    public String getFechaNacimiento() {
        return persona.getFechaNacimiento();
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        persona.setFechaNacimiento(fechaNacimiento);
    }

    public int getEdad() {
        return persona.getEdad();
    }

    public void setEdad(int edad) {
        persona.setEdad(edad);
    }
}

/**
 * Clase que implementa de la clase Comparator para ordenar la lista de personas disponibles para votar
 */
class ordenarPersonas implements Comparator<Personas> {
    @Override
    public int compare(Personas P1, Personas P2) {
        return P1.getNumIdentificacion() - P2.getNumIdentificacion();
    }
}
