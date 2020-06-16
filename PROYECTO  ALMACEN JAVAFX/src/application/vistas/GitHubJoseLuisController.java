/**
 * Controlador dedicado a mostrar la información de contacto de José Luis Álvarez
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

//Creación de la clase GitHubJoseLuisController

public class GitHubJoseLuisController implements Initializable{
  
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
   String direccion = "https://github.com/jlalvarezfernandez";
     irGit.getEngine().load(direccion);
   }
 
 /**
  * Método para mostrar la información de contacto en Twitter
  * @param event
  */
 
 public void twitter(ActionEvent event) {
   String direccion = "https://twitter.com/Jose_Luis84";
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

