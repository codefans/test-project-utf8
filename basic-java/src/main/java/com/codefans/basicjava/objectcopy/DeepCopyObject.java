package com.codefans.basicjava.objectcopy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: codefans
 * @Date: 2020-07-12 13:07
 * 深度拷贝对象
 */

public class DeepCopyObject implements Cloneable {

    /**
     * 姓名
     */
    private String name;

    /**
     * 主键ID
     */
    private int id;

    /**
     * 钱
     */
    private Float money;

    /**
     * 扩展字段
     */
    private List<String> extension;

    /**
     * 成员变量
     */
    private MemberVariable memberVariable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public List<String> getExtension() {
        return extension;
    }

    public void setExtension(List<String> extension) {
        this.extension = extension;
    }

    public MemberVariable getMemberVariable() {
        return memberVariable;
    }

    public void setMemberVariable(MemberVariable memberVariable) {
        this.memberVariable = memberVariable;
    }

    /**
     * 深拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepCopyObject newDeepCopyObj = (DeepCopyObject) super.clone();

        List<String> newExtension = null;
        if(extension instanceof ArrayList) {
            newExtension = (List<String>) ((ArrayList)extension).clone();
        }
        if(extension instanceof LinkedList) {
            newExtension = (List<String>) ((LinkedList)extension).clone();
        }
        newDeepCopyObj.setExtension(newExtension);

        MemberVariable newMemberVariable = (MemberVariable) memberVariable.clone();
        newDeepCopyObj.setMemberVariable(newMemberVariable);

        return newDeepCopyObj;
    }
}
