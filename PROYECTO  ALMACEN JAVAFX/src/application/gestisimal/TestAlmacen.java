package application.gestisimal;


import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import application.gestisimal.utiles.Menu;
import application.gestisimal.utiles.Teclado;

public class TestAlmacen {
  static Almacen almacen = new Almacen();
  static Menu menu = new Menu("ALMACÉN DE ARTÍCULOS", new String[] {
      "Listado Artículos", "Alta Artículos", "Baja Artículo", 
      "Modificación de la Descripción", "Entrada Mercancía", "Salida Mercancía", "Exportar CSV", "Importa CSV",
      "Exportar XML", "Importar XML", "Exportar JSON", "Importar JSON", "Salir"});
  static Menu menuIva = new Menu("TIPO DE IVA", new String[] {
      "General", "Reducido", "Superreducido"});



  public static void main(String[] args) throws UnidadesNegativasErrorExcepcion, PrecioNegativoErrorExcepcion, JSONException, CSVExcepcion, XMLExcepcion , IvaInvalidoExcepcion, CodigoArticuloNoExisteExcepcion, ParserConfigurationException, IOException, SAXException, CampoVacioException, PrecioIncorrecto {
    
    // Creamos varios objetos para hacer pruebas
    
    almacen.annade("descripcion", 5.5, 10, 3, TipoIva.GENERAL,20);
    almacen.annade("soldador", 200, 750, 250, TipoIva.GENERAL,40);
    
    do {
      System.out.println("BIENVENIDO A GESTISIMAL");
      System.out.println("---------------------------");
      System.out.println();
      switch (menu.gestionar()) {
      case 1:
        for (Articulo articulo : almacen) {
          System.out.println(articulo);
        }
        break;
      case 2:
        annade();
        break;
      case 3:
        baja();
        break;
      case 4:
        modificacion();
        break;
      case 5:
        entradaMercancia();
        break;
      case 6:
        salidaMercancia();
        break;
      case 7:
        exportarCSV();
        break;
      case 8:
        importarCSV();
        break;
      case 9:
        exportaXML();
        break;
      case 10:
        importaXML();
        break;
      case 11:
        exportaJSON();
        break;
      case 12:
        importaJSON();
        break;
      default:
        System.out.println("Has salido de la gestión del almacén");
        System.exit(1);
      }
    } while (true);
    
  }
  

  //////MÉTODOS PARA LA GESTIÓN DEL ALMACÉN///////////
 

  
  // Método para añadir articulos al almacén
 /**
  * Método para añadir nuevos artículos al almacén
 * @throws CampoVacioException 
 * @throws PrecioIncorrecto 
 * @throws UnidadesNegativasErrorExcepcion 
 * @throws PrecioNegativoErrorExcepcion 
  */

  private static void annade() throws CampoVacioException, PrecioIncorrecto  {
    try {
      String descripcion = Teclado.getLeeCadena("Introduce la descripción del producto: ");
      double precioCompra = Teclado.getLeeReal("Introduce el precio de compra del artículo: ");
      double precioVenta = Teclado.getLeeReal("Introduce el precio de venta del artículo: ");
      int numUnidades = Teclado.getLeeEntero("Introduce el número de unidades del artículo: ");
      int stockMin = Teclado.getLeeEntero("Introduce el stock mínimo del artículo: ");

      almacen.annade(descripcion, precioCompra, precioVenta, numUnidades, pideIva(), stockMin);
      
    } catch (UnidadesNegativasErrorExcepcion |PrecioNegativoErrorExcepcion | IvaInvalidoExcepcion | CampoVacioException e) {
      System.err.println(e.getMessage());
    } 
    
  }
  
  private static TipoIva pideIva() {
    int opcion = menuIva.gestionar();
    if (opcion == 1) {
      return TipoIva.GENERAL;
    } else if (opcion == 2) {
      return TipoIva.REDUCIDO;
    } else{
      return TipoIva.SUPERREDUCIDO;
    } 
  }


  // Método para dar de baja artículos del almacén
  /**
   * Método para dar de baja artículos del almacén
   * Para ello deberemos eliminar el código del articulo deseado
   * @throws CodigoArticuloNoExisteExcepcion 
   */

  private static void baja() throws CodigoArticuloNoExisteExcepcion {
    
    if (!almacen.baja(Teclado.getLeeEntero("Código del producto que desee borrar:"))) 
      System.err.println("Código inexistente");
   
  }
  
  // Método para modificar los artículos del almacén
  /**
   * Método para modificar los artículos del almacén
   * modificaremos todos los atributos del artículo (código, descripción, precioCompra, precioventa, numUnidades)
   * @throws UnidadesNegativasErrorExcepcion 
   * @throws PrecioNegativoErrorExcepcion 
   * @throws CampoVacioException 
   * @throws PrecioIncorrecto 
   */
  private static void modificacion() throws CodigoArticuloNoExisteExcepcion, UnidadesNegativasErrorExcepcion, PrecioNegativoErrorExcepcion, IvaInvalidoExcepcion, CampoVacioException, PrecioIncorrecto  {
    try {
      int codigo = Teclado.getLeeEntero("Introduce el código del artículo a modificar: ");
      String descripcion = Teclado.getLeeCadena("Introduce la nueva descripción del artículo: ");
      double precioCompra = Teclado.getLeeReal("Introduce el nuevo precio de compra del artículo: ");
      double precioVenta = Teclado.getLeeReal("Introduce el nuevo precio de venta del artículo: ");
      int numUnidades = Teclado.getLeeEntero("Introduce el nuevo número de unidades del artículo: ");
      int stockMin = Teclado.getLeeEntero("Introduce el nuevo stock mínimo del artículo: ");

      almacen.modificacion(codigo, descripcion,precioCompra,precioVenta,numUnidades, pideIva(), stockMin);
    } catch (CodigoArticuloNoExisteExcepcion | UnidadesNegativasErrorExcepcion |PrecioNegativoErrorExcepcion  | IvaInvalidoExcepcion e) {
      System.err.println(e.getMessage());
  }
}
  
