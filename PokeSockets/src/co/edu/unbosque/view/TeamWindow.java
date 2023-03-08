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

public class TeamWindow extends JFrame{
	
	private JLabel user, logo, player_icon;	
	private JPanel info, team_pokemon;
	private JButton log_out, pc, pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6, register_button;
	
	public TeamWindow() {
		setBounds(500, 0, 600, 500);
		setLayout(null);
		setResizable(false);
		
		info = new JPanel(); // Panel donde está el usuario y el logo del programa
		info.setBounds(0, 0, 600, 100);
		info.setBackground(Color.black);
		info.setLayout(null);
		add(info);
		
		logo = new JLabel("Logo"); // Logo del programa
		logo.setBounds(400, 0, 100, 100);
		BufferedImage b = null;
		try {
			b = ImageIO.read(new File("src/pokebola.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image redim = b.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
		logo.setIcon(new ImageIcon(redim));
		info.add(logo);
		
		user = new JLabel("Usuario"); //Usuario
		user.setBounds(50, 25, 100, 50);
		info.add(user);
		
		player_icon = new JLabel(); // Imagen del jugador
		player_icon.setBounds(200, 125, 150, 125);
		BufferedImage b1 = null;
		try {
			b1 = ImageIO.read(new File("src/red ash.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image redim1 = b1.getScaledInstance(player_icon.getWidth(), player_icon.getHeight(), Image.SCALE_SMOOTH);
		player_icon.setIcon(new ImageIcon(redim1));
		add(player_icon);
		
		pc = new JButton("PC"); // Boton para ir a la pc
		pc.setBounds(400, 125, 150, 50);
		add(pc);
		
		log_out = new JButton("Cerrar sesión"); // Boton para cerrar sesión y volver a ventana inicial
		log_out.setBounds(400, 200, 150, 50);
		add(log_out);
		
		team_pokemon = new JPanel(); // Panel donde está el equipo del jugador
		team_pokemon.setBounds(0, 285, 600, 100);
		team_pokemon.setBackground(Color.black);
		team_pokemon.setLayout(null);
		add(team_pokemon);
		
		pokemon1 = new JButton("1"); // Pokemon del equipo 1
		pokemon1.setBounds(75, 25, 50, 50);
		team_pokemon.add(pokemon1);
		
		pokemon2 = new JButton("2"); // Pokemon del equipo 2
		pokemon2.setBounds(150, 25, 50, 50);
		team_pokemon.add(pokemon2);
		
		pokemon3 = new JButton("3"); // Pokemon del equipo 3
		pokemon3.setBounds(225, 25, 50, 50);
		team_pokemon.add(pokemon3);
		
		pokemon4 = new JButton("4"); // Pokemon del equipo 4
		pokemon4.setBounds(300, 25, 50, 50);
		team_pokemon.add(pokemon4);
		
		pokemon5 = new JButton("5"); // Pokemon del equipo 5
		pokemon5.setBounds(375, 25, 50, 50);
		team_pokemon.add(pokemon5);
		
		pokemon6 = new JButton("6"); // Pokemon del equipo 6
		pokemon6.setBounds(450, 25, 50, 50);
		team_pokemon.add(pokemon6);
		
		register_button = new JButton("Registrar"); // Boton para ir a la ventana de registro de pokemon
		register_button.setBounds(200, 400, 150, 50);
		add(register_button);
	}

	public JLabel getUser() {
		return user;
	}

	public void setUser(JLabel user) {
		this.user = user;
	}

	public JLabel getLogo() {
		return logo;
	}

	public void setLogo(JLabel logo) {
		this.logo = logo;
	}

	public JLabel getPlayer_icon() {
		return player_icon;
	}

	public void setPlayer_icon(JLabel player_icon) {
		this.player_icon = player_icon;
	}

	public JPanel getInfo() {
		return info;
	}

	public void setInfo(JPanel info) {
		this.info = info;
	}

	public JPanel getTeam_pokemon() {
		return team_pokemon;
	}

	public void setTeam_pokemon(JPanel team_pokemon) {
		this.team_pokemon = team_pokemon;
	}

	public JButton getLog_out() {
		return log_out;
	}

	public void setLog_out(JButton log_out) {
		this.log_out = log_out;
	}

	public JButton getPc() {
		return pc;
	}

	public void setPc(JButton pc) {
		this.pc = pc;
	}

	public JButton getPokemon1() {
		return pokemon1;
	}

	public void setPokemon1(JButton pokemon1) {
		this.pokemon1 = pokemon1;
	}

	public JButton getPokemon2() {
		return pokemon2;
	}

	public void setPokemon2(JButton pokemon2) {
		this.pokemon2 = pokemon2;
	}

	public JButton getPokemon3() {
		return pokemon3;
	}

	public void setPokemon3(JButton pokemon3) {
		this.pokemon3 = pokemon3;
	}

	public JButton getPokemon4() {
		return pokemon4;
	}

	public void setPokemon4(JButton pokemon4) {
		this.pokemon4 = pokemon4;
	}

	public JButton getPokemon5() {
		return pokemon5;
	}

	public void setPokemon5(JButton pokemon5) {
		this.pokemon5 = pokemon5;
	}

	public JButton getPokemon6() {
		return pokemon6;
	}

	public void setPokemon6(JButton pokemon6) {
		this.pokemon6 = pokemon6;
	}

	public JButton getRegister_button() {
		return register_button;
	}

	public void setRegister_button(JButton register_button) {
		this.register_button = register_button;
	}

}
