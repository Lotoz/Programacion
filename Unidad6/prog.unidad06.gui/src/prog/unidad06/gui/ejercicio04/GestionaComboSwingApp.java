package prog.unidad06.gui.ejercicio04;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GestionaComboSwingApp {

  private JFrame frmGestinComboBox;
  private JTextField txtNombre;
  private JComboBox<String> cbLista;
  private DefaultComboBoxModel<String> modeloLista;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GestionaComboSwingApp window = new GestionaComboSwingApp();
          window.frmGestinComboBox.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public GestionaComboSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmGestinComboBox = new JFrame();
    frmGestinComboBox.setTitle("Gestión Combo Box");
    frmGestinComboBox.setBounds(100, 100, 450, 188);
    frmGestinComboBox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    modeloLista = new DefaultComboBoxModel<>();
    cbLista = new JComboBox<>(modeloLista);
    
    txtNombre = new JTextField();
    txtNombre.setColumns(10);
    
    JButton btnAdd = new JButton("Añadir");
    btnAdd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Obtenemos el texto del cuadro
        String texto = txtNombre.getText();
        // Si no es vacío o blancos
        if (!texto.isBlank()) {
          // Añade el texto al combo
          modeloLista.addElement(texto);
        }
      }
    });
    
    JButton btnEliminar = new JButton("Eliminar");
    btnEliminar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int elemento = cbLista.getSelectedIndex();
        // Si hay elemento seleccionado
        if (elemento >= 0) {
          // Elimina el elemento del modelo
          modeloLista.removeElementAt(elemento);
        }
      }
    });
    GroupLayout groupLayout = new GroupLayout(frmGestinComboBox.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(cbLista, Alignment.TRAILING, 0, 426, Short.MAX_VALUE)
            .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
              .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
              .addComponent(btnAdd))
            .addComponent(btnEliminar, Alignment.TRAILING))
          .addContainerGap())
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(cbLista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          .addGap(39)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnAdd))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(btnEliminar)
          .addContainerGap(128, Short.MAX_VALUE))
    );
    frmGestinComboBox.getContentPane().setLayout(groupLayout);
  }
}
