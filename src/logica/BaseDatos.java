package logica;


import java.util.ArrayList;

/**
 * Base de datos de la universidad donde guarda la informacion de los estudiantes y las materias
 */
public class BaseDatos {


    private ArrayList<Materia> listaMateria;

    public ArrayList<DetallesPago> detallesPagos;

    public ArrayList<DetalleRegistro> listaDetallesRegistros;

    public ArrayList<Estudiante> listaEstudiantes;
    public BaseDatos() {
        listaMateria= new ArrayList ();
        detallesPagos=  new ArrayList ();
        listaDetallesRegistros=  new ArrayList ();
        listaEstudiantes= new ArrayList();
        //materias
        addListaMateria(new Practico(10,"c4",nombreMaterias.Calculo,4,5));
        addListaMateria(new Teorico("P0",nombreMaterias.Programacion,4,5,"Logica de Programacion"));
        addListaMateria(new Teorico_Practico(10,7,"M3",nombreMaterias.Matematica,4,5));
        addListaMateria(new Practico(10,"I5",nombreMaterias.Introduccion,4,5));
        addListaMateria(new Teorico_Practico(10, 7, "F6", nombreMaterias.Fisica, 4, 4));
        addListaMateria(new Teorico("V7", nombreMaterias.Vectorial,4, 5, "Calculo"));
        addListaMateria(new Practico(10, "LP1", nombreMaterias.LogicaDeProgramacion, 4, 5));
        
        addListaEstudiantes(new Estudiante("JUAN","2222"));
        addListaEstudiantes(new Estudiante("DAVID","1111"));
        listaEstudiantes.get(1).addHistorial("Logica de Programacion");
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void addListaEstudiantes(Estudiante estudiantes) {
        this.listaEstudiantes.add(estudiantes);
    }

    public ArrayList<Materia> getListaMateria() {
        return listaMateria;
    }

    private void addListaMateria(Materia listaMateria) {
        this.listaMateria.add(listaMateria);
    }

    public ArrayList<DetallesPago> getDetallesPagos() {
        return detallesPagos;
    }

    public void addDetallesPagos(DetallesPago detallesPagos) {
        this.detallesPagos.add(detallesPagos);
    }

    public ArrayList<DetalleRegistro> getListaDetallesRegistros() {
        return listaDetallesRegistros;
    }

    public void addListaDetallesRegistros(DetalleRegistro listaDetallesRegistros) {
        this.listaDetallesRegistros.add(listaDetallesRegistros);
    }
    
    
}