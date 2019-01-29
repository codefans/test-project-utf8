package com.codefans.reusablecode.designpattern.eventdriven;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ShengzhiCai
 * @date: 2018-11-08 15:01
 */
public class MyButton {

    private List<MyActionListener> actionListenerList = new ArrayList<MyActionListener>();

    public void onClick() {

        MyActionEvent myActionEvent = new MyActionEvent();
        myActionEvent.setName("点击事件");
        fireActionPerformed(myActionEvent);

    }

    public void fireActionPerformed(MyActionEvent myActionEvent) {

        MyActionListener myActionListener = null;
        for(int i = 0; i < actionListenerList.size(); i ++) {
            myActionListener = actionListenerList.get(i);
            myActionListener.actionPerformed(myActionEvent);
        }

    }

    public void addActionListener(MyActionListener myActionListener) {
        actionListenerList.add(myActionListener);
    }

}
