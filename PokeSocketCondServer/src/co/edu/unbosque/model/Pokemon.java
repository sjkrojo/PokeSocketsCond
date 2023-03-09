package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Arrays;

public class Pokemon implements Serializable {
	// atributos Pokemon
	private String name;
	private String mote;
	private String ps;
	private String defen;
	private String velo;
	private String level;
	private String attack;
	private String ASpecial;
	private String ADefen;
	private String[] attacks;
	private String id_owner;
	private String id_poke;

	 // constructor

	public Pokemon() {
		// TODO Auto-generated constructor stub
	}
	public Pokemon(String name, String mote, String ps, String defen, String velo, String level, String attack,
			String aSpecial, String aDefen, String[] attacks, String id_owner, String id_poke) {
		super();
		this.name = name;
		this.mote = mote;
		this.ps = ps;
		this.defen = defen;
		this.velo = velo;
		this.level = level;
		this.attack = attack;
		ASpecial = aSpecial;
		ADefen = aDefen;
		this.attacks = attacks;
		this.id_owner = id_owner;
		this.id_poke = id_poke;
	}

	public String getName() { // getters and setters
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMote() {
		return mote;
	}

	public void setMote(String mote) {
		this.mote = mote;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	public String getDefen() {
		return defen;
	}

	public void setDefen(String defen) {
		this.defen = defen;
	}

	public String getVelo() {
		return velo;
	}

	public void setVelo(String velo) {
		this.velo = velo;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getAttack() {
		return attack;
	}

	public void setAttack(String attack) {
		this.attack = attack;
	}

	public String getASpecial() {
		return ASpecial;
	}

	public void setASpecial(String aSpecial) {
		ASpecial = aSpecial;
	}

	public String getADefen() {
		return ADefen;
	}

	public void setADefen(String aDefen) {
		ADefen = aDefen;
	}

	public String[] getAttacks() {
		return attacks;
	}

	public void setAttacks(String[] attacks) {
		this.attacks = attacks;
	}

	public String getId_owner() {
		return id_owner;
	}

	public String getId_poke() {
		return id_poke;
	}

	public void setId_owner(String id_owner) {
		this.id_owner = id_owner;
	}

	public void setId_poke(String id_poke) {
		this.id_poke = id_poke;
	}

	@Override // ToString para mostrar la info 
	public String toString() { // to String
		String res = ("Name: " + this.name + " Mote: " + this.mote + " ps: " + this.ps + " defen : " + this.defen
				+ " velo :" + this.velo + " level :" + this.level + " attack : " + this.attack + " aEspecial: "
				+ this.ASpecial + " Adefend: " + this.ADefen + " List of attacks: " + Arrays.toString(this.attacks));

		return res;
	}
	public String toStringComas() {
		String res = this.name + "," + this.mote + "," + this.ps + "," + this.defen
				+ "," + this.velo + ",:" + this.level + "," + this.attack + ","
				+ this.ASpecial + "," + this.ADefen + "," + Arrays.toString(this.attacks);
				return res;
	}

}
