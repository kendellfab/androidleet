package us.kendellfabrici.leeter.com;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class LeetCommunicator {
	
	
	public String sendMessage(String input) {
		try {
			Socket client = new Socket();
			InetAddress address = InetAddress.getByName("10.0.2.2");
			int port = 2222;
			SocketAddress socketAddress = new InetSocketAddress(address, port);
			client.connect(socketAddress);
			
			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			DataInputStream in = new DataInputStream(client.getInputStream());
			
			out.writeUTF(input);
			
			String result = in.readUTF();
			
			return result;
		} catch(Exception ex) {
			return ex.getMessage();
		}
	}

}
