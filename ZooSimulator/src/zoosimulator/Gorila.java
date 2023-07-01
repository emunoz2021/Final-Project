package zoosimulator;

import javax.swing.*;

public class Gorila implements AnimalesBuilder {
    private ImageIcon Gorila;
    private int alimentacion; 
    private String habitat;

    public Gorila(){
        Gorila = new ImageIcon("gorilla.png");
        alimentacion = 100;
        habitat = "Jungla"; 
    }

    @Override
    public ImageIcon getImagen() {
        return Gorila;
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