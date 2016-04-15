package com.yun.sample.HolderCreator;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kxrjkf.selectstatemanager.Interface.Holder;
import com.kxrjkf.selectstatemanager.Interface.HolderCreator;
import com.yun.sample.R;

/**
 * Created by KaiXuan on 2016/4/15.
 */
public class MzwHolderCreator implements HolderCreator{
    public Object createHolder() {
        return new Holder<LinearLayout>() {
            ImageView imageView;
            TextView textView;
            @Override
            public void addView(LinearLayout rootView, int position) {
                imageView = (ImageView) rootView.getChildAt(0);
                textView = (TextView) rootView.getChildAt(1);
            }
            @Override
            public boolean OnSelect(LinearLayout o, int position) {
                textView.setTextColor(Color.parseColor("#5DB86B"));
                switch (position) {
                    case 0:
                        imageView.setImageResource(R.drawable.mzw_selected_pressed);
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.mzw_online_pressed);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.mzw_rank_pressed);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.mzw_category_pressed);
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.mzw_manager_pressed);
                        break;
                }
                return true;
            }

            @Override
            public boolean OnUnSelect(LinearLayout o, int position) {
                textView.setTextColor(Color.parseColor("#808080"));
                switch (position) {
                    case 0:
                        imageView.setImageResource(R.drawable.mzw_selected_normal);
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.mzw_online_normal);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.mzw_rank_normal);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.mzw_category_normal);
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.mzw_manager_normal);
                        break;
                }                return true;
            }
        };
    }
}
