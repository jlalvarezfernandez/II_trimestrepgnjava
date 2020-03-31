package excepciones;

public class Fecha {

  //definimos los atributos

  private int dia;
  private int mes;
  private int anio;



  // creamos el constructor

  public Fecha(int dia, int mes, int anio) throws ErrorFecha {
    if (fechaCorrecta(dia, mes, anio)) {
      this.dia = dia;
      this.mes = mes;
      this.anio = anio;
    }
    else {
      throw new ErrorFecha ("Error, fecha introducida incorrecta");
      //System.err.println("Fecha introducida Incorrectamente");
     // System.exit(2);

    }

  }



  // creamos los métodos setters y getters  ( modificadores y observadores) de los atributos de la clase Fecha



  public int getDia() {
    return dia;
  }



  public void setDia(int dia) throws ErrorFecha {
    if (fechaCorrecta(dia, mes, anio)) {
      this.dia = dia;
    } else {
      throw new ErrorFecha("Error, fecha introducida incorrecta");
    }
    
  }



  public int getMes() {
    return mes;
  }



  public void setMes(int mes) throws ErrorFecha {
    if (fechaCorrecta(dia, mes, anio)) {
      this.mes = mes;
    } else {
      throw new ErrorFecha("Error, fecha introducida incorrecta");
    }
    
  }



  public int getAnio() {
    return anio;
  }



  public void setAnio(int anio) throws ErrorFecha {
    if (fechaCorrecta(dia, mes, anio)) {
      this.anio = anio;
    } else {
      throw new ErrorFecha("Error, fecha introducida incorrecta");
    }
    
  }
  


  // Método toString para mostrar la fecha

  @Override
  public String toString() {
    return  dia + " DE " + nombreMes() + " DE " + anio;
  }


  /**
   * Método para mostrar el mes como cadena
   * @return  
   */

  public String nombreMes () {
    String [] meses = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO","SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};

    return meses[this.mes-1];

  }

  /**
   * Método para saber si la es fecha correcta, que devuelve si dia es mayor que 0 y el dia es menor o igual para cuando el año es bisiesto
   * @return
   */

  public boolean fechaCorrecta(int dia, int mes, int anio) {
    
    if (dia < 1 || dia > 31) {
      return false;
    }
    if (mes < 1 || mes > 12) {
      return false;
    }    if (anio < 0) {
      return false;
    }
    return dia > 0 && dia <= diasAnio(mes, anio);

  }

  /**
   * Método para  saber cuantos dias tiene un mes del año y si es un año bisiesto le sumamos a febrero 1 dia
   * @param mes
   * @param anio
   * @return
   */

  public int diasAnio(int mes, int anio) {
    int [] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    if (esBisiesto(anio)) {
      diasMes[1] = 29;
    }
    return diasMes[mes-1];

  }

  /**
   * Método para saber si el año es bisiesto
   * @param anio
   * @return
   */


  private boolean esBisiesto(int anio) {
    if ((anio % 4 == 0) && (anio % 400 == 0 || anio % 100 != 0)) {
      return true;
    }
    return false;
  }


  /**
   * 
   * @param fecha2
   * @return
   */
  public boolean igualQue(Fecha fecha2) {
    if (this.dia == fecha2.dia && this.mes == fecha2.mes && this.anio == fecha2.anio) {
      return true;
    }
    return false;
  }


  /**
   * 
   * @param fecha2
   * @return
   */
  public boolean mayorQue(Fecha fecha2) {
    if (this.dia != fecha2.dia) {
      return this.dia > fecha2.dia;
    } else if (this.mes != fecha2.mes) {
      return this.mes > fecha2.mes;
    }  else if (this.anio != fecha2.anio) {
      return this.anio > fecha2.anio;
    }
    return false;
  }


  /**
   * 
   * @param fecha2
   * @return
   */
  public boolean menorQue(Fecha fecha2) {
    if (this.dia != fecha2.dia) {
      return this.dia < fecha2.dia;
    } else if (this.mes != fecha2.mes) {
      return this.mes < fecha2.mes;
    }  else if (this.anio != fecha2.anio) {
      return this.anio < fecha2.anio;
    }
    return false;

  }

  /**
   * Método para sumar 1 dia a la fecha inicial
   * @return
   */

  public String fechaMas1Dia () {
    dia += 1;

    if (dia > diasAnio(mes, anio)) {
      dia = 1;
      mes +=1;
      if (mes > 12) {
        mes = 1;
        anio +=1;
      }
    }
    return dia + " de " + nombreMes() + " de " + anio;
  }

  /**
   * Metodo para restar 1 dia a la fecha inicial
   * @return
   */

  public String fechaMenos1Dia() {
    dia -= 1;

    if (dia == 0) {
      mes -= 1;
      if (mes < 1) {
        mes = 12;
        anio -= 1;
      }
      dia = diasAnio(mes, anio);
    }
    return dia + " de " + nombreMes() + " de " + anio;

  }

  /**
   * Método para sumar una cantidad de dias que se le pase como parametro a la fecha
   * @param dias
   * @return
   */
  public String fechaMasNDias (int dias) {
    this.dia += dias;

    while (dia > diasAnio(mes, anio)) {
      dia -= diasAnio(mes, anio);
      mes += 1;
      if (mes > 12) {
        mes = 1;
        anio += 1;
      }
    }
    return dia + " de " + nombreMes() + " de " + anio;
  }

  /**
   * Método para sumar una cantidad de dias que se le pase como parámetro a la fecha
   * @param dias
   * @return
   */
  public String fechaMenosNDias (int dias) {

    dia -= dias;

    while (dia < 1) {
      dia += diasAnio(mes, anio);
      mes--;
      if (mes < 1) {
        mes = 12;
        anio--;
      }
    }

    return dia + " de " + nombreMes() + " de " + anio;

  }

}
