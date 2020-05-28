package javaExamenIITrimestre;


/**
 *  1. Crea una clase para gestionar una agenda de un máximo de 100 contactos en Java y haz un programa que la pruebe.
 *  
 *  Un contacto está definido por:
 *    • Nombre. Será válido cuando esté compuesto por letras y espacios (solo en medio) y no haya otro con el mismo nombre.
 *    • Teléfono. Será válido si está compuesto por nueve dígitos, el primero empieza por 6, 7 ó 9.
 *    • Dirección. No se valida, puede estar vacía.
 *    • Correo electrónico. Si existe hay que validarlo.
 *    
 * Una agenda está formada por una colección de de contactos, que a su vez son objetos de la clase Contacto. Esta clase:
      • Tiene tres constructores:
        ◦ El primero recibe un nombre y un teléfono.
        ◦ El segundo los datos anteriores y además una dirección.
        ◦ El tercero los datos anteriores y además un correo electrónico.
        ◦ Los datos los validamos mediante expresiones regulares, si alguno es inválido lanzamos una excepción.
      • Tiene getters para obtener el nombre, teléfono, dirección y correo electrónico.
      • Tiene setters para asignar teléfono, dirección y correo electrónico. En caso de datos no válidos lanza una excepción.
      
   Ten en cuenta de que en ninguna de estas clases se interactúa con el usuario.
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

public class Contacto {
  
  // variable para indicar que el máximo de contactos sea de 100
  
  static int CONTACTOSMAXIMOS = 100;
  
  // Definimos los atributos de la clase contacto

  private String nombre;
  private String telefono;
  private String direccion;
  private String correoElectronico;
  
  
  ///////// CONSTRUCCIÓN CONSTRUCTORES\\\\\\\\\\
  
  
  // Primer construcots que recibe un nombre y un teléfono
  
  public Contacto(String nombre, String telefono) throws DatosInvalidos {
    setNombre(nombre);
    setTelefono(telefono);
  }

  // Segundo constructor que recibe un nombre, un teléfono y una dirección
  
  public Contacto(String nombre, String telefono, String direccion) throws DatosInvalidos {
    setNombre(nombre);
    setTelefono(telefono);
    setDireccion(direccion);
  }

  
  // Tercer constructor que recibe un nombre, un teléfono, una dirección y un correo electrónico
  
  public Contacto(String nombre, String telefono, String direccion, String correoElectronico) throws DatosInvalidos {
    setNombre(nombre);
    setTelefono(telefono);
    setDireccion(direccion);
    setCorreoElectronico(correoElectronico);
  }
  
  
  //////////// CONSTRUCCIÓN GETTERS Y SETTERS\\\\\\\\\\\\
  


  /**
   * Getter (observador) para el nombre
   * @return nombre
   */
  
  public String getNombre() {
    return nombre;
  }
  
  /**
   * Setter (modificador) para el nombre
   * @param nombre
   * @throws DatosInvalidos 
   */

  public void setNombre(String nombre) throws DatosInvalidos {
    String expresion =("^([A-Z]{1}[a-z]+[ ]?){1,2}$");
    if (nombre.matches(expresion)) {
      this.nombre = nombre;
      
    }else {
      throw new DatosInvalidos ("Nombre Incorrecto");
    }
  }
  
  /**
   * Getter (observador) para el teléfono
   * @return telefono
   */

  public String getTelefono() {
    return telefono;
  }
  
  /**
   * Setter (modificador) para el telefono
   * @param telefono
   * @throws DatosInvalidos 
   */

  public void setTelefono(String telefono) throws DatosInvalidos {
    String expresion = "(6|7|9)[0-9]{8}";
    if (telefono.matches(expresion)) {
      this.telefono = telefono;
    }else {
      throw new DatosInvalidos ("Telefono Incorrecto");
    }    
  }
  
  /**
   * Getter (observador) para la dirección
   * @return direccion
   */

  public String getDireccion() {
    return direccion;
  }
  
  /**
   * Setter (modificador) para la dirección
   * @param direccion
   */

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
  
  /**
   * Getter (observador) para el correo electrónico
   * @return correo electrónico
   */

  public String getCorreoElectronico() {
    return correoElectronico;
  }
  
  /**
   * Setter(modificador) para el correoelectrónico
   * @param correoelectronico
   * @throws DatosInvalidos 
   */

  public void setCorreoElectronico(String correoElectronico) throws DatosInvalidos {
    String expresion = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";
    if (correoElectronico.matches(expresion)) {
      this.correoElectronico = correoElectronico;
    }else {
      throw new DatosInvalidos ("Correo Electrónico Incorrecto");
    }
  }
  
  
  ///////// Construcción método toStrig \\\\\\\\\\\
  
  /**
   * Método toString para mostrar una cadena con los datos
   */
  @Override
  public String toString() {
    return "\n" + "NOMBRE DEL CONTACTO: " + nombre + "\n" +
        "TELÉFONO: " + telefono + "\n" + 
        "DIRECCIÓN: " + direccion + "\n"+
        "CORREO ELECTRÓNICO: " + correoElectronico +  "\n"+
        "--------------------------------------"+  "\n";
  }

 
  
  ///////// CONSTRUCCIÓN MÉTODO EQUALS \\\\\\\\\\\
  
  /**
   * Método Equals
   */
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Contacto other = (Contacto) obj;
    if (nombre == null) {
      if (other.nombre != null)
        return false;
    } else if (!nombre.equals(other.nombre))
      return false;
    if (telefono != other.telefono)
      return false;
    return true;
  }
  


  
  
  
  

  
  

}
