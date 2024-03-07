package logica;


import java.util.*;
import java.time.LocalDate;
/**
 * Se guardan los datos de el pago realizado por el estudiante
 */
public class DetallesPago {
    private String fecha;
    private Bancos banco;
    private Estudiante estudiante;
    private DetalleRegistro registro;

    public DetallesPago(Bancos banco, Estudiante estudiante, DetalleRegistro registro) {
        LocalDate fechaHoy= LocalDate.now();
        this.fecha = ""+fechaHoy;
        this.banco = banco;
        this.estudiante = estudiante;
        this.registro = registro;
    }

    @Override
    public String toString() {
        return "Detalles de Pago\n"
                + "Fecha = " + fecha 
                + "\nBanco = " + banco 
                + "\nEstudiante " + estudiante
                + "\nCodigo de Registro = "+registro.getCodigoRegistro();
    }

    
}