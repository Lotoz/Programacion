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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MiPrimeraVentana {

  private JFrame frmMiprimerainterfazgrafica;
  private JTextField textField;

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
    frmMiprimerainterfazgrafica.setBounds(100, 100, 370, 309);
    frmMiprimerainterfazgrafica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JLabel lblNewLabel = new JLabel("Introduce tu nombre : ");
    
    textField = new JTextField();
    textField.setToolTipText("Tu nombre aqui");
    textField.setColumns(10);
    
    JButton btnSaludar = new JButton("Enviar");
    btnSaludar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //Mi codigo aqui
       // hay dos opciones
       //Opcion mala poner todo el metodo aqui
        //Opcion buena,  meter un metodo privado para estar de chill
        saluda();
      }
    });
    
    JLabel salida = new JLabel(" ");
    salida.setEnabled(false);
    GroupLayout groupLayout = new GroupLayout(frmMiprimerainterfazgrafica.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(salida, GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(lblNewLabel)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
              .addGap(37)
              .addComponent(btnSaludar)))
          .addContainerGap())
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel)
            .addComponent(textField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnSaludar))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(salida)
          .addContainerGap(211, Short.MAX_VALUE))
    );
    frmMiprimerainterfazgrafica.getContentPane().setLayout(groupLayout);
  }

  protected void saluda() {
    salida.setText("Hola" + lblNewLabel.getText );
    
  }
}
