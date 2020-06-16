/**
 * Controlador dedicado a mostrar la información de contacto de Franciso Javier Gutierrez
 * 
 * @author JOSÉ LUIS ÁLVAREZ FÉRNANDEZ
 * @author FRANCISCO JAVIER CAMPOS GUTIÉRREZ
 * @author ANTONIO QUESADA CUADRADO
 */

package application.vistas;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.web.WebView;

//Crecion de la clase GitHubCurroController

public class GitHubCurroController implements Initializable{
  
  // Definimos los espacios de nombre correspondientes a cada nodo que vamos a utilizar en esta clase
  @FXML
  private WebView irGit;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    
  }
  
  /**
   * Método para mostrar la información de contacto en Github
   * @param event
   */
  
 public void masInfo(ActionEvent event) {
   String direccion = "https://github.com/front440";
     irGit.getEngine().load(direccion);
   }
 
 /**
  * Método para mostrar la información de contacto en Twitter
  * @param event
  */
 
 public void twitter(ActionEvent event) {
   String direccion = "https://twitter.com/fcampos_98";
     irGit.getEngine().load(direccion);
   }
 
 /**
  * Método para mostrar la información de contacto en Linkedin
  * @param event
  */
 
 public void linkedin(ActionEvent event) {
   String direccion = "https://www.linkedin.com/in/francisco-javier-campos-gutierrez-424345187/";
     irGit.getEngine().load(direccion);
   }
}