  // Método para la entrada de mercancia
  /**
   * Método para la entrada de mercancia
   * Es necesario pedir la cantidad de mercancia a incrementarse
   * @throws CodigoArticuloNoExisteExcepcion 
   * @throws UnidadesNegativasErrorExcepcion 
   */
  
  private static void entradaMercancia()  {
    try {
      int codigo = Teclado.getLeeEntero("Introduce el código del artículo que vas a aumentar sus unidades: ");
      int cantidad = Teclado.getLeeEntero("Introduce la cantidad de mercancía a incrementar: ");
      almacen.incremetaMercancia(codigo, cantidad);
    }catch (CodigoArticuloNoExisteExcepcion | UnidadesNegativasErrorExcepcion e) {
      System.err.println(e.getMessage());
    }
  }
  
  // Método para la salida de mercancía
  private static void salidaMercancia(){
    try {
      int codigo = Teclado.getLeeEntero("Introduce el código del artículo que vas a decrementar sus unidades: ");
      int cantidad = Teclado.getLeeEntero("Introduce la cantidad de mercancía a decrementar: ");
      if (cantidad < 0){
        System.err.println("Error, la cantidad no puede ser negativa");
      }
      almacen.decremetaMercancia(codigo, cantidad);

    }catch (CodigoArticuloNoExisteExcepcion | UnidadesNegativasErrorExcepcion e) {
      System.err.println(e.getMessage());
    }
  }
  
  /**
   * Método para importar los productos del almacen a un fichero JSON
   * @throws JSONException 
   */

  private static void exportaJSON() throws JSONException {
    String archivo = Teclado.getLeeCadena("Introduce el nombre del archivo JSON para exportarlo");

    try {
      almacen.exportaJSON(archivo);
    } catch (JSONException e) {
      System.err.println("Error, no se ha podido exportar el fichero en formato JSON"); 
    }
  }
    
  
 /**
  * Método para importar un archivo JSON
  * @throws JSONException
  */
  
  private static void importaJSON() throws JSONException {
    String archivo = Teclado.getLeeCadena("Introduce el nombre del fichero CSV.");
    try {
      almacen.importaJSON(archivo);
    } catch (JSONException e) {
      throw new JSONException("No se ha podido leer el archivo" + archivo + ": " + e.getMessage());
    }

  }

  

  /**
   * Método para importar un archivo xml
   * @throws XMLExcepcion
   */
  private static void exportaXML() throws XMLExcepcion {
    String archivo = Teclado.getLeeCadena("Introduce el nombre del archivo XML para exportarlo");

    try {
      almacen.exportaXML(archivo);
    } catch (XMLExcepcion e) {
      System.err.println("Error, no se ha podido exportar el fichero en formato XML"); 
    }
  }
  
  /**
   * Método para exportar un archivo xml
   * @throws XMLExcepcion
   * @throws IvaInvalidoExcepcion 
   * @throws PrecioNegativoErrorExcepcion 
   * @throws UnidadesNegativasErrorExcepcion 
   * @throws SAXException 
   * @throws IOException 
   * @throws ParserConfigurationException 
   * @throws CampoVacioException 
   * @throws PrecioIncorrecto 
   */
  private static void importaXML()throws XMLExcepcion, ParserConfigurationException, IOException, SAXException, UnidadesNegativasErrorExcepcion, PrecioNegativoErrorExcepcion, IvaInvalidoExcepcion, CampoVacioException, PrecioIncorrecto  {
    String archivo = Teclado.getLeeCadena("Introduce el nombre del archivo XML para importarlo");

    try {
      almacen.importaXML(archivo);
    } catch (XMLExcepcion e) {
      System.err.println("Error, no se ha podido importar el fichero en formato XML"); 
    }
  }
    
  /**
   * Método para importar los productos del almacen a un fichero CSV
   * @throws CSVExcepcion 
   * @throws ErrorUnidadesNegativas 
   * @throws NumberFormatException 
   * @throws PrecioNegativoErrorExcepcion 
   * @throws IvaInvalidoExcepcion 
   */
  
  private static void importarCSV() throws CSVExcepcion, NumberFormatException, UnidadesNegativasErrorExcepcion, PrecioNegativoErrorExcepcion, IvaInvalidoExcepcion {
    String archivo = Teclado.getLeeCadena("Introduce el nombre del archivo CSV para importarlo");

    try {
      almacen.importarCSV(archivo);

    } catch (CSVExcepcion e) {
      System.err.println("Error, no se ha podido importar el fichero en formato CSV"); 
    }
  }

  /**
   * Método para exportar el fichero en formato csv
   * @throws CSVExcepcion
   */

  private static void exportarCSV() throws CSVExcepcion {
    String archivo = Teclado.getLeeCadena("Introduce el nombre del archivo CSV para importarlo");

    try {
      almacen.exportaCSV(archivo);

    } catch (CSVExcepcion e) {
      System.err.println("Error, no se ha podido exportar el fichero en formato CSV"); 
    }
  }

}


