package thread;
import logica.BaseDatos;
import logica.Practico;
import logica.Teorico_Practico;
import logica.Universidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private final Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;
    private String message;
    private Universidad uni;
    private BaseDatos bd;
    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            uni = new Universidad();
            bd = new BaseDatos();
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out= new PrintWriter(clientSocket.getOutputStream(), true);
            while (clientSocket.isConnected() && (message = in.readLine()) != null) {
                System.out.println("Client: " + message);
                String [] mg=message.split(":");
                if(!mg[0].equalsIgnoreCase("exit")){
                    if(mg[0].equalsIgnoreCase("inicio")){
                        for(int i = 0; i < bd.getListaEstudiantes().size(); i++){
                            if(mg[1].equalsIgnoreCase(bd.getListaEstudiantes().get(i).getNombre()) && mg[2].equalsIgnoreCase(bd.getListaEstudiantes().get(i).getCedula())){
                                out.println("Estudiante:"+bd.getListaEstudiantes().get(i).getNombre()+":"+bd.getListaEstudiantes().get(i).getCedula());
                            }
                        }
                    }else if(mg[0].equalsIgnoreCase("materia")){
                        for(int i = 0; i<bd.getListaMateria().size(); i++){
                            if(bd.getListaMateria().get(i) instanceof Practico){
                                out.println("materia:practico:"+ bd.getListaMateria().get(i));
                            } else if (bd.getListaMateria().get(i) instanceof Teorico_Practico) {
                                out.println("materia:teorico_practico:"+ bd.getListaMateria().get(i));
                            }else {
                                out.println("materia:teorico:"+ bd.getListaMateria().get(i));
                            }
                        }
                        System.out.println("Materias enviadas");
                    }
                }else{
                    break;
                }
            }
            System.out.println("cerrando Socket");
            clientSocket.close();
            System.out.println("Socket cerrado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getMessage() {
        return message;
    }
}
