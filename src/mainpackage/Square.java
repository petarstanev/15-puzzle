package mainpackage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * This is class for single square.
 */
public class Square extends JLabel {
	public static final int SIZE = 50;
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
		setBounds(x, y, SIZE, SIZE);
		setOpaque(true);
		setHorizontalAlignment(SwingConstants.CENTER);
		setForeground(Color.BLACK);
		setFont(new Font("Tahoma", Font.PLAIN, 30));
		setBackgroundColour();
	}
//setBackground(new Color(127, 255, 212));
//setBackground(new Color(218, 112, 214));	
	/**
	 * @return number
	 */
	public int getNumber() {
		return number;
	}
	
	public void setBackgroundColour(){
		if(number==0)
			setBackground(new Color(218, 112, 214));	
		else
			setBackground(new Color(127, 255, 212));
	}

	public void setNumber(int number) {
		this.number = number;
		setText(Integer.toString(number));
		setBackgroundColour();
	}

}