package Form;

import Model.Registro;
import Model.Usuario;
import Model.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VerPerfil extends JFrame{
    private JPanel perfil;
    private JList list1;
    private JButton volverMenu;
    /**
     * Crea una instancia de la clase VerPerfil.
     *
     * @param registro       La lista de registros.
     * @param menuPrincipal  La instancia de la clase MenuPrincipal.
     */
    public VerPerfil(List<Registro> registro, MenuPrincipal menuPrincipal) {
        setTitle("Perfil del usuario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        perfil = new JPanel();
        perfil.setLayout(new BorderLayout());

        DefaultListModel<String> listModel = new DefaultListModel<>();
        list1 = new JList<>(listModel);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(list1);
        perfil.add(scrollPane, BorderLayout.CENTER);

        volverMenu = new JButton("Volver al menú principal");
        volverMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPrincipal.setVisible(true);
                dispose();
            }
        });
        perfil.add(volverMenu, BorderLayout.SOUTH);

        getContentPane().add(perfil);
        String rutUsuario = "123456789";
        Usuario usuarioActual = obtenerUsuarioActual(rutUsuario);
        List<Registro> register = Utils.leerArchivosRegistro();

        for (Registro registros : registro) {
            if (registros.getRut().equals(usuarioActual.getRut())) {
                listModel.addElement("RUT: " + registros.getRut());
                listModel.addElement("Nombre: " + registros.getNombre());
                listModel.addElement("Apellido: " + registros.getApellido());
                listModel.addElement("ISBN: " + registros.getIsbn());
                listModel.addElement("Nombre del libro: " + registros.getNombreLibro());
            }
        }

        setVisible(true);
    }
    /**
     * Obtiene el usuario actual basado en el rut proporcionado.
     *
     * @param rut El rut del usuario.
     * @return El objeto Usuario correspondiente al rut proporcionado, o null si no se encuentra.
     */
    private Usuario obtenerUsuarioActual(String rut) {
        List<Usuario> usuarios = Utils.leerArchivoUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getRut().equals(rut)) {
                return usuario;
            }
        }

        return null;
    }
}
