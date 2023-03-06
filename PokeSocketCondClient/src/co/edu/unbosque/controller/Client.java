package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import co.edu.unbosque.view.MainWindow;

public class Client implements ActionListener { // Toma el papel de controlador principal
	private DataInputStream in;
	private DataOutputStream out;
	private Socket sc;
	private MainWindow mw; // Ventana principal
	private String clientid; // Id unica del cliebnte
	private ClientThread thread_client; // Se almacena el hilo usado por este cliente

	public Client() {
		mw = new MainWindow();
		mw.setVisible(true);
		mw.getLog_in().addActionListener(this);
		mw.getLog_in().setActionCommand("login");

		mw.getSing_in().addActionListener(this);
		mw.getSing_in().setActionCommand("registrar");
		
		thread_client = null;

	}

	// Funcion de inicio del cliente
	public void start(String ip, int port, String clientid) {
		this.clientid = clientid;
		try {
			sc = new Socket("127.0.0.1", 9000); // Se envia la señal del cliente al servidor

			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());

			out.writeUTF(clientid); // Se envia la id del cliente al sv

			ClientThread hilo = new ClientThread(in, out, clientid); // Se crea hilo encargado de manipular las entradas y salidas
			thread_client = hilo; // Se guarda el hilo en la lista
			hilo.start(); // Comienza el hilo
			hilo.join(); // Mantiene controlado al hilo

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("login")) { // Se envia accion de logeo
			if (mw.confirmField() == true) { // Verifica si alguna casilla esta vacia
				JOptionPane.showMessageDialog(null, "Ingresa todos los datos");
			} else {
				thread_client.sendMessage(mw.loginData()); // Envia por el hilo la info al servidor
				mw.eraseData(); // Despeja las casillas
			}
		}

		if (e.getActionCommand().equals("registrar")) { // Se envia accion de registro
			thread_client.sendMessage("registrar,hola"); // Envia informacion al servidor
		}

	}

}
