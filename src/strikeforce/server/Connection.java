package strikeforce.server;

import java.net.InetAddress;

public class Connection {
	private InetAddress source;
	private String username;
	
	/**
	 * @param source
	 * @param username
	 */
	public Connection(InetAddress source, String username) {
		super();
		this.source = source;
		this.username = username;
	}
	
	/**
	 * @return the source
	 */
	public InetAddress getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(InetAddress source) {
		this.source = source;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
}
