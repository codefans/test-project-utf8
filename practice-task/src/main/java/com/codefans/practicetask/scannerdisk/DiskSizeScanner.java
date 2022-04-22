package com.codefans.practicetask.scannerdisk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorCompletionService;

/**
 * @Author: codefans
 * @Date: 2022-04-22 17:20
 */

public class DiskSizeScanner extends AbstractScanner {

    @Override
    public List<String> scanFolders(String rootPath) {
        List<String> folderList = new ArrayList<>();
        try {
            scanFolderByLevel(rootPath, folderList, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return folderList;
    }

    @Override
    public List<String> scanFolders(String rootPath, int level) {
        List<String> folderList = new ArrayList<>();
        try {
            scanFolderByLevel(rootPath, folderList, level);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return folderList;
    }

    @Override
    public Map<String, String> calSize(List<String> folderList) {
        Map<String, String> dataMap = new ConcurrentHashMap<>();
        CompletionService completionService = new ExecutorCompletionService(executor);
        int count = folderList.size();
        for(String path : folderList) {
            completionService.submit(new GetFolderSizeTask(path, dataMap), new String());
        }
        while(count > 0) {
            try {
                completionService.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                count--;
            }
        }
        return dataMap;
    }

    @Override
    public void shutdown() {
        try {
            executor.shutdown();
            ioUtils.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
