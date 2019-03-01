package com.codefans.reusablecode.unittest.mock.model;

/**
 * @author: codefans
 * @date: 2019-03-01 10:42:16
 */
public class ElementResult {

    private String idNo;

    private String name;

    private Long age;

    private String addr;

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "ElementResult{" +
                "idNo='" + idNo + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }
}
