package strikeforce.client.network;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import strikeforce.observer.Subject;

public class StrikeForceClientListener extends Subject implements Runnable {

	private DatagramSocket socket;
	private boolean isRunning;
	private int port;
	private InetAddress hostAddress;
	
	/**
	 * @param port
	 * @param hostAddress
	 */
	public StrikeForceClientListener(int port, InetAddress hostAddress) {
		super();
		this.port = port;
		this.hostAddress = hostAddress;
	}

	@Override
	public void run() {
		isRunning = true;
		
		try {
			socket = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		while(isRunning) {
			
		}
	}
	
}
