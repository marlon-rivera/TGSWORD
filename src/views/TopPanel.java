package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class TopPanel extends JPanel {

	private LetterIconButton exitButton;
	private JLabel coinsImage;
	private JLabel coinsTxt;
	private JLabel levelImage;
	private JLabel levelTxt;

	public TopPanel(ActionListener listener, Component component, int level, int coins) {
		this.setSize(350, 50);
		this.setBackground(Color.WHITE);
		initComponents(listener, component, level, coins);
	}

	private void initComponents(ActionListener listener, Component component, int level, int coins) {
		this.setLayout(null);
		DragListener drag = new DragListener(component);
		this.addMouseListener(drag);
		this.addMouseMotionListener(drag);
		exitButton = new LetterIconButton(new ImageIcon("images/logOut.png"), listener, "exitAll", 50, 50, true);
		coinsTxt = new JLabel(String.valueOf(coins));
		coinsTxt.setFont(new Font("Arial", Font.BOLD, 20));
		ImageIcon coin = new ImageIcon("images/coin.png");
		ImageIcon coinScaled = new ImageIcon(coin.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		levelTxt = new JLabel("NIVEL");
		levelTxt.setFont(new Font("Arial", Font.BOLD, 20));
		levelImage = new JLabel(String.valueOf(level));
		levelImage.setFont(new Font("Arial", Font.BOLD, 20));
		coinsImage = new JLabel(coinScaled);

		this.add(exitButton).setBounds(300, 0, exitButton.getWidthButton(), exitButton.getHeigthButton());
		this.add(levelImage).setBounds(220, 0, 50, 50);
		this.add(levelTxt).setBounds(145, 0, 100, 50);
		this.add(coinsTxt).setBounds(70, 0, 50, 50);
		this.add(coinsImage).setBounds(10, 0, 50, 50);
	}
}

class DragListener extends MouseInputAdapter {
	private Point location;
	private MouseEvent pressed;
	private Component component;

	public DragListener(Component component) {
		this.component = component;
	}

	public void mousePressed(MouseEvent me) {
		pressed = me;
	}

	public void mouseDragged(MouseEvent me) {
		location = component.getLocation(location);
		int x = location.x - pressed.getX() + me.getX();
		int y = location.y - pressed.getY() + me.getY();
		component.setLocation(x, y);
	}
}