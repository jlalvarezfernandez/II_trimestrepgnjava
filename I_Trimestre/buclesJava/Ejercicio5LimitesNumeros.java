package buclesJava;
/**
* Programa: Ejercicio5LimitesNumeros.java
*
* Proposito: 5. Escribe un programa que pida el limite inferior y superior de un intervalo. 
*               Si el límite inferior es mayor que el superior lo tiene que volver a pedir. 
*               A continuación se van introduciendo números hasta que introduzcamos el 0. 
*               Cuando termine el programa dará las siguientes informaciones:
*
*                    La suma de los números que están dentro del intervalo (intervalo abierto).
*                    Cuantos números están fuera del intervalo.
*                    Informa si hemos introducido algún número igual a los límites del intervalo.
*
*
* 
* @author José Luis Álvarez Fernández
*
* Fecha: 9/11/2019
*/

/**
 * Variables:
 * limInferior (numérico): almacenará el primer número introducido
 * limSuperior (numérico): almacenará el segundo número introducido
 * num (numérico): almacenará los números introducidos
 * suma (numérico): almacenará la suma de los números que esten dentro del intervalo
 * fueraIntervalo (numérico): almacenará los números que esten fuera del intervalo
 * igualIntervalo (booleano): inicializado en false
 * 
 * Algoritmo:
 * 
 * pedimos los limites inferior y superior
 * si el limite inferior es superior al limite superior hacemos un ciclo while para corregirlo
 * si el usuario no introduce que el limite inferior sea menor que el limite superior volvera a pedirlo
 * hasta que sea correcto
 * 
 * ciclo while mientras el numero introducido sea diferente a 0 ( al ingresar 0 el programa finaliza)
 * pedimos números
 * si el número introducido esta entre los limites sumamos los numeros
 * si los números introducidos estan fuera de los limites incrementamos en 1 la variable fueraLimites
 * si algún número introducido es igual a los limites declarados sera verdadero 
 * y lo mostraremos por pantalla
 * 
 * mostraremos los resultados por pantalla
 * 
 * 
 */

 import java.util.Scanner;

 public class Ejercicio5LimitesNumeros {
   public static void main(String []args) {

    Scanner sc = new Scanner (System.in);

    // Definimos las variables

    int limInferior;
    int limSuperior;
    int num = 1;
    int suma = 0;
    int fueraIntervalo = 0;
    boolean igualIntervalo = false;
    

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce el primer número: ");
    limInferior  = sc.nextInt();

    System.out.println("Introduce el segundo número: ");
    limSuperior  = sc.nextInt();

  
    // Calculos

    while (limInferior>limSuperior) {
      System.out.println("Introduce el primer número: ");
      limInferior  = sc.nextInt();
  
      System.out.println("Introduce el segundo número: ");
      limSuperior  = sc.nextInt();
    }
    System.out.println("Introduce números (introduce 0 para acabar): ");
    num = sc.nextInt();

    while (num != 0) {

      if (num > limInferior && num < limSuperior) {
        suma += num;
      } else if (num < limInferior || num > limSuperior) {
       fueraIntervalo+=1;
      } else {
        if (num == limInferior || num == limSuperior) {
       igualIntervalo=true;
      }
      }
      System.out.println("Introduce números (introduce 0 para acabar): ");
      num = sc.nextInt();
    }

    System.out.println("La suma de los números que están dentro del intervalo es: " + suma);
    System.out.println("Hay " + fueraIntervalo + " números fuera del intervalo");
    if (igualIntervalo) {
      System.out.println("Has introducido algún número igual al intervalo");
    } else {
        System.out.println("Has introducido algún número igual al intervalo");

    }


 }
}