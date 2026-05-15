package guia2.ejercicio3;

import java.util.ArrayList;

public class Inmobiliaria {

    private ArrayList<Propiedad> propiedades;

    public Inmobiliaria() {
        this.propiedades = new ArrayList<>();
    }

// Este método es vital para poder usar la inmobiliaria desde el main
    public void agregarPropiedad(Propiedad nuevaPropiedad) {
        this.propiedades.add(nuevaPropiedad);
    }

    public double promedioDePrecio() {
        return sumatoriaDePrecios() / propiedades.size();
    }

    private double sumatoriaDePrecios() {
        double precioDeSumatoria = 0;
        for (Propiedad propiedad : propiedades) {
            precioDeSumatoria += propiedad.getPrecio();
        }
        return precioDeSumatoria;
    }

    public ArrayList<Propiedad> propiedadesMasEconomicas(double promedioGeneral) {
        ArrayList<Propiedad> propiedadesEconomicas = new ArrayList<>();
        for (Propiedad propiedad : propiedades) {
            if (propiedad.getPrecio() < promedioDePrecio()) {
                propiedadesEconomicas.add(propiedad);
            }
        }
        return propiedadesEconomicas;
    }

    public int cantidadDePropiedadesSegunTipo(TipoDePropiedad tipo) {
        int cantidadTotal = 0;
        for (Propiedad propiedad : propiedades) {
            if (propiedad.getTipoDePropiedad().equals(tipo)) {
                cantidadTotal++;
            }
        }
        return cantidadTotal;
    }

    @Override
    public String toString() {
        return "Inmobiliaria{" + "propiedades=" + propiedades + '}';
    }

}
