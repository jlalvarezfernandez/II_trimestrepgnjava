package controladoresEjercicios;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ControladorEjercicioCambioDinero implements Initializable{
  

  @FXML
  private TextField billete500;

  @FXML
  private TextField billete200;

  @FXML
  private TextField billete100;

  @FXML
  private TextField billete50;

  @FXML
  private TextField billete20;

  @FXML
  private TextField billete10;

  @FXML
  private TextField billete5;

  @FXML
  private TextField moneda2;

  @FXML
  private TextField moneda1;
  
  @FXML
  private TextField moneda50;
  
  @FXML
  private TextField moneda20;
  
  @FXML
  private TextField moneda10;
  
  @FXML
  private TextField moneda05;
  
  @FXML
  private TextField moneda02;
  
  @FXML
  private TextField moneda01;

  @FXML
  private TextField cantidadTotal;
  
  




  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }

  public void comprobar(ActionEvent e) {
    

    try {
      billete500.clear();
      billete200.clear();
      billete100.clear();
      billete50.clear();
      billete20.clear();
      billete10.clear();
      billete5.clear();
      moneda1.clear();
      moneda2.clear();
      moneda50.clear();
      moneda20.clear();
      moneda10.clear();
      moneda05.clear();
      moneda02.clear();
      moneda01.clear();
      
      

      double cantidadEuros;
      int bill500;
      int bill200;
      int bill100;
      int bill50;
      int bill20;
      int bill10;
      int bill5;
      int mon2;
      int mon1;
      int mon50Cen;
      int mon20Cen;
      int mon10Cen;
      int mon5Cen;
      int mon2Cen;
      int mon1Cen;



      cantidadEuros =Double.parseDouble(cantidadTotal.getText());
      
      

      bill500 = (int) (cantidadEuros /500);
      double resto500 =  (cantidadEuros%500);

      bill200 = (int) (resto500 /200);
      double resto200 = resto500%200;

      bill100 = (int) (resto200 /100);
      double resto100 = resto200%100;

      bill50 = (int) (resto100 /50);
      double resto50 = resto100%50;

      bill20 = (int) (resto50 /20);
      double resto20 = resto50%20;

      bill10 = (int) (resto20 /10);
      double resto10 = resto20%10;

      bill5 = (int) (resto10 /5);
      double resto5 = resto10%5;

      mon2 = (int) (resto5/2);
      double resto2 = resto5%2;

      mon1 = (int) (resto2/1);
      double resto1 = resto2%1;
      
      mon50Cen = (int) (resto1/0.50);
      double resto50Cen = (resto1%0.50);
      
      mon20Cen = (int) (resto50Cen/0.20);
      double resto20Cen = (resto50Cen%0.20);
      
      mon10Cen = (int) (resto20Cen/0.10);
      double resto10Cen = (resto20Cen%0.10);
      
      mon5Cen = (int) (resto10Cen/0.05);
      double resto5Cen = (resto10Cen%0.05);
      
      mon2Cen =  (int) (resto5Cen/0.02);
      double resto2Cen =  (resto5Cen%0.02);
      
      mon1Cen = (int) (resto2Cen/0.01);
      double resto1Cen = (resto2Cen%0.01);
      


      if(bill500 != 0) {
        if (bill500 == 1) {
          billete500.setText(bill500 + "");

        } else {
          billete500.setText(bill500 + "");

        }
      }

      if(bill200 != 0) {
        if (bill200 == 1) {
          billete200.setText(bill200 + "");

        } else {
          billete200.setText(bill200 + "");
        }
      }

      if(bill100 != 0) {
        if (bill100 == 1) {
          billete100.setText(bill100 + "");
        } else {
          billete100.setText(bill100 + "");
        }
      }

      if(bill50 != 0) {
        if (bill500 == 1) {
          billete50.setText(bill50 + "");
        } else {
          billete50.setText(bill50 + "");
        }
      }

      if(bill20 != 0) {
        if (bill20 == 1) {
          billete20.setText(bill20 + "");
        } else {
          billete20.setText(bill20 + "");
        }
      }

      if(bill10 != 0) {
        if (bill10 == 1) {
          billete10.setText(bill10 + "");
        } else {
          billete10.setText(bill10 + "");
        }
      }

      if(bill5 != 0) {
        if (bill5 == 1) {
          billete5.setText(bill5 + "");
        } else {
          billete5.setText(bill5 + "");
        }
      }

      if(mon2!= 0) {
        if (mon2 == 1) {
          moneda2.setText(mon2 + "");
        } else {
          moneda2.setText(mon2 + "");
        }
      }

      if(mon1!= 0) {
        if (mon1 == 1) {
          moneda1.setText(mon1 + "");
        } else {
          moneda1.setText(mon1 + "");
        }
      }
      
      if(mon50Cen!= 0) {
        if (mon1 == 1) {
          moneda50.setText(mon50Cen + "");
        } else {
          moneda50.setText(mon50Cen + "");
        }
      }
      
      if(mon20Cen!= 0) {
        if (mon20Cen == 1) {
          moneda20.setText(mon20Cen + "");
        } else {
          moneda20.setText(mon20Cen + "");
        }
      }
      
      if(mon10Cen!= 0) {
        if (mon10Cen == 1) {
          moneda10.setText(mon10Cen + "");
        } else {
          moneda10.setText(mon10Cen + "");
        }
      }
      
      if(mon5Cen!= 0) {
        if (mon5Cen == 1) {
          moneda05.setText(mon5Cen + "");
        } else {
          moneda05.setText(mon5Cen + "");
        }
      }
      
      if(mon2Cen!= 0) {
        if (mon2Cen == 1) {
          moneda02.setText(mon2Cen + "");
        } else {
          moneda02.setText(mon2Cen + "");
        }
      }
      
      if(mon1Cen!= 0) {
        if (mon1Cen == 1) {
          moneda01.setText(mon1Cen + "");
        } else {
          moneda01.setText(mon1Cen + "");
        }
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
