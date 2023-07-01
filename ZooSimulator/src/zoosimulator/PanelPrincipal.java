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
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class PanelPrincipal extends JPanel {
    private JFrame frame;
    PanelsubPrincipal prueba;
    ImageIcon Zoo;
    JButton botonPlay;
    JButton botonOption;
    JButton botonExit;
    
    
    PanelPrincipal(JFrame frame){
        this.frame = frame;
        Zoo = new ImageIcon("Zoo.jpg");
        
        setLayout(null);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Zoo.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        Botones();
    }
    
    
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
    
    private void OyentesDeMouse(){
        oyenteDePlay();
        oyenteDeOption();
        oyenteDeExit();
    }
    
    private void oyenteDePlay(){
        MouseListener play = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Se Accedio al boton Play");
                prueba= new PanelsubPrincipal(frame);
              
                frame.setContentPane(prueba);
                frame.revalidate();
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}  
        };
    botonPlay.addMouseListener(play);
    }
    
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