import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class Horario implements Serializable {
    private DayOfWeek dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String aula;
    
    public Horario(DayOfWeek dia, LocalTime horaInicio, LocalTime horaFin, String aula) {
        if (horaFin.isBefore(horaInicio)) {
            throw new IllegalArgumentException("La hora de fin no puede ser anterior a la hora de inicio");
        }
        
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.aula = aula;
    }
    
    // Getters y setters
    public DayOfWeek getDia() {
        return dia;
    }
    
    public void setDia(DayOfWeek dia) {
        this.dia = dia;
    }
    
    public LocalTime getHoraInicio() {
        return horaInicio;
    }
    
    public void setHoraInicio(LocalTime horaInicio) {
        if (horaFin != null && horaInicio.isAfter(horaFin)) {
            throw new IllegalArgumentException("La hora de inicio no puede ser posterior a la hora de fin");
        }
        this.horaInicio = horaInicio;
    }
    
    public LocalTime getHoraFin() {
        return horaFin;
    }
    
    public void setHoraFin(LocalTime horaFin) {
        if (horaFin.isBefore(horaInicio)) {
            throw new IllegalArgumentException("La hora de fin no puede ser anterior a la hora de inicio");
        }
        this.horaFin = horaFin;
    }
    
    public String getAula() {
        return aula;
    }
    
    public void setAula(String aula) {
        this.aula = aula;
    }
    
    @Override
    public String toString() {
        return dia + " de " + horaInicio + " a " + horaFin + " en el aula " + aula;
    }
}