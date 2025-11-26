package sakurai;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class windo {

	public static void addButton(JFrame frame) {
        JButton button = new JButton("クリックしてね");
        button.setBackground(Color.cyan);
        button.setFont(new Font("SansSerif", Font.BOLD, 50));
        frame.add(button, BorderLayout.SOUTH);
        
        

        // ボタンにアクションを追加
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "ボタンが押されました！");
        });
    }
	
}

