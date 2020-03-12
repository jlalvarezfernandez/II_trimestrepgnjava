package tiempo;

/**
 * Los objetos de la clase Tiempo son intervalos de tiempo y se crean de la forma:
 *
 *       t = Tiempo(1, 20, 30)
 *
 * donde los parámetros que se le pasan al constructor son las horas, los minutos y los segundos respectivamente.
 * 
 * Crea métodos para:
 *  Sumar y restar otro objeto de la clase Tiempo.
 *  Sumar y restar segundos, minutos y/o horas.
 *  Devolver una cadena con el tiempo almacenado, de forma que si lo que hay es (10 35 5) la cadena sea 10h 35m 5s.
 * 
 * 
 * @author José Luis Álvarez Fernández
 *
 */

// Creamos la clase Tiempo

public class Tiempo {
  
  // Definimos los atributos
  // En principio estos atributos o variables de instancia van a tener una visibiliadad friendly
  
  private int segundos;
  private int minutos;
  private int horas;
  
  
  /**
   * Por defecto Java crea un constructor interno, pero nosotros vamosa  crear un constructor
   * 
   */
  
  public Tiempo (int segundos, int minutos, int horas) {
    this.horas = horas;
    this.minutos = minutos;
    this.segundos = segundos;
       
  }
  
  /**
   * Creamos los getters y los setters para cada atributo de la clase Tiempo
   */
  
  // getter horas
  
  public int getHoras() {
    return this.horas;
  }
  
  // getter minutos
  
  public int getMinutos() {
    return this.minutos;
  }
  
  // getter segundos
  
  public int getSegundos() {
    return this.segundos;
  }
  
  // aunque para este ejercicio no voy a necesitar usar los setters, voy a crearlos porque estamos aprnediendo todos estos métodos
  
  // setter horas
  
  public void setHoras(int horas) {
    this.horas = horas;
  }
  
  // setter minutos
  
  public void setMinutos(int minutos) {
    this.minutos = minutos;
  }
  
  // setter segundos
  
  public void setSegundos (int segundos) {
    this.segundos = segundos;
  }

  /**
   * Método para convertir el tiempo total en segundos
   * @param tiempoTotal
   */
  
  public static void conversor (int tiempoTotal) {
      int horas = tiempoTotal / 3600;
      int minutos = (tiempoTotal % 3600) / 60;
      int segundos = (tiempoTotal % 3600) % 60;
    }
  
  /**
   * Método toString para devolver una cadena con el tiempo almacenado, de forma que si lo que hay es (10 35 5) la cadena sea 10h 35m 5s.
   * 
   */
  
  public String toString() {
    return this.horas + "h " + this.minutos + "m " + this.segundos + "s";
    
  }
  
 /**
  * Método para sumar horas
  * @param horas
  */
  public void  sumaHoras (int horas) {
    this.horas += horas;
    
  }
  
  /**
   * método para restar horas
   * @param horas
   */
  
  public void restaHoras (int horas) {
    this.horas -= horas;
  }
  
  /**
   * Metodo para sumar minutos
   * @param minutos
   */
  public void sumaMinutos (int minutos) {
    int tiempoTotal = (this.horas * 3600 + this.minutos * 60 + this.segundos) + (minutos * 60);
    this.conversor(tiempoTotal);
  }
  /**
   * Método para restar minutos
   * @param minutos
   */
  
  public void restaMinutos (int minutos) {
    int tiempoTotal = (this.horas * 3600 + this.minutos * 60 + this.segundos) - (minutos * 60);
    this.conversor(tiempoTotal);
  }
  
  /**
   * Método para sumar segundos
   * @param segundos
   */
    
  public void sumaSegundos (int segundos) {
    int tiempoTotal = (this.horas * 3600 + this.minutos * 60 + this.segundos) + (segundos);
    this.conversor(tiempoTotal);
  }
  
  /**
   * Método para restar segundos
   * @param segundos
   */
  
  public void restaSegundos (int segundos) {
    int tiempoTotal = (this.horas * 3600 + this.minutos * 60 + this.segundos) - (segundos);
    this.conversor(tiempoTotal);
  }
  
  /**
   * Método para sumar otro tiempo
   * 
   * @param otroTiempo
   */
  
  public void sumaTiempo (Tiempo otroTiempo) {
    int tiempoTotal = (this.horas * 3600 + this.minutos * 60 + this.segundos) + (otroTiempo.horas * 3600 + otroTiempo.minutos * 60 + otroTiempo.segundos);
    this.horas = tiempoTotal / 3600;
    this.minutos = (tiempoTotal% 3600)/60;
    this.segundos =(tiempoTotal % 3600) % 60;
  }
  
  /**
   * Método para restar otro tiempo
   * @param otroTiempo
   */
  
  public void restaTiempo (Tiempo otroTiempo) {
    int tiempoTotal = (this.horas * 3600 + this.minutos * 60 + this.segundos) - (otroTiempo.horas * 3600 + otroTiempo.minutos * 60 + otroTiempo.segundos);
    this.horas = tiempoTotal / 3600;
    this.minutos = (tiempoTotal% 3600)/60;
    this.segundos =(tiempoTotal % 3600) % 60;
  }
  

  }
  
 