package com.aliergul.chatapp.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aliergul.chatapp.model.Messages;
import com.aliergul.chatapp.model.Users;
import com.aliergul.model.PortInfo;

public class ClientTwoWayObject {
	private static Scanner scan;
	private static Users user;
	private static List<Messages> listMessage;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		listMessage = new ArrayList<>();
		
		scan = new Scanner(System.in);
		user = new Users("Client", "Client");
		String sendMessage = "";
		PortInfo port = new PortInfo();
		Socket socket = new Socket(port.getIdAdress(), port.getPort());
		OutputStream outputStream = socket.getOutputStream();
		ObjectOutputStream objOut = new ObjectOutputStream(outputStream);
		ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
		
		while (true) {
			Object obj = null;
			try {
				System.out.print(user.getName() + ": ");
				sendMessage = scan.nextLine();
				Messages msjSend = new Messages(sendMessage, user);
				objOut.writeObject(msjSend);
				listMessage.add(msjSend);
				
				if ((obj = inputStream.readObject()) instanceof Messages) {
					Messages msjGelen = (Messages) obj;
					System.out.println(msjGelen.getId() + "]" + msjGelen.getSendUser().getName() + ":"
							+ msjGelen.getText() + "\n\t\t\t\t" + msjGelen.getLogDate().toString());
					listMessage.add(msjGelen);
				}
			} catch (SocketException e) {
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
	}
	
}
