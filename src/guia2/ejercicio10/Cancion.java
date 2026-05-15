package guia2.ejercicio10;

import java.util.ArrayList;

public class Cancion {

    private String ID;
    private String nombre;
    private int duracionSEG;
    private ArrayList<Usuario> usuariosQueDieronLike;

    public Cancion(String ID, String nombre, int duracionSEG) {
        this.ID = ID;
        this.nombre = nombre;
        this.duracionSEG = duracionSEG;
        this.usuariosQueDieronLike = new ArrayList<Usuario>();
    }

    public void agregarUsuarioQueDioLike(Usuario usuarioQueDioLike) {
        usuariosQueDieronLike.add(usuarioQueDioLike);
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracionSEG() {
        return duracionSEG;
    }

    public boolean buscarUsuarioQueLikeo(Usuario usuario) {
        boolean like = false;
        int contador = 0;
        while (contador < usuariosQueDieronLike.size() && like == false) {
            String nombreDeUsuarioQueDioLike = usuariosQueDieronLike.get(contador).getNombre();
            if (usuario.getNombre().equalsIgnoreCase(nombreDeUsuarioQueDioLike)) {
                like = true;
            }
            contador++;
        }
        return like;
    }

    public void borrarLikeDeUsuario(Usuario usuario) {
        usuariosQueDieronLike.remove(usuario);
    }

}
