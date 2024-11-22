import java.io.Serializable;

public abstract class Instrumento implements Serializable {
    private String codigo;
    private EstadoInstrumento estado;
    private String marca;
    
    public enum EstadoInstrumento {
        Disponible,
        Prestado
    }
    
    public enum TipoInstrumento {
        Cuerda,
        Viento,
        Percusion
    }
    
    public Instrumento(String codigo, String marca) {
        this.codigo = codigo;
        this.marca = marca;
        this.estado = EstadoInstrumento.Disponible;
        
    }
    
    // Getters y setters
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public EstadoInstrumento getEstado() {
        return estado;
    }
    
    public void setEstado(EstadoInstrumento estado) {
        this.estado = estado;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    @Override
    public String toString() {
        return "Código: " + codigo + 
               ", Marca: " + marca + 
               ", Estado: " + estado;
    }

    
}
