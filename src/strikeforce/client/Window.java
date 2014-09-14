package strikeforce.client;

import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class Window extends JFrame {

	private int width;
	private int height;
	
	
	/**
	 * @param width
	 * @param height
	 * @throws HeadlessException
	 */
	public Window(int width, int height) throws HeadlessException {
		super();
		this.width = width;
		this.height = height;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(width, height));

		this.add(new Canvas(width, height, new Game()));
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Window(640, 480);
	}
}
