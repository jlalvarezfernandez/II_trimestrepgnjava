package condicionalesJava;
/**
* Programa: Ejercicio8NotaEdadSexo.java
*
* Proposito: 8. Algoritmo que pida dos números ‘nota’ y ‘edad’ y un carácter ‘sexo’ y muestre el 
*               mensaje ‘ACEPTADA’ si la nota es mayor o igual a cinco, la edad es mayor o igual a 
*               dieciocho y el sexo es ‘F’. En caso de que se cumpla lo mismo, pero el sexo sea ‘M’, debe 
*               imprimir ‘POSIBLE’. Si no se cumplen dichas condiciones se debe mostrar ‘NO ACEPTADA’.
*
* @author José Luis Álvarez Fernández
*
* Fecha: 5/11/2019
*/

/**
 * Variables:
 * nota (double): almacenará la nota introducida
 * edad (double): almacenará la edad introducida
 * sexo (String): almacenará el sexo introducida (F/M)
 * 
 * Algoritmo:
 * 
 * LEER: nota, edad, sexo
 * CALCULAR: si la nota es >=5 y edad >=18 y sexo == F será verdadero y mostrara aceptada, 
 *           sino si nota es >=5 y edad >=18 y sexo == M será posible y mostrara posible
 *           si lo que introducimos es contrario a esto, será falso y mostrara no aceptada
 * 
 */
import java.util.Scanner;

 public class Ejercicio8NotaEdadSexo {
   public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Definimos las variables:

    double nota;
    double edad;
    char sexo;


    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce la nota: ");
    nota = sc.nextDouble();

    System.out.println("Introduce una edad: ");
    edad = sc.nextDouble();

    System.out.println("Introduce un sexo (F/M): ");
    sexo = sc.next().charAt(0);
    
  // Calculos

    if (nota >= 5 && edad >= 18) {
      if (sexo == 'F' || sexo =='f')
        System.out.println("ACEPTADA");
    }
    if (nota >= 5 && edad >= 18) {
      if (sexo == 'M' || sexo =='m')
        System.out.println("POSIBLE");
    }
    else {
      System.out.println("NO ACEPTADA");

    }
    }

   }