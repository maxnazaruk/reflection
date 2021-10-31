package com.luxoft.reflection;

import java.io.Externalizable;
import java.io.Serializable;
import java.util.EventListener;

public class Reflection implements Serializable, EventListener, Cloneable {
    public String name = "name";
    protected int number = 200;
    boolean visible = true;
    public int std;

    public Reflection()  {
    }

    private Reflection(String name, int number, boolean visible, int std) {
        this.name = name;
        this.number = number;
        this.visible = visible;
        this.std = std;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    int getNumber() {
        return number;
    }

    void setNumber(int number) {
        this.number = number;
    }

    protected boolean isVisible() {
        return visible;
    }

    protected void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getStd() {
        return std;
    }

    public void setStd(int std) {
        this.std = std;
    }

    public void emptyMethod(){
        System.err.println("test");
    }

    public final void finalTest(){

    }
}
