package logica;


import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * 
 */
public class DetalleRegistro {

    private ArrayList<Materia> listaMateriaR;
    private String codigoRegistro;
    private String fechaRegistro;
    private String horaRegistro;
    private BaseDatos dato;
    
    public DetalleRegistro() {
        this.listaMateriaR = new ArrayList();
        LocalDateTime fechaHoy= LocalDateTime.now();
        String fecha=""+ (fechaHoy);
        String[]fyH= fecha.split(""+(fecha.charAt(10)));
        fechaRegistro= fyH[0];
        horaRegistro= fyH[1];
        generarCodigo();
    }

    
    /**
     * Este metodo agrega una materia a la lista de materias
     * @param materia 
     */
    public void agregarMateria(Materia materia ) {
        this.listaMateriaR.add(materia);
    }

    /**
     * Este metodo genera los el codigo del registro
     */
    private void generarCodigo(){
        codigoRegistro= "";
        dato=new BaseDatos();
        for (int i= 0; i <4; i ++){
            codigoRegistro+= (int)(Math.random()*10);
        }
        
    }
    
    /**
     * Este metodo retorna el numero total de creditos que registro
     * @return 
     */
    public int totalCreditos() {
        int sum=0;
        for (int i = 0; i < listaMateriaR.size();i++){
            sum+= listaMateriaR.get(i).getCreditos();
        }
        return sum;
    }

    /**
     *  Este metodo retorna el total de intencidad semanal del registro
     * @return 
     */
    public int totalIntensidadSemanal() {
        int sum= 0;
        for (int i = 0; i < listaMateriaR.size();i++){
            sum+= listaMateriaR.get(i).getIntesidadSemanal();
        }
        return sum;
    }
    
    /**
     * Este medoto devuelve la cantidad de horas en el semestre
     * @return 
     */
    public int totalHorasSemestre(){
        return totalCreditos()*48;
    }
    
    /**
     * Este medoto devuelve la cantidad horaria semanal en el semestre
     * @return 
     */
    public int totalIntensidadSemestre(){
        
        return totalIntensidadSemanal()*16;
    }
    /**
     * Este metodo verifica que cumpla el numero de materias precticas que se pueden registrar
     * @return 
     */
    public boolean cumpleNpractico(){
        boolean ban=false;
        int sum=0;
        for (int i = 0; i < listaMateriaR.size();i++){
            if (listaMateriaR.get(i) instanceof Practico){
                sum ++;
            }
        }
        if (sum <= 2){
            ban=true;
        }
        return ban;
    }

    public ArrayList<Materia> getListaMateriaR() {
        return listaMateriaR;
    }

    public String getCodigoRegistro() {
        return codigoRegistro;
    }
    
    
    @Override
    public String toString() {
        return "\nDetalle del Registro\n"+
               "Codigo del Registro = " + codigoRegistro + 
               "\nFecha del Registro = " + fechaRegistro + 
               "\nHora de Registro = " + horaRegistro
                +"\nMaterias Registradas \n" + 
                listaMateriaR + "\n";
    }

    
}