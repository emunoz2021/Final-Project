package zoosimulator;

import javax.swing.*;

public class Leon implements AnimalesBuilder {
    private ImageIcon Jirafa;
    private int alimentacion; 
    private String habitat; 

    public Leon(){
        Jirafa = new ImageIcon("leon.jpg");
        alimentacion = 100; 
        habitat = "Desierto"; 
    }

    @Override
    public ImageIcon getImagen() {
        return Jirafa;
    }

    public void comer(int cantidadComida) {
        alimentacion += cantidadComida;
    }

    public boolean verificarNecesidades() {
        return alimentacion > 0;
    }

    public boolean esHabitatAdecuado(String habitat) {
        return this.habitat.equals(habitat);
    }
}