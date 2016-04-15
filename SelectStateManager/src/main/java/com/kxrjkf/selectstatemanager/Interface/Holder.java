package com.kxrjkf.selectstatemanager.Interface;

/**
 * Created by KaiXuan on 2016/4/15.
 */

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