package ricecakesoftware.irasutoyarock_paper_scissors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * メインアクティビティー
 */
public class MainActivity extends AppCompatActivity {
    /** 手 */
    private enum Hand {
        /** ぐー */
        Rock,
        /** ちょき */
        Scissors,
        /** ぱー */
        Paper,
        /** 数 */
        Num,
    }

    /** 結果テキストビュー */
    private TextView resultText;
    /** 相手テキストビュー */
    private ImageView rivalImage;
    /** ぐーボタン */
    private ImageButton rockButton;
    /** ちょきボタン */
    private ImageButton scissorsButton;
    /** ぱーボタン */
    private ImageButton paperButton;

    /**
     * 作成
     * @param savedInstanceState 保存済インスタンス状態
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.resultText = findViewById(R.id.result_text);
        this.rivalImage = findViewById(R.id.rival_image);
        this.rockButton = findViewById(R.id.rock_button);
        this.scissorsButton = findViewById(R.id.scissors_button);
        this.paperButton = findViewById(R.id.paper_button);

        this.rockButton.setOnClickListener(new View.OnClickListener() {
            /**
             * クリック
             * @param view ビュー
             */
            @Override
            public void onClick(View view) { game(Hand.Rock); }
        });

        this.scissorsButton.setOnClickListener(new View.OnClickListener() {
            /**
             * クリック
             * @param view ビュー
             */
            @Override
            public void onClick(View view) { game(Hand.Scissors); }
        });

        this.paperButton.setOnClickListener(new View.OnClickListener() {
            /**
             * クリック
             * @param view ビュー
             */
            @Override
            public void onClick(View view) { game(Hand.Paper); }
        });
    }

    /**
     * ゲーム
     * @param own 自身の手
     */
    private void game(Hand own) {
        Hand rival = Hand.values()[(new Random()).nextInt(Hand.Num.ordinal())];
        switch (rival) {
            case Rock:
                this.rivalImage.setImageResource(R.drawable.janken_gu);
                break;
            case Scissors:
                this.rivalImage.setImageResource(R.drawable.janken_choki);
                break;
            case Paper:
                this.rivalImage.setImageResource(R.drawable.janken_pa);
                break;
            default:
                Log.e("game", "相手の手が範囲外です。");
                return;
        }

        if (rival == own) {
            this.resultText.setText(R.string.message_once);
        } else if ((own == Hand.Rock && rival == Hand.Scissors) || (own == Hand.Scissors && rival == Hand.Paper) || (own == Hand.Paper && rival == Hand.Rock)) {
            this.resultText.setText(R.string.message_win);
        } else {
            this.resultText.setText(R.string.message_lose);
        }
    }
}
