package controladoresEjercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class ControladorEjercicioQuitaComentarios implements Initializable {
  
  @FXML
  private TextArea resultado;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // TODO Apéndice de método generado automáticamente
    
  }
  
  public void quitaComentarios(ActionEvent e) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Ficheros Java", "*.java")   );
    Window escenario = null;
    File ficheroConComentarios = fileChooser.showOpenDialog(escenario);
    
    // Proceso
    try {
      String FicheroConComentarios = ficheroConComentarios.getAbsolutePath();
      String FicheroSinComentarios = FicheroConComentarios.replace(".java", ".SinComentarios.java");
      //String resultadoSinComentarios = resultado.setText("" + FicheroSinComentarios);
      BufferedReader bOrigen = new BufferedReader(new FileReader(FicheroConComentarios));       // Abrimos fichero origen
      BufferedWriter bDestino = new BufferedWriter(new FileWriter(FicheroSinComentarios));     // Abrimos fichero destino
      
      boolean estoyEnUnBloqueDeComentarios = false;     // necesaria para detectar bloques /* ... */
      
      // Leo cada línea del fichero origen y si no es un comentario la escribo en el destino
      String linea = bOrigen.readLine();
      while (linea != null) {
        if (estoyEnUnBloqueDeComentarios) { 
          // Estoy dentro de un bloque /* ... */
          // solo tengo que comprobar si el bloque finaliza por acabar la línea con "*/"
          // no escribo nada en el fichero de salida en cualquier caso
          if (linea.trim().endsWith("*/")) {
            estoyEnUnBloqueDeComentarios = false;
          }
        } else if (linea.trim().startsWith("/*")) {     // ¿empieza un bloque de comentarios?
          estoyEnUnBloqueDeComentarios = true;          // activo el indicador del bloque /*...*/
        } else {
          // el único comentario posible aquí es con //
          // lo eliminamos y escribimos en el fichero si la línea no queda vacía
          boolean escribeLinea = true;
          if (linea.contains("//")) {     
            int dondeEmpiezaBarra2 = linea.indexOf("//");
            linea = linea.substring(0, dondeEmpiezaBarra2);
            // si la línea contiene únicamente espacios o está vacía, no la escribo
            if (linea.trim().equals("")) {
              escribeLinea = false;
            }
          }
          // escribimos línea sin comentarios
          if (escribeLinea) {
            bDestino.write(linea);
            bDestino.newLine();     // añado salto de línea
            resultado.setText(resultado.getText() + linea + "\n" );
          }
        }
        // leo siguiente línea (o el <EOF>)
        linea = bOrigen.readLine();
      }
      
      // Finalizo y cierro archivos
      bOrigen.close();
      bDestino.close();
      System.out.println("Fin del proceso.");
      
    } catch (FileNotFoundException excp) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setHeaderText("¡ERROR!");
      alert.setContentText("No se encuentra el archivo con extensión .java.");
      alert.showAndWait();
    } catch (IOException excp) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setHeaderText("¡ERROR!");
      alert.setContentText("Error de salida al compilar el fichero.");
      alert.showAndWait();
    }

  }

}

