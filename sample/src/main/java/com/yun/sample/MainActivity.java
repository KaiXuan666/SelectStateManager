package com.yun.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.kxrjkf.selectstatemanager.SelectStateManager;
import com.yun.sample.HolderCreator.MaimaiHolderCreator;
import com.yun.sample.HolderCreator.MzwHolderCreator;
import com.yun.sample.HolderCreator.NumberSelectTabHolderCreator;
import com.yun.sample.HolderCreator.QuyundongHolderCreator;
import com.yun.sample.bean.MyTime;
import com.yun.sample.utils.Times;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout maimai = (LinearLayout) findViewById(R.id.maimai);
        LinearLayout quyundong = (LinearLayout) findViewById(R.id.quyundong);
        LinearLayout mzw = (LinearLayout) findViewById(R.id.mzw);
        LinearLayout tab = (LinearLayout) findViewById(R.id.tab);

        SelectStateManager.parseViewGroup(maimai, 0, new MaimaiHolderCreator());
        SelectStateManager.parseViewGroup(quyundong, 0, new QuyundongHolderCreator());
        SelectStateManager.parseViewGroup(mzw, 0, new MzwHolderCreator());
        Date date = new Date();
        SelectStateManager.parseViewGroup(tab, 0, new NumberSelectTabHolderCreator(
                new MyTime(Times.getMMDDDate(date, 0), Times.getWeekOfDate(date, 0))));


    }
}
