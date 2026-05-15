package guia2.ejercicio5;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        
        System.out.println("=== NUEVO TEST DE SISTEMA HOTELERO ===\n");

        // 1. Creamos el Hotel con otros datos
        Hotel miHotel = new Hotel("Hotel del Sol", "Calle Falsa 123");

        // 2. Instanciamos y agregamos habitaciones (Nro, Precio por día)
        Habitacion hab10 = new Habitacion(10, 5000.0);
        Habitacion hab20 = new Habitacion(20, 7500.0);
        Habitacion hab30 = new Habitacion(30, 12000.0);
        Habitacion hab40 = new Habitacion(40, 4500.0);

        miHotel.agregarHabitacion(hab10);
        miHotel.agregarHabitacion(hab20);
        miHotel.agregarHabitacion(hab30);
        miHotel.agregarHabitacion(hab40);

        // 3. Ocupamos las habitaciones con distintos huéspedes y días
        // (Asegúrate de haber agregado el método ocuparHabitacion en la clase Habitacion)
        
        System.out.println("Realizando ingresos de huéspedes...");
        
        // Nicolás en la 10 por 2 días
        hab10.ocuparHabitacion("Nicolás", 2);
        hab10.agregarAdicionales(new Adicional(1000.0, TipoDeAdicional.DESAYUNO));

        // Thomas en la 20 por 1 día
        hab20.ocuparHabitacion("Thomas", 1);
        hab20.agregarAdicionales(new Adicional(2000.0, TipoDeAdicional.TRASLADO));

        // Sofía en la 30 por 3 días
        hab30.ocuparHabitacion("Sofía", 3);
        hab30.agregarAdicionales(new Adicional(1500.0, TipoDeAdicional.ROOM_SERVICE));
        hab30.agregarAdicionales(new Adicional(1000.0, TipoDeAdicional.DESAYUNO));

        // La habitación 40 queda vacía para probar disponibilidad
        System.out.println("Huéspedes cargados correctamente.\n");

        // 4. Test de Disponibilidad (Debería mostrar solo la habitación 40)
        System.out.println("--- Habitaciones Libres Actuales ---");
        ArrayList<Habitacion> libres = miHotel.obtenerHabitacionesDisponibles();
        if (libres.isEmpty()) {
            System.out.println("No hay habitaciones disponibles.");
        } else {
            for (Habitacion h : libres) {
                System.out.println("Habitación Nro: " + h.obtenerNumeroDeHabitacion());
            }
        }

        // 5. Test de Facturación (Checkout)
        System.out.println("\n--- Procesando Checkouts ---");

        // Checkout Nicolás (Nro 10)
        // Cálculo esperado: (5000 * 2) + 1000 = $11,000
        double ticketNicolas = miHotel.realizarCheckout(10);
        System.out.println("Ticket Nicolás (Hab 10): $" + ticketNicolas);

        // Checkout Thomas (Nro 20)
        // Cálculo esperado: (7500 * 1) + 2000 = $9,500
        double ticketThomas = miHotel.realizarCheckout(20);
        System.out.println("Ticket Thomas (Hab 20): $" + ticketThomas);

        // Checkout Sofía (Nro 30)
        // Cálculo esperado: (12000 * 3) + 1500 + 1000 = $38,500
        double ticketSofia = miHotel.realizarCheckout(30);
        System.out.println("Ticket Sofía (Hab 30): $" + ticketSofia);

        // 6. Test de Error: Intentar cobrar a una habitación ya vacía (la 40)
        double ticketError = miHotel.realizarCheckout(40);
        System.out.println("\nIntento cobrar Hab 40 (Vacía): " + ticketError + " (Resultado esperado: -1)");
        
        // 7. Test de Error: Intentar cobrar a una habitación inexistente
        double ticketInexistente = miHotel.realizarCheckout(999);
        System.out.println("Intento cobrar Hab 999 (Inexistente): " + ticketInexistente + " (Resultado esperado: -1)");
    }
}