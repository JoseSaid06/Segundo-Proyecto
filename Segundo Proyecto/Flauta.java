public class Flauta extends Instrumento {
    private String tipoFlauta; 
    private String material;
    
    public Flauta(String codigo, String marca, String tipoFlauta, String material) {
        super(codigo, marca);
        this.tipoFlauta = tipoFlauta;
        this.material = material;
    }
    
    public String getTipoFlauta() {
        return tipoFlauta;
    }
    
    public void setTipoFlauta(String tipoFlauta) {
        this.tipoFlauta = tipoFlauta;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    
    @Override
    public String toString() {
        return super.toString() + 
               ", Tipo: " + tipoFlauta + 
               ", Material: " + material;
    }
}