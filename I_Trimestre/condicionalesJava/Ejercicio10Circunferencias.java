package condicionalesJava;
/**
* Programa: Ejercicio10Circunferencias.java
*
* Proposito: 10. Algoritmo que pida los puntos centrales x1,y1,x2,y2 y los radios r1,r2 de dos 
*                circunferencias y las clasifique en uno de estos estados:
*
*                     exteriores
*                     tangentes exteriores
*                     secantes
*                     tangentes interiores
*                     interiores
*                     concéntricas
*
* @author José Luis Álvarez Fernández
*
* Fecha: 5/11/2019
*/

/**
 * Variables:
 * x1 (double): almacenará el valor de x1
 * y1 (double): almacenará el valor de y1
 * x2 (double): almacenará el valor de x2
 * y2 (double): almacenará el valor de y2
 * r1 (double): almacenará el valor de r1
 * r2 (double): almacenará el valor de r2
 * distancia (double): alamcenará la distancia entre los puntos de la circunferencia (distancia = (math.sqrt(math.pow((x2 - x1),2) + math.pow((y2 - y1),2))))
 * 
 * Algoritmo:
 * 
 * LEER: x1, y1, x2, y2, rº, r2
 * CALCULAR: definimos la variable distancia para calcular la diferencia entre los puntos de las 
 *           dos circunferencias (distancia = (math.sqrt(math.pow((x2 - x1),2) + math.pow((y2 - y1),2))))
 *           aplicamos la formula (distancia > (r1 + r2)) para saber si son circunferencias exteriores
 *           aplicamos la formula (distancia < (r1 +r2) and distancia > (r1 -r2)) para saber si son circunferencias secantes          
 *           aplicamos la formula (distancia == (r1 + r2)) para saber si son circunferencias tangentes exteriores
 *           aplicamos la formula (distancia == (r1 - r2)) para saber si son circunferencias tangentes interiores
 *           si no cumplen ninguna de estas condiciones nos encontramos ante circunferencias concentricas
 * 
 */
import java.util.Scanner;

 public class Ejercicio10Circunferencias {
   public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Definimos las variables:

    double x1;
    double y1;
    double x2;
    double y2;
    double r1;
    double r2;


    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce el valor de x1: ");
    x1 = sc.nextDouble();

    System.out.println("Introduce el valor de y1: ");
    y1 = sc.nextDouble();

    System.out.println("Introduce el valor de x2: ");
    x2 = sc.nextDouble();

    System.out.println("Introduce el valor de y2: ");
    y2 = sc.nextDouble();

    System.out.println("Introduce el valor de r1: ");
    r1 = sc.nextDouble();

    System.out.println("Introduce el valor de r2: ");
    r2 = sc.nextDouble();
    
  // Calculos

  double distancia = (Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2)));

  if (distancia > (r1 + r2)) {
    System.out.println("se trata de circunferencias exteriores, no tienen puntos en comun");
  }
  
  else if (distancia < (r1 +r2) && distancia > (r1 -r2)) {
    System.out.println("Se tratan de circunferencias secantes, tienen dos puntos en común");
  }
  else if (distancia > 0 && distancia < (r1 - r2)) {
    System.out.println("se trata de circunferencias interiores, una esta dentro de la otra");
  }
  else if (distancia == (r1 + r2)) {
    System.out.println("se trata de circunferencias tangentes exteriores");
  }
  else if (distancia == (r1 - r2)){
    System.out.println("se trata de circunferencias tangentes interiores");
  }
  else {
    System.out.println("se trata de circunferencias concentricas");
  }
}
 }
