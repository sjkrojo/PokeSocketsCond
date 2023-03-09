package co.edu.unbosque.controller;

import co.edu.unbosque.model.PcDAO;
import co.edu.unbosque.model.Pokemon;
import co.edu.unbosque.model.UserDAO;
import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.view.Consola;

public class Controlador {

	private UserDAO user; // DAO principal
	private Consola con;
	private UserDTO usr;
	private PcDAO pc;
	private Pokemon poke;

	Controlador() {
		user = new UserDAO();
		usr = new UserDTO();
		con = new Consola();
		pc = new PcDAO();
		poke = new Pokemon();
	}

	public void mainMenu() {
		mainloop: while (true) { // Se crea un ciclo para mostrar el menu
			System.out.println("1. agregar usuario" + "\n" + "2. mostrar" + "\n" + "3 agregar caja en alguna caja"
					+ "\n" + "4 mostrar info cajas" + "5 registar pokemon en el bolsillo"
					+ "6 registrar pokemon en la pc" + "7 guardar pokemon en la pc" + "\n" + "8 intercambiar pokemon");

			int select = con.readInt();
			switch (select) {
			case 1: { // Opcion 1, crea un usuario nuevo
				con.burnLine();
				con.printString("usuario"); // pide datos del usuario
				String usuario = con.readString();
				con.printString("Password");
				String password = con.readString();
				con.burnLine();
				con.printString("email");
				String email = con.readString();
				con.printString("personaje");
				String personaje = con.readString();
				con.burnLine();
				if (user.verificar(usuario, 0) == true) { // verifica que el usuario no este en uso
					con.printStringInLine("El nombre de usuario ya esta en uso. Elige otro." + "\n");
				} else if (user.verificarPerso(personaje) == false) { // verifica que el nombre sea de alguno de los 2
																		// entrenadores
					con.printStringInLine("Nombre personaje no valido." + "\n");
				} else {
					user.crearUser(usuario.toLowerCase(), password, email, personaje, null); // crea el usuario, el null
																								// es el array de
																								// pokemones
					con.printString("exito" + "\n");
				}

			}
				break;

			case 2: { // Opcion 2 para mostrar los usuarios
				con.printStringInLine(user.showAll());
				break;
			}
			case 3: { // Opcion 3 para eliminar por nombre
				con.burnLine();
				con.printString("digite en que caja quieres agregar el pokemon, del 1 al 3" + "\n");
				int i = con.readInt();
				con.burnLine();
				con.printString("name");
				String name = con.readStringLine();
				con.printString("mote");
				String mote = con.readStringLine();
				con.printString("ps");
				String ps = con.readStringLine();
				con.printString("defen");
				String defen = con.readStringLine();
				con.printString("velo");
				String velo = con.readStringLine();
				con.printString("level");
				String level = con.readStringLine();
				con.printString("attack");
				String attack = con.readStringLine();
				con.printString("Aespecial");
				String Aespecial = con.readStringLine();
				con.printString("Adefend");
				String Adefend = con.readStringLine();

				String[] miArray = new String[3]; // se crea un array para pasarlo cuando se cree la instancia de la
													// clase
				System.out.println("Ingrese los valores para el array:");
				for (int j = 0; j < miArray.length; j++) {
					System.out.print("Elemento " + (j + 1) + ": ");
					miArray[j] = con.readStringLine();
				} // Se piden los datos por teclado para poder enviarlo
				pc.agregarArrayList(i, name, mote, ps, defen, velo, level, attack, Aespecial, Adefend, miArray,
						Aespecial, Adefend);
				con.printString("exito" + "\n"); // Se manda un mensaje diciendo que se pudo agregar
				break;
			}
			case 4: { // Muestar las 3 cajas
				con.printStringInLine(pc.showCaja1());
				con.printStringInLine(pc.showCaja2());
				con.printStringInLine(pc.showCaja3());

				break;
			}
			case 5: { // Opcion 5 para registrar pokemon en el bolsillo

				con.printString("Digite su usuario:");
				con.burnLine();
				String us = con.readStringLine();
				con.printString("name");
				String name = con.readStringLine();
				con.printString("mote");
				String mote = con.readStringLine();
				con.printString("ps");
				String ps = con.readStringLine();
				con.printString("defen");
				String defen = con.readStringLine();
				con.printString("velo");
				String velo = con.readStringLine();
				con.printString("level");
				String level = con.readStringLine();
				con.printString("attack");
				String attack = con.readStringLine();
				con.printString("Aespecial");
				String Aespecial = con.readStringLine();
				con.printString("Adefend");
				String Adefend = con.readStringLine();

				String[] miArray = new String[3];
				System.out.println("Ingrese los valores para el array:");
				for (int i = 0; i < miArray.length; i++) {
					System.out.print("Elemento " + (i + 1) + ": ");
					miArray[i] = con.readStringLine();
				}
				poke = new Pokemon(name, mote, ps, defen, velo, level, attack, Aespecial, Adefend, miArray, "1", "0");
				if (user.agregarPokemon(poke) == false) {
					con.printStringInLine("Almacentamiento lleno");
					con.printString("digite en que caja quieres agregar el pokemon, del 1 al 3" + "\n");
					int i = con.readInt();
					pc.agregarArrayList(i, name, mote, ps, defen, velo, level, attack, Aespecial, Adefend, miArray, "1",
							"0");
				} else {
					user.actualizarPokemon(us);
					con.printStringInLine(poke.toStringComas());
				}
				break;
			}
			case 6: {

				// aca ira la funcion de intercambio

				break;
			}
			case 7: { // Opcion 7 para eliminar
				con.printStringInLine("ingrese numero a eliminar de la lista");
				int n = con.readInt();
				user.eliminarUsuario(n);
			}
			case 8:
				con.printString("asdt");
				break mainloop;
			default: // Mensaje para decir que escogio una opcion invalida
				con.printString("mal");
				break;
			}
		}
	}
}
