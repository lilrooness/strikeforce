package strikeforce.client.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

import strikeforce.entity.Player;
import strikeforce.observer.Observer;
import strikeforce.observer.PlayerEffectedEvent;
import strikeforce.observer.SubjectEvent;
import strikeforce.server.PacketType;

public class StrikeForceClientMessenger implements Observer {
	
	private InetAddress host;
	private int hostPort;
	private int clientPort;
	
	/**
	 * @param host
	 * @param port
	 */
	public StrikeForceClientMessenger(InetAddress host, int hostPort, int clientPort) {
		super();
		this.host = host;
		this.hostPort = hostPort;
		this.clientPort = clientPort;
	}
	
	public void sendConnectionRequest() throws IOException {
		DatagramSocket socket = new DatagramSocket(clientPort);
		
		byte[] buffer = ByteBuffer.allocate(4).putInt(PacketType.CONNECTION).array();
		socket.send(new DatagramPacket(buffer, buffer.length, host, hostPort));
	}

//  public void sendPlayerUpdate(PlayerMovedEvent event) {
//
//  }
	
	public void sendPlayerUpdate(Player player) throws IOException {
		DatagramSocket socket = new DatagramSocket(clientPort);
		byte[] buffer = ByteBuffer.allocate(4)
				.putInt(PacketType.UPDATE)
				.putFloat(player.getxVel())
				.putFloat(player.getyVel())
				.putInt(player.getId()).array();
		
		socket.send(new DatagramPacket(buffer, buffer.length, host, hostPort));
	}
	
	@Override
	public void notifyEvent(SubjectEvent event) {
		switch(event.getType()) {
		case PLAYER_UPDATE: {
			PlayerEffectedEvent effectEvent = (PlayerEffectedEvent) event;
			try {
				sendPlayerUpdate((Player)effectEvent.getPlayer());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		}
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
