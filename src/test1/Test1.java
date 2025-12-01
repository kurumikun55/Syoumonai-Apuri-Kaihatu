package test1;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Test1 {
    public static void main(String[] args) {
        // 最初にエラーダイアログを表示
        JOptionPane.showMessageDialog(null, "エラー: IQが足りていません。再起動してください。");

        // メインフレーム
        JFrame frame = new JFrame("偽の再起動アプリ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        // 進捗バー（永遠に99%）
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(99);
        progressBar.setStringPainted(true);

        // ラベル（初期状態）
        JLabel label = new JLabel("クリックすると再起動開始", SwingConstants.CENTER);

        // ボタン
        JButton button = new JButton("クリックして！");
        button.addActionListener(e -> {
            label.setText("再起動中…");
            // タイマーで「再起動中…」を永遠に更新
            Timer timer = new Timer(1000, ev -> {
                label.setText("再起動中…"); // ずっと同じ表示
            });
            timer.start();
        });

        // コンポーネント配置
        frame.add(progressBar, BorderLayout.CENTER);
        frame.add(label, BorderLayout.NORTH);
        frame.add(button, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}