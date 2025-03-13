package prog.unidad06.gui.PracticaPersonal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class AgendaApp {

  private JFrame frame;
  private JTextField textField;
  private JTextField textField_1;
  private JTextField textField_2;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          AgendaApp window = new AgendaApp();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public AgendaApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JLabel lblNombre = new JLabel("Nombre");
    
    JLabel lblTelefono = new JLabel("Telefono");
    
    JLabel lblCorreo = new JLabel("Correo");
    
    textField = new JTextField();
    textField.setColumns(10);
    
    textField_1 = new JTextField();
    textField_1.setColumns(10);
    
    textField_2 = new JTextField();
    textField_2.setColumns(10);
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(lblNombre)
            .addComponent(lblTelefono)
            .addComponent(lblCorreo))
          .addGap(8)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(262, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(32)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNombre)
            .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblTelefono)
            .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblCorreo)
            .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(205, Short.MAX_VALUE))
    );
    frame.getContentPane().setLayout(groupLayout);
  }
}
