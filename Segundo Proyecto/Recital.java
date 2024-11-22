import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Recital implements Serializable {
    private String nombre;
    private Date fechaHora;
    private List<Participante> participantes;
    private String ubicacion;

    public Recital(String nombre, Date fechaHora, String ubicacion) {
        this.nombre = nombre;
        this.fechaHora = fechaHora;
        this.ubicacion = ubicacion;
        this.participantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Participante> getParticipantes() {
        return new ArrayList<>(participantes);
    }

    public void agregarParticipante(Participante participante) {
        if (!participantes.contains(participante)) {
            participantes.add(participante);
        }
    }

    public void removerParticipante(Participante participante) {
        participantes.remove(participante);
    }

    @Override
    public String toString() {
        return "Recital{" +
                "nombre='" + nombre + '\'' +
                ", fechaHora=" + fechaHora +
                ", ubicacion='" + ubicacion + '\'' +
                ", número de participantes=" + participantes.size() +
                '}';
    }
}