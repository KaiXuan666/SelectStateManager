package com.cmcc.zebra.biz;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * 用于一堆相同控件的选择状态管理
 * Created by KaiXuan on 2016/4/13.
 */
public class SelectStateManager<T extends View> extends ArrayList<T> {

    private int index;
    ArrayList<Holder> list = new ArrayList();
    private HolderCreator holderCreator;

    public SelectStateManager() {}


    /**
     * 解析一个父View容器
     * @param viewGroup 欲解析的ViewGroup
     * @param index 默认选择第几项
     * @param holderCreator holder构造器
     * @return
     */
    public static  SelectStateManager parseViewGroup(ViewGroup viewGroup, int index,HolderCreator holderCreator) {
        return SelectStateManager.parseViewGroup(viewGroup,View.class,index,holderCreator);
    }
    /**
     * 解析一个父View容器
     * @param viewGroup 欲解析的ViewGroup
     * @param e 下级View的泛型，可以不传
     * @param index 默认选择第几项
     * @param holderCreator holder构造器
     * @return
     */
    public static <E extends View>  SelectStateManager parseViewGroup(ViewGroup viewGroup,Class<E> e, int index,HolderCreator holderCreator) {
        SelectStateManager<E> selectStateManager = new SelectStateManager<E>();
        selectStateManager.parseMe(viewGroup, index, holderCreator);
        return selectStateManager;
    }

    public SelectStateManager parseMe(ViewGroup viewGroup, int index,HolderCreator holderCreator){
        this.holderCreator = holderCreator;
        for (int x = 0; x < viewGroup.getChildCount(); x++) {
            this.add((T)viewGroup.getChildAt(x));
        }
        check(index);
        return this;
    }


    @Override
    public boolean add(final T object) {
        Holder holder = (Holder) holderCreator.createHolder();
        holder.addView(object,size());

        list.add(holder);
        object.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        select(object);
                    }
                }
        );
        return super.add(object);
    }

    public void select(T t) {
        if (getCurrentSelect().equals(t)){
            return;
        }
        int temp = indexOf(t);
        if (temp != -1) {
            // 先取消上一个的选中状态
            get(index).setSelected(false);
            if (!list.get(index).OnUnSelect(get(index), index)) {
                get(index).setSelected(true);
            }
            index = temp;
            t.setSelected(true);
            if (!list.get(index).OnSelect(get(index), index)) {
                t.setSelected(false);
            }
        }
    }

    public void check(int index){
        get(index).setSelected(true);
        list.get(index).OnSelect(get(index),index);
    }

    /**
     * 获得当前选择的view
     *
     * @return
     */
    public T getCurrentSelect() {
        return get(index);
    }

    /**
     * 获得当前索引
     *
     * @return
     */
    public int getCurrentIndex() {
        return index;
    }

    /**
     * Holder创建器，泛型指定你要创建的Holder
     * @param <Holder>
     */
    public interface HolderCreator<Holder> {
        public Holder createHolder();
    }

    /**
     * Holder
     * @param <T> ViewGroup下一级的子控件的类型
     */
    public interface Holder<T> {
        /**
         * 你可以在该方法中寻找你需要操作的子控件，并定义成员变量引用他们，以便于在选择或取消选择时直接操作该子View
         * @param rootView
         */
        void addView(T rootView, int position);

        /**
         * view被选择时调用此方法，返回true，表示同意选取，返回false，则选择失败
         *
         * @param t        被选择的view
         * @param position 位置
         * @return
         */
        boolean OnSelect(T t, int position);

        /**
         * view被取消选择时调用此方法，返回true，表示同意取消选择，返回false，则取消选择失败
         *
         * @param t        被取消选择的view
         * @param position 位置
         * @return
         */
        boolean OnUnSelect(T t, int position);
    }



}
