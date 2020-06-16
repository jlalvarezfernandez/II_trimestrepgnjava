/**
 * Creación de la clase AlmacenFX, primer escenario de la aplicación de GESTISIMAL.
 * Aqui aparecerá el menu con las diferentes opciones y navegación sobre nuestra App.
 * 
 * @author JOSÉ LUIS ÁLVAREZ FÉRNANDEZ
 * @author FRANCISCO JAVIER CAMPOS GUTIÉRREZ
 * @author ANTONIO QUESADA CUADRADO
 */

package application;
import java.io.IOException;

import application.gestisimal.Almacen;
import application.gestisimal.CampoVacioException;
import application.gestisimal.IvaInvalidoExcepcion;
import application.gestisimal.PrecioIncorrecto;
import application.gestisimal.PrecioNegativoErrorExcepcion;
import application.gestisimal.TipoIva;
import application.gestisimal.UnidadesNegativasErrorExcepcion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Creación del escenario principal

public class AlmacenFx extends Application {
  
  static private Almacen almacen = new Almacen();
  
	@Override
	public void start(Stage primaryStage) throws IOException {
	  primaryStage.setTitle("GESTISIMAL");
	  Parent root = FXMLLoader.load(getClass().getResource("/application/vistas/AlmacenGestisimal.fxml"));
	  Scene escena = new Scene(root, 575, 480);
	  primaryStage.setScene(escena);
	  primaryStage.show();
	  primaryStage.setResizable(false);
	}
	
	public void init() throws UnidadesNegativasErrorExcepcion, PrecioNegativoErrorExcepcion, IvaInvalidoExcepcion, CampoVacioException, PrecioIncorrecto {
	  
	  // Creamos unos artículos para que nuestro almacén no este vacio por defecto al iniciar la aplicación
	  almacen.annade("Ratón Gamming",10,25,400,TipoIva.GENERAL, 200);
    almacen.annade("Teclado",15,35,25,TipoIva.REDUCIDO,150);
    almacen.annade("Cable USB",1,5,850,TipoIva.SUPERREDUCIDO,400);
    almacen.annade("Monitor LCD",120,450,8,TipoIva.GENERAL,10);
    almacen.annade("Calculadora científica",10,20,50,TipoIva.GENERAL,60);
    almacen.annade("Memoria usb",5,25,600,TipoIva.GENERAL,199);
    almacen.annade("Impresora laser",100,250,25,TipoIva.GENERAL,10);
    almacen.annade("Ordenador portatil",850,999,12,TipoIva.GENERAL,15);


	}
	
	public static void main(String[] args) {
		launch(args);
	}

  public static Almacen getAlmacen() {
    return almacen;
  }
}



