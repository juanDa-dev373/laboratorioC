package logica;


/**
 * 
 */
public class Practico extends Materia {

    private int cantLaboratorios;

    public Practico(int cantLaboratorios, String codigo, nombreMaterias nombre, int creditos, int intesidadSemanal) {
        super(codigo, nombre, creditos, intesidadSemanal);
        this.cantLaboratorios = cantLaboratorios;
    }

    
    public int getCantLaboratorios() {
        return cantLaboratorios;
    }

    @Override
    public String toString() {
        return "Tipo = Practico, "
                + "Cantidadad de Laboratorios = " + cantLaboratorios ;
    }

    
}