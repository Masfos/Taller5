package Form;

import Model.Libro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BuscarLibro extends JFrame {

    private JPanel panel;
    private JLabel isbn;
    private JTextField buscarISBN;
    private JButton buscar;
    private JButton volver;
    private JList list1;
    private List<Libro> libros;
    private MenuPrincipal menuPrincipal;
    /**
     * Constructor de la clase BuscarLibro.
     *
     * @param libros         La lista de libros disponibles.
     * @param menuPrincipal  La instancia de la clase MenuPrincipal.
     */
    public BuscarLibro(List<Libro> libros, MenuPrincipal menuPrincipal) {
        this.libros = libros;
        this.menuPrincipal = menuPrincipal;

        setTitle("Menú de bibliotech");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        isbn = new JLabel("ISBN:");
        buscarISBN = new JTextField();
        buscar = new JButton("Buscar");
        volver = new JButton("Volver al menu principal");
        list1 = new JList<>();

        buscarISBN.setPreferredSize(new Dimension(200, buscarISBN.getPreferredSize().height));

        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarLibro();
            }
        });

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverAlMenuPrincipal();
            }
        });

        JPanel topPanel = new JPanel();
        topPanel.add(isbn);
        topPanel.add(buscarISBN);
        topPanel.add(buscar);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(new JScrollPane(list1), BorderLayout.CENTER);
        bottomPanel.add(volver, BorderLayout.SOUTH);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(bottomPanel, BorderLayout.CENTER);

        getContentPane().add(panel);

        setVisible(true);
    }

    /** Método para buscar un libro por su ISBN
     *
     */
    private void buscarLibro() {
        String isbn = buscarISBN.getText();
        Libro libroEncontrado = buscarLibroPorISBN(libros, isbn);

        if (libroEncontrado != null) {
            DefaultListModel<String> model = new DefaultListModel<>();
            model.addElement("Título: " + libroEncontrado.getTitulo());
            model.addElement("Autor: " + libroEncontrado.getAutor());
            model.addElement("Categoría: " + libroEncontrado.getCategoria());
            model.addElement("Stock: " + libroEncontrado.getStock());
            list1.setModel(model);
        } else {
            JOptionPane.showMessageDialog(BuscarLibro.this, "Libro no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * Método para volver al menú principal.
     */
    private void volverAlMenuPrincipal() {
        menuPrincipal.setVisible(true);
        dispose();
    }
    /**
     * Método para buscar un libro por su ISBN.
     *
     * @param libros  La lista de libros donde buscar.
     * @param isbn    El ISBN del libro a buscar.
     * @return        El libro encontrado, o null si no se encontró.
     */
    private Libro buscarLibroPorISBN(List<Libro> libros, String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }
}
