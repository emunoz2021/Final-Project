    package zoosimulator;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.MouseAdapter;
    import java.awt.event.MouseEvent;
    /*
    * Clase que es la encargada de soltar a los Animales JLabel en los paneles
    * @field gorilla,jirafa, jlabel que usaremos para poner sus imagenes
    * @field mono, jirafa, ImageIcon que usamos inicializar sus imagenes
    * @field panelcito1, panelcito2, panelcito3, panelcito4, paneles donde pondremos las referencias a las jaulas
    * @field areaCaida1, areaCaida2, areaCaida3, areaCaida4, rectangulos donde cae el JLabel para que sea reemplazado
    */
    public class PanelDraggedAnimal extends JPanel {
        private JLabel gorila,jirafa,leon,cocodrilo;
        private ImageIcon mono,jira,leoncito,coco;
        private Point pPartida;
        private Jaula1 panelcito1;
        private Jaula2 panelcito2;
        private Jaula3 panelcito3;
        private Jaula4 panelcito4;
        private Rectangle areaCaida1,areaCaida2,areaCaida3,areaCaida4;
        /*
        *  Metodo constructor donde inicializamos las variables
        */
	public PanelDraggedAnimal(Jaula1 panel,Jaula2 panel2,Jaula3 panel3,Jaula4 panel4){
            setLayout(null);

            panelcito1=panel;
            panelcito2=panel2;
            panelcito3=panel3;
            panelcito4=panel4;

            areaCaida1=new Rectangle(173,0,300,200);
            areaCaida2=new Rectangle(434,0,300,200);
            areaCaida3=new Rectangle(173,390,221,234);
            areaCaida4=new Rectangle(548,386,235,230);

            mono=new ImageIcon("gorilla.png");
            gorila=new JLabel(mono);

            jira=new ImageIcon("jirafa.png");
            jirafa=new JLabel(jira);

            leoncito=new ImageIcon("leon.png");
            leon=new JLabel(leoncito);

            coco=new ImageIcon("cocodrilo.png");
            cocodrilo=new JLabel(coco);
            Oyentes();

            this.setOpaque(false);
        }
	/*
        *Metodo donde cargamos la imagen de gorilla y su setBounds
        */
        public void cargarImagenGori(){
            System.out.println("se toco");
            gorila.setBounds(190, 130, mono.getIconWidth(), mono.getIconHeight());
            add(gorila);

            revalidate();
            repaint();
        }
	/*
        *Metodo donde cargamos la imagen de jirafa y su setBounds
        */
        public void cargarImagenJira(){
            jirafa.setBounds(270, 130, jira.getIconWidth(), jira.getIconHeight());
            add(jirafa);

            revalidate();
            repaint();
        }
        /*
        *Metodo donde cargamos la imagen de leon y su setBounds
        */
        public void cargarImagenLeon(){
            leon.setBounds(190, 330, leoncito.getIconWidth(), leoncito.getIconHeight());
            add(leon);

            revalidate();
            repaint();
        }
	/*
        *Metodo donde cargamos la imagen de cocodrilo y su setBounds
        */
        public void cargarImagenCocodrilo(){
            cocodrilo.setBounds(270, 330, coco.getIconWidth(), coco.getIconHeight());
            add(cocodrilo);

            revalidate();
            repaint();
        }
  	/*
        * Metodo donde agrupamos los MouseListener para tener mejor orden
        */
        private void Oyentes(){
            oyenteGorila();
            oyenteJirafa();
            oyenteLeon();
            oyenteCocodrilo();
        }
	/*
        *Metodo MouseListener de Gorilla
        */
        private void oyenteGorila(){
                MouseAdapter mouseGorila = new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        pPartida= SwingUtilities.convertPoint(gorila,e.getPoint(),gorila.getParent());
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        Point localizacion = SwingUtilities.convertPoint(gorila, e.getPoint(), gorila.getParent());
                        if(areaCaida1.contains(localizacion)) {
                            panelcito1.coordenadasx= localizacion.x-195;
                            panelcito1.coordenadasy= localizacion.y-25;

                            panelcito1.AñadirAnimal(1);
                        }
                        else if(areaCaida2.contains(localizacion)) {
                            panelcito2.coordenadasx = localizacion.x -580; // Resta la posición x de la Jaula2
                            panelcito2.coordenadasy = localizacion.y - 25;   // Resta la posición y de la Jaula2

                            panelcito2.AñadirAnimal(1);

                        }
                        else if(areaCaida3.contains(localizacion)){
                            panelcito3.coordenadasx = localizacion.x - 195; // Resta la posición x de la Jaula3
                            panelcito3.coordenadasy = localizacion.y - 381;

                            panelcito3.AñadirAnimal(1);
                        }
                        else if(areaCaida4.contains(localizacion)){
                            panelcito4.coordenadasx = localizacion.x - 580; // Resta la posición x de la Jaula3
                            panelcito4.coordenadasy = localizacion.y - 378;

                            panelcito4.AñadirAnimal(1);
                        }

                        remove(gorila);
                        revalidate();
                        repaint();
                        pPartida=null;
                    }

                    @Override
                    public void mouseDragged(MouseEvent e){
                        Point localizacion=SwingUtilities.convertPoint(gorila,e.getPoint(),gorila.getParent());
                        if(gorila.getParent().getBounds().contains(localizacion)){
                            Point nuevaLocalizacion=gorila.getLocation();
                            nuevaLocalizacion.translate(localizacion.x-pPartida.x,localizacion.y-pPartida.y);
                            nuevaLocalizacion.x=Math.max(nuevaLocalizacion.x,0);
                            nuevaLocalizacion.y=Math.max(nuevaLocalizacion.y,0);
                            nuevaLocalizacion.x=Math.min(nuevaLocalizacion.x,gorila.getParent().getWidth()-gorila.getWidth());
                            nuevaLocalizacion.y=Math.min(nuevaLocalizacion.y,gorila.getParent().getHeight()-gorila.getHeight());
                            gorila.setLocation(nuevaLocalizacion);
                            pPartida=localizacion;
                        }
                    }
                };
                gorila.addMouseListener(mouseGorila);
                gorila.addMouseMotionListener(mouseGorila);
            }
	 /*
        *Metodo MouseListener de Jirafa
        */
        private void oyenteJirafa(){
            MouseAdapter mouseJirafa = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    pPartida= SwingUtilities.convertPoint(jirafa,e.getPoint(),jirafa.getParent());
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    Point localizacion = SwingUtilities.convertPoint(jirafa, e.getPoint(), jirafa.getParent());
                    if(areaCaida1.contains(localizacion)) {
                        panelcito1.coordenadasx= localizacion.x-195;
                        panelcito1.coordenadasy= localizacion.y-25;

                        panelcito1.AñadirAnimal(2);
                    }
                    else if(areaCaida2.contains(localizacion)) {
                        panelcito2.coordenadasx = localizacion.x -580; // Resta la posición x de la Jaula2
                        panelcito2.coordenadasy = localizacion.y - 25;   // Resta la posición y de la Jaula2

                        panelcito2.AñadirAnimal(2);

                    }
                    else if(areaCaida3.contains(localizacion)){
                        panelcito3.coordenadasx = localizacion.x - 195; // Resta la posición x de la Jaula3
                        panelcito3.coordenadasy = localizacion.y - 381;

                        panelcito3.AñadirAnimal(2);
                    }
                    else if(areaCaida4.contains(localizacion)){
                        panelcito4.coordenadasx = localizacion.x - 580; // Resta la posición x de la Jaula3
                        panelcito4.coordenadasy = localizacion.y - 378;

                        panelcito4.AñadirAnimal(2);
                    }

                    remove(jirafa);
                    revalidate();
                    repaint();
                    pPartida=null;
                }

                @Override
                public void mouseDragged(MouseEvent e){
                    Point localizacion=SwingUtilities.convertPoint(jirafa,e.getPoint(),jirafa.getParent());
                    if(jirafa.getParent().getBounds().contains(localizacion)){
                        Point nuevaLocalizacion=jirafa.getLocation();
                        nuevaLocalizacion.translate(localizacion.x-pPartida.x,localizacion.y-pPartida.y);
                        nuevaLocalizacion.x=Math.max(nuevaLocalizacion.x,0);
                        nuevaLocalizacion.y=Math.max(nuevaLocalizacion.y,0);
                        nuevaLocalizacion.x=Math.min(nuevaLocalizacion.x,jirafa.getParent().getWidth()-jirafa.getWidth());
                        nuevaLocalizacion.y=Math.min(nuevaLocalizacion.y,jirafa.getParent().getHeight()-jirafa.getHeight());
                        jirafa.setLocation(nuevaLocalizacion);
                        pPartida=localizacion;
                    }
                }
            };
            jirafa.addMouseListener(mouseJirafa);
            jirafa.addMouseMotionListener(mouseJirafa);
        }
	 /*
        *Metodo MouseListener de Leon
        */
        private void oyenteLeon(){
            MouseAdapter mouseLeon = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    pPartida= SwingUtilities.convertPoint(leon,e.getPoint(),leon.getParent());
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    Point localizacion = SwingUtilities.convertPoint(leon, e.getPoint(), leon.getParent());
                    if(areaCaida1.contains(localizacion)) {
                        panelcito1.coordenadasx= localizacion.x-195;
                        panelcito1.coordenadasy= localizacion.y-25;

                        panelcito1.AñadirAnimal(3);
                    }
                    else if(areaCaida2.contains(localizacion)) {
                        panelcito2.coordenadasx = localizacion.x -580; // Resta la posición x de la Jaula2
                        panelcito2.coordenadasy = localizacion.y - 25;   // Resta la posición y de la Jaula2

                        panelcito2.AñadirAnimal(3);

                    }
                    else if(areaCaida3.contains(localizacion)){
                        panelcito3.coordenadasx = localizacion.x - 195; // Resta la posición x de la Jaula3
                        panelcito3.coordenadasy = localizacion.y - 381;

                        panelcito3.AñadirAnimal(3);
                    }
                    else if(areaCaida4.contains(localizacion)){
                        panelcito4.coordenadasx = localizacion.x - 580; // Resta la posición x de la Jaula3
                        panelcito4.coordenadasy = localizacion.y - 378;

                        panelcito4.AñadirAnimal(3);
                    }

                    remove(leon);
                    revalidate();
                    repaint();
                    pPartida=null;
                }

                @Override
                public void mouseDragged(MouseEvent e){
                    Point localizacion=SwingUtilities.convertPoint(leon,e.getPoint(),leon.getParent());
                    if(leon.getParent().getBounds().contains(localizacion)){
                        Point nuevaLocalizacion=leon.getLocation();
                        nuevaLocalizacion.translate(localizacion.x-pPartida.x,localizacion.y-pPartida.y);
                        nuevaLocalizacion.x=Math.max(nuevaLocalizacion.x,0);
                        nuevaLocalizacion.y=Math.max(nuevaLocalizacion.y,0);
                        nuevaLocalizacion.x=Math.min(nuevaLocalizacion.x,leon.getParent().getWidth()-leon.getWidth());
                        nuevaLocalizacion.y=Math.min(nuevaLocalizacion.y,leon.getParent().getHeight()-leon.getHeight());
                        leon.setLocation(nuevaLocalizacion);
                        pPartida=localizacion;
                    }
                }
            };
            leon.addMouseListener(mouseLeon);
            leon.addMouseMotionListener(mouseLeon);
        }
  	/*
        *Metodo MouseListener de Cocodrilo
        */
        private void oyenteCocodrilo(){
            MouseAdapter mouseCocodrilo = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    pPartida= SwingUtilities.convertPoint(cocodrilo,e.getPoint(),cocodrilo.getParent());
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    Point localizacion = SwingUtilities.convertPoint(cocodrilo, e.getPoint(), cocodrilo.getParent());
                    if(areaCaida1.contains(localizacion)) {
                        panelcito1.coordenadasx= localizacion.x-195;
                        panelcito1.coordenadasy= localizacion.y-25;

                        panelcito1.AñadirAnimal(4);
                    }
                    else if(areaCaida2.contains(localizacion)) {
                        panelcito2.coordenadasx = localizacion.x -580; // Resta la posición x de la Jaula2
                        panelcito2.coordenadasy = localizacion.y - 25;   // Resta la posición y de la Jaula2

                        panelcito2.AñadirAnimal(4);

                    }
                    else if(areaCaida3.contains(localizacion)){
                        panelcito3.coordenadasx = localizacion.x - 195; // Resta la posición x de la Jaula3
                        panelcito3.coordenadasy = localizacion.y - 381;

                        panelcito3.AñadirAnimal(4);
                    }
                    else if(areaCaida4.contains(localizacion)){
                        panelcito4.coordenadasx = localizacion.x - 580; // Resta la posición x de la Jaula3
                        panelcito4.coordenadasy = localizacion.y - 378;

                        panelcito4.AñadirAnimal(4);
                    }

                    remove(cocodrilo);
                    revalidate();
                    repaint();
                    pPartida=null;
                }

                @Override
                public void mouseDragged(MouseEvent e){
                    Point localizacion=SwingUtilities.convertPoint(cocodrilo,e.getPoint(),cocodrilo.getParent());
                    if(cocodrilo.getParent().getBounds().contains(localizacion)){
                        Point nuevaLocalizacion=cocodrilo.getLocation();
                        nuevaLocalizacion.translate(localizacion.x-pPartida.x,localizacion.y-pPartida.y);
                        nuevaLocalizacion.x=Math.max(nuevaLocalizacion.x,0);
                        nuevaLocalizacion.y=Math.max(nuevaLocalizacion.y,0);
                        nuevaLocalizacion.x=Math.min(nuevaLocalizacion.x,cocodrilo.getParent().getWidth()-cocodrilo.getWidth());
                        nuevaLocalizacion.y=Math.min(nuevaLocalizacion.y,cocodrilo.getParent().getHeight()-cocodrilo.getHeight());
                        cocodrilo.setLocation(nuevaLocalizacion);
                        pPartida=localizacion;
                    }
                }
            };
            cocodrilo.addMouseListener(mouseCocodrilo);
            cocodrilo.addMouseMotionListener(mouseCocodrilo);
        }

    }
