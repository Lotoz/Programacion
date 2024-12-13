package prog.unidad04.practica406.libreria;

import prog.unidad04.practica406.libreria.FechaException;

public class Fecha {

  // FALTAN COMENTARIOS Y SOLUCIONAR METODOS ENTREFECHA Y COMPARA
  // SE PUEDE USAR JAVA LOCAL TIME PARA ENTRE FECHA

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

  /** Constructor */
  public Fecha(int dia, int mes, int anyo) throws FechaException {
    if (anyo >= ANYO_INICIO && mes >= LIMITE_INFERIOR_DIA_MES && mes <= LIMITE_SUPERIOR_MES
        && diaFechaValida(dia, mes, anyo)) {

      this.anyo = anyo;
      this.mes = mes;
      this.dia = dia;

    } else {
      throw new FechaException("La fecha no es correcta.");
    }
  }

  /** Obtiene dia */
  public int getDia() {
    return dia;
  }

  private boolean diaFechaValida(int dia, int mes, int anyo) {
    // Verificar si el mes es válido
    if (this.mesValido(mes) == 0) {
      return false;
    }
    // Declarar la variable de los dias
    int dias = 0;
    switch (mes) {
    case ENERO:
    case MARZO:
    case MAYO:
    case JULIO:
    case AGOSTO:
    case OCTUBRE:
    case DICIEMBRE:
      dias = 31;
      break;
    case ABRIL:
    case JUNIO:
    case SEPTIEMBRE:
    case NOVIEMBRE:
      dias = 30;
      break;
    case FEBRERO:
      dias = esBisiesto(anyo) ? 29 : 28;
      break;
    }

    // Verificar si el día es válido
    return dia >= LIMITE_INFERIOR_DIA_MES && dia <= dias;
  }

  // Metodo usado para calcular dias transcurridos
  private int numeroDeDiasMes(int mes, int anyo) {
    switch (mes) {
    case ENERO:
    case MARZO:
    case MAYO:
    case JULIO:
    case AGOSTO:
    case OCTUBRE:
    case DICIEMBRE:
      return 31;
    case ABRIL:
    case JUNIO:
    case SEPTIEMBRE:
    case NOVIEMBRE:
      return 30;
    case FEBRERO:
      return esBisiesto(anyo) ? 29 : 28;
    }
    return 0;
  }

  /** Obtiene mes */
  public int getMes() {
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
    // Se puede usar la fecha actual y se debe usar, reparar luego. Reparar las
    // clases anexo a esta.
    int cantidadBisiestos = 0;
    // Debe arrancar en -1, debido a que no se cuenta enero, ya que es el primer mes
    // y no va a ver cambios. Por ende, inicializamos la variable en negativo.
    int diasPorMes = -1;
    // Aca contas los años bisiestos desde el año de inicio hasta el actual
    for (int anyoTemporal = ANYO_INICIO; anyoTemporal < anyo; anyoTemporal++) {
      if (esBisiesto(anyoTemporal)) {
        cantidadBisiestos++;
      }
    }
    // Se suma los días de los meses completos hasta el mes anterior
    for (int mesTemporal = 0; mesTemporal < mes; mesTemporal++) {
      diasPorMes += numeroDeDiasMes(mesTemporal, anyo);
    }
    // Sumamos los días del mes actual
    diasPorMes += dia;
    // Calculo final
    return (cantidadBisiestos + (anyo - ANYO_INICIO) * DIAS_POR_ANYO) + diasPorMes;
  }

  /** Verifica si es bisiesto */
  public boolean esBisiesto(int anyo) {
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
//Este metodo es para dias entre, ya que controla la excepcion si ponen una fecha anterior.
  private boolean comparaFechas(Fecha fecha) {
    if (this.anyo < fecha.anyo) {
      return true;
    } else if (this.anyo == fecha.anyo) {
      if (this.mes < fecha.mes) {
        return true;
      } else if (this.mes == fecha.mes) {
        return this.dia < fecha.dia;
      }
    }
    return false;
  }

  /** Compara */
  public int compara(Fecha fecha) {
    return 0;

  }
  public String toString() {

    return getDia() + " de " + mesToString() + " de " + getAnyo();
  }

  protected String fechaDeMatriculacion(Fecha fecha) {

    return toString();

  }

  private String mesToString() {
    switch (mes) {
    case ENERO:
      return "enero";
    case FEBRERO:
      return "febrero";
    case MARZO:
      return "marzo";
    case ABRIL:
      return "abril";
    case MAYO:
      return "mayo";
    case JUNIO:
      return "junio";
    case JULIO:
      return "julio";
    case AGOSTO:
      return "agosto";
    case SEPTIEMBRE:
      return "septiembre";
    case OCTUBRE:
      return "octubre";
    case NOVIEMBRE:
      return "noviembre";
    case DICIEMBRE:
      return "diciembre";
    }
    return null;
  }

}
