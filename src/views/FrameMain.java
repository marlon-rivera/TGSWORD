package views;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;

public class FrameMain extends JFrame {

	private KeyPadPanel keyPadPanel;
	private InfoPanel infoPanel;
	private TopPanel topPanel;
	private OptionsPanel optionsPanel;

	public FrameMain(ActionListener listener, KeyListener keyListener, int columns) {
		this.setTitle("WG - TGS");
		this.setSize(350, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.removeNotify();
		this.setUndecorated(true);
		this.setShape(new RoundRectangle2D.Double(0, 0, this.getWidth(), this.getHeight(), 15, 15));
		this.addNotify();
		this.getContentPane().setBackground(Color.WHITE);
		initComponents(listener, keyListener, columns);
		this.setVisible(true);
	}

	private void initComponents(ActionListener listener, KeyListener keyListener, int columns) {
		this.setLayout(null);
		
		keyPadPanel = new KeyPadPanel(listener);
		infoPanel = new InfoPanel(listener, keyListener, columns);
		topPanel = new TopPanel(listener, this, 5, 100);
		optionsPanel = new OptionsPanel(listener);
		
		add(topPanel).setBounds(0, 8, topPanel.getWidth(), topPanel.getHeight());
		add(optionsPanel).setBounds(0, 300, optionsPanel.getWidth(), optionsPanel.getHeight());
		add(infoPanel).setBounds(-5, 30, infoPanel.getWidth(), infoPanel.getHeight());
		add(keyPadPanel).setBounds(7, 560 - keyPadPanel.getHeight(), keyPadPanel.getWidth(), keyPadPanel.getHeight());
	}

	public void setTextMatrixInPosition(String letter, int column) {
		infoPanel.setTextMatrixInPosition(letter, column);
	}
}
