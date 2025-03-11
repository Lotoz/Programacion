package prog.unidad06.gui.ejercicio02;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class ContarPalabrasSwingApp {

  private JFrame frmContarPalabras;
  private JLabel lblResultado;
  private JTextArea txtTexto;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ContarPalabrasSwingApp window = new ContarPalabrasSwingApp();
          window.frmContarPalabras.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public ContarPalabrasSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmContarPalabras = new JFrame();
    frmContarPalabras.setTitle("Contar Palabras");
    frmContarPalabras.setBounds(100, 100, 450, 241);
    frmContarPalabras.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JScrollPane scrollPane = new JScrollPane();
    
    JButton btnContar = new JButton("Contar");
    btnContar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Delega en contarPalabras que es el que hace el trabajo
        lblResultado.setText(contarPalabras(txtTexto.getText()));
      }
    });
    
    lblResultado = new JLabel("       ");
    GroupLayout groupLayout = new GroupLayout(frmContarPalabras.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(btnContar)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(lblResultado)))
          .addContainerGap())
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(3)
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(btnContar)
            .addComponent(lblResultado))
          .addContainerGap(76, Short.MAX_VALUE))
    );
    
    txtTexto = new JTextArea();
    scrollPane.setViewportView(txtTexto);
    frmContarPalabras.getContentPane().setLayout(groupLayout);
  }
 
  /**
   * Cuenta las ocurrencias de cada palabra en el texto
   * @param texto Texto a procesar
   * @return Texto a mostrar
   */
  private String contarPalabras(String texto) {
    // Dividimos el texto en palabras
    String [] palabras = texto.split("\\s+");
    // Este mapa contendrá como claves las palabras y como valor el número de veces que esa palabra ha aparecido en el texto
    Map<String, Integer> frecuencias = new HashMap<>();
    // Para cada palabra del texto
    for (String palabra: palabras) {
      // Si la palabra no está aún en el mapa
      if (!frecuencias.containsKey(palabra)) {
        // La añade con una frecuencia 0
        frecuencias.put(palabra, 0);
      }
      // Sumamos 1 a la frecuencia actual de la palabra
      frecuencias.put(palabra, frecuencias.get(palabra) + 1);
    }
    // Ahora hay que buscar la palabra de mayor frecuencia
    // Si hay alguna
    if (frecuencias.size() > 0) {
      // Inicializamos la palabra y la frecuencia
      String palabraMasRepetida = null;
      int frecuencia = 0;
      // Para cada palabra en el mapa
      for (String palabra: frecuencias.keySet()) {
        // Si es la primera palabra o la frecuencia de la palabra es mayor que la actual
        if ((palabraMasRepetida == null) || (frecuencias.get(palabra) > frecuencia)) {
          // La tomamos como la más frecuente por ahora
          palabraMasRepetida = palabra;
          frecuencia = frecuencias.get(palabraMasRepetida);
        }
      }
      // Mostrramos en la etiqueta la palabra y la frecuencia
      return String.format("La palabra más frecuente es: \"%s\"(%d)", palabraMasRepetida, frecuencia);
    } else {
      // No hay palabras
      return "No hay palabras";
    }
  }
}
