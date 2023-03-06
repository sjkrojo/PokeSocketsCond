package co.edu.unbosque.controller;

import java.util.Random;

public class AplMain {

	public static void main(String[] args) {
		Client c = new Client();

		Random rd = new Random(); // Crea una id random para el cliente
		c.start("127.0.0.1", 9000, rd.nextInt() + ""); // Conecta al cliente al puerto 9000 por su ip local
	}

}
