package javaExamenIITrimestre;
/**
 * Excepción que se lanza cuando se produce un error al importar o exporar ficheros en formato csv
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

@SuppressWarnings("serial")
public class CSVExcepcion extends Exception {
  public CSVExcepcion (String mensaje) {
    super(mensaje);
  }

}
