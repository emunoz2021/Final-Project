package zoosimulator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
* Metodo donde implementamos los Botones de Animal para luego Agregarlos a los habitats
* @field botonGorilla, botonJirafa, botonLeon, botonCocodrilo, botones de Animales que luego son inicializados en el constructor
* @field ventanita, Jframe que usaremoe para remover y agregar el PanelBotonesAnimalesar
* @field panelsubPrincipal lo usamos para pasarselo a los botones en su constructor
* @field panelon referencia a las jaulas
*/
public class PanelBotonesAnimales extends JPanel {
    BotonGorilla botonGorilla;
    BotonJirafa botonJirafa;
    BotonLeon botonLeon;
    BotonCocodrilo botonCocodrilo;
    
    private JFrame ventanita;
    private PanelsubPrincipal panelSubPrincipal;
    private PanelDraggedAnimal panelon;
     /*
    *Metodo constructor donde inicializamos las variables y creamos los botones
    * @param panelSubPrincipal lo usamos para tener una referencia al PanelsubPrincipal y pasarlo luego a los Botones
    * @param panel inicializa panelon
    */
    public PanelBotonesAnimales(PanelsubPrincipal panelSubPrincipal,PanelDraggedAnimal panel) {
        this.panelSubPrincipal = panelSubPrincipal;
        this.panelon=panel;
        this.ventanita = panelSubPrincipal.getVentanita();
        setLayout(new GridLayout(2, 2));
        botonGorilla = new BotonGorilla(panelSubPrincipal);
        botonJirafa = new BotonJirafa(panelSubPrincipal);
        botonLeon = new BotonLeon(panelSubPrincipal);
        botonCocodrilo = new BotonCocodrilo(panelSubPrincipal);
        add(botonGorilla);
        add(botonJirafa);
        add(botonLeon);
        add(botonCocodrilo);

        oyenteDeCargaExtra();
    }
      /*
    * Metodo que usamos para ordenar de mejor manera nuestros metodos MouseListener
    */
    private void oyenteDeCargaExtra(){
        oyenteBotonGorilla();
        oyenteBotonJirafa();
        oyenteBotonLeon();
        oyenteBotonCocodrilo();
    }

    /*
    * Metodo MouseListener de botonGorilla
    */
    private void oyenteBotonGorilla(){
        MouseListener listenerGorilla = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonGorilla.doClick();
                ventanita.getLayeredPane().remove(PanelBotonesAnimales.this);
                ventanita.revalidate();
                ventanita.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                panelon.cargarImagenGori();
                panelon.repaint();
                panelon.revalidate();
            }
            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        
        botonGorilla.addMouseListener(listenerGorilla);
    }
    /*
    * Metodo MouseListener de botonJirafa
    */
    private void oyenteBotonJirafa(){
        MouseListener listenerJirafa= new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonJirafa.doClick();
                ventanita.getLayeredPane().remove(PanelBotonesAnimales.this);
                ventanita.revalidate();
                ventanita.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                panelon.cargarImagenJira();
                panelon.repaint();
                panelon.revalidate();
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        botonJirafa.addMouseListener(listenerJirafa);
    }
    /*
    * Metodo MouseListener de botonLeon
    */
    private void oyenteBotonLeon(){
        MouseListener listenerLeon = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonLeon.doClick();
                ventanita.getLayeredPane().remove(PanelBotonesAnimales.this);
                ventanita.revalidate();
                ventanita.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                panelon.cargarImagenLeon();
                panelon.repaint();
                panelon.revalidate();
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        botonLeon.addMouseListener(listenerLeon);
    }
    /*
    * Metodo MouseListener de botonCocodrilo
    */
    private void oyenteBotonCocodrilo(){
        MouseListener listenerCocodrilo = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonCocodrilo.doClick();
                ventanita.getLayeredPane().remove(PanelBotonesAnimales.this);
                ventanita.revalidate();
                ventanita.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                panelon.cargarImagenCocodrilo();
                panelon.repaint();
                panelon.revalidate();
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        botonCocodrilo.addMouseListener(listenerCocodrilo);
    }
}