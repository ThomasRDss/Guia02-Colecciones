package guia2.ejercicio8;

import java.util.ArrayList;

public class Droide {

    private boolean funcionamiento;
    private ArrayList<Pieza> piezasOperativas;
    private ArrayList<Pieza> piezasNoOperativas;
    private ArrayList<Droide> droidesRotos;

    public Droide(boolean funcionamiento) {
        this.funcionamiento = funcionamiento;
        this.piezasOperativas = new ArrayList<Pieza>();
        this.piezasNoOperativas = new ArrayList<Pieza>();
        this.droidesRotos = new ArrayList<Droide>();
    }

    public String autoRepararse() {
        String resultadoFinal = "";
        if (piezasNoOperativas.isEmpty()) {
            resultadoFinal = "COMPLETAMENTE_OPERATIVO";
        }
        boolean logroRepararAlguna = false;
        int i = 0;

        // Recorremos las piezas rotas. Usamos un while para poder manipular el índice al eliminar
        while (i < piezasNoOperativas.size() && logroRepararAlguna == false) {
            Pieza piezaRota = piezasNoOperativas.get(i);
            Pieza repuesto = buscarPiezaOperativaEnDroideRoto(piezaRota);

            if (repuesto != null) {
                // Proceso de reemplazo
                this.agregarPieza(repuesto);
                this.removerPiezaDeDroideRoto(repuesto);
                this.piezasNoOperativas.remove(i);
                logroRepararAlguna = true;

            } else {
                i++;
            }
        }

        // Evaluación final
        if (piezasNoOperativas.isEmpty()) {
            resultadoFinal = "COMPLETAMENTE_OPERATIVO";
        } else if (logroRepararAlguna) {
            resultadoFinal = "REPARACION_PARCIAL";
        } else {
            resultadoFinal = "REPARACION_IMPOSIBLE";
        }
        return resultadoFinal;
    }

    public void agregarPieza(Pieza pieza) {
        if (pieza != null) {
            if (pieza.isOperativa()) {
                piezasOperativas.add(pieza);
            } else {
                piezasNoOperativas.add(pieza);
            }
        }
    }

    private Pieza buscarPiezaNoOperativa() {
        Pieza piezaEncontrada = null;
        int i = 0;
        while (i < piezasNoOperativas.size() && piezaEncontrada == null) {
            Pieza pieza = piezasNoOperativas.get(i);
            if (!pieza.isOperativa()) {
                piezaEncontrada = pieza;
            }
            i++;
        }
        return piezaEncontrada;
    }

    private Pieza buscarPiezaOperativaEnDroideRoto(Pieza piezaNoOperativa) {
        Pieza piezaOperativa = null;
        int iDroides = 0;
        while (iDroides < droidesRotos.size()) {
            Droide droideRoto = droidesRotos.get(iDroides);
            int iPiezas = 0;
            while (iPiezas < droideRoto.piezasOperativas.size() && piezaOperativa == null) {
                Pieza piezaPosible = droideRoto.piezasOperativas.get(iPiezas);
                if (piezaPosible.isOperativa() && piezaPosible.getNombre().equals(piezaNoOperativa.getNombre())) {
                    piezaOperativa = piezaPosible;
                }
                iPiezas++;
            }
            iDroides++;
        }
        return piezaOperativa;
    }

    public void escanearDroideRoto(Droide droide) {
        if (droide.funcionamiento == false) {
            droidesRotos.add(droide);
        }
    }

    private boolean quitarPieza(Pieza piezaAQuitar) {
        boolean realizado = false;
        if (piezaAQuitar != null) {
            piezasNoOperativas.remove(piezaAQuitar);
            realizado = true;
        }
        return realizado;
    }

    private void removerPiezaDeDroideRoto(Pieza repuestoUtilizado) {
        int contador = 0;
        while (contador < droidesRotos.size()) {
            if (droidesRotos.get(contador).piezasOperativas.contains(repuestoUtilizado)) {
                droidesRotos.get(contador).piezasOperativas.remove(repuestoUtilizado);

            }
            contador++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n======================================\n");
        sb.append("   ESTADO DEL DROIDE\n");
        sb.append("======================================\n");
        sb.append(String.format("Funcionamiento General: %s\n", funcionamiento ? "ACTIVO" : "FUERA DE SERVICIO"));

        sb.append("\n--- Piezas OPERATIVAS (").append(piezasOperativas.size()).append(") ---\n");
        if (piezasOperativas.isEmpty()) {
            sb.append("  (Vacío)\n");
        } else {
            for (Pieza p : piezasOperativas) {
                sb.append("  [OK] ").append(p).append("\n");
            }
        }

        sb.append("\n--- Piezas NO OPERATIVAS (").append(piezasNoOperativas.size()).append(") ---\n");
        if (piezasNoOperativas.isEmpty()) {
            sb.append("  (Sin fallos detectados)\n");
        } else {
            for (Pieza p : piezasNoOperativas) {
                sb.append("  [!!] ").append(p).append("\n");
            }
        }

        sb.append("--------------------------------------");
        return sb.toString();
    }

}
