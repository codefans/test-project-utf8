package com.codefans.basicjava.generics.extendsgenerics;

import java.util.List;

/**
 * @author: codefans
 * @date: 2019-01-10 10:05:52
 */
public interface ExtendsGenericsService {

    public List<? extends InfoBase> toList(List<? extends InfoBase> list);


}
