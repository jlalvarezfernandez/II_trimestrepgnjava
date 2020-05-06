package ejercicios;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EjercicioContadorPalabras extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {
    primaryStage.setTitle("EJERCICIO CONTADOR PALABRAS" + this.getClass().getSimpleName());
    primaryStage.setResizable(false);
    FXMLLoader fxml = new FXMLLoader(this.getClass().getResource("../vistasEjercicios/VistaEjercicioContadorPalabras.fxml"));
    GridPane root = fxml.<GridPane>load();
    primaryStage.setScene(new Scene(root));
    primaryStage.show();


  }

  public static void main(String[] args) {
    launch(args);
  }
}
