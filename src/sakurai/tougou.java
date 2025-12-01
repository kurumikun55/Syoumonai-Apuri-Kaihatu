package sakurai;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class tougou {
	 public static void main(String[] args) {
		// 最初にエラーダイアログ
	        Object[] options = {"再起動"};
	        int choice = JOptionPane.showOptionDialog(
	            null,
	            "エラー: IQが足りていません。再起動してください。",
	            "エラー",
	            JOptionPane.DEFAULT_OPTION,
	            JOptionPane.ERROR_MESSAGE,
	            null,
	            options,
	            options[0]
	        );

	        if (choice == 0) {
	            JFrame frame = new JFrame("偽の再起動アプリ");
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	            // フルスクリーン化
	            frame.setUndecorated(true); // 枠なし
	            frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // 最大化

	            frame.setLayout(new BorderLayout());

	            // 進捗バー
	            JProgressBar progressBar = new JProgressBar(0, 100);
	            progressBar.setStringPainted(true);

	            // ラベル
	            JLabel label = new JLabel("再起動中…", SwingConstants.CENTER);
	            label.setFont(new Font("SansSerif", Font.BOLD, 40));
	            label.setForeground(Color.WHITE);

	            // 背景を暗くする
	            frame.getContentPane().setBackground(Color.BLACK);
	            progressBar.setBackground(Color.BLACK);
	            progressBar.setForeground(Color.GREEN);

	            frame.add(progressBar, BorderLayout.SOUTH);
	            frame.add(label, BorderLayout.CENTER);

	            frame.setVisible(true);

	            // タイマーで進捗バーを進める（99%で止まる）
	            Timer timer = new Timer(200, e -> {
	                int value = progressBar.getValue();
	                if (value < 99) {
	                    progressBar.setValue(value + 1);
	                }
	            });
	            timer.start();
	        }
	    }
}
