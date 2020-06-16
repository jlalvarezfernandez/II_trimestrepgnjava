/**
 * Creación clase ListaColectiva donde se mostrará una tabla con todos los articulos del alamcén y aparecerán ls siguietnes opciones:
 *    - Modificar un artículo (nos lleva al escenario para modificar los artículos)
 *    - Dar de alta un artículo (nos lleva al escenario para dar de alata un artículo
 *    - Eliminar artículo (elimina un articulo de la lista)
 *    - Cambiar vista (permite ir a la ventana ListaIndividual, donde podemos modificar también un artículo y verlo en detalle
 *    
 * @author JOSÉ LUIS ÁLVAREZ FÉRNANDEZ
 * @author FRANCISCO JAVIER CAMPOS GUTIÉRREZ
 * @author ANTONIO QUESADA CUADRADO
 */

package application.vistas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.AlmacenFx;
import application.gestisimal.Almacen;
import application.gestisimal.Articulo;
import application.gestisimal.CodigoArticuloNoExisteExcepcion;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;


// Creación de la clase ListaColectivaController

public class ListaColectivaController implements Initializable{

  private Almacen almacen = AlmacenFx.getAlmacen();
  private TableViewSelectionModel<Articulo> seleccion = null;
  private int codigo;

  // definimos los espacios de nombre correspondientes a cada nodo que vamos a utiizar
  @FXML
  TableView<Articulo> tableArticulo;
  @FXML
  private TableColumn<Articulo, ?> colCodigo;
  @FXML
  private TableColumn<Articulo, ?> colDescripcion;
  @FXML
  private TableColumn<Articulo, ?> colPrecioC;
  @FXML
  private TableColumn<Articulo, ?> colPrecioV;
  @FXML
  private TableColumn<Articulo, ?> colUnidades;
  @FXML
  private TableColumn<Articulo, ?> colIva;
  @FXML
  private TableColumn<Articulo, ?> colStockMinimo;
  @FXML 
  private Button btnCancelar;

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    seleccion = tableArticulo.getSelectionModel();

    // Tipo de ArrayList
    colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    colPrecioC.setCellValueFactory(new PropertyValueFactory<>("precioCompra"));
    colPrecioV.setCellValueFactory(new PropertyValueFactory<>("precioVenta"));
    colUnidades.setCellValueFactory(new PropertyValueFactory<>("numUnidades"));
    colIva.setCellValueFactory(new PropertyValueFactory<>("tipoDeIva"));
    colStockMinimo.setCellValueFactory(new PropertyValueFactory<>("stockMin"));

    // rellenamos la tabla

    refrescar();
  }

  /**
   * Método refrescar para actualizar la información de la tabla
   */
  private void refrescar() {
    // elimino vista
    tableArticulo.getItems().clear();
    // copio lista de Almacén
    ArrayList<Articulo> lista = new ArrayList<Articulo>();
    almacen.exporta(lista);
    for (Articulo articulo: lista) {
      tableArticulo.getItems().add(articulo);
    }
  }

  /**
   * Método salir para cerrar la ventana
   * @param event
   */

  @FXML
  public void salir(ActionEvent event) {
    Stage stage =  (Stage) btnCancelar.getScene().getWindow();
    stage.close();
  }


  /**
   * Método cambiarVista para ir a la ventana ListaIndividual
   * @param event
   * @throws IOException
   */
  @FXML
  public void cambiarVista(ActionEvent event) throws IOException {
    if (seleccion.isEmpty()) {    
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Error en el programa");
      alert.setHeaderText("Modifica contacto");
      alert.setContentText("Debes seleccionar un contacto para modificarlo");
      alert.setResizable(true);
      alert.getDialogPane().setPrefSize(400, 200);
      alert.showAndWait();

    } else {
      codigo = tableArticulo.getSelectionModel().getSelectedItem().getCodigo();

      Parent root;
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/vistas/ListaIndividual.fxml"));
      root = fxmlLoader.load();

      ListaIndividualController controller = fxmlLoader.getController();
      controller.set(codigo);

      Scene escena = new Scene(root);
      Stage escenario = new Stage();
      escenario.setTitle("Lista Individual");
      escenario.setResizable(false);
      escenario.setScene(escena);
      escenario.showAndWait();

    }

    refrescar();

  }

  /**
   * Método modifcar artículo que nos lleva a la ventana para modificar artículos
   * @param event
   * @throws IOException
   */
  @FXML
  public void modificaArticulo(ActionEvent event) throws IOException {

    TableViewSelectionModel<Articulo> selectionModel = tableArticulo.getSelectionModel();

    if(selectionModel.isEmpty()) {
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Error en el programa");
      alert.setHeaderText("Modifica Artículo");
      alert.setContentText("Debes seleccionar un artículo para modificarlo");
      alert.setResizable(true);
      alert.getDialogPane().setPrefSize(400, 200);
      alert.showAndWait();     

    }else {

      codigo = tableArticulo.getSelectionModel().getSelectedItem().getCodigo();
      Parent root;
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/vistas/ModificaArticulo.fxml"));
      root = fxmlLoader.load();
      ModificaArticuloController controller = fxmlLoader.getController();
      controller.set(codigo);
      Scene escena = new Scene(root);
      Stage escenario = new Stage();
      escenario.setTitle("Sección dedicada a dar de alta artículos");
      escenario.initModality(Modality.APPLICATION_MODAL);
      escenario.setScene(escena);
      escenario.showAndWait();
    }

    refrescar();
  }

  /**
   * Método AltaArticulo que nos llevara a la ventana para dar de alta un artículo
   * @param event
   * @throws IOException
   */
  @FXML
  public void altaArticulo(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/application/vistas/AltaArticulo.fxml"));
    Scene escena = new Scene(root);
    Stage escenario = new Stage();
    escenario.setTitle("Sección dedicada a dar de alta artículos");
    escenario.initModality(Modality.APPLICATION_MODAL);
    escenario.setScene(escena);
    escenario.showAndWait();

    refrescar();

  }

  /**
   * Método bajaArticulo que eliminará un artículo seleccionado en la tabla
   * @param event
   * @throws IOException
   * @throws CodigoArticuloNoExisteExcepcion
   */
  @FXML
  public void bajaArticulo(ActionEvent event) throws IOException, CodigoArticuloNoExisteExcepcion {

    TableViewSelectionModel<Articulo> selectionModel = tableArticulo.getSelectionModel();

    if (selectionModel.isEmpty()) {
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Información");
      alert.setHeaderText("Baja de artículos");
      alert.setContentText("Debes seleccionar un artículo para darlo de baja");
      alert.setResizable(true);
      alert.getDialogPane().setPrefSize(400, 200);
      alert.showAndWait();     
    } else {
      codigo = tableArticulo.getSelectionModel().getSelectedItem().getCodigo();
      almacen.baja(codigo);
      refrescar();
    }
  }
}
