import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Test {
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
			}
		});
		jf.setVisible(true);
	}
}
