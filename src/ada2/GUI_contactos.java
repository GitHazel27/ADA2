package ada2;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_contactos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ArrayList<Contactos> contactos = new ArrayList<>();
	private JTextField Tf_nombre;
	private JTextField Tf_tel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_contactos frame = new GUI_contactos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_contactos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Label_foto = new JLabel("New label");
		Label_foto.setBounds(23, 60, 180, 180);
		contentPane.add(Label_foto);
		Label_foto.setIcon(new ImageIcon("imagenes/icono.png"));
		
		JLabel lblNewLabel = new JLabel("Contactos");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel.setBounds(23, 10, 109, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(223, 85, 64, 19);
		contentPane.add(lblNewLabel_1);
		
		Tf_nombre = new JTextField();
		Tf_nombre.setBounds(297, 87, 109, 19);
		contentPane.add(Tf_nombre);
		Tf_nombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Teléfono:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(223, 129, 70, 19);
		contentPane.add(lblNewLabel_2);
		
		Tf_tel = new JTextField();
		Tf_tel.setBounds(297, 131, 109, 19);
		contentPane.add(Tf_tel);
		Tf_tel.setColumns(10);
		
		JButton btnBuscarBrisa = new JButton("Buscar");
		btnBuscarBrisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sBuscar = JOptionPane.showInputDialog("Buscar");
				if (sBuscar != null) {
				    boolean encontrado = false;
				    for (int i = 0; i < contactos.size(); i++) {
				        if (contactos.get(i).getNomb().equalsIgnoreCase(sBuscar)) {
				            String datos = "Nombre: " + contactos.get(i).getNomb() + 
				                           "\nTeléfono: " + contactos.get(i).getTel();
				            JOptionPane.showMessageDialog(null, datos, "Contacto Encontrado", JOptionPane.INFORMATION_MESSAGE);
				            encontrado = true;
				            break;
				        }
				    }

				    if (!encontrado) {
				        JOptionPane.showMessageDialog(null, "El contacto no fue encontrado");
				    }
				}
			}
		});
		btnBuscarBrisa.setBounds(297, 185, 85, 21);
		contentPane.add(btnBuscarBrisa);
	}
}
