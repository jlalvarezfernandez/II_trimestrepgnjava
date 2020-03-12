package NumerosAleatorios;

/**
 * PROPOSITO: Escribe un programa que muestre tres apuestas de la quiniela en tres columnas para los 14 partidos y el pleno al quince (15 filas) 
 *            de forma que la probabilidad de que salga un 1 sea de 1/2, la probabilidad de que salga x sea de 1/3 y la probabilidad de que salga 2 sea de 1/6. 
 *            Pista: 1/2 = 3/6 y 1/3 = 2/6.
 * 
 * 
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 * 
 * FECHA: 23/11/2019
 * 
 * ANÁLISIS
 * ----------
 * recorremos las filas y las columnas
 * generamos los resultados de forma aleatoria según las indicaciones
 * mostramos los resultados
 * 
 * VARIABLES
 * ----------
 
 * fila (entero): almacenará las filas de la quiniela
 * columna (entero): almacenará las columnas de ña quiniela
 * aleatorio (entero): generará un número aleatorio para poder poner las variables (1 x 2)
 * pleno (entero): almacenará el pleno al 15 
 *
 */

public class Ejercicio01Quiniela {

  public static void main(String[] args) {

    //Definimos las variables

    int aleatorio = 0;

    int pleno = 0;

    // Calculos
    
    // asi calculamos las 14 filas y tres columnas de la quiniela


    for (int fila=0; fila<14; fila++) {

      for (int apuesta=0; apuesta<3; apuesta++) {

        aleatorio = (int)((Math.random()*6)+1);

        if (aleatorio == 1 || aleatorio== 2 || aleatorio==3) {

          System.out.print(" 1 |");

        } else if (aleatorio == 4 || aleatorio== 5) {

          System.out.print(" X |");

        }    else {

          System.out.print(" 2 |");

        }

      }

      System.out.println();

    }
    
    // Asi calculamos el pleno al 15

    pleno = (int)((Math.random()*6)+1);

    if (pleno == 1 || pleno== 2 || pleno==3) {

      System.out.print("pleno: 1 ");

    } else if (pleno == 4 || pleno== 5) {

      System.out.print("pleno: X ");

    } else {

      System.out.print("pleno: 2 ");

    }

  }

}
