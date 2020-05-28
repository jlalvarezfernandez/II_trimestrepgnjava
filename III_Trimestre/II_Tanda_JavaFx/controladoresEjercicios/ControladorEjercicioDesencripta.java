package controladoresEjercicios;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Slider;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class ControladorEjercicioDesencripta implements Initializable{
  
  String archivo;
  int posicion = 0;

	@FXML
	private TextArea textoEncriptado;
	@FXML
	private Slider slider;
	@FXML
	private TextArea textoDesencriptado;
	@FXML
  private TextField clave;
	@FXML
	private Button btnMayor;
	@FXML
	private Button btnMenor;
	@FXML
  private Button btnCargar;
	@FXML
  private Button btnGuardar;
	@FXML
  private Button btnDesencripta;
	
	

	
	 @Override
	  public void initialize(URL location, ResourceBundle resources) {
	    clave.setAlignment(Pos.CENTER);
	    clave.setText(posicion + "");
	    slider.valueProperty().addListener((observable, oldValue, newValue) ->  {
	      clave.setText(Integer.toString(slider.valueProperty().getValue().intValue()));
	    });
	  }
	 

	// Event Listener on Button.onAction
	@FXML
	public void cargar(ActionEvent event) {
	  FileChooser file1 = new FileChooser();
    file1.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

    file1.setTitle("Abriendo fichero 1");
    Window stage = null;
    File f = file1.showOpenDialog(stage);
    archivo = f.getPath();
    try {
      BufferedReader fichero1 = new BufferedReader(new FileReader(f));
      
      String linea;
      while ((linea=fichero1.readLine()) != null) {
        textoEncriptado.setText(textoEncriptado.getText()+ linea + "\n");
      }

      fichero1.close();

    } catch (Exception e) {
      System.err.println("Error, no se ha podido abrir el fichero");
    } 
	}
	// Event Listener on Button.onAction
	@FXML
	public void desencripta(ActionEvent event) {
	 
    try {
      BufferedReader fichero = new BufferedReader(new FileReader(archivo));
      String linea;
      while ((linea=fichero.readLine()) != null) {
        textoDesencriptado.setText(textoDesencriptado.getText() + DesencriptaMetodoCesar.desencriptaCesar(linea, Integer.parseInt(clave.getText())) + "\n"); 
      }
    } catch (Exception e){
      System.out.println("Error en el fichero");
    }
	}
	// Event Listener on Button.onAction
	@FXML
	public void guarda(ActionEvent event) throws IOException {
	  FileChooser file1 = new FileChooser();
	  file1.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
	  file1.setTitle("Abriendo fichero 1");
	  Window stage = null;
    File f = file1.showSaveDialog(stage);
    try {
      BufferedWriter ficheroGuardador = new BufferedWriter(new FileWriter(f.getAbsolutePath()));
      ficheroGuardador.write(textoDesencriptado.getText());
      ficheroGuardador.close();

    } catch (Exception e){
      System.out.println("Error en el fichero");
    }
	}
	  
    

	// Event Listener on Button.onAction
	@FXML
	public void menor(ActionEvent event) {
	  posicion--;
    clave.setText(posicion + "");

	  if (posicion < -65) {
	    Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Error en el programa");
      alert.setHeaderText("Limite -25");
      alert.setContentText("Comprueba que el máximo del desplazamiento sea menor de -25");
      alert.setResizable(true);
      alert.getDialogPane().setPrefSize(400, 200);

      alert.showAndWait();
      posicion = -25;
      clave.setText(posicion + "");
	  }
	 
		
	}
	// Event Listener on Button.onAction
	@FXML
	public void mayor(ActionEvent event) {
	  posicion++;
	  clave.setText(posicion + "");
    if (posicion > 65) {
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Error en el programa");
      alert.setHeaderText("Limite 25");
      alert.setContentText("Comprueba que el máximo del desplazamiento sea menor de 25");
      alert.setResizable(true);
      alert.getDialogPane().setPrefSize(400, 200);

      alert.showAndWait();
      posicion = 25;
      clave.setText(posicion + "");

    }
   

	}
	
	
	@FXML
  public void arrastra(ActionEvent event) {
	  if (event.getSource().equals(btnMayor)) {
	    slider.valueProperty().setValue(slider.valueProperty().getValue().intValue() + 1);
	    clave.setText(Integer.toString(slider.valueProperty().getValue().intValue()));
	    
	  } else if (event.getSource().equals(btnMenor)) {
      slider.valueProperty().setValue(slider.valueProperty().getValue().intValue() - 1);
      clave.setText(Integer.toString(slider.valueProperty().getValue().intValue()));
	    
	  }
	
  }
  private static String desencriptaCesar(String cadena, int desplazamiento) {
    String letras = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZáéíóúüñÁÉÍÓÚÜÑ";
    String cadenaDesencriptada = "";
    for (char caracter: cadena.toCharArray()) {
      char caracterDesencriptado = caracter;
      // si el carácter es alfabético, desencriptamos
      if (letras.contains(Character.toString(caracter))) {
        int posicionDondeEsta = letras.indexOf(caracter);
        int posicionCaracterDesencriptado = ((posicionDondeEsta - desplazamiento) % letras.length());
        if (posicionCaracterDesencriptado < 0) {
          posicionCaracterDesencriptado = letras.length() + posicionCaracterDesencriptado;
        }
        caracterDesencriptado = letras.charAt(posicionCaracterDesencriptado);
      } 
      cadenaDesencriptada += caracterDesencriptado;
    }
    return cadenaDesencriptada;
  }
	

 
}
