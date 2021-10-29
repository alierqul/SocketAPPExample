package com.aliergul.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.aliergul.model.PortInfo;

public class ClientTwoWayText {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		String receivedMessage = "";
		String sendMessage = "";
		PortInfo port = new PortInfo();
		Socket socket = new Socket(port.getIdAdress(), port.getPort());
		
		// Client ile veri göndermek için
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		OutputStream outputStream = socket.getOutputStream();// ________________ klavyeden girilecek.
		PrintWriter printWriter = new PrintWriter(outputStream, true);
		
		// Serverdan Gelen Veriyi Almak.
		InputStream inputStream = socket.getInputStream();
		BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
		// _______________________________________________________________Socketden_gelicek.
		System.out.print("Lütfen Mesajınızı giriniz : ");
		while (true) {
			sendMessage = bufferedReader.readLine();// Klavyeden girilen mesajı alıyor.
			printWriter.println(sendMessage);// mesajı server e Yönlendiriyor.
			printWriter.flush();// tazelenme
			
			// Karşından cevap bekleme
			if ((receivedMessage = bufferedReader2.readLine()) != null) {
				System.out.println("SERVER= " + receivedMessage);
			}
			
		}
	}
	
}
