package strikeforce.client;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import strikeforce.command.KeyboardCommand;

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
				keyPressedEvent(e.getKeyChar());
			}

			@Override
			public void keyReleased(KeyEvent e) {
				//TODO generate game command
			}

			@Override
			public void keyTyped(KeyEvent e) {}
			
		});
		
		ActionListener timerListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				repaint();
			}
			
		};
		
		new Timer(1000/60, timerListener).start();
		this.setFocusable(true);
	}

	@Override
	public void paint(Graphics g) {
		clientGame.update();
		Graphics2D g2 = (Graphics2D) g;
	}
	
	public void keyPressedEvent(char key) {
		clientGame.getCommands().add(new KeyboardCommand(key, clientGame));
	}
}
