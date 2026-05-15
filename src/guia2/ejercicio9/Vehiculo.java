package guia2.ejercicio9;

import java.util.ArrayList;
import java.util.Random;

public class Vehiculo {

    private String patente;
    private ArrayList<Persona> personasAutorizadasARetirar;
    
    public Vehiculo(String patente) {
        this.patente = patente;
        this.personasAutorizadasARetirar = new ArrayList<Persona>();
    }
    
    public int getMesesAdeudados() {
        Random random = new Random();
        final int MES_PARA_RANDOM = 6;
        return random.nextInt(MES_PARA_RANDOM);
    }

    public ArrayList<Persona> getPersonasAutorizadasARetirar() {
        return personasAutorizadasARetirar;
    }

    public String getPatente() {
        return patente;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "patente=" + patente + ", personasAutorizadasARetirar=" + personasAutorizadasARetirar + '}';
    }

    
}