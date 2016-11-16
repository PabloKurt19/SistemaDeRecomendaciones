import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class main {

	private JFrame frame;
	private JPanel panelCont;
	private CardLayout cl;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JButton boton1;
	private JComboBox combo1;
	private JComboBox comboCalculo;
	private JComboBox comboCalculo2;
	private JComboBox comboCalculo3;
	private JComboBox comboModelos;
	private JComboBox comboAlgebra;
	private JComboBox comboEcuas;
	private JTextArea textArea;
	private JButton boton2;
	private JButton boton3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
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
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 576, 641);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelCont = (JPanel) frame.getContentPane();
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		cl = (CardLayout)(frame.getContentPane().getLayout());
		
		panel1 = new JPanel();
		panelCont.add(panel1, "1");
		panel1.setLayout(null);
		
		label1 = new JLabel("Bienvenido al Sistema de recomendacion de asignaciones");
		label1.setFont(new Font("Arial", Font.PLAIN, 20));
		label1.setBounds(20, 13, 526, 45);
		panel1.add(label1);
		
		label2 = new JLabel("");
		label2.setIcon(new ImageIcon("C:\\Users\\usuario\\Documents\\Universidad\\4to. Semestre\\Algor\u00EDtmos y Estructura de Datos\\Proyecto2SistemaDeRecomendaciones\\src\\logo.png"));
		label2.setBounds(131, 73, 333, 387);
		panel1.add(label2);
		
		boton1 = new JButton("Ingresar");
		boton1.setFont(new Font("Arial", Font.PLAIN, 12));
		boton1.setBounds(233, 500, 115, 45);
		boton1.addActionListener(new MiListener());
		panel1.add(boton1);
		
		panel2 = new JPanel();
		panelCont.add(panel2, "2");
		panel2.setLayout(null);
		
		label3 = new JLabel("Sistema de Recomendacion de Asignaciones");
		label3.setFont(new Font("Arial", Font.PLAIN, 20));
		label3.setBounds(82, 13, 412, 45);
		panel2.add(label3);
		
		label4 = new JLabel("Curso");
		label4.setFont(new Font("Arial", Font.PLAIN, 16));
		label4.setBounds(119,59,52,33);
		panel2.add(label4);
		
		combo1 = new JComboBox();
		combo1.setModel(new DefaultComboBoxModel(new String[] {"Modelos Matematicos", "Calculo 1", "Calculo 2", "Calculo 3", "Algebra Lineal 1", "Ecuaciones Diferenciales 1"}));
		combo1.setBounds(82, 105, 135, 33);
		panel2.add(combo1);
		
		label5 = new JLabel("Enfoque");
		label5.setFont(new Font("Arial", Font.PLAIN, 16));
		label5.setBounds(358,59,66,33);
		panel2.add(label5);
		
		comboCalculo = new JComboBox();
		comboCalculo.setModel(new DefaultComboBoxModel(new String[] {"Analisis", "Mecanico"}));
		comboCalculo.setBounds(325, 105, 135, 33);
		panel2.add(comboCalculo);
		comboCalculo.setVisible(false);
		
		comboCalculo2 = new JComboBox();
		comboCalculo2.setModel(new DefaultComboBoxModel(new String[] {"Preparatorio C3", "Ultimo Calculo"}));
		comboCalculo2.setBounds(325, 105, 135, 33);
		panel2.add(comboCalculo2);
		comboCalculo2.setVisible(false);
		
		comboCalculo3 = new JComboBox();
		comboCalculo3.setModel(new DefaultComboBoxModel(new String[] {"Conocimientos Fundamentales", "Estandar", "Abstracto"}));
		comboCalculo3.setBounds(325, 105, 135, 33);
		panel2.add(comboCalculo3);
		comboCalculo3.setVisible(false);
		
		comboModelos = new JComboBox();
		comboModelos.setModel(new DefaultComboBoxModel(new String[] {"Ingenieria", "Biologia"}));
		comboModelos.setBounds(325, 105, 135, 33);
		panel2.add(comboModelos);
		comboModelos.setVisible(true);
		
		comboAlgebra = new JComboBox();
		comboAlgebra.setModel(new DefaultComboBoxModel(new String[] {"Practico","Conocimientos Mecanicos", "Conocimientos Analiticos"}));
		comboAlgebra.setBounds(325, 105, 135, 33);
		panel2.add(comboAlgebra);
		comboAlgebra.setVisible(false);
		
		comboEcuas = new JComboBox();
		comboEcuas.setModel(new DefaultComboBoxModel(new String[] {"Fisico","Matematico"}));
		comboEcuas.setBounds(325, 105, 135, 33);
		panel2.add(comboEcuas);
		comboEcuas.setVisible(false);
		
		textArea = new JTextArea();
		textArea.setBounds(82, 219, 378, 250);
		panel2.add(textArea);
		
		boton2 = new JButton("Seleccionar Curso");
		boton2.setBounds(82, 167, 135, 25);
		panel2.add(boton2);
		boton2.addActionListener(new MiListener());
		
		boton3 = new JButton("Salir");
		boton3.setBounds(363, 528, 97, 25);
		panel2.add(boton3);
		boton3.addActionListener(new MiListener());
		
		cl.show(panelCont, "1");
	}
	
	private class MiListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			//boton1
			//Ingresa al sistema de recomendaciones, se muestra el segundo panel
			if(e.getSource()==boton1){
				cl.show(panelCont, "2");
			}
			
			//boton2
			//Selecciona el curso y cambia el comboBox de enfoque
			if(e.getSource()==boton2){
				String curso = (String) combo1.getSelectedItem();
				System.out.println(curso);
				
				//Se selecciona Modelos
				if(curso.equals("Modelos Matematicos")){
					comboModelos.setVisible(true);
					comboCalculo.setVisible(false);
					comboCalculo2.setVisible(false);
					comboCalculo3.setVisible(false);
					comboAlgebra.setVisible(false);
					comboEcuas.setVisible(false);
				}
				
				//Se selecciona Calculo1
				if(curso.equals("Calculo 1")){
					comboModelos.setVisible(false);
					comboCalculo.setVisible(true);
					comboCalculo2.setVisible(false);
					comboCalculo3.setVisible(false);
					comboAlgebra.setVisible(false);
					comboEcuas.setVisible(false);
				}
				
				//Se selecciona Calculo2
				if(curso.equals("Calculo 2")){
					comboModelos.setVisible(false);
					comboCalculo.setVisible(false);
					comboCalculo2.setVisible(true);
					comboCalculo3.setVisible(false);
					comboAlgebra.setVisible(false);
					comboEcuas.setVisible(false);
				}
				
				//Se selecciona Calculo3
				if(curso.equals("Calculo 3")){
					comboModelos.setVisible(false);
					comboCalculo.setVisible(false);
					comboCalculo2.setVisible(false);
					comboCalculo3.setVisible(true);
					comboAlgebra.setVisible(false);
					comboEcuas.setVisible(false);
				}
				
				//Se selecciona Algebra
				if(curso.equals("Algebra Lineal 1")){
					comboModelos.setVisible(false);
					comboCalculo.setVisible(false);
					comboCalculo2.setVisible(false);
					comboCalculo3.setVisible(false);
					comboAlgebra.setVisible(true);
					comboEcuas.setVisible(false);
				}
				
				//Se selecciona Ecuas
				if(curso.equals("Ecuaciones Diferenciales 1")){
					comboModelos.setVisible(false);
					comboCalculo.setVisible(false);
					comboCalculo2.setVisible(false);
					comboCalculo3.setVisible(false);
					comboAlgebra.setVisible(false);
					comboEcuas.setVisible(true);
				}
				
			}
			//boton3
			//Sale del sistema
			if(e.getSource()==boton3){
				cl.show(panelCont, "1");
			}
		}
	}
}

