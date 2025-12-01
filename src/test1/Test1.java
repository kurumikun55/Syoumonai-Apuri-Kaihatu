package test1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Test1 {
    public static void main(String[] args) {
        // 最初のフレーム
        JFrame frame = new JFrame("javaコード作成");
        JButton button = new JButton("javaのコードを作成するよ！");

        // ボタンを押したら「エラー」→「再起動風画面」に切り替え
        button.addActionListener(e -> {
            // エラーダイアログ
            JOptionPane.showMessageDialog(frame, "エラー: IQが足りていません");

            // 再起動風のフルスクリーン画面を表示
            JFrame restartFrame = new JFrame("偽の再起動アプリ");
            restartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            restartFrame.setUndecorated(true); // 枠なし
            restartFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // フルスクリーン
            restartFrame.setLayout(new BorderLayout());

            // 進捗バー
            JProgressBar progressBar = new JProgressBar(0, 100);
            progressBar.setStringPainted(true);

            // ラベル
            JLabel label = new JLabel("再起動中…", SwingConstants.CENTER);
            label.setFont(new Font("SansSerif", Font.BOLD, 40));
            label.setForeground(Color.WHITE);

            // 背景を暗くする
            restartFrame.getContentPane().setBackground(Color.BLACK);
            progressBar.setBackground(Color.BLACK);
            progressBar.setForeground(Color.GREEN);

            restartFrame.add(progressBar, BorderLayout.SOUTH);
            restartFrame.add(label, BorderLayout.CENTER);

            restartFrame.setVisible(true);

            // タイマーで進捗バーを進める（99%で止まる）
            Timer timer = new Timer(200, ev -> {
                int value = progressBar.getValue();
                if (value < 99) {
                    progressBar.setValue(value + 1);
                } else {
                    // 99%で止まったらエラーダイアログを再度表示
                    JOptionPane.showMessageDialog(restartFrame, "ERROR！：頭脳の容量が足りていません");
                }
            });
            timer.start();
        });

        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}