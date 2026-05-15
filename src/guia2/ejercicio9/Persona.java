package guia2.ejercicio9;

public class Persona {

    private String nombreCompleto;
    private String DNI;

    public Persona(String nombreCompleto, String DNI) {
        this.nombreCompleto = nombreCompleto;
        this.DNI = DNI;
    }

    public String getDNI() {
        return DNI;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombreCompleto=" + nombreCompleto + ", DNI=" + DNI + '}';
    }

    
}