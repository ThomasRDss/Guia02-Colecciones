package guia2.ejercicio10;

public class Principal {

    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA CLONIFY ===");

        // 1. Instanciamos la plataforma y los usuarios
        Clonify clonify = new Clonify();
        Usuario user1 = new Usuario("ThomasRodas", Estado.HABILITADO);
        Usuario user2 = new Usuario("MusicaFan99", Estado.PRUEBA_GRATIS);
        
        clonify.agregarUsuario(user1);
        clonify.agregarUsuario(user2);

        // 2. Instanciamos un Artista y le agregamos canciones
        Artista daftPunk = new Artista("ART-001", "Daft Punk");
        clonify.agregarArtista(daftPunk);

        Cancion c1 = new Cancion("C-001", "One More Time", 320); // 5 min 20 seg
        Cancion c2 = new Cancion("C-002", "Harder, Better, Faster", 224); // 3 min 44 seg
        Cancion c3 = new Cancion("C-003", "Get Lucky", 248); // 4 min 8 seg
        Cancion c4 = new Cancion("C-004", "Around The World", 429); // 7 min 9 seg
        
        daftPunk.agregarCanciones(c1);
        daftPunk.agregarCanciones(c2);
        daftPunk.agregarCanciones(c3);
        daftPunk.agregarCanciones(c4);

        // 3. Simulamos interacción (Likes)
        // Thomas le da like a 3 de las 4 canciones
        c1.agregarUsuarioQueDioLike(user1);
        c2.agregarUsuarioQueDioLike(user1);
        c3.agregarUsuarioQueDioLike(user1);
        
        // MusicaFan99 le da like solo a 1 (no será fan destacado)
        c4.agregarUsuarioQueDioLike(user2);

        // --- PRUEBAS DE LA CONSIGNA ---

        // B) Promedio de duración
        System.out.println("\n--- PRUEBA B: Promedio de Duración ---");
        daftPunk.mostrarDuracionPromedio();

        // C) Fan Destacado (Thomas = Sí / MusicaFan99 = No)
        System.out.println("\n--- PRUEBA C: Fan Destacado ---");
        System.out.println("¿ThomasRodas es fan destacado? " + daftPunk.esFanDestacado(user1));
        System.out.println("¿MusicaFan99 es fan destacado? " + daftPunk.esFanDestacado(user2));

        // D) Primeras 5 Canciones (Daft Punk tiene 4, debe devolver 4 sin crashear)
        System.out.println("\n--- PRUEBA D: Primeras 5 canciones ---");
        Cancion[] primeras5 = daftPunk.primeras5Canciones();
        for (int i = 0; i < daftPunk.primeras5Canciones().length; i++) {
            System.out.println("Canciones disponibles: " + primeras5[i]);
        }

        // E) Borrar Usuario
        System.out.println("\n--- PRUEBA E: Borrar Usuario (Borrando a ThomasRodas) ---");
        
        System.out.println("Antes de borrar: ¿Thomas le dio like a 'One More Time'? " + c1.buscarUsuarioQueLikeo(user1));
        
        Usuario borrado = clonify.borrarUsuario("ThomasRodas");
        
        System.out.println("Usuario borrado con éxito: " + (borrado != null ? borrado.getNombre() : "No encontrado"));
        System.out.println("Después de borrar: ¿Thomas sigue teniendo like en 'One More Time'? " + c1.buscarUsuarioQueLikeo(user1));
    }
}
