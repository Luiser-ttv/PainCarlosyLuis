
package codigo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Image;
import javax.swing.JPanel;


public class VentanaPaint extends javax.swing.JFrame {

    BufferedImage buffer, buffer2 = null;
    Forma miForma;
    Pipeta miPipeta;
    Color colorSeleccionado = Color.black; //Color por defecto
    int formaSeleccionada = 5000; //Selector de forma
    //Posiciones del lapiz
    int posLapizX = 0;
    int posLapizY = 0;
    int posLapizXX = 0;
    int posLapizYY = 0;
    //Buffers
    Graphics2D bufferGraphics, buffer2Graphics, jPanelGraphics = null;

    BasicStroke trazo1 = new BasicStroke(15);
    BasicStroke trazo2 = new BasicStroke(15, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[]{10.0f}, 0.0f);

    Spray miSpray = null;
    
    public VentanaPaint() {
	initComponents();
	jPanel2.setBackground(colorSeleccionado);
	jToggleButton1.setSelected(true);
	inicializaBuffers();
	jDialog1.setSize(678, 439);
	FileNameExtensionFilter jpg = new FileNameExtensionFilter("JPG", "jpg");
	FileNameExtensionFilter png = new FileNameExtensionFilter("PNG", "png");
	jFileChooser1.setFileFilter(jpg);
	jFileChooser1.setFileFilter(png);
	saveAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
	jMenuItem1.setAction(saveAction);
	loadAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
	jMenuItem2.setAction(loadAction);
    }

    private void inicializaBuffers() {
	//Crea una imagen del mismo ancho y alto que el lienzo
	buffer = (BufferedImage) jPanel1.createImage(jPanel1.getWidth(), jPanel1.getHeight());
	//Crea una imagen modificable
	bufferGraphics = buffer.createGraphics();
	//Inicializa el buffer para que sea un rectangulo que ocupe todo el jPanel
	bufferGraphics.setColor(Color.white);
	bufferGraphics.fillRect(0, 0, buffer.getWidth(), buffer.getHeight());

	//Inicializa buffer2
	//Crea una imagen del mismo ancho y alto que el lienzo
	buffer2 = (BufferedImage) jPanel1.createImage(jPanel1.getWidth(), jPanel1.getHeight());
	//Modifica la imagen modificable
	buffer2Graphics = buffer2.createGraphics();
	//Inicializa el buffer para que sea un rectangulo que ocupe todo el jPanel
	buffer2Graphics.setColor(Color.white);
	buffer2Graphics.fillRect(0, 0, buffer2.getWidth(), buffer2.getHeight());
	//Inicializa jPanelGraphics
	jPanelGraphics = (Graphics2D) jPanel1.getGraphics();
    }

    @Override
    public void paint(Graphics g) {
	super.paint(g);
	// Pinta el buffer sobre el jFrame
	jPanelGraphics.drawImage(buffer, 0, 0, null);
    }

    private void deSelecciona() {
	Component[] components = (Component[]) getContentPane().getComponents();
	for (Component comp : components) {
	    if (comp instanceof JToggleButton) {
		((JToggleButton) comp).setSelected(false);
	    }
	}
    }

