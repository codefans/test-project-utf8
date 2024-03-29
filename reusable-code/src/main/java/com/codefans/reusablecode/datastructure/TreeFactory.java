package com.codefans.reusablecode.datastructure;

/**
 * @author: codefans
 * @date: 2017-09-28 10:52
 */
public interface TreeFactory<T> {

    /**
     * 创建创建树
     * @param treeType
     * @return
     */
    public T create(String treeType);

}
