package daoVotaciones;

import dao.PersonasDAOImpl;
import dao.VotacionesDAOImpl;

public class VotacionesTest {

    public static void main(String[] args) {

        PersonasDAOImpl per = new PersonasDAOImpl();
        VotacionesDAOImpl vot = new VotacionesDAOImpl();

        per.orderArrayListPersonas();
        per.arrayPersonasOrdenado();

        per.capturarDatosPersona();
        vot.votacion(182,1);
        System.out.println("Has votado por el Candidato 1 exitosamente");

        per.capturarDatosPersona();
        vot.votacion(182,2);
        System.out.println("Has votado por el Candidato 1 exitosamente");

        vot.listadoVotosXPersona();

    }

}
