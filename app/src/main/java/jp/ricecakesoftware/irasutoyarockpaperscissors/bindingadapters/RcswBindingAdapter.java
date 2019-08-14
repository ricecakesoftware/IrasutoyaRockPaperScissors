package jp.ricecakesoftware.irasutoyarockpaperscissors.bindingadapters;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * バインディングアダプター
 */
public class RcswBindingAdapter {
    /**
     * ImageViewResource設定
     * @param imageView ImageView
     * @param resId リソースID
     */
    @BindingAdapter("android:src")
    public static void setImageViewResource(ImageView imageView, int resId) {
        imageView.setImageResource(resId);
    }

    /**
     * Text設定
     * @param textView TextView
     * @param resId リソースID
     */
    @BindingAdapter("android:text")
    public static void setText(TextView textView, int resId) {
        textView.setText(resId);
    }
}
