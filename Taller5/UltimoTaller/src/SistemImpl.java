import Form.BiblioTech;
import Model.Libro;
import Model.Registro;
import Model.Usuario;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SistemImpl implements Sistema {
    private List<Usuario> usuarios;
    private List<Libro> libros;
    private BiblioTech form;
    private List<Registro> registros;
    /**
     * Constructor de la clase SistemImpl.
     * Inicializa las listas de usuarios, libros, registros y crea una instancia de BiblioTech.
     */
    public SistemImpl() {
        this.form = new BiblioTech();
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.registros = new ArrayList<>();
    }

    /**
     * Método para iniciar el programa.
     * Crea una instancia de BiblioTech y la muestra en la interfaz gráfica.
     */
    @Override
    public void starProgram() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BiblioTech biblioTech = new BiblioTech();
                biblioTech.setVisible(true);
            }
        });
    }
}
