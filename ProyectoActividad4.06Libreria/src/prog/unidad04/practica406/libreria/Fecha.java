package prog.unidad04.practica406.libreria;



import prog.unidad04.practica406.libreria.FechaException;

public class Fecha {

  // FALTAN COMENTARIOS Y SOLUCIONAR METODOS ENTREFECHA Y COMPARA
  // SE PUEDE USAR JAVA LOCAL TIME PARA ENTRE FECHA

  // Errores de metodo a parchear (Vistos en JUnit)
  // No cubre si un mes es menor a 1.
  // No cubre si un mes es mayor a 12.
  // No crea una fecha con mes 12
  // Se pueden crear anyos menores a 1900
  // Error de corchetes

  public int dia;
  public int mes;
  public int anyo;

  // Constantes.
  private static final int DIAS_POR_ANYO = 365;
  private static final int LIMITE_INFERIOR_DIA_MES = 0;
  private static final int LIMITE_SUPERIOR_MES = 13;
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

  /** Constructor */
  public Fecha(int dia, int mes, int anyo) throws FechaException {
    if (anyo >= ANYO_INICIO && mes > LIMITE_INFERIOR_DIA_MES && mes < LIMITE_SUPERIOR_MES) {

      this.anyo = anyo;
      this.mes = mes;
      this.dia = dia;

    } else {
      throw new IllegalArgumentException("Fecha invalida,introduce una fecha correcta de nuevo");
    }
  }

  /** Obtiene dia */
  public int getDia() {
    return dia;
  }

  // Este metodo es para validar si el dia es valido
  private boolean diaValido() throws FechaException {
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
    throw new FechaException("No valido");
  }

  // Metodo usado para calcular dias transcurridos
  private int numeroDeDiasMes(int mes, int anyo) {
    switch (mes) {
    case ENERO, MARZO, MAYO, JULIO, AGOSTO, OCTUBRE, DICIEMBRE -> {
      return 31;
    }
    case ABRIL, JUNIO, SEPTIEMBRE, NOVIEMBRE -> {
      return 30;
    }
    case FEBRERO -> {
      return esAnyoBisiesto(anyo) ? 29 : 28;
    }
    }
    return 0;
  }

  /** Obtiene mes */
  public int getMes(int mes) {
    return this.mesValido(mes);
  }

  // Verificar si es el mes es valido.
  private int mesValido(int mes) {
    if (mes > 0 && mes < 12) {
      return mes;
    } else {
      return 0;
    }
  }

  /** Obtiene anyo */
  public int getAnyo() {
    return anyo;
  }

  /** Calcula dias transcurridos */

  public long diasTranscurridos() {
    int cantidadBisiestos = 0;
    int diasPorMes = 0;
    // Aca contas los años bisiestos desde el año de inicio hasta el actual
    for (int anyoTemporal = ANYO_INICIO; anyoTemporal < anyo; anyoTemporal++) {
      if (esAnyoBisiesto(anyoTemporal)) {
        cantidadBisiestos++;
      }
    }
    // Se suma los días de los meses completos hasta el mes anterior
    for (int mesTemporal = 1; mesTemporal < mes; mesTemporal++) {
      diasPorMes += numeroDeDiasMes(mesTemporal, anyo);
    }
    // Sumamos los días del mes actual
    diasPorMes += dia;
    // Calculo final
    return (cantidadBisiestos + (anyo - ANYO_INICIO) * DIAS_POR_ANYO) + diasPorMes;
  }

  /** Verifica si es bisiesto */
  public boolean esBisiesto(boolean valor) {
    if ((anyo % 400 == 0) || ((anyo % 4 == 0) && (anyo % 100 != 0))) {
      return true;
    } else {
      return false;
    }
  }

  private boolean esAnyoBisiesto(int anyo) {
    if ((anyo % 400 == 0) || ((anyo % 4 == 0) && (anyo % 100 != 0))) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Calculas dias entre
   * 
   * @throws FechaException
   */
  public long diasEntre(Fecha fecha) throws FechaException {
    // Verificamos si la fecha dada es mayor a la anterior
    if (fecha.comparaFechas(this)) {
      throw new FechaException("La fecha proporcionada es anterior a esta fecha.");
    }
    // Calculo la diferencia de fechas
    long diasEntre = fecha.diasTranscurridos() - this.diasTranscurridos();
    return diasEntre;
  }

//Este método compara la fecha actual (this) con otra fecha proporcionada
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

  /** Compara */
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

  public String toString() {
    return getDia() + " de " + mesToString() + " de " + getAnyo();
  }
}
