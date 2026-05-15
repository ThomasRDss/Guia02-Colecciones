package guia2.ejercicio6;

public class Principal {

    public static void main(String[] args) {
        
        // 1. Instanciamos el sistema principal
        ClonFlix miClonFlix = new ClonFlix();
        
        // 2. Creamos y agregamos algunas películas al sistema
        Pelicula peli1 = new Pelicula("El Padrino", TipoDeServicio.STANDARD);
        Pelicula peli2 = new Pelicula("Duna: Parte 2", TipoDeServicio.PREMIUM);
        Pelicula peli3 = new Pelicula("Volver al Futuro", TipoDeServicio.STANDARD);
        
        miClonFlix.agregarPelicula(peli1);
        miClonFlix.agregarPelicula(peli2);
        miClonFlix.agregarPelicula(peli3);
        
        // 3. Creamos y agregamos clientes con distintas características
        // Cliente Standard al día
        Cliente cliente1 = new Cliente("11111111", "Thomas", 0.0, TipoDeServicio.STANDARD); 
        // Cliente Premium al día
        Cliente cliente2 = new Cliente("22222222", "Lucía", -500.0, TipoDeServicio.PREMIUM); 
        // Cliente Premium con deuda
        Cliente cliente3 = new Cliente("33333333", "Marcos", 1500.0, TipoDeServicio.PREMIUM); 
        
        miClonFlix.agregarCliente(cliente1);
        miClonFlix.agregarCliente(cliente2);
        miClonFlix.agregarCliente(cliente3);
        
        // 4. Pruebas de los distintos escenarios del método verPelicula()
        System.out.println("--- PRUEBAS DE CLONFLIX ---");
        
        // Caso A: ALQUILER_OK (Cliente Standard viendo película Standard)
        System.out.println("Prueba 1: " + miClonFlix.verPelicula("11111111", "El Padrino")); 
        
        // Caso B: CONTENIDO_NO_DISPONIBLE (Cliente Standard intentando ver peli Premium)
        System.out.println("Prueba 2: " + miClonFlix.verPelicula("11111111", "Duna: Parte 2")); 
        
        // Caso C: ALQUILER_OK (Cliente Premium viendo peli Premium)
        System.out.println("Prueba 3: " + miClonFlix.verPelicula("22222222", "Duna: Parte 2")); 
        
        // Caso D: CLIENTE_DEUDOR (Cliente tiene saldo positivo a favor de la empresa)
        System.out.println("Prueba 4: " + miClonFlix.verPelicula("33333333", "Volver al Futuro")); 
        
        // Caso E: CONTENIDO_INEXISTENTE (La película no está en la lista)
        System.out.println("Prueba 5: " + miClonFlix.verPelicula("22222222", "Matrix")); 
        
        // Caso F: CLIENTE_NO_ENCONTRADO (El DNI no está registrado)
        System.out.println("Prueba 6: " + miClonFlix.verPelicula("99999999", "El Padrino")); 
        
        System.out.println("\n--- PRUEBA DE BAJA DE CLIENTE ---");
        // Damos de baja al cliente 1
        miClonFlix.darDeBaja("11111111");
        // Intentamos que el cliente 1 vea una película después de ser dado de baja
        System.out.println("Prueba post-baja: " + miClonFlix.verPelicula("11111111", "El Padrino"));
    }
}