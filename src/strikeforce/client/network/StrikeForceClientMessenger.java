package strikeforce.client.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;

import strikeforce.observer.Observer;
import strikeforce.observer.SubjectEvent;
import strikeforce.server.PacketType;

public class StrikeForceClientMessenger implements Observer {
	
	private InetAddress host;
	private int hostPort;
	private int clientPort;
	private DatagramSocket socket;
	
	/**
	 * @param host
	 * @param port
	 */
	public StrikeForceClientMessenger(InetAddress host, int hostPort, int clientPort) {
		super();
		this.host = host;
		this.hostPort = hostPort;
		this.clientPort = clientPort;
		try {
			socket = new DatagramSocket(clientPort);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendConnectionRequest() throws IOException {
		
		byte[] buffer = ByteBuffer.allocate(4).putInt(PacketType.CONNECTION).array();
		socket.send(new DatagramPacket(buffer, buffer.length, host, hostPort));
	}
	
	public void sendPlayerUpdate(float xForce, float yForce, int playerId) throws IOException {
		
		byte[] buffer = ByteBuffer.allocate(16).putInt(PacketType.UPDATE)
											   .putFloat(xForce)
											   .putFloat(yForce)
											   .putInt(playerId)
											   .array();
		socket.send(new DatagramPacket(buffer, buffer.length, host, hostPort));
	}
	
	/**
	 * @return the host
	 */
	public InetAddress getHost() {
		return host;
	}
	/**
	 * @param host the host to set
	 */
	public void setHost(InetAddress host) {
		this.host = host;
	}
	
	@Override
	public void notifyEvent(SubjectEvent event) {
		
	}

	/**
	 * @return the hostPort
	 */
	public int getHostPort() {
		return hostPort;
	}

	/**
	 * @param hostPort the hostPort to set
	 */
	public void setHostPort(int hostPort) {
		this.hostPort = hostPort;
	}

	/**
	 * @return the clientPort
	 */
	public int getClientPort() {
		return clientPort;
	}

	/**
	 * @param clientPort the clientPort to set
	 */
	public void setClientPort(int clientPort) {
		this.clientPort = clientPort;
	}
	
	
}
