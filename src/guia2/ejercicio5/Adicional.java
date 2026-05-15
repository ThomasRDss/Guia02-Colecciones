package guia2.ejercicio5;

import java.time.LocalDate;

public class Adicional {

    private double precio;
    private LocalDate fechaPrestacion;
    private TipoDeAdicional tipoDeAdicional;

    public Adicional(double precio, TipoDeAdicional tipoDeAdicional) {
        this.precio = precio;
        this.tipoDeAdicional = tipoDeAdicional;
    }

    public double getPrecio() {
        return precio;
    }

}