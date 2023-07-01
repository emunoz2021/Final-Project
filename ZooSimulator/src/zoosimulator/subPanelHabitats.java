package zoosimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;
import java.awt.Rectangle;

public class subPanelHabitats extends JPanel{
    private MouseAdapter mouseJungla;
    private Rectangle areaCaida1,areaCaida2,areaCaida3,areaCaida4;
    private JLabel Jungla,Desierto;
    private ImageIcon[] JunglaFinal=new ImageIcon[4],DesiertoFinal=new ImageIcon[4];
    private Point pPartida;
        public subPanelHabitats(){
        setLayout(null);
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
    @Override
    protected void paintComponent(Graphics g){
            super.paintComponent(g);
        if(JunglaFinal[0]!=null){
            g.drawImage(JunglaFinal[0].getImage(),173, 0, 221, 234,null);
        }
        if(JunglaFinal[1]!=null){
            g.drawImage(JunglaFinal[1].getImage(),548, 0, 233, 230,null);
        }
        if(JunglaFinal[2]!=null){
            g.drawImage(JunglaFinal[2].getImage(),173, 390, 221, 234,null);
        }
        if(JunglaFinal[3]!=null){
            g.drawImage(JunglaFinal[3].getImage(),548, 386, 235, 230,null);
        }
        if(DesiertoFinal[0]!=null){
            g.drawImage(DesiertoFinal[0].getImage(),173, 0, 221, 234,null);
        }
        if(DesiertoFinal[1]!=null){
            g.drawImage(DesiertoFinal[1].getImage(),548, 0, 233, 230,null);
        }
        if(DesiertoFinal[2]!=null){
            g.drawImage(DesiertoFinal[2].getImage(),173, 390, 221, 234,null);
        }
        if(DesiertoFinal[3]!=null){
            g.drawImage(DesiertoFinal[3].getImage(),548, 386, 235, 230,null);
        }
    }
    @SuppressWarnings("deprecation")
    private void oyenteJungla(){
         mouseJungla = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pPartida= SwingUtilities.convertPoint(Jungla,e.getPoint(),Jungla.getParent());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Point localizacion = SwingUtilities.convertPoint(Jungla, e.getPoint(), Jungla.getParent());
                if (areaCaida1.contains(localizacion)) {
                    JunglaFinal[0]=new ImageIcon("jungle.jpg");
                    DesiertoFinal[0]=null;
                }
                else if(areaCaida2.contains(localizacion)){
                    JunglaFinal[1]=new ImageIcon("jungle.jpg");
                    DesiertoFinal[1]=null;
                }
                else if(areaCaida3.contains(localizacion)){
                    JunglaFinal[2]=new ImageIcon("jungle.jpg");
                    DesiertoFinal[2]=null;
                }
                else if(areaCaida4.contains(localizacion)){
                    JunglaFinal[3]=new ImageIcon("jungle.jpg");
                    DesiertoFinal[3]=null;
                }
                //remove(Jungla);
                remove(Desierto);
                revalidate();
                repaint();
                pPartida=null;
                Jungla.removeMouseMotionListener(mouseJungla);
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
        Jungla.addMouseMotionListener(mouseJungla);  // esto es nuevo
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
                    DesiertoFinal[0]=new ImageIcon("desert.jpg");
                    JunglaFinal[0]=null;
                }
                else if(areaCaida2.contains(localizacion)){
                    DesiertoFinal[1]=new ImageIcon("desert.jpg");
                    JunglaFinal[1]=null;
                }
                else if(areaCaida3.contains(localizacion)){
                    DesiertoFinal[2]=new ImageIcon("desert.jpg");
                    JunglaFinal[2]=null;
                }
                else if(areaCaida4.contains(localizacion)){
                    DesiertoFinal[3]=new ImageIcon("desert.jpg");
                    JunglaFinal[3]=null;
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
        Desierto.addMouseMotionListener(mouseDesierto);  // esto es nuevo
    }
}
