package co.edu.unbosque.model;

public class PcDAO {

	private PcDTO pc;
	private PcDTO[] array;

	public PcDAO() {
		pc = new PcDTO(null, null);
		array = new PcDTO[3];
		

	}
	// metodo para agregar pokemon a alguna caja, de la 1 a la 3
	public void agregarArrayList(int i, String name, String mote, String ps, String defen, String velo, String level, String attack,
			String aSpecial, String aDefen, String[] attacks, String id_owner, String id_poke) {
		if (i == 1) {
			Pokemon a = new Pokemon(name, mote, ps, defen, velo, level, attack, aSpecial, aDefen,attacks, id_owner, id_poke);
			pc.getCaja1().add(a);
		} else if (i == 2) {
			Pokemon a = new Pokemon(name, mote, ps, defen, velo, level, attack, aSpecial, aDefen,attacks, id_owner, id_poke);
			pc.getCaja2().add(a);
		} else if (i == 3) {
			Pokemon a = new Pokemon(name, mote, ps, defen, velo, level, attack, aSpecial, aDefen,attacks, id_owner, id_poke);
			pc.getCaja3().add(a);
		}
	}
	// funcion para mostrar la caja 1
	public String showCaja1() {
		String res = "Caja 1: " + "\n";
		for (Pokemon s : pc.getCaja1()) {
			res += s.toString() + "\n";
		}
		return res;
	}
	// funcion para mostrar la caja 2

	public String showCaja2() {
		String res = "Caja 2: " + "\n";
		for (Pokemon s : pc.getCaja2()) {
			res += s.toString() + "\n";
		}
		return res;
	}
	// funcion para mostrar la caja 3

	public String showCaja3() {
		String res = "Caja 3: " + "\n";
		for (Pokemon s : pc.getCaja3()) {
			res += s.toString() + "\n";
		}
		return res;
	}
	
	

}
