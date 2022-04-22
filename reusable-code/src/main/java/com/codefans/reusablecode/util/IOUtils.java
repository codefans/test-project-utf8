package com.codefans.reusablecode.util;

import java.io.*;
import java.util.List;

/**
 * @Author: codefans
 * @Date: 2017-09-26 23:35
 */

public class IOUtils {

    String path;

    BufferedWriter bw = null;

    public IOUtils(String path) throws IOException {
        bw = new BufferedWriter(new FileWriter(new File(path)));
    }

    public IOUtils append(String path) throws IOException {
        bw.write(path);
        bw.newLine();
        return this;
    }

    public void append(List<String> strs) {
        if (strs == null || strs.size() == 0) {
            System.out.println("strs is empty.");
        }
        try {
            for (int i = 0; i < strs.size(); i++) {
                bw.write(strs.get(i));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() throws IOException {
        if(bw != null) {
            bw.flush();
            bw.close();
            bw = null;
        }
    }

    public static String getStr(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int n = 0;
        while((n = is.read(bytes)) != -1) {
            baos.write(bytes, 0, n);
        }
        baos.flush();
        return baos.toString("UTF-8");
    }

    public static byte[] getFileBytes(String filePath) throws IOException {
        File file = new File(filePath);
        if(!file.exists()) {
            throw new FileNotFoundException("[" + filePath + "] file not found.");
        }
        BufferedInputStream bis = null;
        ByteArrayOutputStream baos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(file));

            byte[] bytes = new byte[1024];
            baos = new ByteArrayOutputStream();
            int n = 0;
            while((n = bis.read(bytes)) != -1) {
                baos.write(bytes, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bis != null) {
                bis.close();
                bis = null;
            }
        }
        return baos.toByteArray();
    }

    public static boolean write(String inFilePath, String outFilePath) throws IOException {
        return write(new File(inFilePath), new File(outFilePath));
    }

    public static boolean write(File inFile, File outFile) throws IOException {
        return write(new FileInputStream(inFile), new FileOutputStream(outFile));
    }

    public static boolean write(InputStream is, OutputStream os) throws IOException {
        boolean isSuccess = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        String line = "";
        while((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
        br = null;
        bw = null;
        isSuccess = true;
        return isSuccess;
    }

}
