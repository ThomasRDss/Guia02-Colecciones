package guia2.ejercicio8;

public class Principal {

    public static void main(String[] args) {
        System.out.println("=========================================================");
        System.out.println("   SISTEMA DE MANTENIMIENTO INTERGALÁCTICO INICIADO");
        System.out.println("=========================================================\n");

        // Ejecutamos los tres escenarios posibles detalladamente
        ejecutarPruebaReparacionImposible();
        ejecutarPruebaReparacionParcial();
        ejecutarPruebaReparacionTotal();
        
        System.out.println("=========================================================");
        System.out.println("   DIAGNÓSTICO FINALIZADO. QUE LA FUERZA TE ACOMPAÑE.");
        System.out.println("=========================================================");
    }

    private static void ejecutarPruebaReparacionImposible() {
        System.out.println("--- ESCENARIO 1: REPARACIÓN IMPOSIBLE ---");
        System.out.println("Situación: C-3PO está gravemente dañado y encuentra un droide de combate que no tiene las piezas que necesita.");
        
        Droide c3po = new Droide(true);
        c3po.agregarPieza(new Pieza("Módulo de traducción", false)); // Rota
        c3po.agregarPieza(new Pieza("Articulación de rodilla", false)); // Rota

        Droide droideCombateB1 = new Droide(false); // Fuera de servicio
        droideCombateB1.agregarPieza(new Pieza("Blaster integrado", true)); // Pieza sana pero inútil para C-3PO
        
        c3po.escanearDroideRoto(droideCombateB1);

        System.out.println("\n[ESTADO ANTES] " + c3po.toString());
        
        String resultado = c3po.autoRepararse();
        
        System.out.println("[ACCIÓN] Ejecutando protocolo de auto-reparación...");
        System.out.println("[RESULTADO] -> " + resultado);
        System.out.println("[ESTADO DESPUÉS] " + c3po.toString() + "\n");
    }

    private static void ejecutarPruebaReparacionParcial() {
        System.out.println("--- ESCENARIO 2: REPARACIÓN PARCIAL ---");
        System.out.println("Situación: R2-D2 tiene dos piezas rotas. Encuentra chatarra que le sirve para arreglar solo una de ellas.");
        
        Droide r2d2 = new Droide(true);
        r2d2.agregarPieza(new Pieza("Proyector holográfico", false)); // Rota
        r2d2.agregarPieza(new Pieza("Propulsor de vuelo", false)); // Rota
        r2d2.agregarPieza(new Pieza("Sensor óptico", true)); // Sana (ya la tenía)

        Droide unidadR5Destruida = new Droide(false); // Fuera de servicio
        unidadR5Destruida.agregarPieza(new Pieza("Proyector holográfico", true)); // Repuesto exacto!
        unidadR5Destruida.agregarPieza(new Pieza("Cables pelados", false)); // Basura
        
        r2d2.escanearDroideRoto(unidadR5Destruida);

        System.out.println("\n[ESTADO ANTES] " + r2d2.toString());
        
        String resultado = r2d2.autoRepararse();
        
        System.out.println("[ACCIÓN] Ejecutando protocolo de auto-reparación...");
        System.out.println("[RESULTADO] -> " + resultado);
        System.out.println("[ESTADO DESPUÉS] " + r2d2.toString() + "\n");
    }

    private static void ejecutarPruebaReparacionTotal() {
        System.out.println("--- ESCENARIO 3: COMPLETAMENTE OPERATIVO ---");
        System.out.println("Situación: BB-8 perdió su antena. Encuentra un droide idéntico roto y le roba la antena intacta.");
        
        Droide bb8 = new Droide(true);
        bb8.agregarPieza(new Pieza("Antena receptora", false)); // Rota
        
        Droide bb9eDestruido = new Droide(false); // Fuera de servicio
        bb9eDestruido.agregarPieza(new Pieza("Antena receptora", true)); // Repuesto exacto!
        bb9eDestruido.agregarPieza(new Pieza("Carcasa negra", true)); // Repuesto extra que BB-8 no necesita
        
        bb8.escanearDroideRoto(bb9eDestruido);

        System.out.println("\n[ESTADO ANTES] " + bb8.toString());
        
        String resultado = bb8.autoRepararse();
        
        System.out.println("[ACCIÓN] Ejecutando protocolo de auto-reparación...");
        System.out.println("[RESULTADO] -> " + resultado);
        System.out.println("[ESTADO DESPUÉS] " + bb8.toString() + "\n");
    }
}