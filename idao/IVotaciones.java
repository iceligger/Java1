package idao;

/**
 * Interface de Votaciones con sus respectivos metodos a implementar
 *  * @author David Alejandro Tobon Ortiz
 */
public interface IVotaciones {

    public void votacion(int numId, int voto);

    public void votosVotantes();

    public void votosNoVotantes();

    public void intentoVoto();

    public String ganador();

    public void porcentajesCandidatos();

    public void menuPrincipal();

    public void menuVotacion();

}
