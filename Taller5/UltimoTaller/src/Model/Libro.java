package Model;

import java.util.List;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private String categoria;
    private int cantidadPaginas;
    private int stock;
    /**
     * Constructor de la clase Libro.
     *
     * @param isbn            El ISBN del libro.
     * @param titulo          El título del libro.
     * @param autor           El autor del libro.
     * @param categoria       La categoría del libro.
     * @param cantidadPaginas La cantidad de páginas del libro.
     * @param stock           El stock del libro.
     * @throws IllegalArgumentException si alguno de los parámetros no es válido.
     */
    public Libro(String isbn, String titulo, String autor, String categoria, int cantidadPaginas, int stock) {
        if (isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("ISBN no válido");
        }
        this.isbn = isbn;

        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("Título no válido");
        }
        this.titulo = titulo;

        if (autor == null || autor.isEmpty()) {
            throw new IllegalArgumentException("Autor no válido");
        }
        this.autor = autor;

        if (categoria == null || categoria.isEmpty()) {
            throw new IllegalArgumentException("Categoría no válida");
        }
        this.categoria = categoria;

        if (cantidadPaginas < 0) {
            throw new IllegalArgumentException("Cantidad de páginas no válida");
        }
        this.cantidadPaginas = cantidadPaginas;

        if (stock < 0) {
            throw new IllegalArgumentException("Stock no válido");
        }
        this.stock = stock;
    }

    /**
     * Método getter para obtener el ISBN del libro.
     *
     * @return El ISBN del libro.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Método setter para establecer el ISBN del libro.
     *
     * @param isbn El ISBN del libro.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Método getter para obtener el título del libro.
     *
     * @return El título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Método setter para establecer el título del libro.
     *
     * @param titulo El título del libro.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Método getter para obtener el autor del libro.
     *
     * @return El autor del libro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Método setter para establecer el autor del libro.
     *
     * @param autor El autor del libro.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Método getter para obtener la categoría del libro.
     *
     * @return La categoría del libro.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Método setter para establecer la categoría del libro.
     *
     * @param categoria La categoría del libro.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Método getter para obtener la cantidad de páginas del libro.
     *
     * @return La cantidad de páginas del libro.
     */
    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    /**
     * Método setter para establecer la cantidad de páginas del libro.
     *
     * @param cantidadPaginas La cantidad de páginas del libro.
     */
    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    /**
     * Método getter para obtener el stock del libro.
     *
     * @return El stock del libro.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Método setter para establecer el stock del libro.
     *
     * @param stock El stock del libro.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Método para disminuir el stock del libro cuando se devuelve.
     */
    public void stockBajo() {
      stock--;
    }
    /**
     * Método para incrementar el stock del libro cuando se devuelve.
     */
    public void incrementarStock() {
        stock++;
    }
}
