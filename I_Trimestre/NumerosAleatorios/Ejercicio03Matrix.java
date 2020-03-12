package NumerosAleatorios;

/**
 * PROPOSITO: 3. Realiza un programa que llene la pantalla de caracteres aleatorios (a lo Matrix) con el código ascii entre el 32 y el 126. 
 *               Puedes hacer casting con (char) para  convertir un entero en un carácter.
 *
 *
 * @author AJFRU
 * 
 * Fecha: 25/11/2019
 * 
 * ANALISIS
 * ----------
 * generamos caracters aleatorios dentro de un bucle for que muestre los caracters que pidamos por linea dentro de un bucle do-while
 * podemos usar la funcion therad.slepp oara hacer que los caracteres imprimidos vayan a la velocidad que queramos
 * 
 * 
 * VARIABLES
 * -----------
 * matrix: almacenarálos caracters generados aleatoriamente
 * 
 *
 */


public class Ejercicio03Matrix {

  public static void main(String[] args) throws InterruptedException  {
    
    // definimos las variables
    
    int matrix = 0;
    
    // Calculos

    do {
      
      for (int i = 0; i<200; i++) {  // bucle for que imprimira 200 caracteres por linea

        matrix = (int) (Math.random() * (126 - 32 + 1));

        System.out.print((char)(matrix));

        Thread.sleep(1);
      }
      
      System.out.println();

    } while (true);

  }
  
}
