package com.kxrjkf.selectstatemanager.creator;

import android.view.View;

import com.kxrjkf.selectstatemanager.Interface.Holder;
import com.kxrjkf.selectstatemanager.Interface.HolderCreator;

/**
 * Created by KaiXuan on 2016/4/14.
 */

/**
 * HolderCreator的简单实现，用于给设置了状态选择器的控件使用
 */
public class SelectorHolderCreator implements HolderCreator<SelectorHolderCreator.SelectorHolder> {
    @Override
    public SelectorHolder createHolder() {
        return new SelectorHolder();
    }

    public class SelectorHolder implements Holder<View> {

        @Override
        public void addView(View rootView,int position) {

        }

        @Override
        public boolean OnSelect(View o, int position) {
            return true;
        }

        @Override
        public boolean OnUnSelect(View o, int position) {
            return true;
        }
    }
}
