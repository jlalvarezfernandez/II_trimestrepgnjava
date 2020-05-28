package javaExamenIITrimestre;


import utiles.Menu;
import utiles.Teclado;


/**
 *  1. Crea una clase para gestionar una agenda de un máximo de 100 contactos en Java y haz un programa que la pruebe
 * Haz un test con un menú que me permita gestionar una agenda con todas sus opciones. Limita el tamaño de la agenda a 5 contactos.
 * @author @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

public class TestAgenda {


  static Agenda agenda = new Agenda();

  //creacion del menu
  static Menu menu = new Menu("AGENDA DE CONTACTOS", new String[] {
      "Listado Agenda", "Alta Contacto", "Borrar Contacto", "Buscar Contacto", "Reducir Agenda","Exportar CSV", "Importa CSV","Salir"});



  public static void main(String[] args) throws SuperadoLimiteMaximoContactos, NoExisteContacto, CSVExcepcion, DatosInvalidos {

    // creamos varios objetos para hacer las pruebas

    agenda.alta("Jose", "666999888", "calle Rio 2", "ajfru@hotmail.com");
    agenda.alta("Laura", "654789630", "calle Ulloa 5", "laura@hotmail.com");


    // Creamos el menú para elegir entre los diferentes métodos
    do {
      System.out.println("BIENVENIDO A LA AGENDA DE CONTACTOS");
      System.out.println("---------------------------");
      System.out.println();
      switch (menu.gestionar()) {
      case 1:
        System.out.println(agenda);
        break;
      case 2:
        alta();
        break;
      case 3:
        baja();
        break;
      case 4:
        busca();
        break;
      case 5:
        reducir();
        break;
      case 6:
        exportarCSV();
        break;
      case 7:
        importarCSV();
        break;
      default:
        System.out.println("HAS SALIDO DE LA AGENDA");
        System.exit(1);
      }
    } while (true);
  }

  
 /**
  * Método alta para dar de alta un contacto que introduzcamos en la agenda
 * @throws DatosInvalidos 
  */
  private static void alta() throws DatosInvalidos {
    try {
      String nombre = Teclado.leeCadena("Introduce el nombre del contacto: ");
      String telefono = Teclado.leeCadena("Introduce el número de teléfono del contacto: ");
      String direccion = Teclado.leeCadena("Introduce la direcion del contacto: ");
      String correoElectronico = Teclado.leeCadena("Introduce el correo electrónico de tu contacto: ");
      agenda.alta(nombre, telefono, direccion,correoElectronico);
    } catch (SuperadoLimiteMaximoContactos  e) {
      System.err.println(e.getMessage());
    }catch (DatosInvalidos e) {
      System.err.println("Error al introducir los datos");
    }
  }
  
  /**
   * Método baja para borra algun contacto de la agenda
   */

  private static void baja() {
    try {
      String nombre = Teclado.leeCadena("Introduce el nombre del contacto a borrar de la agenda: ");
      String telefono = Teclado.leeCadena("Introduce el telefono del contacto que deseas buscar: ");
      agenda.baja(nombre, telefono);
    } catch (NoExisteContacto e) {
      System.err.println(e.getMessage());
    }
  }
  
  /**
   * Método apra buscar un contacto de la agenda
   * @throws NoExisteContacto 
   */
  
  private static void busca() throws NoExisteContacto {
    try {
      String nombre = Teclado.leeCadena("Introduce el nombre del contacto que deseas buscar: ");
      System.out.println(agenda.busca(nombre));
    } catch (NoExisteContacto e) {
      System.err.println(e.getMessage());
    }        
  }
  
  /**
   * Método para reducir el tamaño de la agenda
   */
  
  private static void reducir() {
    try {
      int nuevoTamanio = Teclado.leeEntero("Introduce el nuevo tamaño de la agenda: ");
      agenda.reduce(nuevoTamanio);  
    } catch (DatosInvalidos e) {
      System.err.println(e.getMessage());
    }  
  }


  /**
   * Método para exportar la agenda a un fichero en csv 
   * @throws CSVExcepcion
   */
  private static void exportarCSV() throws CSVExcepcion{
    try {
      String archivo = Teclado.leeCadena("Introduce el nombre del archivo CSV para importarlo");
      agenda.exportaCSV(archivo);
    } catch (CSVExcepcion e) {
      System.err.println("Error, no se ha podido exportar el fichero en formato CSV"); 
    }
  }

  /**
   * Método para importar la agenda de un fichero en csv
   * @throws SuperadoLimiteMaximoContactos
   * @throws NoExisteContacto 
   * @throws DatosInvalidos 
   */

  private static void importarCSV() throws SuperadoLimiteMaximoContactos, NoExisteContacto, DatosInvalidos {
    try {
      String archivo = Teclado.leeCadena("Introduce el nombre del archivo CSV para importarlo");
      agenda.importarCSV(archivo);
    } catch (CSVExcepcion | NoExisteContacto e) {
      System.err.println("Error, no se ha podido importar el fichero en formato CSV"); 
    }
  }
}
