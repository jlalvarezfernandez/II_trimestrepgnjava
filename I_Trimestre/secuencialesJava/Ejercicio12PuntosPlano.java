package secuencialesJava;
/**
* Programa: Ejercicio12PuntosPlano.java
*
* Proposito: 12. Pide al usuario dos pares de números x1,y2 y x2,y2, que representen dos puntos en el plano. 
*                Calcula y muestra la distancia entre ellos.
*
*
* @author José Luis Álvarez Fernández
*
* Fecha: 2/11/2019
*/
/**
 * Variables:
 * x1 (double): almacenará el valor de x1
 * y1 (double): almacenará el valor de y1
 * x2 (double): almacenará el valor de x2
 * y2 (double): almacenará el valor de y2
 * distancia (double): almacenará la distancia entre los 4 puntos Math.sqrt((Math.pow(x2,2 - x1,2) + (Math.pow(y2,2 - y1,2)))
 * 
 * Algoritmo:
 * 
 * LEER: num1, num2
 * CALCULAR: distancia
 * ESCRIBIR: distancia
 * 
 */


 public class Ejercicio12PuntosPlano {
   public static void  main(String[] args) {
     
    // Definimos las variables:

    String linea;
    double x1;
    double y1;
    double x2;
    double y2;
  

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce el valor de x1: ");
    linea = System.console().readLine();
    x1 = Double.parseDouble(linea);

    System.out.println("Introduce el valor de y1: ");
    linea = System.console().readLine();
    y1 = Double.parseDouble(linea);

    System.out.println("Introduce el valor de x2: ");
    linea = System.console().readLine();
    x2 = Double.parseDouble(linea);

    System.out.println("Introduce el valor de y2: ");
    linea = System.console().readLine();
    y2 = Double.parseDouble(linea);

    // Calculos

   double distancia = Math.sqrt((Math.pow(x2 - x1,2) + (Math.pow(y2 - y1,2))));
   
    // Mostramos los resultados por pantalla

    System.out.println("La distancia entre los números del plano es de: " + distancia);



   }
 }