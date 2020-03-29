package excepciones;

import java.util.InputMismatchException;
import excepciones.Tiempo;

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
 *    Devolver una cadena con el tiempo almacenado, de forma que si lo que hay es (10 35 5) la cadena sea 10h 35m 5s.
 *    
 * Realiza un programa de prueba para comprobar que la clase funciona bien.
 * 
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */
import java.util.Scanner;

public class TestTiempo {

  public static void main(String[] args) throws DatosIntroducidosErroneos {
    Scanner sc = new Scanner (System.in);
    
    // Test para comprobar los métodos de la clase Tiempo
    
    // definimos varias instancias de clase u objetos de la clase tiempo para las pruebas
    
    boolean interruptor = true;

    // creamos una instancia de clase u objeto de la clase rectángulo
    Tiempo t1 = null;
    Tiempo t2 = null;

    do {

      try {
        
        System.out.println("Introduce la hora para el tiempo t1: ");
        int horaT1 = sc.nextInt();
        System.out.println("Introduce los minutos para el tiempo t1: ");
        int minT1 = sc.nextInt();
        System.out.println("Introduce los segundos para el tiempo t1: ");
        int segT1 = sc.nextInt();
        t1 = new Tiempo(horaT1, minT1, segT1);
        System.out.println("Introduce la hora para el tiempo t2: ");
        int horaT2 = sc.nextInt();
        System.out.println("Introduce los minutos para el tiempo t2: ");
        int minT2 = sc.nextInt();
        System.out.println("Introduce los segundos para el tiempo t2: ");
        int segT2 = sc.nextInt();
        t2 = new Tiempo(horaT2, minT2, segT2);
        
        interruptor = false;

      } catch (DatosIntroducidosErroneos e) {
        System.err.println("Error al introducir los datos");
        sc.next();
        //System.exit(1);
        
      }
      
      catch (InputMismatchException e2) {
        
        System.err.println("Introduce un número entero, por favor");
        sc.next();
        
      }

    } while (interruptor);


    System.out.println("TEST PARA COMPROBAR LOS MÉTODOS DE LA CLASE TIEMPO");
    System.out.println("----------------------------------------------------");
    System.out.println("Mostramos t1 por pantalla: ");
    System.out.println(t1);
    System.out.println();
    System.out.println("Mostramos t2 por pantalla: ");
    System.out.println(t2);
    System.out.println("----------------------");
    System.out.println("Sumamos a t1 5 horas: ");
    t1.sumaHoras(5);
    System.out.println(t1);
    System.out.println();
    System.out.println("Sumamos a t1 10 horas" );
    t2.sumaHoras(10);
    System.out.println(t2);
    System.out.println("---------------------------");
    System.out.println("Restamos a t1 2 horas: ");
    t1.restaHoras(2);
    System.out.println(t1);
    System.out.println();
    System.out.println("Restamos a t1 5 horas" );
    t2.restaHoras(5);
    System.out.println(t2);
    System.out.println("---------------------------");
    System.out.println("Sumamos a t1 10 minutos: ");
    t1.sumaMinutos(10);
    System.out.println(t1);
    System.out.println();
    System.out.println("Sumamos a t2 80 minutos: ");
    t2.sumaMinutos(80);
    System.out.println(t2);
    System.out.println();
    System.out.println("---------------------------");
    System.out.println("Restamos a t1 10 minutos: ");
    t1.restaMinutos(10);
    System.out.println(t1);
    System.out.println();
    System.out.println("Restamos a t2 80 minutos: ");
    t2.restaMinutos(80);
    System.out.println(t2);
    System.out.println();
    System.out.println("---------------------------");
    System.out.println("Sumamos a t1 10 segundos: ");
    t1.sumaSegundos(10);
    System.out.println(t1);
    System.out.println();
    System.out.println("Sumamos a t2 80 minutos: ");
    t2.sumaSegundos(80);
    System.out.println(t2);
    System.out.println();
    System.out.println("---------------------------");
    System.out.println("Restamos a t1 10 minutos: ");
    t1.restaSegundos(10);
    System.out.println(t1);
    System.out.println();
    System.out.println("Restamos a t2 80 minutos: ");
    t2.restaSegundos(80);
    System.out.println(t2);
    System.out.println();
    System.out.println("---------------------------");
    System.out.println("Sumamos a t1 el tiempo de t2: ");
    t1.sumaOtroTiempo(t2);
    System.out.println(t1);
    System.out.println("---------------------------");
    System.out.println("Restamos a t1 el tiempo de t2: ");
    t1.restaOtroTiempo(t2);
    System.out.println(t1);
    System.out.println("---------------------------");

  }

}
