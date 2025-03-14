package prog.unidad06.gui.PracticaPersonal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class Agenda {

	JFrame frmAgendaapp;
	private JTextField textTelefono;
	private JTextField textNombre;
	private JRadioButton rdbtnMujer;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnOtro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda window = new Agenda();
					window.frmAgendaapp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Agenda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgendaapp = new JFrame();
		frmAgendaapp.setTitle("AgendaApp");
		frmAgendaapp.setBounds(100, 100, 658, 430);
		frmAgendaapp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblTelefono = new JLabel("Telefono");
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		textTelefono.setColumns(10);
		
		JLabel lblNotas = new JLabel("Informacion:");
		
		JButton btnAdd = new JButton("Añadir");
		//Evento del boton
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarUsuario();
			}
		});
		
		JButton btnDelete = new JButton("Borrar");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarUsuario();
			}

		
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarUsuario();
			}
		});
		
		JPanel panel = new JPanel();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JList listPatner = new JList();
		listPatner.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(listPatner);
		
		rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setEnabled(false);
		
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setEnabled(false);
		
		rdbtnOtro = new JRadioButton("Otro");
		rdbtnOtro.setEnabled(false);
		
		JLabel lblGenero = new JLabel("Genero");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnOtro, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnHombre, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnMujer, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGenero, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGenero)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(rdbtnMujer)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnHombre)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnOtro)
					.addGap(15))
		);
		panel.setLayout(gl_panel);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblGenero, rdbtnOtro, rdbtnHombre, rdbtnMujer}));
		
		JTextArea textAreaInfo = new JTextArea();
		textAreaInfo.setEditable(false);
		textAreaInfo.setLineWrap(true);
		textAreaInfo.setWrapStyleWord(true);
		GroupLayout groupLayout = new GroupLayout(frmAgendaapp.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(32, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textAreaInfo, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNotas)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNombre)
								.addComponent(lblTelefono))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(textTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(48)
											.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(43)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnDelete)
										.addComponent(btnEditar)
										.addComponent(btnAdd))))))
					.addGap(22))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAdd)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDelete)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(btnEditar)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTelefono)
						.addComponent(textTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNotas)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textAreaInfo, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
					.addGap(203))
		);
		frmAgendaapp.getContentPane().setLayout(groupLayout);
	}
	//Metodos privados
	protected void agregarUsuario() {
	habilitarOpciones();
		
	}
	
	protected void borrarUsuario() {
		
		
	}
	
	protected void editarUsuario() {
	habilitarOpciones();
	
	apagarOpciones();
	}

	protected void habilitarOpciones() {
			textNombre.setEditable(true);
			textNombre.setEnabled(true);
			textTelefono.setEnabled(true);
			textTelefono.setEditable(true);
	}
	protected void apagarOpciones() {
		
		textNombre.setEditable(false);
		textNombre.setEnabled(false);
		textTelefono.setEnabled(false);
		textTelefono.setEditable(false);
	}

}
