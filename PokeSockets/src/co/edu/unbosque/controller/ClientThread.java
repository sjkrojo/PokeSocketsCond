package co.edu.unbosque.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ClientThread extends Thread {
	
	private DataInputStream in;
	private DataOutputStream out;
	private String clientid;
	private String answer;

	public ClientThread() {
	}

	public ClientThread(DataInputStream in, DataOutputStream out, String clientid) {
		super();
		this.in = in;
		this.out = out;
		this.clientid = clientid;
	}

	public void run() {
		while(true) {
			try {
				this.answer = in.readUTF();
				System.out.println(answer);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

	public void sendMessage(String message) { // Envia un mensaje al servidor
		try {
			out.writeUTF(message);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public String getAnswer() {
		return answer;
	}

}
