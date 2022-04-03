/**
 * Copyright (C), 2015-2021, 京东
 * FileName: CollectionUtilsMain
 * Author:   codefans
 * Date:     2021/8/24 16:21
 * Description: CollectionUtils测试
 */
package com.codefans.opensource.commoncollections;


import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * CollectionUtils测试
 *
 * @author: codefans
 * @Date: 2021/08/24 16:21
 * @since: 1.0.0
 */
public class CollectionUtilsMain {

    public static void main(String[] args) {
        CollectionUtilsMain cum = new CollectionUtilsMain();
        cum.select();
    }

    public void select() {

        List<DataInfoVo> dataInfoVoList = this.generateList();
        List<DataInfoVo> resultList = (List<DataInfoVo>)CollectionUtils.select(dataInfoVoList, new Predicate<DataInfoVo>() {
            @Override
            public boolean evaluate(DataInfoVo data) {
                return data.isNew();
            }
        });
        this.print(resultList);

    }

    public List<DataInfoVo> generateList() {
        List<DataInfoVo> dataInfoVoList = new ArrayList<DataInfoVo>();
        DataInfoVo dataInfoVo = new DataInfoVo();
        dataInfoVo.setId(1001L);
        dataInfoVo.setName("zhangsan");
        dataInfoVo.setNew(true);

        DataInfoVo dataInfoVo2 = new DataInfoVo();
        dataInfoVo2.setId(1001L);
        dataInfoVo2.setName("zhangsan");
        dataInfoVo2.setNew(false);

        DataInfoVo dataInfoVo3 = new DataInfoVo();
        dataInfoVo3.setId(1001L);
        dataInfoVo3.setName("zhangsan");
        dataInfoVo3.setNew(true);

        dataInfoVoList.add(dataInfoVo);
        dataInfoVoList.add(dataInfoVo2);
        dataInfoVoList.add(dataInfoVo3);

        return dataInfoVoList;
    }

    public void print(List<DataInfoVo> dataList) {
        for(DataInfoVo data : dataList) {
            System.out.println(data);
        }
    }
}