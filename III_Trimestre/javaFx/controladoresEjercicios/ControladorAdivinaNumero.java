package controladoresEjercicios;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ControladorAdivinaNumero implements Initializable {
  int numSecreto = (int) (Math.random()*100 + 1);
  static final int INTENTOS_MAXIMOS = 10;
  int intentosQueQuedan = 10;



  
  @FXML
  private TextField numIntroducido;
  
  @FXML
  private TextField intentosRestantes;
  
  @FXML
  private TextField noAcertaste;
  
  @FXML
  private TextField eureka;

  @FXML
  private TextArea pista;
  
  


  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  public void comprobar(ActionEvent e) {
    
    try {
      int n;
      System.out.println(numSecreto);
      // Proceso
      n = Integer.parseInt(numIntroducido.getText());

     
        if(n == numSecreto) {
          eureka.setText(numSecreto+""); 
          intentosQueQuedan--;
          pista.setText("¡¡¡ENHORABUENA!!!");
          intentosRestantes.setText(Integer.toString(0));


        } else if (n < numSecreto) {
          pista.setText(n + " es menor que el número a adivinar");
          intentosQueQuedan--;
          intentosRestantes.setText(Integer.toString(intentosQueQuedan));
          numIntroducido.clear();
          noAcertaste.setText((INTENTOS_MAXIMOS-intentosQueQuedan)+"");
          numIntroducido.clear();

        } else {
          pista.setText(n + " es mayor que el número a adivinar");
          intentosQueQuedan--;
          intentosRestantes.setText(Integer.toString(intentosQueQuedan));
          numIntroducido.clear();
          noAcertaste.setText((INTENTOS_MAXIMOS-intentosQueQuedan)+"");

        }
        if (intentosQueQuedan == 0) {
          Alert alert = new Alert(AlertType.INFORMATION);
          alert.setTitle("PERDEDOR!");
          alert.setHeaderText("Has agotado el número de intentos");
          alert.setContentText("Cierra para jugar de nuevo");
          alert.showAndWait();
          intentosQueQuedan = 10;
          numSecreto = (int) (Math.random()*100 + 1);
          
        }
        

      
    } catch (NumberFormatException e2) {
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Error");
      alert.setHeaderText("Tipo de dato erroneo");
      alert.setContentText("Introduce un número entero para continuar");
      alert.showAndWait();

    }


}
  
    
  

}


