package servidor;
import thread.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private Socket socket;
    private ServerSocket SS;
    int port = 4000  ;
    public static void main(String args[]){
        Servidor servidor = new Servidor();
        servidor.conectarServidor();
    }
    public void conectarServidor(){
        try {
            SS = new ServerSocket(port);
            System.out.println("Server is running...");

            while(true){
                // Esperar la conexión del cliente
                socket = SS.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress().toString());
                // Crear y ejecutar un hilo para manejar la comunicación con el cliente
                Thread clientThread = new Thread(new ClientHandler(socket));
                clientThread.start();


                // Crear y ejecutar un hilo para manejar la entrada del servidor
                //Thread serverHilo = new Thread(new ServerInputHandler(socket));
                //serverHilo.start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
