package javaExamenIITrimestre;
/**
 * Excepción que s elanza cuando no existe un contacto en la agenda
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */
@SuppressWarnings("serial")
public class NoExisteContacto extends Exception {
  public NoExisteContacto (String mensaje) {
    super (mensaje);
  }

}
