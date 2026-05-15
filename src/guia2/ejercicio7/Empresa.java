package guia2.ejercicio7;

import java.util.ArrayList;

public class Empresa {

    private ArrayList<Alumno> listaDeAlumnos;
    private final int CANTIDAD_MAXIMA_CANDIDATOS = 20;

    public Empresa() {
        this.listaDeAlumnos = new ArrayList<Alumno>();
    }

    public void agregarAlumno(Alumno alumno) {
        listaDeAlumnos.add(alumno);
    }

    public String[] obtenerCandidatos(double promedioMinimo) {
        String[] candidatosPosibles = new String[CANTIDAD_MAXIMA_CANDIDATOS];

        int indiceCandidatos = 0;
        int i = 0;
        final int MINIMO_MATERIAS_APROBADAS = 5;

        while (i < listaDeAlumnos.size() && indiceCandidatos < CANTIDAD_MAXIMA_CANDIDATOS) {

            Alumno alu = listaDeAlumnos.get(i);

            if (alu.obtenerPromedio() >= promedioMinimo && alu.cantidadDeMateriasAprobadas() >= MINIMO_MATERIAS_APROBADAS) {
                candidatosPosibles[indiceCandidatos] = alu.retornarDatos();
                indiceCandidatos++;
            }

            i++; 
        }

        return candidatosPosibles;
    }
}
