# SelectStateManager
这是一个简单强大的选择状态管理器，你可以使用它实现一组相同样式控件的状态改变控制。

![Animation](image/4.png)



 [你可以点击这里下载Demo.apk，亲自测试一下](https://github.com/KaiXuan666/SelectStateManager/blob/master/image/sample.apk?raw=true)
 （如果点击链接无法下载，你可以复制链接到你的下载工具，使用迅雷下载）

它可以减少你不必要的代码，将杂乱的代码抽取出来，为你节省大量的时间，如上图的效果，在Activity中只需要如下代码即可实现



```java
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
```



你可以实现如下几个方法，来对你的一组控件进行管理



```java
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
```



上面代码就是对图片中的第一排View所执行的控制操作，你可以用简单的实现方法来管理、控制一大堆相同样式的控件



```java
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
```



如果你设置了控件的状态选择器，请设置它们的select状态，这样就可以直接使用本库中的一个类SelectorHolderCreator，它提供了简单的实现，只改变控件的select状态，触发相应的状态选择器

SelectStateManager.parseViewGroup(ll_stadium_tv,0, new SelectorHolderCreator());

如果你觉得需要依赖一个库很不爽，或者你使用的是Eclipse，你可以选择使用单文件版，相比起来，它只缺少了一个SelectorHolderCreator

[点击这里查看单文件版](image/SelectStateManager.java)

