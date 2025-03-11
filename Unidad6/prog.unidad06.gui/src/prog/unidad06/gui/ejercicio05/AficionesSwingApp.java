package prog.unidad06.gui.ejercicio05;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class AficionesSwingApp {

  private JFrame frmAficiones;
  private JLabel lblAficiones;
  private JCheckBox chckbxLectura;
  private JCheckBox chckbxSeries;
  private JCheckBox chckbxComic;
  private JCheckBox chckbxAnime;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          AficionesSwingApp window = new AficionesSwingApp();
          window.frmAficiones.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public AficionesSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmAficiones = new JFrame();
    frmAficiones.setTitle("Aficiones");
    frmAficiones.setBounds(100, 100, 450, 300);
    frmAficiones.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel panel = new JPanel();
    panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Aficiones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
    
    JLabel lblTusAficionesSon = new JLabel("Tus aficiones son:");
    
    lblAficiones = new JLabel("   ");
    GroupLayout groupLayout = new GroupLayout(frmAficiones.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(panel, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)
          .addContainerGap())
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(lblTusAficionesSon)
          .addContainerGap(378, Short.MAX_VALUE))
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(lblAficiones)
          .addContainerGap(378, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(panel, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(lblTusAficionesSon)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(lblAficiones)
          .addContainerGap(72, Short.MAX_VALUE))
    );
    
    chckbxLectura = new JCheckBox("Lectura");
    chckbxLectura.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        // Delega en actualizaAficiones porque el codigo es muy largo para colocarlo aqui
        actualizaAficiones();
      }
    });
    
    chckbxSeries = new JCheckBox("Series");
    chckbxSeries.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        // Delega en actualizaAficiones porque el codigo es muy largo para colocarlo aqui
        actualizaAficiones();
      }
    });
    
    chckbxComic = new JCheckBox("Comic");
    chckbxComic.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        // Delega en actualizaAficiones porque el codigo es muy largo para colocarlo aqui
        actualizaAficiones();
      }
    });
    
    chckbxAnime = new JCheckBox("Anime");
    chckbxAnime.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        // Delega en actualizaAficiones porque el codigo es muy largo para colocarlo aqui
        actualizaAficiones();
      }
    });
    GroupLayout gl_panel = new GroupLayout(panel);
    gl_panel.setHorizontalGroup(
      gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel.createSequentialGroup()
          .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
            .addComponent(chckbxLectura)
            .addComponent(chckbxSeries)
            .addComponent(chckbxComic)
            .addComponent(chckbxAnime))
          .addContainerGap(288, Short.MAX_VALUE))
    );
    gl_panel.setVerticalGroup(
      gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel.createSequentialGroup()
          .addContainerGap()
          .addComponent(chckbxLectura)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(chckbxSeries)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(chckbxComic)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(chckbxAnime)
          .addContainerGap(27, Short.MAX_VALUE))
    );
    panel.setLayout(gl_panel);
    frmAficiones.getContentPane().setLayout(groupLayout);
  }

  /**
   * Actualiza la etiqueta con las aficiones según el  estado actual de
   * los check boxes
   */
  protected void actualizaAficiones() {
    // Iniciamos a vacío
    String aficiones = "";
    // Por cada casilla de afición. Si está marcada añadimos su aficion al resultado
    // Si no lo está no se hace nada
    if (chckbxLectura.isSelected()) {
      aficiones += "Lectura ";
    }
    if (chckbxSeries.isSelected()) {
      aficiones += "Series ";
    }
    if (chckbxComic.isSelected()) {
      aficiones += "Comic ";
    }
    if (chckbxAnime.isSelected()) {
      aficiones += "Anime ";
    }
    
    // Mostramos la lista de aficiones en la etiqueta 
    lblAficiones.setText(aficiones);
  }
}
