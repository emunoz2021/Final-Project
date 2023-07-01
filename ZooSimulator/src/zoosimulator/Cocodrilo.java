package zoosimulator;

import javax.swing.*;

/*
 * Clase Cocodrilo que implementa el patron Builder
 * @field Cocodrilo, imagen que se le asignara un ImageIcon de Cocodrilo
 * @field alimentacion, entero que pensabamos usarlo para el momento de agregar comida
 * @field habitat, habitat que le gusta al animal
 */
public class Cocodrilo implements AnimalesBuilder {
    private ImageIcon Cocodrilo;
    private int alimentacion; 
    private String habitat; 

    /*
    * Metodo constructor donde inicializamos los parametros
    */
    public Cocodrilo(){
        Cocodrilo = new ImageIcon("cocodrilo.jpg");
        alimentacion = 100; 
        habitat = "Desierto"; 
    }
    
   /*
    * Metodo getImagen
    * @return ImagenIcon de Cocodrilo
    */
    @Override
    public ImageIcon getImagen() {
        return Cocodrilo;
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