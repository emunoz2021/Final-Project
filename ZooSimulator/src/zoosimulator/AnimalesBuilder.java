package zoosimulator;

import javax.swing.*;

public interface AnimalesBuilder {
    ImageIcon getImagen();
    void comer(int cantidadComida);
    boolean verificarNecesidades();
    boolean esHabitatAdecuado(String habitat);
}