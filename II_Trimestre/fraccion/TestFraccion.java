package fraccion;
/**
 * Pruebas para la clase Fracción
 * 
 * @author José Luis Álvarez Fernández
 *
 */

public class TestFraccion {

  public static void main(String[] args) {
    
    Fraccion f1 = new Fraccion(2,4);
    Fraccion f2 = new Fraccion (6, 2);
    
    
    System.out.println("Mostramos la fraccion f1: ");
    System.out.println(f1);
    System.out.println("---------------------------");
    System.out.println("Mostramos la fraccion f2: ");
    System.out.println(f2);
    System.out.println("---------------------------");
    System.out.println("Mostramos fracción " + f1 + " como número real: ");
    System.out.println(f1.resultadoReal());
    System.out.println("---------------------------");
    System.out.println("Mostramos fracción " + f2 + " como número real: ");
    System.out.println(f2.resultadoReal());
    System.out.println("---------------------------");
    System.out.println("Multiplicamos "+ f1 + " por 5: ");
    System.out.println(f1.multiplicaNumero(5));
    System.out.println("---------------------------");
    System.out.println("Multiplicamos "+ f2 + " por 5: ");
    System.out.println(f2.multiplicaNumero(5));
    System.out.println("---------------------------");
    System.out.println("Multiplicamos " + f1 + " por " + f2);
    f1.multiplicaFracciones(f2);
    System.out.println(f1);
    System.out.println("---------------------------");
    System.out.println("Sumamos " + f1 + " + " + f2);
    f1.sumaFracciones(f2);
    System.out.println(f1);
    System.out.println("---------------------------");
    System.out.println("Restamos " + f1 + " - " + f2);
    f1.restaFracciones(f2);
    System.out.println(f1);
    System.out.println("---------------------------");
    System.out.println("Simplificamos " + f1);
    f1.simplifica();
    System.out.println(f1);
    
   
   
   

    


    
    

  }

}
