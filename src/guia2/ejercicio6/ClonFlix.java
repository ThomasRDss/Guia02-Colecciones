package guia2.ejercicio6;

import java.util.ArrayList;

public class ClonFlix {

    private ArrayList<Cliente> clientes;
    private ArrayList<Pelicula> peliculas;

    public ClonFlix() {
        this.clientes = new ArrayList<Cliente>();
        this.peliculas = new ArrayList<Pelicula>();
    }

    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public String verPelicula(String DNI, String nombreDePelicula) {
        String resultado = "";
        Cliente cliente = buscarCliente(DNI);
        Pelicula pelicula = buscarPelicula(nombreDePelicula);
        if(cliente == null){
            resultado = "CLIENTE_NO_ENCONTRADO";
        }
        else if(pelicula == null){
            resultado = "CONTENIDO_INEXISTENTE";
        }
        else if(cliente.esDeudor()){
            resultado = "CLIENTE_DEUDOR";
        }
        else if(!cliente.getSuscripcion().equals(pelicula.getTipoDeServicio())){
            resultado = "CONTENIDO_NO_DISPONIBLE";
        } else{
            resultado = "ALQUILER_OK";
            cliente.peliculasVistas(pelicula);
        }
        
        return resultado;
    }

    public void darDeBaja(String DNI) {
        clientes.remove(buscarCliente(DNI));
    }

    private Cliente buscarCliente(String DNI){
        Cliente clienteEncontrado = null;
        int i = 0;
        while(i < clientes.size() && clienteEncontrado == null){
            if(DNI.equals(clientes.get(i).getDNI())){
                clienteEncontrado = clientes.get(i);
            }
            i++;
        }
        return clienteEncontrado;
    }
    
   private Pelicula buscarPelicula(String nombreDePelicula){
        Pelicula peliculaEncontrada = null;
        int i = 0;
        while(i < peliculas.size() && peliculaEncontrada == null){
            if(nombreDePelicula.equals(peliculas.get(i).getNombre())){
                peliculaEncontrada = peliculas.get(i);
            }
            i++;
        }
        return peliculaEncontrada;
    }

}
