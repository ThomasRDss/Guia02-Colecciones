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
        boolean esDestacado = false;
        final int LIKES_MINIMOS = (int) canciones.size() / 2;
        int i = 0;
        int cantidadDeLikes = 0;
        while (i < canciones.size() && esDestacado == false) {
            if (canciones.get(i).buscarUsuarioQueLikeo(supuestoUsuarioDestacado)) {
                cantidadDeLikes++;
            }
            if (cantidadDeLikes >= LIKES_MINIMOS) {
                esDestacado = true;
            }
            i++;
        }
        return esDestacado;
    }

    public String[] primeras5Canciones() {
        int CANTIDAD_DE_CANCIONES = 5;
        if(canciones.size() < CANTIDAD_DE_CANCIONES){
            CANTIDAD_DE_CANCIONES = canciones.size();
        }
        String[] primerasCincoCanciones = new String[CANTIDAD_DE_CANCIONES];
        for (int i = 0; i < CANTIDAD_DE_CANCIONES; i++) {
           Cancion cancionActual = canciones.get(i);
            primerasCincoCanciones[i] = cancionActual.getNombre();
        }
        return primerasCincoCanciones;
    }

    public String mostrarDuracionPromedio() {
        double promedioEnSegundos;
        double acumulador = 0;
        final int VALOR_MINUTO_EN_SEG = 60;
        for (Cancion cancion : canciones) {
            acumulador += cancion.getDuracionSEG();
        }
        promedioEnSegundos = acumulador / canciones.size();
        int minutos = (int) promedioEnSegundos / VALOR_MINUTO_EN_SEG;
        int segundos = (int) Math.round(promedioEnSegundos % VALOR_MINUTO_EN_SEG);

        return minutos + " minutos " + " " + segundos + " segundos";
    }

    public void borrarLikeDeUsuario(Usuario usuario){
        for (Cancion cancion : canciones) {
           cancion.borrarLikeDeUsuario(usuario);
        }
    }

    public String getNombre() {
        return nombre;
    }


}
