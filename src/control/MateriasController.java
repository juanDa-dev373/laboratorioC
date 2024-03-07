/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logica.Materia;
import logica.Teorico;
import logica.nombreMaterias;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class MateriasController implements Initializable {

    private static Principal p;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        p= new Principal();
        lista= p.getUni().getDato().getListaMateria();
        agragarOpciones();
    }    
    
    public static void setP(Principal p){
        MateriasController.p=p;
    }
    
    
    @FXML
    private TableColumn<Materia, Integer> intensidad;

    @FXML
    private VBox contenedor;

    @FXML
    private TableColumn<?, ?> selecion;

    @FXML
    private Button botonSalir;

    @FXML
    private TableView<Materia> tablaMaterias;

    @FXML
    private TableColumn<Materia, Integer> creditos;

    @FXML
    private TableColumn<Materia,String> nombre;

    @FXML
    private Button botonRegistrar;

    private ArrayList<Materia> lista;   
    @FXML
    void eventoBoton(ActionEvent event) throws Exception {
        boolean ban=true;
        int pos= 0;
        for (int i = 0; i< lista.size();i++){
            if (lista.get(i).getSelecion().isSelected()){
                if(lista.get(i)instanceof Teorico){
                    if(p.getUni().getEstu().verificarRequisito(((Teorico)p.getUni().consultarDatos(lista.get(i).getNombre())).getPrerrequisito())){
                        p.getUni().agragarMateria(lista.get(i).getNombre());
                    }else{
                        pos=i;
                        ban = false;
                    }
                }else{
                    p.getUni().agragarMateria(lista.get(i).getNombre());
                }
            }
        }
         if (ban == false){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("NO CUMPLE EL PREREQUISITO");
                        alert.setContentText("No cumple el prerequisito de la materia "+lista.get(pos).getNombre()
                        +" '"+((Teorico)p.getUni().consultarDatos(lista.get(pos).getNombre())).getPrerrequisito()+"' "
                                + "Por favor escoja otra materia");
                        alert.showAndWait();
                        p.getUni().borrarLista();
         }else if(p.getUni().verificarPago()==0){
             
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("No cumple los requisitos");
            String msg= "Es de anotar que, por politicas pedagógicas, los estudiantes No pueden registrar menos de "
                    + "12 creditos y mas de 20, y que solo pueden registrar 2 asinaturas Precticas";
            if(ban==false){
                msg+= "\nAlguna materia no cumple con el prerrequisito ";
            }
            alert.setContentText(msg);
            p.getUni().borrarLista();
            alert.showAndWait();
         }else{
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("RESGISTRO EXITOSO");
            alert.setContentText(p.getUni().getRegis().toString());
            alert.showAndWait(); 
            p.getUni().getEstu().setCodigoRegistro(p.getUni().getRegis().getCodigoRegistro());
            p.abrirFactura();
            ocultar(event);
         }
    }

    @FXML
    void eventoSalir(ActionEvent event) throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Cerrar sesion");
        alert.setContentText("Gracias por usar este progama "+p.getUni().getEstu().getNombre());
        alert.showAndWait(); 
        p.abrirLobby();
        ocultar(event);
    }
    
    public void agragarOpciones(){
        selecion.setCellValueFactory(new PropertyValueFactory<>("selecion"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        creditos.setCellValueFactory(new PropertyValueFactory<>("creditos"));
        intensidad.setCellValueFactory(new PropertyValueFactory<>("intesidadSemanal"));
        tablaMaterias.getItems().addAll(lista);
        
    }
    
    
    public void ocultar(Event even) throws Exception{
        Stage stage;
        stage = (Stage)(((Node)(even.getSource())).getScene().getWindow());
        stage.close();
    }
    
    
}