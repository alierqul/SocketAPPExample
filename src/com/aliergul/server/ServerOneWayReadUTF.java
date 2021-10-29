package com.aliergul.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;

import com.aliergul.model.PortInfo;

public class ServerOneWayReadUTF {
	public static void main(String[] args) {
		String clientValue;
		int scannerNumber;
		PortInfo port = new PortInfo();
		try (DataInputStream dataInputStream = new DataInputStream(
				new ServerSocket(port.getPort()).accept().getInputStream())) {
			clientValue = dataInputStream.readUTF();
			scannerNumber = Integer.valueOf(clientValue);
			System.out.println(scannerNumber + " sayısının  Karekökü: " + Math.sqrt(scannerNumber));
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
