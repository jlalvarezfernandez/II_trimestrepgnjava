/**
 * Creación de la clase ListaIndividual donde se mostrará cada artículo de forma individual y tenemos las siguientes opciones:
 *     - Modificar la información de cada artículo
 *     - ver el artículo anterior y posterior ala ctual artículo que se muestra en pantalla
 *     - cambiar vista (vuelve a la tabla colectiva con todos los artículos)
 *     
 * @author JOSÉ LUIS ÁLVAREZ FÉRNANDEZ
 * @author FRANCISCO JAVIER CAMPOS GUTIÉRREZ
 * @author ANTONIO QUESADA CUADRADO
 */

package application.vistas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.AlmacenFx;
import application.gestisimal.Almacen;
import application.gestisimal.Articulo;
import application.gestisimal.CampoVacioException;
import application.gestisimal.CodigoArticuloNoExisteExcepcion;
import application.gestisimal.IvaInvalidoExcepcion;
import application.gestisimal.PrecioIncorrecto;
import application.gestisimal.PrecioNegativoErrorExcepcion;
import application.gestisimal.TipoIva;
import application.gestisimal.UnidadesNegativasErrorExcepcion;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;

// Creación clase ListaIndividualController

public class ListaIndividualController implements Initializable{

  private Almacen almacen = AlmacenFx.getAlmacen();

  private int codigo;

  // definimos los espacios de nombres asociados a cada nodo que vamos a utilizar
  @FXML
  private ImageView imagen;
  @FXML
  private TextField descripcionModifica;
  @FXML
  private TextField ventaModifica;
  @FXML
  private TextField compraModifica;
  @FXML
  private Spinner<Integer> spinnerModifica;
  @FXML
  private ComboBox<String> tipoIvaModifica;
  @FXML
  private Spinner<Integer> spinnerStockMin;
  @FXML
  private Button btnCancelar;
  @FXML
  private Button elegirImagen;
  @FXML
  private TextField listaModificaIndividual;
  @FXML
  private TextField codigoArticulo;



  @Override
  public void initialize(URL location, ResourceBundle resources) {
    ArrayList<Articulo> lista = new ArrayList<Articulo>();

    for (Articulo articulo : almacen) {
      lista.add(articulo);
    }

    // establecemos los tipos de iva
    tipoIvaModifica.getItems().addAll("GENERAL", "REDUCIDO", "SUPERREDUCIDO");
    
    

    // asi hacemos que la primera ventana que se abra corresponde al articulo con código número 1


    codigoArticulo.setText(lista.get(0).getCodigo() + "");
    descripcionModifica.setText(lista.get(0).getDescripcion());
    compraModifica.setText(lista.get(0).getPrecioCompra() + "");
    ventaModifica.setText(lista.get(0).getPrecioVenta() + "");
 

    if (lista.get(0).getTipoDeIva().toString().equals("GENERAL")) {
      tipoIvaModifica.getSelectionModel().select(0);
    } else if (lista.get(0).getTipoDeIva().toString().equals("REDUCIDO")) {
      tipoIvaModifica.getSelectionModel().select(1);
    } else {
      tipoIvaModifica.getSelectionModel().select(2);
    }   


    // donde modificaremos los valores del Spinner
    SpinnerValueFactory<Integer> spinnerUnidades = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000, lista.get(0).getNumUnidades());
    spinnerModifica.setValueFactory(spinnerUnidades);

