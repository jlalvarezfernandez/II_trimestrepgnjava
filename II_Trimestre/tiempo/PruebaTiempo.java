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
    
    
    System.out.println("Tiempo t1: " + t1);
    System.out.println("----------------------");
    System.out.println("Tiempo t2: " + t2);
    System.out.println("-----------------------");
    System.out.println("Salida formateada de t1: ");
    System.out.println(t1);
    System.out.println("-----------------------");
    System.out.println("Salida formateada de t2: ");
    System.out.println(t2);
    System.out.println("------------------------");
    System.out.println("Sumamos 3 horas a t1: ");
    t1.sumaHoras(3);
    System.out.println(t1);
    System.out.println("-------------------------");
    System.out.println("Restamos 5 horas a t1: ");
    t1.restaHoras(5);
    System.out.println(t1);
    System.out.println("--------------------------");
    System.out.println("Sumamos 125 minutos a t1: ");
    t1.sumaMinutos(125);
    System.out.println(t1);
    System.out.println("--------------------------");
    System.out.println("Restamos 75 minutos a t1: ");
    t1.restaMinutos(75);
    System.out.println(t1);
    System.out.println("--------------------------");
    System.out.println("Sumamos 800 segundos a t1: ");
    t1.sumaSegundos(800);
    System.out.println(t1);
    System.out.println("--------------------------");
    System.out.println("Restamos 450 segundos a t1: ");
    t1.restaSegundos(450);
    System.out.println(t1);
    System.out.println("--------------------------");
    System.out.println("sumamos a t1 el tiempo de t2: ");
    t1.sumaTiempo(t2);
    System.out.println(t1);
    System.out.println("--------------------------");
    System.out.println("Restamos 4a t1 el tiempo de t2: ");
    t1.restaTiempo(t2);
    System.out.println(t1);
    
    
    
    
    
    
   

  }

}


/**
Tiempo t1 = new Tiempo(1,1,1);
Tiempo t2 = new Tiempo(2,2,2);

System.out.println("Tiempo 1: " + t1);
System.out.println("Tiempo 2: " + t2); 

// Método de suma
t1.sumaTiempo(t2);
System.out.println("Resultado de sumar " + t1);

System.out.println("---------------------");
Tiempo t3 = new Tiempo(5,5,5);
Tiempo t4 = new Tiempo(2,2,2);
System.out.println("Creamos t3 " + t3 +" y t4 " + t4 + " y los restamos");

t3.restaTiempo(t4);
System.out.println("Resultado " + t3);
System.out.println("Sumamos 70 min a: " + t1);

System.out.println("---------------------");
t1.sumaMinutos(70);
System.out.println(t1);

System.out.println("Restamos 70 min a: " + t1);

t1.restaMinutos(70);
System.out.println(t1);

System.out.println("Sumamos segundos");
System.out.println("--------------------");
System.out.println("Sumamos 120s a " + t1);
t1.sumaSegundos(120);
System.out.println("Resultado: " + t1);

System.out.println("---------------------");
System.out.println("Restamos segundos");
System.out.println("Restamos 120s a " + t1);
t1.restaSegundos(120);
System.out.println("Resultado: " + t1); 



}

}
*/