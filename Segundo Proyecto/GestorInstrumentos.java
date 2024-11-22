import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Date;

public class GestorInstrumentos implements Serializable {
    private List<Instrumento> instrumentos;
    private List<Prestamo> prestamos;
    
    
    public GestorInstrumentos() {
        instrumentos = new ArrayList<>();
        prestamos = new ArrayList<>();
    }
    
    // Métodos para gestión de instrumentos
    public void agregarInstrumento(Instrumento instrumento) {
        for (Instrumento i : instrumentos) {
            if (i.getCodigo().equals(instrumento.getCodigo())) {
                throw new IllegalArgumentException("Ya existe un instrumento con ese código");
            }
        }
        instrumentos.add(instrumento);
    }
    
    public Instrumento buscarInstrumento(String codigo) {
        for (Instrumento instrumento : instrumentos) {
            if (instrumento.getCodigo().equals(codigo)) {
                return instrumento;
            }
        }
        return null;
    }
    
    public void eliminarInstrumento(String codigo) {
        Instrumento instrumento = buscarInstrumento(codigo);
        if (instrumento != null) {
            if (instrumento.getEstado() == Instrumento.EstadoInstrumento.Prestado) {
                throw new IllegalStateException("No se puede eliminar un instrumento prestado");
            }
            instrumentos.remove(instrumento);
        }
    }
    
    // Métodos para gestión de préstamos
    public Prestamo prestarInstrumento(String codigoInstrumento, Estudiante estudiante) {
        Instrumento instrumento = buscarInstrumento(codigoInstrumento);
        if (instrumento == null) {
            throw new IllegalArgumentException("Instrumento no encontrado");
        }
        if (instrumento.getEstado() == Instrumento.EstadoInstrumento.Prestado) {
            throw new IllegalStateException("El instrumento ya está prestado");
        }
        
        // Verificar si el estudiante ya tiene un préstamo activo
        for (Prestamo p : prestamos) {
            if (p.getEstudiante().equals(estudiante) && p.isActivo()) {
                throw new IllegalStateException("El estudiante ya tiene un instrumento prestado");
            }
        }
        
        instrumento.setEstado(Instrumento.EstadoInstrumento.Prestado);
        String idPrestamo = generarIdPrestamo();
        Prestamo prestamo = new Prestamo(idPrestamo, instrumento, estudiante);
        prestamos.add(prestamo);
        return prestamo;
    }
    
    public void registrarDevolucion(String idPrestamo) {
        Prestamo prestamo = buscarPrestamo(idPrestamo);
        if (prestamo == null) {
            throw new IllegalArgumentException("Préstamo no encontrado");
        }
        if (!prestamo.isActivo()) {
            throw new IllegalStateException("El préstamo ya fue devuelto");
        }
        prestamo.registrarDevolucion();
    }
    
    public List<Prestamo> obtenerPrestamosPorEstudiante(Estudiante estudiante) {
        List<Prestamo> prestamosEstudiante = new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getEstudiante().equals(estudiante)) {
                prestamosEstudiante.add(prestamo);
            }
        }
        return prestamosEstudiante;
    }
    
    public List<Prestamo> obtenerPrestamosActivos() {
        List<Prestamo> prestamosActivos = new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if (prestamo.isActivo()) {
                prestamosActivos.add(prestamo);
            }
        }
        return prestamosActivos;
    }
    
    private Prestamo buscarPrestamo(String id) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getId().equals(id)) {
                return prestamo;
            }
        }
        return null;
    }
    
    private String generarIdPrestamo() {
        return "P" + (prestamos.size() + 1) + "-" + new Date().getTime();
    }
    
    // Métodos para persistencia
    public void guardarDatos(String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar los datos: " + e.getMessage());
        }
    }
    
    public static GestorInstrumentos cargarDatos(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (GestorInstrumentos) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error al cargar los datos: " + e.getMessage());
        }
    }
    
    // Getters para las listas
    public List<Instrumento> getInstrumentos() {
        return new ArrayList<>(instrumentos);
    }
    
    public List<Prestamo> getPrestamos() {
        return new ArrayList<>(prestamos);
    }
}