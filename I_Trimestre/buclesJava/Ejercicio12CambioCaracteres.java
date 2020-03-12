package buclesJava;
/**
* Programa: Ejercicio12CambioCaracteres.java
*
* Proposito: 12. Pide una cadena y dos caracteres por teclado (valida que sea un carácter), 
*                sustituye la aparición del primer carácter en la cadena por el segundo carácter.
*

* 
* @author José Luis Álvarez Fernández
*
* Fecha: 9/11/2019
*/

/**
 * Variables:
 * cadena (cadena): almacenará la cadena introducida
 * caracterASustituir (cadena): almacenará el caracter que queremos cambiar de esa cadena
 * caracterNuevo (cadena): almacenará el caracter nuevo que se cambiara por el caracterASustituir
 * cambio (cadena): almacenará el cambio de los caracters (replace)
 * 
 * Algoritmo:
 * 
 * leemos los datos para la cadena y los caracteres
 * bucle while mientras la longitud de los caracteres introducidos sea distinta de 1 los volvemos a pedir
 * 
 * bucle for que recorre la cadena
 * la variable cambio es igual a cadena.replace de caracterASustituir caracterNuevo
 * mostramos los resultados
 *
 */



import java.util.Scanner;
 
 public class Ejercicio12CambioCaracteres {
   public static void main(String []args) {

    Scanner sc = new Scanner (System.in);

    // Definimos las variables

    String cadena;
    String caracterASustituir;
    String caracterNuevo;
    String cambio = "";

  
    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce una frase por pantalla: ");
    cadena = sc.nextLine();

    System.out.println("Introduce el caracter a sustituir: ");
    caracterASustituir = sc.nextLine();

    System.out.println("Introduce el caracter nuevo: ");
    caracterNuevo = sc.nextLine();


    // Calculos
    
    //validar que sea un caracter

    while (caracterASustituir.length() != 1 || (caracterNuevo.length() != 1)) {
    	System.out.println("Debes introducir solamente un caracter");
    	
    	System.out.println("Introduce el caracter a sustituir: ");
    	caracterASustituir = sc.nextLine();
    	System.out.println("Introduce el caracter nuevo: ");
    	caracterNuevo = sc.nextLine();
    }
    
    for (int i = 0; i< cadena.length(); i++) {
    	cambio = cadena.replace(caracterASustituir, caracterNuevo);
    	
    }
    
    System.out.println("La nueva cadena es: "+ cambio);
    	
    
    
    
    // sustituir primer caracter por el segundo y viceversa
    
    
    
    

   



    }
  }