package co.edu.unbosque.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ServerThread extends Thread {

	private DataInputStream in;
	private DataOutputStream out;
	private String clienteid; // Guarda la id del cliente que se ha conectado
	private String[] data; // Almace los datos enviados
	private String answer; // Guarda las respuestas

	public ServerThread() {

	}

	public ServerThread(DataInputStream in, DataOutputStream out, String clienteid) {
		super();
		this.in = in;
		this.out = out;
		this.clienteid = clienteid;
		this.answer = "";
	}

	public void run() {
		try {
			while (true) { // While encargado de que el servidor siempre este buscando entradas nuevas

				String message = in.readUTF(); // Lee e imprime el mensaje del cliente
				System.out.println(message);

				if (!message.equals("")) { // En caso de que el mensaje no este vacio revisa las siguientes condicionales
					data = message.split(","); // Convierte los datos enviados en un array para ser utilizados

					System.out.println("Dato guardado " + data[0]); // Verifica la accion que se debe hacer

					if (data[0].equals("login")) { // Si se logea realiza esto
						answer = "Has iniciado sesion con exito";

					}else if (data[0].equals("registrar")) { // Si se registra realiza esto
						System.out.println("Pasa el true");
						answer = "Te has registrado con exito";
					}
					
					System.out.println("Mensaje que deberia ser enviado: " + answer); // Verifica el mensaje a enviar
					out.writeUTF(answer); // Envia el mensaje
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
