package zoosimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import java.awt.event.MouseAdapter;
import java.awt.Rectangle;

public class PanelDraggedHabitats extends JPanel{
    private Rectangle areaCaida1,areaCaida2,areaCaida3,areaCaida4;
    private JLabel Jungla,Desierto;
    private Jaula1 panelcito1;
    private Jaula2 panelcito2;
    private Jaula3 panelcito3;
    private Jaula4 panelcito4;
    private Point pPartida;
        public PanelDraggedHabitats(Jaula1 panel,Jaula2 panel2,Jaula3 panel3, Jaula4 panel4){
        setLayout(null);

        panelcito1=panel;
        panelcito2=panel2;
        panelcito3=panel3;
        panelcito4=panel4;

        areaCaida1=new Rectangle(173,0,300,200);
        areaCaida2=new Rectangle(434,0,300,200);
        areaCaida3=new Rectangle(173,390,221,234);
        areaCaida4=new Rectangle(548,386,235,230);

        cargarimagenes();
        this.setOpaque(false);
        }
    public void cargarimagenes(){
            ImageIcon imageDesert=new ImageIcon("desertinicial.jpg");
            ImageIcon imageJungle=new ImageIcon("jungleinicial.jpg");
            Jungla= new JLabel(imageJungle);
            Desierto=new JLabel(imageDesert);
            Jungla.setBounds(150,0,imageJungle.getIconWidth(),43);
            Desierto.setBounds(150,40,imageDesert.getIconWidth(),imageDesert.getIconHeight());
            add(Jungla);
            add(Desierto);
            oyenteMouse();
    }
    private void oyenteMouse(){
            oyenteJungla();
            oyenteDesierto();
    }
    @SuppressWarnings("deprecation")
    private void oyenteJungla() {
        MouseAdapter mouseJungla = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pPartida = SwingUtilities.convertPoint(Jungla, e.getPoint(), Jungla.getParent());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Point localizacion = SwingUtilities.convertPoint(Jungla, e.getPoint(), Jungla.getParent());
                if (areaCaida1.contains(localizacion)) {
                    panelcito1.cargarHabitat(1); 
                } else if (areaCaida2.contains(localizacion)) {
                    panelcito2.cargarHabitat(1);
                } else if (areaCaida3.contains(localizacion)) {
                    panelcito3.cargarHabitat(1);
                } else if (areaCaida4.contains(localizacion)) {
                    panelcito4.cargarHabitat(1);
                }
                remove(Jungla);
                remove(Desierto);
                revalidate();
                repaint();
                pPartida=null;
            }
            @Override
            public void mouseDragged(MouseEvent e){
                Point localizacion=SwingUtilities.convertPoint(Jungla,e.getPoint(),Jungla.getParent());
                if(Jungla.getParent().getBounds().contains(localizacion)){
                    Point nuevaLocalizacion=Jungla.getLocation();
                    nuevaLocalizacion.translate(localizacion.x-pPartida.x,localizacion.y-pPartida.y);
                    nuevaLocalizacion.x=Math.max(nuevaLocalizacion.x,0);
                    nuevaLocalizacion.y=Math.max(nuevaLocalizacion.y,0);
                    nuevaLocalizacion.x=Math.min(nuevaLocalizacion.x,Jungla.getParent().getWidth()-Jungla.getWidth());
                    nuevaLocalizacion.y=Math.min(nuevaLocalizacion.y,Jungla.getParent().getHeight()-Jungla.getHeight());
                    Jungla.setLocation(nuevaLocalizacion);
                    pPartida=localizacion;
                }
            }
        };
        Jungla.addMouseListener(mouseJungla);
        Jungla.addMouseMotionListener(mouseJungla); 
    }
    @SuppressWarnings("deprecation")
    private void oyenteDesierto(){
        MouseAdapter mouseDesierto = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pPartida= SwingUtilities.convertPoint(Desierto,e.getPoint(),Desierto.getParent());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Point localizacion = SwingUtilities.convertPoint(Desierto, e.getPoint(), Desierto.getParent());
                if (areaCaida1.contains(localizacion)) {
                   panelcito1.cargarHabitat(2);
                }
                else if(areaCaida2.contains(localizacion)){
                    panelcito2.cargarHabitat(2);
                }
                else if(areaCaida3.contains(localizacion)){
                    panelcito3.cargarHabitat(2);
                }
                else if(areaCaida4.contains(localizacion)){
                    panelcito4.cargarHabitat(2);
                }
                remove(Jungla);
                remove(Desierto);
                revalidate();
                repaint();
                pPartida=null;
            }

            @Override
            public void mouseDragged(MouseEvent e){
                Point localizacion=SwingUtilities.convertPoint(Desierto,e.getPoint(),Desierto.getParent());
                if(Desierto.getParent().getBounds().contains(localizacion)){
                    Point nuevaLocalizacion=Desierto.getLocation();
                    nuevaLocalizacion.translate(localizacion.x-pPartida.x,localizacion.y-pPartida.y);
                    nuevaLocalizacion.x=Math.max(nuevaLocalizacion.x,0);
                    nuevaLocalizacion.y=Math.max(nuevaLocalizacion.y,0);
                    nuevaLocalizacion.x=Math.min(nuevaLocalizacion.x,Desierto.getParent().getWidth()-Desierto.getWidth());
                    nuevaLocalizacion.y=Math.min(nuevaLocalizacion.y,Desierto.getParent().getHeight()-Desierto.getHeight());
                    Desierto.setLocation(nuevaLocalizacion);
                    pPartida=localizacion;
                }
            }
        };
        Desierto.addMouseListener(mouseDesierto);
        Desierto.addMouseMotionListener(mouseDesierto);
    }
}