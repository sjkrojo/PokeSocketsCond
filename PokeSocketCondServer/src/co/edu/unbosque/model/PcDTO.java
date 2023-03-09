package co.edu.unbosque.model;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class PcDTO implements Serializable {
	
	// declaracion de variables
	private PcDTO pc[];
	private ArrayList<Pokemon> caja1;
	private ArrayList<Pokemon> caja2;
	private ArrayList<Pokemon> caja3;
	private String id_owner;
	private String total_pokemones;
	public PcDTO(String id_owner, String total_pokemones) {
		pc = new PcDTO[3];
		caja1 = new ArrayList<Pokemon>();
		caja2 = new ArrayList<Pokemon>();
		caja3 = new ArrayList<Pokemon>();

		this.id_owner = id_owner;
		this.total_pokemones = total_pokemones;
	}

	public ArrayList<Pokemon> getCaja1() {
		return caja1;
	}

	public ArrayList<Pokemon> getCaja2() {
		return caja2;
	}

	public ArrayList<Pokemon> getCaja3() {
		return caja3;
	}

	public String getId_owner() {
		return id_owner;
	}

	public String getTotal_pokemones() {
		return total_pokemones;
	}

	public void setCaja1(ArrayList<Pokemon> caja1) {
		this.caja1 = caja1;
	}

	public void setCaja2(ArrayList<Pokemon> caja2) {
		this.caja2 = caja2;
	}

	public void setCaja3(ArrayList<Pokemon> caja3) {
		this.caja3 = caja3;
	}

	public void setId_owner(String id_owner) {
		this.id_owner = id_owner;
	}

	public void setTotal_pokemones(String total_pokemones) {
		this.total_pokemones = total_pokemones;
	}
}