package controladoresEjercicios;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ControladorEjercicioMediaVarianzaMinimoMaximo implements Initializable{
  //static final int NUMERO_NOTAS = 10;

  
  @FXML
  private TextField numeros;
  
  @FXML
  private TextField min;
  
  @FXML
  private TextField max;
  
  @FXML
  private TextField media;
  
  @FXML
  private TextField var;
  


  @Override
  public void initialize(URL location, ResourceBundle resources) {
    
    
  }

  public void calcular(ActionEvent e) {
    
    try {
      min.clear();
      max.clear();
      var.clear();
      media.clear();
      
      
      double suma = 0;
      double maximo = Integer.MIN_VALUE;
      double minimo = Integer.MAX_VALUE;
      double varianza = 0;
      
      // creamos una variable donde vamos a guardar todos los numeros introducidos en el textField numeros
      String numero = numeros.getText();
   
      
      // creamos un array de cadena  donde guardamos los numeros introducidos anteriormente
      // ademas cambiamos los posibles espacios en blanco por comas para separar cada nuemro
      String notas [] = numero.replace(" ", "").split(",");
      
      // creamos otro array de numeros reales donde guardamos el array de los numeros anteriores
      double[] prueba = new double[notas.length];
      

      for (int i = 0 ; i< notas.length;i++) {
        
        // pasamos el array de cadena a números reales
        prueba[i] = Double.parseDouble(notas[i]);
        if (prueba[i] < 0 || prueba[i] > 10) {
          Alert alert = new Alert(AlertType.ERROR);
          alert.setTitle("Error en el programa");
          alert.setHeaderText("Número incorrecto");
          alert.setContentText("Introduce un número mayor que 0 y menor que 10");
          alert.showAndWait();
          System.exit(3);
          numeros.clear();
        }

        suma += prueba[i];
        if (prueba[i] > maximo) {
          maximo = prueba[i];
        }
        if (prueba[i] < minimo) {
          minimo = prueba[i];
        } 

      }

      // Calculamos varianza
      double sumaVarianza = 0;
      for (int j=0; j<notas.length; j++) {

        sumaVarianza += Math.pow(prueba[j]-(suma/notas.length), 2);
      }
      varianza = sumaVarianza/notas.length;
      
      min.setText(min.getText() + "" + minimo);
      max.setText(max.getText() + "" + maximo);
      var.setText(var.getText() + "" + varianza);
      media.setText(media.getText() + "" + suma/notas.length);

      
    } catch (NumberFormatException ex) {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Error en el programa!!!!");
      alert.setHeaderText("Tipo de dato incorrecto");
      alert.setContentText("Introduce un número entero o real");
      alert.setResizable(true);
      alert.getDialogPane().setPrefSize(400, 200);
      
      Label etiqueta = new Label ("La excepcion trazada fue: ");
      
      TextArea texto = new TextArea(ex.getMessage());
      texto.setEditable(false);
      
      GridPane exc = new GridPane();
        exc.add(etiqueta,0,0);
        exc.add(texto,0,1);
      
      
      
      alert.getDialogPane().setExpandableContent(exc);
      alert.showAndWait();
      
    } 
  }
}

