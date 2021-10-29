package com.aliergul.chatapp.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import com.aliergul.chatapp.model.Messages;
import com.aliergul.chatapp.model.Users;
import com.aliergul.model.PortInfo;

public class ServerTwoWayObject {
	private static Users user;
	private static Scanner scan;
	
	public static void main(String[] args) {
		user = new Users("User Server", "Server");
		scan = new Scanner(System.in);
		PortInfo port = new PortInfo();
		startServer(port);
	}
	
	private static void startServer(PortInfo port) {
		System.err.println("Server Başlatıldı.");
		try (ServerSocket sServer = new ServerSocket(port.getPort())) {
			Socket socket = sServer.accept();
			System.err.println("Bağlantı Sağlandı.");
			inComingMessage(socket);
		} catch (IOException e) {
			System.err.println("Server Başlatılamadı.");
			
		}
	}
	
	private static void inComingMessage(Socket socket) {
		try {
			ObjectInputStream objectReader = new ObjectInputStream(socket.getInputStream());
			Object receivedMessage = null;
			String sendMessage = null;
			
			ObjectOutputStream objOut = new ObjectOutputStream(socket.getOutputStream());
			
			while (true) {
				try {
					if ((receivedMessage = objectReader.readObject()) instanceof Messages) {
						Messages msj = (Messages) receivedMessage;
						System.out.println(msj.getSendUser().getName() + ":" + msj.getText() + "\n\t\t\t\t"
								+ msj.getLogDate().toString());
					}
					
					System.out.print(user.getName() + ": ");
					sendMessage = scan.nextLine();
					Messages msg = new Messages(sendMessage, user);
					objOut.writeObject(msg);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (IOException e) {
			System.err.println("Gelen Veri Okunamadı.");
		}
		
	}
}
