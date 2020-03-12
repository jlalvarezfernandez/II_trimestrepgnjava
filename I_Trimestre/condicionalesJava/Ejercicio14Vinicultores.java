package condicionalesJava;
/**
* Programa: Ejercicio14Vinicultores.java
*
* Proposito: 14. La asociación de vinicultores tiene como política fijar un precio inicial al kilo de uva, 
*                la cual se clasifica en tipos A y B, y además en tamaños 1 y 2. 
*                Cuando se realiza la venta del producto, ésta es de un solo tipo y tamaño, 
*                se requiere determinar cuánto recibirá un productor por la uva que entrega en un embarque, 
*                considerando lo siguiente: 
*                si es de tipo A, se le cargan 20 céntimos al precio inicial cuando es de tamaño 1; y 30 céntimos si es de tamaño 2.
*                Si es de tipo B, se rebajan 30 céntimos cuando es de tamaño 1, y 50 céntimos cuando es de tamaño 2. 
*                Realice un algoritmo para determinar la ganancia obtenida.
*
*
*
* @author José Luis Álvarez Fernández
*
* Fecha: 5/11/2019
*/

/**
 * Variables:
 * annio (double): almacenará el año introducido
 * 
 * 
 * Algoritmo:
 * LEER: annio
 * CALCULAR: si el resto del año intruducido y dividido entre 4 o 400 es cero el año es bisiesto 
 */
import java.util.Scanner;

 public class Ejercicio14Vinicultores {
   public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Definimos las variables:

    char tipo;
    double tamanio;
    double precioInicial;
    double kilos;
    

  
    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce el tipo de uva (A/B): ");
    tipo = sc.next().charAt(0);

    System.out.println("Introduce el tamaño de la uva (1/2): ");
    tamanio = sc.nextDouble();

    System.out.println("Introduce el precio inicial del kilo de uvas: ");
    precioInicial = sc.nextDouble();

    System.out.println("Introduce los kilos de uvas: ");
    kilos = sc.nextDouble();


  // Calculos

  double precioFinal = 0;

  if (tipo == 'A' || tipo == 'a') {
    if (tamanio == 1){
      precioFinal = (precioInicial + 0.20);
    }
  }
  
  if (tipo == 'A' || tipo == 'a'){
    if (tamanio == 2){
      precioFinal = (precioInicial + 0.30);
      }
    }
  
  if (tipo == 'B' || tipo == 'b') {
      if (tamanio == 1){
        precioFinal = (precioInicial - 0.30);
      }
    }
    
    if (tipo == 'B' || tipo == 'b'){
      if (tamanio == 2){
        precioFinal = (precioInicial - 0.50);
        }
      }
      
    double ganancia = (precioFinal * kilos);
    System.out.println("La ganancia del vinicultor será de: " + ganancia + " euros");
  }

}
