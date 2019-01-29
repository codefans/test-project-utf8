package com.codefans.reusablecode.designpattern.eventdriven;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: ShengzhiCai
 * @date: 2018-11-08 11:11
 */
public class SwingEventDrivenExample {

    public static void main(String[] args) {
        SwingEventDrivenExample swingEventDrivenExample = new SwingEventDrivenExample();
        swingEventDrivenExample.startup();
    }

    public void startup() {

        JFrame jFrame = new JFrame("Swing Event Driven Model");
        JButton jButton = new JButton("点击事件2222");
        jButton.setSize(100, 100);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("actionCommand:" + e.getActionCommand());
            }
        });

        jFrame.add(jButton);
        jFrame.setVisible(true);// 设置窗体可视
        jFrame.setSize(500, 350);        // 设置窗体大小
        jFrame.setBackground(Color.BLUE);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// 设置窗体关闭方式


    }
}
