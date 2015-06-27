package mainpackage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * This is class for single square.
 */
public class Square extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int number;

	/**
	 * Constructor for square.
	 * 
	 * @param number
	 */
	Square(int number, int x, int y) {
		super(Integer.toString(number));
		this.number = number;
		setBounds(x, y, 50, 50);
		setOpaque(true);
		setHorizontalAlignment(SwingConstants.CENTER);
		setForeground(Color.BLACK);
		setFont(new Font("Tahoma", Font.PLAIN, 30));
		setBackground(Color.GRAY);
	}

	/**
	 * @return number
	 */
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
		setText(Integer.toString(number));
	}

}