import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class GestorClases implements Serializable {
    private List<ClaseMusical> clases;
    
    
    public GestorClases() {
        this.clases = new ArrayList<>();
    }
    
    // Métodos para gestión de clases
    public void crearClase(String codigo, String nombre, Profesor profesor, 
                          Horario horario, int capacidadMaxima) {
        // Verificar si ya existe una clase con el mismo código
        if (buscarClase(codigo) != null) {
            throw new IllegalArgumentException("Ya existe una clase con ese código");
        }
        
        // Verificar si el profesor ya tiene una clase en ese horario
        for (ClaseMusical clase : clases) {
            if (clase.getProfesor().equals(profesor) && 
                clase.getHorario().getDia() == horario.getDia() &&
                hayConflictoHorario(clase.getHorario(), horario)) {
                throw new IllegalStateException("El profesor ya tiene una clase en ese horario");
            }
        }
        
        ClaseMusical nuevaClase = new ClaseMusical(codigo, nombre, profesor, horario, capacidadMaxima);
        clases.add(nuevaClase);
    }
    
    public void inscribirEstudiante(String codigoClase, Estudiante estudiante) {
        ClaseMusical clase = buscarClase(codigoClase);
        if (clase == null) {
            throw new IllegalArgumentException("No existe una clase con ese código");
        }
        
        // Verificar si el estudiante ya tiene una clase en ese horario
        for (ClaseMusical c : clases) {
            if (c.getEstudiantes().contains(estudiante) && 
                c.getHorario().getDia() == clase.getHorario().getDia() &&
                hayConflictoHorario(c.getHorario(), clase.getHorario())) {
                throw new IllegalStateException("El estudiante ya tiene una clase en ese horario");
            }
        }
        
        clase.agregarEstudiante(estudiante);
    }
    
    public void registrarAsistencia(String codigoClase, LocalDate fecha, 
                                  Estudiante estudiante, boolean asistio) {
        ClaseMusical clase = buscarClase(codigoClase);
        if (clase == null) {
            throw new IllegalArgumentException("No existe una clase con ese código");
        }
        
        clase.registrarAsistencia(fecha, estudiante, asistio);
    }
    
    public void registrarCalificacion(String codigoClase, Estudiante estudiante, 
                                    double calificacion) {
        ClaseMusical clase = buscarClase(codigoClase);
        if (clase == null) {
            throw new IllegalArgumentException("No existe una clase con ese código");
        }
        
        clase.registrarCalificacion(estudiante, calificacion);
    }
    
    public ClaseMusical buscarClase(String codigo) {
        for (ClaseMusical clase : clases) {
            if (clase.getCodigo().equals(codigo)) {
                return clase;
            }
        }
        return null;
    }
    
    public List<ClaseMusical> getClasesProfesor(Profesor profesor) {
        List<ClaseMusical> clasesProfesor = new ArrayList<>();
        for (ClaseMusical clase : clases) {
            if (clase.getProfesor().equals(profesor)) {
                clasesProfesor.add(clase);
            }
        }
        return clasesProfesor;
    }
    
    public List<ClaseMusical> getClasesEstudiante(Estudiante estudiante) {
        List<ClaseMusical> clasesEstudiante = new ArrayList<>();
        for (ClaseMusical clase : clases) {
            if (clase.getEstudiantes().contains(estudiante)) {
                clasesEstudiante.add(clase);
            }
        }
        return clasesEstudiante;
    }
    
    private boolean hayConflictoHorario(Horario horario1, Horario horario2) {
        return !(horario1.getHoraFin().isBefore(horario2.getHoraInicio()) || 
                horario1.getHoraInicio().isAfter(horario2.getHoraFin()));
    }
    
    
    public void guardarDatos(String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar los datos: " + e.getMessage());
        }
    }
    
    public static GestorClases cargarDatos(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (GestorClases) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error al cargar los datos: " + e.getMessage());
        }
    }
    
    // Getter para la lista de clases
    public List<ClaseMusical> getClases() {
        return new ArrayList<>(clases);
    }
}