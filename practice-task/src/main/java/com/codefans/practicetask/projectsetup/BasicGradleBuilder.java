/**
 * Copyright (C), 2015-2021, 京东
 * FileName: BasicGradleBuilder
 * Author:   codefans
 * Date:     2021/9/28 16:28
 * Description: gradle文件构建基础类
 */
package com.codefans.practicetask.projectsetup;


/**
 *
 * gradle文件构建基础类
 *
 * @author: codefans
 * @Date: 2021/09/28 16:28
 * @since: 1.0.0
 */
public class BasicGradleBuilder {

    private StringBuilder pomStr = new StringBuilder();

    public BasicGradleBuilder newLine(String text) {
        pomStr.append(text);
        pomStr.append("\r\n");
        return this;
    }

    public void clear() {
        pomStr = new StringBuilder();
    }

    public String toString() {
        return pomStr.toString();
    }

}