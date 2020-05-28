
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
  
    
      private String titulo = null;
      private String opciones[] = null;
      private int numOpciones;

      /**
       * 
       * @param titulo
       *            título del menú
       * @param opciones
       *            opciones del menú
       */
      public Menu(String titulo, String[] opciones) {
        this.titulo = titulo;
        this.opciones = opciones;
        this.numOpciones = this.opciones.length;
      }

      /**
       * Gestiona el menú. Consiste en mostrar las opcines y recoger la opción
       * seleccionada por el usuario
       * 
       * @return opción válida del menú
       */
      public int gestionar() {
        mostrar();
        return recogerOpcion();
      }

      /**
       * Muestra las opciones del menú
       */
      private void mostrar() {
        int i = 1;
        System.out.println(titulo);
        for (String elemento : opciones)
          System.out.println("(" + (i++) + ") " + elemento);
      }

      /**
       * Recoge la opción válida del menú
       * 
       * @return opción válida
       */
      private int recogerOpcion() {
        int opcion;
        do {
          
          opcion = Teclado.getLeeEntero("\nIntroduce una opción valida: ");
        } while (opcion < 1 || opcion > numOpciones);
        return opcion;
      }
    }
 