    SpinnerValueFactory<Integer> spinnerStock = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000, lista.get(0).getStockMin());
    spinnerStockMin.setValueFactory(spinnerStock);

  }
  /**
   * Método para devolver los campos descripción, precio compra, precio de venta, unidades, stock minimo y tipo de iva
   * @param codigo
   * @throws FileNotFoundException 
   */

  public void set(int codigo) throws FileNotFoundException {
    this.codigo = codigo;
    try {
      codigoArticulo.setText(almacen.get(this.codigo).getCodigo()+ "");
      descripcionModifica.setText(almacen.get(this.codigo).getDescripcion());
      compraModifica.setText(almacen.get(this.codigo).getPrecioCompra() + " ");
      ventaModifica.setText(almacen.get(this.codigo).getPrecioVenta() + " ");

      SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(almacen.get(this.codigo).getNumUnidades(), 1000, 0);
      spinnerModifica.setValueFactory(spinnerValueFactory);

      SpinnerValueFactory<Integer> spinnerValueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(almacen.get(this.codigo).getStockMin(), 1000, 0);
      spinnerStockMin.setValueFactory(spinnerValueFactory2);

      String imagenInicial = "articulo000" + codigo + ".png";
      String rutaArticulo = ("C:/Users/Gestisimal/"  + imagenInicial);
      //
      File ruta = new File(rutaArticulo);
      Image img = null;
      try {
        if (ruta.exists()) {
          img = new Image(new FileInputStream("C:/Users/Gestisimal/" + imagenInicial));
          imagen.setImage(img);
        } else {
          img = null;
          imagen.setImage(img); 

        }
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }


      if (almacen.get(this.codigo).getTipoDeIva().toString().equals("GENERAL")) {
        tipoIvaModifica.getSelectionModel().select(0);
      } else if (almacen.get(this.codigo).getTipoDeIva().toString().equals("REDUCIDO")) {
        tipoIvaModifica.getSelectionModel().select(1);
      } else {
        tipoIvaModifica.getSelectionModel().select(2);
      }

    } catch (CodigoArticuloNoExisteExcepcion e) {
      e.getMessage();
    }
  }

  /**
   * Método para elegir el tipo de Iva
   * @param valor
   * @return GENERAL, REDUCIDO, SUPERREDUCIDO
   */
  private TipoIva pideIva(String valor) {
    if (TipoIva.valueOf(valor) == TipoIva.GENERAL) {
      return TipoIva.GENERAL;
    } else if (TipoIva.valueOf(valor) == TipoIva.REDUCIDO) {
      return TipoIva.REDUCIDO;
    } else {
      return TipoIva.SUPERREDUCIDO;
    }
  }

  /**
   * Método modifica para modificar un artículo del almacén
   * @param e
   * @throws CampoVacioException
   * @throws PrecioIncorrecto 
   * @throws FileNotFoundException 
   */

  public void modificar (ActionEvent e) throws CampoVacioException, PrecioIncorrecto, UnidadesNegativasErrorExcepcion  {
    try {
      int codigo = Integer.parseInt(codigoArticulo.getText());
      String descripcion = descripcionModifica.getText();
      double precioC = Double.parseDouble(compraModifica.getText());
      double precioV = Double.parseDouble(ventaModifica.getText());
      int unidades = (spinnerModifica.getValue());
      TipoIva tipodeIVa = pideIva(tipoIvaModifica.getValue());
      int stockMin = (spinnerStockMin.getValue());


      almacen.modificacion(codigo, descripcion, precioC, precioV, unidades, tipodeIVa, stockMin);

    } catch ( PrecioIncorrecto | CodigoArticuloNoExisteExcepcion | NumberFormatException | PrecioNegativoErrorExcepcion | UnidadesNegativasErrorExcepcion | IvaInvalidoExcepcion exc) {
      Alert alert = new Alert(AlertType.ERROR );
      alert.setTitle("¡Error en el programa!");
      alert.setHeaderText("Error al modificar el artículo");
      alert.setContentText("Introduce un código correcto");
      alert.setResizable(true);
      alert.getDialogPane().setPrefSize(400, 200);
      Label etiqueta = new Label ("La excepcion lanzada fue: ");
      TextArea texto = new TextArea(exc.getMessage());
      texto.setEditable(false);
      GridPane excep = new GridPane();
      excep.add(etiqueta,0,0);
      excep.add(texto,0,1);
      alert.getDialogPane().setExpandableContent(excep);
      alert.showAndWait();
    }
    Stage stage =  (Stage) btnCancelar.getScene().getWindow();
    stage.close();
  }

  /**
   * Creación del método cancelar para cancelar el añadido de un artículo al almacén.  
   * @param e
   */

  public void cancelar (ActionEvent e) {
    Stage stage =  (Stage) btnCancelar.getScene().getWindow();
    stage.close();
  }

  /**
   * Método siguiente para ver la información del siguiente artículo
   * @param e
   * @throws IOException
   * @throws CodigoArticuloNoExisteExcepcion
   */
  public void siguiente(ActionEvent e) throws IOException, CodigoArticuloNoExisteExcepcion {

    ArrayList<Articulo> lista = new ArrayList<Articulo>();

    for (Articulo articulo : almacen) {
      lista.add(articulo);
    }

    int indice = lista.indexOf(new Articulo(Integer.parseInt(codigoArticulo.getText())));
    pasaCodigo(lista, indice, "+");

  }

  /**
   * Método anterior apra ver la información del artículo anterior
   * @param e
   * @throws FileNotFoundException 
   */
  public void anterior (ActionEvent e) throws FileNotFoundException {
    ArrayList<Articulo> lista = new ArrayList<Articulo>();

    for (Articulo articulo : almacen) {
      lista.add(articulo);
    }

    int indice = lista.indexOf(new Articulo(Integer.parseInt(codigoArticulo.getText())));
    pasaCodigo(lista, indice, "-");

  }
  /**
   * Método pasaCodigo para poder cambiar la informacíon de un articulo a otro
   * @param lista2 
   * @param indice
   * @param incremento
   * @throws FileNotFoundException 
   */

  public void pasaCodigo(ArrayList<Articulo> lista, int indice, String incremento) throws FileNotFoundException {

    try {
      if(incremento.equals("+")) {
        indice += 1;
      } else {
        indice -= 1;
      }

      if (indice < lista.size() || indice > lista.size()) {

        codigoArticulo.setText(lista.get(indice).getCodigo() + "");
        descripcionModifica.setText(lista.get(indice).getDescripcion());
        compraModifica.setText(lista.get(indice).getPrecioCompra() + "");
        ventaModifica.setText(lista.get(indice).getPrecioVenta() + ""); 

        SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, lista.get(indice).getNumUnidades());
        spinnerModifica.setValueFactory(spinnerValueFactory);

        SpinnerValueFactory<Integer> spinnerValueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000,lista.get(indice).getStockMin());
        spinnerStockMin.setValueFactory(spinnerValueFactory2);

        String imagenArticulo = "articulo000" + lista.get(indice).getCodigo() + ".png";

        String rutaArticulo = ("C:/Users/Gestisimal/"  + imagenArticulo);


        File ruta = new File(rutaArticulo);
        Image image1 = null;
        if (ruta.exists()) {
          image1 = new Image(new FileInputStream("C:/Users/Gestisimal/" + imagenArticulo));
          imagen.setImage(image1);
        } else {
          image1 = null;
          imagen.setImage(image1); 
        }


        if (lista.get(indice).getTipoDeIva().toString().equals("GENERAL")) {
          tipoIvaModifica.getSelectionModel().select(0);
        } else if (lista.get(indice).getTipoDeIva().toString().equals("REDUCIDO")) {
          tipoIvaModifica.getSelectionModel().select(1);
        } else {
          tipoIvaModifica.getSelectionModel().select(2);
        }

      }

    }catch (IndexOutOfBoundsException e2) {
      Alert alert = new Alert(AlertType.INFORMATION );
      alert.setTitle("¡Error en el programa!");
      alert.setHeaderText("No hay más artículos");
      alert.setContentText("Ha llegado al límite de artículos del almacén");
      alert.setResizable(true);
      alert.getDialogPane().setPrefSize(400, 200);
      alert.showAndWait();
    }

  }

  /**
   * Método cambiarVista que nos lleva a la ventana con la tabla colectiva de artículos
   * @param event
   * @throws IOException
   */

  public void cambiarVista(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/application/vistas/ListaColectiva.fxml"));
    Scene escena = new Scene(root);
    Stage escenario = new Stage();
    escenario.setTitle("Lista Individual");
    escenario.setResizable(false);
    escenario.setScene(escena);
    escenario.showAndWait();
    Stage stage =  (Stage) btnCancelar.getScene().getWindow();
    stage.close();
  }


  /**
   * Método elegirImagen para que el usuario pueda elegir una foto del artículo que esta dando de alta
   */
  public void elegirImagen(){
    String ficheroCopia = "/articulo000" + codigoArticulo.getText() + ".png";

    FileChooser file = new FileChooser();
    file.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imagen Files", "*.png"));
    //file.setInitialDirectory(new File("/application/storeImages"));
    Window stage = null;
    File imgFile = file.showOpenDialog(stage);
    // Mostar la imagen
    if (imgFile != null) {
      Image image = new Image("file:" + imgFile.getAbsolutePath());
      imagen.setImage(image);
    }
    // Copiamos la imagen
    InputStream inputStream = null;
    OutputStream outputStream = null;
    try {

      String directorio = null;
      String sSistemaOperativo = System.getProperty("os.name");

      if (sSistemaOperativo.toLowerCase().indexOf("win") >= 0) {
        directorio = "C://Users//Gestisimal///";

      } 
      else if (sSistemaOperativo.toLowerCase().indexOf("mac") >= 0) {
        directorio = "/Library/Gestisimal/imagenesArticulos/";
      }
      else  {
        //directorio = $HOME + "/.Gestisimal/imagenesArticulos/"  mirar usuario
        directorio = "~/Gestisimal/imagenesArticulos/";
        //directorio = /opt/Gestisimal/imagenesArticulos/"
        //directorio = "/home/Gestisimal/imagenesArticulos/";
      }

      File archivoOriginal = new File(imgFile.getAbsolutePath());
      File archivoCopia = new File(directorio);

      if (!archivoCopia.exists()) { // mirar
        archivoCopia.mkdir();

      }
      inputStream = new FileInputStream(archivoOriginal);
      outputStream = new FileOutputStream(archivoCopia + ficheroCopia);


      byte[] buffer = new byte[1024];
      int length;
      while ((length = inputStream.read(buffer)) > 0) {
        outputStream.write(buffer, 0, length);
      }
      inputStream.close();
      outputStream.close();
      System.out.println("Archivo copiado.");
    } catch (IOException | NullPointerException e) {

    }

  }

}
