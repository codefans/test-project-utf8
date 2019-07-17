package com.codefans.opensource.redis.rediscli;

import java.io.*;

/**
 * @author: codefans
 * @date: 2019-07-12 09:57
 */
public class RedisCli {

    private Process process;
    private InputStream is;
    private InputStream errorIs;
    private OutputStream os;
    private BufferedReader br;
    private BufferedReader errorBr;
    private BufferedWriter bw;

    public void execute(String command) throws IOException {
        process = Runtime.getRuntime().exec(command);
        os = process.getOutputStream();
        is = process.getInputStream();
        errorIs = process.getErrorStream();
        bw = new BufferedWriter(new OutputStreamWriter(os));
        br = new BufferedReader(new InputStreamReader(is));
        errorBr = new BufferedReader(new InputStreamReader(errorIs));
    }

    public void write(String command) throws IOException {
        bw.write(command);
    }

    public String readLine() throws IOException {
        char[] chars = new char[10240];
        int charNums =  br.read(chars);
        return new String(chars, 0, charNums);
    }

    public void close() {
        try {
            close(br);
            close(bw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(BufferedReader br) throws IOException {
        if(br != null) {
            br.close();
            br = null;
        }
    }

    public void close(BufferedWriter bw) throws IOException {
        if(bw != null) {
            bw.flush();
            bw.close();
            bw = null;
        }
    }

}
