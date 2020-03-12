package circulo;

public class PruebaCirculo {

  public static void main(String[] args) {
    

    //Creo el objeto circulo con 5 de radio
    Circulo circulo = new Circulo(5);

    //muestro su estado gracias al método toString()
    System.out.println(circulo);

    //hago crecer el radio 27 veces 
    System.out.println("El circulo ha aumentado 27 veces su radio y su radio actual es "+circulo.creceRadio(27));

    //calculo su área
    System.out.println("Su area es "+circulo.getArea());

    //decrezco el radio 10 veces
    

    System.out.println("El circulo ha decrementado 10 veces su radio y su radio actual es "+circulo.decrementaRadio(10));

    //muestro el estado
    System.out.println(circulo);

    



  }

}
