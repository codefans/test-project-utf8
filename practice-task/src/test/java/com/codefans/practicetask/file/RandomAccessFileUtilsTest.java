/**
 * Copyright (C), 2015-2020, 京东
 * FileName: RandomAccessFileUtilsTest
 * Author:   caishengzhi
 * Date:     2020/11/23 14:25
 * Description: 随机文件读写
 */
package com.codefans.practicetask.file;


import org.junit.Test;

import java.io.IOException;

/**
 *
 * 随机文件读写
 *
 * @author codefans
 * @date 2020/11/23 14:25
 * @since 1.0.0
 */
public class RandomAccessFileUtilsTest {

    /**
     *
     */
    @Test
    public void writeTest() throws IOException {

        String inFilePath = "D:\\github\\test-project-utf8\\interview-case\\build\\test-results\\test\\binary\\output.bin";
        String outFilePath = "E:\\output-1000-lines.bin";
        RandomAccessFileUtils rafUtils = new RandomAccessFileUtils(inFilePath);
        rafUtils.write(outFilePath);

    }








}