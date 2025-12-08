package test1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Test1 {

    private static boolean popupEnabled = false;

    public static void main(String[] args) {
        // 最初のフレーム
        JFrame frame = new JFrame("javaコード作成");
        JButton button = new JButton("javaのコードを作成するよ！");
        frame.add(button, BorderLayout.CENTER);

        button.addActionListener(e -> {
            JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton loginButton = new JButton("ログイン");
            topPanel.add(loginButton);
            frame.add(topPanel, BorderLayout.NORTH);

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            loginButton.addActionListener(ev -> showLoginFrame(frame));
        });

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // ログイン用フレーム
    private static void showLoginFrame(JFrame parent) {
        JFrame jFrame = new JFrame("Java Example");
        jFrame.setSize(400, 400);
        jFrame.setLayout(new FlowLayout());

        JTextField jTextField = new JTextField(20);
        JButton jButton = new JButton("Submit");
        JLabel jLabel = new JLabel();

        jButton.addActionListener(ev -> {
            String input = jTextField.getText().trim();

            if (input.isEmpty()) {
                jLabel.setText("名前を入力してください");
            } else if (input.equals("田端太一")) {
                JOptionPane.showMessageDialog(parent, "エラー: IQが足りていません");
                showRestartFrame();
            } else {
                jLabel.setText("入力された名前は登録されていません");
            }
        });

        jFrame.add(jTextField);
        jFrame.add(jButton);
        jFrame.add(jLabel);
        jFrame.setVisible(true);
    }

    // 再起動風フレーム
    private static void showRestartFrame() {
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

        Timer timer = new Timer(200, ev -> {
            int value = progressBar.getValue();
            if (value < 99) {
                progressBar.setValue(value + 1);
            } else {
                if (!popupEnabled) {
                    Timer delayTimer = new Timer(5000, evt2 -> showNoCloseDialog(restartFrame));
                    delayTimer.setRepeats(false);
                    delayTimer.start();
                    popupEnabled = true;
                }
            }
        });
        timer.start();

        restartFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (popupEnabled) {
                    for (int i = 0; i < 3; i++) {
                        createPopup();
                    }
                } else {
                    JOptionPane.showMessageDialog(restartFrame, "システム再起動中です…");
                }
            }
        });
    }

    // 大ポップアップ
    private static void createPopup() {
        JFrame frame = new JFrame("ERROR！");
        frame.setSize(300, 160);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("勉強をしましょう", SwingConstants.CENTER);
        frame.add(label, BorderLayout.CENTER);

        JButton okButton = new JButton("OK");
        frame.add(okButton, BorderLayout.SOUTH);

        okButton.addActionListener(e -> createSmallPopup());

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                for (int i = 0; i < 3; i++) {
                    createSmallPopup();
                }
            }
        });

        frame.setVisible(true);
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

    // エラーダイアログ
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
}