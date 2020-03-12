package secuencialesJava;
/**
* Programa: Ejercicio3Hipotenusa.java
*
* Proposito: 3. Dados los catetos de un triángulo rectángulo, calcular su hipotenusa.
* 
* @author José Luis Álvarez Fernández
*
* Fecha: 2/11/2019
*/

/**
 * Variables:
 * cateto1 (double): almacenará el primer cateto del triangulo
 * cateto2 (double): almacenará el segundo cateto del triangulo rectangulo
 * hipotenusa (double): almacenará la hipotenusa del triangulo 
 * (hipotenusa = raiz cuadrada de cateto1 al cuadrado + raiz cuadrada de cateto2 al cuadrado)
 * 
 * Algoritmo:
 * 
 * LEER: cateto1, cateto2
 * CALCULAR: hipotenusa
 * ESCRIBIR: hipotenusa
 * 
 */



 public class Ejercicio3Hipotenusa {
  public static void main(String[] args) {

		// Definimos las variables:

		String linea;
		double cateto1;
		double cateto2;

		// Pedimos al usuario que introduzca los datos por pantalla:

		System.out.println("Introduce el valor del primer cateto: ");
		linea = System.console().readLine();
		cateto1 = Double.parseDouble(linea);

		System.out.println("Introduce el valor del segundo cateto: ");
		linea = System.console().readLine();
		cateto2 = Double.parseDouble(linea);

		// Calculos:

		double hipotenusa = Math.sqrt(Math.pow(cateto1,2) + (Math.pow(cateto2,2)));

		// Mostramos los resultados por pantalla

		System.out.println("Dados tus datos, la hipotenusa del triangulo rectangulo es de: " + hipotenusa + " cm");
		



	
   }
 }