
package zoosimulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Clase que es el Panel principal para los subpaneles correspondientes
 * @field frame, lo usamos para inicializar la referencia de frame de Ventana a PanelPrincipal
 * @field Zoo, ImageIcon de la imagen de fondo de Zoologico que la usaremos de fondo
 * @field botonPlay, boton play con el cual accederemos a PanelsubPrincipal
 * @field botonOption, boton que pensamos darle la funcionalidad de colocar musica y las reglas del juego, pero no lo usamos
 * @field botonExit, boton que cierra la ventana
*/

public class PanelPrincipal extends JPanel {
    private JFrame frame;
    PanelsubPrincipal subPane;
    ImageIcon Zoo;
    JButton botonPlay;
    JButton botonOption;
    JButton botonExit;
    
    /**
    * Metodo constructor de la clase, le asignamos al ImageIcon la imagen de "Zoo.jpg" y desactivamos el setLayout para desactivar el diseño predeterminado
    */
    PanelPrincipal(JFrame frame){
        this.frame = frame;
        Zoo = new ImageIcon("Zoo.jpg");
        
        setLayout(null);
    }
    /**
    *Metodo que pinta las componentes del PanelPrincipal mediante el metodo graphics a este panel
    */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Zoo.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        Botones();
    }
    
    /**
     *Metodo donde creamos los Botones, le asignamos sus medidas, posiciones y le colocamos imagenes
     */
    private void Botones(){
        botonPlay = new JButton();
        botonPlay.setBounds(337, 225, 120, 60);
        botonPlay.setOpaque(true);
        botonPlay.setBackground(Color.GREEN);
        ImageIcon playIm = new ImageIcon("Play5.jpg");
        botonPlay.setIcon(new ImageIcon(playIm.getImage().getScaledInstance(botonPlay.getWidth(), botonPlay.getHeight(), Image.SCALE_SMOOTH)));
        this.add(botonPlay);
    
        botonOption = new JButton();
        botonOption.setBounds(337, 300, 120, 60);
        botonOption.setOpaque(true);
        botonOption.setBackground(Color.GREEN);
        ImageIcon optionIm = new ImageIcon("Option.jpg");
        botonOption.setIcon(new ImageIcon(optionIm.getImage().getScaledInstance(botonOption.getWidth(), botonOption.getHeight(), Image.SCALE_SMOOTH)));
        this.add(botonOption);
  
        botonExit = new JButton();
        botonExit.setBounds(337, 375    , 120, 60);
        botonExit.setOpaque(true);
        botonExit.setBackground(Color.GREEN);
        ImageIcon exitIm = new ImageIcon("Exit.jpg");
        botonExit.setIcon(new ImageIcon(exitIm.getImage().getScaledInstance(botonExit.getWidth(), botonExit.getHeight(), Image.SCALE_SMOOTH)));
        this.add(botonExit);
        
        OyentesDeMouse();
    }
    /**
     * Metodo para tener todos los metodos MouseListener de los botones de PanelPrincipal para mantener el orden
     */
    private void OyentesDeMouse(){
        oyenteDePlay();
        oyenteDeOption();
        oyenteDeExit();
    }
    
    /**
    * Metodo MouseListener para el botonPlay, que usamos para cambiar al PanelSubPrincipal
    */
    
    private void oyenteDePlay(){
        MouseListener play = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Se Accedio al boton Play");
                subPane = new PanelsubPrincipal(frame);
                
                frame.setContentPane(subPane);
                frame.revalidate();
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}  
        };
    botonPlay.addMouseListener(play);
    }
    
    /**
    * Metodo MouseListener para el botonOption, el cual no usamos
    */
    
    private void oyenteDeOption() {
        MouseListener option = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Se Accedio al boton Option");
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        botonOption.addMouseListener(option);
    }
    
    /**
    * Metodo MouseListener para el botonExit, que cierra la ventana
    */
    private void oyenteDeExit() {
        MouseListener exit = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Se Accedio al boton Exit");
                frame.dispose();
            }   

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        botonExit.addMouseListener(exit);
    }   
}