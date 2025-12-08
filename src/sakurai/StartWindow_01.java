package sakurai;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class StartWindow_01 {
    // スタート画面
    public static void StartWindow(Runnable onNext) {
        JFrame startFrame = new JFrame("Javaお助けアプリ");
        startFrame.setUndecorated(true);              // タイトルバーを消す
        startFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // フルスクリーン化
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setLayout(new BorderLayout());

        // 名前入力フィールド（フォントを大きく）
        JTextField nameField = new JTextField(20);
        nameField.setFont(new Font("SansSerif", Font.PLAIN, 24));

        // 中央配置用パネル
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        inputPanel.add(new JLabel("名前を入力してください:"), gbc);

        gbc.gridy = 1;
        inputPanel.add(nameField, gbc);

        // 始めるボタン
        JButton startButton = new JButton("始める");
        startButton.setFont(new Font("SansSerif", Font.BOLD, 20));

        startButton.addActionListener(e -> {
            String name = nameField.getText();
            Object input = name;
			if (((String) input).isEmpty()) {
                
            } else if (input.equals("田端太一")) {
                JOptionPane.showMessageDialog(startFrame, "エラー: IQが足りていません。\n再起動が必要です。");
               Java_help_app_method.showRestartScreen();// 再起動画面へ
            } else {
                
         // 2ページ目のウィンドウ
            JFrame nextFrame = new JFrame("別ウィンドウ");
            nextFrame.setUndecorated(true);
            nextFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            nextFrame.setLayout(new GridBagLayout()); // 中央配置に変更

            GridBagConstraints gbc2 = new GridBagConstraints();
            gbc2.gridx = 0;
            gbc2.insets = new Insets(20, 20, 20, 20);
            gbc2.anchor = GridBagConstraints.CENTER;

            // 挨拶ラベル
            JLabel helloLabel = new JLabel("こんにちは、" + name + " さん！");
            helloLabel.setFont(new Font("SansSerif", Font.BOLD, 28)); // 大きめ文字
            gbc2.gridy = 0;
            nextFrame.add(helloLabel, gbc2);

            JLabel infoLabel = new JLabel("Javaのコードの事なら任せてね！");
            infoLabel.setFont(new Font("SansSerif", Font.PLAIN, 24));
            gbc2.gridy = 1;
            nextFrame.add(infoLabel, gbc2);

            JLabel askLabel = new JLabel("作りたいプログラムを教えて！");
            askLabel.setFont(new Font("SansSerif", Font.PLAIN, 24));
            gbc2.gridy = 2;
            nextFrame.add(askLabel, gbc2);

            // 入力欄
            JTextField programField = new JTextField(20);
            programField.setFont(new Font("SansSerif", Font.PLAIN, 24)); // 入力文字も大きく
            gbc2.gridy = 3;
            nextFrame.add(programField, gbc2);

            // ボタン
            JButton goNext = new JButton("コードを作成");
            goNext.setFont(new Font("SansSerif", Font.BOLD, 22));
            gbc2.gridy = 4;
            nextFrame.add(goNext, gbc2);

            goNext.addActionListener(ev -> {
                nextFrame.dispose();
                onNext.run(); // 次のページへ
            });

            nextFrame.setVisible(true);
            startFrame.dispose();
            }
        });

        startFrame.add(inputPanel, BorderLayout.CENTER);
        startFrame.add(startButton, BorderLayout.SOUTH);
        startFrame.setVisible(true);
    }

    // ローディング画面
    public static void Loading(Runnable onNext) {
        JFrame frame = new JFrame("Attention！！！");
        frame.setUndecorated(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());
        JLabel question = new JLabel("本当に人間ですか？", SwingConstants.CENTER);
        question.setFont(new Font("SansSerif", Font.BOLD, 28));
        frame.add(question, BorderLayout.NORTH);

        JButton runButton = new JButton("はい、私は人間です");
        runButton.setFont(new Font("SansSerif", Font.BOLD, 24));
        frame.add(runButton, BorderLayout.CENTER);

        runButton.addActionListener(e -> {
            JFrame loadingFrame = new JFrame("処理中");
            loadingFrame.setUndecorated(true);
            loadingFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

            JLabel label = new JLabel("作成中・・・", SwingConstants.CENTER);
            label.setFont(new Font("SansSerif", Font.BOLD, 48));
            loadingFrame.add(label);
            loadingFrame.setVisible(true);

            // 4秒後にエラーダイアログを表示
            Timer timer = new Timer(4000, evt -> {
                // カスタムエラーダイアログを表示
                JFrame errorDialog = new JFrame("ERROR！");
                errorDialog.setSize(600, 200);
                errorDialog.setLocationRelativeTo(null);
                errorDialog.setLayout(new BorderLayout());
                errorDialog.getContentPane().setBackground(Color.BLACK);

                //×ボタンを無効化
                errorDialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

                JLabel errorLabel = new JLabel("ERROR: IQが足りていません、再起動が必要です", SwingConstants.CENTER);
                errorLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
                errorLabel.setForeground(Color.RED);
                errorDialog.add(errorLabel, BorderLayout.CENTER);

                JButton okButton = new JButton("OK");
                okButton.setFont(new Font("SansSerif", Font.BOLD, 18));
                okButton.setForeground(Color.WHITE);
                okButton.setBackground(Color.DARK_GRAY);

                okButton.addActionListener(ev -> {
                    errorDialog.dispose();
                    onNext.run(); // 次のページへ移動
                });
                errorDialog.add(okButton, BorderLayout.SOUTH);

                errorDialog.setVisible(true);
            });
            timer.setRepeats(false);
            timer.start();
        });

        frame.setVisible(true);
    }
}