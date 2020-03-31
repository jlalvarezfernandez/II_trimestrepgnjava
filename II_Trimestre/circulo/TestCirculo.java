package circulo;

public class TestCirculo {

  public static void main(String[] args) {
    
    Circulo c1 = new Circulo(2);
    
    System.out.println("Mostramos el radio del circulo: " + c1);
    System.out.println("El área del circulo es: " + c1.area());
    System.out.println("Radio del circulo despues de crecer 27 veces: " + c1.crece(27));
    System.out.println("El área del circulo es: " + c1.area());
    System.out.println("Radio del circulo después de menguar 10 veces:" + c1.mengua(10));
    System.out.println("Mostramos el estado final del circulo: " + c1);

  }

}
