package guia2.ejercicio6;

import java.util.ArrayList;

public class Cliente {

    private String DNI;
    private String nombre;
    private double saldo;
    private TipoDeServicio suscripcion;
    private ArrayList<Pelicula> peliculasVistas;
    private boolean deudor;
    
    public Cliente(String DNI, String nombre, double saldo, TipoDeServicio suscripcion) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.saldo = saldo;
        this.suscripcion = suscripcion;
        this.peliculasVistas = new ArrayList<Pelicula>();
    }

    public String getDNI() {
        return DNI;
    }

    
    public double obtenerSaldo() {
        return saldo;
    }

    public boolean esDeudor(){
        if(obtenerSaldo() > 0){
            this.deudor = true;
        }
        return this.deudor;
    }

    public TipoDeServicio getSuscripcion() {
        return suscripcion;
    }
    
    public void peliculasVistas(Pelicula peliculaVista){
        peliculasVistas.add(peliculaVista);
    }
    
    
}