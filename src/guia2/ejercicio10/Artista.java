package guia2.ejercicio10;

import java.util.ArrayList;

public class Artista {

    private String ID;
    private String nombre;
    private ArrayList<Cancion> canciones;

    public Artista(String ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
        this.canciones = new ArrayList<Cancion>();
    }

    public void agregarCanciones(Cancion cancionDeArtista) {
        canciones.add(cancionDeArtista);
    }

    public boolean esFanDestacado(Usuario supuestoUsuarioDestacado) {       
        final int LIKES_MINIMOS = (int) (canciones.size() + 1) / 2;
        int i = 0;
        int cantidadDeLikes = 0;
        while (i < canciones.size() && cantidadDeLikes < LIKES_MINIMOS) {
            if (canciones.get(i).buscarUsuarioQueLikeo(supuestoUsuarioDestacado)) {
                cantidadDeLikes++;                
            } 
            i++;
        }
        return cantidadDeLikes >= LIKES_MINIMOS;
    }

    public Cancion[] primeras5Canciones() {
        int CANTIDAD_DE_CANCIONES = 5;
        if(canciones.size() < CANTIDAD_DE_CANCIONES){
            CANTIDAD_DE_CANCIONES = canciones.size();
        }
        Cancion[] primerasCincoCanciones = new Cancion[CANTIDAD_DE_CANCIONES];
        for (int i = 0; i < CANTIDAD_DE_CANCIONES; i++) {
           Cancion cancionActual = canciones.get(i);
            primerasCincoCanciones[i] = cancionActual;
        }
        return primerasCincoCanciones;
    }

    public void mostrarDuracionPromedio() { //hacerlo VOID
        double promedioEnSegundos;
        double acumulador = 0;
        final int VALOR_MINUTO_EN_SEG = 60;
        for (Cancion cancion : canciones) {
            acumulador += cancion.getDuracionSEG();
        }
        promedioEnSegundos = acumulador / canciones.size();
        int minutos = (int) promedioEnSegundos / VALOR_MINUTO_EN_SEG;
        int segundos = (int) promedioEnSegundos % VALOR_MINUTO_EN_SEG;

        System.out.println(minutos + " minutos " + " " + segundos + " segundos"); 
    }

    public void borrarLikeDeUsuario(Usuario usuario){
        for (Cancion cancion : canciones) {
           cancion.borrarLikeDeUsuario(usuario);
        }
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Artista{" + "ID=" + ID + ", nombre=" + nombre + ", canciones=" + canciones + '}';
    }

    

}
