package application.gestisimal;

@SuppressWarnings("serial")
public class PrecioIncorrecto extends Exception {
  public PrecioIncorrecto (String mensaje) {
    super(mensaje);
  }

}
