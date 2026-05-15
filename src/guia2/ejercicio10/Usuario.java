package guia2.ejercicio10;

import java.util.ArrayList;

public class Usuario {

    private String nombre;
    private Estado estado;

    public Usuario(String nombre, Estado estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

}
