package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

import javax.swing.JOptionPane;

import co.edu.unbosque.view.MainWindow;
import co.edu.unbosque.view.PCWindow;
import co.edu.unbosque.view.RegisterPokemonWindow;
import co.edu.unbosque.view.RegisterWindow;
import co.edu.unbosque.view.TeamWindow;

public class Client extends Thread implements ActionListener {

	private MainWindow main_window; // Ventana de inicio
	private RegisterWindow register_window; // Ventana de registro
	private TeamWindow team_window; // Ventana del equipo
	private RegisterPokemonWindow pokemon_window; // Ventana de registro de los pokemon
	private DataInputStream in;
	private PCWindow pc;
	private DataOutputStream out;
	private Socket sc;
	private String clientid; // Id unica del cliebnte
	private String imagen;
	private String message;
	private String[] bolsillos;

	public Client() {
		imagen = "";
		main_window = new MainWindow();
		register_window = new RegisterWindow();
		team_window = new TeamWindow();
		pokemon_window = new RegisterPokemonWindow();
		pc = new PCWindow();

		main_window.getLog_in().addActionListener(this);
		main_window.getLog_in().setActionCommand("login");

		team_window.getPokemon1().addActionListener(this);
		team_window.getPokemon1().setActionCommand("1bolsillo");

		team_window.getPokemon2().addActionListener(this);
		team_window.getPokemon2().setActionCommand("2bolsillo");

		team_window.getPokemon3().addActionListener(this);
		team_window.getPokemon3().setActionCommand("3bolsillo");

		team_window.getPokemon4().addActionListener(this);
		team_window.getPokemon4().setActionCommand("4bolsillo");

		team_window.getPokemon5().addActionListener(this);
		team_window.getPokemon5().setActionCommand("5bolsillo");

		team_window.getPokemon6().addActionListener(this);
		team_window.getPokemon6().setActionCommand("6bolsillo");

		main_window.getSing_in().addActionListener(this);
		main_window.getSing_in().setActionCommand("registrar");

		main_window.getExit().addActionListener(this);
		main_window.getExit().setActionCommand("salir");

		register_window.getRegister_button().addActionListener(this);
		register_window.getRegister_button().setActionCommand("registro");

		register_window.getAsh().addActionListener(this);
		register_window.getRed().addActionListener(this);

		team_window.getLog_out().addActionListener(this);
		team_window.getLog_out().setActionCommand("logout");

		pc.getGetin_button().addActionListener(this);
		pc.getGetin_button().setActionCommand("ingresar");

		pc.getGetout_button().addActionListener(this);
		pc.getGetout_button().setActionCommand("sacar");

		pc.getFree_button().addActionListener(this);
		pc.getFree_button().setActionCommand("liberar");

		pc.getInfo_button().addActionListener(this);
		pc.getInfo_button().setActionCommand("informacion");

		pokemon_window.getSave_button().addActionListener(this);
		pokemon_window.getSave_button().setActionCommand("savepokemon");

		pokemon_window.getBack_button().addActionListener(this);
		pokemon_window.getBack_button().setActionCommand("exitregisterpoke");

		team_window.getPc().addActionListener(this);
		team_window.getPc().setActionCommand("pc");

		pc.getExit_button().addActionListener(this);
		pc.getExit_button().setActionCommand("volver");

		team_window.getRegister_button().addActionListener(this);
		team_window.getRegister_button().setActionCommand("registropokemon");
		main_window.setVisible(true);
	}

