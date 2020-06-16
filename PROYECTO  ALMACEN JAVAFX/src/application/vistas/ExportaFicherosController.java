/**
 * Controlador dedicado a exportar los artículos del almacén a un fichero en los siguientes formatos:
 *   - CSV
 *   - XML
 *   - JSON
 * 
 * @author JOSÉ LUIS ÁLVAREZ FÉRNANDEZ
 * @author FRANCISCO JAVIER CAMPOS GUTIÉRREZ
 * @author ANTONIO QUESADA CUADRADO
 */

package application.vistas;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.AlmacenFx;
import application.gestisimal.Almacen;
import application.gestisimal.CSVExcepcion;
import application.gestisimal.JSONException;
import application.gestisimal.XMLExcepcion;
import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

// Creación clase ExportaFicherosController

public class ExportaFicherosController implements Initializable {

  private Almacen almacen = AlmacenFx.getAlmacen();

  // definimos las variables que vamos a necesitar
  String archivo;
  String linea;
  boolean extensionCsv;
  boolean extensionJson;
  boolean extensionXml;

  // Definimos los espacios de nombre correspondientes a cada nodo que vamos a utilizar en esta clase
  @FXML
  private RadioButton csv;
  @FXML
  private RadioButton json;
  @FXML
  private RadioButton xml;
  @FXML
  private ToggleGroup toggleGroup;
  @FXML
  private TextArea mostrarInformacion;
  @FXML
  private Button btnCancelar;

  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }

  /**
   * Método mostrarCSV para que al elegir el formato csv se exporte la información del almacén al text Area y el usuario eliga 
   * la información de los artiículos que quiera exportar
   * 
   * @param event
   * @throws CSVExcepcion 
   * @throws IOException
   */

  @FXML
  public void mostrarCSV(ActionEvent e) throws CSVExcepcion, IOException {

    if (csv.isSelected()) {
      leeCSV(extensionCsv);
    } 
  }

  /**
   * Método mostrarJSON para que al elegir el formato json se exporte la información del almacén al text Area y el usuario eliga 
   * la información de los artiículos que quiera exportar
   * @param e
   * @throws JSONException
   * @throws IOException
   */
  public void mostrarJSON(ActionEvent e) throws JSONException, IOException {

    if (json.isSelected()) {
      leeJSON(extensionJson);
    }
  }

  /**
   * Método mostrarXML para que al elegir el formato xml se exporte la información del almacén al text Area y el usuario eliga 
   * la información de los artiículos que quiera exportar
   * @param e
   * @throws IOException
   * @throws XMLExcepcion
   */

  public void mostrarXML(ActionEvent e) throws IOException, XMLExcepcion {

    if (xml.isSelected()) {
      leeXML(extensionXml);
    }
  }

  /**
   * Método para salir al pulsar el botón cancelar
   * @param e
   */
  public void cancelar (ActionEvent e) {
    Stage stage =  (Stage) btnCancelar.getScene().getWindow();
    stage.close();
  }

  /**
   * Método exporta para que al elegir la extesión correspondiente exporte el fichero a donde nosotros eligamos
   * @param e
   * @throws IOException
   * @throws CSVExcepcion
   * @throws JSONException
   * @throws XMLExcepcion
   */

  public void exporta(ActionEvent e) throws IOException, CSVExcepcion, JSONException, XMLExcepcion {

    Window stage = null;
    try {
      if (extensionCsv) {
        FileChooser file2 = new FileChooser();

        extensionCsv = file2.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv"));

        File f = file2.showSaveDialog(stage);
        BufferedWriter fichero2 = new BufferedWriter(new FileWriter(f.getAbsolutePath()));
        fichero2.write(mostrarInformacion.getText());
        almacen.exportaCSV("exporta.csv");
        fichero2.close();

      } else if (extensionJson) {
        FileChooser file2 = new FileChooser();

        extensionJson = file2.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.json"));
        File f = file2.showSaveDialog(stage);
        BufferedWriter fichero2 = new BufferedWriter(new FileWriter(f.getAbsolutePath()));
        fichero2.write(mostrarInformacion.getText());
        almacen.exportaJSON("exporta.json");
        fichero2.close();

      } else if (extensionXml){

        FileChooser file2 = new FileChooser();

        extensionXml = file2.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.xml"));
        File f = file2.showSaveDialog(stage);
        BufferedWriter fichero2 = new BufferedWriter(new FileWriter(f.getAbsolutePath()));
        fichero2.write(mostrarInformacion.getText());
        almacen.exportaXML("exporta.xml");
        fichero2.close();

      } else if (!(extensionCsv || extensionJson || extensionXml)){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error en el programa!!!!");
        alert.setHeaderText("No se ha podido exportar el archivo");
        alert.setContentText("Introduce una extensión correctamente");
        alert.setResizable(true);
        alert.getDialogPane().setPrefSize(400, 200);
        alert.showAndWait();
      } 
    } catch (Exception e2) {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Error en el programa!!!!");
      alert.setHeaderText("No se ha podido exportar el archivo");
      alert.setContentText("Operación cancelada");
      alert.setResizable(true);
      alert.getDialogPane().setPrefSize(400, 200);
      Label etiqueta = new Label("La excepcion trazada fue: ");
      TextArea texto = new TextArea("Has cerrado la ventana antes de tiempo");
      texto.setEditable(false);
      GridPane exc = new GridPane();
      exc.add(etiqueta, 0, 0);
      exc.add(texto, 0, 1);
      alert.getDialogPane().setExpandableContent(exc);
      alert.showAndWait();
    }

    Stage stage2 =  (Stage) btnCancelar.getScene().getWindow();
    stage2.close();
  }


  /**
   * Método leeCSV para leer un fichero en formato CSV la información del fichero 
   * @param extension
   * @throws CSVExcepcion 
   * @throws IOException 
   */
  public void leeCSV(boolean extension) throws CSVExcepcion, IOException {
    FileChooser file2 = new FileChooser();

    extensionCsv = file2.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv"));

    if (extensionCsv) {
      mostrarInformacion.setText("");
      almacen.exportaCSV("exporta.csv");

      BufferedReader fichero1 = new BufferedReader(new FileReader("exporta.csv"));

      String linea;
      while ((linea = fichero1.readLine()) != null) {
        mostrarInformacion.setText(mostrarInformacion.getText() + linea + "\n");
      }
      fichero1.close();
    }
  }

  /**
   * Método leeJSON para leer un fichero en formato json la información del fichero 
   * @param extension
   * @throws JSONException 
   * @throws IOException 
   */

  public void leeJSON(boolean extension) throws JSONException, IOException {
    FileChooser file2 = new FileChooser();
    extensionJson = file2.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.json"));

    if (extensionJson) {
      mostrarInformacion.setText("");
      almacen.exportaJSON("exporta.json");

      BufferedReader fichero1 = new BufferedReader(new FileReader("exporta.json"));

      String linea;
      while ((linea = fichero1.readLine()) != null) {
        mostrarInformacion.setText(mostrarInformacion.getText() + linea + "\n");
      }
      fichero1.close();
    }
  }

  /**
   * Método leeXML para leer un fichero en formato xml la información del fichero 
   * @param extension
   * @throws IOException 
   * @throws XMLExcepcion 
   */

  public void leeXML(boolean extension) throws IOException, XMLExcepcion {
    FileChooser file2 = new FileChooser();
    extensionXml = file2.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.xml"));

    if (extensionXml) {
      mostrarInformacion.setText("");
      almacen.exportaXML("exporta.xml");

      BufferedReader fichero1 = new BufferedReader(new FileReader("exporta.xml"));

      String linea;
      while ((linea = fichero1.readLine()) != null) {
        mostrarInformacion.setText(mostrarInformacion.getText() + linea + "\n");
      }
      fichero1.close();
    }
  }
}
