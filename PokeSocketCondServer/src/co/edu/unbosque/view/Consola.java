package co.edu.unbosque.view;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Consola {
	private Scanner reader;

	public Consola() {
		reader = new Scanner(System.in);
	}

	public void printString(String str) {

		System.out.println(str);
	}

	public void printStringInLine(String str) {
		System.out.print(str);
	}

	public void burnLine() {
		reader.nextLine();
	}

	public int readInt() {

		return reader.nextInt();
		
	}

	public long readLong() {
		return reader.nextLong();
	}

	public float readFloat() {
		return reader.nextFloat();
	}

	public double readDouble() {
		return reader.nextDouble();
	}

	public String readStringLine() {
		return reader.nextLine();
	}

	public String readString() {
		return reader.next();
	}

	public void printInt(int i) {
		System.out.println(i);

	}

}
