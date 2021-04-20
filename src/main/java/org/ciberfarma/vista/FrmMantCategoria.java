package org.ciberfarma.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import org.ciberfarma.modelo.Categoria;
import org.ciberfarma.modelo.Usuario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMantCategoria extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtdescrip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantCategoria frame = new FrmMantCategoria();
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
	public FrmMantCategoria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setBounds(32, 41, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion:");
		lblNewLabel_1.setBounds(32, 85, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		txtid = new JTextField();
		txtid.setEnabled(false);
		txtid.setBounds(105, 38, 86, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtdescrip = new JTextField();
		txtdescrip.setBounds(105, 82, 149, 20);
		contentPane.add(txtdescrip);
		txtdescrip.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				registrar();
			}
		});
		btnAgregar.setBounds(306, 37, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				consultar();
			}
		});
		btnConsultar.setBounds(306, 81, 89, 23);
		contentPane.add(btnConsultar);
	}
	
	//metodos
	
	void registrar()
	{
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		Categoria c = new Categoria();
		//u.setCodigo(15);
		c.setDescripcion(txtdescrip.getText());
		
		//empezar transaccion
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
		//cerrar
		em.close();
		fabrica.close();
	}
	
	void consultar()
	{
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		//consulta
		Categoria c = em.find(Categoria.class, Integer.parseInt(txtid.getText()));
		if (c != null) {
		txtdescrip.setText(c.getDescripcion());	
		}
		else {
			JOptionPane.showMessageDialog(this, "Categoria con código no existe.");
		}

		
		em.close();
		fabrica.close();
	}
}
