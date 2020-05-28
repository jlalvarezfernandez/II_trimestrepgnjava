package gentesimal;

import java.util.ArrayList;


/**
 * Clase Almacen que realice: 
 *       - alta
 *       - baja 
 *       - modificación 
 *       - entrada de mercancía(incrementa unidades) 
 *       - salida de mercancía (decrementa unidades)
 * 
 * El estado será un ArrayList de artículos. 
 * Su comportamiento será: 
 *      - añadir artículos (no puede haber dos artículos iguales) 
 *      - eliminar artículos
 *      - incrementar las existencias de un artículo (se delega en la clase artículo)
 *      - decrementar las existencias de un artículo (nunca por debajo de cero, se delega en la clase artículo devolver un artículo (para mostrarlo).
 * 
 * Para listar el almacén podrá devolverse una cadena con todos los artículos del almacén (toString)
 * 
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 * 
 *
 */

public class Almacen {
  
  // creamos el arrayList que es un estado de la clase Articulo
  
  private ArrayList<Articulo> almacen = new ArrayList<Articulo>();
  
  // Método para añadir nuevos articulos en el almacén
  
  /**
   * Método para añadir nuevos articulos en el almacén
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param numUnidades
   * @throws PrecioNegativoErrorExcepcion 
   */
  
  public void annade(String descripcion, double precioCompra, double precioVenta, int numUnidades) throws UnidadesNegativasErrorExcepcion, PrecioNegativoErrorExcepcion{
    almacen.add(new Articulo(descripcion, precioCompra, precioVenta,numUnidades));
  }
  
  
  // Método para dar de baja un artículo del almacén
  /**
   * Metodo para dar de baja un artículo que tenemos en el almacén
   * @param codigo
   * @return error si ese código no existe
   */
  
  boolean baja(int codigo) {
    return almacen.remove(new Articulo(codigo));
    
  }
  
  // Método get para acceder a los getters de los artículos del almacén
  /**
   * Método get para acceder a los getters de los artículos del almacén
   * @param codigo
   * @return
   * @throws CodigoArticuloNoExisteExcepcion
   */
  public Articulo get(int codigo) throws CodigoArticuloNoExisteExcepcion{
    try {
      return almacen.get(almacen.indexOf(new Articulo(codigo)));
    } catch (IndexOutOfBoundsException  e) {
      throw new CodigoArticuloNoExisteExcepcion("El código no existe");
    }
  }
  
  // Método para modificar los artículos del almacén
  /**
   * Método para modificar los artículos del almacén
   * @param codigo
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param numUnidades
   * @throws PrecioNegativoErrorExcepcion 
   */
  void modificacion(int codigo, String descripcion, double precioCompra, double precioVenta, int numUnidades) throws CodigoArticuloNoExisteExcepcion, UnidadesNegativasErrorExcepcion, PrecioNegativoErrorExcepcion {
    get(codigo).setDescripcion(descripcion);
    get(codigo).setPrecioCompra(precioCompra);
    get(codigo).setPrecioVenta(precioVenta);
    get(codigo).setNumUnidades(numUnidades);
    
  }
  
  // Método para incremetar las unidades de un artículo del almacén
  /**
   * Método para incremetar las unidades de un artículo del almacén
   * @param codigo
   * @param cantidad
   * @throws UnidadesNegativasErrorExcepcion 
   */

  void incremetaMercancia(int codigo, int cantidad)  throws CodigoArticuloNoExisteExcepcion, UnidadesNegativasErrorExcepcion{
    get(codigo).entradaMercancia(cantidad);
  }
  
  // Método para decrementar las unidades de un artículo del almacén
  /**
   * Método para decrementar las unidades de un artículo del almacén
   * @param codigo
   * @param cantidad
   */

  void decremetaMercancia(int codigo, int cantidad) throws CodigoArticuloNoExisteExcepcion, UnidadesNegativasErrorExcepcion{
    get(codigo).salidaMercancia(cantidad);
    
  }

  // Método toString para listar el almacén
  /**
   * Método toString para listar el almacén
   */

  @Override
  public String toString() {
    return "Almacen\n" + almacen;
  }
  
  
  
  
}
