package model;

/**
 * Clase Modelo de Votaciones con sus atributos y metodos
 * @author David Alejandro Tobon Ortiz
 */
public class Votaciones {

    //Variables clase Votaciones
    private int candidato1;
    private int candidato2;
    private int candidato3;
    private int votosBlanco;
    private int noVotantes;
    private int votantes;
    private int votosNulos;
    private int cIntentosVotos = 0;
    private int numIden = 0;
    private String voto = "";


    /**
     * Constructor vacio de la clase Votaciones
     */
    public Votaciones() {

    }

    /**
     * Constructor que recibe la identificación y el voto de la persona
     * @param numIden
     * @param voto
     */
    public Votaciones(int numIden, String voto) {
        this.numIden = numIden;
        this.voto = voto;
    }

    /*
    Metodos Getter y Setter de la clase Modelo Votaciones
    */
    public int getCandidato1() {
        return candidato1;
    }

    public void setCandidato1(int candidato1) {
        this.candidato1 = candidato1;
    }

    public int getCandidato2() {
        return candidato2;
    }

    public void setCandidato2(int candidato2) {
        this.candidato2 = candidato2;
    }

    public int getCandidato3() {
        return candidato3;
    }

    public void setCandidato3(int candidato3) {
        this.candidato3 = candidato3;
    }

    public int getVotosBlanco() {
        return votosBlanco;
    }

    public void setVotosBlanco(int votosBlanco) {
        this.votosBlanco = votosBlanco;
    }

    public int getNoVotantes() {
        return noVotantes;
    }

    public void setNoVotantes(int noVotantes) {
        this.noVotantes = noVotantes;
    }

    public int getVotantes() {
        return votantes;
    }

    public void setVotantes(int votantes) {
        this.votantes = votantes;
    }

    public int getVotosNulos() {
        return votosNulos;
    }

    public void setVotosNulos(int votosNulos) {
        this.votosNulos = votosNulos;
    }

    public int getcIntentosVotos() {
        return cIntentosVotos;
    }

    public void setcIntentosVotos(int cIntentosVotos) {
        this.cIntentosVotos = cIntentosVotos;
    }

    public int getNumIden() {
        return numIden;
    }

    public void setNumIden(int numIden) {
        this.numIden = numIden;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }
}
