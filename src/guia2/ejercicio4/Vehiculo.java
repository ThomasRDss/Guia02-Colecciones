package guia2.ejercicio4;

public class Vehiculo {

    private String patente;
    private double precio;
    private TipoDeVehiculo tipoDeAutomovil;

    // Agrega este constructor
    public Vehiculo(String patente, double precio, TipoDeVehiculo tipo) {
        this.patente = patente;
        this.precio = precio;
        this.tipoDeAutomovil = tipo;
    }

    public TipoDeVehiculo getTipoDeAutomovil() {
        return tipoDeAutomovil;
    }

    public String getPatente() {
        return patente;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "patente=" + patente + ", precio=" + precio + ", tipoDeAutomovil=" + tipoDeAutomovil + '}';
    }

}
