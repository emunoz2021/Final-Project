package zoosimulator;

import javax.swing.*;

/*
 * Clase Jirafa que implementa el patron Builder
 * @field Jirafa, imagen que se le asignara un ImageIcon de Jirafa
 * @field alimentacion, entero que pensabamos usarlo para el momento de agregar comida
 * @field habitat, habitat que le gusta al animal
 */
public class Jirafa implements AnimalesBuilder {
    private ImageIcon Jirafa;
    private int alimentacion; 
    private String habitat; 
    
    /*
    * Metodo constructor donde inicializamos los parametros
    */
    public Jirafa(){
        Jirafa = new ImageIcon("jirafa.png");
        alimentacion = 100; 
        habitat = "Jungla"; 
    }
    
    /*
    * Metodo getImagen
    * @return ImagenIcon de Jirafa
    */
    @Override
    public ImageIcon getImagen() {
        return Jirafa;
    }

    /*
    * Metodo que establece la alimentacion nueva al momento de comer(no implementado)
    */
    public void comer(int cantidadComida) {
        alimentacion += cantidadComida;
    }
    
    /*
    * Metodo que con el cual pensabamos verificar las necesidades del Animal(no implementado)
    */
    public boolean verificarNecesidades() {
        return alimentacion > 0;
    }
    
    /*
    * Metodo que con el cual pensabamos verificar si el habitat es compatible con el Animal(no implementado)
    */
    public boolean esHabitatAdecuado(String habitat) {
        return this.habitat.equals(habitat);
    }
}