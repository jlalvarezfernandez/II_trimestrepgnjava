package condicionalesJava;
/**
* Programa: Ejercicio11Triangulo.java
*
* Proposito: 11. Programa que lea 3 datos de entrada A, B y C. 
*                Estos corresponden a las dimensiones de los lados de un triángulo. 
*                El programa debe determinar que tipo de triangulo es, teniendo en cuenta los siguiente:
*
*                   Si se cumple Pitágoras entonces es triángulo rectángulo
*                   Si sólo dos lados del triángulo son iguales entonces es isósceles.
*                   Si los 3 lados son iguales entonces es equilátero.
*                   Si no se cumple ninguna de las condiciones anteriores, es escaleno.
*
* @author José Luis Álvarez Fernández
*
* Fecha: 5/11/2019
*/

/**
 * Variables:
 * ladoA (double): almacenará el valor del ladoA
 * ladoB (double): almacenará el valor del ladoB
 * ladoC (double): almacenará el valor del ladoC
 * 
 * 
 * Algoritmo:
 * 
 * LEER: ladoA, ladoB, ladoC
 * CALCULAR: para calcular si es un triángulo rectangulo recurrimos a la formula a2 = b2 + c2 y ponemos las diversas opciones
          para calcular si es un triangulo isosceles comparamos dos lados que tienen que ser iguales 
          y el otro debe de ser diferente longutud 
          para calcular si es un triángulo equilatero los 3 lados deben de ser iguales
          para calcular si es un triángulo escaleno la longitud de los lado debe ser diferente.
 */
import java.util.Scanner;

 public class Ejercicio11Triangulo {
   public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Definimos las variables:

    double ladoA;
    double ladoB;
    double ladoC;
  
    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce el valor del lado A: ");
    ladoA = sc.nextDouble();

    System.out.println("Introduce el valor del lado B: ");
    ladoB = sc.nextDouble();

    System.out.println("Introduce el valor del lado A: ");
    ladoC = sc.nextDouble();

    
  // Calculos


  if (ladoA == ladoB && ladoB == ladoC) {
    System.out.println("Los tres lados son iguales, es un triangulo EQUILATERO");
  }
  else if (ladoA == ladoB && ladoB != ladoC && ladoA != ladoC){
    System.out.println("solo dos lados son iguales, es un triangulo ISOSCELES");
  }
  if (Math.pow(ladoA,2) == Math.pow(ladoB,2) + Math.pow(ladoC,2) || Math.pow(ladoB,2) == Math.pow(ladoA,2) + Math.pow(ladoC,2) || Math.pow(ladoC,2) == Math.pow(ladoA,2) + Math.pow(ladoB,2)) {
    System.out.println("Cumple Pitagoras, es un triangulo RECTÁNGULO");
  }
  else {
    System.out.println("Ningún lado es igual, es un triangulo ESCALENO");

  }
  
}
 }
