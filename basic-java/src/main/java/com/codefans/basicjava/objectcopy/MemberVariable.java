package com.codefans.basicjava.objectcopy;

/**
 * @Author: codefans
 * @Date: 2020-07-12 12:53
 * 成员变量对象
 */

public class MemberVariable implements Cloneable {

    /**
     * 变量名称
     */
    private String variableName;

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
