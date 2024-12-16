package clases;



import clases.FechaException;


public class Fecha {

  public int dia;
  public int mes;
  public int anyo;

  // Constantes.
  private static final int DIAS_POR_ANYO = 365;
  private static final int LIMITE_INFERIOR_DIA_MES = 1;
  private static final int LIMITE_SUPERIOR_MES = 12;
  private static final int ANYO_INICIO = 1900;
  private static final int ENERO = 1;
  private static final int FEBRERO = 2;
  private static final int MARZO = 3;
  private static final int ABRIL = 4;
  private static final int MAYO = 5;
  private static final int JUNIO = 6;
  private static final int JULIO = 7;
  private static final int AGOSTO = 8;
  private static final int SEPTIEMBRE = 9;
  private static final int OCTUBRE = 10;
  private static final int NOVIEMBRE = 11;
  private static final int DICIEMBRE = 12;

  // Agregar comentarios javadoc.

  /**
   * Constructor con dia mes y año.
   *
   *@param dia Dia de la fecha. Debe valer entre 1 y la cantidad de días del mes. Tiene en cuenta los años bisiestos.
   *@param mes Mes de la fecha. Debe valer entre 1 y 12.
   *@param anyo Año de la fecha. Debe ser mayor o igual a 1900.
   *@throws IllegalArgumentException Si los parámetros no se corresponden con una fecha válida.
   */
  public Fecha(int dia, int mes, int anyo) throws FechaException {
    if (!(anyo >= ANYO_INICIO && mes >= LIMITE_INFERIOR_DIA_MES && mes <= LIMITE_SUPERIOR_MES
        && diaValido(dia, mes, anyo))) {

      throw new IllegalArgumentException("La fecha introducida no es valida. Revise los valores e intentelo de nuevo");
    }

    this.anyo = anyo;
    this.mes = mes;
    this.dia = dia;
  }
  /**
   * Obtiene el día de la fecha
   * 
   * @return Dia de la fecha
   */
  public int getDia() {
    return dia;
  }
  /**
   * Verifica si el dia es valido
   * 
   *  
   * @return devuelve true si lo es, y devuelve false si no.
   */
  private boolean diaValido(int dia, int mes, int anyo) {
    switch (mes) {
    case ENERO, MARZO, MAYO, JULIO, AGOSTO, OCTUBRE, DICIEMBRE -> {
      return (dia < 0 && dia > 31);
    }
    case ABRIL, JUNIO, SEPTIEMBRE, NOVIEMBRE -> {
      return (dia < 0 && dia > 30);
    }
    case FEBRERO -> {
      if ((anyo % 400 == 0) || ((anyo % 4 == 0) && (anyo % 100 != 0))) {
        return (dia < 0 && dia > 29);
      } else {
        return (dia < 0 && dia > 28);
      }
    }
    }
    return true;
  }
  /**
   *  Metodo usado para calcular dias transcurridos
   * 
   * @return Dia valido por mes
   */
  private int numeroDeDiasMes(int mes) {
    int diasPorMes = 0;
    // Debo descontar -1 por enero
    switch (mes - 1) {

    case NOVIEMBRE:
      diasPorMes += 30;
    case OCTUBRE:
      diasPorMes += 31;
    case SEPTIEMBRE:
      diasPorMes += 30;
    case AGOSTO:
      diasPorMes += 31;
    case JULIO:
      diasPorMes += 31;
    case JUNIO:
      diasPorMes += 30;
    case MAYO:
      diasPorMes += 31;
    case ABRIL:
      diasPorMes += 30;
    case MARZO:
      diasPorMes += 31;
    case FEBRERO:
      diasPorMes += 28;
    case ENERO:
      diasPorMes += 31;
    }
    return diasPorMes;

  }

  /**
   * Obtiene el mes de la fecha
   * 
   * @return Mes de la fecha
   */
  public int getMes() {
    return this.mesValido(mes);
  }
  /**
   * Verificar si es el mes es valido.
   * 
   * @return Mes de la fecha
   */
  private int mesValido(int mes) {
    if (mes < 0 && mes > 12) {
      return 0;
    } else {
      return mes;
    }
  }

  /**
   * Obtiene el año de la fecha
   * 
   * @return Año de la fecha
   */
  public int getAnyo() {
    return anyo;
  }

  /**
   * Obtiene el número de días transcurridos entre esta fecha y la fecha de inicio del calendario (1/1/1900)
   * 
   * @return Número de días transcurridos entre esta fecha y la fecha de inicio del calendario
   */
  public long diasTranscurridos() {

    int cantidadBisiestos = 0;

    // Hago un bucle para comprobar la cantidad de años bisiestos que hay entre la
    // fecha inicial hasta la fecha del objeto, lo que suma un dia por cada año
    // bisiesto.
    for (int anyoTemporal = ANYO_INICIO; anyoTemporal <= anyo; anyoTemporal++) {

      if (esAnyoBisiesto(anyoTemporal) && (mes > 2 || anyoTemporal != anyo)) {
        cantidadBisiestos++;
      }
    }
    // Uso mi metodo privado
    int diasPorMes = numeroDeDiasMes(mes);

    return (cantidadBisiestos + (anyo - ANYO_INICIO) * DIAS_POR_ANYO) + diasPorMes + (dia - 1);
  }

