package prog.unidad06.examen.ejercicio03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlumnosApp {

  private JFrame frame;
  private JTextField textNombre;
  private JTextField textEdad;
  private JCheckBox chckbxCome;
  private JRadioButton rdbtnPrimerB;
  private JRadioButton rdbtnSegundoB;
  private JRadioButton rdbtnSegundoSuperior;
  private JRadioButton rdbtnPrimerSuperior;
  private JButton btnActualizar;
  private JButton btnNuevo;
  private JButton btnEliminar;
  private JButton btnAceptar;
  private JButton btnCancelar;
  JList<Alumno> list;
  Alumno persona;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          AlumnosApp window = new AlumnosApp();
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
  public AlumnosApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 481);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel lblAlumnos = new JLabel("Alumnos:");

    JScrollPane scrollPane = new JScrollPane();

    JLabel lblNombre = new JLabel("Nombre:");

    textNombre = new JTextField();
    textNombre.setEnabled(false);
    textNombre.setColumns(10);

    JLabel lblEdad = new JLabel("Edad:");

    textEdad = new JTextField();
    textEdad.setEnabled(false);
    textEdad.setColumns(10);

    chckbxCome = new JCheckBox("¿Usa comedor?");
    chckbxCome.setEnabled(false);

    JPanel cajaCurso = new JPanel();
    cajaCurso.setBorder(new TitledBorder(null, "Curso", TitledBorder.LEADING, TitledBorder.TOP, null, null));

    btnNuevo = new JButton("Nuevo");
    btnNuevo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        crearAlumno();
      }
    });

    btnActualizar = new JButton("Actualizar");
    btnActualizar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        actualizarAlumno();
      }
    });
    btnActualizar.setEnabled(false);

    btnEliminar = new JButton("Eliminar");
    btnEliminar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        eliminarAlumno();
      }
    });
    btnEliminar.setEnabled(false);

    btnAceptar = new JButton("Aceptar");
    btnAceptar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        deshabilitarOpciones();
      }
    });
    btnAceptar.setEnabled(false);

    btnCancelar = new JButton("Cancelar");
    btnCancelar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        calcelarOpciones();
      }
    });
    btnCancelar.setEnabled(false);
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
                .createParallelGroup(Alignment.LEADING).addComponent(chckbxCome).addComponent(lblAlumnos)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
                .addGroup(groupLayout.createSequentialGroup().addComponent(lblNombre)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE).addGap(18)
                    .addComponent(lblEdad).addPreferredGap(ComponentPlacement.RELATED).addComponent(textEdad,
                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addComponent(cajaCurso, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)))
            .addGroup(groupLayout.createSequentialGroup().addGap(69).addComponent(btnNuevo).addGap(35)
                .addComponent(btnActualizar).addGap(18).addComponent(btnEliminar))
            .addGroup(groupLayout.createSequentialGroup().addGap(107).addComponent(btnAceptar).addGap(43)
                .addComponent(btnCancelar)))
            .addContainerGap(16, Short.MAX_VALUE)));
    groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
        .createSequentialGroup().addContainerGap().addComponent(lblAlumnos).addPreferredGap(ComponentPlacement.RELATED)
        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(ComponentPlacement.UNRELATED)
        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNombre)
            .addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(textEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblEdad))
        .addPreferredGap(ComponentPlacement.RELATED).addComponent(chckbxCome)
        .addPreferredGap(ComponentPlacement.RELATED)
        .addComponent(cajaCurso, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE).addGap(18)
        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnEliminar)
            .addComponent(btnActualizar).addComponent(btnNuevo))
        .addPreferredGap(ComponentPlacement.RELATED)
        .addGroup(
            groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnCancelar).addComponent(btnAceptar))
        .addContainerGap(18, Short.MAX_VALUE)));

    rdbtnPrimerB = new JRadioButton("Primero Bachillerato");
    rdbtnPrimerB.setEnabled(false);

    rdbtnSegundoB = new JRadioButton("Segundo Bachillerato");
    rdbtnSegundoB.setEnabled(false);

    rdbtnPrimerSuperior = new JRadioButton("Primero Grado Superior");
    rdbtnPrimerSuperior.setEnabled(false);

    rdbtnSegundoSuperior = new JRadioButton("Segundo Grado Superior");
    rdbtnSegundoSuperior.setEnabled(false);
    GroupLayout gl_cajaCurso = new GroupLayout(cajaCurso);
    gl_cajaCurso.setHorizontalGroup(gl_cajaCurso.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_cajaCurso.createSequentialGroup().addContainerGap()
            .addGroup(
                gl_cajaCurso.createParallelGroup(Alignment.LEADING).addComponent(rdbtnPrimerB).addComponent(rdbtnSegundoB))
            .addGap(64).addGroup(gl_cajaCurso.createParallelGroup(Alignment.LEADING).addComponent(rdbtnSegundoSuperior)
                .addComponent(rdbtnPrimerSuperior))
            .addContainerGap(92, Short.MAX_VALUE)));
    gl_cajaCurso.setVerticalGroup(gl_cajaCurso.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_cajaCurso.createSequentialGroup().addContainerGap()
            .addGroup(gl_cajaCurso.createParallelGroup(Alignment.BASELINE).addComponent(rdbtnPrimerB)
                .addComponent(rdbtnPrimerSuperior))
            .addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_cajaCurso.createParallelGroup(Alignment.BASELINE)
                .addComponent(rdbtnSegundoB).addComponent(rdbtnSegundoSuperior))
            .addContainerGap(14, Short.MAX_VALUE)));
    cajaCurso.setLayout(gl_cajaCurso);

    list = new JList();
    scrollPane.setViewportView(list);
    list.setModel(new DefaultListModel<Alumno>());
    frame.getContentPane().setLayout(groupLayout);
  }

  // Metodos privados
  protected void crearAlumno() {
    habilitarOpciones();
    
    // Obtenemos el nombre
    String nombre = textNombre.getText();
    if ((nombre.length() < 1) || (nombre.length() > 8)) {
      JOptionPane.showMessageDialog(null, "Debe ser un nombre valido");
      return;
    }
    //Obtenemos Edad
   int edad = Integer.parseInt(textEdad.getText());
    if (edad == 0 || edad < 0) {
      JOptionPane.showMessageDialog(null, "Debe ser una edad valida");
      return;
    }
    //Vemos si cursa comedor
    boolean comedor = chckbxCome.isSelected();
    
    //Obtenemos lo que cursa
   
    
    
    //Se guarda el nuevo alumno con los datos creados
    Alumno persona = new Alumno(nombre, edad, comedor, 1);
   confirmarOpciones(persona);

  }

  protected void actualizarAlumno() {
    

  }

  protected void eliminarAlumno() {
    //Si lo selecciona lo elimina
    if (btnEliminar.isSelected()) {
      JOptionPane.showMessageDialog(null, "Seguro que quieres eliminar?");
      JOptionPane.showConfirmDialog(btnEliminar, btnCancelar);
      
    }
  }

  protected void confirmarOpciones(Alumno persona) {
    //Agrega a la lista a la persona
    if (list.getSelectedIndex() >= 0) {
      
      DefaultListModel<Alumno> modelo = (DefaultListModel<Alumno>)list.getModel();
     
      modelo.remove(list.getSelectedIndex());
    }
    deshabilitarOpciones();

  }

  protected void calcelarOpciones() {
   

  }

  //Habilita las opciones
  private void habilitarOpciones() {
    textNombre.setEnabled(true);
    textEdad.setEnabled(true);
    chckbxCome.setEnabled(true);
    rdbtnPrimerB.setEnabled(true);
    rdbtnSegundoB.setEnabled(true);
    rdbtnPrimerSuperior.setEnabled(true);
    rdbtnSegundoSuperior.setEnabled(true);
    btnAceptar.setEnabled(true);
    btnCancelar.setEnabled(true);
  }
  //Deshabilita las opciones
  private void deshabilitarOpciones() {
    textNombre.setEnabled(false);
    textEdad.setEnabled(false);
    chckbxCome.setEnabled(false);
    rdbtnPrimerB.setEnabled(false);
    rdbtnSegundoB.setEnabled(false);
    rdbtnPrimerSuperior.setEnabled(false);
    rdbtnSegundoSuperior.setEnabled(false);
    btnAceptar.setEnabled(false);
    btnCancelar.setEnabled(false);
  }

}
