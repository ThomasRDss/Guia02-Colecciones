package guia2.ejercicio8;

import java.util.ArrayList;

public class GalaxiaLejana {

    private ArrayList<Droide> droides;

    public GalaxiaLejana() {
        this.droides = new ArrayList<Droide>();
    }
    
    public void agregarDroide(Droide droide){
        droides.add(droide);
    }

    @Override
    public String toString() {
        return "GalaxiaLejana{" + "droides=" + droides + '}';
    }

}