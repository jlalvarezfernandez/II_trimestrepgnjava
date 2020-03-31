package rectangulo;

public class TestRectangulo {

  public static void main(String[] args) {
    
    // creamos una instncia de clase u objeto de la clase rectángulo
    
    Rectangulo r1 = new Rectangulo(8, 8);
    Rectangulo r2 = new Rectangulo(8, 8);
    
    // COmprobamos todos los métodos creados para la clase Rectángulo
    
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
