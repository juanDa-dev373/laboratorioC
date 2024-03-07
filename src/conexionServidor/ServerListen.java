package conexionServidor;


import control.PortalController;
import control.Principal;
import logica.BaseDatos;
import logica.Estudiante;
import logica.InicioSeccion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerListen implements  Runnable{
    private final Socket socket;
    private BufferedReader in;
    private String message;
    private Principal p;

    public ServerListen(Socket socket,Principal principal) {
        this.socket = socket;
        p = principal;
        try {
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {

            while (socket.isConnected() && (message = in.readLine()) != null) {
                System.out.println("Server: " + message);
                String ms[] = message.split(":");
                if(ms[0].equalsIgnoreCase("estudiante")){

                    p.getUni().getDato().getListaEstudiantes().add(new Estudiante(ms[1], ms[2]));
                    System.out.println("Se registro el CLiente");
                }

        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
