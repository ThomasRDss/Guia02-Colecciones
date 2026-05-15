package guia2.ejercicio4;

import java.util.ArrayList;

public class Marca {

    private ArrayList<Concesionario> concesionarios;

    public Marca() {
        this.concesionarios = new ArrayList<>();
    }


    public void agregarConcesionario(Concesionario nuevoConcesionario) {
        this.concesionarios.add(nuevoConcesionario);
    }

    public ArrayList<Vehiculo> mostrarVehiculos() {
        ArrayList<Vehiculo> vehiculosALaVenta = new ArrayList<>();
        for (Concesionario c : concesionarios) {
            vehiculosALaVenta.addAll(c.mostrarVehiculos());
        }
        return vehiculosALaVenta;
    }

    public ArrayList<Concesionario> obtenerConcesionariaMaxVeh() {
        ArrayList<Concesionario> concesionarioMayorV = new ArrayList<>();
        int maxVehiculos = -1;
        for (Concesionario c : concesionarios) {
            int cantActual = c.cantidadDeVehiculosALaVenta();
            if (cantActual > maxVehiculos) {
                maxVehiculos = cantActual;
            }
        }
        for (Concesionario c : concesionarios) {
            if (c.cantidadDeVehiculosALaVenta() == maxVehiculos) {
                concesionarioMayorV.add(c);
            }
        }

        return concesionarioMayorV;
    }

    public void borrarVehiculo(String patente) {
        for (Concesionario concesionario : concesionarios) {
            concesionario.eliminarVehiculo(patente);
        }
    }

    public void cambiarVehiculoDeConcesionaria(String patente, Concesionario concesionarioDestino) {

        for (Concesionario concesionarioActual : concesionarios) {
            Vehiculo vehiculoMover = concesionarioActual.buscarVehiculo(patente);

            if (vehiculoMover != null) {

                concesionarioActual.eliminarVehiculo(patente);

                concesionarioDestino.agregarVehiculo(vehiculoMover);

                System.out.println("Vehículo " + patente + " movido exitosamente.");

            }
        }
        System.out.println("Error: No se encontró ningún vehículo con la patente " + patente);
    }

}
