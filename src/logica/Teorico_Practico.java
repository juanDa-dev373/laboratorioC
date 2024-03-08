package logica;


/**
 * 
 */
public class Teorico_Practico extends Materia {

    private int horasTeoria;
    private int horasPractica;

    public Teorico_Practico(int horasTeoria, int horasPractica, String codigo, nombreMaterias nombre, int creditos, int intesidadSemanal) {
        super(codigo, nombre, creditos, intesidadSemanal);
        this.horasTeoria = horasTeoria;
        this.horasPractica = horasPractica;
    }

    
    public int getHorasTeoria() {
        return horasTeoria;
    }

    public int getHorasPractica() {
        return horasPractica;
    }

    @Override
    public String toString() {
        return "Tipo = Teorico_Practico,"
                + "Horas Teoria = " + horasTeoria 
                + ",Horas Practica = " + horasPractica;
    }
    
    
    
}