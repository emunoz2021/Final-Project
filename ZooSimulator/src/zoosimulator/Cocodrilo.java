package zoosimulator;

import javax.swing.*;

public class Cocodrilo implements AnimalesBuilder{
    private ImageIcon Cocodrilo;
    private int alimentacion;
    private String habitat;

    public Cocodrilo(){
        Cocodrilo= new ImageIcon("cocodrilo.png");
        alimentacion = 100;
        habitat = "Pantano";
    }

    @Override
    public ImageIcon getImagen() {
        return Cocodrilo;
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