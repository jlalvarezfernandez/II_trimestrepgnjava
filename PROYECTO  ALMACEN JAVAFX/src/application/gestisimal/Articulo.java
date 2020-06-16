package application.gestisimal;



/**
 * Necesito una clase Articulo que representa a los artículos del almacén: 
 * 
 *       - Su estado será: 
 *       
 *              código
 *              descripción
 *              precio de compra
 *              precio de venta
 *              número de unidades (nunca negativas)
 *
 *       -Como comportamiento:
 *       
 *              Considero que el código va a generarse de forma automática en el constructor, 
 *              así no puede haber dos artículos con el mismo código. Esto implica que no puede modificarse el código de un artículo. 
 *              Sí el resto de las propiedades. 
 *              Podremos mostrar el artículo, por lo que necesito una representacion del artículo en forma de cadena (toString)
 * 
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

public class Articulo {

  // Creamos los atributos de la clase Artículo

  private int codigo;
  private String descripcion;
  private double precioCompra;
  private double precioVenta;
  private int numUnidades;
  private TipoIva tipoDeIva;
  private int stockMin;

  private static int siguienteCodigo = 1;

  // Creamos el constructor de la clase Artículo

  public Articulo(String descripcion, double precioCompra, double precioVenta, int numUnidades, TipoIva tipoDeIva, int stockMin) throws  PrecioNegativoErrorExcepcion, UnidadesNegativasErrorExcepcion, IvaInvalidoExcepcion, CampoVacioException, PrecioIncorrecto {


    setDescripcion(descripcion);
    setPrecioCompra(precioCompra);
    setPrecioVenta(precioVenta);
    setNumUnidades(numUnidades);
    setTipoDeIva(tipoDeIva);
    setStockMin(stockMin);
    this.codigo = generaCodigo();

  }

  // Creamos otro constructor para identificar el artículo con su código pasado como parametro
  /**
   *  Creamos otro constructor para identificar el artículo con su código pasado como parametro
   * @param codigo
   */

  public Articulo(int codigo) {
    this.codigo = codigo;
  }

  //////////// Creamos los Getters (observadores) y los Setters (modificadores) de la  clase Artículo \\\\\\\\\\\\\\\


  /**
   * Método Código
   * @return
   */

  public int getCodigo() {
    return codigo;
  }

  /**
   * getter para la descripcion (observador)
   * 
   * @return descripción
   */
  public String getDescripcion() {

    return descripcion;
  }


  // Setter para la descripción
  /**
   * Setter para la descripción
   * @param descripcion
   */
  void setDescripcion(String descripcion) throws CampoVacioException {
    if (descripcion.isEmpty()) 
      throw new CampoVacioException("La descripción esta vacía.");

    this.descripcion = descripcion;


  }

  /**
   * getter para el precio de compra (observador)
   * 
   * @return precioCompra
   */
  public double getPrecioCompra() {
    return precioCompra;
  }

  // Setter para el precio de compra y evitar que sea negatívo
  /**
   * Setter para el precio de compra y evitar que sea negativo
   * @param precioCompra
   * @throws PrecioNegativoErrorExcepcion 
   * @throws CampoVacioException 
   */
  void setPrecioCompra(double precioCompra) throws PrecioNegativoErrorExcepcion, CampoVacioException {
    if (precioCompra < 0) {
      throw new PrecioNegativoErrorExcepcion("El precio de compra no puede ser negativo");
    }
    if (String.valueOf(precioCompra).isEmpty()) {
      throw new CampoVacioException("El precio de compra esta vacio");
    }
    this.precioCompra = precioCompra;
  }

  /**
   * getter para el precio de venta (observador)
   * 
   * @return precioVenta
   */
  public double getPrecioVenta() {
    return precioVenta;
  }

  // Setter para el precio de venta
  /**
   * Setter para el precio de venta
   * @param precioVenta
   * @throws PrecioNegativoErrorExcepcion 
   * @throws CampoVacioException 
   * @throws PrecioIncorrecto 
   */
  void setPrecioVenta(double precioVenta) throws PrecioNegativoErrorExcepcion, CampoVacioException, PrecioIncorrecto {
    if (precioVenta < 0) {
      throw new PrecioNegativoErrorExcepcion("El precio de venta no puede ser negativo");
    }
    if (String.valueOf(precioVenta).equals("")) {
      throw new CampoVacioException("El precio de venta eno puede ser 0");
    }
    
    if(precioVenta < precioCompra) {
      throw new PrecioIncorrecto("El precio de venta no puede ser menor que le precio de compra");
    }
    this.precioVenta = precioVenta;
  }

  // Getter para el número de unidades
  /**
   * Getter para el número de unidades que tiene nuestro almacén
   * @return numUnidades
   */
  public int getNumUnidades() {
    return numUnidades;
  }

  // Setter para el número de unidades
  /**
   * Setter para el número de unidades del almacén evitando que sean negatívas
   * @param numUnidades
   * @throws UnidadesNegativasErrorExcepcion 
   */
  public void setNumUnidades(int numUnidades) throws UnidadesNegativasErrorExcepcion {
    if (numUnidades < 0) 
      throw new UnidadesNegativasErrorExcepcion("Las unidades no pueden ser negativas");
    this.numUnidades = numUnidades; 
  }

  /**
   * Creamos el Getter para el tipo de iva
   * @return tipo de iva
   */

  public TipoIva getTipoDeIva() {
    return tipoDeIva;
  }

  /**
   * Setter para el iva
   * @param tipoDeIva
   * @throws IvaInvalidoExcepcion
   */

  public void setTipoDeIva(TipoIva tipoDeIva) throws IvaInvalidoExcepcion {
    if (tipoDeIva == null)
      throw new IvaInvalidoExcepcion ("Error al introducir el tipo de Iva");
    this.tipoDeIva = tipoDeIva;
  }

  /**
   * 
   * @return
   */
  public int getStockMin() {
    return stockMin;
  }

  /**
   * 
   * @param stockMin
   * @throws UnidadesNegativasErrorExcepcion 
   */
  public void setStockMin(int stockMin) throws UnidadesNegativasErrorExcepcion {
    if(stockMin < 0)
      throw new UnidadesNegativasErrorExcepcion("El stock mínimo no puede ser negativo");
    this.stockMin = stockMin;
  }


  // Método para incrementar el codigo en uno cada vez que creemos un artículo nuevo
  /**
   * Método para incrementar el codigo en uno cada vez que creemos un artículo nuevo
   * @return siguienteCodigo
   */
  private int generaCodigo() {
    return siguienteCodigo++;
  }

  // Creamos el método toString pra mostrar los artículos
  /**
   * Creamos el método toString pra mostrar los artículos
   */
  @Override
  public String toString() {
    return "CÓDIGO DEL ARTÍCULO: " + codigo + "\n"+
        "DESCRIPCIÓN: " + descripcion + "\n"+
        "PRECIO DE COMPRA: " + precioCompra + "\n"+
        "PRECIO DE VENTA: " + precioVenta + "\n"+
        "NÚMERO DE UNIDADES: " + numUnidades + "\n" +
        "TIPO DE IVA: " + tipoDeIva + "\n"+
        "STOCK MÍNIMO: " + stockMin + "\n";
  }

  /**
   * 
   */

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + codigo;
    return result;
  }

  /**
   * 
   */

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Articulo other = (Articulo) obj;
    if (codigo != other.codigo)
      return false;
    return true;
  }

  // Método para dar entrada a una cantidad de unidades de un artículo del almacén
  /**
   * Método para dar entrada a una cantidad de unidades de un artículo del almacén y controlar que no sean negativas
   * @param cantidad
   * @throws UnidadesNegativasErrorExcepcion 
   */

  void entradaMercancia(int cantidad) throws UnidadesNegativasErrorExcepcion {
    if (cantidad < 0) 
      throw new UnidadesNegativasErrorExcepcion("Las unidades no pueden ser negativas");
    setNumUnidades(getNumUnidades() + cantidad); 
  }

  // Método para dar salida  a una cantidad de unidades de un artículo del almacén
  /**
   * Método para dar salida  a una cantidad de unidades de un artículo del almacén
   * @param cantidad
   * @throws UnidadesNegativasErrorExcepcion 
   */

  void salidaMercancia(int cantidad) throws UnidadesNegativasErrorExcepcion {
    if (cantidad < 0) 
      throw new UnidadesNegativasErrorExcepcion("Las unidades no pueden ser negativas");
    setNumUnidades(getNumUnidades() - cantidad);
  }

}
