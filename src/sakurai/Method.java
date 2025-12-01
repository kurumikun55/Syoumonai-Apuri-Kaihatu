package sakurai;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Method {
    public void start() {
        JFrame frame = new JFrame("デモアプリ");
        frame.setUndecorated(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("Hello 太一", JLabel.CENTER);
        label.setFont(new Font("Serif", Font.PLAIN, 250));
        frame.add(label, BorderLayout.CENTER);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton loginButton = new JButton("ログイン");
        topPanel.add(loginButton);
        frame.add(topPanel, BorderLayout.NORTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        loginButton.addActionListener((ActionEvent e) -> {
            JFrame jFrame = new JFrame("Java Example");
            jFrame.setSize(400, 400);
            jFrame.setLayout(new FlowLayout());

            JTextField jTextField = new JTextField(20);
            JButton jButton = new JButton("Submit");
            JLabel jLabel = new JLabel();

            jButton.addActionListener(ev -> {
                String input = jTextField.getText().trim(); // 入力を取得して前後の空白を除去

                if (input.isEmpty()) {
                    jLabel.setText("名前を入力してください");
                } else if (input.equals("田端太一")) {
                    jLabel.setText("田端太一さん、勉強しろ！！");
                } else if (input.equals("馬場啓太")) {
                    jLabel.setText("馬場啓太、勉強しろ！！");
                } else if (input.equals("服部愛星")) {
                    jLabel.setText("まなせ、勉強しろ！！");
                } else {
                    jLabel.setText("入力された名前は登録されていません");
                }
            });

            jFrame.add(jTextField);
            jFrame.add(jButton);
            jFrame.add(jLabel);
            jFrame.setVisible(true);
        });
    }
}

