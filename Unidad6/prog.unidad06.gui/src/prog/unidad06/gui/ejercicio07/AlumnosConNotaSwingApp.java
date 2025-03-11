package prog.unidad06.gui.ejercicio07;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class AlumnosConNotaSwingApp {

  // Constantes
  // Número de calificaciones
  private static final int CALIFICACIONES = 30;
  // Valor máximo de una calificación
  private static final int CALIFICACION_MAX = 10;
  // Valor mínimo de una calificación
  private static final int CALIFICACION_MIN = 0;
  
  private JFrame frmCalificaciones;
  private JList<String> lstCalificaciones;
  private DefaultListModel<String> modeloListaCalificaciones;
  private JComboBox<String> cbCalificacion;
  private DefaultComboBoxModel<String> modeloComboCalificacion;
  private JLabel lblSalida;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          AlumnosConNotaSwingApp window = new AlumnosConNotaSwingApp();
          window.frmCalificaciones.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public AlumnosConNotaSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmCalificaciones = new JFrame();
    frmCalificaciones.setTitle("Calificaciones");
    frmCalificaciones.setBounds(100, 100, 450, 300);
    frmCalificaciones.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JScrollPane scrollPane = new JScrollPane();
    
    modeloComboCalificacion = new DefaultComboBoxModel<>(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"});
    cbCalificacion = new JComboBox<>(modeloComboCalificacion);
    cbCalificacion.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        // Cuando cambie el contenido del combo, vuelve a contar las calificaciones
        contarCalificaciones();
      }
    });
    
    lblSalida = new JLabel("Hay ");
    GroupLayout groupLayout = new GroupLayout(frmCalificaciones.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(15)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(cbCalificacion, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
              .addGap(43)
              .addComponent(lblSalida))
            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
          .addContainerGap())
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
          .addGap(18)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(lblSalida)
            .addComponent(cbCalificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(67, Short.MAX_VALUE))
    );
    
    modeloListaCalificaciones = new DefaultListModel<>();
    lstCalificaciones = new JList<String>(modeloListaCalificaciones);

    // Creamos el modelo para la lista añadiendo los números aleatorios
    rellenaModeloLista(modeloListaCalificaciones);

    scrollPane.setViewportView(lstCalificaciones);
    frmCalificaciones.getContentPane().setLayout(groupLayout);
    
    // Mostramos las apariciones del valor seleccionado por defecto en el combo box
    contarCalificaciones();
  }

  /**
   * Cuenta cuantas calificaciones tienen el valor igual al seleccionado en el combo box
   */
  private void contarCalificaciones() {
    // Obtiene la calificacion seleccionada en el combo box
    String calificacion = cbCalificacion.getItemAt(cbCalificacion.getSelectedIndex());
    
    // Cuenta cuantas veces aparece la calificacion en el modelo de la lista
    int apariciones = 0;
    for (int i = 0; i < modeloListaCalificaciones.size(); i++) {
      if (modeloListaCalificaciones.get(i).equals(calificacion)) {
        apariciones++;
      }
    }
    // Muestra en la etiqueta la cantidad
    lblSalida.setText(String.format("Hay %d alumnos con una calificación de %s", apariciones, calificacion));
  }

  /**
   * Rellena la lista de calificaciones con números aleatorios
   * @param lstLista
   */
  private void rellenaModeloLista(DefaultListModel<String> modeloLista) {
    // Generador de números aleatorios
    Random random = new Random();
    // Para el número de calificaciones a generar
    for (int i = 0; i < CALIFICACIONES; i++) {
      // La genera (en número)
      int calificacionEntera = random.nextInt(CALIFICACION_MIN, CALIFICACION_MAX + 1);
      // Y la añade al modelo (debe ser una cadena)
      modeloLista.addElement(String.valueOf(calificacionEntera));
    }
  }
}
