
package zoosimulator;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *metodo main para llamar a la ventana y ocurran las acciones subsiguientes
 */
public class Ventana extends JFrame{
    PanelPrincipal panel;
    
    public Ventana(){
        this.setLayout(new BorderLayout());
        this.setSize(800, 650);
        panel = new PanelPrincipal(this);
        this.setTitle("Zoo-Simulator");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //cerrar aplicación
        this.add(panel,BorderLayout.CENTER); //se agrega al centro
        setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

