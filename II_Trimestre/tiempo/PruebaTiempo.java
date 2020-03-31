package tiempo;

/**
 * Prueba de la clase Tiempo
 * 
 * @author José Luis Álvarez Fernández
 *
 */

public class PruebaTiempo {

  public static void main(String[] args) {
    
    // Creamos t1 como objeto de la clase Tiempo
    
    Tiempo t1 = new Tiempo (10, 10, 10);
    Tiempo t2 = new Tiempo (3, 3, 3);
    
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