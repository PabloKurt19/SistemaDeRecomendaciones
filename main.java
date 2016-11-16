import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
	private JTextArea textArea1;
	private JButton boton2;
	private JButton boton3;
	private JButton boton4;
	private funcionesDB baseDeDatos;
	private String enfoque;
	private String curso;
	private String intereses;
	private Vector <String> resultado;
	private JTextField textField1;
	private JButton boton5;
	private JLabel label6;
	private JLabel label7;
	private JComboBox comboIntereses;
	private JButton boton6;
	private JTextArea textArea2;
	private JLabel label8;
	private JButton boton7;

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
		baseDeDatos = new funcionesDB();
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
		
		boton1 = new JButton("Recomendaciones Catedraticos");
		boton1.setFont(new Font("Arial", Font.PLAIN, 12));
		boton1.setBounds(274, 499, 242, 45);
		boton1.addActionListener(new MiListener());
		panel1.add(boton1);
		
		boton5 = new JButton("Recomendaciones Clubs");
		boton5.setFont(new Font("Arial", Font.PLAIN, 12));
		boton5.setBounds(20, 499, 242, 45);
		panel1.add(boton5);
		boton5.addActionListener(new MiListener());
		
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
		comboCalculo2.setModel(new DefaultComboBoxModel(new String[] {"PreparacionCalculo3", "UltimoCalculo"}));
		comboCalculo2.setBounds(325, 105, 135, 33);
		panel2.add(comboCalculo2);
		comboCalculo2.setVisible(false);
		
		comboCalculo3 = new JComboBox();
		comboCalculo3.setModel(new DefaultComboBoxModel(new String[] {"ConocimientosFundamentales", "Estandar", "Abstracto"}));
		comboCalculo3.setBounds(325, 105, 135, 33);
		panel2.add(comboCalculo3);
		comboCalculo3.setVisible(false);
		
		comboModelos = new JComboBox();
		comboModelos.setModel(new DefaultComboBoxModel(new String[] {"Ingenieria", "Biologia"}));
		comboModelos.setBounds(325, 105, 135, 33);
		panel2.add(comboModelos);
		comboModelos.setVisible(true);
		
		comboAlgebra = new JComboBox();
		comboAlgebra.setModel(new DefaultComboBoxModel(new String[] {"Practico","ConocimientosMecanicos", "ConocimientosAnaliticos"}));
		comboAlgebra.setBounds(325, 105, 135, 33);
		panel2.add(comboAlgebra);
		comboAlgebra.setVisible(false);
		
		comboEcuas = new JComboBox();
		comboEcuas.setModel(new DefaultComboBoxModel(new String[] {"Fisico","Matematico"}));
		comboEcuas.setBounds(325, 105, 135, 33);
		panel2.add(comboEcuas);
		comboEcuas.setVisible(false);
		
		textArea1 = new JTextArea();
		textArea1.setBounds(56, 273, 438, 196);
		panel2.add(textArea1);
		
		boton2 = new JButton("Seleccionar Curso");
		boton2.setBounds(70, 167, 166, 25);
		panel2.add(boton2);
		boton2.addActionListener(new MiListener());
		
		boton3 = new JButton("Salir");
		boton3.setBounds(363, 528, 97, 25);
		panel2.add(boton3);
		
		boton4 = new JButton("Buscar Recomendaciones");
		boton4.addActionListener(new MiListener());
		boton4.setBounds(304, 167, 177, 25);
		panel2.add(boton4);
		
		textField1 = new JTextField();
		textField1.setBounds(56, 238, 438, 22);
		panel2.add(textField1);
		textField1.setColumns(10);
		boton3.addActionListener(new MiListener());
		
		panel3 = new JPanel();
		panelCont.add(panel3, "3");
		panel3.setLayout(null);
		
		label6 = new JLabel("New label");
		label6.setIcon(new ImageIcon("C:\\Users\\usuario\\Documents\\Universidad\\4to. Semestre\\Algor\u00EDtmos y Estructura de Datos\\Proyecto2SistemaDeRecomendaciones\\src\\equipo.png"));
		label6.setBounds(78, 33, 397, 189);
		panel3.add(label6);
		
		label7 = new JLabel("Intereses");
		label7.setFont(new Font("Arial", Font.PLAIN, 16));
		label7.setBounds(150, 235, 86, 29);
		panel3.add(label7);
		
		comboIntereses = new JComboBox();
		comboIntereses.setFont(new Font("Arial", Font.PLAIN, 15));
		comboIntereses.setModel(new DefaultComboBoxModel(new String[] {"Artisticos", "Academicos", "Deportivos", "Entretenimiento"}));
		comboIntereses.setBounds(114, 277, 143, 34);
		panel3.add(comboIntereses);
		
		boton6 = new JButton("Salir");
		boton6.setBounds(78, 499, 397, 55);
		panel3.add(boton6);
		boton6.addActionListener(new MiListener());
		
		textArea2 = new JTextArea();
		textArea2.setBounds(78, 364, 397, 96);
		panel3.add(textArea2);
		
		label8 = new JLabel("Los CLUBS recomendados son:");
		label8.setFont(new Font("Arial", Font.PLAIN, 16));
		label8.setBounds(89, 324, 273, 27);
		panel3.add(label8);
		
		boton7 = new JButton("Buscar Club");
		boton7.setBounds(316, 277, 130, 34);
		panel3.add(boton7);
		boton7.addActionListener(new MiListener());
		
		cl.show(panelCont, "1");
	}
	
	private class MiListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			//boton1
			//Ingresa al sistema de recomendaciones, se muestra el segundo panel
			if(e.getSource()==boton1){
				cl.show(panelCont, "2");
				baseDeDatos.Conectar();
				textField1.setText("");
				textArea1.setText(" ");
				comboModelos.disable();
				comboCalculo.disable();
				comboCalculo2.disable();
				comboCalculo3.disable();
				comboAlgebra.disable();
				comboEcuas.disable();
				boton4.disable();
			}
			
			//boton2
			//Selecciona el curso y cambia el comboBox de enfoque
			if(e.getSource()==boton2){
				curso = (String) combo1.getSelectedItem();
				boton4.enable();
				comboModelos.enable();
				comboCalculo.enable();
				comboCalculo2.enable();
				comboCalculo3.enable();
				comboAlgebra.enable();
				comboEcuas.enable();
				
				
				//Se selecciona Modelos
				if(curso.equals("Modelos Matematicos")){
					comboModelos.setVisible(true);
					comboCalculo.setVisible(false);
					comboCalculo2.setVisible(false);
					comboCalculo3.setVisible(false);
					comboAlgebra.setVisible(false);
					comboEcuas.setVisible(false);
					
					enfoque = (String) comboModelos.getSelectedItem();
				}
				
				//Se selecciona Calculo1
				if(curso.equals("Calculo 1")){
					comboModelos.setVisible(false);
					comboCalculo.setVisible(true);
					comboCalculo2.setVisible(false);
					comboCalculo3.setVisible(false);
					comboAlgebra.setVisible(false);
					comboEcuas.setVisible(false);
					
					enfoque = (String) comboCalculo.getSelectedItem();
				}
				
				//Se selecciona Calculo2
				if(curso.equals("Calculo 2")){
					comboModelos.setVisible(false);
					comboCalculo.setVisible(false);
					comboCalculo2.setVisible(true);
					comboCalculo3.setVisible(false);
					comboAlgebra.setVisible(false);
					comboEcuas.setVisible(false);
					
					enfoque = (String) comboCalculo2.getSelectedItem();
				}
				
				//Se selecciona Calculo3
				if(curso.equals("Calculo 3")){
					comboModelos.setVisible(false);
					comboCalculo.setVisible(false);
					comboCalculo2.setVisible(false);
					comboCalculo3.setVisible(true);
					comboAlgebra.setVisible(false);
					comboEcuas.setVisible(false);
					
					enfoque = (String) comboCalculo3.getSelectedItem();
				}
				
				//Se selecciona Algebra
				if(curso.equals("Algebra Lineal 1")){
					comboModelos.setVisible(false);
					comboCalculo.setVisible(false);
					comboCalculo2.setVisible(false);
					comboCalculo3.setVisible(false);
					comboAlgebra.setVisible(true);
					comboEcuas.setVisible(false);
					
					enfoque = (String) comboAlgebra.getSelectedItem();
				}
				
				//Se selecciona Ecuas
				if(curso.equals("Ecuaciones Diferenciales 1")){
					comboModelos.setVisible(false);
					comboCalculo.setVisible(false);
					comboCalculo2.setVisible(false);
					comboCalculo3.setVisible(false);
					comboAlgebra.setVisible(false);
					comboEcuas.setVisible(true);
					
					enfoque = (String) comboEcuas.getSelectedItem();
				}
				
			}
			//boton3
			//Sale del sistema
			if(e.getSource()==boton3){
				
				baseDeDatos.apagar();
				cl.show(panelCont, "1");
			}
			
			//boton4
			//Empieza la busqueda de recomendacion de maestros según enfoque y curso
			if(e.getSource()==boton4){
				curso = (String) combo1.getSelectedItem();
				comboModelos.disable();
				comboCalculo.disable();
				comboCalculo2.disable();
				comboCalculo3.disable();
				comboAlgebra.disable();
				comboEcuas.disable();
				//Se selecciona Modelos
				if(curso.equals("Modelos Matematicos")){
					comboModelos.setVisible(true);
					comboCalculo.setVisible(false);
					comboCalculo2.setVisible(false);
					comboCalculo3.setVisible(false);
					comboAlgebra.setVisible(false);
					comboEcuas.setVisible(false);
					
					enfoque = (String) comboModelos.getSelectedItem();
				}
				
				//Se selecciona Calculo1
				if(curso.equals("Calculo 1")){
					comboModelos.setVisible(false);
					comboCalculo.setVisible(true);
					comboCalculo2.setVisible(false);
					comboCalculo3.setVisible(false);
					comboAlgebra.setVisible(false);
					comboEcuas.setVisible(false);
					
					enfoque = (String) comboCalculo.getSelectedItem();
				}
				
				//Se selecciona Calculo2
				if(curso.equals("Calculo 2")){
					comboModelos.setVisible(false);
					comboCalculo.setVisible(false);
					comboCalculo2.setVisible(true);
					comboCalculo3.setVisible(false);
					comboAlgebra.setVisible(false);
					comboEcuas.setVisible(false);
					
					enfoque = (String) comboCalculo2.getSelectedItem();
				}
				
				//Se selecciona Calculo3
				if(curso.equals("Calculo 3")){
					comboModelos.setVisible(false);
					comboCalculo.setVisible(false);
					comboCalculo2.setVisible(false);
					comboCalculo3.setVisible(true);
					comboAlgebra.setVisible(false);
					comboEcuas.setVisible(false);
					
					enfoque = (String) comboCalculo3.getSelectedItem();
				}
				
				//Se selecciona Algebra
				if(curso.equals("Algebra Lineal 1")){
					comboModelos.setVisible(false);
					comboCalculo.setVisible(false);
					comboCalculo2.setVisible(false);
					comboCalculo3.setVisible(false);
					comboAlgebra.setVisible(true);
					comboEcuas.setVisible(false);
					
					enfoque = (String) comboAlgebra.getSelectedItem();
				}
				
				//Se selecciona Ecuas
				if(curso.equals("Ecuaciones Diferenciales 1")){
					comboModelos.setVisible(false);
					comboCalculo.setVisible(false);
					comboCalculo2.setVisible(false);
					comboCalculo3.setVisible(false);
					comboAlgebra.setVisible(false);
					comboEcuas.setVisible(true);
					
					enfoque = (String) comboEcuas.getSelectedItem();
				}
				textField1.setText("");
				textArea1.setText(" ");
				textField1.setText("Los catedráticos recomendados para el curso de "+curso+" son:");
				
				resultado = baseDeDatos.getRecomendation(enfoque);
				
				textArea1.setText(resultado.toString());
				boton4.disable();
				
			}
			
			//boton5
			//Recomendaciones de clubs
			if(e.getSource()==boton5){
				textArea2.setText(" ");
				baseDeDatos.Conectar();
				cl.show(panelCont, "3");
			}
			
			//boton6
			//Salir hacia el sistema
			if(e.getSource()==boton6){
				
				baseDeDatos.apagar();
				cl.show(panelCont, "1");
			}
			
			//boton7
			//Buscar clubs recomendados
			if(e.getSource()==boton7){
				intereses = (String) comboIntereses.getSelectedItem();
			}
		}
	}
}

