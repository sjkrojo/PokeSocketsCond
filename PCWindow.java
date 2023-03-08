package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PCWindow extends JFrame {

	private JButton getin_button, getout_button, free_button, info_button, exit_button, pokemon1, pokemon2, pokemon3,
			pokemon4, pokemon5, pokemon6, left_button, right_button, pokemon_box;
	private JPanel actions, team_pokemon, box_head, box;
	private JLabel box_name;

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
	
	public JPanel crearPanel(List<String> elementos) {
        box = new JPanel(new GridLayout(elementos.size(), 1));
        
        for (String elemento : elementos) {
            pokemon_box = new JButton(elemento);
            box.add(pokemon_box);
        }
        
        return box;
    }

}
