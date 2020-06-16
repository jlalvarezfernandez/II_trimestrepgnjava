/**
 * Controlador dedicado a importar los artículos del alacen a un fichero en los siguientes formatos:
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
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import application.AlmacenFx;
import application.gestisimal.Almacen;
import application.gestisimal.CSVExcepcion;
import application.gestisimal.CampoVacioException;
import application.gestisimal.IvaInvalidoExcepcion;
import application.gestisimal.JSONException;
import application.gestisimal.PrecioIncorrecto;
import application.gestisimal.PrecioNegativoErrorExcepcion;
import application.gestisimal.UnidadesNegativasErrorExcepcion;
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


//Creación clase ImportaFicherosController

public class ImportaFicherosController implements Initializable{


  // definimos las variables que vamos a necesitar
  String linea;
  boolean extensionCsv;
  boolean extensionJson;
  boolean extensionXml;
  File f;
  File file = new File("Artículos.txt");

  // Definimos los espacios de nombre correspondientes a cada nodo que vamos a utilizar en esta clase
  @FXML
  private RadioButton csv;
  @FXML
  private RadioButton json;
  @FXML
  private RadioButton xml;
  @FXML
  private TextArea mostrarInformacion;
  @FXML
  private ToggleGroup toggleGroup;
  @FXML
  private Button btnCancelar;

  private Almacen almacen = AlmacenFx.getAlmacen();


  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }

  /**
   * Método importa para que al elegir un fichero en formato CSV se carge la información correspondiente
   * @param e
   * @throws IOException
   * @throws CSVExcepcion
   * @throws NumberFormatException
   * @throws UnidadesNegativasErrorExcepcion
   * @throws PrecioNegativoErrorExcepcion
   * @throws IvaInvalidoExcepcion
   */

  public void cargaCSV (ActionEvent e) throws IOException, CSVExcepcion, NumberFormatException, UnidadesNegativasErrorExcepcion, PrecioNegativoErrorExcepcion, IvaInvalidoExcepcion, InvocationTargetException {
    FileChooser file2 = new FileChooser();
    extensionCsv = file2.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv"));
    Window stage = null;
    try {
      if (extensionCsv) {
        mostrarInformacion.setText("");
        f = file2.showOpenDialog(stage);
        BufferedReader fichero2 = new BufferedReader(new FileReader(f));
        linea = fichero2.readLine();
        while (linea != null) {
          mostrarInformacion.setText(mostrarInformacion.getText()+ linea+ "\n");
          linea = fichero2.readLine();
        }
        fichero2.close();

      }    
      
    } catch (NullPointerException e2) {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Error en el programa!!!!");
      alert.setHeaderText("No se ha podido importar el archivo");
      alert.setResizable(true);
      alert.getDialogPane().setPrefSize(400, 200);
    }
    
  }

  /**
   * Método importa para que al elegir un fichero en formato Json se carge la información correspondiente
   * @param e
   * @throws IOException
   * @throws JSONException
   * @throws ArrayIndexOutOfBoundsException
   */
  public void cargaJSON (ActionEvent e) throws IOException, JSONException, ArrayIndexOutOfBoundsException, InvocationTargetException {
    FileChooser file2 = new FileChooser();
    extensionJson = file2.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.json"));
    Window stage = null;
    try {
      if (extensionJson) {
        mostrarInformacion.setText("");
        f = file2.showOpenDialog(stage);
        BufferedReader fichero2 = new BufferedReader(new FileReader(f));
        linea = fichero2.readLine();
        while (linea != null) {
          mostrarInformacion.setText(mostrarInformacion.getText()+ linea+ "\n");
          linea = fichero2.readLine();
        }
        fichero2.close();
      }
    } catch (NullPointerException e2) {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Error en el programa!!!!");
      alert.setHeaderText("No se ha podido importar el archivo");
      alert.setResizable(true);
      alert.getDialogPane().setPrefSize(400, 200);
    }
    
  }

  /**
   * Método importa para que al elegir un fichero en formato XML se carge la información correspondiente
   * @param e
   * @throws ParserConfigurationException
   * @throws IOException
   * @throws ArrayIndexOutOfBoundsException
   * @throws XMLExcepcion
   * @throws SAXException
   * @throws UnidadesNegativasErrorExcepcion
   * @throws PrecioNegativoErrorExcepcion
   * @throws IvaInvalidoExcepcion
   */
  public void cargaXML (ActionEvent e) throws ParserConfigurationException, IOException, ArrayIndexOutOfBoundsException, XMLExcepcion, SAXException, UnidadesNegativasErrorExcepcion, PrecioNegativoErrorExcepcion, IvaInvalidoExcepcion, InvocationTargetException{
    FileChooser file2 = new FileChooser();
    extensionXml = file2.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.xml"));
    Window stage = null;
    try {
      if (extensionXml) {
        mostrarInformacion.setText("");

        f = file2.showOpenDialog(stage);
        BufferedReader fichero2 = new BufferedReader(new FileReader(f));

        linea = fichero2.readLine();
        while (linea != null) {
          mostrarInformacion.setText(mostrarInformacion.getText()+ linea+ "\n");
          linea = fichero2.readLine();
        }
        fichero2.close();
      }
      
    } catch (NullPointerException e2) {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Error en el programa!!!!");
      alert.setHeaderText("No se ha podido importar el archivo");
      alert.setResizable(true);
      alert.getDialogPane().setPrefSize(400, 200);
    }
    
  }

  /**
   * Método cancelar para salir de la ventana
   * @param e
   */
  public void cancelar (ActionEvent e) {
    Stage stage =  (Stage) btnCancelar.getScene().getWindow();
    stage.close();
  }


  /**
   * Método para importar la información del textArea a la lista de artículos del almacén
   * @param event
   * @throws NullPointerException
   * @throws JSONException
   * @throws ParserConfigurationException
   * @throws IOException
   * @throws XMLExcepcion
   * @throws SAXException
   * @throws UnidadesNegativasErrorExcepcion
   * @throws PrecioNegativoErrorExcepcion
   * @throws IvaInvalidoExcepcion
   * @throws NumberFormatException
   * @throws CSVExcepcion
   * @throws CampoVacioException
   * @throws PrecioIncorrecto 
   */
  @FXML
  public void importa(ActionEvent event) throws  JSONException, ParserConfigurationException, IOException, XMLExcepcion, SAXException, UnidadesNegativasErrorExcepcion, PrecioNegativoErrorExcepcion, IvaInvalidoExcepcion, NumberFormatException, CSVExcepcion, CampoVacioException, PrecioIncorrecto {
    try {
      if (extensionJson) {
        BufferedWriter fichero3 = new BufferedWriter(new FileWriter(file));
        fichero3.write(mostrarInformacion.getText());
        fichero3.close();
        almacen.importaJSON(file.getAbsolutePath());
      } else if (extensionXml) {
        BufferedWriter fichero3 = new BufferedWriter(new FileWriter(file));
        fichero3.write(mostrarInformacion.getText());
        fichero3.close();
        almacen.importaXML(file.getAbsolutePath());
      } else if (extensionCsv) {
        BufferedWriter fichero3 = new BufferedWriter(new FileWriter(file));
        fichero3.write(mostrarInformacion.getText());
        fichero3.close();
        almacen.importarCSV(file.getAbsolutePath());
      } else if (!(extensionCsv || extensionJson || extensionXml)){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error en el programa!!!!");
        alert.setHeaderText("No se ha podido importar el archivo");
        alert.setContentText("Selecciona una extension correcta");
        alert.setResizable(true);
        alert.getDialogPane().setPrefSize(400, 200);
        Label etiqueta = new Label("La excepcion trazada fue: ");
        TextArea texto = new TextArea("Tienes que introducir un formato de fichero");
        texto.setEditable(false);
        GridPane exc = new GridPane();
        exc.add(etiqueta, 0, 0);
        exc.add(texto, 0, 1);
        alert.getDialogPane().setExpandableContent(exc);
        alert.showAndWait();
      }

      Stage stage =  (Stage) btnCancelar.getScene().getWindow();
      stage.close();

    } catch (NullPointerException | CSVExcepcion  e) {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Error en el programa!!!!");
      alert.setHeaderText("No se ha podido importar el archivo");
      alert.setResizable(true);
      alert.getDialogPane().setPrefSize(400, 200);

    }
  }
}

