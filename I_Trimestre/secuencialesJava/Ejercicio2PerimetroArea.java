package secuencialesJava;
/**
* Programa: Ejercicio2PerimetroArea.java
*
* Proposito: 2. Calcular el perí­metro y área de un rectángulo dada su base y su altura.
* 
* @author José Luis Álvarez Fernández
*
* Fecha: 1/11/2019
*/

/**
 * Variables:
 * base (double): almacenará la base del rectangulo
 * altura (double): almacenará la altura del rectangulo
 * perimetro (double): almacenará el perimetro del rectangulo (base2+altura2)
 * area (double): almacenará el area del rectangulo (base*altura)
 * 
 * Algoritmo:
 * 
 * LEER: lado1, lado2
 * CALCULAR: perimetro, area
 * ESCRIBIR: perimetro,area
 * 
 */


 public class Ejercicio2PerimetroArea {
  public static void main(String[] args) {

		// Definimos las variables:

		String linea;
		double base;
		double altura;

		// Pedimos al usuario que introduzca los datos por pantalla:

		System.out.println("Introduce la base del rectangulo en cm: ");
		linea = System.console().readLine();
		base = Double.parseDouble(linea);

		System.out.println("Introduce la altura del rectangulo en cm: ");
		linea = System.console().readLine();
		altura = Double.parseDouble(linea);

		// Calculos:

		double perimetro = (base*2 + altura*2);
		double area = (base * altura);

		// Mostramos los resultados por pantalla

		System.out.println("Dados tus datos, el perimetro del rectangulo es de: " + perimetro + " cm, y el área es de: " + area + " cm");
		

   }
 }