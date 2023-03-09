package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainWindow extends JFrame {

	private JButton log_in, sing_in, exit;
	private JLabel team, logo, user_label, password_label;
	private JTextField user_textfield, password_textfield;

	public MainWindow() {
		setBounds(500, 0, 500, 500);
		setLayout(null);
		setResizable(false);

		log_in = new JButton("Iniciar Sesion"); // boton inicio de sesion
		log_in.setBounds(75, 315, 150, 50);
		add(log_in);

		sing_in = new JButton("Registrar"); // boton registrar
		sing_in.setBounds(225, 315, 150, 50);
		add(sing_in);

		exit = new JButton("Salir"); // boton salir
		exit.setBounds(185, 375, 75, 50);
		add(exit);

		user_label = new JLabel("Usuario:"); // Usuario indicador
		user_label.setBounds(125, 200, 150, 30);
		add(user_label);

		user_textfield = new JTextField(); // campo de texto para el usuario
		user_textfield.setBounds(200, 200, 150, 30);
		add(user_textfield);

		password_label = new JLabel("Contraseña:"); // Contraseña indicador
		password_label.setBounds(125, 250, 150, 30);
		add(password_label);

		password_textfield = new JTextField(); // campo de texto para la contraseña
		password_textfield.setBounds(200, 250, 150, 30);
		add(password_textfield);

		logo = new JLabel("Logo"); // Logo del programa
		logo.setBounds(200, 50, 100, 100);
		BufferedImage b = null;
		try {
			b = ImageIO.read(new File("src/pokebola.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image redim = b.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
		logo.setIcon(new ImageIcon(redim));
		add(logo);

		team = new JLabel("Condenados Corps.®"); // Nombre empresa
		team.setBounds(310, 335, 350, 200);
		add(team);

	}

	public JButton getLog_in() {
		return log_in;
	}

	public void setLog_in(JButton log_in) {
		this.log_in = log_in;
	}

	public JButton getSing_in() {
		return sing_in;
	}

	public void setSing_in(JButton sing_in) {
		this.sing_in = sing_in;
	}

	public JButton getExit() {
		return exit;
	}

	public void setExit(JButton exit) {
		this.exit = exit;
	}

	public JLabel getTeam() {
		return team;
	}

	public void setTeam(JLabel team) {
		this.team = team;
	}

	public JLabel getLogo() {
		return logo;
	}

	public void setLogo(JLabel logo) {
		this.logo = logo;
	}

	public JLabel getUser_label() {
		return user_label;
	}

	public void setUser_label(JLabel user_label) {
		this.user_label = user_label;
	}

	public JLabel getPassword_label() {
		return password_label;
	}

	public void setPassword_label(JLabel password_label) {
		this.password_label = password_label;
	}

	public JTextField getUser_textfield() {
		return user_textfield;
	}

	public void setUser_textfield(JTextField user_textfield) {
		this.user_textfield = user_textfield;
	}

	public JTextField getPassword_textfield() {
		return password_textfield;
	}

	public void setPassword_textfield(JTextField password_textfield) {
		this.password_textfield = password_textfield;
	}

	public String loginData() { // Construye un string con la informacion de los textfield
		return "login," + user_textfield.getText() + "," + password_textfield.getText();
	}

	public void eraseData() { // Bora los datos en los textfield
		this.password_textfield.setText("");
		this.user_textfield.setText("");
	}
	
	public boolean confirmField() { // Confirma si hay alguno vacio
		boolean state = false;
		if(this.password_textfield.getText().isEmpty() || this.user_textfield.getText().isEmpty()) {
			state = true;
		}
			
			return state;
	}
}
