package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RegisterWindow extends JFrame {

	private JLabel logo, characters, user_label, password_label,
			mail_label;
	private JButton register_button;
	private ButtonGroup bg;
	private JRadioButton red, ash;
	private JTextField user_textfield, password_textfield, mail_textfield;

	public RegisterWindow() {
		setBounds(500, 0, 600, 500);
		setLayout(null);
		setResizable(false);

		logo = new JLabel(); // Logo del programa
		logo.setBounds(200, 30, 50, 50);
		BufferedImage b = null;
		try {
			b = ImageIO.read(new File("src/pokebola.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image redim = b.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
		logo.setIcon(new ImageIcon(redim));
		add(logo);

		characters = new JLabel(); // Imagen de los personajes que se pueden elegir
		characters.setBounds(300, 100, 150, 125);
		BufferedImage b1 = null;
		try {
			b1 = ImageIO.read(new File("src/red ash.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image redim1 = b1.getScaledInstance(characters.getWidth(), characters.getHeight(), Image.SCALE_SMOOTH);
		characters.setIcon(new ImageIcon(redim1));
		add(characters);

		bg = new ButtonGroup(); // Grupo de botones para la elección de personajes
		red = new JRadioButton("Red");
		red.setBounds(300, 225, 50, 50);
		add(red);
		bg.add(red);
		ash = new JRadioButton("Ash");
		ash.setBounds(385, 225, 50, 50);
		add(ash);
		bg.add(ash);

		user_label = new JLabel("Usuario:"); // Usuario indicador
		user_label.setBounds(50, 80, 150, 30);
		add(user_label);

		user_textfield = new JTextField(); // campo de texto para el usuario
		user_textfield.setBounds(50, 110, 150, 30);
		add(user_textfield);

		password_label = new JLabel("Contraseña:"); // Contraseña indicador
		password_label.setBounds(50, 140, 150, 30);
		add(password_label);

		password_textfield = new JTextField(); // campo de texto para el usuario
		password_textfield.setBounds(50, 170, 150, 30);
		add(password_textfield);

		mail_label = new JLabel("Correo:"); // Contraseña indicador
		mail_label.setBounds(50, 200, 150, 30);
		add(mail_label);

		mail_textfield = new JTextField(); // campo de texto para el usuario
		mail_textfield.setBounds(50, 230, 150, 30);
		add(mail_textfield);
		
		register_button = new JButton("Registrar"); // Boton para registrar y pasar de ventana
		register_button.setBounds(200, 350, 100, 50);
		add(register_button);
	}

	public JLabel getLogo() {
		return logo;
	}

	public void setLogo(JLabel logo) {
		this.logo = logo;
	}

	public JLabel getCharacters() {
		return characters;
	}

	public void setCharacters(JLabel characters) {
		this.characters = characters;
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

	public JLabel getMail_label() {
		return mail_label;
	}

	public void setMail_label(JLabel mail_label) {
		this.mail_label = mail_label;
	}

	public JButton getRegister_button() {
		return register_button;
	}

	public void setRegister_button(JButton register_button) {
		this.register_button = register_button;
	}

	public ButtonGroup getBg() {
		return bg;
	}

	public void setBg(ButtonGroup bg) {
		this.bg = bg;
	}

	public JRadioButton getRed() {
		return red;
	}

	public void setRed(JRadioButton red) {
		this.red = red;
	}

	public JRadioButton getAsh() {
		return ash;
	}

	public void setAsh(JRadioButton ash) {
		this.ash = ash;
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

	public JTextField getMail_textfield() {
		return mail_textfield;
	}

	public void setMail_textfield(JTextField mail_textfield) {
		this.mail_textfield = mail_textfield;
	}
	
	public String loginData() { // Construye un string con la informacion de los textfield
		return "login," + user_textfield.getText() + "," + password_textfield.getText() + "," + mail_textfield.getText();
	}

	public void eraseData() { // Borra los datos en los textfield
		this.password_textfield.setText("");
		this.user_textfield.setText("");
		this.mail_textfield.setText("");
	}
	
	public boolean verifyPassword() {//Verifica que la contraseña no tiene coma
		boolean verify = false;
		if(this.password_textfield.getText().contains(",")) {
			verify = true;
		}
		return verify;
	}
	
	public boolean confirmField() { // Confirma si hay alguno vacio
		boolean state = false;
		if(this.password_textfield.getText().isEmpty() || this.user_textfield.getText().isEmpty() || this.mail_textfield.getText().isEmpty()) {
			state = true;
		}
			
			return state;
	}

}
