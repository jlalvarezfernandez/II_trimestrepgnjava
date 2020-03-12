package secuencialesJava;
/**
* Programa: Ejercicio20TotalDinero.java
*
* Proposito: 20. Diseñar un algoritmo que nos diga el dinero que tenemos (en euros y céntimos) 
*                después de pedirnos cuantas monedas tenemos de 2e, 1e, 50 céntimos, 20 céntimos o 10 céntimos).
*
*
* @author José Luis Álvarez Fernández
*
* Fecha: 4/11/2019
*/

/**
 * Variables:
 * monedas2E (double): almacenará las monedas de dos euros introducidas 
 * monedas1E (double): almacenará las monedas de un euro introducidas 
 * monedas50Cent (double): almacenará las monedas de 50 centimos introducidas 
 * monedas20Cent (double): almacenará las monedas de 20 centimos introducidas 
 * monedas10Cent (double): almacenará las monedas de 10 centimos introducidas 

 * 
 * Algoritmo:
 * 
 * LEER: monedas2E, monedas1E, monedas50Cent, monedas20Cent, monedas10Cent 
 * CALCULAR: 
 * ESCRIBIR: 
 * 
 */


 public class Ejercicio20TotalDinero {
   public static void  main(String[] args) {
     
    // Definimos las variables:

   String linea;
   double monedas2E;
   double monedas1E;
   double monedas50Cent;
   double monedas20Cent;
   double monedas10Cent; 

  

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce el total de monedas de 2 euros que tienes: ");
    linea = System.console().readLine();
    monedas2E = Double.parseDouble(linea);
    

    System.out.println("Introduce el total de monedas de 1 euro que tienes: ");
    linea = System.console().readLine();
    monedas1E = Double.parseDouble(linea);
   
    System.out.println("Introduce el total de monedas de 50 centimos que tienes: ");
    linea = System.console().readLine();
    monedas50Cent = Double.parseDouble(linea);

    System.out.println("Introduce el total de monedas de 20 centimos que tienes: ");
    linea = System.console().readLine();
    monedas20Cent = Double.parseDouble(linea);

    System.out.println("Introduce el total de monedas de 10 centimos que tienes: ");
    linea = System.console().readLine();
    monedas10Cent = Double.parseDouble(linea);
    

    // Calculos

    double total2E = monedas2E * 2;
    double total1E = monedas1E * 1;
    double totalEuros = total2E + total1E;
    double total50Cent = monedas50Cent * 0.50;
    double total20Cent = monedas20Cent * 0.20;
    double total10Cent = monedas10Cent * 0.10;
    double totalCentimos = total50Cent +total20Cent + total10Cent;
    totalEuros = (totalEuros+totalCentimos)/100;
    totalCentimos = (totalCentimos%100);




    // Mostramos los resultados por pantalla

    System.out.println("Tienes en total:  " + totalEuros + " euros y " + totalCentimos + " centimos");
    

   }
 }