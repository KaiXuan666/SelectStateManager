package com.yun.sample.HolderCreator;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kxrjkf.selectstatemanager.Interface.Holder;
import com.kxrjkf.selectstatemanager.Interface.HolderCreator;
import com.yun.sample.bean.MyTime;

/**
 * Created by KaiXuan on 2016/4/14.
 */
public class NumberSelectTabHolderCreator implements HolderCreator<NumberSelectTabHolderCreator.NumberSelectTabHolder> {

    MyTime qqTime;

    public NumberSelectTabHolderCreator(MyTime qqTime) {
        this.qqTime = qqTime;
    }

    @Override
    public NumberSelectTabHolder createHolder() {
        return new NumberSelectTabHolder(qqTime);
    }

    public class NumberSelectTabHolder implements Holder<LinearLayout> {
        TextView tvDay;
        TextView tvMonth;
        MyTime qqTime;

        public NumberSelectTabHolder(MyTime qqTime) {
            this.qqTime = qqTime;
        }

        @Override
        public void addView(LinearLayout rootView, int po) {
            tvDay = (TextView) (rootView.getChildAt(0));
            tvDay.setText(qqTime.week[po]);
            tvMonth = (TextView) (rootView.getChildAt(1));
            tvMonth.setText(qqTime.mmdd[po]);
        }

        @Override
        public boolean OnSelect(LinearLayout o, int position) {
            tvDay.setTextColor(Color.parseColor("#6BD949"));
            tvMonth.setTextColor(Color.parseColor("#6BD949"));
            return true;
        }

        @Override
        public boolean OnUnSelect(LinearLayout o, int position) {
            tvDay.setTextColor(Color.parseColor("#7A7A7A"));
            tvMonth.setTextColor(Color.parseColor("#7A7A7A"));
            return true;
        }
    }
}
