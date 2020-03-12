package secuencialesJava;
/**
* Programa: Ejercicio10CalificacionFinal.java
*
* Proposito: 10. Un alumno desea saber cual será su calificación final en la materia de Algoritmos. 
*             Dicha calificación se compone de los siguientes porcentajes:
*
*                 55% del promedio de sus tres calificaciones parciales.
*
*                 30% de la calificación del examen final.
*
*                 15% de la calificación de un trabajo final.
*
*
* @author José Luis Álvarez Fernández
*
* Fecha: 2/11/2019
*/
/**
 * Variables:
 * parcial1 (double): almacenará la nota del primer examen parcial
 * parcial2 (double): almacenará la nota del segundo examen parcial
 * parcial3 (double): almacenará la nota del tercer examen parcial
 * examenFinal (double): almacenará la nota del examen final
 * trabajo (double): alamcenará la nota del trabajo final
 * mediaParciales (double): almacenará la media de los tres examenes y su respectivo porcentaje sobre la nota final 
 *                          ((parcial1 + parcial2 + parcial3) / 3) * 0.55))
 * notaFinalExamen (double): almacenará la nota del examen final con su correspondiente porcentaje (examenFinal * 0.30)
 * notaFinalTrabajo (double): almacenará la nota del trabajo final con su correspondiente porcentaje (trabajo * 0.15)
 * calificacionFinal (double): almacenará la nota calificacion final del alumno (mediaParciales + notaFinalExamen + notaFinalTrabajo)
 * 
 * 
 * Algoritmo:
 * 
 * LEER: parcial1, parcial2, parcial3, examenFinal, trabajo
 * CALCULAR: mediaParciales, notaFinalExamen, notaFinalTrabajo, calificacionFinal
 * ESCRIBIR: calificacionfinal
 * 
 */

 public class Ejercicio10CalificacionFinal {
   public static void  main(String[] args) {
     
    // Definimos las variables:

    String linea;
    double parcial1;
    double parcial2;
    double parcial3;
    double examenFinal;
    double trabajo;
  

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce la nota del primer examen parcial: ");
    linea = System.console().readLine();
    parcial1 = Double.parseDouble(linea);

    System.out.println("Introduce la nota del segundo examen parcial: ");
    linea = System.console().readLine();
    parcial2 = Double.parseDouble(linea);

    System.out.println("Introduce la nota del tercer examen parcial: ");
    linea = System.console().readLine();
    parcial3 = Double.parseDouble(linea);

    System.out.println("Introduce la nota del examen final: ");
    linea = System.console().readLine();
    examenFinal = Double.parseDouble(linea);

    System.out.println("Introduce la nota del trabajo final: ");
    linea = System.console().readLine();
    trabajo = Double.parseDouble(linea);



    // Calculos

   double mediaParciales = (((parcial1 + parcial2 + parcial3) /3) * 0.55);
   double notaFinalExamen = (examenFinal * 0.30);
   double notaFinalTrabajo = (trabajo * 0.15);
   double calificacionFinal = (mediaParciales + notaFinalExamen + notaFinalTrabajo);
   
    // Mostramos los resultados por pantalla

    System.out.println("La nota final del alumno en la materia de algoritmos será un: " + calificacionFinal);



   }
 }