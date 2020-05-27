package controladoresEjercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class ControladorEjercicioExpresiones implements Initializable{
  String archivo;
  String linea;
  double tamanio;


  @FXML
  private TextArea busquedaPatron;

  @FXML
  private TextField textPatron;

  @FXML
  private TextArea cadenasEncontradas;

  @FXML
  private ComboBox<String> fuente;

  @FXML
  private Spinner<Integer> spinner;



  @Override
  public void initialize(URL location, ResourceBundle resources) {

    fuente.getItems().addAll("Arial", "Algerian", "Comic Sans MC", "Bauhaus 93", "Mongolian Baiti", "Broadway", "Bradley Hand ITC");
     cadenasEncontradas.setFont(new Font(fuente.getValue(),spinner.getValue()));
    //tamano = cadenasEncontradas.getFont().getSize();

  }


  public void cargarFichero (ActionEvent e) {

    //String lineaC = " ";
    // Elegimos el fichero
    FileChooser file1 = new FileChooser();
    file1.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

    // Abrimos el explorador de archivos
    file1.setTitle("Abriendo fichero 1");
    Window stage = null;
    File f = file1.showOpenDialog(stage);
    archivo = f.getPath();
    try {
      BufferedReader fichero1 = new BufferedReader(new FileReader(f));

      // Leemos el fichero
      String linea = fichero1.readLine();

      while (linea != null) {
        busquedaPatron.setText(busquedaPatron.getText()+ linea+ "\n"); // muestra el contenido en el TextArea
        linea = fichero1.readLine();
      }
      //busquedaPatron.setText(lineaC);

      fichero1.close();

    } catch (Exception exception) {
      System.err.println("Error, no se ha podido abrir el fichero");
    }    
  }


  //[0-9]{4}[BC-DF-GH-JN-PT-VZ]{3} MATRICULA
  //#[0-9A-Fa-f]+\\b  NUMERO HEXADECIMAL
  // \b\d{8}[A-HJ-NP-TV-Z]\b DNI
  //\\b\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\b IP
  //\\B(@[a-zA-Z0-9_]{1,15})\\b TWITTER
  // \\d{1,2}/\\d{1,2}/\\d{4} FECHA
  


  public void busca (ActionEvent b) {

    //cadenasEncontradas.setFont(new Font(fuente.getValue(),spinner.getValue()));

    try {
      String patron = textPatron.getText();
      BufferedReader manejador = new BufferedReader(new FileReader(archivo));
      String linea = manejador.readLine();
      while (linea != null) {
        Pattern pattern1 = Pattern.compile(patron);
        Matcher matcher1 = pattern1.matcher(linea);
        while (matcher1.find()) {
          cadenasEncontradas.setText(cadenasEncontradas.getText() + " " + "\n" + matcher1.group());
        }
        linea = manejador.readLine();
      }
      manejador.close();

    } catch (Exception e) {
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Error en el programa");
      alert.setHeaderText("Ninguna coincidencia");
      alert.setContentText("Comprueba que la expresión sea correcta");
      alert.setResizable(true);
      alert.getDialogPane().setPrefSize(400, 200);

      alert.showAndWait();
    }

  }

  public void tipoLetra (ActionEvent e) {
    cadenasEncontradas.setFont(new Font(fuente.getValue(),spinner.getValue()));

  }
  public void tamanioLetra (MouseEvent e) {
   tamanio = spinner.getValue();
   cadenasEncontradas.setFont(new Font(fuente.getValue(),spinner.getValue()));
  }
  
  
 
    
  
}


