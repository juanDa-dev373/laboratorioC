package logica;


/**
 * 
 */
public class Teorico extends Materia {

    private String prerrequisito;

    public Teorico(String codigo, nombreMaterias nombre, int creditos, int intesidadSemanal,String requisito) {
        super(codigo, nombre, creditos, intesidadSemanal);
        prerrequisito= requisito;
    }

    
   
    public String getPrerrequisito() {
        return prerrequisito;
    }
    
    @Override
    public String toString() {
        return "Tipo = Teorico,"
                + "Prerrequisito = " + prerrequisito;
    }
    
}