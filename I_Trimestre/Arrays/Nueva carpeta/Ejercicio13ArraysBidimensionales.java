package Arrays;

/**
 * PROPOSITO: 13. Realiza un programa que calcule la estatura media, mínima y máxima en centímetros de personas de diferentes países. 
 *                El array que contiene los nombres de los paises es el siguiente: pais = {“España”, “Rusia”, “Japón”,“Australia”}. 
 *                Los datos sobre las estaturas se deben simular mediante un array de 4 filas por 10 columnas con números aleatorios generados al azar entre
 *                140 y 210. 
 *                Los decimales de la media se pueden despreciar.
 *                Los nombres de los países se deben mostrar utilizando el array de países (no se pueden escribir directamente).
 *                
 *                    Ejemplo:
 *                                                                                      MED MIN MAX
 *                                    España: 178 165 148 185 155 141 165 149 155 201 | 164 141 201
 *                                     Rusia: 179 189 208 167 186 174 152 192 173 179 | 179 152 179
 *                                     Japón: 173 182 168 170 181 197 146 168 166 177 | 172 146 177
 *                                 Australia: 172 170 187 186 197 143 190 199 187 191 | 182 143 191
 * 
 * 
 * 
 * 
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 * FECHA: 23/11/2019
 *
 */

public class Ejercicio13ArraysBidimensionales {

  public static void main(String[] args) {
    
    
    // definimos las variables

    String[] pais = {"España", "Rusia", "Japón", "Australia"};   
    int [][] estaturas = new int [4][10];
    int alturaMinima = Integer.MAX_VALUE;
    int alturaMaxima = Integer.MIN_VALUE;
    int suma = 0;

    // calculos
    
    System.out.printf("%68s"," MED  MIN  MAX\n");
    
    for (int fila = 0; fila<4;fila++) {
      
      System.out.printf("%9s: ",pais[fila]);
      
      for(int columna = 0;columna<10;columna++) {
        
        estaturas[fila][columna]= (int) (Math.random()*(210-140 + 1)) +140;

        System.out.print(estaturas[fila][columna]+ " ");
        
        // Calculamos la altura minima
        
          if (estaturas[fila][columna] < alturaMinima) {
            
            alturaMinima = estaturas[fila][columna];
            
            // calculamos la altura maxima
            
        }
          if (estaturas[fila][columna] > alturaMaxima) {
            
            alturaMaxima = estaturas[fila][columna];
            
          }
          
          // calculamos la media
     
            suma += estaturas[fila][columna]/10;

      }
      
      System.out.print("| " +suma + " | ");
      
      suma = 0;
      
      System.out.print(alturaMinima+ " | ");
      
      alturaMinima = Integer.MAX_VALUE;
      
      System.out.print(alturaMaxima + " |");
      
      alturaMaxima = Integer.MIN_VALUE;

     
      System.out.println();
      
    }

  }

}
