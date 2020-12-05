package daoVotaciones;

import dao.VotacionesDAOImpl;
import idao.IVotaciones;

/**
 * Clase Principal de la aplicación de Votaciones
 *  * @author David Alejandro Tobon Ortiz
 */
public class Principal {

    /**
     * Clase estatica inicio de la aplicación de Votaciones
     * @param args
     */
    public static void main(String[] args) {

        //Instancia de las interface IVotaciones
        IVotaciones votacionesdao = new VotacionesDAOImpl();

        //Se llama al menú principal de Votaciones
        votacionesdao.menuPrincipal();
    }
}
