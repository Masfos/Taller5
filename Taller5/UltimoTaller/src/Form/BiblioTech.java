package Form;

import Model.Libro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Model.Registro;
import Model.Usuario;
import Model.Utils;

public class BiblioTech extends JFrame {
    private JPasswordField password;
    private JTextField rut;
    private JButton abrir;
    private JButton cerrar;
    private JPanel login;
    private List<Usuario> usuarios;
    private List<Libro> libros;
    private List<Registro> registros;
    public BiblioTech() {
        this.usuarios = Utils.leerArchivoUsuarios();
        this.libros = Utils.leerArchivoLibros();
        this.registros = Utils.leerArchivosRegistro();
        // Configurar el botón "Abrir"
        abrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });
        // Configurar el botón "Cerrar"
        cerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPrograma();
            }
        });
        // Configurar la ventana de inicio de sesión
        add(login);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Iniciar sesión");

    }
    /**
     * Método para cerrar el programa.
     * Se muestra una confirmación al usuario antes de cerrar el programa.
     */
    private void cerrarPrograma() {
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de cerrar el programa?", "Cerrar", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            Utils.registrarRegistros(registros); //
            System.exit(0);
        }
    }


    /**
     * Método para iniciar sesión.
     * Se verifica el RUT y la contraseña ingresados.
     * Si las credenciales son válidas, se muestra el menú principal.
     * Si las credenciales son inválidas, se muestra un mensaje de error.
     */
    private void iniciarSesion() {
        String dni = rut.getText();
        String contraseña = new String(password.getPassword());

        if (dni.isEmpty() || contraseña.isEmpty()) {
            mostrarMensajeError("Debe ingresar el RUT y la contraseña.");
        } else {
            Usuario usuario = buscarUsuario(rut);
            if (usuario != null && usuario.getContraseña().equals(contraseña)) {
                // Inicio de sesión exitoso
                mostrarMenuPrincipal();
            } else {
                mostrarMensajeError("Credenciales inválidas.");
            }
        }
    }
    /**
     * Método para mostrar el menú principal.
     * Se crea una instancia de la clase MenuPrincipal y se muestra en pantalla.
     * La ventana actual de inicio de sesión se cierra.
     */
    private void mostrarMenuPrincipal() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MenuPrincipal menuPrincipal = new MenuPrincipal(usuarios, libros);
                menuPrincipal.setVisible(true);
                dispose(); // Cerrar la ventana actual de inicio de sesión
            }
        });
    }
    /**
     * Método para buscar un usuario por su RUT.
     *
     * @param rut El campo de texto que contiene el RUT del usuario.
     * @return El objeto Usuario si se encuentra, o null si no se encuentra.
     */
    private Usuario buscarUsuario(JTextField rut) {
        String rutIngresado = rut.getText();

        for (Usuario usuario : usuarios) {
            if (usuario.getRut().equals(rutIngresado)) {
                return usuario; // Usuario encontrado
            }
        }

        return null; // Usuario no encontrado
    }
    /**
     * Método para mostrar un mensaje de error.
     *
     * @param s El mensaje de error a mostrar.
     */
    private void mostrarMensajeError(String s) {
        JOptionPane.showMessageDialog(this, s, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
