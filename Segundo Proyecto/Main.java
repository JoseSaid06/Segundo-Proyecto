import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Date;
import java.util.List;

public class Main {
    private static GestorPersonas gestorPersonas = new GestorPersonas();
    private static GestorInstrumentos gestorInstrumentos = new GestorInstrumentos();
    private static GestorClases gestorClases = new GestorClases();
    private static GestorEventos gestorEventos = new GestorEventos();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenuPrincipal();
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- Academia Melodía ---");
        System.out.println("1. Gestión de Personas");
        System.out.println("2. Gestión de Instrumentos");
        System.out.println("3. Gestión de Clases");
        System.out.println("4. Gestión de Eventos");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        switch (opcion) {
            case 1: menuPersonas(); break;
            case 2: menuInstrumentos(); break;
            case 3: menuClases(); break;
            case 4: menuEventos(); break;
            case 5: 
                System.out.println("Saliendo del sistema. ¡Hasta luego!");
                System.exit(0);
            default: System.out.println("Opción inválida.");
        }
    }

    private static void menuPersonas() {
        while (true) {
            System.out.println("\n--- Gestión de Personas ---");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Agregar Profesor");
            System.out.println("3. Agregar Personal Administrativo");
            System.out.println("4. Buscar Persona");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1: agregarEstudiante(); break;
                case 2: agregarProfesor(); break;
                case 3: agregarPersonalAdministrativo(); break;
                case 4: buscarPersona(); break;
                case 5: return;
                default: System.out.println("Opción inválida.");
            }
        }
    }

    private static void agregarEstudiante() {
        try {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();
            System.out.print("Instrumento: ");
            String instrumento = scanner.nextLine();
            
            System.out.println("Nivel del estudiante:");
            System.out.println("1. Básico");
            System.out.println("2. Intermedio");
            System.out.println("3. Avanzado");
            System.out.print("Seleccione nivel: ");
            int nivelOpcion = scanner.nextInt();
            
            Estudiante.NivelEstudiante nivel;
            switch (nivelOpcion) {
                case 1: nivel = Estudiante.NivelEstudiante.Basico; break;
                case 2: nivel = Estudiante.NivelEstudiante.Intermedio; break;
                case 3: nivel = Estudiante.NivelEstudiante.Avanzado; break;
                default: throw new IllegalArgumentException("Nivel inválido");
            }

            Estudiante estudiante = new Estudiante(nombre, edad, telefono, instrumento, nivel);
            gestorPersonas.agregarEstudiante(estudiante);
            System.out.println("Estudiante agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void agregarProfesor() {
        try {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();
            System.out.print("Instrumento que enseña: ");
            String instrumento = scanner.nextLine();
            
            System.out.println("Horario disponible:");
            System.out.println("1. Mañana");
            System.out.println("2. Tarde");
            System.out.print("Seleccione horario: ");
            int horarioOpcion = scanner.nextInt();
            
            Profesor.HorarioDisponible horario;
            horario = (horarioOpcion == 1) ? 
                Profesor.HorarioDisponible.Manana : 
                Profesor.HorarioDisponible.Tarde;

            Profesor profesor = new Profesor(nombre, edad, telefono, instrumento, horario);
            gestorPersonas.agregarProfesor(profesor);
            System.out.println("Profesor agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * 
     */
    private static void agregarPersonalAdministrativo() {
        try {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();
            System.out.print("Cargo: ");
            System.out.println("1. Secretaria");
            System.out.println("2. Coordinador");
            System.out.print("Seleccione cargo: ");
            int cargoOpcion = scanner.nextInt();
            scanner.nextLine(); 
        
            PersonalAdministrativo.CargoAdministrativo cargo;
        switch (cargoOpcion) {
            case 1: cargo = PersonalAdministrativo.CargoAdministrativo.Secretaria; break;
            case 2: cargo = PersonalAdministrativo.CargoAdministrativo.Coordinador; break;
            default: throw new IllegalArgumentException("Cargo inválido");
        }

        PersonalAdministrativo personal = new PersonalAdministrativo(nombre, edad, telefono, cargo);
        gestorPersonas.agregarPersonalAdmin(personal);
        System.out.println("Personal administrativo agregado exitosamente.");
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}

    private static void buscarPersona() {
        System.out.println("Buscar por:");
        System.out.println("1. Estudiante");
        System.out.println("2. Profesor");
        System.out.println("3. Personal Administrativo");
        System.out.print("Seleccione una opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea
        
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        
        try {
            switch (opcion) {
                case 1:
                    Estudiante estudiante = gestorPersonas.buscarEstudiante(nombre);
                    if (estudiante != null) {
                        System.out.println(estudiante);
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;
                case 2:
                    Profesor profesor = gestorPersonas.buscarProfesor(nombre);
                    if (profesor != null) {
                        System.out.println(profesor);
                    } else {
                        System.out.println("Profesor no encontrado.");
                    }
                    break;
                case 3:
                    PersonalAdministrativo personal = gestorPersonas.buscarPersonalAdmin(nombre);
                    if (personal != null) {
                        System.out.println(personal);
                    } else {
                        System.out.println("Personal administrativo no encontrado.");
                    }
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void menuInstrumentos() {
        while (true) {
            System.out.println("\n--- Gestión de Instrumentos ---");
            System.out.println("1. Agregar Instrumento");
            System.out.println("2. Prestar Instrumento");
            System.out.println("3. Registrar Devolución");
            System.out.println("4. Listar Instrumentos");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1: agregarInstrumento(); break;
                case 2: prestarInstrumento(); break;
                case 3: registrarDevolucion(); break;
                case 4: listarInstrumentos(); break;
                case 5: return;
                default: System.out.println("Opción inválida.");
            }
        }
    }

    private static void agregarInstrumento() {
        try {
            System.out.print("Código del instrumento: ");
            String codigo = scanner.nextLine();
            System.out.print("Nombre del instrumento: ");
            String nombre = scanner.nextLine();
            
            System.out.println("Tipo de instrumento:");
            System.out.println("1. Guitarra");
            System.out.println("2. Flauta");
            System.out.println("3. Bateria");
            System.out.print("Seleccione tipo: ");
            int tipoOpcion = scanner.nextInt();
            
            Instrumento.TipoInstrumento tipo;
            switch (tipoOpcion) {
                case 1: tipo = Instrumento.TipoInstrumento.Cuerda; break;
                case 2: tipo = Instrumento.TipoInstrumento.Viento; break;
                case 3: tipo = Instrumento.TipoInstrumento.Percusion; break;
                default: throw new IllegalArgumentException("Tipo inválido");
            }

            InstrumentoConcreto instrumento = new InstrumentoConcreto(codigo, nombre, tipo);
            gestorInstrumentos.agregarInstrumento(instrumento);
            System.out.println("Instrumento agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void prestarInstrumento() {
        try {
            System.out.print("Código del instrumento: ");
            String codigoInstrumento = scanner.nextLine();
            
            System.out.print("Nombre del estudiante: ");
            String nombreEstudiante = scanner.nextLine();
            
            Estudiante estudiante = gestorPersonas.buscarEstudiante(nombreEstudiante);
            if (estudiante == null) {
                System.out.println("Estudiante no encontrado.");
                return;
            }

            Prestamo prestamo = gestorInstrumentos.prestarInstrumento(codigoInstrumento, estudiante);
            System.out.println("Préstamo realizado exitosamente.");
            System.out.println(prestamo);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void registrarDevolucion() {
        try {
            System.out.print("ID del préstamo: ");
            String idPrestamo = scanner.nextLine();

            gestorInstrumentos.registrarDevolucion(idPrestamo);
            System.out.println("Devolución registrada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listarInstrumentos() {
        List<Instrumento> instrumentos = gestorInstrumentos.getInstrumentos();
        if (instrumentos.isEmpty()) {
            System.out.println("No hay instrumentos registrados.");
        } else {
            System.out.println("--- Instrumentos ---");
            for (Instrumento instrumento : instrumentos) {
                System.out.println(instrumento);
            }
        }
    }

    private static void menuClases() {
        while (true) {
            System.out.println("\n--- Gestión de Clases ---");
            System.out.println("1. Crear Clase");
            System.out.println("2. Inscribir Estudiante");
            System.out.println("3. Registrar Asistencia");
            System.out.println("4. Registrar Calificación");
            System.out.println("5. Listar Clases");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1: crearClase(); break;
                case 2: inscribirEstudiante(); break;
                case 3: registrarAsistencia(); break;
                case 4: registrarCalificacion(); break;
                case 5: listarClases(); break;
                case 6: return;
                default: System.out.println("Opción inválida.");
            }
        }
    }

    private static void inscribirEstudiante() {
        try {
            System.out.print("Código de la clase: ");
            String codigoClase = scanner.nextLine();
            
            System.out.print("Nombre del estudiante: ");
            String nombreEstudiante = scanner.nextLine();
            
            Estudiante estudiante = gestorPersonas.buscarEstudiante(nombreEstudiante);
            if (estudiante == null) {
                System.out.println("Estudiante no encontrado.");
                return;
            }
            
            gestorClases.inscribirEstudiante(codigoClase, estudiante);
            System.out.println("Estudiante inscrito exitosamente.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void registrarAsistencia() {
        try {
            System.out.print("Código de la clase: ");
            String codigoClase = scanner.nextLine();
            
            System.out.print("Nombre del estudiante: ");
            String nombreEstudiante = scanner.nextLine();
            
            Estudiante estudiante = gestorPersonas.buscarEstudiante(nombreEstudiante);
            if (estudiante == null) {
                System.out.println("Estudiante no encontrado.");
                return;
            }
            
            System.out.print("Fecha (yyyy-MM-dd): ");
            LocalDate fecha = LocalDate.parse(scanner.nextLine());
            
            System.out.print("¿Asistió? (true/false): ");
            boolean asistio = scanner.nextBoolean();
            
            gestorClases.registrarAsistencia(codigoClase, fecha, estudiante, asistio);
            System.out.println("Asistencia registrada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void registrarCalificacion() {
        try {
            System.out.print("Código de la clase: ");
            String codigoClase = scanner.nextLine();
            
            System.out.print("Nombre del estudiante: ");
            String nombreEstudiante = scanner.nextLine();
            
            Estudiante estudiante = gestorPersonas.buscarEstudiante(nombreEstudiante);
            if (estudiante == null) {
                System.out.println("Estudiante no encontrado.");
                return;
            }
            
            System.out.print("Calificación: ");
            double calificacion = scanner.nextDouble();
            
            gestorClases.registrarCalificacion(codigoClase, estudiante, calificacion);
            System.out.println("Calificación registrada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listarClases() {
        List<ClaseMusical> clases = gestorClases.getClases();
        if (clases.isEmpty()) {
            System.out.println("No hay clases registradas.");
            return;
        }
        
        System.out.println("--- Clases Registradas ---");
        for (ClaseMusical clase : clases) {
            System.out.println("Código: " + clase.getCodigo());
            System.out.println("Nombre: " + clase.getNombre());
            System.out.println("Profesor: " + clase.getProfesor().getNombre());
            System.out.println("Horario: " + clase.getHorario());
            System.out.println("Capacidad Máxima: " + clase.getCapacidadMaxima());
            System.out.println("Estudiantes Inscritos: " + clase.getEstudiantes().size());
            System.out.println("--------------------");
        }
    }

    private static void crearClase() {
        try {
            System.out.print("Código de la clase: ");
            String codigo = scanner.nextLine();
            System.out.print("Nombre de la clase: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Nombre del profesor: ");
            String nombreProfesor = scanner.nextLine();
            Profesor profesor = gestorPersonas.buscarProfesor(nombreProfesor);
            if (profesor == null) {
                System.out.println("Profesor no encontrado.");
                return;
            }
            
            System.out.println("Día de la clase:");
            for (int i = 0; i < DayOfWeek.values().length; i++) {
                System.out.println((i+1) + ". " + DayOfWeek.values()[i]);
            }
            System.out.print("Seleccione día: ");
            int diaOpcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            DayOfWeek dia = DayOfWeek.values()[diaOpcion - 1];
            
            System.out.print("Hora de inicio (HH:MM): ");
            LocalTime horaInicio = LocalTime.parse(scanner.nextLine());
            System.out.print("Hora de fin (HH:MM): ");
            LocalTime horaFin = LocalTime.parse(scanner.nextLine());
            
            System.out.print("Aula: ");
            String aula = scanner.nextLine();
            
            Horario horario = new Horario(dia, horaInicio, horaFin, aula);
            
            System.out.print("Capacidad máxima: ");
            int capacidadMaxima = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            gestorClases.crearClase(codigo, nombre, profesor, horario, capacidadMaxima);
            System.out.println("Clase creada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al crear la clase: " + e.getMessage());
        }
    }
    private static void menuEventos() {
    while (true) {
        System.out.println("\n--- Gestión de Eventos ---");
        System.out.println("1. Crear Recital");
        System.out.println("2. Agregar Participante a Recital");
        System.out.println("3. Modificar Orden de Participación");
        System.out.println("4. Listar Recitales");
        System.out.println("5. Eliminar Recital");
        System.out.println("6. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        switch (opcion) {
            case 1: crearRecital(); break;
            case 2: agregarParticipanteRecital(); break;
            case 3: modificarOrdenParticipacion(); break;
            case 4: listarRecitales(); break;
            case 5: eliminarRecital(); break;
            case 6: return;
            default: System.out.println("Opción inválida.");
        }
    }
}

private static void crearRecital() {
    try {
        System.out.print("Nombre del recital: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Fecha y hora (yyyy-MM-dd HH:mm): ");
        String fechaHoraStr = scanner.nextLine();
        Date fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(fechaHoraStr);
        
        System.out.print("Ubicación: ");
        String ubicacion = scanner.nextLine();
        
        gestorEventos.crearRecital(nombre, fechaHora, ubicacion);
        System.out.println("Recital creado exitosamente.");
    } catch (Exception e) {
        System.out.println("Error al crear recital: " + e.getMessage());
    }
}

private static void agregarParticipanteRecital() {
    try {
        System.out.println("Recitales disponibles:");
        List<Recital> recitales = gestorEventos.obtenerRecitales();
        for (int i = 0; i < recitales.size(); i++) {
            Recital r = recitales.get(i);
            System.out.println((i+1) + ". " + r.getNombre() + " - " + r.getFechaHora());
        }
        
        System.out.print("Seleccione un recital (número): ");
        int indiceRecital = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir salto de línea
        
        Recital recitalSeleccionado = recitales.get(indiceRecital);
        
        System.out.print("Nombre del estudiante: ");
        String nombreEstudiante = scanner.nextLine();
        Estudiante estudiante = gestorPersonas.buscarEstudiante(nombreEstudiante);
        
        if (estudiante == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }
        
        System.out.print("Pieza musical: ");
        String pieza = scanner.nextLine();
        
        System.out.print("Duración (minutos): ");
        int duracion = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea
        
        gestorEventos.agregarParticipante(recitalSeleccionado, estudiante, pieza, duracion);
        System.out.println("Participante agregado exitosamente.");
    } catch (Exception e) {
        System.out.println("Error al agregar participante: " + e.getMessage());
    }
}

private static void modificarOrdenParticipacion() {
    try {
        System.out.println("Recitales disponibles:");
        List<Recital> recitales = gestorEventos.obtenerRecitales();
        for (int i = 0; i < recitales.size(); i++) {
            Recital r = recitales.get(i);
            System.out.println((i+1) + ". " + r.getNombre() + " - " + r.getFechaHora());
        }
        
        System.out.print("Seleccione un recital (número): ");
        int indiceRecital = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir salto de línea
        
        Recital recitalSeleccionado = recitales.get(indiceRecital);
        
        List<Participante> participantes = gestorEventos.obtenerListaParticipantes(recitalSeleccionado);
        
        System.out.println("Participantes actuales:");
        for (int i = 0; i < participantes.size(); i++) {
            Participante p = participantes.get(i);
            System.out.println((i+1) + ". " + p.getEstudiante().getNombre() + " - " + p.getPieza());
        }
        
        System.out.print("Seleccione participante a modificar (número): ");
        int indiceParticipante = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir salto de línea
        
        Participante participante = participantes.get(indiceParticipante);
        
        System.out.print("Nuevo orden de participación: ");
        int nuevoOrden = scanner.nextInt();
        scanner.nextLine(); 
        
        gestorEventos.modificarOrdenParticipacion(recitalSeleccionado, participante, nuevoOrden);
        System.out.println("Orden de participación modificado exitosamente.");
    } catch (Exception e) {
        System.out.println("Error al modificar orden: " + e.getMessage());
    }
}

private static void listarRecitales() {
    List<Recital> recitales = gestorEventos.obtenerRecitales();
    if (recitales.isEmpty()) {
        System.out.println("No hay recitales registrados.");
        return;
    }
    
    System.out.println("--- Recitales ---");
    for (Recital recital : recitales) {
        System.out.println("Nombre: " + recital.getNombre());
        System.out.println("Fecha y Hora: " + recital.getFechaHora());
        System.out.println("Ubicación: " + recital.getUbicacion());
        
        List<Participante> participantes = gestorEventos.obtenerListaParticipantes(recital);
        System.out.println("Participantes:");
        for (Participante participante : participantes) {
            System.out.println("  - " + participante.getEstudiante().getNombre() + 
                               " (Pieza: " + participante.getPieza() + 
                               ", Orden: " + participante.getOrdenParticipacion() + ")");
        }
        System.out.println("--------------------");
    }
}

private static void eliminarRecital() {
    try {
        System.out.println("Recitales disponibles:");
        List<Recital> recitales = gestorEventos.obtenerRecitales();
        for (int i = 0; i < recitales.size(); i++) {
            Recital r = recitales.get(i);
            System.out.println((i+1) + ". " + r.getNombre() + " - " + r.getFechaHora());
        }
        
        System.out.print("Seleccione un recital para eliminar (número): ");
        int indiceRecital = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir salto de línea
        
        Recital recitalSeleccionado = recitales.get(indiceRecital);
        
        gestorEventos.eliminarRecital(recitalSeleccionado);
        System.out.println("Recital eliminado exitosamente.");
    } catch (Exception e) {
        System.out.println("Error al eliminar recital: " + e.getMessage());
    }
}

}