package conexionServidor;


import control.Principal;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConexionServidor {


    private Socket socket;
    private String message;
    private PrintWriter out;
    private BufferedReader in;

    private static Principal p;

    public void setP(Principal principal){
        p=principal;
    }
    public void generarConexion(){
        try {
            // Intenta establecer la conexión aquí
            conexion();
            System.out.println("se establecio conexion con el servidor");
            // Si no hay excepciones, la conexión se realizó con éxito
        } catch (Exception ex) {
            // Si hay una excepción, marca la conexión como fallida
            Logger.getLogger(ConexionServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void conexion(){
        String serverHostname = "0.tcp.ngrok.io";
        int port = 12245;
        try {
            try {
                socket = new Socket(serverHostname, port);
                in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(socket.getOutputStream(), true);
                Thread hiloservidor = new Thread(new ServerListen(socket));
                hiloservidor.start();
                System.out.println(hiloservidor.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.err.println("Unknown host: " + serverHostname);
            System.exit(1);
        }
    }
    public BufferedReader getIn() {
        return in;
    }
    public PrintWriter getOut() {
        return out;
    }
}
