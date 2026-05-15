package guia2.ejercicio9;

import java.util.ArrayList;

public class Garaje {

    private String identificador;
    private Tablero tablero;
    private ArrayList<Vehiculo> vehiculosEstacionados;
    private ArrayList<Vehiculo> vehiculosRetirados;

    public Garaje(String identificador, Tablero tablero) {
        this.identificador = identificador;
        this.tablero = tablero;
        this.vehiculosEstacionados = new ArrayList<Vehiculo>();
        this.vehiculosRetirados = new ArrayList<Vehiculo>();
    }

    public String estacionarVehiculo(String patente) {
        String resultado = "";
        Vehiculo vehiculoConocido = buscarVehiculo(patente);
        if (vehiculoConocido == null) {
            resultado = "VEHICULO_NO_HABILITADO";
        } else if (estaEstacionado(patente)) {
            resultado = "VEHICULO_YA_ESTACIONADO";
        } else if (esDeudor(patente)) {
            resultado = "NO_ESTACIONA_ADEUDA";
        } else {
            resultado = "INGRESO_OK";
            agregarVehiculoEstacionado(vehiculoConocido);
            vehiculosRetirados.remove(vehiculoConocido);
        }
        return resultado;
    }

    public void agregarVehiculoEstacionado(Vehiculo vehiculoAEstacionar) {
        vehiculosEstacionados.add(vehiculoAEstacionar);
    }

    public void agregarVehiculoRetirado(Vehiculo vehiculoAEstacionar) {
        vehiculosRetirados.add(vehiculoAEstacionar);
    }

    public boolean esPersonaAutorizada(String DNI) {
        return buscarPersonaAutorizada(DNI);
    }

    private int cantidadDeVehiculosEstacionados() {
        return vehiculosEstacionados.size();
    }

    private boolean buscarPersonaAutorizada(String DNI) {
        boolean personaEncontrada = false;
        int iVehiculos = 0;

        while (iVehiculos < vehiculosEstacionados.size() && personaEncontrada == false) {
            Vehiculo vehiculoEstacionado = vehiculosEstacionados.get(iVehiculos);
            int iPersonas = 0;
            while (iPersonas < vehiculoEstacionado.getPersonasAutorizadasARetirar().size() && personaEncontrada == false) {
                String DNIpersona = vehiculoEstacionado.getPersonasAutorizadasARetirar().get(iPersonas).getDNI();
                if (DNIpersona.equalsIgnoreCase(DNI)) {
                    personaEncontrada = true;
                }
                iPersonas++;
            }
            iVehiculos++;
        }
        return personaEncontrada;
    }

    private boolean estaEstacionado(String patente) {
        boolean estacionado = false;
        int i = 0;
        while (i < vehiculosEstacionados.size() && estacionado == false) {
            String patenteDeVehiculoEstacionado = vehiculosEstacionados.get(i).getPatente();
            if (patenteDeVehiculoEstacionado.equalsIgnoreCase(patente)) {
                estacionado = true;
            }
            i++;
        }
        return estacionado;
    }

    private Vehiculo buscarVehiculo(String patente) {
        Vehiculo buscado = null;
        int i = 0;

        while (i < vehiculosEstacionados.size() && buscado == null) {
            Vehiculo posible = vehiculosEstacionados.get(i);
            if (posible.getPatente().equalsIgnoreCase(patente)) {
                buscado = posible;
            }
            i++;
        }

        if (buscado == null) {
            int j = 0;
            while (j < vehiculosRetirados.size() && buscado == null) {
                Vehiculo posible = vehiculosRetirados.get(j);
                if (posible.getPatente().equalsIgnoreCase(patente)) {
                    buscado = posible;
                }
                j++;
            }
        }

        return buscado;
    }

    private boolean esDeudor(String patente) {
        final int MINIMA_CANTIDAD_MESES_POSIBLE = 3;
        Vehiculo posibleDeudor = buscarVehiculo(patente);
        return posibleDeudor.getMesesAdeudados() > MINIMA_CANTIDAD_MESES_POSIBLE;
    }

    public void mostrarVehiculosEstacionadosSinLLave() {
        System.out.println("Código de Garaje: " + this.identificador);

        for (int i = 0; i < vehiculosEstacionados.size(); i++) {
            Vehiculo vehiculoActual = vehiculosEstacionados.get(i);

            String patenteActual = vehiculoActual.getPatente();

            Llave llaveEnTablero = tablero.devolverLlave(patenteActual);

            if (llaveEnTablero == null) {
                System.out.println(" - Patente sin llave en tablero: " + patenteActual);
            }
        }
        System.out.println("------------------------------------------------");
    }

    public Tablero getTablero() {
        return tablero;
    }

    public ArrayList<Vehiculo> getVehiculosRetirados() {
        return vehiculosRetirados;
    }

    public String obtenerInformeEstadoGaraje() {
        return identificador + " cantidad de vehiculos estacionados= " + cantidadDeVehiculosEstacionados();
    }

    @Override
    public String toString() {
        return "Garaje{" + "identificador=" + identificador + ", tablero=" + tablero + ", vehiculosEstacionados=" + vehiculosEstacionados + ", vehiculosRetirados=" + vehiculosRetirados + '}';
    }

}
