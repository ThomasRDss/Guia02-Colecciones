package guia2.ejercicio7;

import java.util.ArrayList;

public class Alumno {

    private String nombre;
    private String mail;
    private ArrayList<MateriaAprobada> materiasAprobadas;

    public Alumno(String nombre, String mail) {
        this.nombre = nombre;
        this.mail = mail;
        this.materiasAprobadas = new ArrayList<MateriaAprobada>();
    }

    public void agregarMateriaAprobada(MateriaAprobada materia) {
        materiasAprobadas.add(materia);
    }
    
    public String retornarDatos(){
        return nombre + " " + mail;
    }

    public double obtenerPromedio() {
        final double SIN_PROMEDIO = 0;
        double promedio = SIN_PROMEDIO;
        double acumulador = SIN_PROMEDIO;
        for (MateriaAprobada materiaAprobada : materiasAprobadas) {
            acumulador += materiaAprobada.getNotaFinal();
        }
        promedio = acumulador / cantidadDeMateriasAprobadas();
        return promedio;
    }

    public double cantidadDeMateriasAprobadas() {
        return materiasAprobadas.size();
    }
}
