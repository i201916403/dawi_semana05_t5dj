package org.ciberfarma.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import org.ciberfarma.modelo.Usuario;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;

public class FrmManteUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtcodigo;
	private JTextField txtnombre;
	private JTextField txtapellido;
	private JTextField txtusuario;
	private JTextField txtclave;
	private JTextField txtfecha;
	private JTextField txttipo;
	private JTextField txtestado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteUsuario frame = new FrmManteUsuario();
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
	public FrmManteUsuario() {
		setTitle("Frm_Mantenimiento_Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 403);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.window);
		panel.setBackground(new Color(51, 51, 51));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Mantenimiento Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.window));
		panel.setBounds(10, 11, 383, 343);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCdigo.setForeground(SystemColor.window);
		lblCdigo.setBounds(10, 33, 53, 14);
		panel.add(lblCdigo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setForeground(SystemColor.window);
		lblNombre.setBounds(10, 68, 53, 14);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellido.setForeground(SystemColor.window);
		lblApellido.setBounds(10, 103, 53, 14);
		panel.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario.setForeground(SystemColor.window);
		lblUsuario.setBounds(10, 138, 53, 14);
		panel.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClave.setForeground(SystemColor.window);
		lblClave.setBounds(10, 173, 53, 14);
		panel.add(lblClave);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha.setForeground(SystemColor.window);
		lblFecha.setBounds(10, 208, 53, 14);
		panel.add(lblFecha);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipo.setForeground(SystemColor.window);
		lblTipo.setBounds(10, 243, 53, 14);
		panel.add(lblTipo);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado.setForeground(SystemColor.window);
		lblEstado.setBounds(10, 278, 53, 14);
		panel.add(lblEstado);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(62, 30, 86, 20);
		panel.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtnombre = new JTextField();
		txtnombre.setColumns(10);
		txtnombre.setBounds(62, 65, 183, 20);
		panel.add(txtnombre);
		
		txtapellido = new JTextField();
		txtapellido.setColumns(10);
		txtapellido.setBounds(62, 100, 183, 20);
		panel.add(txtapellido);
		
		txtusuario = new JTextField();
		txtusuario.setColumns(10);
		txtusuario.setBounds(62, 135, 142, 20);
		panel.add(txtusuario);
		
		txtclave = new JTextField();
		txtclave.setColumns(10);
		txtclave.setBounds(62, 170, 86, 20);
		panel.add(txtclave);
		
		txtfecha = new JTextField();
		txtfecha.setColumns(10);
		txtfecha.setBounds(62, 205, 86, 20);
		panel.add(txtfecha);
		
		txttipo = new JTextField();
		txttipo.setColumns(10);
		txttipo.setBounds(62, 240, 86, 20);
		panel.add(txttipo);
		
		txtestado = new JTextField();
		txtestado.setColumns(10);
		txtestado.setBounds(62, 275, 86, 20);
		panel.add(txtestado);
		
		JButton btnregistrar = new JButton("Registrar");
		btnregistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnregistrar.setForeground(new Color(255, 255, 255));
		btnregistrar.setBackground(SystemColor.inactiveCaptionText);
		btnregistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				registrar();
				
			}
		});
		btnregistrar.setBounds(284, 45, 89, 23);
		panel.add(btnregistrar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				actualizar();
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnActualizar.setForeground(new Color(255, 255, 255));
		btnActualizar.setBackground(SystemColor.inactiveCaptionText);
		btnActualizar.setBounds(284, 118, 89, 23);
		panel.add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(SystemColor.inactiveCaptionText);
		btnEliminar.setBounds(284, 191, 89, 23);
		panel.add(btnEliminar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				consultar();
				
			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.setBackground(SystemColor.inactiveCaptionText);
		btnConsultar.setBounds(284, 264, 89, 23);
		panel.add(btnConsultar);
	}
	
	//metodos
	
	void registrar()
	{
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		Usuario u = new Usuario();
		//u.setCodigo(15);
		u.setNombre(txtnombre.getText());
		u.setApellido(txtapellido.getText());
		u.setUsuario(txtusuario.getText());
		u.setClave(txtclave.getText());
		u.setFnacim(txtfecha.getText());
		u.setTipo(Integer.parseInt(txttipo.getText()));
		u.setEstado(Integer.parseInt(txtestado.getText()));
		
		//empezar transaccion
		em.getTransaction().begin();
		em.persist(u);
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
		Usuario u = em.find(Usuario.class, Integer.parseInt(txtcodigo.getText()));
		if (u != null) {
		txtnombre.setText(u.getNombre());
		txtapellido.setText(u.getApellido());
		txtusuario.setText(u.getUsuario());
		txtclave.setText(u.getClave());
		txtfecha.setText(u.getFnacim());		
		}
		else {
			JOptionPane.showMessageDialog(this, "Usuario con código no existe.");
		}

		
		em.close();
		fabrica.close();
	}
	
	void actualizar()
	{
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		
		
		
		em.close();
		fabrica.close();
	}
}
