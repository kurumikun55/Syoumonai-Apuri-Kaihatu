package sample;

import sakurai.Java_help_app_method;
import sakurai.StartWindow_01;

public class Java_help {
    private static int page = 0; // ページ変数

    public static void main(String[] args) {
        showPage(); // 最初のページを表示
    }

    // ページ番号に応じて画面を切り替える
    public static void showPage() {
        switch (page) {
            case 0:
                StartWindow_01.StartWindow(() -> {
                    page = 1;
                    showPage();
                });
                break;
            case 1:
                StartWindow_01.Loading(() -> {
                    page = 2;
                    showPage();
                });
                break;
            case 2:
                Java_help_app_method.JavaHelpApp(null);
                break;
        }
    }
}