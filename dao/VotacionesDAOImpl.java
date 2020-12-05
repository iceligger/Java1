package dao;

import idao.IVotaciones;
import model.Votaciones;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Implementación de Votaciones que contiene los atributos, instacias y metodos para realizar las votaciones
 * @author David Alejandro Tobon Ortiz
 */
public class VotacionesDAOImpl implements IVotaciones {

    //Variables e instancias
    private Votaciones votaciones = new Votaciones();
    private PersonasDAOImpl personaV = new PersonasDAOImpl();
    private Scanner teclado = new Scanner(System.in);

    private String candidato;
    private int ganador;
    private double porcentajeC1;
    private double porcentajeC2;
    private double porcentajeC3;
    private double porcentajeVB;
    private double porcentajeVA;
    private ArrayList<Votaciones> resultadoVotacionesL = new ArrayList<Votaciones>();

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private LocalDate fechaActual = LocalDate.now();


    /**
     * Metodo que incrementa la votación por cada candidato, voto en blanco y anulados, además, guarda un listado
     * de la identificación de la persona y su respectiva votación
     * @param numId
     * @param voto
     */
    @Override
    public void votacion(int numId, int voto) {
        switch (voto) {
            case 1:
                votaciones.setCandidato1(votaciones.getCandidato1() + 1);
                resultadoVotacionesL.add(new Votaciones(numId, "Candidato 1"));
                break;
            case 2:
                votaciones.setCandidato2(votaciones.getCandidato2() + 1);
                resultadoVotacionesL.add(new Votaciones(numId, "Candidato 2"));
                break;
            case 3:
                votaciones.setCandidato3(votaciones.getCandidato3() + 1);
                resultadoVotacionesL.add(new Votaciones(numId, "Candidato 3"));
                break;
            case 4:
                votaciones.setVotosBlanco(votaciones.getVotosBlanco() + 1);
                resultadoVotacionesL.add(new Votaciones(numId, "Voto en Blanco"));
                break;
            case 5:
                votaciones.setVotosNulos(votaciones.getVotosNulos() + 1);
                resultadoVotacionesL.add(new Votaciones(numId, "Voto Anulado"));
                break;
        }
    }

    /**
     * Metodo que incrementa la cantidad de votantes que participaron en la votación
     */
    @Override
    public void votosVotantes() {
        votaciones.setVotantes(votaciones.getVotantes() + 1);
    }

    /**
     * Metodo que incrementa la cantidad de No votantes que participaron en la votación
     */
    @Override
    public void votosNoVotantes() {
        votaciones.setNoVotantes(votaciones.getNoVotantes() + 1);
    }

    /**
     * Metodo que incrementea la cantidad de veces algunas personas intentaron votar nuevamente
     */
    @Override
    public void intentoVoto() {
        votaciones.setcIntentosVotos(votaciones.getcIntentosVotos() + 1);
    }

    /**
     * Metodo que se encarga de calcular el ganador de la votaciones y retorna quien fue el ganador
     * @return candidato
     */
    @Override
    public String ganador() {
        if (votaciones.getCandidato1() > votaciones.getCandidato2() && votaciones.getCandidato1() > votaciones.getCandidato3()) {
            candidato = "Candidato 1";
            ganador = 1;
        } else if (votaciones.getCandidato2() > votaciones.getCandidato1() && votaciones.getCandidato2() > votaciones.getCandidato3()) {
            candidato = "Candidato 2";
            ganador = 1;
        } else if (votaciones.getCandidato3() > votaciones.getCandidato1() && votaciones.getCandidato3() > votaciones.getCandidato2()) {
            candidato = "Candidato 3";
            ganador = 1;
        } else if (votaciones.getCandidato1() == votaciones.getCandidato2() && votaciones.getCandidato1() > 0) {
            candidato = "Candidato 1 & Candidato 2";
            ganador = 2;
        } else if (votaciones.getCandidato1() == votaciones.getCandidato3() && votaciones.getCandidato1() > 0) {
            candidato = "Candidato 1 & Candidato 3";
            ganador = 2;
        } else if (votaciones.getCandidato1() == votaciones.getVotosNulos() && votaciones.getCandidato1() > 0) {
            candidato = "Candidato 1";
            ganador = 1;
        } else if (votaciones.getCandidato1() == votaciones.getVotosBlanco() && votaciones.getCandidato1() > 0) {
            candidato = "Candidato 1";
            ganador = 1;
        } else if (votaciones.getCandidato2() == votaciones.getCandidato3() && votaciones.getCandidato2() > 0) {
            candidato = "Candidato 2 & Candidato 3";
            ganador = 2;
        } else if (votaciones.getCandidato2() == votaciones.getVotosNulos() && votaciones.getCandidato2() > 0) {
            candidato = "Candidato 2";
            ganador = 1;
        } else if (votaciones.getCandidato2() == votaciones.getVotosBlanco() && votaciones.getCandidato2() > 0) {
            candidato = "Candidato 2";
            ganador = 1;
        } else if (votaciones.getCandidato3() == votaciones.getVotosNulos() && votaciones.getCandidato3() > 0) {
            candidato = "Candidato 3";
            ganador = 1;
        } else if (votaciones.getCandidato3() == votaciones.getVotosBlanco() && votaciones.getCandidato3() > 0) {
            candidato = "Candidato 3";
            ganador = 1;
        } else {
            candidato = "No hay gananador de las votaciones, se debe hacer una nueva votación";
            ganador = 3;
        }
        return candidato;
    }

