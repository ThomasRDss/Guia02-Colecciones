package guia2.ejercicio9;

public class Llave {

    private String etiqueta;
    
    public Llave(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    @Override
    public String toString() {
        return "Llave{" + "etiqueta=" + etiqueta + '}';
    }

}