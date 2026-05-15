package guia2.ejercicio8;

public class Pieza {

    private String nombre;
    private boolean operativa;
    
    public Pieza(String nombre, boolean operativa) {
        this.nombre = nombre;
        this.operativa = operativa;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isOperativa() {
        return operativa;
    }

    @Override
public String toString() {
    return nombre; 
}

}