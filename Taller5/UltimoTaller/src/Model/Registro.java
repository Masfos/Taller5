package Model;

public class Registro {
    private String rut;
    private String nombre;
    private String apellido;
    private String isbn;
    private String nombreLibro;
    private String tipoTransaccion;

    /**
     * Crea una instancia de la clase Registro.
     *
     * @param rut             El RUT del usuario.
     * @param nombre          El nombre del usuario.
     * @param apellido        El apellido del usuario.
     * @param isbn            El ISBN del libro.
     * @param nombreLibro     El nombre del libro.
     * @param tipoTransaccion El tipo de transacción realizada.
     */
    public Registro(String rut, String nombre, String apellido, String isbn, String nombreLibro, String tipoTransaccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.isbn = isbn;
        this.nombreLibro = nombreLibro;
        this.tipoTransaccion = tipoTransaccion;
    }

    /**
     * Obtiene el RUT del usuario.
     *
     * @return El RUT del usuario.
     */
    public String getRut() {
        return rut;
    }

    /**
     * Establece el RUT del usuario.
     *
     * @param rut El RUT del usuario.
     */
    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del usuario.
     *
     * @return El apellido del usuario.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del usuario.
     *
     * @param apellido El apellido del usuario.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el ISBN del libro.
     *
     * @return El ISBN del libro.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Establece el ISBN del libro.
     *
     * @param isbn El ISBN del libro.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Obtiene el nombre del libro.
     *
     * @return El nombre del libro.
     */
    public String getNombreLibro() {
        return nombreLibro;
    }

    /**
     * Establece el nombre del libro.
     *
     * @param nombreLibro El nombre del libro.
     */
    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    /**
     * Obtiene el tipo de transacción realizada.
     *
     * @return El tipo de transacción.
     */
    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    /**
     * Establece el tipo de transacción realizada.
     *
     * @param tipoTransaccion El tipo de transacción.
     */
    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
}
