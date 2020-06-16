/**
 * Controlador dedicado a dar salida de una cantidad de unidades de un artículo al almacén con las siguentes opciones:
 *    - Introducir el número de unidades del artículo
 * 
 * @author JOSÉ LUIS ÁLVAREZ FÉRNANDEZ
 * @author FRANCISCO JAVIER CAMPOS GUTIÉRREZ
 * @author ANTONIO QUESADA CUADRADO
 */

package application.vistas;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import application.AlmacenFx;
import application.gestisimal.Almacen;
import application.gestisimal.CodigoArticuloNoExisteExcepcion;
import application.gestisimal.UnidadesNegativasErrorExcepcion;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//Creación Clase SalidaMercanciaController

public class SalidaMercanciaController implements Initializable{

  private Almacen almacen = AlmacenFx.getAlmacen();
  //private int stockMin;

  // Definimos los espacios de nombre correspondientes a cada nodo que vamos a utilizar en esta clase
  @FXML
  private Spinner<Integer> spinnerSalida;
  @FXML
  private ComboBox<String> tipoIvaSalida;
  @FXML
  private TextField descripcionSalida;
  @FXML
  private TextField compraSalida;
  @FXML
  private TextField ventaSalida;
  @FXML
  private TextField codigoSalida;
  @FXML 
  private Button btnCancelar;
  @FXML 
  private ImageView imagen;
  @FXML 
  private Button elegirImagen;
  @FXML
  private Spinner<Integer> spinnerStockMin;

  private int codigo;

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    // Haecmos que no se puedan introducir caracteres en el spinner
    spinnerSalida.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
      if (! esNumerico(newValue)) {
        spinnerSalida.getEditor().setText(oldValue);
      }
    });
  }

  /**
   * Método para no ontroducir caracteres en el Spinner, solo números enteros
   * @param cadena
   * @return
   */

  private static boolean esNumerico(String cadena) {
    return Pattern.matches("^[1-9][0-9]*$", cadena);
  }

  /**
   * Método modificar para que al introducir una cantidad de unidades estas se resten a las que ya tenia el artículo
   * @param event
   * @throws IOException
   * @throws UnidadesNegativasErrorExcepcion 
   * @throws CodigoArticuloNoExisteExcepcion 
   */

  @FXML
  public void modificar(ActionEvent event) throws IOException, CodigoArticuloNoExisteExcepcion, UnidadesNegativasErrorExcepcion {

    // Creamos una rchivo que indica la cantidad de unidades decrementadas de cada artículo
    BufferedWriter fichero = null;
    FileWriter fw = null;
    try {
      File file = new File("Salida_Mercancia.txt");
      if(file.exists()) {
        int unidades = (almacen.get(codigo).getNumUnidades() - spinnerSalida.getValue());
        almacen.decremetaMercancia(codigo, unidades);
        fw = new FileWriter(file.getAbsoluteFile(), true);
        fichero = new BufferedWriter(fw);
        fichero.newLine();

        Date fecha = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        fichero.write("Código:\t" + String.valueOf(codigo) + "\tNúmero de unidades decrementadas: " + String.valueOf(unidades) +"\tFecha:\t" +formatter.format(fecha));
        fichero.newLine();

      } else {
        int unidades = ( almacen.get(codigo).getNumUnidades() - spinnerSalida.getValue());
        almacen.incremetaMercancia(codigo, unidades);
        fw = new FileWriter(file.getAbsoluteFile(), true);
        fichero = new BufferedWriter(fw);
        fichero.write("Fichero histórico con la información de la entrada de mercancía de GESTISIMAL");
        fichero.newLine();
        Date fecha = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        fichero.write("Código:\t" + String.valueOf(codigo) + "\tNúmero de unidades decrementadas: " + String.valueOf(unidades) +"\tFecha:\t" +formatter.format(fecha));
      }
      fichero.close();
      Alert alert1 = new Alert(AlertType.INFORMATION);
      alert1.setTitle("ENtrada de mercancía realizada");
      alert1.setHeaderText("Se ha generado un fichero interno con la información correspondiente");
      alert1.setContentText("Gracias por realizar el pedido");
      alert1.setResizable(true);
      alert1.getDialogPane().setPrefSize(400, 200);
      alert1.showAndWait();

    } catch (NumberFormatException | CodigoArticuloNoExisteExcepcion | UnidadesNegativasErrorExcepcion exc) {
      Alert alert = new Alert(AlertType.ERROR );
      alert.setTitle("¡Error en el programa!");
      alert.setHeaderText("Error al modificar el artículo");
      alert.setContentText("Introduce las unidades correctamente");
      alert.setResizable(true);
      alert.getDialogPane().setPrefSize(400, 200);
      Label etiqueta = new Label ("La excepcion trazada fue: ");
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
   * Método cancelar para cerrar la ventana y no efectuar cambios en la apliación
   * @param event
   */

  @FXML
  public void cancelar(ActionEvent event) {
    Stage stage =  (Stage) btnCancelar.getScene().getWindow();
    stage.close();
  }

  /**
   * Método pra que se muestren la información de cada artículo
   * @param codigo
   */

  public void set(int codigo) {
    this.codigo = codigo;
    try {
      descripcionSalida.setText(almacen.get(this.codigo).getDescripcion());
      compraSalida.setText(almacen.get(this.codigo).getPrecioCompra() + " ");
      ventaSalida.setText(almacen.get(this.codigo).getPrecioVenta() + " ");

      SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, almacen.get(this.codigo).getNumUnidades(), almacen.get(this.codigo).getNumUnidades());
      spinnerSalida.setValueFactory(spinnerValueFactory);

      SpinnerValueFactory<Integer> spinnerStockMinimo = new SpinnerValueFactory.IntegerSpinnerValueFactory(almacen.get(this.codigo).getStockMin(),almacen.get(this.codigo).getStockMin(),almacen.get(this.codigo).getStockMin());
      spinnerStockMin.setValueFactory(spinnerStockMinimo);

      tipoIvaSalida.getItems().addAll(almacen.get(this.codigo).getTipoDeIva().toString());
      tipoIvaSalida.getSelectionModel().select(0);


    } catch (CodigoArticuloNoExisteExcepcion e) {
      e.getMessage();
    }
  }
}
