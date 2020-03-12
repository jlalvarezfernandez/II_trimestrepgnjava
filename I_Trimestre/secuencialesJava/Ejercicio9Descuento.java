package secuencialesJava;
/**
* Programa: Ejercicio9Descuento.java
*
* Proposito: 9. Una tienda ofrece un descuento del 15% sobre el total de la compra 
                y un cliente desea saber cuanto deberá pagar finalmente por su compra.


* @author José Luis Álvarez Fernández
*
* Fecha: 2/11/2019
*/
/**
 * Variables:
 * precioInicial (double): almacenará el precio inicial del producto
 * descuento (double): almacenará el descuento aplicado al producto (precioIncial * 0.15)
 * precioFinal (double): almacenará el precio final del producto con el descuento incluido
 *   
 * 
 * Algoritmo:
 * 
 * LEER: precioInicial
 * CALCULAR: descuento
 * ESCRIBIR: precioFinal
 * 
 */

 public class Ejercicio9Descuento {
   public static void  main(String[] args) {
     
    // Definimos las variables:

    String linea;
    double precioInicial;
  

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce el precio del producto: ");
    linea = System.console().readLine();
    precioInicial = Double.parseDouble(linea);


    // Calculos

   double descuento = (precioInicial * 0.15);
   double precioFinal = (precioInicial - descuento);
   
    // Mostramos los resultados por pantalla

    System.out.println("El precio final que el cliente pagará por el articulo será de: " + precioFinal + " euros");



   }
 }