package prog.unidad05.arraysobjetos;

import java.lang.reflect.Constructor;

/**
 * La clase libro representa un libro.
 */
public class Libro {

  private String titulo;
  private String autor;
  private int anyo;

  public Libro(String titulo, String autor, int anyo) {

    this.titulo = titulo;
    this.autor = autor;
    this.anyo = anyo;

  }

  public String getTitulo() {

    return titulo;
  }

  public String getAutor() {

    return autor;
  }

  public int getAnyoPublicacion() {

    return anyo;
  }

  public String toString() {

    return "Titulo: " +  getTitulo() + ", Autor: " +  getAutor()  + ",  Año Publicación: " + getAnyoPublicacion();
  }
}
