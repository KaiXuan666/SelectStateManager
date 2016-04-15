package com.kxrjkf.selectstatemanager.Interface;

/**
 * Created by KaiXuan on 2016/4/15.
 */

/**
 * Holder创建器，泛型指定你要创建的Holder
 * @param <Holder>
 */
public interface HolderCreator<Holder> {
    public Holder createHolder();
}

