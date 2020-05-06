package controladoresEjercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class ControladorFicheros implements Initializable{
  
  String archivo1;
  String archivo2;
   
  
  
  @FXML
  private TextArea resultado;
  
  @FXML
  private TextArea muestraF1;
  
  @FXML
  private TextArea muestraF2;
  
  

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    
    
  }
  
  public void fichero1 (ActionEvent f1) {

    FileChooser file1 = new FileChooser();
    file1.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

    file1.setTitle("Abriendo fichero 1");
    Window stage = null;
    File f = file1.showOpenDialog(stage);
    archivo1 = f.getPath();
    try {
      BufferedReader fichero1 = new BufferedReader(new FileReader(f));
      
      String linea;
      while ((linea=fichero1.readLine()) != null) {
        muestraF1.setText(muestraF1.getText()+ linea + "\n");
      }

      fichero1.close();

    } catch (Exception e) {
      System.err.println("Error, no se ha podido abrir el fichero");
    }    
  }
  
 
  
  public void fichero2 (ActionEvent f2) {

    FileChooser file2 = new FileChooser();
    file2.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

    file2.setTitle("Abriendo fichero 2");
    Window stage = null;
    File f1 = file2.showOpenDialog(stage);
    archivo2 = f1.getPath();

    
    try {
      BufferedReader fichero2 = new BufferedReader(new FileReader(f1));
      String linea = fichero2.readLine();

      while (linea != null) {
        muestraF2.setText(muestraF2.getText()+ linea+ "\n");
        linea = fichero2.readLine();

      }

      fichero2.close();

    } catch (Exception e) {
      System.err.println("Error, no se ha podido abrir el fichero");
    }    
  }
  
  public void mezcla(ActionEvent e) {
    
    try {
      
    BufferedReader fichero1 = new BufferedReader(new FileReader(archivo1));
    BufferedReader fichero2 = new BufferedReader(new FileReader(archivo2));
    BufferedWriter ficheroMezclado = new BufferedWriter(new FileWriter("ficheroMezcla.txt"));

    String linea1 = fichero1.readLine();
    String linea2 = fichero2.readLine();

    while ((linea1 != null) || (linea2 != null) ) {
      
      if (linea1 != null) {
        ficheroMezclado.write(linea1 + "\n");

        resultado.setText(resultado.getText() + linea1 + "\n");
      }
      if (linea2 != null) {
        ficheroMezclado.write(linea2 + "\n");

        resultado.setText(resultado.getText() + linea2 + "\n");
      }
      linea1 = fichero1.readLine();
      linea2 = fichero2.readLine();
    }
    fichero1.close();
    fichero2.close();
    ficheroMezclado.close();



  } catch (Exception ex) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error en el programa!!!!");
    alert.setHeaderText("No se ha podido abrir el archivo");
    alert.setContentText("Introduce un archivo correctamente");
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