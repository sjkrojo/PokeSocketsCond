package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

import co.edu.unbosque.view.MainWindow;
import co.edu.unbosque.view.PCWindow;
import co.edu.unbosque.view.RegisterPokemonWindow;
import co.edu.unbosque.view.RegisterWindow;
import co.edu.unbosque.view.TeamWindow;

public class Client implements ActionListener{
	
	private MainWindow main_window; // Ventana de inicio
	private RegisterWindow register_window; //Ventana de registro
	private TeamWindow team_window; //Ventana del equipo
	private RegisterPokemonWindow pokemon_window; //Ventana de registro de los pokemon
	private PCWindow pc_window; //Ventana de pc
	private DataInputStream in;
	private DataOutputStream out;
	private Socket sc;
	private String clientid; // Id unica del cliebnte
	private ClientThread thread_client; // Se almacena el hilo usado por este cliente
	
	public Client() {
		main_window = new MainWindow();
		register_window = new RegisterWindow();
		team_window = new TeamWindow();
		pokemon_window = new RegisterPokemonWindow();
		pc_window = new PCWindow();
		
		main_window.getLog_in().addActionListener(this);
		main_window.getLog_in().setActionCommand("login");
		
		main_window.getSing_in().addActionListener(this);
		main_window.getSing_in().setActionCommand("registrar");
		
		main_window.getExit().addActionListener(this);
		main_window.getExit().setActionCommand("salir");
		
		register_window.getRegister_button().addActionListener(this);
		register_window.getRegister_button().setActionCommand("registro");
		
		team_window.getLog_out().addActionListener(this);
		team_window.getLog_out().setActionCommand("logout");
		
		team_window.getRegister_button().addActionListener(this);
		team_window.getRegister_button().setActionCommand("registropokemon");
		
		pokemon_window.getSave_button().addActionListener(this);
		pokemon_window.getSave_button().setActionCommand("guardar");
		
		pokemon_window.getBack_button().addActionListener(this);
		pokemon_window.getBack_button().setActionCommand("volver");
		
		pc_window.getGetin_button().addActionListener(this);
		pc_window.getGetin_button().setActionCommand("ingresar");
		
		pc_window.getGetout_button().addActionListener(this);
		pc_window.getGetout_button().setActionCommand("sacar");
		
		pc_window.getFree_button().addActionListener(this);
		pc_window.getFree_button().setActionCommand("liberar");
		
		pc_window.getInfo_button().addActionListener(this);
		pc_window.getInfo_button().setActionCommand("informacion");
	}
//		public void start(String ip, int port, String clientid) {
//			this.clientid = clientid;
//			try {
//				sc = new Socket("127.0.0.1", 9000); // Se envia la señal del cliente al servidor
//
//				in = new DataInputStream(sc.getInputStream());
//				out = new DataOutputStream(sc.getOutputStream());
//
//				out.writeUTF(clientid); // Se envia la id del cliente al sv
//
//				ClientThread hilo = new ClientThread(in, out, clientid); // Se crea hilo encargado de manipular las entradas y salidas
//				thread_client = hilo; // Se guarda el hilo en la lista
//				hilo.start(); // Comienza el hilo
//				hilo.join(); // Mantiene controlado al hilo
//
//			} catch (IOException | InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
	public void start() {
		pc_window.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("login")) { // Se envia accion de logeo
			if (main_window.confirmField() == true) { // Verifica si alguna casilla esta vacia
				JOptionPane.showMessageDialog(null, "Ingresa todos los datos");
			} else {
				thread_client.sendMessage(main_window.loginData()); // Envia por el hilo la info al servidor
				main_window.eraseData(); // Despeja las casillas
			}
		}
		if (e.getActionCommand().equals("registrar")) { // Se envia accion de registro
			main_window.setVisible(false);
			register_window.setVisible(true);
		}
		if (e.getActionCommand().equals("salir")) { // Se envia accion de salida
			System.exit(0); //Cierra el programa
		}
		if(e.getActionCommand().equals("registro")) { // Se envia accion de logeo
			if (register_window.confirmField() == true  || register_window.verifyPassword() == true) { // Verifica si alguna casilla esta vacia
				JOptionPane.showMessageDialog(null, "Ingresa todos los datos o verifica la contraseña");
			} else {
				thread_client.sendMessage(register_window.loginData()); // Envia por el hilo la info al servidor
				register_window.eraseData(); // Despeja las casillas
				register_window.setVisible(false);
				team_window.setVisible(true);
			}
		}
		if(e.getActionCommand().equals("logout")) {
			team_window.setVisible(false);
			main_window.setVisible(true);
		}
		if(e.getActionCommand().equals("registropokemon")) {
			team_window.setVisible(false);
			pokemon_window.setVisible(true);
		}
		if(e.getActionCommand().equals("guardar")) {
			if (pokemon_window.confirmField() == true) { // Verifica si alguna casilla esta vacia
				JOptionPane.showMessageDialog(null, "Ingresa todos los datos");
			} else {
				thread_client.sendMessage(pokemon_window.loginData()); // Envia por el hilo la info al servidor
				pokemon_window.eraseData(); // Despeja las casillas
				pokemon_window.setVisible(false);
				team_window.setVisible(true);
			}
		}
		if(e.getActionCommand().equals("volver")) {
			pokemon_window.setVisible(false);
			team_window.setVisible(true);
		}
		if(e.getActionCommand().equals("ingresar")) {
			
		}
		if(e.getActionCommand().equals("sacar")) {
			
		}
		if(e.getActionCommand().equals("liberar")) {
			
		}
		if(e.getActionCommand().equals("informacion")) {
			
		}
		
	}
	
}
