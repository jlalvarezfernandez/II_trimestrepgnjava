/**
 * Creación de la clase IrRepositorioCOntroller donde se mostrará el enlace de github donde se encuetra el código de esta aplicación
 * 
 * @author JOSÉ LUIS ÁLVAREZ FÉRNANDEZ
 * @author FRANCISCO JAVIER CAMPOS GUTIÉRREZ
 * @author ANTONIO QUESADA CUADRADO
 */

package application.vistas;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

// Creación clase IrRepositorioController

public class IrRepositorioController implements Initializable{

  @FXML
  private WebView navegador;

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    String direccion = "https://github.com/jlalvarezfernandez/PGN_JAVA/tree/master/PROYECTO%20%20ALMACEN%20JAVAFX/src/application";
    navegador.getEngine().load(direccion);
  }
}








