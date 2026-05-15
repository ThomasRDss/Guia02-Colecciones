package guia2.ejercicio4;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        
        System.out.println("=== SISTEMA DE GESTIÓN DE MARCA Y CONCESIONARIAS ===\n");

        // 1. Creamos la Marca general[cite: 17]
        Marca miMarca = new Marca();

        // 2. Creamos 3 Concesionarias distintas[cite: 21]
        Concesionario conceNorte = new Concesionario("Sucursal Norte");
        Concesionario conceSur = new Concesionario("Sucursal Sur");
        Concesionario conceOeste = new Concesionario("Sucursal Oeste");

        miMarca.agregarConcesionario(conceNorte); //[cite: 17]
        miMarca.agregarConcesionario(conceSur); //[cite: 17]
        miMarca.agregarConcesionario(conceOeste); //[cite: 17]

        // 3. Creamos un buen lote de vehículos[cite: 20]
        System.out.println("--- Ingresando vehículos a las sucursales ---");
        
        // Sucursal Norte (Tendrá 4 vehículos)
        conceNorte.agregarVehiculo(new Vehiculo("AAA-111", 15000, TipoDeVehiculo.AUTO));
        conceNorte.agregarVehiculo(new Vehiculo("BBB-222", 25000, TipoDeVehiculo.CAMIONETA));
        conceNorte.agregarVehiculo(new Vehiculo("CCC-333", 12000, TipoDeVehiculo.UTILITARIO));
        conceNorte.agregarVehiculo(new Vehiculo("DDD-444", 18000, TipoDeVehiculo.AUTO));

        // Sucursal Sur (Tendrá 4 vehículos - ¡Empate con la Norte!)
        conceSur.agregarVehiculo(new Vehiculo("EEE-555", 22000, TipoDeVehiculo.CAMIONETA));
        conceSur.agregarVehiculo(new Vehiculo("FFF-666", 14000, TipoDeVehiculo.AUTO));
        conceSur.agregarVehiculo(new Vehiculo("GGG-777", 26000, TipoDeVehiculo.CAMIONETA));
        conceSur.agregarVehiculo(new Vehiculo("HHH-888", 13500, TipoDeVehiculo.UTILITARIO));

        // Sucursal Oeste (Tendrá 2 vehículos)
        conceOeste.agregarVehiculo(new Vehiculo("III-999", 19000, TipoDeVehiculo.AUTO));
        conceOeste.agregarVehiculo(new Vehiculo("JJJ-000", 21000, TipoDeVehiculo.UTILITARIO));

        System.out.println("Carga inicial completada con éxito.\n");

        // --- TEST B: mostrarVehiculos de la Marca ---
        System.out.println("--- TEST B: Todos los vehículos a la venta en la Marca ---");
        ArrayList<Vehiculo> todosLosVehiculos = miMarca.mostrarVehiculos(); //[cite: 17]
        for (Vehiculo v : todosLosVehiculos) {
            System.out.println(" - " + v.toString()); //[cite: 20]
        }
        System.out.println("Total en toda la marca: " + todosLosVehiculos.size() + " (Deberían ser 10)\n");

        // --- TEST D: Concesionarias con más vehículos (Prueba de empate) ---
        System.out.println("--- TEST D: Sucursales con más vehículos ---");
        ArrayList<Concesionario> lasMasLlenas = miMarca.obtenerConcesionariaMaxVeh(); //[cite: 17]
        System.out.println("Deberían aparecer Norte y Sur (ambas tienen 4):");
        for (Concesionario c : lasMasLlenas) {
            System.out.println(" -> " + c.getNombre() + " con " + c.cantidadDeVehiculosALaVenta() + " vehículos."); //[cite: 21]
        }
        System.out.println();

        // --- TEST F: Mover un vehículo ---
        System.out.println("--- TEST F: Movimiento de Inventario ---");
        System.out.println("Moviendo la camioneta EEE-555 (del Sur) hacia la sucursal Oeste...");
        // Movemos de Sur a Oeste
        miMarca.cambiarVehiculoDeConcesionaria("EEE-555", conceOeste); //[cite: 17]
        
        System.out.println("Vehículos actuales en Sur: " + conceSur.cantidadDeVehiculosALaVenta() + " (Deberían ser 3)"); //[cite: 21]
        System.out.println("Vehículos actuales en Oeste: " + conceOeste.cantidadDeVehiculosALaVenta() + " (Deberían ser 3)\n"); //[cite: 21]

        // --- TEST D (Otra vez): Verificamos si cambió el máximo ---
        System.out.println("--- TEST D REVISIÓN: ¿Quién tiene el máximo ahora? ---");
        // Como Sur perdió un auto, Norte (con 4) debería ser ahora la única ganadora absoluta.
        lasMasLlenas = miMarca.obtenerConcesionariaMaxVeh(); //[cite: 17]
        for (Concesionario c : lasMasLlenas) {
            System.out.println(" -> " + c.getNombre() + " con " + c.cantidadDeVehiculosALaVenta() + " vehículos. (Debería ser SOLO Norte)"); //[cite: 21]
        }
        System.out.println();

        // --- TEST E: Borrar Vehículo ---
        System.out.println("--- TEST E: Borrar vehículo (Se vendió el auto AAA-111 de Norte) ---");
        miMarca.borrarVehiculo("AAA-111"); //[cite: 17]
        
        System.out.println("Vehículos actuales en Norte: " + conceNorte.cantidadDeVehiculosALaVenta() + " (Deberían ser 3)"); //[cite: 21]
        System.out.println("Total en toda la marca: " + miMarca.mostrarVehiculos().size() + " (Deberían ser 9)\n"); //[cite: 17]

        // --- EXTRA: mostrarVehiculos por tipo de Concesionario ---
        System.out.println("--- EXTRA: Filtro por tipo en Sucursal Sur ---");
        System.out.println("Mostrando solo AUTOS en Sur:");
        ArrayList<Vehiculo> autosSur = conceSur.mostrarVehiculos(TipoDeVehiculo.AUTO); //[cite: 21]
        for (Vehiculo v : autosSur) {
            System.out.println(" - " + v.toString()); //[cite: 20]
        }
    }
}