package co.edu.unbosque.model;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class PcDTO implements Serializable {

	// declaracion de variables
	private ArrayList<PokemonDTO>[] listasPokemon;
	private ArrayList<PokemonDTO> caja1;
	private ArrayList<PokemonDTO> caja2;
	private ArrayList<PokemonDTO> caja3;
	private String id_owner;
	private String total_pokemones;

	public PcDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public PcDTO(String id_owner, String total_pokemones) {
		caja1 = new ArrayList<PokemonDTO>();
		caja2 = new ArrayList<PokemonDTO>();
		caja3 = new ArrayList<PokemonDTO>();

		this.id_owner = id_owner;
		this.total_pokemones = total_pokemones;
	}
	
	public ArrayList<PokemonDTO>[] obtenerCajasPokemon() {
		listasPokemon = new ArrayList[3];
		listasPokemon[0] = getCaja1();
		listasPokemon[1] = getCaja2();
		listasPokemon[2] = getCaja3();
		return listasPokemon;
	}

	
	
	public ArrayList<PokemonDTO> getCaja1() {
		return caja1;
	}

	public ArrayList<PokemonDTO> getCaja2() {
		return caja2;
	}

	public ArrayList<PokemonDTO> getCaja3() {
		return caja3;
	}

	public String getId_owner() {
		return id_owner;
	}

	public String getTotal_pokemones() {
		return total_pokemones;
	}

	public void setCaja1(ArrayList<PokemonDTO> caja1) {
		this.caja1 = caja1;
	}

	public void setCaja2(ArrayList<PokemonDTO> caja2) {
		this.caja2 = caja2;
	}

	public void setCaja3(ArrayList<PokemonDTO> caja3) {
		this.caja3 = caja3;
	}

	public void setId_owner(String id_owner) {
		this.id_owner = id_owner;
	}

	public void setTotal_pokemones(String total_pokemones) {
		this.total_pokemones = total_pokemones;
	}
	
	   @Override
	    public String toString() {
	        return "PcDTO{" +
	                "caja1=" + caja1 +
	                ", caja2=" + caja2 +
	                ", caja3=" + caja3 +
	                ", id_owner='" + id_owner + '\'' +
	                ", total_pokemones='" + total_pokemones + '\'' +
	                '}';
	    }
	}

