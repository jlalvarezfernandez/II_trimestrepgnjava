package secuencialesJava;
/**
* Programa: Ejercicio16AlcanceVehiculos.java
*
* Proposito: 16. Dos vehículos viajan a diferentes velocidades (v1 y v2) y están distanciados por una distancia d. 
                 El que está detrás viaja a una velocidad mayor. 
                 Se pide hacer un algoritmo para ingresar la distancia entre los dos vehículos (km) 
                 y sus respectivas velocidades (km/h) 
                 y con esto determinar y mostrar en que tiempo (minutos) alcanzará el vehículo más rápido al otro.


*
*
* @author José Luis Álvarez Fernández
*
* Fecha: 4/11/2019
*/
/**
 * Variables:
 * v1 (double): almacenará la velocidad a la que viaja el primer vehiculo
 * v2 (double): almacenará la velocidad a la que viaja el segundo vehiculo
 * distancia (double): almacenará la distanca que existe entre ambos vehiculos
 * alcance (double): almacenará a los minutos que el v2 alcanzará al v1 (tiempo = distancia/(v1 - v2) *60))
 * 
 * Algoritmo:
 * 
 * LEER: v1, v2, distancia
 * CALCULAR: alcance
 * ESCRIBIR: alcance
 * 
 */


 public class Ejercicio16AlcanceVehiculos {
   public static void  main(String[] args) {
     
    // Definimos las variables:

    String linea;
    int v1;
    int v2;
    int distancia;
  
  

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce la velocidad a la que viaje el vehiculo 1: ");
    linea = System.console().readLine();
    v1 =Integer.parseInt(linea);

    System.out.println("Introduce la velocidad a la que viaja el vehiculo 2 (debe ser mayor que la velocidad del vehiculo 1): ");
    linea = System.console().readLine();
    v2 =Integer.parseInt(linea);

    System.out.println("Introduce la distancia que separa a los dos vehiculos en km: ");
    linea = System.console().readLine();
    distancia = Integer.parseInt(linea);

    // Calculos

   int alcance = (distancia / (v2 - v1)) * 60;
  
   
    // Mostramos los resultados por pantalla

    System.out.println("El vehiculo 2 alcanzara al vehiculo 1 a los: " + alcance + " minutos");

   }
 }