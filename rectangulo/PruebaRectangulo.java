package rectangulo;

public class PruebaRectangulo {

  public static void main(String[] args) {
    
    Rectangulo r1 = new Rectangulo (5,3);
    Rectangulo r2 = new Rectangulo (8,4);
    
    System.out.println("Mostramos r1: ");
    System.out.println(r1);
    r1.mostrar();
    r2.mostrar();
    System.out.println("--------------------------------------------");
    System.out.println("El perimetro del rectangulo r1 es: ");
    System.out.println("El perimetro es: " + r1.perimetro() + " cm");
    System.out.println("--------------------------------------------");
    System.out.println("El área del rectangulo r1 es: ");
    System.out.println("El area es: " + r1.area() + " cm");
    System.out.println("--------------------------------------------");
    System.out.println("Resultado de comparar " + r1 + " con " + r2 +": " + r1.comparaRectangulos(r2));
    System.out.println("--------------------------------------------");
    System.out.println("¿Son gemelos los dos rectangulos?: " + r1.esGemelo(r2));
    System.out.println("--------------------------------------------");
    System.out.println("¿Cuantos rectangulos se han creado?" + Rectangulo.NUMCREADOS);


    

  }

}
