import es.iespablopicasso.programacion.unidad02.actividad0201.GranHermano;

public class Actividad204 {

  public static void main(String[] args) {
   
    GranHermano hermano1 = new GranHermano(12);
    GranHermano hermano2 = new GranHermano(12);
    GranHermano hermano3 = new GranHermano(12);
    GranHermano hermano4 = new GranHermano(12);
    GranHermano hermano5 = new GranHermano(12);
    GranHermano hermano6 = new GranHermano(12);
    GranHermano hermano7 = new GranHermano(12);
    
    int numeroObjeto = hermano1.getEdad();
    
    int objetos1 = GranHermano.getNumeroObjetosCreados();
    
    System.out.printf("Su objeto es %d y su edad es %d%n", objetos1, numeroObjeto);
    
      new GranHermano(12);
      new GranHermano(12);
      new GranHermano(12);
      new GranHermano(12);
      new GranHermano(12);
      new GranHermano(12);
      new GranHermano(12);
    
    int objetos2 = GranHermano.getNumeroObjetosCreados();
    
    System.out.printf("Su objeto es %d", objetos2);
    
  }
}
