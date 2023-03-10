package co.edu.unbosque.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import co.edu.unbosque.model.OperationDAO;
import co.edu.unbosque.model.PokemonDTO;
import co.edu.unbosque.view.Consola;

public class Server {
	private ServerSocket server; // Variable encargada de inicializar el servidor con su puerto
	private DataInputStream in;
	private DataOutputStream out;
	private Socket sc;
	private ArrayList<ServerThread> sockets; // Arraylist donde se guardan todas las conexiones
	private OperationDAO op; // DAO principal

	public Server() {
		sockets = new ArrayList<ServerThread>();
		op = new OperationDAO();
	}

	public void start() {
		try {
			server = new ServerSocket(9000); // Abre el socket y el puerto

			System.out.println("Servidor iniciado"); // Informa por consola

			while (true) { // While encargado de crear hilos segun los clientes que reciba
				sc = server.accept(); // Aguarda la llegada de un cliente

				in = new DataInputStream(sc.getInputStream()); // Inicializa las variables de entrada y salidad
				out = new DataOutputStream(sc.getOutputStream());

				String clienteid = in.readUTF(); // Guarda la id del cliente que se ha conectado

				ServerThread hilo = new ServerThread(in, out, clienteid, op); // Crea un nuevo hilo encargado de manejar a
																			// un cliente en especifico
				sockets.add(hilo); // Lo añade a la lista de hilos del servidor
				System.out.println(sockets.size()); // Verifica si la lista se esta llenando
				hilo.start(); // Inicia el hilo

				System.out.println("Conexion creada con el cliente " + clienteid); // Informa por el sv de la conexion
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
