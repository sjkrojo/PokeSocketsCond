package co.edu.unbosque.controller;

public class AplMain {
	
	public static void main(String[] args) {
		Client c = new Client();
		c.run("127.0.0.1" , 9000);
	}
}
