package secuencialesJava;
/**
* Programa: Ejercicio19NotaFinal.java
*
* Proposito: 19. Escribir un algoritmo para calcular la nota final de un estudiante, 
*                considerando que por cada respuesta correcta 5 puntos, 
*                por una incorrecta -1 
*                y por respuestas en blanco 0. 
*                Imprime el resultado obtenido por el estudiante.
*
*
*
*
* @author José Luis Álvarez Fernández
*
* Fecha: 4/11/2019
*/

/**
 * Variables:
 * respAcertadas (double): almacenará las respuestas acertadas
 * respIncorrectas (double): almacenará las respuestas incorrectas
 * respBlanco (double): almacenará las respuestas en blanco
 * 
 * Algoritmo:
 * 
 * LEER: respAcertadas, respIncorrectas, respBlanco
 * CALCULAR: totalPuntos, totalRespuestas,  notaFinal
 * ESCRIBIR: totalPuntos, totalRespuestas,  notaFinal
 * 
 */


 public class Ejercicio19NotaFinal {
   public static void  main(String[] args) {
     
    // Definimos las variables:

   String linea;
   double respAcertadas;
   double respIncorrectas;
   double respBlanco;

  

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce el total de respuestas acertadas: ");
    linea = System.console().readLine();
    respAcertadas = Double.parseDouble(linea);
    

    System.out.println("Introduce el total de respuestas incorrectas: ");
    linea = System.console().readLine();
    respIncorrectas = Double.parseDouble(linea);
   
    System.out.println("Introduce el total de respuestas en blanco: ");
    linea = System.console().readLine();
    respBlanco = Double.parseDouble(linea);
    

    // Calculos

    double totalPuntos = respAcertadas * 5 + respIncorrectas * (-1) + respBlanco;
    double totalRespuestas = respAcertadas + respBlanco + respIncorrectas;
    double notaFinal = ((10 * totalPuntos) /  (totalRespuestas * 5));


    // Mostramos los resultados por pantalla

    System.out.println("la nota final dela lumno será un: " + notaFinal);
    

   }
 }