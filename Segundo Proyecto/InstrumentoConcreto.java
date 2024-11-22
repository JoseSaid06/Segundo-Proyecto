public class InstrumentoConcreto extends Instrumento {
    private String nombre;
    private TipoInstrumento tipo;
    

    public InstrumentoConcreto(String codigo, String nombre, TipoInstrumento tipo) {
        super(codigo, "MarcaGenerica");
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoInstrumento getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return super.toString() + ", Nombre: " + nombre + ", Tipo: " + tipo;
    }
}