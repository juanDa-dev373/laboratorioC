package control;


import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.*;

import conexionServidor.ConexionServidor;
import logica.BaseDatos;
import logica.InicioSeccion;
import logica.Universidad;
import logica.nombreMaterias;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author ACER
 */
public class Principal extends Application {
    
    FondoPanel fondo = new FondoPanel();
    public ConexionServidor conexionServidor;
    private Universidad uni;
    private InicioSeccion inicio;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/vista/Portal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public  ConexionServidor getConexionServidor() {
        return conexionServidor;
    }

    /**
     * Este metodo muestra las ventanas
     * @return
     * @throws IOException 
     */
    public void abrirMaterias() throws Exception {
       
        MateriasController mat= (MateriasController)abrirVentana("/vista/Materias.fxml").getController();
        mat.setP(this);
    }
    
    /**
     * Este metodo muestra las ventanas
     * @return
     * @throws IOException 
     */
    public void abrirFactura() throws Exception {
       
        FacturaController mat= (FacturaController)abrirVentana("/vista/Factura.fxml").getController();
        mat.setP(this);
        
    }
    
    
    /**
     * Este metodo muestra las ventanas
     * @return
     * @throws IOException 
     */
    public void abrirPortal() throws Exception {
        PortalController mat= (PortalController)abrirVentana("/vista/Portal.fxml").getController();
        mat.setP(this);
        
    }
    
    /**
     * Este metodo muestra las ventanas
     * @return
     * @throws IOException 
     */
     public void abrirDaviplata() throws Exception {
        
        BancosController mat= (BancosController)abrirVentana("/vista/Daviplata.fxml").getController();
        mat.setP(this);
        
    }
     
     
     /**
     * Este metodo muestra las ventanas
     * @return
     * @throws IOException 
     */
    public void abrirAvevilla() throws Exception {
          
        BancosController mat= (BancosController)abrirVentana("/vista/Avevilla.fxml").getController();
        mat.setP(this);
        
    }
    
    /**
     * Este metodo muestra las ventanas
     * @return
     * @throws IOException 
     */
    public void abrirBancolombia() throws Exception {
        BancosController mat= (BancosController)abrirVentana("/vista/Bancolombia.fxml").getController();
        mat.setP(this);
    }
    
    
    /**
     * Este metodo muestra las ventanas
     *
     * @return
     * @throws IOException 
     */
    public void abrirLobby() throws Exception {
        LobbyController mat= (LobbyController)abrirVentana("/vista/Lobby.fxml").getController();
        mat.setP(this);
    }
    
    /**
     * Este metodo muestra las ventanas
     * @param ulr
     * @return
     * @throws IOException 
     */
    public  FXMLLoader abrirVentana(String ulr) throws IOException{
        FXMLLoader fxmllLoader= new FXMLLoader(getClass().getResource(ulr));
        Parent root = (Parent)fxmllLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        return fxmllLoader;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Default constructor
     */
    public Principal() {
        uni= new Universidad();
        this.setContentPane(fondo);
        conexionServidor = new ConexionServidor();
        conexionServidor.setP(this);
    }

    public Universidad getUni() {
        return uni;
    }

    private void setContentPane(FondoPanel fondo) {
        
    
    }

    public InicioSeccion getInicio() {
        return inicio;
    }

    class FondoPanel extends JPanel
            {
    private Image imagen;
    
    @Override
    public void paint(Graphics g)
    {
       imagen = new ImageIcon(getClass().getResource("/Imagen/abstract-blue-geometric-shapes-background_1035-17545.jpg")).getImage();
       
       g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
       
        setOpaque(false);
        
        super.paint(g);
    }
   
}

}

