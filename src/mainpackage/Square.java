package mainpackage;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;

/* This is class for single square.
 */
public class Square {
	private int number; // if number = 0 it is empty
	private JLabel JLabel;

	Square(int number) {
		if (number != 0) {
			JLabel = new JLabel(number + "");
			JLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
			JLabel.setHorizontalAlignment(SwingConstants.CENTER);
			JLabel.setBackground(Color.green);
			// JLabel.setBounds(99, 119, 50, 50);
		} else {
			JLabel = new JLabel("");
			JLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
			JLabel.setHorizontalAlignment(SwingConstants.CENTER);
			JLabel.setBackground(Color.black);
		}
		// contentPanel.add(JLabel);
		this.number = number;
	}

	JLabel getJLabel() {
		return JLabel;
	}

	int getNumber() {
		return number;
	}
}
