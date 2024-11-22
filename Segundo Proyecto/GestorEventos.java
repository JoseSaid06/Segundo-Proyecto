import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorEventos implements Serializable {
    private List<Recital> recitales;
    private static final String ARCHIVO_RECITALES = "recitales.dat";

    public GestorEventos() {
        this.recitales = new ArrayList<>();
        cargarRecitales();
    }

    public void crearRecital(String nombre, Date fechaHora, String ubicacion) {
        Recital nuevoRecital = new Recital(nombre, fechaHora, ubicacion);
        recitales.add(nuevoRecital);
        guardarRecitales();
    }

    public void agregarParticipante(Recital recital, Estudiante estudiante, String pieza, int duracionMinutos) {
        if (recital == null || estudiante == null) {
            throw new IllegalArgumentException("El recital y el estudiante no pueden ser nulos");
        }

        int ordenParticipacion = recital.getParticipantes().size() + 1;
        Participante nuevoParticipante = new Participante(estudiante, ordenParticipacion, pieza, duracionMinutos);
        recital.agregarParticipante(nuevoParticipante);
        guardarRecitales();
    }

    public void modificarOrdenParticipacion(Recital recital, Participante participante, int nuevoOrden) {
        List<Participante> participantes = recital.getParticipantes();
        if (nuevoOrden <= 0 || nuevoOrden > participantes.size()) {
            throw new IllegalArgumentException("Orden de participación inválido");
        }

        participante.setOrdenParticipacion(nuevoOrden);
        
        // Reordenar otros participantes
        for (Participante p : participantes) {
            if (p != participante && p.getOrdenParticipacion() >= nuevoOrden) {
                p.setOrdenParticipacion(p.getOrdenParticipacion() + 1);
            }
        }
        guardarRecitales();
    }

    public List<Participante> obtenerListaParticipantes(Recital recital) {
        if (recital == null) {
            throw new IllegalArgumentException("El recital no existe");
        }
        List<Participante> participantes = new ArrayList<>(recital.getParticipantes());
        // Ordenar usando un comparador tradicional
        participantes.sort((p1, p2) -> p1.getOrdenParticipacion() - p2.getOrdenParticipacion());
        return participantes;
    }

    public List<Recital> obtenerRecitales() {
        return new ArrayList<>(recitales);
    }

    public void eliminarRecital(Recital recital) {
        recitales.remove(recital);
        guardarRecitales();
    }

    private void guardarRecitales() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_RECITALES))) {
            oos.writeObject(recitales);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar los recitales: " + e.getMessage());
        }
    }

    private void cargarRecitales() {
        File archivo = new File(ARCHIVO_RECITALES);
        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                ois.readObject();
                
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException("Error al cargar los recitales: " + e.getMessage());
            }
        }
    }
}