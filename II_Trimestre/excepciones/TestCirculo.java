package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;


public class TestCirculo {

  public static void main(String[] args) throws radioNegativoError, InputMismatchException {
    Scanner sc = new Scanner (System.in);
    boolean interruptor = true;
    Circulo c1 = null;
    do {
      try {
        System.out.println("Introduce el radio del circulo: ");
        double radio = sc.nextDouble();
        c1 = new Circulo(radio);
        interruptor = false;
        
      } catch (radioNegativoError e) {
        System.err.println("El radio introducido no puede ser negativo");
      }
      catch (InputMismatchException e) {
        System.err.println("ERROR, tipo de dato incorrecto");
        
      }
      
    } while(interruptor);
    
    
    
    
    System.out.println("Mostramos el radio del circulo: " + c1);
    System.out.println("El área del circulo es: " + c1.area());
    System.out.println("Radio del circulo despues de crecer 27 veces: " + c1.crece(27));
    System.out.println("El área del circulo es: " + c1.area());
    System.out.println("Radio del circulo después de menguar 10 veces:" + c1.mengua(10));
    System.out.println("Mostramos el estado final del circulo: " + c1);


  }

}
