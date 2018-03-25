import java.io.*;
import java.net.*;

public class Server {

	public static void main(String args[]) {
		new Server().openServer();
	}
	
	/* Define the socket that receives requests */
	ServerSocket ProviderSocket;
	Socket connection = null;

	/* Define the socket that is used to handle the connection */
	
	void openServer() {
		try {

			/* Create Server Socket */
			ProviderSocket = new ServerSocket(4321,10);//Listener socket, to 2o arg einai to epitrepto orio sundesewn
			
			while (true) {
				/* Accept the connection */
				
				connection = ProviderSocket.accept(); //Stalls till connection arrives
				
				
				System.out.println("Got a new connection...");
				/* Handle the request */
				Thread t = new ActionsForClients(connection);
				t.start();
			}

		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			try {
				ProviderSocket.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
	}	
}