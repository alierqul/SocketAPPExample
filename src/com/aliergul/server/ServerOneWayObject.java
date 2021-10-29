package com.aliergul.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.aliergul.model.PortInfo;

public class ServerOneWayObject {
	public static void main(String[] args) throws ClassNotFoundException {
		PortInfo port = new PortInfo();
		try {
			ServerSocket serverSocket = new ServerSocket(port.getPort());
			System.out.println("Server Bağlanmaya hazır");
			
			Socket socket = serverSocket.accept();
			System.out.println("Bağlantı: " + socket);
			
			InputStream inputStream = socket.getInputStream();
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			
			ArrayList<PortInfo> listObjextExamples = (ArrayList<PortInfo>) objectInputStream.readObject();
			
			// stream()
			listObjextExamples.forEach((temp) -> System.out.println(temp.getPort() + " " + temp.getIdAdress()));
			
			serverSocket.close();
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
