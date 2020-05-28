package gentesimal;

import utiles.Menu;
import utiles.Teclado;

public class TestAlmacen {
  static Almacen almacen = new Almacen();
  static Menu menu = new Menu("ALMACÉN DE ARTÍCULOS\n", new String[] {
      "Listado de Artículos", "Alta Artículos", "Baja de Artículo", "Modificación de Artículos",
      "Entrada de Mercancía", "Salida de Mercancía"});


  public static void main(String[] args) throws UnidadesNegativasErrorExcepcion, PrecioNegativoErrorExcepcion  {
    
    // Creamos varios objetos para hacer pruebas
    
    almacen.annade("descripcion", 5.5, 10, 3);
    almacen.annade("soldador", 200, 750, 250);
    
    do {
      System.out.println("BIENVENIDO A GESTISIMAL");
      System.out.println("---------------------------");
      System.out.println();
      switch (menu.gestionar()) {
      case 1:
        System.out.println(almacen);
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
 * @throws UnidadesNegativasErrorExcepcion 
 * @throws PrecioNegativoErrorExcepcion 
  */

  private static void annade()  {
    try {
      String descripcion = Teclado.getLeeCadena("Introduce la descripción del producto: ");
      double precioCompra = Teclado.getLeeReal("Introduce el precio de compra del artículo: ");
      double precioVenta = Teclado.getLeeReal("Introduce el precio de venta del artículo: ");
      int numUnidades = Teclado.getLeeEntero("Introduce el número de unidades del artículo: ");
      almacen.annade(descripcion, precioCompra, precioVenta, numUnidades);
      
    } catch (UnidadesNegativasErrorExcepcion |PrecioNegativoErrorExcepcion  e) {
      System.err.println(e.getMessage());
    } 
  }
  
  // Método para dar de baja artículos del almacén
  /**
   * Método para dar de baja artículos del almacén
   * Para ello deberemos eliminar el código del articulo deseado
   */

  private static void baja() {
    if (!almacen.baja(Teclado.getLeeEntero("Código del producto que desee borrar:"))) 
      System.err.println("Código inexistente");
   
  }
  
  // Método para modificar los artículos del almacén
  /**
   * Método para modificar los artículos del almacén
   * modificaremos todos los atributos del artículo (código, descripción, precioCompra, precioventa, numUnidades)
   * @throws UnidadesNegativasErrorExcepcion 
   * @throws PrecioNegativoErrorExcepcion 
   */
  private static void modificacion()  {
    try {
      int codigo = Teclado.getLeeEntero("Introduce el código del artículo a modificar: ");
      String descripcion = Teclado.getLeeCadena("Introduce la nueva descripción del artículo: ");
      double precioCompra = Teclado.getLeeReal("Introduce el nuevo precio de compra del artículo: ");
      double precioVenta = Teclado.getLeeReal("Introduce el nuevo precio de venta del artículo: ");
      int numUnidades = Teclado.getLeeEntero("Introduce el nuevo número de unidades del artículo: ");
      almacen.modificacion(codigo, descripcion,precioCompra,precioVenta,numUnidades);
    } catch (CodigoArticuloNoExisteExcepcion | UnidadesNegativasErrorExcepcion |PrecioNegativoErrorExcepcion  e) {
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
}


