package controladoresEjercicios;

/**
 * Creación de la clase controlador para el ejercicio de los números primos
 * aqui lo que vamos a hacer es darle funcionalidad al boton que esta controlado por el ratón
 * tambien darle funcionalidad a los dos textField para acceder a ellos a traves de su espacio de nombre
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ControladorNumerosPrimos implements Initializable{
  
  // indicamos los espacios de nombre utilizados en este ejercicio
  
  @FXML
  private TextField numerosAMostrar;
  
  @FXML
  private TextArea resultado;
  
  
  
  
  
 

  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }

  // método apra manejar el raton 
  public void calcular(ActionEvent e) { 
    int cantidadAMostrar = 0;
    try {
      // cantidadAMostrar es un textField, y para leerlo lo hacemos así
       cantidadAMostrar = Integer.parseInt(numerosAMostrar.getText());

      resultado.setText("1º ==> 2");       
      int cantidadMostrados = 1;
      // ...a partir de 3
      int num = 3;
      while (cantidadMostrados < cantidadAMostrar) {
        // pienso que es primo hasta que encuentre con que dividirlo
        boolean esPrimo = true;
        // ya sabemos que es impar
        for (int divisor=3; divisor<=Math.sqrt(num) && esPrimo; divisor+=2) {
          // si la división da exacta...
          if (num%divisor==0) {
            // ...ya no es primo
            esPrimo = false;
          }
        }
        if (esPrimo) {
          cantidadMostrados++;
          resultado.setText(resultado.getText() + "\n" + cantidadMostrados + "º ==> " + num);
        }
        num += 2;
      }

    } catch (NumberFormatException excep) {
      // método alert para informar en una pestaña auxiliar si se ha producido un error
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Error");
      alert.setHeaderText("Tipo de dato incorrecto");
      alert.setContentText("Introduce un número");
      alert.showAndWait();
      
    }


  }
}


