package sakurai;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Method {
		public  void start(){
			// コンストラクタの引数でアプリタイトルを設定
	        JFrame frame = new JFrame("デモアプリ");
	     // フルスクリーンにする
	        frame.setUndecorated(true);
	        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

	        
	        // 画面上に表示するメッセージ
	        JLabel label = new JLabel("Hello 太一");
	        label.setFont(new Font("Serif", Font.PLAIN, 250));
	        // メッセージを画面上部に表示させる
	        label.setVerticalAlignment(JLabel.CENTER);
	        frame.add(label);
	        // 画面上下左右中央にウィンドウを表示させる
	        frame.setLocationRelativeTo(null);
	        
	       
	        // 「X」ボタンで画面を閉じたらアプリケーションを終了させる
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	windo windo=new windo();
	    	windo.addLoginButton(frame);
	    	frame.setVisible(true);
	    	
	    	

	        // 上パネル（右寄せ）
	        JPanel topPanel = new JPanel();
	        JButton loginButton = new JButton("ログイン");
	        topPanel.add(loginButton);

	        frame.add(topPanel, BorderLayout.EAST);

	        frame.setVisible(true);
	        
	     // ボタンにアクションを追加
	        	 loginButton.addActionListener((ActionEvent e) -> {
	                 // 新しいウィンドウを作成
	                 JFrame newFrame = new JFrame("新しいウィンドウ");
	                 newFrame.setSize(400, 300);
	                 newFrame.setLayout(new FlowLayout());
	                 newFrame.add(new JLabel("これは新しいウィンドウです"));
	                 newFrame.setLocationRelativeTo(frame); // メインウィンドウの中央に表示
	                 newFrame.setVisible(true);

        
    });
	       
		}
		
		
		
		
}