    private void actualizaBuffers() {
	bufferGraphics.drawImage(buffer, 0, 0, null);
	buffer2Graphics.drawImage(buffer, 0, 0, null);
	bufferGraphics.drawImage(buffer2, 0, 0, null);
	buffer2Graphics.drawImage(buffer2, 0, 0, null);
    }
    //Public void para crear el metodo de guardado.
    private void guarda() {
	int seleccion = jFileChooser1.showSaveDialog(this);
	if (seleccion == JFileChooser.APPROVE_OPTION) {
	    //Botón de guardar presionado en cualquier JFileChooser
	    File fichero = jFileChooser1.getSelectedFile();
	    String nombre = fichero.getName();
	    String extension = nombre.substring(nombre.lastIndexOf('.') + 1);
	    if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("png")) {
		try {
		    ImageIO.write(buffer, extension, fichero);
		} catch (IOException e) {
		}
	    }
	}
    }
    //Public void para crear el metodo de carga.
    private void carga() {
	int seleccion = jFileChooser1.showOpenDialog(this);
	if (seleccion == JFileChooser.APPROVE_OPTION) {
	    File fichero = jFileChooser1.getSelectedFile();
	    String nombre = fichero.getName();
	    String extension = nombre.substring(nombre.lastIndexOf('.') + 1);
	    BufferedImage imagen = null;
	    if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("png")) {
		try {
		    imagen = ImageIO.read(fichero);
		    bufferGraphics.drawImage(imagen, 0, 0, null);
		    buffer2Graphics.drawImage(imagen, 0, 0, null);
		    repaint();
		} catch (IOException e) {
		}
	    }
	}
    }

    Action saveAction = new AbstractAction("Save") {
	@Override
	public void actionPerformed(ActionEvent e) {
	    guarda();
	}
    };

    Action loadAction = new AbstractAction("Load") {
	@Override
	public void actionPerformed(ActionEvent e) {
	    carga();
	}
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jColorChooser1 = new javax.swing.JColorChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jDialog2 = new javax.swing.JDialog();
        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jCheckBox2 = new javax.swing.JCheckBox();
        jSpinner1 = new javax.swing.JSpinner();
        jSlider1 = new javax.swing.JSlider();
        jCheckBox3 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jToggleButton6 = new javax.swing.JToggleButton();
        jToggleButton7 = new javax.swing.JToggleButton();
        jToggleButton8 = new javax.swing.JToggleButton();
        jToggleButton9 = new javax.swing.JToggleButton();
        jToggleButton10 = new javax.swing.JToggleButton();
        jToggleButton11 = new javax.swing.JToggleButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jDialog1.setResizable(false);

        jButton1.setText("Guardar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(75, 75, 75))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jDialog2.getContentPane().add(jFileChooser1, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1037, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );

        jCheckBox1.setText("Relleno");
        jCheckBox1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel2.setText("Color:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jToggleButton1.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Elipse.png"))); // NOI18N
        jToggleButton1.setMaximumSize(new java.awt.Dimension(36, 36));
        jToggleButton1.setMinimumSize(new java.awt.Dimension(36, 36));
        jToggleButton1.setPreferredSize(new java.awt.Dimension(36, 36));
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton1MousePressed(evt);
            }
        });

        jToggleButton2.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Rectangulo.png"))); // NOI18N
        jToggleButton2.setMaximumSize(new java.awt.Dimension(36, 36));
        jToggleButton2.setMinimumSize(new java.awt.Dimension(36, 36));
        jToggleButton2.setPreferredSize(new java.awt.Dimension(36, 36));
        jToggleButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton2MousePressed(evt);
            }
        });
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Triangle.png")));
        jToggleButton3.setMaximumSize(new java.awt.Dimension(36, 36));
        jToggleButton3.setMinimumSize(new java.awt.Dimension(36, 36));
        jToggleButton3.setPreferredSize(new java.awt.Dimension(36, 36));
        jToggleButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton3MousePressed(evt);
            }
        });
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pentagon.png")));
        jToggleButton4.setMaximumSize(new java.awt.Dimension(36, 36));
        jToggleButton4.setMinimumSize(new java.awt.Dimension(36, 36));
        jToggleButton4.setPreferredSize(new java.awt.Dimension(36, 36));
        jToggleButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton4MousePressed(evt);
            }
        });
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jToggleButton5.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        jToggleButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Forma.png"))); // NOI18N
        jToggleButton5.setMaximumSize(new java.awt.Dimension(36, 36));
        jToggleButton5.setMinimumSize(new java.awt.Dimension(36, 36));
        jToggleButton5.setPreferredSize(new java.awt.Dimension(36, 36));
        jToggleButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton5MousePressed(evt);
            }
        });

        jCheckBox2.setText("Efecto");
        jCheckBox2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jCheckBox2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox2StateChanged(evt);
            }
        });

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        jSpinner1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jSpinner1MousePressed(evt);
            }
        });

        jSlider1.setMinimum(1);
        jSlider1.setValue(1);
        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlider1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSlider1MouseDragged(evt);
            }
        });

        jCheckBox3.setText("Discontinuo");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jToggleButton6.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        jToggleButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Lapiz.png"))); // NOI18N
        jToggleButton6.setMaximumSize(new java.awt.Dimension(36, 36));
        jToggleButton6.setMinimumSize(new java.awt.Dimension(36, 36));
        jToggleButton6.setPreferredSize(new java.awt.Dimension(36, 36));
        jToggleButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton6MousePressed(evt);
            }
        });
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });

        jToggleButton7.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        jToggleButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Linea.png"))); // NOI18N
        jToggleButton7.setMaximumSize(new java.awt.Dimension(36, 36));
        jToggleButton7.setMinimumSize(new java.awt.Dimension(36, 36));
        jToggleButton7.setPreferredSize(new java.awt.Dimension(36, 36));
        jToggleButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton7MousePressed(evt);
            }
        });

        jToggleButton8.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        jToggleButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Spray.png"))); // NOI18N
        jToggleButton8.setMaximumSize(new java.awt.Dimension(36, 36));
        jToggleButton8.setMinimumSize(new java.awt.Dimension(36, 36));
        jToggleButton8.setPreferredSize(new java.awt.Dimension(36, 36));
        jToggleButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton8MousePressed(evt);
            }
        });
        jToggleButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton8ActionPerformed(evt);
            }
        });

        jToggleButton9.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        jToggleButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Goma.png"))); // NOI18N
        jToggleButton9.setMaximumSize(new java.awt.Dimension(36, 36));
        jToggleButton9.setMinimumSize(new java.awt.Dimension(36, 36));
        jToggleButton9.setPreferredSize(new java.awt.Dimension(36, 36));
        jToggleButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton9MousePressed(evt);
            }
        });
        jToggleButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton9ActionPerformed(evt);
            }
        });

        jToggleButton10.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        jToggleButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pipeta.png")));
        jToggleButton10.setMaximumSize(new java.awt.Dimension(36, 36));
        jToggleButton10.setMinimumSize(new java.awt.Dimension(36, 36));
        jToggleButton10.setPreferredSize(new java.awt.Dimension(36, 36));
        jToggleButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton10MousePressed(evt);
            }
        });
        jToggleButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton10ActionPerformed(evt);
            }
        });

        jToggleButton11.setText("jToggleButton11");

        jMenu1.setText("File");
        jMenu1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jMenu1StateChanged(evt);
            }
        });

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("New");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Guardar");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MousePressed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Cargar");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem2MousePressed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Extras");

        jMenuItem3.setText("Github");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jToggleButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jToggleButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jToggleButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jToggleButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jToggleButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButton11))
                        .addGap(8, 8, 8)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
	switch (formaSeleccionada) {
	    case 1:
		posLapizXX = evt.getX();
		posLapizYY = evt.getY();
		if (posLapizX != posLapizXX || posLapizY != posLapizYY) {
		    bufferGraphics.setColor(colorSeleccionado);
		    bufferGraphics.setStroke(new Trazo(jSlider1.getValue(), true, true));
		    bufferGraphics.drawLine(posLapizX, posLapizY, posLapizXX, posLapizYY);
		    posLapizX = posLapizXX;
		    posLapizY = posLapizYY;
		}
		break;
	    case 677:
		posLapizXX = evt.getX();
		posLapizYY = evt.getY();
		if (posLapizX != posLapizXX || posLapizY != posLapizYY) {
		    bufferGraphics.setColor(Color.WHITE);
		    bufferGraphics.setStroke(new Trazo(jSlider1.getValue(), true, true));
		    bufferGraphics.drawLine(posLapizX, posLapizY, posLapizXX, posLapizYY);
		    posLapizX = posLapizXX;
		    posLapizY = posLapizYY;
		}
		break;
                
                case 482:
                miSpray = new Spray(evt.getX(), evt.getY(), colorSeleccionado);
                miSpray.dibujate(buffer2Graphics, evt.getX(), evt.getY(), jSlider1.getValue());
            break;
                
	    default:
		// Sobreescribe el lienzo
		if (!jCheckBox2.isSelected()) {
		    bufferGraphics.drawImage(buffer2, 0, 0, null);
		}
		// Dibuja la forma
		if (!jCheckBox3.isSelected()) {
		    miForma.dibujate(bufferGraphics, evt.getX(), evt.getY(), new Trazo(jSlider1.getValue()));
		} else {
		    miForma.dibujate(bufferGraphics, evt.getX(), evt.getY(), new Trazo(jSlider1.getValue(), true));
		}
		break;
	}
	repaint(0, 0, 1, 1);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
	// Inicializa la forma que se usara para dibujar en el buffer
	switch (formaSeleccionada) {
	    case 5000:
		miForma = new Circulo(evt.getX(), evt.getY(), colorSeleccionado, jCheckBox1.isSelected());
		break;
	    case 4:
		miForma = new Cuadrado(evt.getX(), evt.getY(), colorSeleccionado, jCheckBox1.isSelected());
		break;
	    case 3:
		miForma = new Triangulo(evt.getX(), evt.getY(), colorSeleccionado, jCheckBox1.isSelected());
		break;
	    case 5:
		miForma = new Pentagono(evt.getX(), evt.getY(), colorSeleccionado, jCheckBox1.isSelected());
		break;
	    case 24:
		miForma = new Estrella(evt.getX(), evt.getY(), colorSeleccionado, jCheckBox1.isSelected());
		break;
	    case 1:
		posLapizX = evt.getX();
		posLapizY = evt.getY();
		break;
	    case 677:
		posLapizX = evt.getX();
		posLapizY = evt.getY();
		break;
	    case 2:
		miForma = new Linea(evt.getX(), evt.getY(), colorSeleccionado, jCheckBox1.isSelected());
		break;
	    case 254:
		break;
            case 777:
                colorSeleccionado = new Color (buffer2.getRGB(evt.getX(), evt.getY()));
                jPanel2.setBackground(colorSeleccionado);
            break;
            
            
	}
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
	// Dibuja la forma
	if (formaSeleccionada != 1 && formaSeleccionada != 677) {
	    if (!jCheckBox3.isSelected()) {
		miForma.dibujate(buffer2Graphics, evt.getX(), evt.getY(), new Trazo(jSlider1.getValue()));
	    } else {
		miForma.dibujate(buffer2Graphics, evt.getX(), evt.getY(), new Trazo(jSlider1.getValue(), true));
	    }
	} else {
	    actualizaBuffers();
	}
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
	jDialog1.setVisible(false);
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
	jDialog1.setVisible(false);
	colorSeleccionado = jColorChooser1.getColor();
	jPanel2.setBackground(colorSeleccionado);
    }//GEN-LAST:event_jButton1MousePressed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
	jDialog1.setVisible(true);
    }//GEN-LAST:event_jPanel2MousePressed

    private void jToggleButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MousePressed
	//Selecciona la forma circulo
	formaSeleccionada = 5000;
	deSelecciona();
    }//GEN-LAST:event_jToggleButton1MousePressed

    private void jToggleButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton2MousePressed
	//Selecciona la forma cuadrado
	formaSeleccionada = 4;
	deSelecciona();
    }//GEN-LAST:event_jToggleButton2MousePressed

    private void jToggleButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton3MousePressed
	//Selecciona la forma triangulo
	formaSeleccionada = 3;
	deSelecciona();
    }//GEN-LAST:event_jToggleButton3MousePressed

    private void jToggleButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton4MousePressed
	//Selecciona la forma pentagono
	formaSeleccionada = 5;
	deSelecciona();
    }//GEN-LAST:event_jToggleButton4MousePressed

    private void jToggleButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton5MousePressed
	//Seleciona la forma estrella
	formaSeleccionada = 24;
	deSelecciona();
    }//GEN-LAST:event_jToggleButton5MousePressed

    private void jMenuItem1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MousePressed
	guarda();
    }//GEN-LAST:event_jMenuItem1MousePressed

    private void jMenu1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jMenu1StateChanged
	JMenu menu = (JMenu) evt.getSource();
	if (!menu.isSelected()) {
	    repaint();
	}
    }//GEN-LAST:event_jMenu1StateChanged

    private void jMenuItem2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MousePressed
	carga();
    }//GEN-LAST:event_jMenuItem2MousePressed

    private void jCheckBox2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox2StateChanged
	actualizaBuffers();
    }//GEN-LAST:event_jCheckBox2StateChanged

    private void jSlider1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseDragged
	jSpinner1.setValue(jSlider1.getValue());
    }//GEN-LAST:event_jSlider1MouseDragged

    private void jSpinner1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSpinner1MousePressed

    }//GEN-LAST:event_jSpinner1MousePressed

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
	jSlider1.setValue((int) jSpinner1.getValue());
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jToggleButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton6MousePressed
	//Seleciona el lapiz
	formaSeleccionada = 1;
	deSelecciona();
    }//GEN-LAST:event_jToggleButton6MousePressed

    private void jToggleButton7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton7MousePressed
	//Seleciona la brocha
	formaSeleccionada = 2;
	deSelecciona();
    }//GEN-LAST:event_jToggleButton7MousePressed

    private void jToggleButton8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton8MousePressed
	//Seleciona el spray
	formaSeleccionada = 254;
	deSelecciona();
    }//GEN-LAST:event_jToggleButton8MousePressed

    private void jToggleButton9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton9MousePressed
	//Seleciona la goma
	formaSeleccionada = 677;
	deSelecciona();
    }//GEN-LAST:event_jToggleButton9MousePressed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton9ActionPerformed
        
    }//GEN-LAST:event_jToggleButton9ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
  Desktop desktop = java.awt.Desktop.getDesktop();
  URI oURL = new URI("https://github.com/Luiser-ttv/Paint2020");
  desktop.browse(oURL);
} catch (Exception e) {
  e.printStackTrace();
}
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jToggleButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton8ActionPerformed
        
                
                
    }//GEN-LAST:event_jToggleButton8ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
         bufferGraphics.setColor(Color.WHITE);
        bufferGraphics.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
        bufferGraphics.setColor(Color.WHITE);
        bufferGraphics.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
        jPanelGraphics.drawImage(buffer, 0, 0, null);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton10MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton10MousePressed

    private void jToggleButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton10ActionPerformed
        formaSeleccionada = 777;
        deSelecciona();
    }//GEN-LAST:event_jToggleButton10ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
	/* Set the Nimbus look and feel */
	//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
	/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	 */
	try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException ex) {
	    java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new VentanaPaint().setVisible(true);
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton10;
    private javax.swing.JToggleButton jToggleButton11;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JToggleButton jToggleButton8;
    private javax.swing.JToggleButton jToggleButton9;
    // End of variables declaration//GEN-END:variables

}
