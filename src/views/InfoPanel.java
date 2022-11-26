package views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class InfoPanel extends JPanel{

	private TextFieldRound[][] matrix;
	private GridBagConstraints gbc;
	private int row;
	
	public InfoPanel(ActionListener listner, KeyListener keyListener, int columns) {
		this.setSize(350, 300);
		this.setBackground(Color.WHITE);
		initComponents(listner, keyListener, columns);
	}
	
	private void initComponents(ActionListener listener, KeyListener keyListener, int columns) {
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		fillMatrix(columns, keyListener);
	}
	
	private void fillMatrix(int columns, KeyListener listener) {
		matrix = new TextFieldRound[columns][6];
		gbc.insets = new Insets(5, 0, 5, 5);
		gbc.ipadx = (this.getWidth() - (columns * 5) - 100)/columns;
		gbc.ipady = 10;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				gbc.gridx = i;
				gbc.gridy = j;
				matrix[i][j] = new TextFieldRound(10, listener);
				this.add(matrix[i][j], gbc);
			}
		}
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
	
	public void setTextMatrixInPosition(String letter, int column) {
		matrix[column][row].setText(letter);
	}
}
