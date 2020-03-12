package secuencialesJava;
/**
* Programa: Ejercicio4Operaciones.java
*
* Proposito: 4. Dados dos números, mostrar la suma, resta, división y multiplicación de ambos.
* 
* @author José Luis Álvarez Fernández
*
* Fecha: 2/11/2019
*/

/**
 * Variables:
 * num1 (double): almacenará el valor del primer número
 * num2 (double): almacenará el valor del segundo número
 * suma (double): almacenará el valor de la suma de los dos números
 * resta (double): almacenará el valor de la resta de los dos números
 * division (double): almacenará el valor de la división de los dos números
 * multiplicacion (double): almacenará el valor de la multiplicación de los dos números
 * 
 * 
 * Algoritmo:
 * 
 * LEER: num1,num2
 * CALCULAR: suma, resta, multiplicacion, division
 * ESCRIBIR: suma, resta, multiplicacion, division
 * 
 */

public class Ejercicio4Operaciones {
  public static void main (String []args){
  
    // Definimos las variables:

    String linea;
    double num1;
    double num2;

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce el primer número");
    linea = System.console().readLine();
    num1 = Double.parseDouble(linea);

    System.out.println("Introduce el segundo número");
    linea = System.console().readLine();
    num2 = Double.parseDouble(linea);

    // Calculos

    double suma = num1 + num2;
    double resta = num1 - num2;
    double division = num1 / num2;
    double multiplicacion = num1 * num2;

    // Mostramos los resultados por pantalla

    System.out.println("La suma de los dos números es de: " + suma);
    System.out.println("La resta de los dos números es de: " + resta);
    System.out.println("La división de los dos números es de: " + division);
    System.out.println("La multiplicación de los dos números es de: " + multiplicacion);




  }
}