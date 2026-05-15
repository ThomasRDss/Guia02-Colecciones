package guia2.ejercicio6;


public class Pelicula {

    private String nombre;
    private TipoDeServicio tipoDeServicio;



    public Pelicula(String nombre, TipoDeServicio tipoDeServicio) {
        this.nombre = nombre;
        this.tipoDeServicio = tipoDeServicio;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public TipoDeServicio getTipoDeServicio() {
        return tipoDeServicio;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "nombre=" + nombre + ", tipoDeServicio=" + tipoDeServicio + '}';
    }
    

}