package guia2.ejercicio3;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        
        System.out.println("=== TEST DE INMOBILIARIA (v2) ===");

        // 1. Instanciamos la inmobiliaria vacía (usa tu nuevo constructor)
        Inmobiliaria miInmobiliaria = new Inmobiliaria();

        // 2. Agregamos las propiedades una por una (requiere el método agregarPropiedad)
        System.out.println("Agregando propiedades al sistema...");
        miInmobiliaria.agregarPropiedad(new Propiedad("Callao 123", 150000.0, TipoDePropiedad.DEPTO, Barrio.RECOLETA));
        miInmobiliaria.agregarPropiedad(new Propiedad("Santa Fe 456", 250000.0, TipoDePropiedad.PH, Barrio.PALERMO));
        miInmobiliaria.agregarPropiedad(new Propiedad("Cabildo 789", 300000.0, TipoDePropiedad.CASA, Barrio.BELGRANO));
        miInmobiliaria.agregarPropiedad(new Propiedad("Coronel Diaz 111", 100000.0, TipoDePropiedad.DEPTO, Barrio.PALERMO));
        System.out.println("¡Propiedades agregadas exitosamente!\n");

        // 3. Probamos el promedio de precios
        System.out.println("--- Promedio de Precios ---");
        double promedio = miInmobiliaria.promedioDePrecio();
        System.out.println("El precio promedio es: $" + promedio + "\n");

        // 4. Probamos las propiedades más económicas
        System.out.println("--- Propiedades más económicas que el promedio ---");
        // Nota: Le pasamos la variable 'promedio' como pide tu firma, 
        // aunque tu método adentro no la use (sigue usando promedioDePrecio())
        ArrayList<Propiedad> economicas = miInmobiliaria.propiedadesMasEconomicas(promedio); 
        
        for (Propiedad prop : economicas) {
            System.out.println("Propiedad económica: $" + prop.getPrecio());
        }
        System.out.println();

        // 5. Probamos contar propiedades por tipo
        System.out.println("--- Cantidad de propiedades por Tipo ---");
        
        // Usamos la nueva versión de tu método que sí recibe el Enum
        int cantDeptos = miInmobiliaria.cantidadDePropiedadesSegunTipo(TipoDePropiedad.DEPTO);
        int cantCasas = miInmobiliaria.cantidadDePropiedadesSegunTipo(TipoDePropiedad.CASA);
        
        System.out.println("Cantidad de Departamentos: " + cantDeptos + " (Deberían ser 2)");
        System.out.println("Cantidad de Casas: " + cantCasas + " (Debería ser 1)");

    }
}