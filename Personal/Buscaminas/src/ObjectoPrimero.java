
public class ObjectoPrimero {

  public static void main(String[] args) { 
    
    //String cadena = new String();
    //cadena.length();
    //cadena.charAt(1); Pide caracteres y esto se le llama parametros,,
    //Hay acciones que tienen muchos parametros, por ende puede ser llamado multiples
    //veces. Se usan segun su orden y segun el orden tienen un significado muy importante
    //Solo se puede devolver uno en casos x y debes de tener cuidado
   
    //empieza a contar en cero
    //int a = 1;
    //int b = 3;
    //cadena.charAt(a + b);
    //cadena.charAt((int)3.5);
    
    //trozo de cadena grande, empezando por 1 dame 2
    //cadena.substring(1, 2);
 String cadena = "Hola Caracola";
 //Solo con string se puede quitar el new
    String otraCadena = cadena.substring(0, 7).substring(0, 4);
    String otraCadenaMas = otraCadena;
    //String es una clase inmutable, su estado nunca cambia, es intocable todo pro
    System.out.printf("El trozo es %s%n", otraCadenaMas);
    
    //La interfaz de un objeto es la wea publica que presenta al exterior, por ejemplo, atributos etc.
    //Esta prohibido hacer un valor publico, se usa los metodos o acciones de acceso que se utilizan para modificar
    //un valor de un atributo
    //a.nopmbre = "hola"; no es good idea porque va a valer verga
    //Se debe poner, a.cambiarNombre ("___"); control mas fino para leerlo pero no cambiar, es more cool
    //cuando hay que cambiar un atributo te dice setAtributo, es un metodo o una opcion para cambiar este metodo o atributo.
    //y para leerlo se usa getAtributo y no lleva parametro y es mas que nada para obtencion
    //En caso de lo que devuelva sea un booleano es isAtributo , costumbre mistica de años
    
  }
  
}
