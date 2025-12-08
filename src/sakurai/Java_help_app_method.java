package sakurai;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Java_help_app_method {

    private static boolean popupEnabled = false;

    // 親フレームを指定してエラーダイアログを出す
    public static void JavaHelpApp(JFrame parent) {

        // OKを押したら再起動画面へ
        showRestartScreen();
    } 

    // 再起動風のフルスクリーン画面
    static void showRestartScreen() {
        JFrame restartFrame = new JFrame("偽の再起動アプリ");
        restartFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        restartFrame.setUndecorated(true);
        restartFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        restartFrame.setLayout(new BorderLayout());

        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        JLabel label = new JLabel("再起動中…", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 40));
        label.setForeground(Color.WHITE);

        restartFrame.getContentPane().setBackground(Color.BLACK);
        progressBar.setBackground(Color.BLACK);
        progressBar.setForeground(Color.GREEN);

        restartFrame.add(progressBar, BorderLayout.SOUTH);
        restartFrame.add(label, BorderLayout.CENTER);

        restartFrame.setVisible(true);

        // 進捗バーを進める
        Timer timer = new Timer(200, ev -> {
            int value = progressBar.getValue();
            if (value < 99) {
                progressBar.setValue(value + 1);
            } else {
                if (!popupEnabled) {
                    Timer delayTimer = new Timer(5000, evt2 -> {
                        showNoCloseDialog(restartFrame);
                    });
                    delayTimer.setRepeats(false);
                    delayTimer.start();
                    popupEnabled = true;
                }
            }
        });
        timer.start();
    }

    // エラーダイアログ（閉じられない）
    private static void showNoCloseDialog(JFrame parent) {
        JFrame dialog = new JFrame("ERROR！");
        dialog.setSize(400, 180);
        dialog.setLocationRelativeTo(parent);
        dialog.setLayout(new BorderLayout());
        dialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JLabel label = new JLabel("ERROR！：頭脳の容量が足りていません", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 16));
        dialog.add(label, BorderLayout.CENTER);

        JButton ok = new JButton("OK");
        ok.addActionListener(e -> {
            // OKでも閉じない
        });
        dialog.add(ok, BorderLayout.SOUTH);

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                for (int i = 0; i < 3; i++) {
                    createSmallPopup();
                }
            }
        });

        dialog.setVisible(true);
    }

    // 小ポップアップ
    private static void createSmallPopup() {
        JFrame small = new JFrame("ERROR！");
        small.setSize(200, 100);
        small.setLocation((int) (Math.random() * 800), (int) (Math.random() * 600));
        small.add(new JLabel("勉強しましょう", SwingConstants.CENTER));
        small.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        small.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                for (int i = 0; i < 3; i++) {
                    createSmallPopup();
                }
            }
        });

        small.setVisible(true);
    }
}