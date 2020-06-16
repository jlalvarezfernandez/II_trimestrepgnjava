package application.gestisimal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



/**
 * Clase Almacen que realice: 
 *       - alta
 *       - baja 
 *       - modificación 
 *       - entrada de mercancía(incrementa unidades) 
 *       - salida de mercancía (decrementa unidades)
 * 
 * El estado será un ArrayList de artículos. 
 * Su comportamiento será: 
 *      - añadir artículos (no puede haber dos artículos iguales) 
 *      - eliminar artículos
 *      - incrementar las existencias de un artículo (se delega en la clase artículo)
 *      - decrementar las existencias de un artículo (nunca por debajo de cero, se delega en la clase artículo devolver un artículo (para mostrarlo).
 * 
 * Para listar el almacén podrá devolverse una cadena con todos los artículos del almacén (toString)
 * 
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 * 
 *
 */

public class Almacen implements Iterable<Articulo> {//

  // creamos el arrayList que es un estado de la clase Articulo

  private ArrayList<Articulo> almacen = new ArrayList<Articulo>();

  // Método para añadir nuevos articulos en el almacén

  /**
   * Método para añadir nuevos articulos en el almacén
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param numUnidades
   * @throws PrecioNegativoErrorExcepcion 
   * @throws PrecioIncorrecto 
   */

  public void annade(String descripcion, double precioCompra, double precioVenta, int numUnidades, TipoIva tipoDeIva, int stockMin) throws CampoVacioException, UnidadesNegativasErrorExcepcion, PrecioNegativoErrorExcepcion, IvaInvalidoExcepcion, PrecioIncorrecto{
    almacen.add(new Articulo(descripcion, precioCompra, precioVenta,numUnidades, tipoDeIva, stockMin));
  }


  // Método para dar de baja un artículo del almacén
  /**
   * Metodo para dar de baja un artículo que tenemos en el almacén
   * @param codigo
   * @return error si ese código no existe
   * @throws CodigoArticuloNoExisteExcepcion 
   */

  public boolean baja(int codigo) throws CodigoArticuloNoExisteExcepcion {
    try {
      return almacen.remove(new Articulo(codigo));

    } catch (Exception e) {
      throw new CodigoArticuloNoExisteExcepcion("Código no existe");
    }

  }

  // Método get para acceder a los getters de los artículos del almacén

  public Articulo get(int codigo) throws CodigoArticuloNoExisteExcepcion{
    try {
      return almacen.get(almacen.indexOf(new Articulo(codigo)));
    } catch (IndexOutOfBoundsException  e) {
      throw new CodigoArticuloNoExisteExcepcion("El código no existe");
    }
  }


  // Método para modificar los artículos del almacén
  /**
   * Método para modificar los artículos del almacén
   * @param codigo
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param numUnidades
   * @param tipoDeIva
   * @param stockMin
   * @throws CodigoArticuloNoExisteExcepcion
   * @throws UnidadesNegativasErrorExcepcion
   * @throws PrecioNegativoErrorExcepcion
   * @throws IvaInvalidoExcepcion
   * @throws CampoVacioException
   * @throws PrecioIncorrecto 
   */
  public void modificacion(int codigo, String descripcion, double precioCompra, double precioVenta, int numUnidades, TipoIva tipoDeIva, int stockMin) throws CodigoArticuloNoExisteExcepcion, UnidadesNegativasErrorExcepcion, PrecioNegativoErrorExcepcion, IvaInvalidoExcepcion, CampoVacioException, PrecioIncorrecto {
    get(codigo).setDescripcion(descripcion);
    get(codigo).setPrecioCompra(precioCompra);
    get(codigo).setPrecioVenta(precioVenta);
    get(codigo).setNumUnidades(numUnidades);
    get(codigo).setTipoDeIva(tipoDeIva);
    get(codigo).setStockMin(stockMin);

  }

  // Método para incremetar las unidades de un artículo del almacén
  /**
   * Método para incremetar las unidades de un artículo del almacén
   * @param codigo
   * @param cantidad
   * @throws UnidadesNegativasErrorExcepcion 
   */

  public void incremetaMercancia(int codigo, int cantidad)  throws CodigoArticuloNoExisteExcepcion, UnidadesNegativasErrorExcepcion{
    get(codigo).entradaMercancia(cantidad);
  }

  // Método para decrementar las unidades de un artículo del almacén
  /**
   * Método para decrementar las unidades de un artículo del almacén
   * @param codigo
   * @param cantidad
   */

  public void decremetaMercancia(int codigo, int cantidad) throws CodigoArticuloNoExisteExcepcion, UnidadesNegativasErrorExcepcion{
    get(codigo).salidaMercancia(cantidad);

  }

