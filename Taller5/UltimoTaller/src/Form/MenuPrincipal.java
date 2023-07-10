package Form;

import Model.Libro;
import Model.Registro;
import Model.Usuario;
import Model.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MenuPrincipal extends JFrame{
    private final List<Libro> libros;
    private List<Usuario> usuarios;
     private JButton buscarLibroButton;
    private JButton devolverLibroButton;
    private JButton agregarLibroNuevoButton;
    private JButton prestarLibroButton;
    private JPanel menu;
    private JButton cerrarSesion;
    private JButton verPerfilButton;

    private List<Registro> registro;
    private Usuario usuarioActual;

    /**
     * Crea una instancia de la clase MenuPrincipal.
     *
     * @param usuarios La lista de usuarios.
     * @param libros   La lista de libros.
     */
    public MenuPrincipal(List<Usuario> usuarios, List<Libro> libros){
        this.menu = new JPanel();
        List<Registro> registros = Utils.leerArchivosRegistro();
        this.registro = registros;
        setTitle("Menú de bibliotech");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        

        // Configuración de los botones
        buscarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarLibro();
            }
        });

        devolverLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                devolverLibro();
            }
        });

        agregarLibroNuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });

        prestarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prestarLibro();
            }
        });

        cerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPerfil();
            }
        });
        verPerfilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verPerfil();
            }
        });
        
        menu.setLayout(new GridLayout(6, 1));
        menu.add(verPerfilButton);
        menu.add(buscarLibroButton);
        menu.add(devolverLibroButton);
        menu.add(agregarLibroNuevoButton);
        menu.add(prestarLibroButton);
        menu.add(cerrarSesion);



        // Agregar el panel al contenido de la ventana
        getContentPane().add(menu);

        // Cargar los libros desde el archivo
        if (libros == null) {
            libros = Utils.leerArchivoLibros();
        }

        // Asignar la lista de libros actualizada
        this.libros = libros;

        // Mostrar la ventana
        setVisible(true);
    }

    /**
     * Muestra la ventana del perfil del usuario actual.
     */
    private void verPerfil() {
        List<Registro> registros = obtenerRegistrosUsuario();
        VerPerfil ventanaPerfil = new VerPerfil(registros, this);
        ventanaPerfil.setVisible(true);
        setVisible(false);
    }
    /**
     * Obtiene los registros asociados al usuario actual.
     *
     * @return La lista de registros del usuario actual.
     */
    private List<Registro> obtenerRegistrosUsuario() {
        List<Registro> registrosUsuario = new ArrayList<>();
        List<Registro> todosLosRegistros = Utils.leerArchivosRegistro();
        for (Registro registro : todosLosRegistros) {
            if (registro.getNombre().equals(usuarioActual)) {
                registrosUsuario.add(registro);
            }
        }
        return registrosUsuario;
    }

    /**
     * Cierra la ventana del menu y finaliza el programa.
     */
    private void cerrarPerfil() {
        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas cerrar sesión?", "Cerrando sesión", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Registrar los registros en el archivo
            Utils.registrarRegistros(registro);
            System.exit(0);
        }
    }

    /**
     * Método para buscar un libro.
     * Abre la ventana de búsqueda de libros y cierra la ventana actual de menú principal.
     */
    private void buscarLibro() {
        MenuPrincipal menuPrincipal = this;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BuscarLibro ventanaBusqueda = new BuscarLibro(libros,menuPrincipal);
                ventanaBusqueda.setVisible(true);
                dispose();
            }
        });
    }
    /**
     * Método para devolver un libro.
     * Solicita el ISBN del libro a devolver y realiza la devolución si es posible.
     */
    private void devolverLibro() {
        String isbn = JOptionPane.showInputDialog(this, "Ingrese el ISBN del libro a devolver:");


        boolean devolucionExitosa = devolverLibroPorISBN(isbn);

        if (devolucionExitosa) {
            JOptionPane.showMessageDialog(this, "Libro devuelto exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo realizar la devolución del libro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * Método para devolver un libro por su ISBN.
     *
     * @param isbn El ISBN del libro a devolver.
     * @return true si la devolución es exitosa, false de lo contrario.
     */
    private boolean devolverLibroPorISBN(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                if (libro.getStock() > 0) {
                    libro.incrementarStock();
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Método para agregar un nuevo libro.
     * Solicita los datos del libro y lo agrega a la lista de libros si es válido.
     */
    private void agregarLibro() {
        String isbn = JOptionPane.showInputDialog(this, "Ingrese el ISBN del libro:");
        String titulo = JOptionPane.showInputDialog(this, "Ingrese el título del libro:");
        String autor = JOptionPane.showInputDialog(this, "Ingrese el autor del libro:");
        String categoria = JOptionPane.showInputDialog(this, "Ingrese la categoría del libro:");
        int cantidadPaginas = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la cantidad de páginas del libro:"));
        int stock = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el stock del libro:"));

        // Crear un objeto Libro con los datos ingresados
        Libro nuevoLibro = new Libro(isbn, titulo, autor, categoria, cantidadPaginas, stock);

        // Verificar si el libro ya está registrado
        if (buscarLibroPorISBN(isbn) != null) {
            JOptionPane.showMessageDialog(this, "El libro ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Agregar el nuevo libro a la lista de libros
            libros.add(nuevoLibro);
            JOptionPane.showMessageDialog(this, "Libro agregado exitosamente.");
        }
    }
    /**
     * Método para buscar un libro por su ISBN.
     *
     * @param isbn El ISBN del libro a buscar.
     * @return El objeto Libro si se encuentra, o null si no se encuentra.
     */
    private Libro buscarLibroPorISBN(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro; // Libro encontrado
            }
        }
        return null; // Libro no encontrado
    }
    /**
     * Método para prestar un libro.
     * Solicita el ISBN del libro a prestar y realiza el préstamo si es posible.
     */
    private void prestarLibro() {
        String isbn = JOptionPane.showInputDialog(this, "Ingrese el ISBN del libro a prestar:");


        boolean prestamoExitoso = prestarLibroPorISBN(isbn);

        if (prestamoExitoso) {
            JOptionPane.showMessageDialog(this, "Libro prestado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo realizar el préstamo del libro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * Método para prestar un libro por su ISBN.
     *
     * @param isbn El ISBN del libro a prestar.
     * @return true si el préstamo es exitoso, false de lo contrario.
     */
    private boolean prestarLibroPorISBN(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                if (libro.getStock() > 0) {
                    libro.stockBajo();
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}

