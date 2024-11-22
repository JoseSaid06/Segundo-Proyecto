import java.util.Date;
import java.io.Serializable;

public class Prestamo implements Serializable {
    private String id;
    private Instrumento instrumento;
    private Estudiante estudiante;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private boolean activo;
    
    public Prestamo(String id, Instrumento instrumento, Estudiante estudiante) {
        this.id = id;
        this.instrumento = instrumento;
        this.estudiante = estudiante;
        this.fechaPrestamo = new Date();
        this.activo = true;
    }
    
    public void registrarDevolucion() {
        this.fechaDevolucion = new Date();
        this.activo = false;
        this.instrumento.setEstado(Instrumento.EstadoInstrumento.Disponible);
    }
    
    // Getters
    public String getId() {
        return id;
    }
    
    public Instrumento getInstrumento() {
        return instrumento;
    }
    
    public Estudiante getEstudiante() {
        return estudiante;
    }
    
    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }
    
    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }
    
    public boolean isActivo() {
        return activo;
    }
    
    @Override
    public String toString() {
        return "ID Préstamo: " + id + 
               "\nInstrumento: " + instrumento.getCodigo() + 
               "\nEstudiante: " + estudiante.getNombre() + 
               "\nFecha Préstamo: " + fechaPrestamo + 
               "\nEstado: " + (activo ? "Activo" : "Devuelto") +
               (fechaDevolucion != null ? "\nFecha Devolución: " + fechaDevolucion : "");
    }
}