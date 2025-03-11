package prog.unidad06.gui.ejercicio06;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RadioCiclosSwingApp {

  private JFrame frmCiclosFormativos;
  private final ButtonGroup buttonGroup = new ButtonGroup();
  private JRadioButton rdbtnASIR;
  private JRadioButton rdbtnDAW;
  private JRadioButton rdbtnDAM;
  private JLabel lblSalida;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          RadioCiclosSwingApp window = new RadioCiclosSwingApp();
          window.frmCiclosFormativos.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public RadioCiclosSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmCiclosFormativos = new JFrame();
    frmCiclosFormativos.setTitle("Ciclos Formativos");
    frmCiclosFormativos.getContentPane().setFont(new Font("DialogInput", Font.PLAIN, 12));
    frmCiclosFormativos.setBounds(100, 100, 450, 207);
    frmCiclosFormativos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel panel = new JPanel();
    panel.setBorder(new TitledBorder(null, "Ciclo a cursar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    
    JLabel lblElCicloQue = new JLabel("El ciclo que quieres cursar es:");
    lblElCicloQue.setFont(new Font("Dialog", Font.PLAIN, 12));
    
    lblSalida = new JLabel("     ");
    GroupLayout groupLayout = new GroupLayout(frmCiclosFormativos.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(panel, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
            .addComponent(lblElCicloQue)
            .addComponent(lblSalida, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE))
          .addContainerGap())
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addComponent(panel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(lblElCicloQue)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(lblSalida)
          .addContainerGap(104, Short.MAX_VALUE))
    );
    
    rdbtnDAM = new JRadioButton("Desarrollo de Aplicaciones Multiplataforma");
    rdbtnDAM.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        // Delega en actualizaEstado que lo hace por todos los radios
        actualizaEstado();
      }
    });
    buttonGroup.add(rdbtnDAM);
    
    rdbtnASIR = new JRadioButton("Administracíón de Sistemas informáticos y Redes");
    rdbtnASIR.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        // Delega en actualizaEstado que lo hace por todos los radios
        actualizaEstado();
      }
    });
    buttonGroup.add(rdbtnASIR);
    rdbtnASIR.setSelected(true);
    
    rdbtnDAW = new JRadioButton("Desarrollo de Aplicaciones Web");
    rdbtnDAW.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        // Delega en actualizaEstado que lo hace por todos los radios
        actualizaEstado();
      }
    });
    buttonGroup.add(rdbtnDAW);
    GroupLayout gl_panel = new GroupLayout(panel);
    gl_panel.setHorizontalGroup(
      gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel.createSequentialGroup()
          .addContainerGap()
          .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
            .addComponent(rdbtnASIR)
            .addComponent(rdbtnDAM)
            .addComponent(rdbtnDAW))
          .addContainerGap(74, Short.MAX_VALUE))
    );
    gl_panel.setVerticalGroup(
      gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel.createSequentialGroup()
          .addContainerGap()
          .addComponent(rdbtnASIR)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(rdbtnDAM)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(rdbtnDAW)
          .addContainerGap(76, Short.MAX_VALUE))
    );
    panel.setLayout(gl_panel);
    frmCiclosFormativos.getContentPane().setLayout(groupLayout);
  }

  /**
   * 
   */
  protected void actualizaEstado() {
    if (rdbtnASIR != null && rdbtnASIR.isSelected()) {
      lblSalida.setText("ASIR");
    }
    if (rdbtnDAM != null && rdbtnDAM.isSelected()) {
      lblSalida.setText("DAM");
    }
    if (rdbtnDAW != null && rdbtnDAW.isSelected()) {
      lblSalida.setText("DAW");
    }
  }
}
