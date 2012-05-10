import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;


public class LeetCommunicator implements Runnable {
	
	private Socket client;
	private DataInputStream inputStream;
	private DataOutputStream outputStream;
	
	public LeetCommunicator(Socket c) {
		client = c;
	}

	@Override
	public void run() {
		System.out.println("Starting the communication.");
		
		String input = "";
		try {
			
			inputStream = new DataInputStream(client.getInputStream());
			outputStream = new DataOutputStream(client.getOutputStream());
			input = inputStream.readUTF();
			System.out.println(input);			
			
			String output = makeLeet(input);
			System.out.println(output);
			outputStream.writeUTF(output);	
			System.out.println("Finishing communication");
			
		} catch(Exception ex) {
			
		}
		
	}
	
	public String makeLeet(String input) {
		
		String result = "";
		
		for(int i = 0; i < input.length(); i++) {
			
			if(input.charAt(i) == 'e' || input.charAt(i) == 'E') {
				result += '3';
			}
			
			else if(input.charAt(i) == 't' || input.charAt(i) == 'T') {
				result += '7';
			}
			else {
				result += input.charAt(i);
			}
		}
		
		return result;
	}

}
