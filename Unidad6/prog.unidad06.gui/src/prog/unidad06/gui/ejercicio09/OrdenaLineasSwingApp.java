package prog.unidad06.gui.ejercicio09;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

public class OrdenaLineasSwingApp {

  private JFrame frmOrdenaLneas;
  private JTextArea txtOrdenado;
  private JTextArea txtOriginal;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          OrdenaLineasSwingApp window = new OrdenaLineasSwingApp();
          window.frmOrdenaLneas.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public OrdenaLineasSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmOrdenaLneas = new JFrame();
    frmOrdenaLneas.setTitle("Ordena Líneas");
    frmOrdenaLneas.setBounds(100, 100, 450, 382);
    frmOrdenaLneas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JLabel lblTextoOriginal = new JLabel("Texto Original:");
    
    JScrollPane scrollPane = new JScrollPane();
    
    JLabel lblTextoOrdenado = new JLabel("Texto Ordenado:");
    
    JScrollPane scrollPane_1 = new JScrollPane();
    
    JButton btnOrdenar = new JButton("Ordenar");
    btnOrdenar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Delega en ordenarTexto
        ordenarTexto();
      }
    });
    GroupLayout groupLayout = new GroupLayout(frmOrdenaLneas.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(lblTextoOriginal)
            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblTextoOrdenado)
            .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
          .addContainerGap(193, Short.MAX_VALUE)
          .addComponent(btnOrdenar)
          .addGap(173))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(lblTextoOriginal)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(lblTextoOrdenado)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(btnOrdenar)
          .addContainerGap(17, Short.MAX_VALUE))
    );
    
    txtOrdenado = new JTextArea();
    txtOrdenado.setEnabled(false);
    txtOrdenado.setEditable(false);
    scrollPane_1.setViewportView(txtOrdenado);
    
    txtOriginal = new JTextArea();
    scrollPane.setViewportView(txtOriginal);
    frmOrdenaLneas.getContentPane().setLayout(groupLayout);
  }

  /**
   * Procesa la ordenación del texto
   */
  protected void ordenarTexto() {
    // Tomamos el texto original
    String textoOriginal = txtOriginal.getText();
    // Lo dividimos en lineas
    String[] lineas = textoOriginal.split("\n");
    // Lista para añadir las líneas
    List<String> ordenadas = new ArrayList<>();
    // Para cada línea
    for (String linea: lineas) {
      // Si la línea tiene algo
      if (!linea.isBlank()) {
        // La añade
        ordenadas.add(linea);
      }
    }
    // Ordena la lista
    ordenadas.sort(null);
    
    // Vaciamos la caja de destino
    txtOrdenado.setText("");
    for (String linea: ordenadas) {
      txtOrdenado.setText(txtOrdenado.getText() + linea + "\n");
    }
  }
}
