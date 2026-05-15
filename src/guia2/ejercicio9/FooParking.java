package guia2.ejercicio9;

import java.util.ArrayList;

public class FooParking {

    private ArrayList<Garaje> garajes;

    public FooParking() {
        this.garajes = new ArrayList<Garaje>();
    }
    
    public ArrayList<String> obtenerInformeEstadoGarajes() {
        ArrayList<String> listaDetallada = new ArrayList<String>();
        for (int i = 0; i < garajes.size(); i++) {
            listaDetallada.add(garajes.get(i).obtenerInformeEstadoGaraje());
        }
        return listaDetallada;
    }
    
    public void mostrarVehiculosSinLlave() {
        System.out.println("=== REPORTE DE VEHÍCULOS SIN LLAVE EN TABLERO ===");

        for (int i = 0; i < garajes.size(); i++) {
            Garaje garajeActual = garajes.get(i);
            garajeActual.mostrarVehiculosEstacionadosSinLLave();
        }
    }

    void agregarGaraje(Garaje garaje) {
        garajes.add(garaje);
    }

    
}