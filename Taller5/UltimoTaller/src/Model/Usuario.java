package Model;

public class Usuario {
    private String rut;
    private String nombre;
    private String apellido;
    private String contraseña;
    /**
     * Crea una instancia de la clase Usuario.
     *
     * @param rut        El RUT del usuario.
     * @param nombre     El nombre del usuario.
     * @param apellido   El apellido del usuario.
     * @param contraseña La contraseña del usuario.
     */
    public Usuario(String rut, String nombre, String apellido, String contraseña) {
        if (rut == null || rut.isEmpty()) {
            throw new IllegalArgumentException("RUT no válido");
        }
        this.rut = rut;

        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Nombre no válido");
        }
        this.nombre = nombre;

        if (apellido == null || apellido.isEmpty()) {
            throw new IllegalArgumentException("Apellido no válido");
        }
        this.apellido = apellido;

        if (contraseña == null || contraseña.isEmpty()) {
            throw new IllegalArgumentException("Contraseña no válida");
        }
        this.contraseña = contraseña;
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
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contraseña La contraseña del usuario.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
