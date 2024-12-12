package prog.unidad04.practica406.libreria;

import java.time.Year;

public class Fecha {

  public int dia;
  public int mes;
  public int anyo;
  
  //Constantes.
  private static final int DICIEMBRE = 12;
  private static final int NOVIEMBRE = 11;
  private static final int OCTUBRE = 10;
  private static final int SEPTIEMBRE = 9;
  private static final int AGOSTO = 8;
  private static final int JULIO = 7;
  private static final int JUNIO = 6;
  private static final int MAYO = 5;
  private static final int ABRIL= 4;
  private static final int MARZO = 3;
  private static final int FEBRERO = 2;
  private static final int ENERO = 1;
  
  // Agregar comentarios javadoc.
  // Esta clase es el nono de todas.
  // ESTA CLASE HEREDA DE FECHA EXCEPTION< CREAR EXCEPCION PARA CUANDO HAYA ALGO
  // INVALIDO Y COLOCARLA DONDE 0
  /** Constructor */
  public Fecha(int dia, int mes, int anyo) {
    this.dia = dia;
    this.mes = mes;
    this.anyo = anyo;
  }

  /** Obtiene dia */
  public int getDia() {
    return dia;
  }

  // metodo privado para verificar si los dias son validos.
  private boolean diasValidosPorMes() {
  return false;
  }
  //SE DEBE RETOCAR ESTOS DOS METODOS O VER SI SE HACE OTRO DIFERENTE
  //Para corroborar si los dias de ese mes entran en el mes.
  private int numeroDeDiasMes(){
    int numeroDias = 0;
        switch (mes) {
        case 1, 3, 5, 7, 8, 10, 12 -> numeroDias=31;
        case 4, 6, 9, 11 -> numeroDias=30;
        case 2 -> numeroDias = esBisiesto() == true ? getBisiestoDia() : 28;
        }
        //Agregar un if o ver como meto metodo mes valido antes del switch, si no, no funcionaria.
    return numeroDias;
}
  /** Obtiene mes */
  public int getMes() {
    return this.mesValido();
  }
  // Verificar si es el mes es valido.
  private int mesValido() {
    int mesValido = mes;
    if (mesValido > 0 && mesValido < 12) {
      return mes;
    } else {
      return 0;
    }
  }

  /** Obtiene anyo */
  public int getAnyo() {
    return anyoValido();
  }

  // Verifica si mes es valido.
  private int anyoValido() {
    int anyoValido = anyo;
    return anyoValido < 1900 ? 0 : anyo;
  }

  // metodo en duda. Revisar si es necesario.
  private int getBisiestoDia() {
    //En este metodo deberiamos agregar un dia mas al dia comun, si se cumple que es bisiesto.
    return 0;
  }

  /** Calcula dias transcurridos */
  public long diasTranscurridos() {
	  /* LocalDate fecha1=LocalDate.of(1990,8,18);
    LocalDate fecha2=LocalDate.now();
    System.out.println("fech1: "+fecha1);
    System.out.println("fech2: "+fecha2);

    int anioACT = fecha2.getYear();
    int mesACT = fecha2.getMonthValue();
    int diaACT = fecha2.getDayOfMonth();

    int resAnio = 0;

    int resDia = fecha2.getDayOfMonth() - fecha1.getDayOfMonth() + 1;
    int resMes = fecha2.getMonthValue() - fecha1.getMonthValue() -1;

    if(fecha2.getYear() > fecha1.getYear()) {
       if(fecha2.getMonthValue() == fecha1.getMonthValue()) {


                if(fecha2.getDayOfMonth() == fecha1.getDayOfMonth()) {
                    resAnio = fecha2.getYear() - fecha1.getYear();
                }
            }else {
                resAnio = fecha2.getYear() - fecha1.getYear() - 1;
            }
        }  
        y anexar a*/
    return 0;
  }

  /** Verifica si es bisiesto */
  public boolean esBisiesto() {
    int anyo = this.anyo;
    if ((anyo % 400 == 0) || ((anyo % 4 == 0) && (anyo % 100 != 0))) {
      return true;
    } else {
      return false;
    }
  }

  /** Calculas dias entre */
  public long diasEntre() {
    return 0;
    //Es una simple resta.
  }

  /** Compara */
  public int compara() {
    return 0;
    //Hacer un if, si es menor, da -1 si es igual 0 y si da mayor 1
  }

}
