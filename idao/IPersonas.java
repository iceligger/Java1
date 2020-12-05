package idao;

/**
 * Interface de Personas con sus respectivos metodos a implementar
 *  * @author David Alejandro Tobon Ortiz
 */
public interface IPersonas {

    public void capturarDatosPersona();

    public boolean validarEdadPersona(int edad);

    public void addOrRemovePersona();

    public void orderArrayListPersonas();

    public void arrayPersonasOrdenado();

    public boolean buscarNumIdentificacion(int valorNit);

    public int calcularEdad(String fechaNacimiento);

}
