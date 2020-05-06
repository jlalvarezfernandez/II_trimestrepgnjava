package ejercicios;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EjercicioPrimos extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
	  
	  primaryStage.setTitle("Cálculo números primos " +getClass().getSimpleName());
	  // la ventana no puede hacerse mas grande
	  primaryStage.setResizable(false);
	  FXMLLoader fxml = new FXMLLoader(this.getClass().getResource("../vistasEjercicios/VistaEjercicioNumerosPrimos.fxml"));
	  GridPane root = fxml.<GridPane>load(); 
	  
	  FileInputStream input = new FileInputStream("C:/Users/AJFRU/Desktop/cosas/foto.png");
    Image imagen = new Image(input);
    ImageView imageView = new ImageView(imagen);
    
    
	  primaryStage.setScene(new Scene(root));
	  primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
