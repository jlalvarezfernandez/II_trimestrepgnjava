package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

import excepciones.Rectangulo;

public class TestRectangulo {

  public static void main(String[] args) throws excepciones.DimensionRectanguloError, InputMismatchException {

    Scanner sc = new Scanner (System.in);

    boolean interruptor = true;

    // creamos una instancia de clase u objeto de la clase rectángulo
    Rectangulo r1 = null;
    Rectangulo r2 = null;

    do {

      try {
        
        System.out.println("Introduce la base para el rectángulo r1: ");
        int baseR1 = sc.nextInt();
        System.out.println("Introduce la altura para el rectángulo r1: ");
        int alturaR1 = sc.nextInt();
        r1 = new Rectangulo(baseR1, alturaR1);
        System.out.println("Introduce la base para el rectángulo r2: ");
        int baseR2 = sc.nextInt();
        System.out.println("Introduce la altura para el rectángulo r2: ");
        int alturaR2 = sc.nextInt();
        r2 = new Rectangulo(baseR2, alturaR2);
        
        interruptor = false;

      } catch (DimensionRectanguloError e) {
        System.err.println("Error al dar las dimensiones");
        sc.next();
        //System.exit(1);
        
      }
      
      catch (InputMismatchException e2) {
        
        System.err.println("Introduce un número entero, por favor");
        sc.next();
        //System.exit(2);
      }

    } while (interruptor);



    // Comprobamos todos los métodos creados para la clase Rectángulo

    System.out.println("TEST PARA COMPROBAR LOS MÉTODOS DE LA CLASE RECTÁNGULO: ");
    System.out.println("---------------------------------------------------------");
    System.out.println("Valores del réctangulo r1: " + r1);
    System.out.println("Valores del réctangulo r2: " + r2);
    System.out.println("----------------------------------");
    System.out.println("Mostramos el rectángulo r1: ");
    System.out.println();
    System.out.println(r1.dibujaRectangulo());
    System.out.println("----------------------------------");
    System.out.println("Mostramos el rectángulo r2: ");
    System.out.println();
    System.out.println(r2.dibujaRectangulo());
    System.out.println("----------------------------------");
    System.out.println("El perímetro del rectángulo r1 es: " + r1.calculaPerimetro() + " cm");
    System.out.println("El perímetro del rectángulo r2 es: " + r2.calculaPerimetro() + " cm");
    System.out.println("------------------------------------------");
    System.out.println("El área del rectángulo r1 es: " + r1.calculaArea() + " cm cuadrados");
    System.out.println("El área del rectángulo r2 es: " + r2.calculaArea() + " cm cuadrados");
    System.out.println("----------------------------------------------");
    System.out.println("¿Resultado de comparar el rectángulo r1 con el rectángulo r2?: " + r1.comparaRectangulos(r2));
    System.out.println("-----------------------------------------------------------------");
    System.out.println("¿Son gemelos los rectángulos r1 y r2?: " + r1.esGemelo(r2));
    System.out.println("-----------------------------------------------");
    System.out.println("Cantidad de rectángulos creados: " + Rectangulo.NUMRECTANGULOSCREADOS + " rectangulos");
    System.out.println("--------------------------------------------------");
    System.out.println("¿Cual es la base y altura máxima de los rectángulos creados: " + Rectangulo.LADOMAXIMO);
    System.out.println("-------------------------------------------------------------------");


  }

}
