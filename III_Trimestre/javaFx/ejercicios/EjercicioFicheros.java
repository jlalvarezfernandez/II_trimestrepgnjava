package ejercicios;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EjercicioFicheros extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
	  primaryStage.setTitle("MEZCLA FICHEROS" + getClass().getSimpleName());
		FXMLLoader fxml = new FXMLLoader(this.getClass().getResource("../vistasEjercicios/VistaEjercicioFicheros.fxml"));
		GridPane root = fxml.<GridPane>load();
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
