
package ejercicios;

/**
 * 
 * Programa para calcular:
 *        media
 *        número máximo
 *        número mínimo
 *        varianza
 * de 10 notas introducidas por el usuario
 * 
 * @author José Luis Álvarez Fernández
 */

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EjercicioCalcularMediaVarianzaMinimoMaximo extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
	  primaryStage.setTitle("CALCULO VALORES " + getClass().getSimpleName());
	  FXMLLoader fxml = new FXMLLoader(this.getClass().getResource("../vistasEjercicios/VistaEjercicioMediaVarianzaMinimoMaximo.fxml"));
	  GridPane root = fxml.<GridPane>load(); 
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
