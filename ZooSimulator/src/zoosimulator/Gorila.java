package zoosimulator;

import javax.swing.*;

/*
 * Clase Gorilla que implementa el patron Builder
 * @field Gorilla, imagen que se le asignara un ImageIcon de Gorilla
 * @field alimentacion, entero que pensabamos usarlo para el momento de agregar comida
 * @field habitat, habitat que le gusta al animal
 */
public class Gorila implements AnimalesBuilder {
    private ImageIcon Gorila;
    private int alimentacion; 
    private String habitat;
    
    /*
    * Metodo constructor donde inicializamos los parametros
    */
    public Gorila(){
        Gorila = new ImageIcon("gorilla.png");
        alimentacion = 100;
        habitat = "Jungla"; 
    }
    
    /*
    * Metodo getImagen
    * @return ImagenIcon de Gorilla
    */
    @Override
    public ImageIcon getImagen() {
        return Gorila;
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