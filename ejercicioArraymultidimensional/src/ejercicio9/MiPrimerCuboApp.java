package ejercicio9;

public class MiPrimerCuboApp {
  
  public static void main(String[] args)  {
    int [][][] cubo = new int [3][4][5]; 
    
    //Primer plano. Cuadro 1
     cubo [0][0][0] = 18 ;
     cubo [0][0][2] = 74 ;
     cubo [0][0][3] = 59 ;
     cubo [0][1][1] = 74 ;
     cubo [0][3][1] = 51 ;
     cubo [0][0][2] = 36 ;
     cubo [0][2][2] = 59 ;
     cubo [0][3][2] = 85 ;
     cubo [0][0][3] = 67 ;
     cubo [0][1][3] = 6  ;
     cubo [0][3][3] = 62 ;
     cubo [0][1][4] = 40 ;
     cubo [0][2][4] = 11 ;

    //Segundo plano. Cuadro 2
     cubo [1][0][1] = 92 ;
     cubo [1][0][3] = 1  ;
     cubo [1][1][0] = 25 ;
     cubo [1][2][1] = 78 ;
     cubo [1][3][1] = 26 ;
     cubo [1][2][3] = 26 ;
     cubo [1][2][3] = 26 ;
     cubo [1][2][3] = 26 ;
  }
}
