public class PersonalAdministrativo extends Persona {
    private CargoAdministrativo cargo;
    
    public enum CargoAdministrativo {
        Secretaria,
        Coordinador
    }
    
    public PersonalAdministrativo(String nombre, int edad, String telefono, CargoAdministrativo cargo) {
        super(nombre, edad, telefono);
        this.cargo = cargo;
    }
    
    // Getter y setter específico
    public CargoAdministrativo getCargo() {
        return cargo;
    }
    
    public void setCargo(CargoAdministrativo cargo) {
        this.cargo = cargo;
    }
    
    @Override
    public String toString() {
        return super.toString() + 
               ", Cargo: " + cargo;
    }
}