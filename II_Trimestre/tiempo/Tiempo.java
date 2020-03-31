package tiempo;



/**
 * 1. Crea la clase Tiempo. Los objetos de la clase Tiempo son intervalos de tiempo y se crean de la forma:
 * 
 * t = Tiempo(1, 20, 30)
 * 
 * donde los parámetros que se le pasan al constructor son las horas, los minutos y los segundos respectivamente. 
 * 
 * Crea métodos para:
 *    Sumar y restar otro objeto de la clase Tiempo.
 *    Sumar y restar segundos, minutos y/o horas.
 *    - Devolver una cadena con el tiempo almacenado, de forma que si lo que hay es (10 35 5) la cadena sea 10h 35m 5s.
 *    
 * Realiza un programa de prueba para comprobar que la clase funciona bien.
 * 
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

public class Tiempo {
  
  // definimos los atributos de la clase Tiempo
  
  private int horas;
  private int minutos;
  private int segundos;
  
  // Creamos el constructor de la clase Tiempo
  
  /**
   * Creamos el constructor de la clase Tiempo
   * @param horas
   * @param minutos
   * @param segundos
   * @throws DatosIntroducidosErroneos 
   */
  
  public Tiempo(int horas, int minutos, int segundos)  {

    if (Tiempo.tiempoCorrecto(horas, minutos, segundos)) {
      this.horas = horas;
      this.minutos = minutos;
      this.segundos = segundos;
    } else {

      System.err.println("Error al introducir los datos");
      System.exit(1);
    }


  }

  
  // Métodos getters (observadores) y setters (modificadores) de la clase Tiempo
  
  /**
   * Método getter para las horas
   * @return: horas
   */
  
  public int getHoras() {
    return horas;
  }
  /**
   * Método setter para las horas
   * @param horas
   */

  public void setHoras(int horas) {
    this.horas = horas;
  }
  /**
   * Método getter para los minutos
   * @return: minutos
   */

  public int getMinutos() {
    return minutos;
  }
  /**
   * Método setter para los minutos
   * @param minutos
   */

  public void setMinutos(int minutos) {
    this.minutos = minutos;
  }
  
  /**
   * Método getter para los segundos
   * @return: segundos
   */

  public int getSegundos() {
    return segundos;
  }
  /**
   * Método setter para los segundos
   * @param segundos
   */

  public void setSegundos(int segundos) {
    this.segundos = segundos;
  }
  
  // Método toString para la salida de la información formateada en forma de cadena
  
  /**
   * Método toString para la salida de la información formateada en forma de cadena
   */

  @Override
  public String toString() {
    return horas +"h " + minutos + "m " + segundos + "s";
  }
  
  // Método para sumar horas a un objeto de la clase tiempo
  
  /**
   * Método para sumar horas a un objeto de la clase tiempo
   * @param horas
   * @return
   */
  public int sumaHoras(int horas) {
    return this.horas += horas;
  }
  
  // Método para restar horas a un objeto de la clase tiempo
  /**
   * Método para restar horas a un objeto de la clase tiempo
   * @param horas
   * @return
   */
  
  public int restaHoras(int horas) {
    return this.horas -= horas;
  }
  
  // Método para sumar minutos a un objeto de la clase Tiempo
  
  /**
   * Método apra sumar minutos a un objeto de la clase tiempo
   * Para ello pasamos las horas, minutos, segundos del objeto a segundos y luego le sumamos los minutos pasados a segundos
   * despues con el conveersor pasamos esos segundos a tiempo
   * @param minutos
   */
  
  public int sumaMinutos(int minutos) {
    int tiempoTotal = tiempoSegundos() + minutos*60;
    return conversor(tiempoTotal);
    
    
  }
  
  // Método para restar minutos a un objeto de la clase tiempo
  
  /**
   * Método para restar minutos a un objeto 
   * @param minutos
   */
  
  public int restaMinutos(int minutos) {
    int tiempoTotal = tiempoSegundos() - minutos *60;
    return conversor(tiempoTotal);
  }
  
  // Método para sumar segundos a un objeto de la clase tiempo
  
  /**
   * Método para sumar segundos a un objeto de la clase Tiempo
   * @param segundos
   * @return conversor con el tiempo pasado a horas minutos segundos
   */
  
  public int sumaSegundos(int segundos) {
    int tiempoTotal = tiempoSegundos() + segundos;
    return conversor(tiempoTotal);
  }
  
  // Método para restar segundos a un objeto de la clase Tiempo
  /**
   * Método para restar segundos a un objeto de la clase Tiempo
   * @param segundos
   * @return conversor con el tiempo pasado a horas minutos segundos
   */
  
  public int restaSegundos(int segundos) {
    int tiempoTotal = tiempoSegundos() - segundos;
    return conversor(tiempoTotal);
  }
  
  // Método para sumar a un objeto de la clase Tiempo otro objeto de la clase Tiempo
  
  /**
   * Método para sumar a un objeto de la clase Tiempo otro objeto de la clase Tiempo
   * @param otroTiempo
   * @return conversor con la suma de los tiempos pasado a horas, minutos, segundos
   */
  
  public int sumaOtroTiempo(Tiempo otroTiempo) {
    int tiempoTotal = tiempoSegundos() + otroTiempo.tiempoSegundos();
    return conversor(tiempoTotal);
  }
  
  // Método para restar a un objeto de la clase Tiempo otro objeto de la clase Tiempo
  /**
   * Método para restar a un objeto de la clase Tiempo otro objeto de la calse Tiempo
   * @param otroTiempo
   * @return conversor con la resta de los tiempos pasado a horas, minutos, segundos
   */
  public int restaOtroTiempo(Tiempo otroTiempo) {
    int tiempoTotal = tiempoSegundos() - otroTiempo.tiempoSegundos();
    return conversor(tiempoTotal);
  }
  
  
  // OTROS MÉTODOS
  
  // Método conversor para los segundos a tiempo
  
  /**
   * Método conversor para pasar el tiempo a segundos
   * @param tiempoTotal
   * @return tiempoTotal
   */
  
  public int conversor(int tiempoTotal) {
    this.horas = tiempoTotal / 3600;
    this.minutos = (tiempoTotal % 3600) / 60;
    this.segundos = (tiempoTotal % 3600) % 60;
    
    return tiempoTotal;
   
  }
  
  // Método para pasar el objeto tiempo a segundos
  
  /**
   * Metodo para pasar el objeto a segundos
   * @return el tiempo introducido en segundos
   */
  
  public int tiempoSegundos() {
    return this.horas * 3600 + this.minutos * 60 + this.segundos;
  }
  
  // Método para comprobar si el tiempo introducido en el objeto  de la clase Tiempo es correcto
  /**
   * Método para comprobar si el tiempo introducido en el objeto  de la clase Tiempo es correcto
   * @return true si esta bien introducido o false si es incorrecto
   */
  
  public static boolean tiempoCorrecto (int horas, int minutos, int segundos) {
    if (horas < 0 ) {
      return false;
    }
    if (minutos < 0 || minutos > 59) {
      return false;
    }
    if (segundos < 0 || segundos > 59) {
      return false;
    }
    return true;
    
  }


}

 