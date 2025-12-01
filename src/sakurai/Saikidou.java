package sakurai;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class Saikidou {

	public static void main(String[] args) {

	
		        JFrame frame = new JFrame("システムの再起動中");
		        JProgressBar bar = new JProgressBar(0, 100);
		        bar.setStringPainted(true);

		        frame.add(bar, BorderLayout.CENTER);
		        frame.setSize(300, 80);
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setVisible(true);

		        new Thread(() -> {
		            for (int i = 0; i <= 99; i++) {
		                try { Thread.sleep((int)(Math.random()*150)); } catch (Exception ignored) {}
		                bar.setValue(i);
		            }
		            JOptionPane.showMessageDialog(frame, "ERROR！：頭脳の容量が足りていません");
		        }).start();
		    }
		


	}


