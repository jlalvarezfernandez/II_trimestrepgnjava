package gentesimal;

/**
 * Excepcion que se lanza cuando el número de unidades introducidas es erronea
 * @author AJFRU
 *
 */

@SuppressWarnings("serial")
public class UnidadesNegativasErrorExcepcion extends Exception {
  public UnidadesNegativasErrorExcepcion(String mensaje) {
    super(mensaje);
  }

}
