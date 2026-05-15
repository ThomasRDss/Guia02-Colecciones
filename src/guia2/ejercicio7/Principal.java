package guia2.ejercicio7;

public class Principal {

    public static void main(String[] args) {
        
        Empresa miEmpresa = new Empresa();

        // --- CASO 1: Cumple todo (Más de 5 materias y buen promedio) ---
        Alumno alu1 = new Alumno("Thomas", "thomas@mail.com");
        alu1.agregarMateriaAprobada(new MateriaAprobada("Programación", 8));
        alu1.agregarMateriaAprobada(new MateriaAprobada("Bases de Datos", 9));
        alu1.agregarMateriaAprobada(new MateriaAprobada("Redes", 8));
        alu1.agregarMateriaAprobada(new MateriaAprobada("Sistemas Operativos", 7));
        alu1.agregarMateriaAprobada(new MateriaAprobada("Matemática", 8)); // Promedio: 8.0

        // --- CASO 2: Falla por cantidad de materias (Tiene excelente promedio pero solo 3 materias) ---
        Alumno alu2 = new Alumno("Lucía", "lucia@mail.com");
        alu2.agregarMateriaAprobada(new MateriaAprobada("Programación", 10));
        alu2.agregarMateriaAprobada(new MateriaAprobada("Inglés", 9));
        alu2.agregarMateriaAprobada(new MateriaAprobada("Física", 8)); // Promedio: 9.0

        // --- CASO 3: Falla por promedio (Tiene 5 materias pero promedio bajo) ---
        Alumno alu3 = new Alumno("Marcos", "marcos@mail.com");
        alu3.agregarMateriaAprobada(new MateriaAprobada("Programación", 4));
        alu3.agregarMateriaAprobada(new MateriaAprobada("Bases de Datos", 5));
        alu3.agregarMateriaAprobada(new MateriaAprobada("Redes", 4));
        alu3.agregarMateriaAprobada(new MateriaAprobada("Sistemas Operativos", 6));
        alu3.agregarMateriaAprobada(new MateriaAprobada("Matemática", 4)); // Promedio: 4.6

        // --- CASO 4: Cumple todo (Seis materias y excelente promedio) ---
        Alumno alu4 = new Alumno("Sofía", "sofia@mail.com");
        alu4.agregarMateriaAprobada(new MateriaAprobada("Programación", 10));
        alu4.agregarMateriaAprobada(new MateriaAprobada("Bases de Datos", 10));
        alu4.agregarMateriaAprobada(new MateriaAprobada("Redes", 9));
        alu4.agregarMateriaAprobada(new MateriaAprobada("Arquitectura", 10));
        alu4.agregarMateriaAprobada(new MateriaAprobada("Matemática", 9));
        alu4.agregarMateriaAprobada(new MateriaAprobada("Estadística", 10)); // Promedio: 9.66

        // Agregamos todos los alumnos a la empresa
        miEmpresa.agregarAlumno(alu1);
        miEmpresa.agregarAlumno(alu2);
        miEmpresa.agregarAlumno(alu3);
        miEmpresa.agregarAlumno(alu4);

        // --- PRUEBA DEL MÉTODO ---
        double promedioBuscado = 7.0;
        System.out.println("Buscando candidatos con promedio mayor o igual a " + promedioBuscado + "...");
        
        String[] candidatosEncontrados = miEmpresa.obtenerCandidatos(promedioBuscado);

        // Recorremos el array devuelto para imprimir los resultados
        int contador = 0;
        for (int i = 0; i < candidatosEncontrados.length; i++) {
            // Como el array tiene 20 espacios fijos, los que no se usen van a ser 'null'
            // Solo imprimimos las posiciones que tengan información
            if (candidatosEncontrados[i] != null) {
                contador++;
                System.out.println(contador + ". " + candidatosEncontrados[i]);
            }
        }
        
        if (contador == 0) {
            System.out.println("No se encontraron candidatos que cumplan con los requisitos.");
        }
    }
}