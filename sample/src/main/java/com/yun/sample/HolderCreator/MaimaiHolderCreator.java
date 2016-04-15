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
public class MaimaiHolderCreator implements HolderCreator{
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
                textView.setTextColor(Color.parseColor("#2E95FF"));
                switch (position) {
                    case 0:
                        imageView.setImageResource(R.drawable.mm_feeds_select);
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.mm_talk_select);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.mm_contacts_select);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.mm_myself_select);
                        break;
                }
                return true;
            }

            @Override
            public boolean OnUnSelect(LinearLayout o, int position) {
                textView.setTextColor(Color.parseColor("#808080"));
                switch (position) {
                    case 0:
                        imageView.setImageResource(R.drawable.mm_feeds_normal);
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.mm_talk_normal);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.mm_contacts_normal);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.mm_myself_normal);
                        break;
                }
                return true;
            }
        };
    }
}
