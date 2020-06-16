/**
 * Controlador dedicado a mostrar la información de contacto de Antonio Cuadrado
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

// Crecion de la clase GitHubAntonioController

public class GitHubAntonioController implements Initializable{
  
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
   String direccion = "https://github.com/antonioqc";
     irGit.getEngine().load(direccion);
   }
 
 /**
  * Método para mostrar la información de contacto en Twitter
  * @param event
  */
 
 public void twitter(ActionEvent event) {
   String direccion = "https://twitter.com/antonioq00";
     irGit.getEngine().load(direccion);
   }
 
 /**
  * Método para mostrar la información de contacto en Linkedin
  * @param event
  */
 
 public void linkedin(ActionEvent event) {
   String direccion = "https://www.linkedin.com/in/jose-luis-alvarez-3ab78758/";
     irGit.getEngine().load(direccion);
   }
}

