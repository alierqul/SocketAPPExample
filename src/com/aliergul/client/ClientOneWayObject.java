package com.aliergul.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.aliergul.model.PortInfo;

public class ClientOneWayObject {
	public static void main(String[] args) {
		PortInfo port = new PortInfo();
		List<PortInfo> listExamleObject = new ArrayList<>();
		listExamleObject.add(port);
		try {
			Socket socket = new Socket(port.getIdAdress(), port.getPort());
			System.out.println("Bağlantı tamam");
			OutputStream outputStream = socket.getOutputStream();
			
			// Object g�nderiyorum
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			
			objectOutputStream.writeObject(listExamleObject);
			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
