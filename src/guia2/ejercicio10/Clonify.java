package guia2.ejercicio10;

import java.util.ArrayList;

public class Clonify {

    private ArrayList<Artista> artistas;
    private ArrayList<Usuario> usuarios;

    public Clonify() {
        this.artistas = new ArrayList<Artista>();
        this.usuarios = new ArrayList<Usuario>();
    }

    public void agregarArtista(Artista artistaNuevo) {
        artistas.add(artistaNuevo);
    }

    public void agregarUsuario(Usuario usuarioNuevo) {
        usuarios.add(usuarioNuevo);
    }

    public Usuario borrarUsuario(String nombre) {
        Usuario usuarioBorrado = buscarUsuario(nombre);
        borrarLikesDeUsuario(usuarioBorrado);
        usuarios.remove(usuarioBorrado);
        return usuarioBorrado;
    }

    private Usuario buscarUsuario(String nombre) {
        Usuario usuarioBuscado = null;
        int i = 0;
        while (i < usuarios.size() && usuarioBuscado == null) {
            Usuario usuarioActual = usuarios.get(i);
            if (usuarioActual.getNombre().equals(nombre)) {
                usuarioBuscado = usuarioActual;
            }
            i++;
        }
        return usuarioBuscado;
    }
    
    private void borrarLikesDeUsuario(Usuario usuario){
        for (Artista artista : artistas) {
            artista.borrarLikeDeUsuario(usuario);
        }
    }

    @Override
    public String toString() {
        return "Clonify{" + "artistas=" + artistas + ", usuarios=" + usuarios + '}';
    }
    
    
}
