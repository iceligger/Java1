package model;

/**
 * Clase Modelo Personas con sus atributos y metodos
 * @author David Alejandro Tobon Ortiz
 */
public class Personas {

    //Variables clase Personas
    private String tipoIdentificacion;
    private int numIdentificacion;
    private String nombre;
    private String fechaNacimiento;
    private int edad;

    /**
     * Constructor que recibe la información básica de la persona
     * @param tipoIdentificacion
     * @param numIdentificacion
     * @param nombre
     * @param fechaNacimiento
     */
    public Personas(String tipoIdentificacion, int numIdentificacion, String nombre, String fechaNacimiento) {
        this.tipoIdentificacion = tipoIdentificacion;
        this.numIdentificacion = numIdentificacion;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Metodo que usa la clase toString() para retornar la información de la persona
     * @return los datos de la persona concatenados
     */
    public String toString() {
        return this.tipoIdentificacion + " " + this.numIdentificacion + " " + this.nombre + " " + this.fechaNacimiento + " " + this.edad;
    }


    /**
     * Getter y Setter Clase Personas
     */
    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public int getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(int numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}