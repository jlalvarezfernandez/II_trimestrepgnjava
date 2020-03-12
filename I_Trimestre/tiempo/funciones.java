package tiempo;
/**
 * Colección de funciones para manejar fechas en cadenas de caracteres.
 *
 * El formato de la cadena es: AAAAMMDD.
 * Ejemplo: El 15 de diciembre de 2019 sería: "20191215"
 *
 * Colección de funciones:
 *
 * 1. fechaCorrecta: dice si la fecha que se pasa como parámetro es correcta.
 *
 * 2. fechaMas1Dia: suma un día a la fecha que se pasa como parámetro y lo devuelve.
 *
 * 3. fechaMasNDias: suma una serie de días a la fecha que se pasa como parámetro y lo devuelve.
 *
 * 4. fechaMenos1Dia: resta un día a la fecha que se pasa como parámetro y lo devuelve.
 *
 * 5. fechaMenosNDias: resta una serie de días a la fecha que se pasa como parámetro y lo devuelve.
 *
 * 6. esBisiesto: dice si la fecha que se pasa como parámetro es bisiesto.
 *
 * 7. comparaFechas: recibe dos fechas y devuelve un valor negativo si la 1ª es anterior a la
 *    segunda, cero si son iguales, y un valor positivo si la 1ª es posterior a la segunda.
 *
 * 8. fechaFormateada: recibe un fecha y devuelve una cadena con el formato:
 *    DD de {MES} de AAAA     (Ejemplo: "15 de Diciembre de 2019")
 *
 * 9. anyo, mes, dia, nombreMes: recibe un fecha y devuelve esos valores.
 *
 * @author rafa
 *
 */


public class funciones {
  

  /**
   * Dice si la fecha que se pasa como parámetro es correcta.
   *
   * @param fecha
   * @return verdadero o falso.
   */
  
  public static boolean fechaCorrecta(String fecha) {
  
    /**String a;
    String m;
    String d;
    
    a = fecha.substring(0,3);
    m = fecha.substring(4,5);
    d = fecha.substring(6,7);
    
    int anio = Integer.valueOf(a);
    for (int i = 0; i < a.length(); i++) {
      if (anio < 0 ) {
        return false;
      }
    }

    a = String.valueOf(anio);
    
    int mes = Integer.valueOf(m);
    
    for (int i = 0; i < m.length(); i++) {
      if (mes <0 || mes > 12) {
        return false;
      }
    }
    
    m = String.valueOf(mes);
    
    int dia =  Integer.valueOf(d);
    
    for (int i = 0; i <d.length(); i++) {
      if (dia < 0 || dia > 31) {
        return false;
      }
    }
    
    d = String.valueOf(dia);*/
  
    return true;
  }

  /**
   * Suma un día a la fecha que se pasa como parámetro y la devuelve.
   *
   * @param fecha
   * @return nuevo fecha
   */
  public static String fechaMas1Dia(String fecha) {
    
    int sumarUnDia = Integer.valueOf(fecha); // paso la fecha de cadena a entero para poder sumarle  1
    
    int fechaFinal = sumarUnDia + 1;
    
    String fechaMasUno = String.valueOf(fechaFinal);
   
    return fechaMasUno;
    
  }

  /**
   * Suma una serie de días a la fecha que se pasa como parámetro y la devuelve.
   *
   * @param fecha
   * @param dias
   * @return nueva fecha
   */
  public static String fechaMasNDias(String fecha, int dias) {
    
    int sumarNDias = Integer.valueOf(fecha);
    
    int fechaFinal = sumarNDias + dias;
    
    String fechaMasNDias = String.valueOf(fechaFinal);
    
    return fechaMasNDias;
  }

  /**
   * Resta un día a la fecha que se pasa como parámetro y la devuelve.
   *
   * @param fecha
   * @return nuevo fecha
   */
  public static String fechaMenos1Dia(String fecha) {
    
    int restarUnDia = Integer.valueOf(fecha); // paso la fecha de cadena a entero para poder sumarle  1
    
    int fechaFinal = restarUnDia - 1;
    
    String fechaMenosUno = String.valueOf(fechaFinal);

    
    return fechaMenosUno;
  }

  /**
   * Resta una serie de días a la fecha que se pasa como parámetro y la devuelve.
   *
   * @param fecha
   * @param dias
   * @return nuevo fecha
   */
  public static String fechaMenosNDias(String fecha, int dias) {
    
    int restarNDias = Integer.valueOf(fecha);
    
    int fechaFinal = restarNDias + dias;
    
    String fechaMenosNDias = String.valueOf(fechaFinal);
    
    return fechaMenosNDias;
   
  }

  /**
   * Dice si la fecha que se pasa como parámetro es de un año bisiesto.
   *
   * @param fecha
   * @return verdadero o falso
   */
  public static boolean esBisiesto(String fecha) {
    
    int posibleBisiesto = Integer.valueOf(fecha);
    
    String bisiesto = String.valueOf(posibleBisiesto);
    
    if (posibleBisiesto % 4 == 0 && posibleBisiesto  % 100 != 0 || posibleBisiesto % 400 == 0) {
        return true;
        } else {
          return false;
        }
    
  }

  /**
   * Recibe dos fechas y devuelve un valor negativo si la 1º es anterior a la 2º,
   * cero si son iguales, y un valor positivo si la 1º es posterior a la segunda.
   *
   * @param fecha1
   * @param fecha2
   * @return entero negativo, cero o un entero positivo.
   */
  public static int comparaFechas(String fecha1, String fecha2) {
    
    int primFecha = Integer.valueOf(fecha1); // paso las fechas de cadena a entero para opoerar con ellas
    int segFecha = Integer.valueOf(fecha2);
    String primeraFecha = String.valueOf(primFecha);
    String segundaFecha = String.valueOf(segFecha);
    
    if (primFecha < segFecha) {
      return -1;
    } else if (primFecha == segFecha) {
      return 0;
    } else {
      return 1;
    }
    
    
  }

  /**
   * Recibe un fecha y devuelve una cadena con el formato DD de {MES} de AAAA
   * (Ejemplo: "15 de Diciembre de 2019")
   *
   * @param fecha
   * @return fecha formateada
   */
  public static String fechaFormateada(String fecha) {
    
    
    return "DD de MM de AAAA";
  }

  /**
   * Devuelve el año de la fecha.
   *
   * @param fecha
   * @return
   */
  public static int anyo(String fecha) {
    return 0;
  }

  /**
   * Devuelve el mes de la fecha.
   *
   * @param fecha
   * @return
   */
  public static String nombreMes(String fecha) {
    return "MES";
  }

  /**
   * Devuelve el nombre del mes de la fecha.
   *
   * @param fecha
   * @return nombre del mes
   */
  public static int mes(String fecha) {
    return 0;
  }

  /**
   * Devuelve el día de la fecha.
   *
   * @param fecha
   * @return
   */
  public static int dia(String fecha) {
    
    
    
    
    
    

    return 0;
  }

  /**
   * Devuelve una cadena en formato AAAAMMDD
   * @param d día del mes
   * @param m día del año
   * @param a año
   * @return
   */
  public static String fecha(int d, int m, int a) {
    String dia=Integer.toString(d).trim();
    String mes=Integer.toString(m).trim();
    String anyo=Integer.toString(a).trim();
    // día
    if (dia.length()<2) {
      dia = "0"+dia;
    }
    // mes
    if (mes.length()<2) {
      mes = "0"+mes;
    }
    // año
    for (int i=anyo.length(); i<4; i++) {
      anyo = "0"+anyo;
    }
    return anyo + mes + dia;
  }

}
  
  


