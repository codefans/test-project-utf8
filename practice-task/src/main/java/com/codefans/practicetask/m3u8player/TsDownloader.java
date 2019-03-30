package com.codefans.practicetask.m3u8player;

import com.codefans.reusablecode.encode.Base64;

import java.io.IOException;

/**
 * @author: codefans
 * @date: 2019-03-30 09:38:31
 *
 *
 *
 */
public class TsDownloader {

    public String getM3u8DownloanUrl() {
        String m3u8Url = "";
        try {
            m3u8Url = Base64.decode("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return m3u8Url;
    }

}
