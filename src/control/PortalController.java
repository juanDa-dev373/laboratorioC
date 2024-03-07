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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import conexionServidor.ConexionServidor;
import logica.BaseDatos;
import logica.Estudiante;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class PortalController implements Initializable {

    private static Principal p;
    private static BaseDatos bd;
    private Estudiante estudiante;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        p= new Principal();
        bd = new BaseDatos();
        p.getConexionServidor().generarConexion();

    }    
    
    
    @FXML
    private TextField cedula;

    @FXML
    private TextField nombre;

    @FXML
    private Button boton;

    private String message;

    @FXML
    void eventoBoton(ActionEvent event) throws Exception {
        String nom=nombre.getText();
        nombre.setText("");
        String ced=cedula.getText();
        cedula.setText("");
        p.getConexionServidor().getOut().println("inicio:"+nom+":"+ced);
        System.out.println();
        if ( true){
            System.out.println("Seccion iniciado con exito");

            
            ocultar(event);
            p.abrirLobby();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Datos erronios");
            alert.setContentText("Los datos ingresados son erronios, vuelva a ingresarlos");
            alert.showAndWait();
            
        }
        
    }
    
    public static void setP(Principal p){
        PortalController.p=p;
    }
    
     @FXML
    void eventoSalir(ActionEvent event) throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Salir");
        alert.setContentText("Gracias por usar este progama ");
        alert.showAndWait();
        p.getConexionServidor().getOut().println("exit");
        ocultar(event);

    }
    public void ocultar(Event even) throws Exception{
        Stage stage;
        stage = (Stage)(((Node)(even.getSource())).getScene().getWindow());
        stage.close();
    }
    
}
