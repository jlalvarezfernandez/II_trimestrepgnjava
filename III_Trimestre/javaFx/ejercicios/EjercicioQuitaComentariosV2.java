package ejercicios;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EjercicioQuitaComentariosV2 extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
	  primaryStage.setResizable(true);
	  primaryStage.setTitle("QUITA COMENTARIOS");
    FXMLLoader fxml = new FXMLLoader(this.getClass().getResource("../vistasEjercicios/VistaEjercicioQuitaComentarios.fxml"));
    GridPane root = fxml.<GridPane>load(); 
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
