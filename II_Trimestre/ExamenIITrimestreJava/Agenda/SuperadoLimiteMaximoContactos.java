package javaExamenIITrimestre;
/**
 * Excepción que se lanza cuando se supera el tamaño maximo de contactos en la agenda
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */
@SuppressWarnings("serial")
public class SuperadoLimiteMaximoContactos extends Exception {
  public SuperadoLimiteMaximoContactos (String mensaje) {
    super (mensaje);
  }

}
