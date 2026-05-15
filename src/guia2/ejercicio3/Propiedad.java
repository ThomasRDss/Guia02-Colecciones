package guia2.ejercicio3;

public class Propiedad {

    private String domicilio;
    private double precio;
    private TipoDePropiedad tipoDePropiedad;
    private Barrio barrio;

    public Propiedad(String domicilio, double precio, TipoDePropiedad tipoDePropiedad, Barrio barrio) {
        this.domicilio = domicilio;
        this.precio = precio;
        this.tipoDePropiedad = tipoDePropiedad;
        this.barrio = barrio;
    }

    public double getPrecio() {
        return precio;
    }

    public TipoDePropiedad getTipoDePropiedad() {
        return tipoDePropiedad;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    @Override
    public String toString() {
        return "Propiedad{" + "domicilio=" + domicilio + ", precio=" + precio + ", tipoDePropiedad=" + tipoDePropiedad + ", barrio=" + barrio + '}';
    }


}