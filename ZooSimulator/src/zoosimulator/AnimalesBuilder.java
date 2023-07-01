package zoosimulator;

import javax.swing.*;
/*
* Patron Builder Animales donde definimos nustras funciones a implementar
*/
public interface AnimalesBuilder {
    ImageIcon getImagen();
    void comer(int cantidadComida);
    boolean verificarNecesidades();
    boolean esHabitatAdecuado(String habitat);
}