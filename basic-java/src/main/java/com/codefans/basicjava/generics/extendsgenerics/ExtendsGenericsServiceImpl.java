package com.codefans.basicjava.generics.extendsgenerics;


import java.util.List;

/**
 * @author: codefans
 * @date: 2019-01-10 10:07:24
 */
public class ExtendsGenericsServiceImpl implements ExtendsGenericsService {


    @Override
    public List<? extends InfoBase> toList(List<? extends InfoBase> list) {

        System.out.println("ExtendsGenericsServiceImpl");

        return list;
    }



}
