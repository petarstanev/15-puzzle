package mainpackage;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;

/* This is class for single square.
 */
public class Square {
	private int number; // if number = 0 it is empty
	private int x;
	private int y;
	private JLabel JLabel;

	Square(int number) {
		if (number != 0) {
			JLabel = new JLabel(Integer.toString(number));
			JLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
			JLabel.setHorizontalAlignment(SwingConstants.CENTER);
			JLabel.setOpaque(true);
			JLabel.setBackground(new Color(204,182,20));
		} else {
			JLabel = new JLabel("");
			JLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
			JLabel.setHorizontalAlignment(SwingConstants.CENTER);
			JLabel.setOpaque(true);
			JLabel.setBackground(new Color(255,25,145));//CCB614
		}
		// contentPanel.add(JLabel);
		this.number = number;
	}

	void setCoordinates(int x,int y) {
		this.x = x;
		this.y = y;
		JLabel.setBounds(x, y, 50, 50);
	}
	
	JLabel getJLabel(){
		return JLabel;
	}

	int getNumber() {
		return number;
	}
}