  // Método toString para listar el almacén
  /**
   * Método toString para listar el almacén
   */

  @Override
  public String toString() {
    return "Almacen\n" + almacen;
  }

  /**
   * Método para exportar el almacen en formato CSV
   * @param archivo
   * @return 
   * @throws CSVExcepcion
   */

  public void exportaCSV(String archivo) throws CSVExcepcion {
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
      bw.write("Código, Descripción, Precio Compra, Precio Venta, Unidades,Stock Mínimo");
      bw.newLine();
      for(Articulo articulo:almacen) {
        bw.write(articulo.getCodigo() + ",\""+ articulo.getDescripcion() + "\"," + 
            articulo.getPrecioCompra() + "," + articulo.getPrecioVenta() + "," + articulo.getNumUnidades() + "," +  articulo.getTipoDeIva() + "," + articulo.getStockMin());
        bw.newLine();
      }
      bw.close();

    } catch (IOException e) {
      throw new CSVExcepcion("error de escritura en " + archivo);

    }


  }

  /**
   * 
   * @param archivo
   * @throws CSVExcepcion
   * @throws UnidadesNegativasErrorExcepcion 
   * @throws PrecioNegativoErrorExcepcion 
   * @throws IvaInvalidoExcepcion 
   * @throws ErrorUnidadesNegativas 
   */
  public void importarCSV(String archivo) throws CSVExcepcion,NumberFormatException, UnidadesNegativasErrorExcepcion, PrecioNegativoErrorExcepcion, IvaInvalidoExcepcion, NullPointerException {
    try {
      BufferedReader csv = new BufferedReader(new FileReader(archivo));
      String linea = csv.readLine();
      linea = csv.readLine(); // lectura de la primera línea
      while (linea != null) {
        String[] elemento = linea.split(",");
        // Con el método annadir se añade un nuevo artículo
        annade(elemento[1].replace("\"", ""), // quitamos comillas
            Double.parseDouble(elemento[2]), // precio de compra
            Double.parseDouble(elemento[3]), // precio de venta
            Integer.parseInt(elemento[4]), // unidades
            TipoIva.valueOf(elemento[5]),
            Integer.parseInt(elemento[6]));

        linea = csv.readLine();
      }

      csv.close();

    } catch (Exception e) {
      throw new CSVExcepcion("Error de lectura en " + archivo);
    }

  }


  /**
   * 
   * @param archivo
   * @throws XMLExcepcion
   */

  public void exportaXML(String archivo) throws XMLExcepcion {
    try {
      // clases necesarias para crear el archivo

      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document doc = db.newDocument();

      // Creamos el nodo raiz del alamcén <almacen></almacen>
      Element raiz = doc.createElement("almacen");
      doc.appendChild (raiz);

      // bucle foreach para recorrer lo que tenemos dentro de cada articulo
      // dentro empezaremos a recorrer el cuerpo del nodo raiz (codigo, 
      // descripcion,precioVenta, precioCompra, numUnidades

      for (Articulo art : almacen){
        Element articulo =  doc.createElement("articulo");
        raiz.appendChild(articulo);

        // El codigo va ser un atributo y asi lo tratamos

        Attr codigo = doc.createAttribute("codigo");
        codigo.setValue(Integer.toString(art.getCodigo()));
        articulo.setAttributeNode(codigo);

        //Nodo descripcion <descripcion></descripcion>
        Element descripcion = doc.createElement("descripcion");
        descripcion.appendChild(doc.createTextNode(art.getDescripcion()));
        articulo.appendChild(descripcion);

        //Nodo precioCompra <precioCompra></precioCompra>
        Element precioCompra = doc.createElement("precioCompra");
        precioCompra.appendChild(doc.createTextNode(Double.toString(art.getPrecioCompra())));
        articulo.appendChild(precioCompra);

        //Nodo precioVenta <precioVenta></precioVenta>
        Element precioVenta = doc.createElement("precioVenta");
        precioVenta.appendChild(doc.createTextNode(Double.toString(art.getPrecioVenta())));
        articulo.appendChild(precioVenta);

        //Nodo numUnidades <numUnidades></numUnidades>
        Element numUnidades = doc.createElement("unidades");
        numUnidades.appendChild(doc.createTextNode(Integer.toString(art.getNumUnidades())));
        articulo.appendChild(numUnidades);

        //Nodo numUnidades <numUnidades></numUnidades>
        Element tipoIva = doc.createElement("tipoIva");
        tipoIva.appendChild(doc.createTextNode(art.getTipoDeIva().toString()));
        articulo.appendChild(tipoIva);

        Element stockMin = doc.createElement("stockMin");
        stockMin.appendChild(doc.createTextNode(Integer.toString(art.getStockMin())));
        articulo.appendChild(stockMin);

      }

      // guardar XML en el fichero

      TransformerFactory tf = TransformerFactory.newInstance();
      Transformer t = tf.newTransformer();
      DOMSource s = new DOMSource(doc);
      StreamResult r = new  StreamResult(new FileWriter(archivo));
      t.transform(s, r);

    } catch (IOException e) {
      throw new XMLExcepcion("Error al crear" + archivo + ": " + e.getMessage());
    } catch (TransformerException e) {
      throw new XMLExcepcion("Error en la salida XML" + archivo + ": " + e.getMessage());
    } catch (ParserConfigurationException e) {
      throw new XMLExcepcion("Error construyendo el documento xml" + archivo + ": " + e.getMessage());

    }

  }

  public void importaXML(String archivo) throws ParserConfigurationException, IOException, XMLExcepcion, SAXException, UnidadesNegativasErrorExcepcion, PrecioNegativoErrorExcepcion, IvaInvalidoExcepcion, CampoVacioException, PrecioIncorrecto  {

    try {

      // creamos el documento XML

      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document doc = (Document) db.parse(new File(archivo));
      doc.getDocumentElement().normalize();

      // acceso a la lista de nodos del articulo

      NodeList articulos =  doc.getElementsByTagName("articulo");

      // recorremos los nodos de articulo

      for(int i = 0; i < articulos.getLength(); i++) {

        // nodo articulo
        Node nodo =  articulos.item(i);
        Element articulo = (Element) nodo;

        // campos del articulo
        String descripcion = articulo.getElementsByTagName("descripcion").item(0).getTextContent();
        double precioCompra = Double.parseDouble(articulo.getElementsByTagName("precioCompra").item(0).getTextContent());
        double precioVenta = Double.parseDouble(articulo.getElementsByTagName("precioVenta").item(0).getTextContent());
        int unidades = Integer.parseInt(articulo.getElementsByTagName("unidades").item(0).getTextContent());
        TipoIva tipoDeIva = TipoIva.valueOf(articulo.getElementsByTagName("tipoIva").item(0).getTextContent());
        int stockMin = Integer.parseInt(articulo.getElementsByTagName("stockMin").item(0).getTextContent());
        // añadimos los campos al almacén
        annade(descripcion, precioCompra, precioVenta, unidades, tipoDeIva, stockMin);
      }

    } catch (ParserConfigurationException e) {
      throw new XMLExcepcion("Error al abrir " + archivo + ": " + e.getMessage());
    } catch (IOException e) {
      throw new XMLExcepcion("Error al crear" + archivo + ": " + e.getMessage());

    } catch (SAXException e) {
      throw new XMLExcepcion("Error construyendo el documento xml" + archivo + ": " + e.getMessage());

    }

  }

  /**
   * Método para exportar los datos del almacen a un fichero.JSON
   * @param archivo
   * @throws JSONException 
   * @throws IOException 
   */

  public void exportaJSON(String archivo) throws JSONException  {

    try {
      // primero tenemos que apsar el arraylist almacen a json
      String json = new Gson().toJson(almacen);

      // ahora tenemos que guardar el json en el archivo que queremos

      BufferedWriter bf = new BufferedWriter(new FileWriter(archivo));
      bf.write(json); // escribimos el archivo
      bf.close();     //  cerramos el archivo

    } catch (Exception e) {
      System.err.println(e.getMessage());
      throw new JSONException("error al crear el archivo JSON en " + archivo + ": " + e.getMessage());

    }

  }

  /**
   * 
   * @param archivo
   * @throws JSONException 
   */

  public void importaJSON(String archivo) throws JSONException {
    try {

      // priemro tenemos que leer el formato json del archivo

      BufferedReader bf = new BufferedReader (new FileReader(archivo));
      String json = bf.readLine();
      bf.close(); // cerramos el archivo

      // ahora tenemos que convertir el json en un arraylist de almacen
      Gson gson = new Gson();
      Type tipoArticulo = new TypeToken<ArrayList<Articulo>>(){}.getType();
      ArrayList<Articulo> articulos = gson.fromJson(json, tipoArticulo);

      // ahora tenemos que añadir los articulos

      for (Articulo art : articulos) {
        annade(art.getDescripcion(), art.getPrecioCompra(), art.getPrecioVenta(), art.getNumUnidades(), art.getTipoDeIva(), art.getStockMin());

      }

    } catch (Exception e) {
      throw new JSONException("error al crear el archivo JSON en " + archivo + ": " + e.getMessage());
    }


  }


  public void exporta(ArrayList<Articulo> lista) {
    lista.clear();
    for (Articulo articulo: almacen) {
      lista.add(articulo);
    }
  }


  public Iterator<Articulo> iterator() {
    return almacen.iterator();
  }



}
