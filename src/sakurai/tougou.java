package sakurai;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class tougou {

	// 99% 到達したかどうかのフラグ
	private static boolean popupEnabled = false;

	public static void main(String[] args) {

		// 最初のフレーム
		JFrame frame = new JFrame("javaコード作成");
		JButton button = new JButton("javaのコードを作成するよ！");

		// ボタンが押されたら……
		button.addActionListener(e -> {

			JOptionPane.showMessageDialog(frame, "エラー: IQが足りていません");

			// 再起動風のフルスクリーンフレーム
			JFrame restartFrame = new JFrame("偽の再起動アプリ");
			restartFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			restartFrame.setUndecorated(true);
			restartFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			restartFrame.setLayout(new BorderLayout());

			// 進捗バー
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

			// 進捗バー進行（99% 到達でフラグを ON にする）
			Timer timer = new Timer(200, ev -> {
				int value = progressBar.getValue();
				if (value < 99) {
					progressBar.setValue(value + 1);
				} else {
					{
						if (!popupEnabled) {

							//  5秒後にダイアログを表示
							Timer delayTimer = new Timer(5000, evt2 -> {
								showNoCloseDialog(restartFrame);
							});
							delayTimer.setRepeats(false); // 1回だけ実行
							delayTimer.start();

							popupEnabled = true;//増殖可能にする
						}
					}
				}
			});
			timer.start();

			// × を押したら？
			restartFrame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {

					if (popupEnabled) { // 99% 到達していれば増殖！
						for (int i = 0; i < 3; i++) {
							createPopup();
						}
					} else {
						// 99%未満なら閉じてほしくないだけ
						JOptionPane.showMessageDialog(restartFrame,
								"システム再起動中です…");
					}

				}
			});
		});

		frame.add(button);
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	// メインポップアップ（×で3つ増える）
	private static void createPopup() {
		JFrame frame = new JFrame("ERROR！");
		frame.setSize(300, 160);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());

		// メッセージ
		JLabel label = new JLabel("勉強をしましょう", SwingConstants.CENTER);
		frame.add(label, BorderLayout.CENTER);

		// OKボタン
		JButton okButton = new JButton("OK");
		frame.add(okButton, BorderLayout.SOUTH);

		// OK を押しても閉じない
		okButton.addActionListener(e -> {
			// ここに好きな処理を追加できる
			// 例: もっと増やすなど
			createSmallPopup();
		});

		// × を押しても閉じない
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

	// 小ポップアップ（×で3つ増える）
	private static void createSmallPopup() {
		JFrame small = new JFrame("ERROR！");
		small.setSize(200, 100);

		small.setLocation(
				(int) (Math.random() * 800),
				(int) (Math.random() * 600));

		small.add(new JLabel("勉強しましょう", SwingConstants.CENTER));
		small.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		small.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				for (int i = 0; i < 3; i++) {
					createSmallPopup();//ポップアップ増やす
				}
			}
		});

		small.setVisible(true);
	}// OK を押しても閉じないカスタムエラーダイアログ

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
			// OK でも閉じない
		});
		dialog.add(ok, BorderLayout.SOUTH);

		//  × を押したときの増殖処理
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// ここで好きな増え方にできる
				for (int i = 0; i < 3; i++) {
					createSmallPopup(); // 小ポップアップ3つ出す
				}
			}
		});

		dialog.setVisible(true);
	}
}
