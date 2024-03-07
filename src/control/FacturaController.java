/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import logica.Bancos;
import logica.nombreMaterias;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class FacturaController implements Initializable {

    private static Principal p;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        p= new Principal();
    }    
    
    public void setP(Principal p){
        FacturaController.p=p;
        inicio();
    }
    @FXML
    private Button pagar;


    @FXML
    private Label valor;

    @FXML
    private ChoiceBox<Bancos> banco;
    
    @FXML
    private Label cantHoras;

    @FXML
    private Label cantSemestre;

    
    @FXML
    void pagar(ActionEvent event) throws Exception {
        boolean ban=false;
        if (banco.getSelectionModel().getSelectedItem().equals(Bancos.Bancolombia)){
            p.getUni().escogerBanco(Bancos.Bancolombia);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Detalles del pago");
            alert.setContentText(p.getUni().getPago().toString());
            alert.showAndWait();
            p.abrirBancolombia();
            ocultar(event);
            
        }else if (banco.getSelectionModel().getSelectedItem().equals(Bancos.Daviplata)){
            p.getUni().escogerBanco(Bancos.Daviplata);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Detalles del pago");
            alert.setContentText(p.getUni().getPago().toString());
            alert.showAndWait();
            p.abrirDaviplata();
            ocultar(event);
            
        }else{
            p.getUni().escogerBanco(Bancos.Avevilla);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Detalles del pago");
            alert.setContentText(p.getUni().getPago().toString());
            alert.showAndWait();
            
            p.abrirAvevilla();
            ocultar(event);
        }
        
    }
    
    ObservableList<Bancos> listaBanco= FXCollections.observableArrayList();
    
    public void inicio(){
        
        listaBanco.addAll(Bancos.values());
        banco.setItems(listaBanco);
        cantHoras.setText("Cantidad de horas en el semestre: "+p.getUni().getRegis().totalHorasSemestre());
        cantSemestre.setText("Intesidad horaria semanal del semestre: "+p.getUni().getRegis().totalIntensidadSemestre());
        valor.setText("El valor de la factura es "+(p.getUni().verificarPago()));
        
    }
    
    
    public void ocultar(Event even) throws Exception{
        Stage stage;
        stage = (Stage)(((Node)(even.getSource())).getScene().getWindow());
        stage.close();
    }
    
}
