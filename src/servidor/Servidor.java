package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private Socket socket;
    private ServerSocket SS;
    int port = 5555;
    public static void main(String args[]){
        Servidor servidor = new Servidor();
        servidor.conectarServidor();
    }
    public void conectarServidor(){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Servidor esperando conexiones...");

            // Esperamos a que un cliente se conecte
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado desde: " + clientSocket.getInetAddress().getHostAddress());

            // Creamos los streams de entrada y salida para comunicarnos con el cliente
            PrintWriter outToClient = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Creamos un thread para leer los mensajes del cliente continuamente
            Thread clientInputThread = new Thread(() -> {
                try {
                    String clientMessage;
                    while ((clientMessage = inFromClient.readLine()).equalsIgnoreCase("exit")) {
                        System.out.println("Cliente: " + clientMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            clientInputThread.start();

            // Creamos un BufferedReader para leer la entrada del usuario desde la consola
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            // Leemos los mensajes desde la consola y los enviamos al cliente
            String consoleMessage;
            while ((consoleMessage = consoleReader.readLine()) != null) {
                outToClient.println(consoleMessage);
            }

            // Cerramos los streams y el socket
            outToClient.close();
            inFromClient.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
