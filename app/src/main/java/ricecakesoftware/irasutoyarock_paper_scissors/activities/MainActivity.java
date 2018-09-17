package ricecakesoftware.irasutoyarock_paper_scissors.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import ricecakesoftware.irasutoyarock_paper_scissors.R;
import ricecakesoftware.irasutoyarock_paper_scissors.databinding.ActivityMainBinding;
import ricecakesoftware.irasutoyarock_paper_scissors.viewmodels.MainViewModel;

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
