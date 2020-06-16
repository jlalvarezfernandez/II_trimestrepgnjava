/**
 * Controlador dedicado a dar entrada de una cantidad de unidades de un artículo al almacén con las siguentes opciones:
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

//Creación Clase EntradaMercanciaController

public class EntradaMercanciaController implements Initializable{

  private Almacen almacen = AlmacenFx.getAlmacen();
  
  int unidades;
  int stockMin;


  // Definimos los espacios de nombre correspondientes a cada nodo que vamos a utilizar en esta clase
  @FXML
  private Spinner<Integer> spinnerEntrada;
  @FXML
  private TextField codigoEntrada;
  @FXML 
  private Button btnCancelar;
  @FXML
  private ComboBox<String> tipoIvaEntrada;
  @FXML
  private TextField descripcionEntrada;
  @FXML
  private TextField compraEntrada;
  @FXML
  private TextField ventaEntrada;
  @FXML
  private Spinner<Integer> spinnerStockMin;
  @FXML 
  private ImageView imagen;
  @FXML 
  private Button elegirImagen;

  private int codigo;
  
  /**
   * Método initializable
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // Para que el spinner no pueda recoger caracteres
    
    spinnerEntrada.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
      if (! esNumerico(newValue)) {
        spinnerEntrada.getEditor().setText(oldValue);
      }
    });
  }
  
  /**
   * Método para evitar que introduzcamos una cadena en el Spinner
   * @param cadena
   * @return
   */
  private static boolean esNumerico(String cadena) {
    return Pattern.matches("^[1-9][0-9]*$", cadena);
  }
  
  
  /**
   * Método modificar para que al introducir una cantidad de unidades estas se sumen a las que ya tenia el artículo
   * @param event
   * @throws IOException
   * @throws UnidadesNegativasErrorExcepcion 
   * @throws CodigoArticuloNoExisteExcepcion 
   */
  @FXML
  public void modificar(ActionEvent event) throws IOException, CodigoArticuloNoExisteExcepcion, UnidadesNegativasErrorExcepcion {
    pedidoAutomatico(unidades, stockMin); 
    
    // Creamos un fichero que nos diga la cantidad de unidades que tenemos y su correspondiente codigo cuando se prudece la entrada de mercancía 
    BufferedWriter fichero = null;
    FileWriter fw = null;
    try {
      File file = new File("Entrada_Mercancia.txt");
      if(file.exists()) {
        int unidades = (spinnerEntrada.getValue()) - almacen.get(codigo).getNumUnidades();
        almacen.incremetaMercancia(codigo, unidades);
        fw = new FileWriter(file.getAbsoluteFile(), true);
        fichero = new BufferedWriter(fw);
        fichero.newLine();
        Date fecha = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        fichero.write("Código:\t" + String.valueOf(codigo) + "\tNúmero de unidades decrementadas: " + String.valueOf(unidades) +"\tFecha:\t" +formatter.format(fecha));
      }else {    
          int unidades = (spinnerEntrada.getValue()) - almacen.get(codigo).getNumUnidades();
          almacen.incremetaMercancia(codigo, unidades);
          fw = new FileWriter(file.getAbsoluteFile(), true);
          fichero = new BufferedWriter(fw);
          fichero.write("Fichero histórico con la información de la entrada de mercancía de GESTISIMAL");
          fichero.newLine();
          Date fecha = new Date();
          SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
          fichero.write("Código:\t" + String.valueOf(codigo) + "\tNúmero de unidades decrementadas: " + String.valueOf(unidades) +"\tFecha:\t" + formatter.format(fecha));        
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
      alert.setHeaderText("Error al incrementar las unidades del artículo");
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
   * Método cancelar para cerrar la ventana y no efectuar cambios en la apliación
   * @param event
   */

  @FXML
  public void cancelar(ActionEvent event) {
    Stage stage =  (Stage) btnCancelar.getScene().getWindow();
    stage.close();

  }
  
  /**
   * Método para mostrar la información de cada artículo en su correspondiente casilla
   * @param codigo
   */
  public void set(int codigo) {
    this.codigo = codigo;
    try {
      descripcionEntrada.setText(almacen.get(this.codigo).getDescripcion());
      compraEntrada.setText(almacen.get(this.codigo).getPrecioCompra() + " ");
      ventaEntrada.setText(almacen.get(this.codigo).getPrecioVenta() + " ");
      
      SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(almacen.get(this.codigo).getNumUnidades(), 1000, 1);
      spinnerEntrada.setValueFactory(spinnerValueFactory);
      
      SpinnerValueFactory<Integer> spinnerStockMinimo = new SpinnerValueFactory.IntegerSpinnerValueFactory(almacen.get(this.codigo).getStockMin(),almacen.get(this.codigo).getStockMin(),almacen.get(this.codigo).getStockMin());
      spinnerStockMin.setValueFactory(spinnerStockMinimo);
      
      tipoIvaEntrada.getItems().addAll(almacen.get(this.codigo).getTipoDeIva().toString());
      tipoIvaEntrada.getSelectionModel().select(0);
        

    } catch (CodigoArticuloNoExisteExcepcion e) {
      e.getMessage();
    }
  }
  
  /**
   * Método para realizar el pedidi automático
   * @param unidades
   * @param stockMin
   * @throws CodigoArticuloNoExisteExcepcion
   * @throws UnidadesNegativasErrorExcepcion
   */
  private void pedidoAutomatico(int unidades, int stockMin) throws CodigoArticuloNoExisteExcepcion, UnidadesNegativasErrorExcepcion {
    if (unidades < stockMin) {
      Alert alert = new Alert(AlertType.INFORMATION );
      alert.setTitle("¡Atención!");
      alert.setHeaderText("Error al modificar el artículo");
      alert.setContentText("Se ha realizado un pedido automatico debido que el número de unidades es inferior que el stock mínimo");
      alert.setResizable(true);
      alert.getDialogPane().setPrefSize(400, 200);
      alert.showAndWait();
      almacen.incremetaMercancia(codigo, (stockMin-unidades));
    }
  }
}
