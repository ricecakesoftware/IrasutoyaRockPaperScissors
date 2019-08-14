package jp.ricecakesoftware.irasutoyarock_paper_scissors.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.view.View;

import java.util.Random;

import jp.ricecakesoftware.irasutoyarock_paper_scissors.BR;
import jp.ricecakesoftware.irasutoyarock_paper_scissors.R;

/**
 * メインビューモデル
 */
public class MainViewModel extends BaseObservable {
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

    /** 結果 */
    private int result;
    /** 相手画像 */
    private int rivalImage;

    /**
     * コンストラクター
     * @param result 結果
     * @param rivalImage 相手画像
     */
    public MainViewModel(int result, int rivalImage) {
        this.result = result;
        this.rivalImage = rivalImage;
    }

    /**
     * ぐークリック
     * @param view ビュー
     */
    public void onClickRock(View view) { game(Hand.Rock); }

    /**
     * ちょきクリック
     * @param view ビュー
     */
    public void onClickScissors(View view) { game(Hand.Scissors); }

    /**
     * ぱークリック
     * @param view ビュー
     */
    public void onClickPaper(View view) { game(Hand.Paper); }

    /**
     * ゲーム
     * @param own 自身の手
     */
    private void game(Hand own) {
        Hand rival = Hand.values()[(new Random()).nextInt(Hand.Num.ordinal())];
        switch (rival) {
            case Rock:
                setRivalImage(R.drawable.janken_gu);
                break;
            case Scissors:
                setRivalImage(R.drawable.janken_choki);
                break;
            case Paper:
                setRivalImage(R.drawable.janken_pa);
                break;
            default:
                Log.e("game", "相手の手が範囲外です。");
                return;
        }

        if (rival == own) {
            setResult(R.string.message_once);
        } else if ((own == Hand.Rock && rival == Hand.Scissors) || (own == Hand.Scissors && rival == Hand.Paper) || (own == Hand.Paper && rival == Hand.Rock)) {
            setResult(R.string.message_win);
        } else {
            setResult(R.string.message_lose);
        }
    }

    /**
     * 結果取得
     * @return 結果
     */
    @Bindable
    public int getResult() {
        return this.result;
    }

    /**
     * 結果設定
     * @param result 結果
     */
    private void setResult(int result) {
        this.result = result;
        notifyPropertyChanged(BR.result);
    }

    /**
     * 相手画像取得
     * @return 相手画像
     */
    @Bindable
    public int getRivalImage() {
        return this.rivalImage;
    }

    /**
     * 相手画像設定
     * @param rivalImage 相手画像
     */
    private void setRivalImage(int rivalImage) {
        this.rivalImage = rivalImage;
        notifyPropertyChanged(BR.rivalImage);
    }
}
