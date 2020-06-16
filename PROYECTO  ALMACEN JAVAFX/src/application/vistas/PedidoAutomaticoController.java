/**
 * Creación de la clase PedidoAutomático donde podremos hacer un pedido de los artículos cuyas unidades estan por debajo del Stock Mínimo para
 * que en nuestro almacén nuca nos falta nada de mercancía
 * 
 * @author JOSÉ LUIS ÁLVAREZ FÉRNANDEZ
 * @author FRANCISCO JAVIER CAMPOS GUTIÉRREZ
 * @author ANTONIO QUESADA CUADRADO
 */

package application.vistas;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import application.AlmacenFx;
import application.gestisimal.Almacen;
import application.gestisimal.Articulo;
import application.gestisimal.CodigoArticuloNoExisteExcepcion;
import application.gestisimal.UnidadesNegativasErrorExcepcion;
import javafx.event.ActionEvent;


// Creación clase PedidoAutomaticoController
public class PedidoAutomaticoController implements Initializable{


  //Definimos los espacios de nombre correspondientes a cada nodo que vamos a utilizar en esta clase
  @FXML
  private Button btnCancelar;
  @FXML
  TableView<Articulo> tablePedido;
  @FXML
  private TableColumn<Articulo, Integer> codigoPedido;
  @FXML
  private TableColumn<Articulo, String> descripcion;
  @FXML
  private TableColumn<Articulo, Integer> unidades;
  @FXML
  private TableColumn<Articulo, Integer> stockMin;

  private Almacen almacen = AlmacenFx.getAlmacen();

  @SuppressWarnings("unused")
  private TableViewSelectionModel<Articulo> seleccion = null;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    seleccion = tablePedido.getSelectionModel();

    // Así podemos modificar las unidades directamente des la tabla

    codigoPedido.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    unidades.setCellValueFactory(new PropertyValueFactory<>("numUnidades"));
    stockMin.setCellValueFactory(new PropertyValueFactory<>("stockMin"));
    refrescar();


    tablePedido.setEditable(true);
    unidades.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    unidades.setOnEditCommit(e->{
      try {
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setNumUnidades( (int) e.getNewValue());
      } catch (UnidadesNegativasErrorExcepcion e1) {
        e1.printStackTrace();
      }
    });

    tablePedido.setEditable(true);
    stockMin.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    stockMin.setOnEditCommit(e->{
      try {
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setStockMin( (int) e.getNewValue());
      } catch (UnidadesNegativasErrorExcepcion e1) {
        e1.printStackTrace();
      }
    });

  }
  /**
   * Método refrescar que actualizará los datos de la tabla colectiva ademas de la tabla de  pedidos automáticos
   */
  private void refrescar() {
    // elimino vista
    tablePedido.getItems().clear();

    // copio lista de Almacén
    ArrayList<Articulo> lista = new ArrayList<Articulo>();
    almacen.exporta(lista);
    for (Articulo articulo: lista) {
      if(articulo.getNumUnidades() < articulo.getStockMin()) {
        tablePedido.getItems().add(articulo);
      }

    }
  }

  /**
   * Método para salir de la ventana
   * @param event
   */
  @FXML
  public void cancelar(ActionEvent event) {
    Stage stage =  (Stage) btnCancelar.getScene().getWindow();
    stage.close();
  }

  /**
   * Método para realizar el pedido automáticamente y crear un fichero en el que apareceran todas las unidades pedidas para satisfacer
   * la demanda del stock mínimo.
   * @param e
   * @throws CodigoArticuloNoExisteExcepcion
   * @throws UnidadesNegativasErrorExcepcion
   */
  public void realizarPedido (ActionEvent e) throws CodigoArticuloNoExisteExcepcion {
    tablePedido.getSelectionModel();

    try {

      Date fecha = new Date();
      DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
      String historialPedidos = formatter.format(fecha);
      BufferedWriter bw = new BufferedWriter(new FileWriter("Pedido_" + historialPedidos +".txt"));

      bw.write("Artículos que necesitan incrementar el stock\n");


      for (Articulo articulo: almacen) {
        if (articulo.getStockMin() > articulo.getNumUnidades()) {
          bw.write("Código: " + articulo.getCodigo() + "\tDescripción: " + articulo.getDescripcion() + "\t\tUnidades a pedir: " +(articulo.getStockMin()-articulo.getNumUnidades()) + "\n");
        }

      }
      bw.close();
      Alert alert1 = new Alert(AlertType.INFORMATION);
      alert1.setTitle("Pedido Automático realizado");
      alert1.setHeaderText("Se ha generado un fichero interno con la información correspondiente");
      alert1.setContentText("Gracias por realizar el pedido");
      alert1.setResizable(true);
      alert1.getDialogPane().setPrefSize(400, 200);
      alert1.showAndWait();


    } catch (NullPointerException | IOException e2) {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Error en el programa");
      alert.setHeaderText("Modifica Artículo");
      alert.setContentText("Unidades Negativas.");
      alert.setResizable(true);
      alert.getDialogPane().setPrefSize(400, 200);
    }
    Stage stage =  (Stage) btnCancelar.getScene().getWindow();
    stage.close();
  }

}



