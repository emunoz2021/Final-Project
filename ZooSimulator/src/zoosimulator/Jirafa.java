package zoosimulator;

import javax.swing.*;

public class Jirafa implements AnimalesBuilder{
    private ImageIcon Jirafa;
    public Jirafa(){
        Jirafa =new ImageIcon("jirafa.png");
    }
    @Override
    public ImageIcon getImagen() {
        return Jirafa;
    }
}