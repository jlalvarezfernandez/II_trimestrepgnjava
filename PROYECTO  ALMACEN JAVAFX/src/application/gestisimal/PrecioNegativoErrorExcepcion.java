package application.gestisimal;

/**
 * Excepcion que se lanza cuando el precio de compra, de venta o las unidades introducidas son negativas
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

@SuppressWarnings("serial")
public class PrecioNegativoErrorExcepcion extends Exception {
  public PrecioNegativoErrorExcepcion(String mensaje) {
    super(mensaje);
  }

}
