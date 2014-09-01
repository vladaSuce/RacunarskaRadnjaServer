package server;

import java.net.ServerSocket;
import java.net.Socket;

import repository.ProdavnicaRacunara;

public class StartServer {

	public static final int TCP_PORT = 9000;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		ProdavnicaRacunara prodavnica = new ProdavnicaRacunara();
		try {
			ServerSocket ss = new ServerSocket(TCP_PORT);
			System.out.println("Server running...");
			while (true) {
				Socket sock = ss.accept();
				UserServerThread st = new UserServerThread(sock, prodavnica);
				System.out.println("-> Client accepted: " + sock.getInetAddress() + "[" + sock.getPort() + "]");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
