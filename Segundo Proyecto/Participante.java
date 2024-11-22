import java.io.Serializable;

public class Participante implements Serializable {
    private Estudiante estudiante;
    private int ordenParticipacion;
    private String pieza;
    private int duracionMinutos;

    public Participante(Estudiante estudiante, int ordenParticipacion, String pieza, int duracionMinutos) {
        this.estudiante = estudiante;
        this.ordenParticipacion = ordenParticipacion;
        this.pieza = pieza;
        this.duracionMinutos = duracionMinutos;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public int getOrdenParticipacion() {
        return ordenParticipacion;
    }

    public void setOrdenParticipacion(int ordenParticipacion) {
        this.ordenParticipacion = ordenParticipacion;
    }

    public String getPieza() {
        return pieza;
    }

    public void setPieza(String pieza) {
        this.pieza = pieza;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Participante that = (Participante) obj;
        return estudiante.equals(that.estudiante);
    }

    @Override
    public int hashCode() {
        return estudiante.hashCode();
    }

    @Override
    public String toString() {
        return "Participante{" +
                "estudiante=" + estudiante.getNombre() +
                ", ordenParticipacion=" + ordenParticipacion +
                ", pieza='" + pieza + '\'' +
                ", duracionMinutos=" + duracionMinutos +
                '}';
    }
}