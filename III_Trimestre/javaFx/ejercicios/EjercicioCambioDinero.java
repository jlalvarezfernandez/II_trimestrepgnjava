package ejercicios;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EjercicioCambioDinero extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
	  primaryStage.setTitle("Cambio ideal " + getClass().getSimpleName());
	  FXMLLoader fxml = new FXMLLoader(getClass().getResource("../vistasEjercicios/VistaEjercicioCalcularCambio.fxml"));
	  GridPane root = fxml.<GridPane>load(); 
    primaryStage.setScene(new Scene(root));
    primaryStage.show(); 
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
