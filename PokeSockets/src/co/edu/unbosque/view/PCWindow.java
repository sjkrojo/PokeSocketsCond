package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PCWindow extends JFrame {

	private JButton getin_button, getout_button, free_button, info_button, exit_button, left_button, right_button, pokemon_box;
	private JPanel actions, team_pokemon, box_head, box;
	private JLabel box_name;
	private JScrollPane scroll_pane;
	private JTextField pokemon;
	private JTextArea pokemon1, pokemon2, pokemon3,pokemon4, pokemon5, pokemon6, box_area;

	public PCWindow() {
		setBounds(500, 0, 600, 500);
		setLayout(null);
		setResizable(false);

		actions = new JPanel(); // Panel donde están los botones que hacen acciones en la pc
		actions.setBounds(400, 0, 200, 350);
		actions.setBackground(Color.black);
		actions.setLayout(null);
		add(actions);

		getin_button = new JButton("Ingresar"); // boton ingresar
		getin_button.setBounds(50, 0, 100, 50);
		actions.add(getin_button);

		getout_button = new JButton("Sacar"); // boton sacar
		getout_button.setBounds(50, 75, 100, 50);
		actions.add(getout_button);

		free_button = new JButton("Liberar"); // boton liberar
		free_button.setBounds(50, 150, 100, 50);
		actions.add(free_button);

		info_button = new JButton("Información"); // boton información
		info_button.setBounds(50, 225, 100, 50);
		actions.add(info_button);

		exit_button = new JButton("Salir"); // boton salir
		exit_button.setBounds(50, 300, 100, 50);
		actions.add(exit_button);

		team_pokemon = new JPanel(); // Panel donde está el equipo del jugador
		team_pokemon.setBounds(0, 350, 600, 100);
		team_pokemon.setBackground(Color.black);
		team_pokemon.setLayout(null);
		add(team_pokemon);

		pokemon1 = new JTextArea("1"); // Pokemon del equipo 1
		pokemon1.setBounds(75, 25, 50, 50);
		pokemon1.setEditable(false);
		team_pokemon.add(pokemon1);

		pokemon2 = new JTextArea("2"); // Pokemon del equipo 2
		pokemon2.setBounds(150, 25, 50, 50);
		pokemon2.setEditable(false);
		team_pokemon.add(pokemon2);

		pokemon3 = new JTextArea("3"); // Pokemon del equipo 3
		pokemon3.setBounds(225, 25, 50, 50);
		pokemon3.setEditable(false);
		team_pokemon.add(pokemon3);

		pokemon4 = new JTextArea("4"); // Pokemon del equipo 4
		pokemon4.setBounds(300, 25, 50, 50);
		pokemon4.setEditable(false);
		team_pokemon.add(pokemon4);

		pokemon5 = new JTextArea("5"); // Pokemon del equipo 5
		pokemon5.setBounds(375, 25, 50, 50);
		pokemon5.setEditable(false);
		team_pokemon.add(pokemon5);

		pokemon6 = new JTextArea("6"); // Pokemon del equipo 6
		pokemon6.setBounds(450, 25, 50, 50);
		pokemon6.setEditable(false);
		team_pokemon.add(pokemon6);

		box_head = new JPanel(); // Panel donde está el nombre de la caja y las flechas para moverla
		box_head.setBounds(0, 10, 390, 100);
		box_head.setBackground(Color.black);
		box_head.setLayout(null);
		add(box_head);
		
		box_name = new JLabel("CAJA"); // Nombre caja 
		box_name.setBounds(175, 35, 150, 30);
		box_head.add(box_name);
		
		left_button = new JButton("L"); // boton para moverse para la izquierda
		left_button.setBounds(20, 25, 50, 50);
		box_head.add(left_button);
		
		right_button = new JButton("R"); // boton para moverse para la derecha
		right_button.setBounds(330, 25, 50, 50);
		box_head.add(right_button);
		
		box = new JPanel(); //CAJA
		box.setBounds(0, 115, 390, 225);
		box.setBackground(Color.black);
		box.setLayout(new BorderLayout());
		add(box);
		
		box_area = new JTextArea(); // Lista en la que salen los pokemon
		box_area.setBounds(25, 25, 200, 150);
		box_area.setEditable(false);
		box.add(box_area);
		
		scroll_pane = new JScrollPane(box_area); // Scroll para bajar en la lista de pokemon
		scroll_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll_pane.setPreferredSize(new Dimension(10, 225));
		box.add(scroll_pane);
		
		pokemon = new JTextField(); // Campo de texto para ingresar el pokemon que se va a utilizar
		pokemon.setBounds(115, 65, 150,30);
		box_head.add(pokemon);
		
		

	}

	public JButton getGetin_button() {
		return getin_button;
	}

	public void setGetin_button(JButton getin_button) {
		this.getin_button = getin_button;
	}

	public JButton getGetout_button() {
		return getout_button;
	}

	public void setGetout_button(JButton getout_button) {
		this.getout_button = getout_button;
	}

	public JButton getFree_button() {
		return free_button;
	}

	public void setFree_button(JButton free_button) {
		this.free_button = free_button;
	}

	public JButton getInfo_button() {
		return info_button;
	}

	public void setInfo_button(JButton info_button) {
		this.info_button = info_button;
	}

	public JButton getExit_button() {
		return exit_button;
	}

	public void setExit_button(JButton exit_button) {
		this.exit_button = exit_button;
	}

	public JButton getLeft_button() {
		return left_button;
	}

	public void setLeft_button(JButton left_button) {
		this.left_button = left_button;
	}

	public JButton getRight_button() {
		return right_button;
	}

	public void setRight_button(JButton right_button) {
		this.right_button = right_button;
	}

	public JButton getPokemon_box() {
		return pokemon_box;
	}

	public void setPokemon_box(JButton pokemon_box) {
		this.pokemon_box = pokemon_box;
	}

	public JPanel getActions() {
		return actions;
	}

	public void setActions(JPanel actions) {
		this.actions = actions;
	}

	public JPanel getTeam_pokemon() {
		return team_pokemon;
	}

	public void setTeam_pokemon(JPanel team_pokemon) {
		this.team_pokemon = team_pokemon;
	}

	public JPanel getBox_head() {
		return box_head;
	}

	public void setBox_head(JPanel box_head) {
		this.box_head = box_head;
	}

	public JPanel getBox() {
		return box;
	}

	public void setBox(JPanel box) {
		this.box = box;
	}

	public JLabel getBox_name() {
		return box_name;
	}

	public void setBox_name(JLabel box_name) {
		this.box_name = box_name;
	}

}
