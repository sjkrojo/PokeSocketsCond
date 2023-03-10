package co.edu.unbosque.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import co.edu.unbosque.model.OperationDAO;
import co.edu.unbosque.model.PokemonDTO;

public class ServerThread extends Thread {

	private DataInputStream in;
	private DataOutputStream out;
	private String clienteid; // Guarda la id del cliente que se ha conectado
	private String[] data; // Almace los datos enviados
	private String answer; // Guarda las respuestas
	private OperationDAO op; // DAO principal
	private String actual_user;

	public ServerThread() {

	}

	public ServerThread(DataInputStream in, DataOutputStream out, String clienteid, OperationDAO op) {
		super();
		this.in = in;
		this.out = out;
		this.clienteid = clienteid;
		this.answer = "";
		this.op = op;
	}

	public void run() {
		try {
			while (true) { // While encargado de que el servidor siempre este buscando entradas nuevas

				String message = in.readUTF(); // Lee e imprime el mensaje del cliente
				System.out.println(message);
				if (!message.equals("")) { // En caso de que el mensaje no este vacio revisa las siguientes
											// condicionales
					data = message.split(","); // Convierte los datos enviados en un array para ser utilizados

					System.out.println("Dato guardado " + data[0]); // Verifica la accion que se debe hacer

					if (data[0].equals("login")) { // Si se logea realiza esto
						if (op.verificarIngreso(data[1], 0) == true && op.verificarIngreso(data[2], 1) == true) {
							System.out.println("Pasa el true");
							answer = "truelogin";
							out.writeUTF(answer); // Envia el mensaje
							actual_user = data[1];
						} else {
							System.out.println("Pasa el true");
							answer = "falselogin";
							out.writeUTF(answer);
						}
					}

					if (data[0].equals("register")) { // Si se registra realiza esto
						if (op.verificarNombre(data[1], 0) == true) { // verifica que el usuario no este
																		// en uso
							answer = "inuseuser";
							out.writeUTF(answer);
						} else if (op.verificarPersonaje(data[4]) == false) { // verifica que el nombre sea de alguno de
																				// los 2 entrenadores
							answer = "invalidcharacter";
							out.writeUTF(answer);
						} else {
							op.crearUser(data[1], data[2], data[3], data[4], null); // crea el usuario
							answer = "usercreated";
							out.writeUTF(answer);
						}
					}

					if (data[0].equals("registerpoke")) { // Si se registra un nuevo pokemon realiza esto

						String[] miArray = new String[4];
						miArray[0] = data[10];
						miArray[1] = data[11];
						miArray[2] = data[12];
						miArray[3] = data[13];

						PokemonDTO poke = new PokemonDTO(data[1], data[2], data[3], data[5], data[8], data[9], data[4],
								data[6], data[7], miArray, data[14], "0");

						if (op.agregarPokemon(poke) == false) { // si el bolsillo esta lleno
							int i = 1;
							op.agregarArrayList(i, actual_user, poke);
							op.cargarPokemon(actual_user); // se actualizan los datos
						} else {
							op.cargarPokemon(actual_user);
						}

						answer = "Has registrado un pokemon";
						out.writeUTF(answer); // Envia el mensaje
					}

					if (data[0].equals("bolsillos")) {
						answer = op.showPokemonPocket(data[0]);
						out.writeUTF(answer); // Envia el mensaje
					}

					System.out.println("Mensaje que deberia ser enviado: " + answer); // Verifica el mensaje a enviar
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
