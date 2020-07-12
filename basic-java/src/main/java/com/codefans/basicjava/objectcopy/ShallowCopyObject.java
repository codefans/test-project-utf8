package com.codefans.basicjava.objectcopy;

import java.util.Map;

/**
 * @Author: codefans
 * @Date: 2020-07-12 12:39
 */

public class ShallowCopyObject implements Cloneable {

    /**
     * 姓名
     */
    private String name;

    /**
     * 主键ID
     */
    private long id;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 扩展字段
     */
    private Map<String, String> extension;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Map<String, String> getExtension() {
        return extension;
    }

    public void setExtension(Map<String, String> extension) {
        this.extension = extension;
    }

    public MemberVariable getMemberVariable() {
        return memberVariable;
    }

    public void setMemberVariable(MemberVariable memberVariable) {
        this.memberVariable = memberVariable;
    }

    /**
     * 浅拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
