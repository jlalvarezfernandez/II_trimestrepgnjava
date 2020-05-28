package javaExamenIITrimestre;
/**
 * Excepción que se lanza cuando los datos introducidos son incorrectos
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */
@SuppressWarnings("serial")
public class DatosInvalidos extends Exception {
  public DatosInvalidos(String mensaje) {
    super(mensaje);

  }

}
