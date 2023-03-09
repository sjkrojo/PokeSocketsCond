package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Arrays;

public class UserDTO implements Serializable {

	private String user;
	private String password;
	private String email;
	private String perso;
	private Pokemon[] bolsilloPokemon;

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String user, String password, String email, String perso, Pokemon[] pokemon) {
		super();
		this.user = user;
		this.password = password;
		this.email = email;
		this.perso = perso;
		this.bolsilloPokemon = pokemon;
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

	public String getPerso() {
		return perso;
	}

	public void setPerso(String perso) {
		this.perso = perso;
	}

	public Pokemon[] getBolsilloPokemon() {
		return bolsilloPokemon;
	}

	public void setBolsilloPokemon(Pokemon[] string) {
		this.bolsilloPokemon = string;
	}

	@Override // to String para mostrar la info
	public String toString() {
		String res = ("Usuario: " + this.user + " password: " + this.password + " Email: " + this.email + " Personaje: "
				+ this.perso + "\n " + "pokemones en el bolsillo: " + Arrays.toString(this.bolsilloPokemon) + "\n");
		return res;
	}
}
