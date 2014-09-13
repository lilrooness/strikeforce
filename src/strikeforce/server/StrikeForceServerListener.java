package strikeforce.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import strikeforce.observer.PlayerConnectedEvent;
import strikeforce.observer.PlayerEffectedEvent;
import strikeforce.observer.Subject;

public class StrikeForceServerListener extends Subject implements Runnable {

	private ArrayList<Connection> connections;
	private DatagramSocket socket;
	private boolean isRunning;
	
	/**
	 * @param socket
	 */
	public StrikeForceServerListener(DatagramSocket socket) {
		super();
		this.socket = socket;
		this.connections = new ArrayList<>();
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
					this.notifyObservers(new PlayerConnectedEvent(0, 0, 0, 0, connections.size()));
					connections.add(new Connection(packetReceived.getAddress(), "a player"));
					break;
				case PacketType.DISCONNECTION:
					System.out.println(packetReceived.getAddress()+" is leaving");
					break;
				case PacketType.UPDATE:
					float xForce = ByteBuffer.wrap(buffer, 4, 4).getFloat();
					float yForce = ByteBuffer.wrap(buffer, 8, 4).getFloat();
					int id = ByteBuffer.wrap(buffer, 12, 4).getInt();
					System.out.println("Player moving: x:" + xForce + " y:" + yForce);
//					this.notifyObservers(new PlayerEffectedEvent(xForce, yForce, ));
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
