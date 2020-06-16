/**
 * Controlador dedicado a modificar un artículo con las siguentes opciones:
 *    - Introducir el código del artículo a modificar
 *    - Modificar la descripción del producto
 *    - Modificar el precio de compra del artículo
 *    - Modificar el precio de Venta del artículo
 *    - Modificar el número de unidades del artículo
 *    - Modificar el tipo de IVA del artículo
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
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

// Creacion clase ModificaArticulo

public class ModificaArticuloController implements Initializable{

  private Almacen almacen = AlmacenFx.getAlmacen();

  // Definimos los espacios de nombre correspondientes a cada nodo que vamos a utilizar en esta clase

  @FXML
  private Spinner<Integer> spinnerModifica;
  @FXML
  private ComboBox<String> tipoIvaModifica;
  @FXML
  private TextField descripcionModifica;
  @FXML
  private TextField compraModifica;
  @FXML
  private TextField ventaModifica;
  @FXML
  private Spinner<Integer> spinnerStockMin;
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
    tipoIvaModifica.getItems().addAll("GENERAL", "REDUCIDO", "SUPERREDUCIDO");

    // Listener para evitar que en el Spinner usemos cualquier caracter que no sea numérico

    spinnerModifica.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
      if (! esNumerico(newValue)) {
        spinnerModifica.getEditor().setText(oldValue);
      }
    });

    // Listener para evitar que en el Spinner usemos cualquier caracter que no sea numérico
    spinnerStockMin.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
      if (! esNumerico(newValue)) {
        spinnerStockMin.getEditor().setText(oldValue);
      }
    });
  }

  /**
   * Método para evitar introducir cadenas en los spinners
   * @param cadena
   * @return
   */
  private static boolean esNumerico(String cadena) {
    return Pattern.matches("^[1-9][0-9]*$", cadena);
  }

  /**
   * Método para devolver los campos descripcion, precio compra, precio de venta, unidades, stock minimo y tipo de iva
   * @param codigo
   * @throws FileNotFoundException 
   */

  public void set(int codigo) throws FileNotFoundException {
    this.codigo = codigo;
    try {
      descripcionModifica.setText(almacen.get(this.codigo).getDescripcion());
      compraModifica.setText(almacen.get(this.codigo).getPrecioCompra() + " ");
      ventaModifica.setText(almacen.get(this.codigo).getPrecioVenta() + " ");

      SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000, almacen.get(this.codigo).getNumUnidades());
      spinnerModifica.setValueFactory(spinnerValueFactory);

      SpinnerValueFactory<Integer> spinnerStockMinimo = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000, almacen.get(this.codigo).getStockMin());
      spinnerStockMin.setValueFactory(spinnerStockMinimo);

      if (almacen.get(this.codigo).getTipoDeIva().toString().equals("GENERAL")) {
        tipoIvaModifica.getSelectionModel().select(0);
      } else if (almacen.get(this.codigo).getTipoDeIva().toString().equals("REDUCIDO")) {
        tipoIvaModifica.getSelectionModel().select(1);
      } else {
        tipoIvaModifica.getSelectionModel().select(2);
      }
      
      
      
      String imagenArticulo = "articulo000" + codigo + ".png";

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
   * Creación del método modificar para poder modificar los datos de los artículos que hay en el almacén
   * @param e
   * @throws CampoVacioException 
   * @throws PrecioIncorrecto 
   * @throws CodigoArticuloNoExisteExcepcion 
   */

  public void modificar (ActionEvent e) throws CampoVacioException  {

    try {
      String descripcion = descripcionModifica.getText();
      double precioC = Double.parseDouble(compraModifica.getText());
      double precioV = Double.parseDouble(ventaModifica.getText());
      int unidades = (spinnerModifica.getValue());
      TipoIva tipodeIVa = pideIva(tipoIvaModifica.getValue());
      int stockMin = (spinnerStockMin.getValue());

      almacen.modificacion(codigo, descripcion, precioC, precioV, unidades, tipodeIVa, stockMin);

    } catch ( PrecioIncorrecto | CampoVacioException | NullPointerException | CodigoArticuloNoExisteExcepcion | NumberFormatException | PrecioNegativoErrorExcepcion | UnidadesNegativasErrorExcepcion | IvaInvalidoExcepcion exc) {
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
   * Creación del método cancelar para cancelar el alta de un artículo al almacén.  
   * @param e
   */

  public void cancelar (ActionEvent e) {
    Stage stage =  (Stage) btnCancelar.getScene().getWindow();
    stage.close();
  }

  /**
   * Método elegirImagen para que el usuario pueda elegir una foto del artículo que esta dando de alta
   */

  public void elegirImagen(){
    String ficheroCopia = "/articulo000" + codigo + ".png";

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