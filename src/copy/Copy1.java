package copy;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import sakurai.windo;

public class Copy1 {
	public class Method {
		public  void start(){
			// コンストラクタの引数でアプリタイトルを設定
	        JFrame frame = new JFrame("デモアプリ");
	     // フルスクリーンにする
	        frame.setUndecorated(true);
	        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

	        
	        // 画面上に表示するメッセージ
	        JLabel label = new JLabel("Hello 太一");
	        label.setFont(new Font("Serif", Font.PLAIN, 175));
	        // メッセージを画面上部に表示させる
	        label.setVerticalAlignment(JLabel.CENTER);
	        frame.add(label);
	        // 画面上下左右中央にウィンドウを表示させる
	        frame.add(label, BorderLayout.WEST);
	        
	        // 「X」ボタンで画面を閉じたらアプリケーションを終了させる
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        
	    	windo windo=new windo();
	    	windo.addLoginButton(frame);
	        

		}
		
		
		
		
}
}
