package controladoresEjercicios;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;

public class ControladorEjercicioContadorPalabras implements Initializable{

  @FXML 
  private TextArea fraseAnalizar;

  @FXML 
  private TextField resultado;


  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }

  public void calcular(ActionEvent e) {
    try {
      String cadena;
      int contadorPalabras = 0;

      // Pedimos datos
      cadena = fraseAnalizar.getText();

      // Borro los posibles espacios al principio y final de la cadena
      cadena = cadena.trim();

      // Si nos dan la cadena vacía terminamos la ejecución con un código de error
      if (cadena.isEmpty()) {
        resultado.setText("Has introducido una cadena vacía, no hay nada que contar");
        System.exit(1);
      }

      // Desde el primer caracter distinto de espacio
      for (int posicion = 0; posicion<=cadena.length()-1; posicion++) {
        if (cadena.charAt(posicion)==' ') {
          contadorPalabras++;
          // No tengo en cuanta los posibles espacios que haya entre las palabras
          while (posicion<=cadena.length()-1 && cadena.charAt(posicion)==' ') {
            posicion++;
          }
        }
      }
      // Si no acaba en espacios tengo que contar la última palabra (no hace falta aquí)
      // if (!cadena.endsWith(" ")) {
      //   contadorPalabras++;
      // }
      contadorPalabras++;

      resultado.setText("La cadena tiene "+contadorPalabras+" palabras.");




    } catch (Exception e2) {
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Error");
      alert.setContentText("Introduce una frase");
      alert.showAndWait();
    }
  }  
}


