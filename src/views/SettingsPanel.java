package views;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

public class SettingsPanel extends JFrame{

//	private JLabel lblDarkMode;
//	private JToggleButton tglDarkModeButton;
//	private LetterIconButton btnSound;
//	private LetterIconButton btnMusic;
//	private LetterIconButton btnHelp;
//	
//
//	public SettingsPanel(ItemListener itmListener) {
//		this.setTitle("Ajustes");
//		this.setSize(330, 520);
//		this.setLocationRelativeTo(null);
//		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		initComponents(itmListener);
//		this.setVisible(true);
//	}
//
//	private void initComponents(ItemListener itmListener) {
//		this.setLayout(null);
//		createLabelDarkMode();
//		createToggleButtonDarkMode();
//		setItemAction(itmListener);
//		createSoundButton();
//		createMusicButton();
//		createHelpButton();
//	}
//
//	private void createLabelDarkMode() {
//		lblDarkMode = new JLabel("Modo Oscuro");
//		add(lblDarkMode);
//	}
//
//	private void createToggleButtonDarkMode() {
//		tglDarkModeButton = new JToggleButton("OFF");
//		tglDarkModeButton.setBounds(5, 5, 500, 500);
//		add(tglDarkModeButton);
//	}
//
//	private void setItemAction(ItemListener itmListener) {
//		tglDarkModeButton.addItemListener(itmListener);
//	}
//
//	public void itemStateChanged(ItemListener itmListener) {
//		if (tglDarkModeButton.isSelected()) {
//			tglDarkModeButton.setText("ON");
//			tglDarkModeButton.setBackground(Color.BLACK);
//		} else {
//			tglDarkModeButton.setText("OFF");
//		}
//	}
//	
//	private void createSoundButton() {
//		btnSound = new LetterIconButton();
//		add(btnSound);
//	}
//	
//	private void createMusicButton() {
//		btnMusic = new LetterIconButton();
//		add(btnMusic);
//	}
//	
//	private void createHelpButton() {
//		btnHelp = new LetterIconButton();
//		add(btnHelp);
//	}
}
