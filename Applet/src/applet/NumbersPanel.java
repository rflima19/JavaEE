package applet;

import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NumbersPanel extends JPanel implements ActionListener {

	private JButton[] numbers = new JButton[10];
	private InfoPanel infoPanel;
	
	public NumbersPanel(InfoPanel infoPanel) {
		this.infoPanel = infoPanel;
		
		setLayout(new GridLayout(2, 5, 5, 5));
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = new JButton(String.valueOf(i));
			numbers[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			numbers[i].addActionListener(this);
			add(numbers[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton b = (JButton) e.getSource();
		
		String num = b.getText();
		
		infoPanel.adicionarNumero(Integer.parseInt(num));
	}
}
