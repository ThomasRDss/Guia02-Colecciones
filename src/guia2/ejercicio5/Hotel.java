package guia2.ejercicio5;

import java.util.ArrayList;

public class Hotel {

    private String nombre;
    private String direccion;
    private ArrayList<Habitacion> habitaciones;

    public Hotel(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.habitaciones = new ArrayList<Habitacion>();
    }

    public void agregarHabitacion(Habitacion habitacionAAgregar) {
        habitaciones.add(habitacionAAgregar);
    }

    public ArrayList<Habitacion> obtenerHabitacionesDisponibles() {
        ArrayList<Habitacion> habitacionesDisponibles = new ArrayList<Habitacion>();
        for (Habitacion habitacion : habitaciones) {
            if (!habitacion.consultarDisponibilidad()) {
                habitacionesDisponibles.add(habitacion);
            }
        }
        return habitacionesDisponibles;
    }

    public double realizarCheckout(int numeroDeHabitacion) {
        final int VALOR_DE_NO_ES_POSIBLE_HACER_CHECKOUT = -1;
        double montoTotal = VALOR_DE_NO_ES_POSIBLE_HACER_CHECKOUT;
        Habitacion habEncontrada = buscarHabitacion(numeroDeHabitacion);
        if (habEncontrada != null && habEncontrada.consultarDisponibilidad()) {
            montoTotal = habEncontrada.calcularTotal();
        }
        return montoTotal;
    }

    private Habitacion buscarHabitacion(int numeroDeHabitacion) {
    int i = 0;
    Habitacion encontrada = null;

    while (i < habitaciones.size() && encontrada == null) {
        if (habitaciones.get(i).obtenerNumeroDeHabitacion() == numeroDeHabitacion) {
            encontrada = habitaciones.get(i); 
        }
        i++;
    }
    return encontrada;
}
}
