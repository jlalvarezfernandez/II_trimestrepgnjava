package secuencialesJava;
/**
* Programa: Ejercicio8SueldoBase.java
*
* Proposito: 8. Un vendedor recibe un sueldo base mas un 10% extra por comisión de sus ventas,
                el vendedor desea saber cuanto dinero obtendrá por concepto de comisiones por las tres ventas que realiza en el mes 
                y el total que recibirá en el mes tomando en cuenta su sueldo base y comisiones.
* 
* @author José Luis Álvarez Fernández
*
* Fecha: 2/11/2019
*/
/**
 * Variables:
 * sueldoBase (double): almacenará el sueldo base del vendedor
 * venta1 (double): almacenará el valor de la primera venta
 * venta2 (double): almacenará el valor de la segunda venta
 * venta3 (double): almacenará el valor de la tercera venta
 * comision (double): alamcenará la comision por las tres ventas ( venta1 + venta2 + venta3) / 0.10
 * sueldoTotal (double): alamcenara el sueldo total de vendedor (sueldoBase+ comision)
 * 
 *   
 * 
 * Algoritmo:
 * 
 * LEER: sueldoBase, venta1 + venta2 + venta3
 * CALCULAR: comision
 * ESCRIBIR: sueldoTotal
 * 
 */

 public class Ejercicio8SueldoBase {
   public static void  main(String[] args) {
     
    // Definimos las variables:

    String linea;
    double sueldoBase;
    double venta1;
    double venta2;
    double venta3;

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce el sueldo base del vendedor: ");
    linea = System.console().readLine();
    sueldoBase = Double.parseDouble(linea);

    System.out.println("Introduce la primera venta: ");
    linea = System.console().readLine();
    venta1 = Double.parseDouble(linea);

    System.out.println("Introduce la segunda venta: ");
    linea = System.console().readLine();
    venta2 = Double.parseDouble(linea);

    System.out.println("Introduce la tercera venta: ");
    linea = System.console().readLine();
    venta3 = Double.parseDouble(linea);

    // Calculos

   double comision = ((venta1 + venta2 + venta3) * 0.10);
   double sueldoTotal = (sueldoBase + comision);


    // Mostramos los resultados por pantalla

    System.out.println("El sueldo total del trabajador será de : " + sueldoTotal + " euros");



   }
 }