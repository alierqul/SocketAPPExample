package com.aliergul.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.aliergul.model.PortInfo;

public class ServerTwoWayText {
	public static void main(String[] args) {
		
		PortInfo port = new PortInfo();
		startServer(port);
	}
	
	private static void startServer(PortInfo port) {
		try (ServerSocket sServer = new ServerSocket(port.getPort())) {
			Socket socket = sServer.accept();
			System.err.println("Server Başlatıldı.");
			inComingMessage(socket);
		} catch (IOException e) {
			System.err.println("Server Başlatılamadı.");
			
		}
	}
	
	private static void inComingMessage(Socket socket) {
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			String receivedMessage = "";
			String sendMessage = "";
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream, true);
			
			InputStream inputStream = socket.getInputStream();
			BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
			while (true) {
				if ((receivedMessage = bufferedReader2.readLine()) != null) {
					System.out.println("CLIENT= " + receivedMessage);
				}
				
				sendMessage = bufferedReader.readLine();
				printWriter.println(sendMessage);
				printWriter.flush();
			}
		} catch (IOException e) {
			System.err.println("Gelen Veri Okunamadı.");
		}
		
	}
}
