package sakurai;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class test2 {
    public static void main(String[] args) {
        StartWindow();
    }

    // スタート画面
    public static void StartWindow() {
        JFrame startFrame = new JFrame("Javaお助けアプリ");
        startFrame.setSize(400, 300);
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setLayout(new BorderLayout());

        JTextField nameField = new JTextField(20);
        nameField.setFont(new Font("SansSerif", Font.PLAIN, 20));

        JButton startButton = new JButton("始める");
        startButton.setFont(new Font("SansSerif", Font.BOLD, 20));

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("名前を入力してください:"));
        panel.add(nameField);
        panel.add(startButton);

        startFrame.add(panel, BorderLayout.CENTER);
        startFrame.setLocationRelativeTo(null);
        startFrame.setVisible(true);

        // 始めるボタンの処理（ここで直接判定）
        startButton.addActionListener(e -> {
            String input = nameField.getText().trim();

            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(startFrame, "名前を入力してください");
            } else if (input.equals("田端太一")) {
                JOptionPane.showMessageDialog(startFrame, "エラー: IQが足りていません");
               Java_help_app_method.showRestartScreen();// 再起動画面へ
            } else {
                JOptionPane.showMessageDialog(startFrame, "入力された名前は登録されていません");
            }
        });
    }


}