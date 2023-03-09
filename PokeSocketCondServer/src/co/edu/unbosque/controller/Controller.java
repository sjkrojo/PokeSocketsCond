package co.edu.unbosque.controller;

import co.edu.unbosque.model.OperationDAO;
import co.edu.unbosque.model.PokemonDTO;
import co.edu.unbosque.view.Consola;

public class Controller {

	private OperationDAO op; // DAO principal
	private Consola con;
	private PokemonDTO poke;

	Controller() {
		op = new OperationDAO();
		con = new Consola();
		poke = new PokemonDTO();
	}

	public void mainMenu() {
		try {
			mainloop: while (true) { // Se crea un ciclo para mostrar el menu
				System.out.println("1. agregar usuario" + "\n" + "2. mostrar" + "\n"
						+ "3 agregar Pokemon en alguna caja" + "\n" + "4 mostrar info cajas" + "\n"
						+ "5 registar pokemon en el bolsillo" + "\n" + "6 Eliminar usuario" + "7 Iniciar sesion" + "\n"
						+ "8 Salir" + "\n");

				int select = con.readInt();
				switch (select) {
				case 1: { // Oopion 1, crea un usuario nuevo
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
					PokemonDTO[] lista = (null);
					con.burnLine();
					if (op.verificarNombre(usuario.toLowerCase(), 0) == true) { // verifica que el usuario no este en uso
																				// uso
						con.printStringInLine("El nombre de usuario ya esta en uso. Elige otro." + "\n");
					} else if (op.verificarPersonaje(personaje) == false) { // verifica que el nombre sea de alguno de
																			// los
																			// 2
																			// entrenadores
						con.printStringInLine("Nombre personaje no valido." + "\n");
					} else {
						op.crearUser(usuario.toLowerCase(), password, email, personaje, lista); // crea el usuario
						
						con.printString("exito" + "\n");
					}

				}
					break;

				case 2: { // Opcion 2 para mostrar los usuarios
					con.printStringInLine(op.showAll());
					break;
				}
				case 3: { // Opcion 3 Agregar a alguna Caja
					con.burnLine();

					con.printString("digite en que caja quieres agregar el pokemon, del 1 al 3" + "\n");
					int i = con.readInt();
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
					for (int j = 0; j < miArray.length; j++) {
						System.out.print("Elemento " + (j + 1) + ": ");
						miArray[j] = con.readStringLine();
					}
					op.agregarArrayList(i, us, name, mote, ps, defen, velo, level, attack, Aespecial, Adefend, miArray,
							Aespecial, Adefend);
					op.CargarPokemon(us);
					con.printString("exito" + "\n"); // Se manda un mensaje diciendo que se pudo agregar
					break;
				}
				case 4: { // muestra las 4 cajas
					con.printStringInLine(op.showCaja1());
					con.printStringInLine(op.showCaja2());
					con.printStringInLine(op.showCaja3());

					break;
				}
				case 5: { // Oopion 5 para registrar pokemon en el bolsillo
					con.burnLine();
					con.printString("Digite su usuario:"); // pide datos
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

					String[] miArray = new String[3]; // array para poder ingresar los poderes
					System.out.println("Ingrese los valores para el array:");
					for (int i = 0; i < miArray.length; i++) {
						System.out.print("Elemento " + (i + 1) + ": ");
						miArray[i] = con.readStringLine();
					} // se crea pokemon
					poke = new PokemonDTO(name, mote, ps, defen, velo, level, attack, Aespecial, Adefend, miArray, " ",
							"0");
					if (op.agregarPokemon(poke) == false) { // si el bolsillo esta lleno
						con.printStringInLine("Almacentamiento lleno");
						con.printString("digite en que caja quieres agregar el pokemon, del 1 al 3" + "\n"); // se almacenara en alguna caja
						int i = con.readInt();
						op.agregarArrayList(i, us, name, mote, ps, defen, velo, level, attack, Aespecial, Adefend,
								miArray, " ", "0"); 
						op.CargarPokemon(us); // se actualizan los datos 
					} else {
						op.CargarPokemon(us);
					}
					break;
				}
				case 6: { // Eliminar algun usuario de la lista
					con.printStringInLine("ingrese numero a eliminar de la lista");
					int n = con.readInt();
					op.eliminarUsuario(n);
					break;
				}
				case 7: {  // Opcion 7 iniciar sesion, verifica que sea correcto el usuario y la contraseña
					con.printString("Digite nombre usuario"); 			
					String usuario = con.readString();
					con.printString("Digite Password");
					String password = con.readString();
					con.burnLine();
					if (op.verificarIngreso(usuario, 0) == true && op.verificarIngreso(password, 1) == true) {
						con.printStringInLine("bienvenido: " + usuario);
					} else {
						con.printStringInLine("No encontrado");
					}
					break;
				}

				case 8: { // Salir
					con.printString("Hasta luego");
					break mainloop;
				}
				default: // Mensaje para decir que escogio una oopion invalida
					con.printString("mal eleccion");
					break;
				}
			}
		} catch (Exception e) {
			con.printString("Ingresa solo numeros");
		}
	}
}
