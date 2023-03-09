package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistance.FileController;
import co.edu.unbosque.model.persistance.FileHandler;

public class UserDAO {
	// declaracion de atributos a usar
	private ArrayList<UserDTO> lista;
	private ArrayList<String> usuario, contras;
	private Pokemon[] pokemon;
	private FileController fc;
	private FileHandler fh;
	private UserDTO user;

	public UserDAO() {

		lista = new ArrayList<UserDTO>();
		usuario = new ArrayList<String>();
		contras = new ArrayList<String>();
		user = new UserDTO();
		pokemon = new Pokemon[6];
		fc = new FileController();
		fc.initEntrada("userserializable"); // archivo serializable

		for (int x = 0; x < lista.size(); x++) {
			usuario.add(lista.get(x).getUser());
			contras.add(lista.get(x).getPassword());
		}
		loadSerializable(); // se carga el archivo
		fc.cerrarLector();

	}

	public void loadSerializable() { // Funcion para cargar archivo serializable
		Object aux = fc.leerSerializado();
		if (aux != null) {
			lista = (ArrayList<UserDTO>) aux;
		}
	}

	public UserDTO getUser() { // tomar Usuarios
		return user;
	}

	public void crearUser(String user, String password, String email, String perso, Pokemon[] poke) {
		// crear usuario nuevo y escribir en el archivo
		UserDTO a = new UserDTO(user, password, email, perso, poke);
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

	public boolean verificar(String input, int elec) { // Metodo se uso para verificar si el nombre estaba o no siendo
														// utlizada

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

	public boolean agregarPokemon(Pokemon pokemons) { // agregarPokemon
		for (int i = 0; i < pokemon.length; i++) {
			if (pokemon[i] == null) {
				pokemon[i] = pokemons;
				return true;
			}
		}
		return false;
	}  
	
	public String showAll2() { // mostrar los datos
		String res = "";
		for (UserDTO s : lista) {
			res += s.toString() + "\n";
		}
		return res;
	}

	public void actualizarPokemon(String usuario) { // actualizar los datos del Pokemon
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getUser().equals(usuario)) {
				lista.get(i).setBolsilloPokemon(this.pokemon);
			}
		}
		fc.initSalida("userserializable");
		fc.escribirSerializado(lista);
		fc.cerrarSerializado();
	}

	public boolean verificarPerso(String perso) { // // Metodo se uso para verificar si el nombre estaba o no siendo
		// utlizada
		boolean estado = false;
		if (perso.equalsIgnoreCase("ash") || perso.equalsIgnoreCase("red")) {
			estado = true;
		} else {
			estado = false;
		}
		return estado;
	}

	public UserDTO getuser() {
		return user;
	}

	public void setuser(UserDTO user) {
		this.user = user;
	}

	public int cantidadDatos() {
		return lista.size();
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

	public Pokemon[] getPokemon() {
		return pokemon;
	}

	public FileController getFc() {
		return fc;
	}

	public FileHandler getFh() {
		return fh;
	}

	public void setUsuario(ArrayList<String> usuario) {
		this.usuario = usuario;
	}

	public void setContras(ArrayList<String> contras) {
		this.contras = contras;
	}

	public void setPokemon(Pokemon[] pokemon) {
		this.pokemon = pokemon;
	}

	public void setFc(FileController fc) {
		this.fc = fc;
	}

	public void setFh(FileHandler fh) {
		this.fh = fh;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public void setLista(ArrayList<UserDTO> lista) {
		this.lista = lista;
	}
}