  /**
   * Devuelve si el año es bisiesto o no
   *  
   * @return true si el año es bisiesto, false en caso contrario
   *  */
  public boolean esBisiesto(boolean valor) {
    if ((anyo % 400 == 0) || ((anyo % 4 == 0) && (anyo % 100 != 0))) {
      return true;
    } else {
      return false;
    }
  }
  /**
   * Devuelve si el año es bisiesto o no, pero usa enteros
   *  
   * @return true si el año es bisiesto, false en caso contrario
   *  */
  private boolean esAnyoBisiesto(int anyo) {
    if ((anyo % 400 == 0) || ((anyo % 4 == 0) && (anyo % 100 != 0))) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Obtiene el número de días transcurridos entre esta fecha y otra posterior que se proporciona.
   * @param fecha - Otra fecha posterior a ésta
   * @return Número de días transcurridos entre esta fecha y la proporcionada
   * @throws FechaException
   */
  public long diasEntre(Fecha fecha) throws FechaException {
    // Verificamos si la fecha dada es mayor a la anterior
    if (fecha.comparaFechas(this)) {
      throw new FechaException("La fecha proporcionada es superior a la actual.");
    }
    // Calculo la diferencia de fechas
    long diasEntre = fecha.diasTranscurridos() - this.diasTranscurridos();
    return diasEntre;
  }

  /**
   * Este método compara fecha con otra fecha proporcionada
   *  
   * @return devuelve en boolean segun si es mayor, menor  o igual
   *  */
  private boolean comparaFechas(Fecha fecha) {
    // Comparar el año de ambas fechas
    if (this.anyo < fecha.anyo) {
      return true; // this es anterior a fecha
    } else if (this.anyo == fecha.anyo) {
      // Si los años son iguales, comparar el mes
      if (this.mes < fecha.mes) {
        return true; // this es anterior a fecha
      } else if (this.mes == fecha.mes) {
        // Si los meses son iguales, comparar el día
        return this.dia < fecha.dia; // Retorna true si this es anterior
      }
    }
    // Si no se cumple ninguna de las condiciones anteriores, this no es anterior a
    // fecha
    return false;
  }

  /**
   * Este método compara fecha con otra fecha proporcionada
   *  
   * @return Menor que 0 si esta fecha es anterior a la otra, 0 si las dos fechas son iguales y mayor que cero si esta fecha es posterior a la otra
   *  */
  public int compara(Fecha fecha) {
    int resultado = 0;

    // Comparar el año de ambas fechas
    if (this.anyo < fecha.anyo) {
      return -1; // this es menor que fecha
    } else if (this.anyo > fecha.anyo) {
      return 1; // this es mayor que fecha
    } else {
      // Si los años son iguales, comparar el mes
      if (this.mes < fecha.mes) {
        return -1; // this es menor que fecha
      } else if (this.mes > fecha.mes) {
        return 1; // this es mayor que fecha
      } else {
        // Si los meses son iguales, comparar el día
        if (this.dia < fecha.dia) {
          return -1; // this es menor que fecha
        } else if (this.dia > fecha.dia) {
          return 1; // this es mayor que fecha
        } else {
          // Si los días son iguales, las fechas son iguales
          return 0; // this es igual a fecha
        }
      }
    }
  }
  /**
   * Este método convierte mes en cadena
   *  
   * @return devuelve segun el mes su nombre correspondiente
   *  */
  private String mesToString() {
    switch (mes) {
    case ENERO -> {
      return "enero";
    }
    case FEBRERO -> {
      return "febrero";
    }
    case MARZO -> {
      return "marzo";
    }
    case ABRIL -> {
      return "abril";
    }
    case MAYO -> {
      return "mayo";
    }
    case JUNIO -> {
      return "junio";
    }
    case JULIO -> {
      return "julio";
    }
    case AGOSTO -> {
      return "agosto";
    }
    case SEPTIEMBRE -> {
      return "septiembre";
    }
    case OCTUBRE -> {
      return "octubre";
    }
    case NOVIEMBRE -> {
      return "noviembre";
    }
    case DICIEMBRE -> {
      return "diciembre";
    }
    }
    return null;
  }
  /**
   * Obtiene una representación de la fecha en formato texto El formato es DD de MMMMM de AAAA donde DD es el día del mes (en número), MMMM es el mes (en letra y minúsculas) y AAAA es el año (en número).
   */
  public String toString() {
    return getDia() + " de " + mesToString() + " de " + getAnyo();
  }

}
