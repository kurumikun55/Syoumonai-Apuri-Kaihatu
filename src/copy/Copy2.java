package copy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Copy2 {
	public static void addLoginButton(JFrame frame) {
	    JPanel panel = new JPanel(new GridBagLayout());

	    JButton loginButton = new JButton("ログイン");
	    loginButton.setFont(new Font("Serif", Font.PLAIN, 100));
	    loginButton.setPreferredSize(new Dimension(600, 240));

	    panel.add(loginButton);

	    frame.add(panel, BorderLayout.CENTER);
	    frame.setVisible(true);
	}
}
