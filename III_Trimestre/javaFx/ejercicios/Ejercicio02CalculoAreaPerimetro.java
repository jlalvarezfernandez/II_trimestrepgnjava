package ejercicios;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 2. Calcular el perí­metro y área de un rectángulo dada su base y su altura.
 * 
 * Componentes gráficos:
 *    Etiquetas.
 *    Cajas de texto para base y altura.
 *    Botón para calcular.
 *    Caja de texto resultado.
 *    
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */


public class Ejercicio02CalculoAreaPerimetro  extends  Application{
  

  int altura;
  
  @Override
    public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Calcular perímetro y área " + getClass().getSimpleName());
    primaryStage.show();
    
    
    Label etiqueta = new Label("Calculo perímetro y área: ");
    etiqueta.setFont(new Font("Arial", 30));
    Label pideBase = new Label("Introduce la base del rectangulo: ");
    TextField baseCampo = new TextField(" "); 
    Label pidealtura = new Label("Introduce la altura del rectangulo: ");
    TextField alturaCampo = new TextField();
    Button boton = new Button("Calcular");
    
    Label resultadoPerimetro = new Label("Resultado Perímetro: ");
    
    Label resultadoArea = new Label("Resultado Área: ");
    TextField muestraResultadoPerimetro = new TextField(" ");
    TextField muestraResultadoArea = new TextField(" ");


    GridPane gp = new GridPane();
    gp.setAlignment(Pos.CENTER);
    // introducimos la separacion horizontal y vertical entre las filas y columnas
    gp.setHgap(10);
    gp.setVgap(10);
    // introducimos unos margenes con padding
    gp.setPadding(new Insets(10,10,10,10));
    gp.add(etiqueta, 0, 0);
    gp.add(pideBase, 0, 1);
    gp.add(baseCampo, 1, 1);
    gp.add(pidealtura, 0, 3);
    gp.add(alturaCampo, 1, 3);
    gp.add(boton, 0, 4);
    gp.add(resultadoPerimetro, 0, 5);
    gp.add(muestraResultadoPerimetro, 1,5);
    gp.add(resultadoArea, 0, 6);
    gp.add(muestraResultadoArea, 1,6);
    Scene scene = new Scene(gp);
    
    // añadimos el boton setOnAction a un evento para cuando lo pulsemos haga una acción y lo metemos en un envoltorio ActionEvent
    
    boton.setOnAction(new EventHandler<ActionEvent>() {
      
      @Override
      // sobreescribimos el método handle que recibe ActionEvent
      public void handle(ActionEvent event) {
        try {
          
          double base =Double.parseDouble(baseCampo.getText());
          double altura = Double.parseDouble(alturaCampo.getText());
          
          double perimetro = (base+ altura) *2;
          muestraResultadoPerimetro.setText(perimetro + "");
          double area = base * altura;
          muestraResultadoArea.setText(area + "");
          
        } catch (NumberFormatException e) {
          muestraResultadoArea.setText("Debe Introducir un número");
          Alert alert = new Alert(AlertType.INFORMATION);
          alert.setTitle("Error");
          alert.setHeaderText("Tipo de dato incorrecto");
          alert.setContentText("Introduce un número");
          alert.showAndWait();
          
          muestraResultadoPerimetro.setText("Debe Introducir un número");
          Alert alert1 = new Alert(AlertType.INFORMATION);
          alert1.setTitle("Error");
          alert1.setHeaderText("Tipo de dato incorrecto");
          alert1.setContentText("Introduce un número");
          alert1.showAndWait();
          
        }

 
      }
    });
    
    primaryStage.setScene(scene);

    }
  
  
  public static void main(String[] args) {
    
    launch(args);
    
  }

}


