package prog.unidad06.gui.ejercicio01;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculadoraSwingApp {

  private JFrame frmCalculadora;
  private JTextField txtPrimerOperando;
  private JTextField txtSegundoOperando;
  private double primerOperando;
  private double segundoOperando;
  private JLabel lblMensaje;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          CalculadoraSwingApp window = new CalculadoraSwingApp();
          window.frmCalculadora.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public CalculadoraSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmCalculadora = new JFrame();
    frmCalculadora.setTitle("Calculadora");
    frmCalculadora.setBounds(100, 100, 385, 210);
    frmCalculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JLabel lblPrimerOperando = new JLabel("Primer operando:");
    
    txtPrimerOperando = new JTextField();
    txtPrimerOperando.setText("0");
    txtPrimerOperando.setColumns(10);
    
    JLabel lblSegundoOperando = new JLabel("Segundo operando:");
    
    txtSegundoOperando = new JTextField();
    txtSegundoOperando.setText("0");
    txtSegundoOperando.setColumns(10);
    
    lblMensaje = new JLabel("");
    
    JButton btnSumar = new JButton("Suma");
    btnSumar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Lee los operandos desde las cajas de texto
        // Si correctos
        if (leeOperandos()) {
          // Realiza la operacion y muestra el resultado en la etiqueta
          lblMensaje.setText("Resultado: " + (primerOperando + segundoOperando));
        }
      }

    });
    
    JButton btnRestar = new JButton("Resta");
    btnRestar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Lee los operandos desde las cajas de texto
        // Si correctos
        if (leeOperandos()) {
          // Realiza la operación y muestra el resultado en la etiqueta
          lblMensaje.setText("Resultado: " + (primerOperando - segundoOperando));
        }
      }
    });
    
    JButton btnProducto = new JButton("Producto");
    btnProducto.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Lee los operandos desde las cajas de texto
        // Si correctos
        if (leeOperandos()) {
          // Realiza la operación y muestra el resultado en la etiqueta
          lblMensaje.setText("Resultado: " + (primerOperando * segundoOperando));
        }
      }
    });
    
    JButton btnDivisin = new JButton("División");
    btnDivisin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Lee los operandos desde las cajas de texto
        // Si correctos
        if (leeOperandos()) {
          // Si la división es correcta (no se divide por cero, por ejemplo)
          if (Double.isFinite(primerOperando / segundoOperando)) {
            // Realiza la operación y muestra los resultados en la etiqueta
            lblMensaje.setText("Resultado: " + (primerOperando / segundoOperando));
          } else {
            // Mostramos un mensaje
            JOptionPane.showInternalMessageDialog(null, "La división da un valor incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });
    GroupLayout groupLayout = new GroupLayout(frmCalculadora.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
            .addComponent(btnDivisin)
            .addComponent(lblMensaje, Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                    .addGroup(groupLayout.createSequentialGroup()
                      .addComponent(lblPrimerOperando)
                      .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                      .addComponent(txtPrimerOperando, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(groupLayout.createSequentialGroup()
                      .addComponent(lblSegundoOperando)
                      .addPreferredGap(ComponentPlacement.RELATED)
                      .addComponent(txtSegundoOperando, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                  .addGap(38)
                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(btnRestar)
                    .addComponent(btnSumar)))
                .addComponent(btnProducto))
              .addGap(2)))
          .addGap(43))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblPrimerOperando)
            .addComponent(txtPrimerOperando, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnSumar))
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(18)
              .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblSegundoOperando)
                .addComponent(txtSegundoOperando, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
            .addGroup(groupLayout.createSequentialGroup()
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(btnRestar)))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
              .addComponent(btnProducto)
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(btnDivisin))
            .addComponent(lblMensaje))
          .addContainerGap())
    );
    frmCalculadora.getContentPane().setLayout(groupLayout);
  }

  private boolean leeOperandos() {
    try {
      this.primerOperando = Double.parseDouble(txtPrimerOperando.getText());
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "El primer operando no es un número válido", "Error", JOptionPane.ERROR_MESSAGE);
      return false;
    }
    try {
      this.segundoOperando = Double.parseDouble(txtSegundoOperando.getText());
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "El segundo operando no es un número válido", "Error", JOptionPane.ERROR_MESSAGE);
      return false;
    }
    return true;
  }
}
