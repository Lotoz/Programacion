package prog.unidad05.arraysobjetos;

import java.lang.reflect.Constructor;

public class Libro {

  private String titulo;
  private String autor;
  private int anyoPublicacion;

  public Libro(String titulo, String autor, int anyoPublicacion) {

    this.titulo = titulo;
    this.autor = autor;
    this.anyoPublicacion = anyoPublicacion;

  }

  public String getTitulo() {

    return titulo;
  }

  public String getAutor() {

    return autor;
  }

  public int getAnyoPublicacion() {

    return anyoPublicacion;
  }

  public String toString() {

    return "Titulo: " +  getTitulo() + ", Autor: " +  getAutor()  + ",  Año Publicación: " + getAnyoPublicacion();
  }
}
