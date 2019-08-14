package jp.ricecakesoftware.irasutoyarockpaperscissors.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import jp.ricecakesoftware.irasutoyarockpaperscissors.R;
import jp.ricecakesoftware.irasutoyarockpaperscissors.databinding.ActivityMainBinding;
import jp.ricecakesoftware.irasutoyarockpaperscissors.viewmodels.MainViewModel;

/**
 * メインアクティビティー
 */
public class MainActivity extends AppCompatActivity {
    /**
     * 作成
     * @param savedInstanceState 保存済インスタンス状態
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(new MainViewModel(R.string.message_init, R.drawable.janken_boys));
    }
}
