/**
 * Controlador para la clase almacén.
 * En esta clase creamos todos los eventos necesarios para la navegacion del menú.
 * Ademas también hemos creado los métodos necesarios para la creación de los distintos escenarios de los que esta 
 * compuesta esta aplicación
 * 
 * @author JOSÉ LUIS ÁLVAREZ FÉRNANDEZ
 * @author FRANCISCO JAVIER CAMPOS GUTIÉRREZ
 * @author ANTONIO QUESADA CUADRADO
 */

package application.vistas;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.gestisimal.Almacen;
import javafx.event.ActionEvent;
import javafx.event.Event;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;

// Creación clase AlmacenGestisimalControllerBis

public class AlmacenGestisimalControllerBis implements Initializable{

  // asi podemos usar todos lo métodos de la clase almacén de Gestisimal

  static Almacen almacen = new Almacen();

  // Definimos los espacios de nombre correspondientes a cada nodo que vamos a utilizar en esta clase

  @FXML
  private Text descripcion;
  @FXML
  private MenuItem salir;
  @FXML
  private Menu menuArticulo;
  @FXML
  private Menu menuListado;
  @FXML
  private Menu menuHerramientas;
  @FXML
  private Menu menuContacto;
  @FXML
  private ContextMenu menuContextual;
  @FXML
  private MenuItem repositorio;


  /**
   *  Método initializable en el que hemos creado que se pueda salir de la aplicación mediante la combinación de teclas ctrl+ x
   */

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    // combinación de teclas ctrl + x para salir del menú

