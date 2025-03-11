package prog.unidad06.gui.ejercicio10;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioRegistroSwingApp {

  private JFrame frmFormularioDeRegistro;
  private JTextField txtPassword;
  private JTextField txtPassword2;
  private final ButtonGroup buttonGroup = new ButtonGroup();
  private JTextField txtUsuario;
  private JComboBox<String> cbCiclo;
  private DefaultComboBoxModel<String> modeloComboCiclo;
  private JRadioButton rdbtnBachillerato;
  private JRadioButton rdbtnPruebaAcceso;
  private JCheckBox chkTituloOficial;
  private JCheckBox chkCertificado;
  private JCheckBox chkConvalidacion;
  private JCheckBox chkDNI;
  private JTextArea txtSalida;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          FormularioRegistroSwingApp window = new FormularioRegistroSwingApp();
          window.frmFormularioDeRegistro.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public FormularioRegistroSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmFormularioDeRegistro = new JFrame();
    frmFormularioDeRegistro.setTitle("Formulario de Registro");
    frmFormularioDeRegistro.setBounds(100, 100, 504, 577);
    frmFormularioDeRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
    
    txtUsuario = new JTextField();
    txtUsuario.setColumns(10);
    
    JLabel lblPassword = new JLabel("Password:");
    
    txtPassword = new JTextField();
    txtPassword.setColumns(10);
    
    JLabel lblRepitePassword = new JLabel("Repite Password:");
    
    txtPassword2 = new JTextField();
    txtPassword2.setColumns(10);
    
    JLabel lblCicloAlQue = new JLabel("Ciclo al que se presenta:");
    
    modeloComboCiclo = new DefaultComboBoxModel(new String[] {"ASIR", "DAM", "DAW"}); 
    cbCiclo = new JComboBox<>(modeloComboCiclo);
    
    JPanel panel = new JPanel();
    panel.setBorder(new TitledBorder(null, "Titulaci\u00F3n que presenta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    
    JPanel panel_1 = new JPanel();
    panel_1.setBorder(new TitledBorder(null, "Documentaci\u00F3n que aporta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    
    JButton btnRegistrar = new JButton("Registrar");
    btnRegistrar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Delega en registrar
        registrar();
      }
    });
    
    JScrollPane scrollPane = new JScrollPane();
    GroupLayout groupLayout = new GroupLayout(frmFormularioDeRegistro.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
            .addComponent(panel, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)
            .addGroup(groupLayout.createSequentialGroup()
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(lblNombreDeUsuario)
                .addComponent(lblPassword))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                  .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(lblRepitePassword)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(txtPassword2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(lblCicloAlQue)
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(cbCiclo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
          .addContainerGap(212, Short.MAX_VALUE)
          .addComponent(btnRegistrar)
          .addGap(203))
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNombreDeUsuario)
            .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblPassword)
            .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblRepitePassword)
            .addComponent(txtPassword2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblCicloAlQue)
            .addComponent(cbCiclo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addComponent(panel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(btnRegistrar)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(42, Short.MAX_VALUE))
    );
    
    txtSalida = new JTextArea();
    txtSalida.setEditable(false);
    scrollPane.setViewportView(txtSalida);
    
    chkTituloOficial = new JCheckBox("Titulo Oficial");
    
    chkCertificado = new JCheckBox("Certificado de Notas");
    
    chkConvalidacion = new JCheckBox("Convalidación");
    
    chkDNI = new JCheckBox("DNI");
    GroupLayout gl_panel_1 = new GroupLayout(panel_1);
    gl_panel_1.setHorizontalGroup(
      gl_panel_1.createParallelGroup(Alignment.LEADING)
        .addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
          .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
            .addComponent(chkTituloOficial)
            .addComponent(chkCertificado))
          .addPreferredGap(ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
          .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
            .addGroup(gl_panel_1.createSequentialGroup()
              .addComponent(chkDNI)
              .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
              .addComponent(chkConvalidacion)
              .addGap(67))))
    );
    gl_panel_1.setVerticalGroup(
      gl_panel_1.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel_1.createSequentialGroup()
          .addContainerGap()
          .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
            .addComponent(chkTituloOficial)
            .addComponent(chkConvalidacion))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
            .addComponent(chkCertificado)
            .addComponent(chkDNI))
          .addContainerGap(80, Short.MAX_VALUE))
    );
    panel_1.setLayout(gl_panel_1);
    
    rdbtnBachillerato = new JRadioButton("Bachillerato");
    buttonGroup.add(rdbtnBachillerato);
    rdbtnBachillerato.setSelected(true);
    
    rdbtnPruebaAcceso = new JRadioButton("Prueba de Acceso");
    buttonGroup.add(rdbtnPruebaAcceso);
    GroupLayout gl_panel = new GroupLayout(panel);
    gl_panel.setHorizontalGroup(
      gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel.createSequentialGroup()
          .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
            .addComponent(rdbtnPruebaAcceso)
            .addComponent(rdbtnBachillerato))
          .addContainerGap(332, Short.MAX_VALUE))
    );
    gl_panel.setVerticalGroup(
      gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel.createSequentialGroup()
          .addComponent(rdbtnBachillerato)
          .addGap(4)
          .addComponent(rdbtnPruebaAcceso)
          .addContainerGap(30, Short.MAX_VALUE))
    );
    panel.setLayout(gl_panel);
    frmFormularioDeRegistro.getContentPane().setLayout(groupLayout);
  }

  /**
   * Procesa el registro
   */
  protected void registrar() {
    // Obtenemos el nombre
    String nombre = txtUsuario.getText();
    // El tamaño debe ser entre 1 y 8
    if ((nombre.length() < 1) || (nombre.length() > 8)) {
      JOptionPane.showMessageDialog(null, "El nombre de usuario debe tener entre 1 y 8 caracteres");
      return;
    }
    // La password entre 5 y 10
    String password1 = txtPassword.getText();
    String password2 = txtPassword2.getText();
    if ((password1.length() < 5) || (password1.length() > 10)) {
      JOptionPane.showMessageDialog(null, "La password debe tener entre 5 y 10  caracteres");
      return;
    }
    
    // Las dos passwords deben ser iguales
    if (!password1.equals(password2)) {
      JOptionPane.showMessageDialog(null, "Las passwords deben coincidir");
      return;
    }
    
    // Obtenemos el ciclo
    String ciclo = cbCiclo.getItemAt(cbCiclo.getSelectedIndex());
    
    // Obtenemos la titulacion
    String titulacion = rdbtnBachillerato.isSelected() ? "Bachillerato" : "Prueba de Acceso";
    
    // Y los documentos
    boolean bTituloOficial = chkTituloOficial.isSelected();
    boolean bCertificado = chkCertificado.isSelected();
    boolean bConvalidacion = chkConvalidacion.isSelected();
    boolean bDNI = chkDNI.isSelected();
    
    // Generamos el registro
    String registro = "Registro\n";
    registro += "Nombre de Usuario: " + nombre + "\n";
    registro += "Contraseña: " + password1 + "\n";
    registro += "Ciclo en el que se matricula: " + ciclo + "\n";
    registro += "Titulación que presenta: " + titulacion + "\n";
    registro += "Documentos que presenta: ";
    String documentos = "";
    if (bTituloOficial) {
      documentos = "Titulo oficial";
    }
    if (bCertificado) {
      if (documentos.length() > 0) {
        documentos += ", ";
      }
      documentos += "Certificado de notas";
    }
    if (bConvalidacion) {
      if (documentos.length() > 0) {
        documentos += ", ";
      }
      documentos += "Convalidación";
    }
    if (bDNI) {
      if (documentos.length() > 0) {
        documentos += ", ";
      }
      documentos += "DNI";
    }
    registro += documentos + "\n";
    
    // Mostramos el registro
    txtSalida.setText(registro);
  }
}
