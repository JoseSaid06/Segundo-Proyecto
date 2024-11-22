public class Profesor extends Persona {
    private String instrumentoEnsenado;
    private HorarioDisponible horario;
    
    public enum HorarioDisponible {
        Manana,
        Tarde
    }
    
    public Profesor(String nombre, int edad, String telefono, String instrumentoEnsenado, HorarioDisponible horario) {
        super(nombre, edad, telefono);
        this.instrumentoEnsenado = instrumentoEnsenado;
        this.horario = horario;
    }
    
    // Getters y setters específicos
    public String getInstrumentoEnsenado() {
        return instrumentoEnsenado;
    }
    
    public void setInstrumentoEnsenado(String instrumentoEnsenado) {
        this.instrumentoEnsenado = instrumentoEnsenado;
    }
    
    public HorarioDisponible getHorario() {
        return horario;
    }
    
    public void setHorario(HorarioDisponible horario) {
        this.horario = horario;
    }
    
    @Override
    public String toString() {
        return super.toString() + 
               ", Instrumento que enseña: " + instrumentoEnsenado + 
               ", Horario: " + horario;
    }
}