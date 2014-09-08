package strikeforce.client;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private int width;
	private int height;
	
	private Game clientGame;
	
	/**
	 * @param width
	 * @param height
	 * @param clientGame
	 */
	public Canvas(int width, int height, Game clientGame) {
		super();
		this.width = width;
		this.height = height;
		this.clientGame = clientGame;
		
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				//TODO generate game command
			}

			@Override
			public void keyReleased(KeyEvent e) {
				//TODO generate game command
			}

			@Override
			public void keyTyped(KeyEvent e) {}
			
		});
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
	}	
}
