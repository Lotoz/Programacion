package prog.unidad06.gui.ejercicio03;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionaListaSwingApp {

  private JFrame frmGestinLista;
  private JTextField txtTexto;
  private JList<String> lstLista;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GestionaListaSwingApp window = new GestionaListaSwingApp();
          window.frmGestinLista.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public GestionaListaSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmGestinLista = new JFrame();
    frmGestinLista.setTitle("Gestión Lista");
    frmGestinLista.setBounds(100, 100, 450, 265);
    frmGestinLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JScrollPane scrollPane = new JScrollPane();
    
    txtTexto = new JTextField();
    txtTexto.setColumns(10);
    
    JButton btnAdd = new JButton("Añadir");
    btnAdd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Obtenemos el texto del cuadro
        String texto = txtTexto.getText();
        // Si no está vacío o sólo espacios
        if (!texto.isBlank()) {
          // Obtiene el modelo de la lista
          DefaultListModel<String> modelo = (DefaultListModel<String>)lstLista.getModel();
          // Y añade el texto
          modelo.addElement(texto);
        }
      }
    });
    
    JButton btnEliminar = new JButton("Eliminar");
    btnEliminar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Si hay algo seleccionado
        if (lstLista.getSelectedIndex() >= 0) {
          // Obtiene el modelo de la lista
          DefaultListModel<String> modelo = (DefaultListModel<String>)lstLista.getModel();
          // Y elimina el elemento en la posición especificada
          modelo.remove(lstLista.getSelectedIndex());
        }
      }
    });
    GroupLayout groupLayout = new GroupLayout(frmGestinLista.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
            .addComponent(btnEliminar)
            .addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 431, GroupLayout.PREFERRED_SIZE)
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(txtTexto)
              .addGap(18)
              .addComponent(btnAdd)))
          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(txtTexto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnAdd))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(btnEliminar)
          .addContainerGap(46, Short.MAX_VALUE))
    );
    
    lstLista = new JList<>();
    scrollPane.setViewportView(lstLista);
    // Definimos el modelo de la lista (Va a contener cadenas)
    lstLista.setModel(new DefaultListModel<String>());
    frmGestinLista.getContentPane().setLayout(groupLayout);
  }
}
