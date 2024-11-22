public class Bateria extends Instrumento {
    private int numeroPiezas;
    private String tipoBateria; 
    
    public Bateria(String codigo, String marca, int numeroPiezas, String tipoBateria) {
        super(codigo, marca);
        this.numeroPiezas = numeroPiezas;
        this.tipoBateria = tipoBateria;
    }
    
    public int getNumeroPiezas() {
        return numeroPiezas;
    }
    
    public void setNumeroPiezas(int numeroPiezas) {
        this.numeroPiezas = numeroPiezas;
    }
    
    public String getTipoBateria() {
        return tipoBateria;
    }
    
    public void setTipoBateria(String tipoBateria) {
        this.tipoBateria = tipoBateria;
    }
    
    @Override
    public String toString() {
        return super.toString() + 
               ", Número de piezas: " + numeroPiezas + 
               ", Tipo: " + tipoBateria;
    }
}