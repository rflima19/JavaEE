package applet;

import java.awt.BorderLayout;

import javax.swing.JApplet;

public class Teclado extends JApplet {
	public Teclado() {

		setLayout(new BorderLayout());

		InfoPanel infoPanel = new InfoPanel(this);
		add(BorderLayout.SOUTH, infoPanel);

		NumbersPanel numbersPanel = new NumbersPanel(infoPanel);
		add(BorderLayout.CENTER, numbersPanel);
	}
}