    KeyCombination ctrlX = new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN);
    salir.setAccelerator(ctrlX);

  }

  /**
   *  Creación del evento información donde al presionar en cada elemento del menuBar 
   *  nos ofrecerá una pequeña descripción de lo que hace cada parte del menú
   * @param event
   */

  public void informacion(Event event) {
    String id = ((Menu) event.getSource()).getId();
    if (id.equals("menuArticulo")) {
      descripcion.setText("Menú artículo (alta, baja, modificación,entrada y salida mercancía)");
    } else if (id.equals("menuListado")) {
      descripcion.setText("Menú listado (vista individual del artículo y vista conjunta de los artículos");
    } else if (id.equals("menuHerramientas")) {
      descripcion.setText("Menú herramientas (exportar e importar fichero en formato XML, CSV, JSON)");
    } else {
      descripcion.setText("Menú contacto (Información sobre los creadores de esta aplicación)");
    }
  }

  /**
   * Creación del método AltaArticulo, donde crearemos un nuevo escenario dedicado a dar de alta los artículos del almacén
   * @param e
   * @throws IOException
   */

  public void altaArticulo(ActionEvent e) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/application/vistas/AltaArticulo.fxml"));
    Scene escena = new Scene(root);
    Stage escenario = new Stage();
    escenario.setTitle("Sección dedicada a dar de alta artículos en el almacén");
    escenario.initModality(Modality.APPLICATION_MODAL);
    escenario.setScene(escena);
    escenario.setResizable(false);
    escenario.showAndWait();
  }

  /**
   * Creación del método ModificaArticulo, donde crearemos un nuevo escenario dedicado a modificar los artículos del almacén
   * @param e
   * @throws IOException
   */

  public void modificaArticulo(ActionEvent e) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/application/vistas/CodigoArticuloModifica.fxml"));
    Scene escena = new Scene(root);
    Stage escenario = new Stage();
    escenario.setTitle("Sección dedicada a modificar artículos del almacén");
    escenario.initModality(Modality.APPLICATION_MODAL);
    escenario.setResizable(false);
    escenario.setScene(escena);
    escenario.showAndWait();
  }

  /**
   * Creación del método CodigoArticuloBaja, donde crearemos un nuevo escenario dedicado a pedir el codigo de un artículo para 
   * poder darlo de baja
   * @param e
   * @throws IOException
   */

  public void bajaArticulo(ActionEvent e) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/application/vistas/CodigoArticuloBaja.fxml"));
    Scene escena = new Scene(root);
    Stage escenario = new Stage();
    escenario.setTitle("Sección dedicada a dar de baja artículos del almacén");
    escenario.setResizable(false);
    escenario.initModality(Modality.APPLICATION_MODAL);
    escenario.setScene(escena);
    escenario.showAndWait();
  }

  /**
   * Creación del método EntradaMercancia, donde crearemos un nuevo escenario dedicado a dar entrada a nueva mercancía en el almacén
   * @param e
   * @throws IOException
   */

  public void entradaMercancia(ActionEvent e) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/application/vistas/CodigoEntradaMercancia.fxml"));
    Scene escena = new Scene(root);
    Stage escenario = new Stage();
    escenario.setTitle("Sección dedicada a dar entrada de unidades a un artículo del almacén");
    escenario.setResizable(false);
    escenario.initModality(Modality.APPLICATION_MODAL);
    escenario.setScene(escena);
    escenario.showAndWait();
  }

  /**
   * Creación del método salidadaMercancia, donde crearemos un nuevo escenario dedicado a dar salida a la mercancía en el almacén
   * @param e
   * @throws IOException
   */

  public void salidaMercancia(ActionEvent e) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/application/vistas/CodigoSalidaMercancia.fxml"));
    Scene escena = new Scene(root);
    Stage escenario = new Stage();
    escenario.setTitle("Sección dedicada a dar salida de unidades a un artículo del almacén");
    escenario.setResizable(false);
    escenario.initModality(Modality.APPLICATION_MODAL);
    escenario.setScene(escena);
    escenario.showAndWait();
  }

  /**
   * Creación del método irRepositorio, donde crearemos un nuevo escenario dedicado a mostrar donde hemos subido esta aplicación en GitHub
   * @param e
   * @throws IOException
   */

  @SuppressWarnings("unused")
  public void irRepositorio(ActionEvent e) throws IOException {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Información GESTISIMAL");
    alert.setHeaderText("Esta aplicación se encarga de realizar la gestión de un almacén\n"
        + "Donde se pueden dar de alta, borrar, modificar artículos, además de controlar la entrada y salida de artículos\n"
        + "Tambien podemos ver los artículos en una tabla conjunta o de forma individual,\n "
        + "pudiendo también exportar e importar ficheros con información de dichos artículos en formato CSV, XML y JSON");
    alert.setContentText("Si quieres ver el código de esta aplicación pulsa en aceptar");

    Optional<ButtonType> result = alert.showAndWait();

    Parent root = FXMLLoader.load(getClass().getResource("/application/vistas/irRepositorio.fxml"));
    Scene escena = new Scene(root);
    Stage escenario = new Stage();
    escenario.setTitle("Sección donde esta guardada esta aplicación");
    escenario.setResizable(false);
    escenario.initModality(Modality.APPLICATION_MODAL);
    escenario.setScene(escena);
    escenario.showAndWait();
  }

  /**
   * Creación del método ExportaFicheros, donde crearemos un nuevo escenario dedicado a poder exportar los articulos del almacén 
   * a un fichero en formato CSV, JSON, XML
   * @param e
   * @throws IOException
   */

  public void ExportaFicheros(ActionEvent e) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/application/vistas/ExportaFicheros.fxml"));
    Scene escena = new Scene(root);
    Stage escenario = new Stage();
    escenario.setTitle("Exportar información del almacén a diferentes formatos: CSV, XML, JSON");
    escenario.setResizable(false);
    escenario.initModality(Modality.APPLICATION_MODAL);
    escenario.setScene(escena);
    escenario.showAndWait();
  }

  /**
   * Creación del método ImportaFicheros, donde crearemos un nuevo escenario dedicado a poder importar los articulos del almacén
   * a un fichero en formato CSV, JSON, XML
   * @param e
   * @throws IOException
   */

  public void ImportaFicheros(ActionEvent e) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/application/vistas/ImportaFicheros.fxml"));
    Scene escena = new Scene(root);
    Stage escenario = new Stage();
    escenario.setTitle("Importar información al almacén en diferentes formatos: CSV, XML, JSON");
    escenario.setResizable(false);
    escenario.initModality(Modality.APPLICATION_MODAL);
    escenario.setScene(escena);
    escenario.showAndWait();
  }

  /**
   * Creación del método ListaColectiva, donde crearemos un nuevo escenario dedicado a mostrar los artículos del almacén en una tabla
   * @param e
   * @throws IOException
   */

  public void ListaColectiva(ActionEvent e) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/application/vistas/ListaColectiva.fxml"));
    Scene escena = new Scene(root);
    Stage escenario = new Stage();
    escenario.setTitle("Tabla colectiva con la información de todos los artículos del almacén");
    escenario.setResizable(false);
    escenario.setScene(escena);
    escenario.showAndWait();
  }

  /**
   * Creación del método Listaindividual, donde crearemos un nuevo escenario dedicado a mostrar los artículos del almacén 
   * de forma individual y se podrán modificar.
   * @param e
   * @throws IOException
   */

  public void ListaIndividual(ActionEvent e) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/application/vistas/listaIndividual.fxml"));
    Scene escena = new Scene(root);
    Stage escenario = new Stage();
    escenario.setTitle("Lista Individual");
    escenario.setResizable(false);
    escenario.setScene(escena);
    escenario.showAndWait();
  }

  /**
   * Creación del método GitHubJoseLuis, donde crearemos un nuevo escenario dedicado a mostrar la información de contacto 
   * de José Luis Álvarez
   * @param e
   * @throws IOException
   */

  public void GitHubJoseluis (ActionEvent e) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/application/vistas/GitHubJoseLuis.fxml"));
    Scene escena = new Scene(root);
    Stage escenario = new Stage();
    escenario.setTitle("Github José Luis");
    escenario.setResizable(false);
    escenario.setScene(escena);
    escenario.show();
  }

  /**
   * Creación del método GitHubCurro, donde crearemos un nuevo escenario dedicado a mostrar la información de contacto 
   * de Francisco Javier Gutierrez Campos
   * @param e
   * @throws IOException
   */

  public void GitHubCurro (ActionEvent e) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/application/vistas/GitHubCurro.fxml"));
    Scene escena = new Scene(root);
    Stage escenario = new Stage();
    escenario.setTitle("Github Francisco Javier Campos");
    escenario.setResizable(false);
    escenario.setScene(escena);
    escenario.show();
  }

  /**
   * Creación del método GitHubAntonio, donde crearemos un nuevo escenario dedicado a mostrar la información de contacto 
   * de Antonio Quesada
   * @param e
   * @throws IOException
   */

  public void GitHubAntonio (ActionEvent e) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/application/vistas/GitHubAntonio.fxml"));
    Scene escena = new Scene(root);
    Stage escenario = new Stage();
    escenario.setTitle("Github Antonio Quesada");
    escenario.setResizable(false);
    escenario.setScene(escena);
    escenario.show();
  }
  
  /**
   * Creación del método pedidoAutomático, donde podremos realizar un pedido de forma automática de los artículos cuyas unidades
   * se encuentren por debajo del stock mínimo asiginado.
   * @param e
   * @throws IOException
   */

  public void pedidoAutomatico (ActionEvent e) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/application/vistas/PedidoAutomatico.fxml"));
    Scene escena = new Scene(root);
    Stage escenario = new Stage();
    escenario.setTitle("Pedido Automático de artículos del almacén");
    escenario.setResizable(false);
    escenario.setScene(escena);
    escenario.show();
  }

  /**
   * Método salirApp, para que al pulsar ctrl+x la apliación se cierre
   */

  public void salirApp() {
    System.exit(0);
  }

}
