package co.edu.unbosque.model.persistance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import co.edu.unbosque.model.UserDTO;

public class FileHandler {

	private Scanner lector;
	private File archivo;
	private PrintWriter escritor;

	public FileHandler(String url) {
		archivo = new File("src/co/edu/unbosque/model/persistance/" + url);
	}

	public String leerArchivo() {
		FileReader reader = null;
		try {
			reader = new FileReader(archivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(reader);
		
		String contenido = "";
		String line;
		try {
			while((line = br.readLine()) != null) {
				String[] columns = line.split("\n");
				for(String column : columns) {
					System.out.println( column);
					contenido += column + "\n";
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return contenido;
	}

	public void escribirArchivo(UserDTO a) {
		try {
			escritor = new PrintWriter(archivo);
			escritor.print(a);
			escritor.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo solicitado (escritura)");
			e.printStackTrace();
		}

	}

}