	public void run(String ip, int port) {
		Random r = new Random();
		this.clientid = r.nextInt() + "";
		try {
			sc = new Socket(ip, port); // Se envia la señal del cliente al servidor

			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());

			out.writeUTF(clientid);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("login")) { // Se envia accion de logeo
			if (main_window.confirmField() == true) { // Verifica si alguna casilla esta vacia
				JOptionPane.showMessageDialog(null, "Ingresa todos los datos");
			} else {
				sendMessage(main_window.loginData()); // Envia por el hilo la info al servidor
				try {
					this.message = in.readUTF();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				main_window.eraseData(); // Despeja las casillas
				if (message.equals("truelogin")) {
					JOptionPane.showMessageDialog(null, "Logeo exitoso");
					main_window.setVisible(false);
					team_window.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		}
		if (e.getActionCommand().equals("registrar")) { // Se envia accion para pasar a la ventana registro
			main_window.setVisible(false);
			register_window.setVisible(true);
		}
		if (e.getActionCommand().equals("salir")) { // Se envia accion de salida
			System.exit(0); // Cierra el programa
		}
		if (e.getActionCommand().equals("registro")) { // Se envia accion de logeo
			if (register_window.confirmField() == true || register_window.verifyPassword() == true) { // Verifica si
																										// alguna
																										// casilla esta
																										// vacia
				JOptionPane.showMessageDialog(null, "Ingresa todos los datos o verifica la contraseña");
			} else {
				sendMessage(register_window.registerData() + "," + imagen); // Envia por el hilo la info
																			// del registro de un nuevo
				try {
					this.message = in.readUTF();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (message.equals("inuseuser")) {
					JOptionPane.showMessageDialog(null, "ERROR: Usuario en uso");
					register_window.eraseData(); // Despeja las casillas

				} else if (message.equals("invalidcharacter")) {
					JOptionPane.showMessageDialog(null, "ERROR: Personaje invalido!");
					register_window.eraseData(); // Despeja las casillas
				} else if (message.equals("usercreated")) {
					JOptionPane.showMessageDialog(null, "¡Cliente creado!");
					register_window.eraseData(); // Despeja las casillas
					register_window.setVisible(false);
					team_window.setVisible(true);
				}
			}
		}

		// Botones equipo principal

		if (e.getActionCommand().equals("1bolsillo")) {
			JOptionPane.showMessageDialog(null, bolsillos[0]);

		}

		if (e.getActionCommand().equals("2bolsillo")) {
			JOptionPane.showMessageDialog(null, bolsillos[1]);

		}

		if (e.getActionCommand().equals("3bolsillo")) {
			JOptionPane.showMessageDialog(null, bolsillos[2]);

		}

		if (e.getActionCommand().equals("4bolsillo")) {
			JOptionPane.showMessageDialog(null, bolsillos[3]);

		}

		if (e.getActionCommand().equals("5bolsillo")) {
			JOptionPane.showMessageDialog(null, bolsillos[4]);

		}

		if (e.getActionCommand().equals("6bolsillo")) {
			JOptionPane.showMessageDialog(null, bolsillos[5]);

		}

		// Eleccion Ash/Red
		if (register_window.getAsh().isSelected()) {
			this.imagen = "src/ash.png";
		}

		if (register_window.getRed().isSelected()) {
			this.imagen = "src/red.png";
		}
		/////

		if (e.getActionCommand().equals("logout")) {
			team_window.setVisible(false);
			main_window.setVisible(true);
		}

		// PC
		if (e.getActionCommand().equals("pc")) {
			team_window.setVisible(false);
			pc.setVisible(true);
		}

		if (e.getActionCommand().equals("ingresar")) {

		}
		if (e.getActionCommand().equals("sacar")) {

		}
		if (e.getActionCommand().equals("liberar")) {

		}
		if (e.getActionCommand().equals("informacion")) {

		}

		if (e.getActionCommand().equals("volver")) {
			pc.setVisible(false);
			team_window.setVisible(true);
		}

		// Registro pokemon ventana

		if (e.getActionCommand().equals("registropokemon")) {
			team_window.setVisible(false);
			pokemon_window.setVisible(true);
		}

		// Envia pokemon nuevo a la PC
		if (e.getActionCommand().equals("savepokemon")) {
			if (pokemon_window.confirmField() == true) {
				JOptionPane.showMessageDialog(null, "ERROR: Ingresa todos los datos");
			} else {
				sendMessage(pokemon_window.registerPokeInfo()+ ","+clientid);
				pokemon_window.setVisible(false);
				team_window.setVisible(true);
				sendMessage("bolsillos" + "," + clientid);
				try {
					this.message = in.readUTF();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				bolsillos = message.split(";");
				
			}
			pokemon_window.eraseData();

		}

		if (e.getActionCommand().equals("exitregisterpoke")) {
			pokemon_window.setVisible(false);
			team_window.setVisible(true);
		}

		sendMessage("bolsillos" + "," + clientid);
		try {
			this.message = in.readUTF();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		bolsillos = message.split(";");
		
	}

	public void sendMessage(String message) { // Envia un mensaje al servidor
		try {
			out.writeUTF(message);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
