/**
 * Copyright (C), 2015-2020, 京东
 * FileName: RandomAccessFileUtils
 * Author:   caishengzhi
 * Date:     2020/11/23 11:42
 * Description: 随机文件读写
 */
package com.codefans.practicetask.file;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * 随机文件读写
 *
 * @author codefans
 * @date 2020/11/23 11:42
 * @since 1.0.0
 */
public class RandomAccessFileUtils {

    /**
     *
     */
    private String inFilePath;

    /**
     *
     */
    RandomAccessFile raf;

    /**
     *
     * @param inFilePath
     */
    public RandomAccessFileUtils(String inFilePath) {
        this.inFilePath = inFilePath;
        this.init();
    }

    /**
     *
     */
    public void init() {
        try {
            raf = new RandomAccessFile(new File(inFilePath), "r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    private void checkInit() {
        if(raf == null) {
            this.init();
        }
    }

    /**
     *
     * @param outFilePath
     * @return
     */
    public boolean write(String outFilePath) throws IOException {
        boolean writeSuccess;
        checkInit();
        String line = "";
        File outFile = new File(outFilePath);
        if(!outFile.exists()) {
            outFile.createNewFile();
        }
//        BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
        int totalLine = 0;
//        while((line = raf.readLine()) != null) {
//            if(totalLine == 1000) {
//                break;
//            }
//            bw.write(line);
//            bw.newLine();
//            totalLine++;
//        }

        RandomAccessFile outRaf = new RandomAccessFile(new File(outFilePath), "rw");
        byte[] bytes = new byte[2048];
        int readCount = 0;
        while((readCount = raf.read(bytes)) > 0) {
            if(totalLine == 1000) {
                break;
            }
            outRaf.write(bytes, 0, readCount);
            outRaf.writeBytes(File.separator);
            totalLine++;
        }

        outRaf.close();
        writeSuccess = true;
        return writeSuccess;
    }

}