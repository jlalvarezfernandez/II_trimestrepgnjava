/**
 * Controlador dedicado a dar de alta un artículo con las siguentes opciones:
 *  
 *    - Introducir la descripción del producto
 *    - Introducir el precio de compra del artículo
 *    - Introducir el precio de Venta del artículo
 *    - Introducir el número de unidades del artículo
 *    - Introducir el tipo de IVA del artículo
 * 
 * @author JOSÉ LUIS ÁLVAREZ FÉRNANDEZ
 * @author FRANCISCO JAVIER CAMPOS GUTIÉRREZ
 * @author ANTONIO QUESADA CUADRADO
 */

package application.vistas;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

// Creacion clase AltaArticuloController

public class AltaArticuloController implements Initializable{

  // Asi podemos trabajar con la información de los artículos que tenemos en nuestro almacén
  private Almacen almacen = AlmacenFx.getAlmacen();
  
  
  // Definimos los espacios de nombre correspondientes a cada nodo que vamos a utilizar en esta clase
  @FXML
  private Spinner<Integer> spinnerAlta;
  @FXML
  private ComboBox<String> tipoIvaAlta;
  @FXML
  private TextField descripcionAlta;
  @FXML
  private TextField compraAlta;
  @FXML
  private TextField ventaAlta;
  @FXML
  private Spinner<Integer> spinnerstockMin;
  @FXML 
  private Button btnCancelar;
  @FXML 
  private ImageView imagen;
  @FXML 
  private Button elegirImagen;
  
  private int codigo;

  //Método initializable en el que hemos creado los valores del comboBox para el tipo de IVA y un Spinner para introducir el número de unidades
  /**
   * Método initializable en el que hemos creado los valores del comboBox para el tipo de IVA
   * y un Spinner para introducir el número de unidades
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {

    // Valores para el ComboBox
    tipoIvaAlta.getItems().addAll("GENERAL", "REDUCIDO", "SUPERREDUCIDO");

    // Valores para las unidades del Spinner, solo podrá haber hasta un máximo de 1000 unidades de un determinado artículo
    SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000, 0);
    spinnerAlta.setValueFactory(spinnerValueFactory);

    // Asi nos aseguramos de que solo se introducen carárteres numéricos 
    spinnerAlta.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
      if (! esNumerico(newValue)) {
        spinnerAlta.getEditor().setText(oldValue);
      }
    });

    // Asi nos aseguramos de que solo se introducen carárteres numéricos 
    spinnerstockMin.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
      if (! esNumerico(newValue)) {
        spinnerstockMin.getEditor().setText(oldValue);
      }
    });

    // Valores para las unidades del stock minimo para realizar el pedido automático
    SpinnerValueFactory<Integer> spinnerStockMinimo = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 10);
    spinnerstockMin.setValueFactory(spinnerStockMinimo);
    
    String imagenArticulo = "articulo000" + codigo + ".png";

    String rutaArticulo = ("C:/Users/Gestisimal/"  + imagenArticulo);


    File ruta = new File(rutaArticulo);
    Image image1 = null;
    if (ruta.exists()) {
      try {
        image1 = new Image(new FileInputStream("C:/Users/Gestisimal/" + imagenArticulo));
        imagen.setImage(image1);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    } else {
      image1 = null;
      imagen.setImage(image1); 
    }
  }

  /**
   * Método para no introducir cadenas en los spinners
   * @param cadena
   * @return
   */
  private static boolean esNumerico(String cadena) {
    return Pattern.matches("^[1-9][0-9]*$", cadena);
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
   * Creación del método anadir para poder dar de alta artículos 
   * @param e
   * @throws CampoVacioException 
   * @throws CodigoArticuloNoExisteExcepcion 
   * @throws PrecioIncorrecto 
   */

  public void anadir (ActionEvent e) throws CampoVacioException, CodigoArticuloNoExisteExcepcion  {

    try {
      String descripcion = descripcionAlta.getText();
      double precioC = Double.parseDouble(compraAlta.getText());
      double precioV = Double.parseDouble(ventaAlta.getText());
      int unidades = (spinnerAlta.getValue());
      TipoIva tipodeIVa = pideIva(tipoIvaAlta.getValue());
      int stockMin = (spinnerstockMin.getValue());
      almacen.annade(descripcion, precioC, precioV, unidades, tipodeIVa, stockMin);


    } catch ( PrecioIncorrecto | NullPointerException | CampoVacioException | NumberFormatException | PrecioNegativoErrorExcepcion | UnidadesNegativasErrorExcepcion | IvaInvalidoExcepcion exc) {
      Alert alert = new Alert(AlertType.ERROR );
      alert.setTitle("¡Error en el programa!");
      alert.setHeaderText("Error al dar de alta el artículo");
      alert.setContentText("Introduce correctamente los datos");
      alert.setResizable(true);
      alert.showAndWait();
    } 
    // asi cerramos la ventana después de realizar los cambios
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
   * Método elegirImagen para que el usuario pueda elegir una foto del artículo que esta dando de alta
   * @throws CodigoArticuloNoExisteExcepcion 
   */
  
  public void elegirImagen() throws CodigoArticuloNoExisteExcepcion  {
    for(Articulo lista : almacen) {
      codigo = lista.getCodigo();
    }
    String ficheroCopia = "/articulo000" + (codigo + 1) + ".png";

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
        directorio = "/Gestisimal/imagenesArticulos/";
      }

      File archivoOriginal = new File(imgFile.getAbsolutePath());
      File archivoCopia = new File(directorio);

      if (archivoCopia.exists()) {
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










