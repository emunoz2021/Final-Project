package zoosimulator;

import javax.swing.*;

public class Leon implements AnimalesBuilder{
    private ImageIcon Leon;
    private int alimentacion;
    private String habitat;

    public Leon(){
        Leon= new ImageIcon("leon.png");
        alimentacion = 100;
        habitat = "Sabana Africana";
    }

    @Override
    public ImageIcon getImagen() {
        return Leon;
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