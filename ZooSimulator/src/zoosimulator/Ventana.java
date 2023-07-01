
package zoosimulator;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


/**
 *Clase Ventana, donde abrimos el JFrame y le agregamos el PanelPrincipal
 */

public class Ventana extends JFrame{
    PanelPrincipal panel;
    /**
     * Metodo Constructor de Ventana, donde le damos las caracteristicas que deseamos para nuestro JFrame
     */
    public Ventana(){
        this.setLayout(new BorderLayout());
        this.setSize(800, 650);
        panel = new PanelPrincipal(this);
        this.setTitle("Zoo-Simulator");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(panel,BorderLayout.CENTER); 
        setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

