package com.codefans.practicetask.file;

import java.io.File;
import java.util.*;

/**
 * @Author: codefans
 * @Date: 2020-06-13 17:51
 */

public class SortFileBySizeTask extends FileBase {

    /**
     * 视频类型
     */
    private static final List<String> VIDEO_TYPE = new ArrayList<>();

    /**
     * 图片类型
     */
    private static final List<String> IMAGE_TYPE = new ArrayList<>();

    static {
        VIDEO_TYPE.add(".mp4");
        VIDEO_TYPE.add(".rmvb");
        VIDEO_TYPE.add(".rm");
        VIDEO_TYPE.add(".flv");
        VIDEO_TYPE.add(".avi");
        VIDEO_TYPE.add(".wmv");
        VIDEO_TYPE.add(".mkv");

        IMAGE_TYPE.add(".jpg");
        IMAGE_TYPE.add(".jpeg");
        IMAGE_TYPE.add(".png");
        IMAGE_TYPE.add(".gif");
    }

    /**
     * 扫描视频
     */
    private static final String SCAN_VIDEO = "video";

    /**
     * 扫描图片
     */
    private static final String SCAN_IMAGE = "image";

    public static void main(String[] args) {
        SortFileBySizeTask sortFileBySizeTask = new SortFileBySizeTask();
        sortFileBySizeTask.taskExecute();
    }

    public void taskExecute() {
//        List<String> fileList = new ArrayList<>();
        Map<String, Long> fileSizeMap = new HashMap<>(1024);
        this.gather(fileSizeMap);
        List<Map.Entry<String, Long>> fileSizeList = this.sort(fileSizeMap, null);
        this.print(fileSizeList);
    }

    public void gather(Map<String, Long> fileSizeMap) {
        String[] dirs = new String[]{
            "D:\\Films",
			"E:\\Films",
			"F:\\Films",
			"G:\\Films",
        };
        /**
         * 扫描视频
         */
//        String scanType = SCAN_VIDEO;
        /**
         * 扫描图片
         */
        String scanType = SCAN_IMAGE;
        for(int i = 0; i < dirs.length; i ++) {
            this.gather(dirs[i], scanType, fileSizeMap);
        }
    }

    /**
     * 收集目录dir下的所有文件及文件大小
     * @param dir
     * @param fileSizeMap
     */
    public void gather(String dir, String scanType, Map<String, Long> fileSizeMap) {
        File path = new File(dir);
        if(path.isDirectory()) {
            File[] files = path.listFiles();
            for(int i = 0; i < files.length; i ++) {
                File f = files[i];
                if(f.isDirectory()) {
                    gather(dir + File.separator + f.getName(), scanType, fileSizeMap);
                } else {
                    this.addFile(f, scanType, fileSizeMap);
                }
            }
        } else {
            this.addFile(path, scanType, fileSizeMap);
        }
    }

    public void addFile(File file, String scanType, Map<String, Long> fileSizeMap) {
        String name = file.getName();
        String suffix = "";
        if(name.lastIndexOf(".") >= 0) {
            suffix = name.substring(name.lastIndexOf("."));
        }
        boolean addThisFile = false;
        if(SCAN_VIDEO.equals(scanType)) {
            if (VIDEO_TYPE.contains(suffix)) {
                addThisFile = true;
            }
        } else if (SCAN_IMAGE.equals(scanType)){
            if (IMAGE_TYPE.contains(suffix)) {
                addThisFile = true;
            }
        }
        if(addThisFile) {
            fileSizeMap.put(file.getAbsolutePath(), file.length());
        }
    }

    /**
     *
     * @param fileSizeMap
     * @param sortType: desc-降序; asc-升序, 默认值：desc-降序
     * @return
     */
    public List<Map.Entry<String, Long>> sort(Map<String, Long> fileSizeMap, String sortType) {
        Map<String, Long> sortedMap = new LinkedHashMap<>(fileSizeMap.size());

        List<Map.Entry<String, Long>> infoIds = new ArrayList<>(fileSizeMap.entrySet());

        //排序方法
        Collections.sort(infoIds, new Comparator<Map.Entry<String, Long>>() {
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                if ("asc".equals(sortType)) {
                    return o1.getValue().compareTo(o2.getValue());
                } else {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });


        return infoIds;
    }

    /**
     * 打印
     * @param fileSizeMap
     */
    public void print(Map<String, Long> fileSizeMap) {
        Iterator<String> iter = fileSizeMap.keySet().iterator();
        String key = "";
        while(iter.hasNext()) {
            key = iter.next();
            System.out.println("size:[" + super.formetFileSize(fileSizeMap.get(key)) + "], path:[" + key + "]");
        }
    }

    /**
     * 打印
     * @param fileSizeMap
     */
    public void print(List<Map.Entry<String, Long>> fileSizeMap) {
        Iterator<Map.Entry<String, Long>> iter = fileSizeMap.iterator();
        Map.Entry<String, Long> key = null;
        int index = 1;
        long totalSize = 0;
        while(iter.hasNext()) {
            key = iter.next();
            System.out.println("第[" + (index++) + "]个文件, size:[" + super.formetFileSize(key.getValue()) + "], path:[" + key.getKey() + "]");
            totalSize += key.getValue();
        }
        System.out.println("[" + (--index) + "]个文件总大小为:[" + super.formetFileSize(totalSize) + "]");
    }

}
