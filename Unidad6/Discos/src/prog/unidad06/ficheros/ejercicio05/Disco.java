package prog.unidad06.ficheros.ejercicio05;

/**
 * Disco musical
 */
public class Disco {

  // Atributos
  // Titulo
  private String titulo;
  // Artista
  private String artista;
  // Año de publicación
  private int anyoPublicacion;
  // Precio
  private double precio;
  // En CD?
  private boolean cd;

  /**
   * Constructor con toda la información del disco
   * @param titulo Título del disco. No puede ser null ni vacío.
   * @param artista Artista del disco. No puede ser null ni vacío
   * @param anyoPublicacion Año de publiación. Positivo o cero
   * @param precio Precio del disco. Positivo o cero
   * @param cd Indica si el disco está publicado en CD o no
   * @throws IllegalArgumentException Si algún parámetro no es correcto
   */
  public Disco(String titulo, String artista, int anyoPublicacion, double precio, boolean cd) {
    setTitulo(titulo);
    setArtista(artista);
    setAnyoPublicacion(anyoPublicacion);
    setPrecio(precio);
    setCd(cd);
  }

  /**
   * Obtiene el título
   * @return Título del disco
   */
  public String getTitulo() {
    return titulo;
  }

  /**
   * Obtiene el artista
   * @return Artista del libro
   */
  public String getArtista() {
    return artista;
  }

  /**
   * Obtiene el año de publicación del libro
   * @return Año de publicación
   */
  public int getAnyoPublicacion() {
    return anyoPublicacion;
  }

  /**
   * Obtiene el precio del libro
   * @return Precio
   */
  public double getPrecio() {
    return precio;
  }

  /**
   * Obtiene si el disco es un CD o no
   * @return true si el disco es CD, false si no lo es
   */
  public boolean isCd() {
    return cd;
  }
  
  /**
   * Obtiene la representación en cadena del disco
   * @return Información del disco en una cadena
   */
  public String toString() {
    return String.format("Titulo: \"%s\", Artista: \"%s\", " + 
      "Año de Publicación: %d, Precio: %.2f, ¿Formato CD?: %s"
      , titulo, artista, anyoPublicacion, precio, cd ? "si" : "no");
  }

  /**
   * Modifica el precio 
   * @param precio Nuevo precio. Debe ser positivo o cero
   * @throws IllegalArgumentException Si no es válido
   */
  public void setPrecio(double precio) {
    if (precio >= 0) {
      this.precio = precio;
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Modifica el titulo del disco
   * @param titulo Nuevo titulo. No puede ser null o vacío
   * @throws NullPointerException Si es null
   * @throws IllegalArgumentException Si es vacío
   */
  private void setTitulo(String titulo) {
    // SI el título no es null
    if (titulo != null) {
      // Si no está vacío
      if (!titulo.isEmpty()) {
        // Lo almacena
        this.titulo = titulo;
      } else {
        // Lanza excepcion
        throw new IllegalArgumentException("El titulo está vacío");
      }
    } else {
      throw new NullPointerException("titulo es null");
    }
  }

  /**
   * Modifica el artista del disco
   * @param artista Nuevo artista del disco. No puede ser null o vacío
   * @throws IllegalArgumentException Si es null o vacío
   */
  private void setArtista(String artista) {
    // Si el artista no es null
    if (artista != null) {
      // Y si no esta vacío
      if (!artista.isEmpty()) {
        // Lo almacena
        this.artista = artista;
      } else {
        // Si está vacío lanza excepción
        throw new IllegalArgumentException("artista está vacío");
      }
    } else {
      throw new NullPointerException("artista es null");
    }
  }

  /**
   * Modifica el año de publicación del disco
   * @param anyoPublicacion Año de publicación. Debe ser positivo o cero
   * @throws IllegalArgumentException Si no es válido
   */
  private void setAnyoPublicacion(int anyoPublicacion) {
    if (anyoPublicacion >= 0) {
      this.anyoPublicacion = anyoPublicacion;
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Modifica Si el disco es CD o no
   * @param cd true si el disco es CD y false si no lo es
   */
  private void setCd(boolean cd) {
    this.cd = cd;
  }
}
