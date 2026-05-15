package guia2.ejercicio9;

public class Principal {

    public static void main(String[] args) {
        // 1. Inicialización de la infraestructura
        FooParking empresa = new FooParking();
        
        // CORRECCIÓN: Creamos los tableros primero
        Tablero tableroNorte = new Tablero();
        Tablero tableroSur = new Tablero();
        
        // CORRECCIÓN: Pasamos el identificador y el tablero al constructor
        Garaje garajeNorte = new Garaje("GAR-NORTE-01", tableroNorte);
        Garaje garajeSur = new Garaje("GAR-SUR-02", tableroSur);
        
        // Agregamos los garajes a la empresa
        empresa.agregarGaraje(garajeNorte);
        empresa.agregarGaraje(garajeSur);

        // 2. Poblado de datos para GARAGE NORTE (Pruebas de Estacionamiento)
        System.out.println("--- PREPARANDO DATOS Y PRUEBAS DE ESTACIONAMIENTO ---");
        
        // Vehículo 1: Habilitado (está en el registro de 'retirados') y con dueño autorizado
        Vehiculo v1 = new Vehiculo("AAA111");
        v1.getPersonasAutorizadasARetirar().add(new Persona("Thomas Rodas", "45678912"));
        garajeNorte.getVehiculosRetirados().add(v1); // Lo ponemos en retirados para que buscarVehiculo lo encuentre

        // Vehículo 2: Ya está estacionado
        Vehiculo v2 = new Vehiculo("BBB222");
        garajeNorte.agregarVehiculoEstacionado(v2);

        // Probamos los distintos estados de 'estacionarVehiculo'
        System.out.println("Intento AAA111 (Habilitado): " + garajeNorte.estacionarVehiculo("AAA111"));
        System.out.println("Intento CCC333 (No registrado): " + garajeNorte.estacionarVehiculo("CCC333"));
        System.out.println("Intento BBB222 (Ya estacionado): " + garajeNorte.estacionarVehiculo("BBB222"));
        
        // Nota: El caso 'NO_ESTACIONA_ADEUDA' saltará aleatoriamente según el Random de tu clase Vehiculo.

        // 3. Prueba de Personas Autorizadas
        System.out.println("\n--- PRUEBA DE PERSONAS AUTORIZADAS ---");
        System.out.println("¿Thomas (45678912) puede retirar? " + garajeNorte.esPersonaAutorizada("45678912"));
        System.out.println("¿Desconocido (00000000) puede retirar? " + garajeNorte.esPersonaAutorizada("00000000"));

        // 4. Configuración para 'mostrarVehiculosSinLlave'
        // En Garaje Sur, estacionamos un vehículo pero NO ponemos su llave en el tablero
        Vehiculo v3 = new Vehiculo("KEY-999");
        garajeSur.agregarVehiculoEstacionado(v3); 
        
        // En Garaje Norte, estacionamos uno y SÍ ponemos su llave en su tablero respectivo
        Vehiculo v4 = new Vehiculo("KEY-111");
        garajeNorte.agregarVehiculoEstacionado(v4);
        tableroNorte.agregarLLave(new Llave("KEY-111"));

        // 5. Reportes Finales (Métodos de FooParking)
        System.out.println("\n--- REPORTE C: INFORME DE ESTADO ---");
        for (String informe : empresa.obtenerInformeEstadoGarajes()) {
            System.out.println(informe);
        }

        System.out.println("\n--- REPORTE D: VEHÍCULOS SIN LLAVE ---");
        empresa.mostrarVehiculosSinLlave();
    }
}