/**
 * Controlador dedicado a pedir un código de un artículo para darlo de baja del almacén
 * 
 * @author JOSÉ LUIS ÁLVAREZ FÉRNANDEZ
 * @author FRANCISCO JAVIER CAMPOS GUTIÉRREZ
 * @author ANTONIO QUESADA CUADRADO
 */

package application.vistas;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import application.AlmacenFx;
import application.gestisimal.Almacen;
import application.gestisimal.CodigoArticuloNoExisteExcepcion;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

// Creación Clase CodigoArticuloBajaController

public class CodigoArticuloBajaController implements Initializable{

  private Almacen almacen = AlmacenFx.getAlmacen();

  // Definimos los espacios de nombre correspondientes a cada nodo que vamos a utilizar en esta clase
  @FXML
  private TextField codigoArticulo;
  @FXML 
  private Button btnCancelar;


  @Override
  public void initialize(URL location, ResourceBundle resources) {
    
  }

  /**
   * Creación del método aceptar para poder borrar un artículo que hay en el almacén
   * @param e
   * @throws CodigoArticuloNoExisteExcepcion 
   */

  public void aceptar (ActionEvent e)   {
    try {
      
      int codigo = Integer.parseInt(codigoArticulo.getText());
      // si el código introducido no existe lanzamos alert
      if(!almacen.baja(codigo)) {

        Alert alert = new Alert(AlertType.ERROR );
        alert.setTitle("¡Error en el programa!");
        alert.setHeaderText("Error al dar de baja un artículo del almacén");
        alert.setContentText("Introduce un código correcto");
        alert.setResizable(true);
        alert.getDialogPane().setPrefSize(400, 200);
        Label etiqueta = new Label ("La excepcion lanzada fue: ");
        TextArea texto = new TextArea("El código no existe");
        texto.setEditable(false);
        GridPane excep = new GridPane();
        excep.add(etiqueta,0,0);
        excep.add(texto,0,1);
        alert.getDialogPane().setExpandableContent(excep);
        alert.showAndWait();
        
      } else {
        almacen.baja(codigo); // si existe el código, se borrará de la lista de rtículos del almacén
      }
    } catch (NullPointerException|NumberFormatException | CodigoArticuloNoExisteExcepcion exc) {
      // si no introducimos ningún codigo salta este alert
      Alert alert = new Alert(AlertType.ERROR );
      alert.setTitle("¡Error en el programa!");
      alert.setHeaderText("Error al dar de baja un artículo del almacén");
      alert.setContentText("Introduce un código correcto");
      alert.setResizable(true);
      alert.getDialogPane().setPrefSize(400, 200);
      
      alert.showAndWait();
     
    }
    // Asi cerramos la ventana al efectuar los cambios
    Stage stage =  (Stage) btnCancelar.getScene().getWindow();
    stage.close();
  }

  /**
   * Creación del método cancelar para cancelar el dar de baja un artículo al almacén.  
   * @param e
   */

  public void cancelar (ActionEvent e) {
    Stage stage =  (Stage) btnCancelar.getScene().getWindow();
    stage.close();
  }
}







