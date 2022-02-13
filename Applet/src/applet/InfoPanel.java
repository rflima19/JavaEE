package applet;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class InfoPanel extends JPanel implements ActionListener {
	private JPasswordField senhaTxt;
	private JButton okBtn;
	private JButton limparBtn;
	private JApplet applet;
	
	public InfoPanel(JApplet applet) {
		this.applet = applet;
		
		senhaTxt = new JPasswordField(8);
		senhaTxt.setEditable(false);
		senhaTxt.setEchoChar('*');
		add(senhaTxt);
		
		okBtn = new JButton("OK");
		okBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		okBtn.addActionListener(this);
		add(okBtn);
		
		limparBtn = new JButton("Limpar");
		limparBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		limparBtn.addActionListener(this);
		add(limparBtn);
	}
	
	public void adicionarNumero(int num) {
		char[] chars = senhaTxt.getPassword();
		
		String senhaAtual = new String(chars);
		
		if (senhaAtual.length() == 6) {
			return;
		}
		
		senhaTxt.setText(senhaAtual + num);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == limparBtn) {
			senhaTxt.setText("");
		
		} else if (e.getSource() == okBtn) {
			
			String url = "http://localhost:8080/Applet/Login?senha=" + new String(senhaTxt.getPassword());
			
			try {
				applet.getAppletContext().showDocument(new URL(url));
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
