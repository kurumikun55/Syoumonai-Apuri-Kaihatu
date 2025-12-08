package sakurai;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
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
    private static int popupCount = 0; // 小ポップアップの数をカウント

    public static void JavaHelpApp(JFrame parent) {
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
    	    popupCount++;

    	    if (popupCount >= 15) {
    	        showPanicScreen(); // 15以上ならPanicScreenへ
    	        return;
    	    }

    	    // 画面サイズを取得
    	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	    int screenWidth = screenSize.width;
    	    int screenHeight = screenSize.height;

    	    JFrame small = new JFrame("ERROR！");
    	    small.setSize(200, 100);

    	    // 画面内のランダム位置に配置
    	    int x = (int) (Math.random() * (screenWidth - small.getWidth()));
    	    int y = (int) (Math.random() * (screenHeight - small.getHeight()));
    	    small.setLocation(x, y);

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


    // 焦るような画面
    static void showPanicScreen() {
        JFrame panic = new JFrame("警告");
        panic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panic.setUndecorated(true);
        panic.setExtendedState(JFrame.MAXIMIZED_BOTH);
        panic.setLayout(new BorderLayout());

        JLabel label = new JLabel("システムが制御不能です", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 60));
        label.setForeground(Color.RED);

        panic.getContentPane().setBackground(Color.BLACK);
        panic.add(label, BorderLayout.CENTER);

        panic.setVisible(true);

        // 3秒後に大量のエラーポップアップを出す
        Timer virusTimer = new Timer(3000, e -> {
            for (int i = 0; i < 100; i++) {
                createVirusPopup();
            }
        });
        virusTimer.setRepeats(false);
        virusTimer.start();
    }


    // ウイルスメッセージ付きポップアップ
    private static void createVirusPopup() {
        // 画面サイズを取得
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        JFrame virus = new JFrame("ERROR！ウイルス検出");
        virus.setSize(300, 150);

        // 画面内のランダム位置に配置
        int x = (int) (Math.random() * (screenWidth - virus.getWidth()));
        int y = (int) (Math.random() * (screenHeight - virus.getHeight()));
        virus.setLocation(x, y);

        virus.setLayout(new BorderLayout());

        JLabel msg = new JLabel("ファイルが破損しています", SwingConstants.CENTER);
        msg.setFont(new Font("SansSerif", Font.BOLD, 18));
        msg.setForeground(Color.RED);

        virus.add(msg, BorderLayout.CENTER);

        JButton ok = new JButton("OK");
        ok.addActionListener(ev -> {
            // OKを押しても閉じない
        });
        virus.add(ok, BorderLayout.SOUTH);

        virus.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        virus.setVisible(true);
    }
}