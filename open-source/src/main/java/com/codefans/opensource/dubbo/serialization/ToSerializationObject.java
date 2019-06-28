package com.codefans.opensource.dubbo.serialization;

import java.io.Serializable;

/**
 * @author: codefans
 * @date: 2019-06-26 20:37
 */
public class ToSerializationObject implements Serializable {

    private int i;

    private char c;

    private boolean b;

    private float f;

    private double d;

    private byte aByte;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public float getF() {
        return f;
    }

    public void setF(float f) {
        this.f = f;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public byte getaByte() {
        return aByte;
    }

    public void setaByte(byte aByte) {
        this.aByte = aByte;
    }

    @Override
    public String toString() {
        return "ToSerializationObject{" +
                "i=" + i +
                ", c=" + c +
                ", b=" + b +
                ", f=" + f +
                ", d=" + d +
                ", aByte=" + aByte +
                '}';
    }
}
