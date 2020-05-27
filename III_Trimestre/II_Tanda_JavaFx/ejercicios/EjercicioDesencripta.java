package ejercicios;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EjercicioDesencripta extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
	  primaryStage.setTitle("DESENCRIPTA FICHEROS");
	  Parent root = FXMLLoader.load(getClass().getResource("../vistasEjercicios/VistaEjercicioDesencripta.fxml"));
    Scene escena = new Scene(root);                       
    primaryStage.setScene(escena);
    primaryStage.show(); 
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
