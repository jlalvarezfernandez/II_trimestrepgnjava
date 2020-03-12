package Arrays;

/**
 * Proposito: 8. Realiza un programa que pida la temperatura media que ha hecho en cada mes de un determinado año 
 *               y que muestre a continuación un diagrama de barras horizontales con esos datos. 
 *               Las barras del diagrama se pueden dibujar a base de asteriscos o cualquier otro carácter.
 *                              
 * @author José Luis Álvarez Fernández
 * Fecha: 24//11/2019
 * 
 * ANÁLISIS
 * ----------
 * Este programa tiene dos partes:
 * - 1º tenemos que crear un array para almacenar las 12 temperaturas medias introducidas por el usuario
 * - 2º despues recorremos ese array y dentro de el creamos otro array para asignar a cada temperatura del mes un simbolo para construir el diagrama 
 *
 * VARIABLES
 * ----------
 * tempMedia (entro): almacenará el array con los datos introducidos para las temperaturas medias
 * temperatura (cadena): almacenará cada temeratura media para convertirla en un simbolo y crear la grafica
 * 
 * 
 * ALGORTIMO
 * -----------
 * int[] tempMedia = new int [12]
 * String temperatura = ""
 * PARA i = 0 HASTA i<tempMedia.length
 *      LEER  tempMedia[i]
 * PARA i HASTA i<tempMedia.length
 *     PARA j HASTA i<tempMedia.length
 *         temperatura+= "*"
 * ESCRIBIR temperatura
 */
import java.util.Scanner;

public class Ejercicio8Arrays {

  public static void main(String[] args) {

    Scanner sc = new Scanner (System.in);

    // definimos las variables

    int[] tempMedia = new int [12];
    String temperatura = "";


    for (int i= 0 ; i<tempMedia.length; i++) {
      System.out.println("Introduce la temperatura media del mes " + (i+1) + " :");
      tempMedia[i]= sc.nextInt();
    }
    for (int i =0; i< tempMedia.length; i++) {
      for (int j =0; j< tempMedia[i]; j++) {
        temperatura+="*";
      }
      System.out.println("La temepratura del mes " + (i+1)+ " es de: " + temperatura);
    }
  }

}
