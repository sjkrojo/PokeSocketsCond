package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistance.FileController;

public class OperationDAO {

	// declaracion de atributos a usar
	private ArrayList<UserDTO> lista;
	private ArrayList<String> usuario, contras;
	private UserDTO user;
	private PcDTO pc;
	private PokemonDTO[] pokemon;
	private FileController fc;

	public OperationDAO() {

		lista = new ArrayList<UserDTO>();
		usuario = new ArrayList<String>();
		contras = new ArrayList<String>();
		user = new UserDTO();
		lista.add(user);
		pc = new PcDTO("usuario", "id");
		pokemon = new PokemonDTO[6];
		fc = new FileController();
		fc.initEntrada("userserializable");
		loadSerializable();
		for (int x = 0; x < lista.size(); x++) {
			usuario.add(lista.get(x).getUser());
			contras.add(lista.get(x).getPassword());
			System.out.println(contras.get(x) + " 2");
			System.out.println(usuario.get(x) + " 1");
		}
		fc.cerrarLector();

	}

	public void loadSerializable() { // cargar el serializable
		Object aux = fc.leerSerializado();
		lista = (ArrayList<UserDTO>) aux;
	}

	public UserDTO getUser() { // tomar Usuarios
		return user;
	}

	// crear usuario nuevo y escribir en el archivo

	public void crearUser(String user, String password, String email, String perso, PokemonDTO[] poke) {
		UserDTO a = new UserDTO(user, password, email, perso, poke, pc);
		lista.add(a);

		this.usuario.add(a.getUser());
		this.contras.add(a.getPassword());

		fc.initSalida("userserializable");
		fc.escribirSerializado(lista);
		fc.cerrarSerializado();
	}

	// return UserDTO
	public String showAll() { // mostrar los datos
		String res = "";
		for (UserDTO s : lista) {
			res += s.toString() + "\n";
		}
		return res;
	}

	// Metodo se uso para verificar si el nombre esta o no en uso
	public boolean verificarNombre(String input, int elec) {
		boolean estado = false;
		if (elec == 0) {
			estado = usuario.contains(input);
		}

		return estado;
	}

	public boolean verificarIngreso(String input, int elec) { // para rectificar que el usuario este registrado

		boolean estado = false;
		if (elec == 0) {
			estado = usuario.contains(input);
		}

		if (elec == 1) {
			estado = contras.contains(input);
		}

		return estado;
	}

	public void eliminarUsuario(int x) { // eliminar usuario
		lista.remove(x);
		fc.initSalida("userserializable");
		fc.escribirSerializado(lista);
		fc.cerrarSerializado();
	}

	public boolean agregarPokemon(PokemonDTO pokemons) { // agregarPokemon al bolsillo
		boolean state = false;
		for (int i = 0; i < pokemon.length; i++) {
			if (pokemon[i] == null) {
				pokemon[i] = pokemons;
				state = true;
			}

		}
		return state;
	}

	public void cargarPokemon(String usuario) { // Carga las cajas y los bolsillo de los usuarios
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getUser().equals(usuario)) {
				lista.get(i).setBolsilloPokemon(pokemon);
				lista.get(i).setListasPokemon(pc.obtenerCajasPokemon());
			}

		}
		fc.initSalida("userserializable");
		fc.escribirSerializado(lista);
		fc.cerrarSerializado();
	}

	public boolean verificarPersonaje(String perso) { // // Metodo se uso para verificar si escogio el debido nombre
		// utlizada
		boolean estado = false;
		if (perso.equalsIgnoreCase("src/ash.png") || perso.equalsIgnoreCase("src/red.png")) {
			estado = true;
		} else {
			estado = false;
		}
		return estado;
	}

	public String showPokemonPocket(String us) {
		String message = "";
		for (int y = 0; y < lista.size(); y++) {
			if (lista.get(y).getUser().equals(us)) {
				for (int z = 0; z < lista.get(y).getBolsilloPokemon().length; z++) {
					message += lista.get(y).getBolsilloPokemon()[z].toString() + ";";
				}
			}
		}

		if (message.equals("")) {
			message = "Bolsillo libre;Bolsillo libre;Bolsillo libre;Bolsillo libre;Bolsillo libre;Bolsillo libre;";
		}

		return message;
	}

	// metodo para llenar alguna de las 3 cajas
	public void agregarArrayList(int i, String usuario, PokemonDTO a) {

		for (int j = 0; j < lista.size(); j++) {
			if (lista.get(j).getUser().equals(usuario)) {
				if (i == 1) {
					pc.getCaja1().add(a);
				} else if (i == 2) {
					pc.getCaja2().add(a);
				} else if (i == 3) {
					pc.getCaja3().add(a);
				}
			}
		}
	}

	// funcion para mostrar la caja 1
	public String showCaja1() {
		String res = "Caja 1: " + "\n";
		for (PokemonDTO s : pc.getCaja1()) {
			res += s.toString() + "\n";
		}
		return res;
	}
	// funcion para mostrar la caja 2

	public String showCaja2() {
		String res = "Caja 2: " + "\n";
		for (PokemonDTO s : pc.getCaja2()) {
			res += s.toString() + "\n";
		}
		return res;
	}
	// funcion para mostrar la caja 3

	public String showCaja3() {
		String res = "Caja 3: " + "\n";
		for (PokemonDTO s : pc.getCaja3()) {
			res += s.toString() + "\n";
		}
		return res;
	}

	public ArrayList<UserDTO> getLista() {
		return lista;
	}

	public ArrayList<String> getUsuario() {
		return usuario;
	}

	public ArrayList<String> getContras() {
		return contras;
	}

	public PokemonDTO[] getPokemon() {
		return pokemon;
	}

	public FileController getFc() {
		return fc;
	}

	public PcDTO getPc() {
		return pc;
	}

	public void setLista(ArrayList<UserDTO> lista) {
		this.lista = lista;
	}

	public void setUsuario(ArrayList<String> usuario) {
		this.usuario = usuario;
	}

	public void setContras(ArrayList<String> contras) {
		this.contras = contras;
	}

	public void setPokemon(PokemonDTO[] pokemon) {
		this.pokemon = pokemon;
	}

	public void setFc(FileController fc) {
		this.fc = fc;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public void setPc(PcDTO pc) {
		this.pc = pc;
	}

}
