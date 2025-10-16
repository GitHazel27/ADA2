package ada2;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_contactos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ArrayList<Contactos> contactos = new ArrayList<>();
	private JTextField Tf_nombre;
	private JTextField Tf_tel;
	int indice = 0;
	int contador = 0;
	DefaultListModel<String> JLNombres = new DefaultListModel<>();
	

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
		setBounds(100, 100, 665, 356);
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
		
		JList list = new JList();
		list.setBounds(468, 46, 174, 186);
		contentPane.add(list);
		list.setModel(JLNombres);
		
		Tf_tel = new JTextField();
		Tf_tel.setBounds(297, 131, 109, 19);
		contentPane.add(Tf_tel);
		Tf_tel.setColumns(10);
		

		//Hazel Silva: Botón de agregar. Agrega al arraylist un nuevo contacto, en el cual
		//se le asigna el nombre, teléfono, número de contacto y la dirección de la foto.
		//Lo guarda y deja en blanco los textfields.
		//Agrega al JList
		JButton bt_agregar = new JButton("Agregar");
		bt_agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String nombre = Tf_nombre.getText();
			String tel = Tf_tel.getText();
			int num = contactos.size() + 1;
			String foto = "";
			if (num == 1) {
			    foto = "imagenes/Contacto1.png";
			} else if (num == 2) {
			    foto = "imagenes/Contacto2.png";
			} else if (num == 3) {
			    foto = "imagenes/Contacto3.png";
			} else if (num == 4) {
			    foto = "imagenes/Contacto4.png";
			} else if (num == 5) {
			    foto = "imagenes/Contacto5.png";
			}
			contactos.add(new Contactos(num,nombre,tel,foto));
			String contacto = Integer.toString(num)+ ". "+ Tf_nombre.getText() + " " + Tf_tel.getText();
			JLNombres.add(contador, contacto);
			contador++;
			JOptionPane.showMessageDialog(null,"Contacto guardado");
			Tf_nombre.setText("");
			Tf_tel.setText("");
			}
		});
		bt_agregar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_agregar.setBounds(281, 182, 109, 21);
		contentPane.add(bt_agregar);
		
		//	Hazel silva, recorre el arraylist a la derecha
		JButton Derecha = new JButton(">>");
		Derecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contactos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Aún no hay contactos");
					return;
				}
		        if (indice < contactos.size() - 1) {
		            indice++;
		        }
		        Tf_nombre.setText(contactos.get(indice).getNomb());
		        Tf_tel.setText(contactos.get(indice).getTel());
		        Label_foto.setIcon(new ImageIcon(contactos.get(indice).getIma()));
		    }
		});
		Derecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Derecha.setBounds(394, 182, 64, 21);
		contentPane.add(Derecha);
		
		//Hazel Silva, recorre el arraylist a la izquierda
		JButton izquierda = new JButton("<<");
		izquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contactos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Aún no hay contactos");
					return;
				}
		        if (indice > 0) {
		            indice--;
		        }
		        Tf_nombre.setText(contactos.get(indice).getNomb());
		        Tf_tel.setText(contactos.get(indice).getTel());
		        Label_foto.setIcon(new ImageIcon(contactos.get(indice).getIma()));
		    }
		});
		izquierda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		izquierda.setBounds(213, 182, 64, 21);
		contentPane.add(izquierda);
		

		JButton btnBuscarBrisa = new JButton("Buscar");
		btnBuscarBrisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Boton "Buscar" realizado por Brisa Narvaez.
				String sBuscar = JOptionPane.showInputDialog("Buscar");//Solicita al usuario el nombre del contacto que desea encontrar
				if (sBuscar != null) {
				    boolean encontrado = false;
				    for (int i = 0; i < contactos.size(); i++) {//recorre la lista comparando cada nombre con el solicitado.
				        if (contactos.get(i).getNomb().equalsIgnoreCase(sBuscar)) {
				            String datos = "Nombre: " + contactos.get(i).getNomb() + 
				                           "\nTeléfono: " + contactos.get(i).getTel();
				            JOptionPane.showMessageDialog(null, datos, "Contacto Encontrado", JOptionPane.INFORMATION_MESSAGE);
				            encontrado = true;//se muestra los datos del contacto si existe en la lista
				            break;
				        }
				    }

				    if (!encontrado) {
				        JOptionPane.showMessageDialog(null, "El contacto no fue encontrado");//si no encontro el contacto se muestra este mensaje
				    }
				}
			}
		});
		btnBuscarBrisa.setBounds(507, 15, 85, 21);
		contentPane.add(btnBuscarBrisa);


		/*Boton para eliminar Realizado por Jimena; Se pregunta que contacto se va a eliminar y se guarda en una variable de tipo String, entra a un ciclo en el
		 de tamaño del ArrayList, si el contacto existe se eliminar del ArrayList y de Jlist, le enviara un mensaje de que el contacto ya fue eliminado 
		 y enseguida saldra del for, si el contacto no existe al salir del for se le enviara un mensaje de que no existe el contacto. 
		 */
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Nombre = JOptionPane.showInputDialog("¿Contacto a eliminar?");
				boolean Res = false;
				for (int i = 0; i<contactos.size(); i++) { 
					if(contactos.get(i).getNomb().equalsIgnoreCase(Nombre)) { 
					contactos.remove(i);           
					JLNombres.removeElementAt(i); 
					JOptionPane.showMessageDialog(null,"El contacto " + Nombre + " fue eliminado");
					Res = true; 
					break;
					
				}
					
			}
				if (Res == false) {
				     JOptionPane.showMessageDialog(null,"El contacto " + Nombre + " no existe");
				     }
			     
			}
		});
		btnBorrar.setBounds(503, 258, 89, 23);
		contentPane.add(btnBorrar);
		
	}
}
