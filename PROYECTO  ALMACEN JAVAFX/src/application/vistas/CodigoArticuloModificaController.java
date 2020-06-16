/**
 * Controlador dedicado a pedir un código de un artículo para después poder modificarlo
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.AlmacenFx;
import application.gestisimal.Almacen;
import application.gestisimal.Articulo;
import application.gestisimal.CodigoArticuloNoExisteExcepcion;
import javafx.event.ActionEvent;

//Creación Clase CodigoArticuloModificaController

public class CodigoArticuloModificaController implements Initializable{

  // Definimos los espacios de nombre correspondientes a cada nodo que vamos a utilizar en esta clase
  @FXML
  private Button btnCancelar;
  @FXML
  private TextField codigoArticulo;

  private Almacen almacen = AlmacenFx.getAlmacen();

  private int codigo;


 

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    
  }
  
  /**
   * Método para poder saber si existe un código de un artículo en nuestro almacén
   * @param codigo
   * @return
   * @throws CodigoArticuloNoExisteExcepcion
   */
  public boolean existe(int codigo) throws CodigoArticuloNoExisteExcepcion {

    ArrayList<Articulo> almacen2 = new ArrayList<Articulo>();
    almacen.exporta(almacen2);
    
      if (!almacen2.contains(almacen.get(codigo))) {
        return false;
      }  
    return true;
  }

  /**
   * Método aceptar para que al introducir un código correcto nos lleve a la ventana para poder modificar un artículo del almacén
   * @param event
   * @throws IOException
   */
  @FXML
  public void aceptar(ActionEvent event) throws IOException, CodigoArticuloNoExisteExcepcion {
    Parent root;
      try {
        codigo = Integer.parseInt(codigoArticulo.getText());
        if (existe(codigo)) { 
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/vistas/ModificaArticulo.fxml"));
        root = fxmlLoader.load();

        ModificaArticuloController controller = fxmlLoader.getController();
        controller.set(codigo);

        Scene escena = new Scene(root);
        Stage escenario = new Stage();
        escenario.setTitle("Sección dedicada a modificar artículos del almacén");
        escenario.initModality(Modality.APPLICATION_MODAL);
        escenario.setResizable(false);
        escenario.setScene(escena);
        escenario.showAndWait();
        escenario.close();
      }
      // cerramos el stage una vez hayamos introducido un código correcto
      Stage stage =  (Stage) btnCancelar.getScene().getWindow();
      stage.close();

        
      } catch (NumberFormatException | CodigoArticuloNoExisteExcepcion e) {
        Alert alert = new Alert(AlertType.ERROR );
        alert.setTitle("¡Error en el programa!");
        alert.setHeaderText("Error al intentar acceder al artículo");
        alert.setContentText("Introduce un código correcto");
        alert.setResizable(true);
        alert.getDialogPane().setPrefSize(400, 200);
        Label etiqueta = new Label ("La excepcion lanzada fue: ");
        TextArea texto = new TextArea("campo vacio o código inexistente");
        texto.setEditable(false);
        GridPane excep = new GridPane();
        excep.add(etiqueta,0,0);
        excep.add(texto,0,1);
        alert.getDialogPane().setExpandableContent(excep);
        alert.showAndWait();
      }
  }


  /**
   * Método cancelar para cerrar la ventana y salir de la vista
   * @param event
   */

  @FXML
  public void cancelar(ActionEvent event) {
    Stage stage =  (Stage) btnCancelar.getScene().getWindow();
    stage.close();
  }
}
