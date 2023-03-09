package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class UserDTO implements Serializable {

	private String user;
	private String password;
	private String email;
	private String personaje;
	private PokemonDTO[] bolsilloPokemon;
	private PcDTO pc;
	private ArrayList<PokemonDTO>[] listasPokemon;

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String user, String password, String email, String personaje, PokemonDTO[] bolsilloPokemon,
			PcDTO pc) {
		super();
		this.user = user;
		this.password = password;
		this.email = email;
		this.personaje = personaje;
		this.bolsilloPokemon = bolsilloPokemon;
		this.pc = pc;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getpersonaje() {
		return personaje;
	}

	public void setpersonaje(String personaje) {
		this.personaje = personaje;
	}

	public PcDTO getPc() {
		return pc;
	}

	public ArrayList<PokemonDTO>[] getListasPokemon() {
		return listasPokemon;
	}

	public void setPc(PcDTO pc) {
		this.pc = pc;
	}

	public void setListasPokemon(ArrayList<PokemonDTO>[] listasPokemon) {
		this.listasPokemon = listasPokemon;
	}

	public PokemonDTO[] getBolsilloPokemon() {
		return bolsilloPokemon;
	}

	public void setBolsilloPokemon(PokemonDTO[] pokemon) {
		this.bolsilloPokemon = pokemon;
	}

	@Override // to String para mostrar la info
	public String toString() {
		String res = ( "\n" + "\n" + "Usuario: " + this.user + " password: " + this.password + " Email: " + this.email + " personaje: "
				+ this.personaje + "\n" + "\n" + "Pokemones en el bolsillo: " + Arrays.toString(this.bolsilloPokemon) + "\n"
				+ "\n" + "Pokemones en las cajas:" + Arrays.toString(this.listasPokemon) + "\n" );

		return res;
	}
}
