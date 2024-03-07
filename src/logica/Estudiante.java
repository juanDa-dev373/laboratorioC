package logica;


import java.util.*;

/**
 * 
 */
public class Estudiante {
    private boolean inicioSeccion;
    private String nombre;
    private String cedula;
    private ArrayList<String> historial;
    private String codigoRegistro;

    public Estudiante(boolean inicioSeccion){
        this.inicioSeccion = inicioSeccion;
    }
    public Estudiante(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        codigoRegistro= "";
        historial= new ArrayList<>();
    }

    public String getCodigoRegistro() {
        return codigoRegistro;
    }

    public void setCodigoRegistro(String codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }

    
    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }
    public void addHistorial(String nombre){
        historial.add(nombre);
    }
    public boolean verificarRequisito(String nom){
        boolean ban= false;
        for (int i =0; i < historial.size();i++){
            if (historial.get(i).equals(nom)){
                ban= true;
            }
        }
        return ban;
    }
    public boolean getInicioSeccion(){
        return inicioSeccion;
    }

    public void setInicioSeccion(boolean inicioSeccion) {
        this.inicioSeccion = inicioSeccion;
    }

    @Override
    public String toString() {
        return "\n"
                + "Nombre = " + nombre 
                + "\nCedula =" + cedula ;
    }
    
}