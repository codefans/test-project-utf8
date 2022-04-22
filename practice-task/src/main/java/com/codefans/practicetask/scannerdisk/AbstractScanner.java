package com.codefans.practicetask.scannerdisk;

import com.codefans.practicetask.file.FileBase;
import com.codefans.reusablecode.util.IOUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.codefans.practicetask.file.FileBase.formetFileSize;

/**
 * @Author: codefans
 * @Date: 2022-04-22 17:14
 */

public abstract class AbstractScanner {

    protected ThreadPoolExecutor executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() + 1, Runtime.getRuntime().availableProcessors() + 1, 5000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(10000), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "scannerThreadPool");
        }
    }, new ThreadPoolExecutor.AbortPolicy());

    protected IOUtils ioUtils;

    /**
     *
     * @param rootPath
     * @param outFilePath
     */
    public void scan(String rootPath, String outFilePath) throws IOException {
        List<String> folderList = this.scanFolders(rootPath);
        Map<String, String> dataMap = this.calSize(folderList);
        Map<String, String> sortedMap = sort(dataMap, 0);
        if(ioUtils == null) {
           ioUtils = new IOUtils(outFilePath);
        }
        writeTo(sortedMap, outFilePath);
    }

    /**
     *
     * @param rootPath
     * @param outFilePath
     */
    public void scan(String rootPath, int level, String outFilePath) throws IOException {
        List<String> folderList = this.scanFolders(rootPath, level);
        Map<String, String> dataMap = this.calSize(folderList);
        Map<String, String> sortedMap = sort(dataMap, 0);
        writeTo(sortedMap, outFilePath);
    }

    public abstract List<String> scanFolders(String rootPath);

    public abstract List<String> scanFolders(String rootPath, int level);

    public abstract Map<String, String> calSize(List<String> folderList);

    /**
     * 根据value排序
     * @param dataMap
     * @param asc:1-升序; 0-降序
     * @return
     */
    public LinkedHashMap<String, String> sort(Map<String, String> dataMap, int asc) {
        /**
         * 利用Map的entrySet方法，转化为list进行排序
         */
        List<Map.Entry<String, String>> entryList = new ArrayList<>(dataMap.entrySet());
        /**
         * 利用Collections的sort方法对list排序
         */
        Collections.sort(entryList, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                long res = 0;
                if(asc == 1) {
                    res = Long.parseLong(o1.getValue()) - Long.parseLong(o2.getValue());
                } else {
                    res = Long.parseLong(o2.getValue()) - Long.parseLong(o1.getValue());;
                }
                return res >= 0 ? 1 : -1;
            }
        });
        //遍历排序好的list，一定要放进LinkedHashMap，因为只有LinkedHashMap是根据插入顺序进行存储
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        for (Map.Entry<String,String> e : entryList ) {
            linkedHashMap.put(e.getKey(), e.getValue());
        }
        return linkedHashMap;
    }

    public void writeTo(Map<String, String> dataMap, String filePath) throws IOException {
        Iterator<String> iter = dataMap.keySet().iterator();
        String path = "";
        long size = 0L;
        List<String> nextPathList = new ArrayList<>(8);
        while(iter.hasNext()) {
            path = iter.next();
            size = Long.parseLong(dataMap.get(path));
            ioUtils.append("size:[" + formetFileSize(size) + "], path:[" + path + "]");
            if(size > FileBase.G) {
                nextPathList.add(path);
            }
        }
        for(String p : nextPathList) {
            ioUtils.append("\"" + p + "\",");
        }
    }

    /**
     * 按层级扫描文件夹
     * @param dir
     * @param foldersInThisLevel
     * @param level
     * @throws IOException
     */
    public void scanFolderByLevel(String dir, List<String> foldersInThisLevel, int level) throws IOException {

        File path = new File(dir);
        if (path.isDirectory()) {
            File[] files = path.listFiles();
            if (files != null && files.length > 0) {
                for (int i = 0; i < files.length; i++) {
                    File file = files[i];
                    if (file.isDirectory()) {
                        if (level == 0) {
                            if (!foldersInThisLevel.contains(dir)) {
                                foldersInThisLevel.add(dir);
                            }
                            continue;
                        } else {
                            scanFolderByLevel(dir + File.separator + file.getName(), foldersInThisLevel,level-1);
                        }
                    }
                }
            }
        }
    }

    /**
     * 按层级扫描文件
     * @param dir
     * @param fileType
     * @throws IOException
     */
    public void scanFile(String dir, FileType fileType, List<String> fileList) throws IOException {
        File path = new File(dir);
        if (path.isDirectory()) {
            File[] files = path.listFiles();
            if (files != null && files.length > 0) {
                for (int i = 0; i < files.length; i++) {
                    File file = files[i];
                    if (file.isDirectory()) {
                        scanFile(dir + File.separator + file.getName(), fileType, fileList);
                    } else {
                        if (FileFilter.filter(file.getAbsolutePath(), fileType)) {
                            fileList.add(file.getAbsolutePath());
                        }
                    }
                }
            }
        } else {
            if (FileFilter.filter(path.getAbsolutePath(), fileType)) {
                fileList.add(path.getAbsolutePath());
            }
        }
    }

    /**
     * 关闭任务
     */
    public abstract void shutdown();

}
