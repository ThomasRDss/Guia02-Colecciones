package guia2.ejercicio9;

import java.util.ArrayList;

public class Tablero {

    private ArrayList<Llave> llaves;

    public Tablero() {
        this.llaves = new ArrayList<Llave>();
    }
    
    
    public void agregarLLave(Llave llave){
        llaves.add(llave);
    }
    
    public Llave devolverLlave(String patente) {
        return buscarLLave(patente);
    }

    private Llave buscarLLave(String patente){
        Llave llaveEncontrada = null;
        int i = 0;
        while(i < llaves.size() && llaveEncontrada == null){
            Llave posibleLlave = llaves.get(i);
            if(posibleLlave.getEtiqueta().equals(patente)){
                llaveEncontrada = posibleLlave;
            }                
            i++;
        }
        return llaveEncontrada;
    }

    @Override
    public String toString() {
        return "Tablero{" + "llaves=" + llaves + '}';
    }

    
}