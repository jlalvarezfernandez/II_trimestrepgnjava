package funcionesArrays;

public class Arrays {
  
  /**
   * 
   * Creación de los ejercicos de funciones de arrays
   * 
   * 1. generaArrayInt: Genera un array de tamaño n con números aleatorios cuyo intervalo (mínimo y máximo) se indica como parámetro.
   * 
   * 2. minimoArrayInt: Devuelve el mínimo del array que se pasa como parámetro.
   * 
   * 3. maximoArrayInt: Devuelve el máximo del array que se pasa como parámetro. 
   * 
   * 4. mediaArrayInt: Devuelve la media del array que se pasa como parámetro.
   * 
   * 5. estaEnArrayInt: Dice si un número está o no dentro de un array.
   * 
   * 6. posicionEnArray: Busca un número en un array y devuelve la posición (el índice) en la que se encuentra.
   * 
   * 7. volteaArrayInt: Le da la vuelta a un array.
   * 
   * 8. rotaDerechaArrayInt: Rota n posiciones a la derecha los números de un array.
   * 
   * 9. rotaIzquierdaArrayInt: Rota n posiciones a la izquierda los números de un array.
   * 
   * 
   * @ José Luis Álvarez Fernández
   */
  
  /**
   * Creamos la función mostrar array que nos va a servir para mostar los arrays que creemos
   * @param array
   */
  
  public static void mostrarArray(int array[]) {
    for (int n: array) {
      System.out.print(n + " | ");
    }
  }

  
  /**
   * Creamos la funcion generaArrayInt
   * @param tamanio
   * @param max
   * @param min
   * @return
   */
  
  public static int[] generaArrayInt (int tamanio, int max, int min) {

    int [] array = new int[tamanio];


    for (int i = 0; i<tamanio; i++) {
      array[i] = (int)(Math.random()*(max-min+1)+ min);

    }
    return array;
  }
  
 /**
  * minimoArrayInt: Devuelve el mínimo del array que se pasa como parámetro.
  * @param array
  * @return
  */
 public static int minimoArrayInt ( int[] array) {
   
   int minimo = Integer.MAX_VALUE;
   
   for (int i = 0; i <array.length; i++) {
     if (array[i] < minimo) {
       minimo = array[i];
     }
   }
   return minimo;
 }
  
  
  
 /**
  * maximoArrayInt: Devuelve el máximo del array que se pasa como parámetro.
  * @param array
  * @return
  */
 
 public static int maximoArrayInt (int [] array) {
   int maximo = Integer.MIN_VALUE;
   
   for (int i = 0; i < array.length; i++) {
     if (array[i] > maximo) {
       maximo = array[i];
     }
   }
   return maximo;
 }
 
 /**
  * mediaArrayInt: Devuelve la media del array que se pasa como parámetro.
  * @param array
  * @return
  */
 public static int mediaArrayInt (int []array) {

   int media = 0;

   for (int i = 0; i < array.length; i++) {

     media += array[i];
   }

   return media/array.length;
   
 }
 
/**
 * estaEnArrayInt: Dice si un número está o no dentro de un array.
 * @param array
 * @param num
 * @return
 */
 
 public static boolean estaEnArrayInt (int []array, int num) {
   
   
   for (int numero:array) {
     if (numero == num) {
       return true;
     }
   }

   return false;
 }
 
 /**
  * posicionEnArray: Busca un número en un array y devuelve la posición (el índice) en la que se encuentra.
  * @param array
  * @param num
  * @return
  */
 
 public static int posicionEnArray (int [] array, int num) {
   
   //int posicion;
   
   for (int i = 0; i <array.length; i++) {
     if (num == array[i]) {
       return i;
     }
   }
   
   return 0;
 
 }
 
 /**
  *    * 7. volteaArrayInt: Le da la vuelta a un array.
  */
 
 public static int[] volteaArrayInt (int[] array) {
   int [] arrayVolteado = new int [array.length];
   int i;
   for ( i = 0 ; i<array.length; i++) {

     arrayVolteado[array.length-i-1]=array[i];
   }
   return arrayVolteado;
 }
 /**
  * 8. rotaDerechaArrayInt: Rota n posiciones a la derecha los números de un array.
  */
 
 public static void rotaDerechaArrayInt(int [] array, int numAPasar) {
   
   int [] copia = new int [array.length];  // creamos un array que va er igual de grande que el array que tenemos
   
   int c = numAPasar; //contador para el array copia
   
   // llevando al array copia el desplazamiento
   
   for (int i = 0; i < array.length; i++) {
     copia[c] = array[i];
     c++;
     if (c == array.length) {
       c = 0;
     }
     
   }
   // me llevo la copia la array que me llega como parametro
   
   for (int i = 0; i <array.length; i++) {
     array[i]= copia[i];
   }
 }
 
 /**
  *   9. rotaIzquierdaArrayInt: Rota n posiciones a la izquierda los números de un array.
  */
 
 public static void rotaIzquierdaArrayInt(int [] array, int numAPasar) {
   
   int [] copia = new int [array.length];  // creamos un array que va a ser igual de grande que el array que tenemos
   
   int c = numAPasar; //contador para el array copia
   
   // llevando al array copia el desplazamiento
   
   for (int i = array.length; i < 0 ; i++) {
     copia[c] = array[i];
     c++;
     if (c == array.length) {
       c = 0;
     }
     
   }
   // me llevo la copia la array que me llega como parametro
   
   for (int i = array.length; i < 0; i++) {
     array[i]= copia[i];
   }
 }

}
