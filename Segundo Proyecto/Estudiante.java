public class Estudiante extends Persona {
    private String instrumento;
    private NivelEstudiante nivel;
    
    public enum NivelEstudiante {
        Basico,
        Intermedio,
        Avanzado
    }
    
    public Estudiante(String nombre, int edad, String telefono, String instrumento, NivelEstudiante nivel) {
        super(nombre, edad, telefono);
        this.instrumento = instrumento;
        this.nivel = nivel;
    }
    
    // Getters y setters específicos
    public String getInstrumento() {
        return instrumento;
    }
    
    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }
    
    public NivelEstudiante getNivel() {
        return nivel;
    }
    
    public void setNivel(NivelEstudiante nivel) {
        this.nivel = nivel;
    }
    
    @Override
    public String toString() {
        return super.toString() + 
               ", Instrumento: " + instrumento + 
               ", Nivel: " + nivel;
    }
}