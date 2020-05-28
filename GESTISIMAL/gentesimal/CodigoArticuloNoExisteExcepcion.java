package gentesimal;

/**
 * Excepcion para controlar que el código introducido existe
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

@SuppressWarnings("serial")
public class CodigoArticuloNoExisteExcepcion extends Exception {
  public CodigoArticuloNoExisteExcepcion(String mensaje) {
    super(mensaje);
  }
}
