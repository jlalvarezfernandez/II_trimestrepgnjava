package javaExamenIITrimestre;
/**
 *  1. Crea una clase para gestionar una agenda de un máximo de 100 contactos en Java y haz un programa que la pruebe.
 *  Nombre clase: Agenda.
 *  
 *  El comportamiento de esta clase es el siguiente:
 *    • Tiene dos constructores:
 *      ◦ El primero sin parámetros, simplemente crea una agenda vacía.
 *      ◦ El segundo recibe un fichero CSV con información de contactos.
 *    • Alta de contacto. Añade un contacto a la agenda. Lanza una excepción si se sobrepasa el máximo de contactos (100).
 *    • Baja de contacto. Lanza una excepción si el contacto a borrar no existe.
 *    • Busca un contacto. Devuelve el contacto que coincida con la búsqueda, en caso de no encontrar coincidencia se devuelve un valor nulo.
 *    • Reduce el tamaño de la agenda. Cambia el número máximo de contactos a otro valor inferior a 100, 
 *    si se diera un valor mayor lanza una excepción, si reducimos el tamaño de la agenda a un valor inferior al número de contactos que hay lanza una excepción.
 *    • Exporta a fichero CSV. Lanza una excepción si no podemos escribir en el fichero.
 *    • Importa de fichero CSV. Cada contacto importado llama al método que da de alta. Lanza una excepción si no podemos leer del fichero.
 *  El control del tamaño de la agenda se hace sobre esta clase.
 * @author @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;




public class Agenda {
  static int CONTACTOSMAXIMOS = 100;


  // creamos el arrayList que es un estado de la clase Contacto

  private ArrayList<Contacto> agenda = new ArrayList<>();


  ///// CREACIÓN CONSTRUCTORES \\\\\\
  //Creamos un cosntructor vacio

  public Agenda() {

  }

  // creamos un constructor que recibe un fichero con la información de los contactos

  public Agenda(String fichero) throws SuperadoLimiteMaximoContactos, NoExisteContacto, CSVExcepcion, DatosInvalidos {
    @SuppressWarnings("unused")
    ArrayList<Contacto>  agenda = new ArrayList<Contacto>();
    importarCSV(fichero);

  }
  /**
   * Método para saber si existe un nombre en la agenda
   * @param nombre
   * @return
   * @throws NoExisteContacto
   * @throws DatosInvalidos 
   */
  
  public Contacto getContacto(String nombre, String telefono)  throws NoExisteContacto, DatosInvalidos{
    try {
      return agenda.get(agenda.indexOf(new Contacto(nombre, telefono))); 
      
    } catch (IndexOutOfBoundsException e) {
      throw new NoExisteContacto("El contacto seleccionado no existe en la agenda");
    }
    
  }

  /**
   * Alta de contacto. Añade un contacto a la agenda. Lanza una excepción si se sobrepasa el máximo de contactos (100). 
   * @param nombre
   * @param telefono
   * @param direccion
   * @param correoElectronico
   * @throws SuperadoLimiteMaximoContactos 
   * @throws DatosInvalidos 
   */

  public void alta(String nombre, String telefono, String direccion, String correoElectronico) throws SuperadoLimiteMaximoContactos, DatosInvalidos {

    if (agenda.size() >= CONTACTOSMAXIMOS) {
      throw new SuperadoLimiteMaximoContactos("No se pueden introducir más contactos en la agenda");
    }
    agenda.add(new Contacto(nombre, telefono, direccion, correoElectronico));

  }

  /**
   * Método para dar de baja un contacto de la agenda introduciendo su nombre
   * @param nombre
   * @return 
   * @throws NoExisteContacto 
   */

  public Contacto baja(String nombre, String telefono) throws NoExisteContacto {
    Contacto borrar = null;
    try {
      for (Contacto contacto : agenda) {
        if (contacto.getNombre().equals(nombre)) {
          borrar = contacto;
          break;
        }
      }
      return agenda.remove(agenda.indexOf(borrar));

    } catch (Exception e) {
      throw new NoExisteContacto("Contanto inexistente");
    } 
  }
  
  /**
   * Método para buscar un contacto de la agenda
   * @param nombre
   * @return 
   */
  
  public Contacto busca(String nombre) throws NoExisteContacto{
    Contacto nombreEnAgenda = null;
    try { 
    for (Contacto contacto : agenda) {
      if(contacto.getNombre().equals(nombre)){
        nombreEnAgenda = contacto;
        break;
      }
    }
    return agenda.get(agenda.indexOf(nombreEnAgenda));

    } catch (Exception  e) {
      throw new NoExisteContacto("No existe ese nombre en la agenda");
    }
  }
  
  
  /**
   * Metodo para reducir el tamaño de la agenda
   * @param numero
   * @throws DatosInvalidos
   */

  public void reduce(int numero) throws DatosInvalidos{
    if (numero > 0 && agenda.size() < numero && numero < CONTACTOSMAXIMOS) {
      CONTACTOSMAXIMOS = numero;
    }else {
      throw new DatosInvalidos("Error provocado por que hay mas contactos que el tamaño elegido para la agenda "
          + "o porque el tamaño introducido es mayor de 100 contactos o se ha ontroducio un número negativo");
    }
    
  }

  /**
   * Método para exportar la agenda a un fichero en csv 
   * @param archivo
   * @throws javaExamenIITrimestre.CSVExcepcion
   */

  public void exportaCSV(String archivo) throws javaExamenIITrimestre.CSVExcepcion {
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
      bw.write("Nombre, Telefono, Dirección, Email");
      bw.newLine();

      for(Contacto cont:agenda) {
        bw.write(cont.getNombre() + ",\""+ cont.getTelefono() + "\"," + 
            cont.getDireccion() + "," + cont.getCorreoElectronico());
        bw.newLine();
      }
      bw.close();

    } catch (IOException e) {
      throw new CSVExcepcion("error de escritura en " + archivo);

    }

  }
  /**
   * Método para importar la agenda de un fichero en csv
   * @param archivo
   * @throws SuperadoLimiteMaximoContactos
   * @throws javaExamenIITrimestre.CSVExcepcion
   * @throws DatosInvalidos 
   */
  
  public void importarCSV(String archivo) throws SuperadoLimiteMaximoContactos, NoExisteContacto, CSVExcepcion, DatosInvalidos {
    try {

      BufferedReader csv = new BufferedReader(new FileReader(archivo));

      String linea = csv.readLine();
      linea = csv.readLine();

      while(linea != null) {
        String[] elementos = linea.split(",");
        alta(elementos[0].replace("\"", ""),(elementos[1]), (elementos[2]), (elementos[3]));

        linea = csv.readLine();
      }
      csv.close();
    } catch (IOException e) {
      throw new CSVExcepcion("No se puede leer el fichero " + archivo);
    }


  }


  /**
   * Método toString para mostrar los contactos de la agenda
   */

  @Override
  public String toString() {
    return "Agenda\n" + agenda + "\n";
  }

  

  
}

  











