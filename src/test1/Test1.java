package test1;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Test1{
public static void main(String[] args) {
    // コンストラクタの引数でアプリタイトルを設定
    JFrame frame = new JFrame("デモアプリ");
    frame.setSize(1980, 1080);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // レイアウトを設定（縦に並べる）
    frame.setLayout(new BorderLayout());

    // ラベルを作成
    JLabel label = new JLabel("Hello 太一", SwingConstants.CENTER);
    label.setFont(new Font("Serif", Font.PLAIN, 250));
    frame.add(label, BorderLayout.CENTER);

    // ボタンを作成
    JButton button = new JButton("クリックしてね");
    button.setFont(new Font("SansSerif", Font.BOLD, 50));
    frame.add(button, BorderLayout.SOUTH); // 下部に配置

    // ボタンにアクションを追加
    button.addActionListener(e -> {
        JOptionPane.showMessageDialog(frame, "ボタンが押されました！");
    });

    // ウィンドウを表示
    frame.setVisible(true);

}
}

