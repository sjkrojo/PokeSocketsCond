package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterPokemonWindow extends JFrame {

	private JPanel name, attributes, attacks;
	private JLabel logo, pokemon_icon, pokemon_label, nick_label, ps_label, attack_label, def_label, attack_esp_label,
			def_esp_label, speed_label, level_label, attack1_label, attack2_label, attack3_label, attack4_label;
	private JButton back_button, save_button;
	private JTextField pokemon_name, pokemon_nick, pokemon_ps, pokemon_attack, pokemon_def, pokemon_attack_esp,
			pokemon_def_esp, pokemon_speed, pokemon_level, pokemon_attack1, pokemon_attack2, pokemon_attack3,
			pokemon_attack4;

	public RegisterPokemonWindow() {
		setBounds(500, 0, 600, 500);
		setLayout(null);
		setResizable(false);

		logo = new JLabel("Logo"); // Logo del programa
		logo.setBounds(425, 25, 100, 100);
		BufferedImage b = null;
		try {
			b = ImageIO.read(new File("src/pokebola.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image redim = b.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
		logo.setIcon(new ImageIcon(redim));
		add(logo);

		name = new JPanel(); // Panel donde está se ingresa el nombre y mote del pokemon
		name.setBounds(10, 10, 400, 150);
		name.setBackground(Color.black);
		name.setLayout(null);
		add(name);

		pokemon_label = new JLabel("Pokemon:"); // Nombre Pokemon
		pokemon_label.setBounds(0, 0, 150, 30);
		name.add(pokemon_label);

		pokemon_name = new JTextField(); // campo de texto para el nombre de pokemon
		pokemon_name.setBounds(100, 0, 150, 30);
		name.add(pokemon_name);

		nick_label = new JLabel("Mote:"); // Mote Pokemon
		nick_label.setBounds(0, 40, 150, 30);
		name.add(nick_label);

		pokemon_nick = new JTextField(); // campo de texto para el mote de pokemon
		pokemon_nick.setBounds(100, 40, 150, 30);
		name.add(pokemon_nick);

		pokemon_icon = new JLabel("IMAGEN POKE:"); // Imagen Pokemon
		pokemon_icon.setBounds(50, 100, 150, 30);
		name.add(pokemon_icon);

		attributes = new JPanel(); // Panel donde está se ingresan los atributos del pokemon
		attributes.setBounds(10, 170, 450, 150);
		attributes.setBackground(Color.black);
		attributes.setLayout(null);
		add(attributes);

		ps_label = new JLabel("PS:"); // PS Pokemon
		ps_label.setBounds(0, 0, 50, 30);
		attributes.add(ps_label);

		pokemon_ps = new JTextField(); // campo de texto para los ps del pokemon
		pokemon_ps.setBounds(40, 0, 75, 30);
		attributes.add(pokemon_ps);

		attack_label = new JLabel("Ataque:"); // Ataque Pokemon
		attack_label.setBounds(125, 0, 50, 30);
		attributes.add(attack_label);

		pokemon_attack = new JTextField(); // campo de texto para el ataque del pokemon
		pokemon_attack.setBounds(175, 0, 75, 30);
		attributes.add(pokemon_attack);

		def_label = new JLabel("Defensa:"); // Defensa Pokemon
		def_label.setBounds(0, 50, 50, 30);
		attributes.add(def_label);

		pokemon_def = new JTextField(); // campo de texto para la defensa del pokemon
		pokemon_def.setBounds(65, 50, 75, 30);
		attributes.add(pokemon_def);

		attack_esp_label = new JLabel("Ataque Esp:"); // Ataque Esp Pokemon
		attack_esp_label.setBounds(275, 0, 75, 30);
		attributes.add(attack_esp_label);

		pokemon_attack_esp = new JTextField(); // campo de texto para el ataque especial del pokemon
		pokemon_attack_esp.setBounds(350, 0, 75, 30);
		attributes.add(pokemon_attack_esp);

		def_esp_label = new JLabel("Defensa Esp:"); // Defensa Esp Pokemon
		def_esp_label.setBounds(150, 50, 75, 30);
		attributes.add(def_esp_label);

		pokemon_def_esp = new JTextField(); // campo de texto para la defensa especial del pokemon
		pokemon_def_esp.setBounds(235, 50, 75, 30);
		attributes.add(pokemon_def_esp);

		speed_label = new JLabel("Velocidad:"); // Velocidad Pokemon
		speed_label.setBounds(0, 100, 75, 30);
		attributes.add(speed_label);

		pokemon_speed = new JTextField(); // campo de texto para la velocidad del pokemon
		pokemon_speed.setBounds(65, 100, 75, 30);
		attributes.add(pokemon_speed);

		level_label = new JLabel("Nivel:"); // Nivel Pokemon
		level_label.setBounds(150, 100, 75, 30);
		attributes.add(level_label);

		pokemon_level = new JTextField(); // campo de texto para el nivel del pokemon
		pokemon_level.setBounds(235, 100, 75, 30);
		attributes.add(pokemon_level);

		attacks = new JPanel(); // Panel donde está se ingresan los ataques del pokemon
		attacks.setBounds(10, 330, 450, 125);
		attacks.setBackground(Color.black);
		attacks.setLayout(null);
		add(attacks);

		attack1_label = new JLabel("Ataque 1:"); // Ataque 1 Pokemon
		attack1_label.setBounds(0, 0, 150, 30);
		attacks.add(attack1_label);

		pokemon_attack1 = new JTextField(); // campo de texto para el primer ataque de pokemon
		pokemon_attack1.setBounds(65, 0, 150, 30);
		attacks.add(pokemon_attack1);

		attack2_label = new JLabel("Ataque 2:"); // Ataque 2 Pokemon
		attack2_label.setBounds(0, 50, 150, 30);
		attacks.add(attack2_label);

		pokemon_attack2 = new JTextField(); // campo de texto para el segundo ataque de pokemon
		pokemon_attack2.setBounds(65, 50, 150, 30);
		attacks.add(pokemon_attack2);

		attack3_label = new JLabel("Ataque 3:"); // Ataque 3 Pokemon
		attack3_label.setBounds(220, 0, 150, 30);
		attacks.add(attack3_label);

		pokemon_attack3 = new JTextField(); // campo de texto para el tercer ataque de pokemon
		pokemon_attack3.setBounds(285, 0, 150, 30);
		attacks.add(pokemon_attack3);

		attack4_label = new JLabel("Ataque 4:"); // Ataque 4 Pokemon
		attack4_label.setBounds(220, 50, 150, 30);
		attacks.add(attack4_label);

		pokemon_attack4 = new JTextField(); // campo de texto para el cuarto ataque de pokemon
		pokemon_attack4.setBounds(285, 50, 150, 30);
		attacks.add(pokemon_attack4);

		save_button = new JButton("Guardar"); // Boton para guardar el pokemon
		save_button.setBounds(480, 275, 100, 50);
		add(save_button);

		back_button = new JButton("Regresar"); // Boton para regresar a la ventana equipo
		back_button.setBounds(480, 325, 100, 50);
		add(back_button);

	}

	public void setName(JPanel name) {
		this.name = name;
	}

	public JPanel getAttributes() {
		return attributes;
	}

	public void setAttributes(JPanel attributes) {
		this.attributes = attributes;
	}

	public JPanel getAttacks() {
		return attacks;
	}

	public void setAttacks(JPanel attacks) {
		this.attacks = attacks;
	}

	public JLabel getLogo() {
		return logo;
	}

	public void setLogo(JLabel logo) {
		this.logo = logo;
	}

	public JLabel getPokemon_icon() {
		return pokemon_icon;
	}

	public void setPokemon_icon(JLabel pokemon_icon) {
		this.pokemon_icon = pokemon_icon;
	}

	public JLabel getPokemon_label() {
		return pokemon_label;
	}

	public void setPokemon_label(JLabel pokemon_label) {
		this.pokemon_label = pokemon_label;
	}

	public JLabel getNick_label() {
		return nick_label;
	}

	public void setNick_label(JLabel nick_label) {
		this.nick_label = nick_label;
	}

	public JLabel getPs_label() {
		return ps_label;
	}

	public void setPs_label(JLabel ps_label) {
		this.ps_label = ps_label;
	}

	public JLabel getAttack_label() {
		return attack_label;
	}

	public void setAttack_label(JLabel attack_label) {
		this.attack_label = attack_label;
	}

	public JLabel getDef_label() {
		return def_label;
	}

	public void setDef_label(JLabel def_label) {
		this.def_label = def_label;
	}

	public JLabel getAttack_esp_label() {
		return attack_esp_label;
	}

	public void setAttack_esp_label(JLabel attack_esp_label) {
		this.attack_esp_label = attack_esp_label;
	}

	public JLabel getDef_esp_label() {
		return def_esp_label;
	}

	public void setDef_esp_label(JLabel def_esp_label) {
		this.def_esp_label = def_esp_label;
	}

	public JLabel getSpeed_label() {
		return speed_label;
	}

	public void setSpeed_label(JLabel speed_label) {
		this.speed_label = speed_label;
	}

	public JLabel getLevel_label() {
		return level_label;
	}

	public void setLevel_label(JLabel level_label) {
		this.level_label = level_label;
	}

	public JLabel getAttack1_label() {
		return attack1_label;
	}

	public void setAttack1_label(JLabel attack1_label) {
		this.attack1_label = attack1_label;
	}

	public JLabel getAttack2_label() {
		return attack2_label;
	}

	public void setAttack2_label(JLabel attack2_label) {
		this.attack2_label = attack2_label;
	}

	public JLabel getAttack3_label() {
		return attack3_label;
	}

	public void setAttack3_label(JLabel attack3_label) {
		this.attack3_label = attack3_label;
	}

	public JLabel getAttack4_label() {
		return attack4_label;
	}

	public void setAttack4_label(JLabel attack4_label) {
		this.attack4_label = attack4_label;
	}

	public JButton getBack_button() {
		return back_button;
	}

	public void setBack_button(JButton back_button) {
		this.back_button = back_button;
	}

	public JButton getSave_button() {
		return save_button;
	}

	public void setSave_button(JButton save_button) {
		this.save_button = save_button;
	}

	public JTextField getPokemon_name() {
		return pokemon_name;
	}

	public void setPokemon_name(JTextField pokemon_name) {
		this.pokemon_name = pokemon_name;
	}

	public JTextField getPokemon_nick() {
		return pokemon_nick;
	}

	public void setPokemon_nick(JTextField pokemon_nick) {
		this.pokemon_nick = pokemon_nick;
	}

	public JTextField getPokemon_ps() {
		return pokemon_ps;
	}

	public void setPokemon_ps(JTextField pokemon_ps) {
		this.pokemon_ps = pokemon_ps;
	}

	public JTextField getPokemon_attack() {
		return pokemon_attack;
	}

	public void setPokemon_attack(JTextField pokemon_attack) {
		this.pokemon_attack = pokemon_attack;
	}

	public JTextField getPokemon_def() {
		return pokemon_def;
	}

	public void setPokemon_def(JTextField pokemon_def) {
		this.pokemon_def = pokemon_def;
	}

	public JTextField getPokemon_attack_esp() {
		return pokemon_attack_esp;
	}

	public void setPokemon_attack_esp(JTextField pokemon_attack_esp) {
		this.pokemon_attack_esp = pokemon_attack_esp;
	}

	public JTextField getPokemon_def_esp() {
		return pokemon_def_esp;
	}

	public void setPokemon_def_esp(JTextField pokemon_def_esp) {
		this.pokemon_def_esp = pokemon_def_esp;
	}

	public JTextField getPokemon_speed() {
		return pokemon_speed;
	}

	public void setPokemon_speed(JTextField pokemon_speed) {
		this.pokemon_speed = pokemon_speed;
	}

	public JTextField getPokemon_level() {
		return pokemon_level;
	}

	public void setPokemon_level(JTextField pokemon_level) {
		this.pokemon_level = pokemon_level;
	}

	public JTextField getPokemon_attack1() {
		return pokemon_attack1;
	}

	public void setPokemon_attack1(JTextField pokemon_attack1) {
		this.pokemon_attack1 = pokemon_attack1;
	}

	public JTextField getPokemon_attack2() {
		return pokemon_attack2;
	}

	public void setPokemon_attack2(JTextField pokemon_attack2) {
		this.pokemon_attack2 = pokemon_attack2;
	}

	public JTextField getPokemon_attack3() {
		return pokemon_attack3;
	}

	public void setPokemon_attack3(JTextField pokemon_attack3) {
		this.pokemon_attack3 = pokemon_attack3;
	}

	public JTextField getPokemon_attack4() {
		return pokemon_attack4;
	}

	public void setPokemon_attack4(JTextField pokemon_attack4) {
		this.pokemon_attack4 = pokemon_attack4;
	}

	public String pokemon() {
		return pokemon_name.getText();
	}

	public String registerPokeInfo() {
		return "registerpoke," + pokemon_name.getText() + "," + pokemon_nick.getText() + "," + pokemon_ps.getText()
				+ "," + pokemon_attack.getText() + "," + pokemon_def.getText() + "," + pokemon_attack_esp.getText()
				+ "," + pokemon_def_esp.getText() + "," + pokemon_speed.getText() + "," + pokemon_level.getText() + ","
				+ pokemon_attack1.getText() + "," + pokemon_attack2.getText() + "," + pokemon_attack3.getText() + ","
				+ pokemon_attack4.getText();
	}
	
	public void eraseData() { // Borra los datos en los textfield
		this.pokemon_name.setText("");
		this.pokemon_nick.setText("");
		this.pokemon_ps.setText("");
		this.pokemon_attack.setText("");
		this.pokemon_def.setText("");
		this.pokemon_attack_esp.setText("");
		this.pokemon_def_esp.setText("");
		this.pokemon_speed.setText("");
		this.pokemon_level.setText("");
		this.pokemon_attack1.setText("");
		this.pokemon_attack2.setText("");
		this.pokemon_attack3.setText("");
		this.pokemon_attack4.setText("");
	}
	
	public boolean confirmField() { // Confirma si hay alguno vacio
		boolean state = false;
		if (this.pokemon_name.getText().isEmpty() || this.pokemon_nick.getText().isEmpty()
				|| this.pokemon_ps.getText().isEmpty() || this.pokemon_attack.getText().isEmpty()
				|| this.pokemon_def.getText().isEmpty() || this.pokemon_attack_esp.getText().isEmpty()
				|| this.pokemon_def_esp.getText().isEmpty() || this.pokemon_speed.getText().isEmpty()
				|| this.pokemon_level.getText().isEmpty() || this.pokemon_attack1.getText().isEmpty()
				|| this.pokemon_attack2.getText().isEmpty() || this.pokemon_attack3.getText().isEmpty()
				|| this.pokemon_attack4.getText().isEmpty()) {
			state = true;
		}

		return state;
	}

}
