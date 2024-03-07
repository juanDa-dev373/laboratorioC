/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import logica.Bancos;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class BancosController implements Initializable {

    private static Principal p;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        p = new Principal();
    }

    public void setP(Principal p) {
        BancosController.p = p;

    }

    @FXML
    private Button pagar;

    @FXML
    void eventoBoton(ActionEvent event) throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Detalles del pago");
        alert.setContentText("El pago fue un exito");
        alert.showAndWait();
        p.abrirLobby();
        ocultar(event);

    }

    public void ocultar(Event even) throws Exception {
        Stage stage;
        stage = (Stage) (((Node) (even.getSource())).getScene().getWindow());
        stage.close();
    }
}
