package strikeforce.client.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClientMainTest {
	
	public static void main(String[] args) {
		
		try {
			StrikeForceClientMessenger clientMessenger = new StrikeForceClientMessenger(InetAddress.getLocalHost(), 9001, 9000);
			clientMessenger.sendConnectionRequest();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
