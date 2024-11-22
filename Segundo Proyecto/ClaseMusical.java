import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

public class ClaseMusical implements Serializable {
    private String codigo;
    private String nombre;
    private Profesor profesor;
    private List<Estudiante> estudiantes;
    private Horario horario;
    private int capacidadMaxima;
    private Map<LocalDate, Map<Estudiante, Boolean>> asistencias;
    private Map<Estudiante, List<Double>> calificaciones;
    
    public ClaseMusical(String codigo, String nombre, Profesor profesor, Horario horario, int capacidadMaxima) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = profesor;
        this.horario = horario;
        this.capacidadMaxima = capacidadMaxima;
        this.estudiantes = new ArrayList<>();
        this.asistencias = new HashMap<>();
        this.calificaciones = new HashMap<>();
    }
    
    public void agregarEstudiante(Estudiante estudiante) {
        if (estudiantes.size() >= capacidadMaxima) {
            throw new IllegalStateException("La clase ha alcanzado su capacidad máxima");
        }
        
        if (estudiantes.contains(estudiante)) {
            throw new IllegalArgumentException("El estudiante ya está inscrito en esta clase");
        }
        
        estudiantes.add(estudiante);
        calificaciones.put(estudiante, new ArrayList<>());
    }
    
    public void registrarAsistencia(LocalDate fecha, Estudiante estudiante, boolean asistio) {
        if (!estudiantes.contains(estudiante)) {
            throw new IllegalArgumentException("El estudiante no está inscrito en esta clase");
        }
        
        if (!asistencias.containsKey(fecha)) {
            asistencias.put(fecha, new HashMap<>());
        }
        
        asistencias.get(fecha).put(estudiante, asistio);
    }
    
    public void registrarCalificacion(Estudiante estudiante, double calificacion) {
        if (!estudiantes.contains(estudiante)) {
            throw new IllegalArgumentException("El estudiante no está inscrito en esta clase");
        }
        
        if (calificacion < 0.0 || calificacion > 5.0) {
            throw new IllegalArgumentException("La calificación debe estar entre 0.0 y 5.0");
        }
        
        calificaciones.get(estudiante).add(calificacion);
    }
    
    // Getters y setters
    public String getCodigo() {
        return codigo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Profesor getProfesor() {
        return profesor;
    }
    
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    public List<Estudiante> getEstudiantes() {
        return new ArrayList<>(estudiantes);
    }
    
    public Horario getHorario() {
        return horario;
    }
    
    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    
    public Map<LocalDate, Boolean> getAsistenciasEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            throw new IllegalArgumentException("El estudiante no está inscrito en esta clase");
        }
        
        Map<LocalDate, Boolean> asistenciasEstudiante = new HashMap<>();
        for (Map.Entry<LocalDate, Map<Estudiante, Boolean>> entry : asistencias.entrySet()) {
            if (entry.getValue().containsKey(estudiante)) {
                asistenciasEstudiante.put(entry.getKey(), entry.getValue().get(estudiante));
            }
        }
        return asistenciasEstudiante;
    }
    
    public List<Double> getCalificacionesEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            throw new IllegalArgumentException("El estudiante no está inscrito en esta clase");
        }
        return new ArrayList<>(calificaciones.get(estudiante));
    }
    
    @Override
    public String toString() {
        return "Clase: " + nombre + 
               "\nCódigo: " + codigo +
               "\nProfesor: " + profesor.getNombre() +
               "\nHorario: " + horario +
               "\nEstudiantes inscritos: " + estudiantes.size() + 
               "/" + capacidadMaxima;
    }
}