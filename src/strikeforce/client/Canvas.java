package strikeforce.client;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import strikeforce.command.ClientKeyboardCommand;
import strikeforce.entity.Entity;

public class Canvas extends JPanel {

	private int width;
	private int height;
	
	private ClientGame clientGame;
	
	ActionListener timerListener;
	
	/**
	 * @param width
	 * @param height
	 * @param clientGame
	 */
	public Canvas(int width, int height, ClientGame clientGame) {
		super();
		this.width = width;
		this.height = height;
		this.clientGame = clientGame;
		
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				clientKeyPressed(e.getKeyChar());
			}

			@Override
			public void keyReleased(KeyEvent e) {
				//TODO generate game command
			}

			@Override
			public void keyTyped(KeyEvent e) {}
			
		});
		
		this.setFocusable(true);
		
		timerListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("updating");
				updateClient();
			}
			
		};
		new Timer(1000 / 60, timerListener).start();
	}

	@Override
	public void paint(Graphics g) {
		clientGame.update();
		Graphics2D g2 = (Graphics2D) g;
		for(Entity entity : clientGame.getOtherPlayers()) {
			g2.fillOval((int)entity.getxPos(), (int)entity.getyPos(), 30, 30);
		}
		
		g2.fillOval((int)clientGame.getPlayer().getxPos(), (int)clientGame.getPlayer().getyPos(), 30, 30);
	}
	
	public void clientKeyPressed(char keyCode) {
		clientGame.getCommands().add(new ClientKeyboardCommand(keyCode, clientGame));
	}
	
	public void updateClient() {
		clientGame.update();
	}
}
