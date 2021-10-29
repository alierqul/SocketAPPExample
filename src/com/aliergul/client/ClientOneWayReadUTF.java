package com.aliergul.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import com.aliergul.model.PortInfo;

public class ClientOneWayReadUTF {
	public static void main(String[] args) {
		Scanner klavye;
		String number;
		PortInfo port = new PortInfo();
		try (DataOutputStream dataOutputStream = new DataOutputStream(
				new Socket(port.getIdAdress(), port.getPort()).getOutputStream())) {
			klavye = new Scanner(System.in);
			System.out.println("Lutfen bir sayı giriniz");
			number = klavye.nextLine();
			dataOutputStream.writeUTF(number);
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
