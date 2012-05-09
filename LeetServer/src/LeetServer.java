import java.net.ServerSocket;
import java.net.Socket;


public class LeetServer {
	
	private static final int _portNumber = 2222;
	
	public static void main(String[] args) {
		System.out.println("Started Leet Server");
		ServerSocket server;
		Socket client;
		try {
			server = new ServerSocket(_portNumber);
			
			while(true) {
				client = server.accept();
				System.out.println("Connection accepted.");
				
				LeetCommunicator com = new LeetCommunicator(client);
				Thread t = new Thread(com);
				t.start();
			}
		}
		catch(Exception ex) {
			
		}
		
	}

}