    /**
     * Metodo que calcula el porcentaje de las votaciones por cada candidato, voto en blanco y anulados
     */
    @Override
    public void porcentajesCandidatos() {

        porcentajeC1 = (votaciones.getCandidato1() * 100) / votaciones.getVotantes();
        porcentajeC2 = (votaciones.getCandidato2() * 100) / votaciones.getVotantes();
        porcentajeC3 = (votaciones.getCandidato3() * 100) / votaciones.getVotantes();
        porcentajeVB = (votaciones.getVotosBlanco() * 100) / votaciones.getVotantes();
        porcentajeVA = (votaciones.getVotosNulos() * 100) / votaciones.getVotantes();
    }

    /**
     * Metodo encargado de generar los resultados finales Conteos, Porcentajes y Ganador de las votaciones y al final
     * despliega la lista de las personas que hicieron su votación
     */
    public void generarResultados() {

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("--                    RESULTADOS DE LAS VOTACIONES                                --");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("-- Total de votos por Candidatos                                                  --");
        System.out.println("Canditato 1 = " + votaciones.getCandidato1());
        System.out.println("Canditato 2 = " + votaciones.getCandidato2());
        System.out.println("Canditato 3 = " + votaciones.getCandidato3());
        System.out.println("Voto en Blanco = " + votaciones.getVotosBlanco());
        System.out.println("");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("-- Cantidad de Votaciones                                                         --");
        System.out.println("Cantidad de Votantes = " + votaciones.getVotantes());
        System.out.println("Cantidad de No Votantes = " + votaciones.getNoVotantes());
        System.out.println("Cantidad de Nulos = " + votaciones.getVotosNulos());
        System.out.println("Intentos de Votos = " + votaciones.getcIntentosVotos());
        System.out.println("");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("-- Los porcentajes de las Votaciones                                              --");
        System.out.println("Canditato 1 = " + porcentajeC1 + "%");
        System.out.println("Canditato 2 = " + porcentajeC2 + "%");
        System.out.println("Canditato 3 = " + porcentajeC3 + "%");
        System.out.println("Voto en Blanco = " + porcentajeVB + "%");
        System.out.println("Votos Anulados = " + porcentajeVA + "%");
        System.out.println("");
        System.out.println("-- Ganador de las Votaciones                                                      --");
        ganador();
        if (ganador == 1) {
            System.out.println("El candidato ganador es: " + candidato);
        } else if (ganador == 2) {
            System.out.println("Existe un empate entre los candidatos " + candidato);
        } else {
            System.out.println(candidato);
        }
        System.out.println("");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("-- Personas que Votaron                                                           --");
        listadoVotosXPersona();
        System.out.println("");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("--                      FIN DE LAS VOTACIONES                                     --");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("");
    }

    /**
     * Metodo encargado de reiniciar y incializar las variables para realizar un nuevo proceso electoral
     */
    public void reiniciarVotaciones() {
        votaciones.setCandidato1(0);
        votaciones.setCandidato2(0);
        votaciones.setCandidato3(0);
        votaciones.setNoVotantes(0);
        votaciones.setVotosNulos(0);
        votaciones.setVotosBlanco(0);
        votaciones.setVotantes(0);
        candidato = "";
        ganador = 0;
        porcentajeC1 = 0;
        porcentajeC2 = 0;
        porcentajeC3 = 0;
        porcentajeVA = 0;
        porcentajeVB = 0;
        votaciones.setcIntentosVotos(0);
        borrarVotos();
    }

    /**
     * Metodo que valida si la persona ya realizó o no la votación y retorna la respuesta
     * @param numIden
     * @return yaVoto
     */
    public boolean yaVotoPersona(int numIden) {
        boolean yaVoto = false;
        for (int i = 0; i < resultadoVotacionesL.size(); i++) {
            if (resultadoVotacionesL.get(i).getNumIden() == numIden) {
                personaV.getNumIdentificacion();
                yaVoto = true;
                break;
            }
        }
        return yaVoto;
    }

    /**
     * Metodo que imprime la lista de votaciones del proceso electoral por persona y su respectivo voto
     */
    public void listadoVotosXPersona() {
        System.out.println("Nro. Identificación - Voto");

        for (int j = 0; j < resultadoVotacionesL.size(); j++) {
            System.out.println(resultadoVotacionesL.get(j).getNumIden() + " - " + resultadoVotacionesL.get(j).getVoto());
        }
    }

