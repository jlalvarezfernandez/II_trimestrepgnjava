package pruebaFuncionesExamen;
import tiempo.*;
import java.util.Scanner;

public class Pruebas {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    
    String fecha;
    String fecha2;
    int diasASumar;
    int diasARestar;
    
    System.out.println("Introduce una fecha: ");
    fecha = sc.next();
    
    if (funciones.fechaCorrecta(fecha)) {
      System.out.println("CORRECTO");
    } else {
      System.out.println("INCORRECTO");
    }
    
    System.out.println("Si sumamos un dia a: '" + fecha + "' obtenemos: " + funciones.fechaMas1Dia(fecha));
    System.out.println();
    
    System.out.println("Introduce el número de dias que quieres sumar a la fecha: ");
    diasASumar = sc.nextInt();
    System.out.println("La fecha final sumados " + diasASumar + " es: " + funciones.fechaMasNDias(fecha, diasASumar));
    
    System.out.println("Si restamos un dia a: '" + fecha + "' obtenemos: " + funciones.fechaMenos1Dia(fecha));
    System.out.println();
    
    System.out.println("Introduce el numero de dias que quieres restar a la fecha: ");
    diasARestar = sc.nextInt();
    System.out.println("La fecha final restados " + diasARestar + " es: " + funciones.fechaMenosNDias(fecha, diasARestar));
    System.out.println();
    
    System.out.println("Vamos a comparar fechas: ");
    System.out.println("Introduce la primera fecha: ");
    fecha = sc.next();
    System.out.println("Introduce la segunda fecha: ");
    fecha2 = sc.next();
    System.out.println("El resultado de la comparacion es: " + funciones.comparaFechas(fecha, fecha2));
    
    System.out.println("Comprobamos si la fecha pertenece a un año bisiesto o no: " + funciones.esBisiesto(fecha));
    fecha = sc.next();
    
   
    

  }

}
