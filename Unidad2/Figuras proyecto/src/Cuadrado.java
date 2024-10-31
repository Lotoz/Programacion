
public class Cuadrado {

  public static void main(String[] args) {
    
    //Invocamos el lapiz
    Lapiz lapiz = new Lapiz();
    
    //baja el lapiz
    lapiz.baja();
    
    //Desplaza el lapiz
    lapiz.desplaza(20);
    //giramos el lapiz
    lapiz.gira(90);
    
    lapiz.desplaza(20);
    
   lapiz.gira(90);
   lapiz.desplaza(20);
   lapiz.gira(90);
   lapiz.desplaza(20);
   Linea linea1 = lapiz.getTrazo(1);
  
   Linea linea2= lapiz.getTrazo(2);

   
   Linea linea3= lapiz.getTrazo(3);
 
   
   Linea linea4 = lapiz.getTrazo (4);
  
   
   //Triangulo
   lapiz.reinicia();
   //lapiz.mueve(20, 35);
   lapiz.mueve(new Punto(20, 35));
   lapiz.baja();
   lapiz.desplaza(30);
   //lapiz.gira(-60);
   lapiz.gira(120);
   lapiz.desplaza(30);
   lapiz.gira(120);
   lapiz.desplaza(30);
   
   lapiz.reinicia();
   //lapiz.mueve(20, 35);
   lapiz.mueve(new Punto(25, 45));
   lapiz.baja();
  
   //lapiz.gira(-60);
   lapiz.gira(108);
   lapiz.desplaza(20);
   lapiz.gira(108);
   lapiz.desplaza(20);
   lapiz.gira(108);
   lapiz.desplaza(20);
   lapiz.gira(108);
   lapiz.desplaza(20);
   lapiz.gira(108);
   lapiz.desplaza(20);
   
  }
}