    /**
     * Metodo encargado de generar el Certificado Electoral para cada uno de los votantes
     */
    public void generarCertificado() {
        System.out.println("-- ------------------------------------------------------------------------------ --");
        System.out.println("--                    CERTIFICADO ELECTORAL                                       --");
        System.out.println("-- ------------------------------------------------------------------------------ --");
        System.out.println("--                                                                                --");
        System.out.println("-- FECHA: " + fechaActual);
        System.out.println("-- TIPO IDENTIFICACIÓN: " + personaV.getTipoIdentificacion());
        System.out.println("-- NÚMERO IDENTIFICACIÓN: " + personaV.getNumIdentificacion());
        System.out.println("-- NOMBRE: " + personaV.getNombre());
        System.out.println("--                                                                                --");
        System.out.println("-- ------------------------------------------------------------------------------ --");
        System.out.println("--                                                                                --");
        System.out.println("-- La registraduría certifica que:                                                --");
        System.out.println("-- Asistió y Ejerció el poder al Voto                                             --");
        System.out.println("--                                                                                --");
        System.out.println("-- ------------------------------------------------------------------------------ --");
        System.out.println("");
    }

    /**
     * Metodo que permite eliminar el listado de los votos realizados para un nuevo proceso electoral
     */
    public void borrarVotos() {
        resultadoVotacionesL.clear();
    }

    /**
     * Menú Principal en la cual se puede consultar la lista de personas que pueden votar, realizar votación,
     * finalizar proceso electoral y generar resultados y salir de la aplicación
     */
    @Override
    public void menuPrincipal() {
        try {
            int opcP = 0;

            System.out.println("--- Menú Principal Votaciones: ---");
            System.out.println("1. Mostrar listado de Personas que pueden votar");
            System.out.println("2. Realizar Votación");
            System.out.println("3. Finalizar Votación y Generar Resultados");
            System.out.println("4. Salir");
            opcP = teclado.nextInt();

            switch (opcP) {
                case 1:
                    personaV.orderArrayListPersonas();
                    personaV.arrayPersonasOrdenado();
                    System.out.println("");
                    menuPrincipal();
                case 2:
                    personaV.capturarDatosPersona();
                    menuVotacion();
                case 3:
                    boolean finVotacion = false;
                    String respuesta = "";

                    do {
                        System.out.println("¿Está Seguro de Finalizar las votaciones? (S/N)");
                        respuesta = teclado.next();
                        if (respuesta.equals("S")) {
                            finVotacion = true;
                            if (votaciones.getVotantes() == 0) {
                                System.out.println("No se se han hecho votaciones");
                                System.out.println("");
                                menuPrincipal();
                            } else {
                                porcentajesCandidatos();
                                generarResultados();
                                reiniciarVotaciones();
                                menuPrincipal();
                            }
                        } else if (respuesta.equals("N")) {
                            finVotacion = false;
                            menuPrincipal();
                        } else {
                            System.out.println("Opción ingresada no válida");
                            System.out.println("");
                        }
                    } while (finVotacion != true);
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Opción ingresada no válida");
                    System.out.println("");
                    menuPrincipal();
            }
        } catch (Exception e) {
            System.err.println("Has ingresado una opcion no válida: " + e);
            System.exit(0);
        }
    }

    /**
     * Menú de votación que muestra los candidatos disponibles para votar y realizar la respectiva votación
     */
    @Override
    public void menuVotacion() {
        try {
            int opcV = 0;

            System.out.println("--- Menú Votaciones: ---");
            System.out.println("1. Candidato 1");
            System.out.println("2. Candidato 2");
            System.out.println("3. Candidato 3");
            System.out.println("4. Voto en Blanco");
            opcV = teclado.nextInt();

            switch (opcV) {
                case 1:
                    votacion(personaV.getNumIdentificacion(), 1);
                    votosVotantes();
                    System.out.println("Has votado por el Candidato 1 exitosamente");
                    System.out.println("");
                    generarCertificado();
                    menuPrincipal();
                case 2:
                    votacion(personaV.getNumIdentificacion(), 2);
                    votosVotantes();
                    System.out.println("Has votado por el Candidato 2 exitosamente");
                    System.out.println("");
                    generarCertificado();
                    menuPrincipal();
                case 3:
                    votacion(personaV.getNumIdentificacion(), 3);
                    votosVotantes();
                    System.out.println("Has votado por el Candidato 3 exitosamente");
                    System.out.println("");
                    generarCertificado();
                    menuPrincipal();
                case 4:
                    votacion(personaV.getNumIdentificacion(), 4);
                    votosVotantes();
                    System.out.println("Has votado en Blanco");
                    System.out.println("");
                    generarCertificado();
                    menuPrincipal();
                default:
                    votacion(personaV.getNumIdentificacion(), 5);
                    votosVotantes();
                    System.out.println("No has elegido un candidato correcto por lo tanto se anula el voto");
                    System.out.println("");
                    generarCertificado();
                    menuPrincipal();
            }
        } catch (Exception e) {
            System.err.println("Has ingresado una opción inválida: " + e);
            System.exit(0);
        }
    }

    public ArrayList<Votaciones> getResultadoVotacionesL() {
        return resultadoVotacionesL;
    }

    public void setResultadoVotacionesL(ArrayList<Votaciones> resultadoVotacionesL) {
        this.resultadoVotacionesL = resultadoVotacionesL;
    }

}
