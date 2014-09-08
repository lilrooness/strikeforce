package strikeforce.server;

import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerMainTest {

	public static void main(String[] args) {
		try {
			StrikeForceServerListener serverListener = new StrikeForceServerListener(new DatagramSocket(9001));
			Thread listenerThread = new Thread(serverListener);
			listenerThread.start();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
}
