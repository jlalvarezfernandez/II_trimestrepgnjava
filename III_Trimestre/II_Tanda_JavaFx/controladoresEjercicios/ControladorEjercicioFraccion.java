package controladoresEjercicios;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class ControladorEjercicioFraccion implements Initializable{

  @FXML
  private TextField numF1;

  @FXML
  private TextField denoF1;

  @FXML
  private TextField numF2;

  @FXML
  private TextField denoF2;

  @FXML
  private TextField resultadoNumerador;

  @FXML
  private TextField resultadoDenominador;

  @FXML
  private ToggleGroup toggleGroup;

  @FXML
  private RadioButton suma;

  @FXML
  private RadioButton resta;

  @FXML
  private RadioButton producto;

  @FXML
  private RadioButton division;





  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }


  @SuppressWarnings("static-access")
  public void calcula(ActionEvent e) {

    try {
      // Fracción 1
      int numeradorF1 = Integer.parseInt(this.numF1.getText());
      int denominadorF1 = Integer.parseInt(this.denoF1.getText());
      Fraccion f1 = new Fraccion (numeradorF1, denominadorF1);

      //Fracción 2
      int numeradorF2 = Integer.parseInt(this.numF2.getText());
      int denominadorF2 = Integer.parseInt(this.denoF2.getText());
      Fraccion f2 = new Fraccion (numeradorF2, denominadorF2);


      RadioButton radioSelectedGroup = (RadioButton) toggleGroup.getSelectedToggle();

      if(radioSelectedGroup == null) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error en el programa!!!!");
        alert.setHeaderText("Error en la selección de opciones");
        alert.setContentText("Tienes que seleccionar alguna de las opciones:\n"
            + "Suma, Resta, Poducto, División");
        alert.setResizable(true);
        alert.getDialogPane().setPrefSize(400, 200);
        alert.showAndWait();

      }
      
      Fraccion resultado = null;

      if (radioSelectedGroup.equals(suma)) {
        resultado = f1.sumar(f1, f2);
       

      } else if (radioSelectedGroup.equals(resta)) {
        resultado = f1.restar(f1, f2);
        

      } else if (radioSelectedGroup.equals(producto)) {
        resultado = f1.multiplicar(f1, f2);
        

      }else if (radioSelectedGroup.equals(division)) {
        resultado = f1.dividir(f1, f2);
        

      }
      
      // muestras resultado
      resultadoNumerador.setText(resultado.getNum() + "");
      resultadoDenominador.setText(resultado.getDen() + "");

    } catch (NumberFormatException e2) {

      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Error en el programa!!!!");
      alert.setHeaderText("Tipo de dato incorrecto");
      alert.setContentText("Introduce un número entero");
      alert.setResizable(true);
      alert.getDialogPane().setPrefSize(400, 200);

      Label etiqueta = new Label ("La excepcion trazada fue: ");

      TextArea texto = new TextArea(e2.getMessage());
      texto.setEditable(false);

      GridPane exc = new GridPane();
      exc.add(etiqueta,0,0);
      exc.add(texto,0,1);

      alert.getDialogPane().setExpandableContent(exc);
      alert.showAndWait();
    }

  }
}


