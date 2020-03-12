package secuencialesJava;
/**
* Programa: Ejercicio18MostarIniciales.java
*
* Proposito: 18. Pedir el nombre y los dos apellidos de una persona y mostrar las iniciales.
*
*
* @author José Luis Álvarez Fernández
*
* Fecha: 4/11/2019
*/

/**
 * Variables:
 * nombre (String): almacenará el nombre del usuario.
 * apellido1 (String): almacenará el priemr apellido del usuario.
 * apellido2 (String): almacenará el segundo apellido del usuario.
 * inicialNombre (String): almacenará la primera letra del nombre en mayusculas
 * inicialApellido1 (String): almacenará la primera letra del apellido1 en mayusculas
 * inicialApellido2 (String):almacenará la primera letra del apellido2 en mayusculas
 * 
 * Algoritmo:
 * 
 * LEER: nombre, apellido1, apellido2
 * CALCULAR: inicialNombre, inicialApellido1, inicialApellido2
 * ESCRIBIR: inicialNombre, inicialApellido1, inicialApellido2
 * 
 */


 public class Ejercicio18MostarIniciales {
   public static void  main(String[] args) {
     
    // Definimos las variables:

   String nombre;
   String apellido1;
   String apellido2;

  

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce tu nombre: ");
    nombre = System.console().readLine();
    

    System.out.println("Introduce tu primer apellido: ");
    apellido1 = System.console().readLine();
   

    System.out.println("Introduce tu segundo apellido: ");
    apellido2 = System.console().readLine();
    

    // Calculos

    String inicialNombre = Character.toUpperCase(nombre.charAt(0)) + nombre.substring(1,nombre.length());
    String inicialApellido1 = Character.toUpperCase(apellido1.charAt(0)) + apellido1.substring(1,apellido1.length());
    String inicialApellido2 = Character.toUpperCase(apellido2.charAt(0)) + apellido2.substring(1,apellido2.length());


    // Mostramos los resultados por pantalla

    System.out.println("Tu nombre es: " + inicialNombre + ", tu primer apellido: " + inicialApellido1 + " y tu segundo apellido " + inicialApellido2);
    

   }
 }