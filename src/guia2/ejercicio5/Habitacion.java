package guia2.ejercicio5;

import java.util.ArrayList;

public class Habitacion {

    private int numero;
    private double precioPorDia;
    private boolean estaOcupado;
    private String nombreDelCliente;
    private int cantidadDiasEstadia;
    private ArrayList<Adicional> adicionales;

    public Habitacion(int numero, double precioPorDia) {
        this.numero = numero;
        this.precioPorDia = precioPorDia;
        this.adicionales = new ArrayList<Adicional>();
    }

    public void agregarAdicionales(Adicional adicionalAAgregar) {
        adicionales.add(adicionalAAgregar);
    }

    public boolean consultarDisponibilidad() {
        return estaOcupado;
    }

    public int obtenerNumeroDeHabitacion() {
        return numero;
    }

    public double calcularTotal() {
        return ((precioPorDia * cantidadDiasEstadia) + obtenerPrecioDeAdicionales());
    }

    private double obtenerPrecioDeAdicionales() {
        double totalAdicionales = 0;
        for (Adicional adicional : adicionales) {
            totalAdicionales += adicional.getPrecio();
        }
        return totalAdicionales;
    }

    public void ocuparHabitacion(String nombre, int dias) {
        this.estaOcupado = true;
        this.nombreDelCliente = nombre;
        this.cantidadDiasEstadia = dias;
    }

    @Override
    public String toString() {
        return "Habitación " + numero + " | Ocupada: " + estaOcupado + " | Cliente: " + nombreDelCliente;
    }
}
