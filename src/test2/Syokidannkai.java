package test2;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Syokidannkai {

	public static void main(String[] args) {
		// コンストラクタの引数でアプリタイトルを設定
        JFrame frame = new JFrame("デモアプリ");
        // デスクトップに表示する画面のサイズ
        frame.setSize(1920,1080);
        
        // このウィンドウをデスクトップ上に表示する
        frame.setVisible(true);
        
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

        System.out.println(11111111111111);
        
        
        System.out.println(11111111111111111111111111111111);
	}

}
