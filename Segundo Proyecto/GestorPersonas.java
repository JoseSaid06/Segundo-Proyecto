import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class GestorPersonas implements Serializable {
    private List<Estudiante> estudiantes;
    private List<Profesor> profesores;
    private List<PersonalAdministrativo> personalAdministrativo;
    
    public GestorPersonas() {
        estudiantes = new ArrayList<>();
        profesores = new ArrayList<>();
        personalAdministrativo = new ArrayList<>();
    }
    
    // Métodos para Estudiantes
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
    
    public void modificarEstudiante(String nombre, Estudiante estudianteModificado) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getNombre().equals(nombre)) {
                estudiantes.set(i, estudianteModificado);
                return;
            }
        }
        throw new IllegalArgumentException("Estudiante no encontrado");
    }
    
    public Estudiante buscarEstudiante(String nombre) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().equals(nombre)) {
                return estudiante;
            }
        }
        return null;
    }
    
    // Métodos para Profesores
    public void agregarProfesor(Profesor profesor) {
        profesores.add(profesor);
    }
    
    public void modificarProfesor(String nombre, Profesor profesorModificado) {
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getNombre().equals(nombre)) {
                profesores.set(i, profesorModificado);
                return;
            }
        }
        throw new IllegalArgumentException("Profesor no encontrado");
    }
    
    public Profesor buscarProfesor(String nombre) {
        for (Profesor profesor : profesores) {
            if (profesor.getNombre().equals(nombre)) {
                return profesor;
            }
        }
        return null;
    }
    
    // Métodos para Personal Administrativo
    public void agregarPersonalAdmin(PersonalAdministrativo personal) {
        personalAdministrativo.add(personal);
    }
    
    public void modificarPersonalAdmin(String nombre, PersonalAdministrativo personalModificado) {
        for (int i = 0; i < personalAdministrativo.size(); i++) {
            if (personalAdministrativo.get(i).getNombre().equals(nombre)) {
                personalAdministrativo.set(i, personalModificado);
                return;
            }
        }
        throw new IllegalArgumentException("Personal administrativo no encontrado");
    }
    
    public PersonalAdministrativo buscarPersonalAdmin(String nombre) {
        for (PersonalAdministrativo personal : personalAdministrativo) {
            if (personal.getNombre().equals(nombre)) {
                return personal;
            }
        }
        return null;
    }
    
    // Métodos para guardar y cargar datos
    public void guardarDatos(String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar los datos: " + e.getMessage());
        }
    }
    
    public static GestorPersonas cargarDatos(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (GestorPersonas) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error al cargar los datos: " + e.getMessage());
        }
    }
    
    // Getters para las listas
    public List<Estudiante> getEstudiantes() {
        return new ArrayList<>(estudiantes);
    }
    
    public List<Profesor> getProfesores() {
        return new ArrayList<>(profesores);
    }
    
    public List<PersonalAdministrativo> getPersonalAdministrativo() {
        return new ArrayList<>(personalAdministrativo);
    }
}