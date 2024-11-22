public class Guitarra extends Instrumento {
    private String tipoGuitarra; 
    private int numeroCuerdas;
    
    public Guitarra(String codigo, String marca, String tipoGuitarra, int numeroCuerdas) {
        super(codigo, marca);
        this.tipoGuitarra = tipoGuitarra;
        this.numeroCuerdas = numeroCuerdas;
    }
    
    public String getTipoGuitarra() {
        return tipoGuitarra;
    }
    
    public void setTipoGuitarra(String tipoGuitarra) {
        this.tipoGuitarra = tipoGuitarra;
    }
    
    public int getNumeroCuerdas() {
        return numeroCuerdas;
    }
    
    public void setNumeroCuerdas(int numeroCuerdas) {
        this.numeroCuerdas = numeroCuerdas;
    }
    
    @Override
    public String toString() {
        return super.toString() + 
               ", Tipo: " + tipoGuitarra + 
               ", Número de cuerdas: " + numeroCuerdas;
    }
}