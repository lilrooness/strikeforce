package strikeforce.client;

import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import strikeforce.Game;

public class Window extends JFrame {

	private int width;
	private int height;
	
	private Canvas canvas;
	
	private ClientGame clientGame;
	
	/**
	 * @param width
	 * @param height
	 * @throws HeadlessException
	 */
	public Window(int width, int height, Game game) throws HeadlessException {
		super();
		this.width = width;
		this.height = height;
		clientGame = new ClientGame();
		canvas = new Canvas(width, height, clientGame);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(width, height));
		
		add(canvas);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Window(640, 480, new Game());
	}

}
