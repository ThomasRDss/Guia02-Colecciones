package guia2.ejercicio7;

public class MateriaAprobada {

    private String nombre;
    private double notaFinal;

    public MateriaAprobada(String nombre, double notaFinal) {
        this.nombre = nombre;
        this.notaFinal = notaFinal;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

}