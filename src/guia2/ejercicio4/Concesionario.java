package guia2.ejercicio4;

import java.util.ArrayList;

public class Concesionario {

    private String nombre;
    private ArrayList<Vehiculo> vehiculos;

    public Concesionario(String nombre) {
        this.nombre = nombre;
        this.vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo nuevoVehiculo) {
        this.vehiculos.add(nuevoVehiculo);
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Vehiculo> mostrarVehiculos(TipoDeVehiculo tipodevehiculo) {
        ArrayList<Vehiculo> vehiculosXTipo = new ArrayList<>();
        for (Vehiculo v : vehiculos) {
            if (v.getTipoDeAutomovil().equals(tipodevehiculo)) {
                vehiculosXTipo.add(v);
            }
        }
        return vehiculosXTipo;
    }

    public ArrayList<Vehiculo> mostrarVehiculos() {
        ArrayList<Vehiculo> todosLosVehiculos = new ArrayList<>();
        for (Vehiculo v : vehiculos) {
            todosLosVehiculos.add(v);
        }
        return todosLosVehiculos;
    }

    public int cantidadDeVehiculosALaVenta() {
        return vehiculos.size();
    }

    public Vehiculo buscarVehiculo(String patente) {
        Vehiculo vehiculoEncontrado = null;
        for (Vehiculo vehiculo : vehiculos) {
            if (patente.equals(vehiculo.getPatente())) {
                vehiculoEncontrado = vehiculo;
            }
        }
        return vehiculoEncontrado;
    }

    public void eliminarVehiculo(String patente) {
        if (buscarVehiculo(patente) != null) {
            vehiculos.remove(buscarVehiculo(patente));
        }
    }

    @Override
    public String toString() {
        return "Concesionario{" + "nombre=" + nombre + ", vehiculo=" + vehiculos + '}';
    }

}
