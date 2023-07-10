package Model;

import Model.Libro;
import Model.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    /**
     * Lee el archivo de libros y retorna una lista de objetos Libro.
     *
     * @return La lista de libros leídos del archivo.
     */
    public static List<Libro> leerArchivoLibros() {
        List<Libro> libros = new ArrayList<>();

        // Leer el archivo "libros.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("libros.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] chain = line.split(",");
                String isbn = chain[0];
                String title = chain[1];
                String author = chain[2];
                String category = chain[3];
                int copies = Integer.parseInt(chain[4]);
                int price = Integer.parseInt(chain[5]);


                Libro libro = new Libro(isbn,title,author,category,copies,price);
                libros.add(libro);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return libros;
    }

    /**
     * Lee el archivo de usuarios y retorna una lista de objetos Usuario.
     *
     * @return La lista de usuarios leídos del archivo.
     */
    public static List<Usuario> leerArchivoUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        // Leer el archivo "usuarios.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] chain = line.split(",");
                String rut = chain[0];
                String name = chain[1];
                String lastname = chain[2];
                String password = chain[3];

                Usuario usuario = new Usuario(rut, name, lastname, password);
                usuarios.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return usuarios;
    }
    /**
     * Lee el archivo "registro.txt" y retorna una lista de objetos Registro.
     *
     * @return La lista de registros leídos del archivo.
     */
    public static List<Registro> leerArchivosRegistro() {
        List<Registro> registros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("registro.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String rutVendedor = data[0];
                String nombre = data[1];
                String apellido = data[2];
                String isbnLibro = data[3];
                String nombreLibro = data[4];
                String tipoTransaccion = data[5];

                Registro registro = new Registro(rutVendedor, nombre, apellido, isbnLibro, nombreLibro, tipoTransaccion);
                registros.add(registro);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de registros: " + e.getMessage());
        }
        return registros;
    }

    /**
     * Registra los registros en el archivo "registro.txt".
     *
     * @param registros La lista de registros a registrar.
     */
    public static void registrarRegistros(List<Registro> registros) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("registro.txt", true))) {
            for (Registro registro : registros) {
                String linea = registro.getRut() + "," +
                        registro.getNombre() + "," +
                        registro.getApellido() + "," +
                        registro.getIsbn() + "," +
                        registro.getNombreLibro() + "," +
                        registro.getTipoTransaccion();
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al registrar los registros: " + e.getMessage());
        }
    }
}
