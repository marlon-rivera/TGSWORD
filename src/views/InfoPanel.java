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
	private int columns;
	private int row;
	
	public InfoPanel(ActionListener listner, KeyListener keyListener, int columns) {
		this.columns = columns;
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
	
	public void resetColor() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j].setText("");
				matrix[i][j].setBackgroundColor(Color.decode("#9b9b9b"));
			}
		}
	}
	
	public String getWordUser(int row) {
		String wordUser = "";
		for (int i = 0; i < matrix.length; i++) {
			wordUser += matrix[i][row].getText();
		}
		return wordUser;
	}
	
	public void setBackgroundColor(int row, boolean[] positions, boolean[] incorrectPositions) {
		for (int i = 0; i < positions.length; i++) {
			if(positions[i] == true) {
				matrix[i][row].setBackgroundColor(Color.decode("#00bb2d"));
			}
		}
		for (int i = 0; i < incorrectPositions.length; i++) {
			if(incorrectPositions[i] == true) {
				matrix[i][row].setBackgroundColor(Color.BLACK);
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			if(matrix[i][row].getBackgroundColor().equals(Color.decode("#9b9b9b"))) {
				matrix[i][row].setBackgroundColor(Color.ORANGE);
			}
		}
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
	
	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public void setTextMatrixInPosition(String letter, int column) {
		matrix[column][row].setText(letter);
	}
}
