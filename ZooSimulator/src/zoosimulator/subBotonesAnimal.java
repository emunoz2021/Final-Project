
package zoosimulator;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class subBotonesAnimal extends JPanel{
    private JButton botonGorilla, botonJirafa;
    private int coorx1=0,coorx2=0;
    PanelsubPrincipal panelPrincipal;
    
    public subBotonesAnimal(PanelsubPrincipal panel2) {
        setLayout(null);
        panelPrincipal= panel2;
        cargarBotones();
        this.setOpaque(false);
    }
    
    private void cargarBotones() {
        botonGorilla = new JButton("Gorilla");
        botonGorilla.setBounds(135, 150, 130, 81);
        botonGorilla.setOpaque(true);
        botonGorilla.setBackground(Color.WHITE);
        ImageIcon Gori = new ImageIcon("gorillaPerfil.jpg");
        botonGorilla.setIcon(new ImageIcon(Gori.getImage().getScaledInstance(botonGorilla.getWidth(), botonGorilla.getHeight(), Image.SCALE_SMOOTH)));
        this.add(botonGorilla);
        
        botonJirafa = new JButton("Jirafa");
        botonJirafa.setBounds(135, 235, 130, 81);
        botonJirafa.setOpaque(true);
        botonJirafa.setBackground(Color.WHITE);
        ImageIcon Jira = new ImageIcon("jirafaPerfil.jpg");
        botonJirafa.setIcon(new ImageIcon(Jira.getImage().getScaledInstance(botonJirafa.getWidth(), botonJirafa.getHeight(), Image.SCALE_SMOOTH)));
        this.add(botonJirafa);
        oyentesMouse();
    }

    private void oyentesMouse() {
        oyenteGorilla();
        oyenteJirafa();
    }

    private void oyenteGorilla() {
        MouseListener MouseGorilla = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("se apreto");
                remove(botonGorilla);
                remove(botonJirafa);
                cargarGorilla();
                /*panelPrincipal.revalidate();
                panelPrincipal.repaint();*/
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        botonGorilla.addMouseListener(MouseGorilla);
    }
    
    
    private void oyenteJirafa() {
        MouseListener MouseJirafa = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("se apreto");
                remove(botonGorilla);
                remove(botonJirafa);
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
                cargarJirafa();
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        botonJirafa.addMouseListener(MouseJirafa);
    }
    
    
    
    private void cargarJirafa(){
        ImageIcon image=new ImageIcon("jirafa.jpg");
        for(int i=-1; i < panelPrincipal.num1;i++) {
            if(i==4) break;
            JLabel Jirafa = new JLabel(image);
            Jirafa.setBounds(552+coorx2, 30, image.getIconWidth(), image.getIconHeight());
            add(Jirafa);
            coorx2+=40;
        }
        panelPrincipal.num1= panelPrincipal.num1+1;
        repaint();
    }
    private void cargarGorilla(){
        ImageIcon image=new ImageIcon("gorilla.jpg");
        for(int i=-1;i< panelPrincipal.num2;i++) {
            if(i==4) break;
            JLabel Gorilla = new JLabel(image);
            Gorilla.setBounds(190+coorx1, 30, image.getIconWidth(), image.getIconHeight());
            add(Gorilla);
            coorx1+=40;
        }
        panelPrincipal.num2= panelPrincipal.num2+1;
        repaint();
    }
}
