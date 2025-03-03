package interfazGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MiPrimeraVentana {

  private JFrame frmMiprimerainterfazgrafica;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          MiPrimeraVentana window = new MiPrimeraVentana();
          window.frmMiprimerainterfazgrafica.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public MiPrimeraVentana() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmMiprimerainterfazgrafica = new JFrame();
    frmMiprimerainterfazgrafica.setTitle("MiPrimeraInterfazGrafica");
    frmMiprimerainterfazgrafica.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 12));
    frmMiprimerainterfazgrafica.getContentPane().setBackground(new Color(226, 209, 237));
    frmMiprimerainterfazgrafica.setBounds(100, 100, 450, 300);
    frmMiprimerainterfazgrafica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JLabel lblNewLabel = new JLabel("New label");
    GroupLayout groupLayout = new GroupLayout(frmMiprimerainterfazgrafica.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(lblNewLabel)
          .addContainerGap(378, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(lblNewLabel)
          .addContainerGap(236, Short.MAX_VALUE))
    );
    frmMiprimerainterfazgrafica.getContentPane().setLayout(groupLayout);
  }
}
