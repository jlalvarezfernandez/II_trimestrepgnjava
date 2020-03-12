package matematicas;

/**
 * Funciones matematicas para los ejercicios de Java
 * 
 * @author José Luis Álvarez Fernández
 *
 */

public class Varias {
  
  /**
   * Aqui voy a ir haciendo las distintas funciones que necesito
   * para hacer los ejercicios
   * 
   */
  
  /**
   * Creamos la función esCapicua que devolverá verdadero si el número que se pasa
   * como parametro es capicua y falso en caso contrario
   * 
   * Un número es capicua si se lee igual de derecha a izquierda que de izquierda a derecha
   * 
   * ejemplo 212
   * 
   * Para hacerlo podemos convertir el entero a cadena y después recorremos el número.
   * vamos recorriendolo con un bucle y si el final es igual al principio entonces es capicua y devolvera true.
   * 
   * 
   * @param numero
   * 
   */
  
  //cabecera de la función
  public static boolean esCapicua (int numero) {  
    //cuerpo de la función

    String invertido = "";

    String numCadena = Integer.toString(numero);

    for (int i = numCadena.length()-1; i > -1; i--) {

      invertido += numCadena.charAt(i); // asi invertimos al cadena     
    }

    return (numCadena.equals(invertido));

  }


  /**
   * Creamos la función esPrimo que devuelve verdadero si el número que se pasa como parámetro es primo y falso en caso contrario.
   * 
   * un número es primo cuando solo es divisible por la unidad y por el mismo (que el resto de la división sea 0)
   * 
   * @param primo
   * Creamos un bucle que vaya recorriendo desde 2 hasta la raiz cuadrada del número introducido, 
   * si ese numero dividido entre el número que se va incrementando en el bucle da como resto 0 no es un numero primo.
   */

  public static boolean esPrimo (int primo) {
    
    boolean creoPrimo = true;

    for (int i = 2; i <= Math.sqrt(primo) && creoPrimo; i++) {

      if ((primo % i) == 0) {

        creoPrimo = false;

      } 
    }

    return creoPrimo;

  }


  /**
   * 
   * Creamos la función siguientePrimo que devuelve el menor primo que es mayor al número que se pasa como parámetro.
   * 
   * @param numero
   * 
   * bucle while, mientras numero introducido no sea un numero primo incrementamos en uno el número y vilvemos a comprobar
   * si es primo salimos y devolvemos el número
   * 
   * 
   * 
   */

  public static int siguientePrimo (int numero) {
    
    int num = numero+1;

    while (!esPrimo(num)) {

      num++;
    }

    return num;
  }

  /**
   * Creamos la función potencia que dada una base y un exponente devuelve la potencia.
   * 
   * no se puede utilizar la funcion Math.pow de java.
   * 
   */
  public static double potencia (int base, int exponente) {

    int resultado = base;


    for (int i = 1 ; i < Math.abs(exponente); i++) {

      resultado *= base;

    }

    if (exponente < 0) {

      return 1/resultado;

    } else {

      return resultado;

    }
  }


  /**
   * 
   * Creamos la funcion digitos que cuenta el número de dígitos de un número entero.
   * 
   * 
   */

  public static int digitos(int numero) {

    String numeroCadena = String.valueOf(numero); // String.valueof hace los mismo que toString

    int i;

    for ( i = 1; i <numeroCadena.length(); i++) {

    }

    return i;
  }


  /**
   * Creamos la funcion voltea: Le da la vuelta a un número.
   * 
   * 
   * 
   * 
   * 
   */

  public static int voltea (int numero) {

    int resto;
    String numeroVolteado = "";

    if (numero == 0) {
      return 0;
    }

    while (numero > 0) {
      resto = numero%10;
      numero = numero / 10;

      numeroVolteado += String.valueOf(resto);

    }

    return Integer.valueOf(numeroVolteado);

  }

  /**
   * 
   * Creamos la funcion digitoN: Devuelve el dígito que está en la posición n de un número entero.
   * Se empieza contando por el 0 y de izquierda a derecha.
   * 
   * 
   */

  public static int digitoN (int numero, int posicion) {

    String cadenaDigito = String.valueOf(numero);

    return Integer.parseInt(cadenaDigito.substring(posicion,posicion+1));

  }

  /**
   * 
   * Creamos la función posicionDeDigito: Da la posición de la primera ocurrencia de un dígito
   * dentro de un número entero. Si no se encuentra, devuelve -1.
   * 
   */

  public static int posicionDeDigito (int numero, int digito) {

    String cadenaDigito = String.valueOf(numero);

    String cadDigito = String.valueOf(digito);

    if (numero > 0) {

      return cadenaDigito.indexOf(cadDigito);

    } else {

      return -1;
    }
  }







  /**
   * 
   * Creamos la función quitaPorDetras: Le quita a un número n dígitos por detrás (por la derecha).
   * 
   */

  public static int quitaPorDetras (int numero, int numDigitosDetras) {

    String cadNumero = String.valueOf(numero);

    String numSinDigitosPorDetras = cadNumero.substring(0,cadNumero.length()-numDigitosDetras);

    numero = Integer.valueOf(numSinDigitosPorDetras);

    return numero;
  }

  /**
   * 
   * 
   * Creamos la función quitaPorDelante: Le quita a un número n dígitos por delante (por la izquierda).
   * 
   * 
   */

  public static int quitaPorDelante (int numero, int numDigitosDelante) {

    String cadNumero = String.valueOf(numero);

    String numSinDigitosPorDelante = cadNumero.substring(numDigitosDelante,cadNumero.length());

    numero = Integer.valueOf(numSinDigitosPorDelante);

    return numero;
  }

  /**
   * Creamos la función pegaPorDetras: Añade un dígito a un número por detrás.
   * 
   * 
   */

  public static int pegaPorDetras (int numero, int anadido) {

    String cadNumero = String.valueOf(numero);

    String cadcaracter = String.valueOf(anadido);

    String numNuevo = (cadNumero + cadcaracter);

    // int numAMostrar = Integer.valueOf(numNuevo);


    return Integer.valueOf(numNuevo);

  }

  /**
   * 
   * Creamos la función pegaPorDelante: Añade un dígito a un número por delante.
   * 
   */

  public static int pegaPorDelante (int numero, int numAnadido) {

    String cadNumero = String.valueOf(numero);

    String cadcaracter = String.valueOf(numAnadido);

    String numNuevo = (cadcaracter + cadNumero);



    return Integer.valueOf(numNuevo);

  }

  /**
   * 
   * Creamos la función trozoDeNumero: Toma como parámetros las posiciones inicial y final dentro de un número y devuelve el trozo correspondiente.
   */

  public static int trozoDeNumero (int posInicial, int posFinal, int numero) {

    String numCadena = String.valueOf(numero);

    String trozo = numCadena.substring(posInicial,posFinal);

    numero = Integer.valueOf(trozo);

    return numero;
  }

  /**
   * 
   * Creamos la función juntaNumeros: Pega dos números para formar uno.
   */

  public static int juntaNumeros (int numero1, int numero2) {

    String cadNum1 = String.valueOf(numero1);
    String cadNum2 = String.valueOf(numero2);

    String cadNumeroNuevo = cadNum1 + cadNum2;

    int numNuevo = Integer.valueOf(cadNumeroNuevo);

    return numNuevo;
  }
}


