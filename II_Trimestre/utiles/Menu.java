
package utiles;

/**
 * Algunas especificaciones sobre Menú:
 *      Clase utilizada para la gestión de un menú. Se dedica a mostrar las opciones del menú y a recoger y devolver las opciones de un menú 
 *      Su estado serán las opciones a mostrar (array de cadenas) y el título (se muestra al principio)
 *      Su comportamiento será:
 *             Mostrará el menu (mostrar()). Será privado.
 *             Recogerá la opción válida (entre las opciones del menú). Se usará un bucle para que devuelva una opción válida. Será privado.
 *             Gestionará el menú. A la vez se mostrarán las opciones y se recogerá la opción  seleccionada por el usuario. 
 *             Invocará a las dos anteriores. Será el único método público (switch(menu.gestionar()){...}
 *             Hará uso de la clase Teclado (Teclado.leerEntero())
 *
 *
 *@author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

public class Menu {
  
  private static void main (String args[]) {
    
  
  int opcion = 0;
  
  
  do {
    System.out.println("BIENVENIDO A GESTISIMAL");
    System.out.println("---------------------------");
    System.out.println();
    System.out.println("1) LISTADO:");
    System.out.println("2) ALTA:");
    System.out.println("3) BAJA: ");
    System.out.println("4) MODIFICACI�N: ");
    System.out.println("5) ENTRADA DE MERCANCIA: ");
    System.out.println("6) SALIDA DE MERCANCIA: ");
    System.out.println("7) SALIR: ");
    System.out.println();
    System.out.println("---------------------------");
    opcion = Teclado.leeEntero("INTRODUCE UNA OPCCIÓN: ");
    
  }while (opcion != 7);
  
  
  
  
}
}

 
