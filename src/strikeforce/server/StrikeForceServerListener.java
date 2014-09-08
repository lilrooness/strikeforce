package strikeforce.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class StrikeForceServerListener implements Runnable {

	private ArrayList<Connection> connections;
	private DatagramSocket socket;
	private boolean isRunning;
	
	/**
	 * @param socket
	 */
	public StrikeForceServerListener(DatagramSocket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		isRunning = true;
		DatagramPacket packetReceived;
		byte[] buffer = new byte[256];
		packetReceived = new DatagramPacket(buffer, buffer.length);
		
		while(isRunning) {
			try {
				this.socket.receive(packetReceived);
				int type = ByteBuffer.wrap(buffer, 0, 4).getInt();
				
				switch(type) {
				case PacketType.CONNECTION:
					System.out.println("Connection received from"+packetReceived.getAddress().toString());
					break;
				case PacketType.DISCONNECTION:
					System.out.println(packetReceived.getAddress()+" is leaving");
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
