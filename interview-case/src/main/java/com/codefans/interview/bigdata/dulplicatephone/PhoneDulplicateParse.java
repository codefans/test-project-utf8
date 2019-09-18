package com.codefans.interview.bigdata.dulplicatephone;

import com.codefans.reusablecode.bigdata.bloomfilter.MurmurHash;
import com.codefans.reusablecode.util.DateUtils;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * @author: codefans
 * @date: 2019-09-11 15:04
 */
public class PhoneDulplicateParse {

    private String inFilePath;
    private BufferedReader br;
    private RandomAccessFile raf;

    public PhoneDulplicateParse(String inFilePath) throws FileNotFoundException {
        this.inFilePath = inFilePath;
        raf = new RandomAccessFile(new File(inFilePath), "rw");
    }

    public void hashTest() throws IOException {
        int fileCount = 1000;

        MurmurHash murmurHash = new MurmurHash();

        long phoneNo = -1;
        String phoneNoStr = "";
        Set<Long> originDataSet = new HashSet<Long>();
        Set<Long> hashDataSet = new HashSet<Long>();
        int[] originDataArr = new int[fileCount];
        int[] hashDataArr = new int[fileCount];

        while((phoneNoStr = raf.readLine()) != null) {
            phoneNo = Long.parseLong(phoneNoStr);

//            originDataSet.add(phoneNo%fileCount);
//            hashDataSet.add((long)Math.abs(murmurHash.guavaMurmur3_32Hash(phoneNoStr))%fileCount);

            add(originDataArr, (int)Math.abs(phoneNo%fileCount));
            add(hashDataArr, Math.abs(murmurHash.guavaMurmur3_32Hash(phoneNoStr))%fileCount);

        }
//        System.out.println("originDataSize:" + originDataSet.size());
//        System.out.println("hashDataSize:" + hashDataSet.size());

        this.printArr(originDataArr);
        System.out.println("----------------");
        this.printArr(hashDataArr);

    }

    public void add(int[] arr, int index) {
        int oldData = arr[index];
        arr[index] = oldData+1;
    }

    public void printArr(int[] arr) {
        for(int i = 0; i < arr.length; i ++) {
            System.out.println("phoneNo:[" + i + "],出现次数:[" + arr[i] + "]");
        }
    }
    public void printList(List<String> list) {
        String str = "";
        System.out.println("printList-->list.size():" + list.size());
        for(int i = 0; i < list.size(); i ++) {
            str = list.get(i);
            System.out.println("phoneNo:[" + str.split("_")[0] + "],出现次数:[" + str.split("_")[1] + "]");
        }
    }

    public List<File> getSmallFileList(int fileCount) {

        String pathPrefix = "/data/phones/";
        String pathSuffix = ".txt";
        List<File> writerList = new ArrayList<File>();

        String filePath = "";
        File file = null;
        for(int i = 0; i < fileCount; i ++) {
            filePath = pathPrefix + i + pathSuffix;
            try {
                file = new File(filePath);
                if(!file.exists()) {
                    boolean createSuccess = file.createNewFile();
                    if(createSuccess) {
                        System.out.println("file[" + filePath + "] created!");
                    }
                }
                writerList.add(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return writerList;
    }

    public List<File> getCustomFileList() {
        String pathPrefix = "/data/";
        String pathSuffix = ".txt";
        List<File> writerList = new ArrayList<File>();

        String filePath = "";
        File file = null;
        for(int i = 1; i <= 2; i ++) {
            filePath = pathPrefix + i + pathSuffix;
            try {
                file = new File(filePath);
                writerList.add(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return writerList;
    }

    public List<RandomAccessFile> getSmallRandomAccessFileList(int fileCount) {

        String pathPrefix = "/data/phones/";
        String pathSuffix = ".txt";
        List<RandomAccessFile> writerList = new ArrayList<RandomAccessFile>();

        String filePath = "";
        File file = null;
        for(int i = 0; i < fileCount; i ++) {
            filePath = pathPrefix + i + pathSuffix;
            try {
                file = new File(filePath);
                if(!file.exists()) {
                    boolean createSuccess = file.createNewFile();
                    if(createSuccess) {
                        System.out.println("file[" + filePath + "] created!");
                    }
                }
                writerList.add(new RandomAccessFile(file, "rw"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return writerList;
    }



    /**
     * 10亿数据量要半个小时
     * @throws IOException
     */
    public void splitDataToMultiFiles() throws IOException {

        long beginTime = System.currentTimeMillis();

        int fileCount = 1000;
        List<RandomAccessFile> writerList = this.getSmallRandomAccessFileList(fileCount);

        MurmurHash murmurHash = new MurmurHash();

        String phoneNoStr = "";
        long phoneNo = -1;
        int index = 0;
        RandomAccessFile tmpRaf = null;

        while((phoneNoStr = raf.readLine()) != null) {
            phoneNo = Long.parseLong(phoneNoStr);
            System.out.println("phoneNo:" + phoneNo);

//            index = (int)Math.abs(murmurHash.guavaMurmur3_32Hash(phoneNoStr)%fileCount);
            index = (int)Math.abs(phoneNo%fileCount);

            if(phoneNoStr != null && phoneNoStr.trim().length() != 0) {
                tmpRaf = writerList.get(index);
                tmpRaf.writeUTF(phoneNoStr);
                tmpRaf.writeUTF("\n");
            }

        }

        this.close(writerList);

        long endTime = System.currentTimeMillis();
        System.out.println("time cost:[" + (endTime - beginTime)/1024 + "]s, [" + (endTime - beginTime)/1024/1024 + "]min");

    }

    public void violenceParse() throws IOException {

        long beginTime = System.currentTimeMillis();
        String beginTimeStr = DateUtils.formatYYYYMMDDHHMMSS_SSS(new Date());
        long beginMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        int fileCount = 1000;
        String pathPrefix = "/data/phones/";
        String pathSuffix = ".txt";
        List<File> fileList = new ArrayList<File>();
        List<String> dataList = new ArrayList<String>();

        String filePath = "";
        File file = null;
        for(int i = 0; i < fileCount; i ++) {
            filePath = pathPrefix + i + pathSuffix;
            file = new File(filePath);
            if(!file.exists()) {
                boolean createSuccess = file.createNewFile();
                if(createSuccess) {
                    System.out.println("file[" + filePath + "] created!");
                }
            }

            if(i == 555) {
                System.out.println(filePath);
//                dataList.addAll(getTopK(file, 5, false));
            }
            fileList.add(file);
//            dataList.addAll(getTopK(file, 5, false));

        }

        getTopK(new File("/data/phoneNos.txt"), 1000, true);
//        getTopK(new File("/data/phones/555.txt"), 10, true);
//        getTopK(dataList, 20);

        long endTime = System.currentTimeMillis();
        String endTimeStr = DateUtils.formatYYYYMMDDHHMMSS_SSS(new Date());
        long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("beginTimeStr:[" + beginTimeStr + "], endTimeStr:[" + endTimeStr + "], total time cost:[" + (endTime - beginTime) + "]ms");
        long totalBytes = endMemory - beginMemory;
        System.out.println("memory cost:[" + totalBytes/1024 + "]KB, [" + totalBytes / 1024 / 1024 + "]MB");

    }

    public List<String> getTopK(File file, int topK, boolean print) throws FileNotFoundException {
//        List<Map<String, Integer>> res = new LinkedList<Map<String, Integer>>();
        List<String> res = new LinkedList<String>();

        InputStream is = new FileInputStream(file);
        Scanner sc = new Scanner(is);
        String line = "";
        Map<String, Integer> datas = new HashMap<String, Integer>();
        int oldCount = 0;
        int totalCount = 0;

        while(sc.hasNextLine()) {
            line = sc.nextLine();
            if(line != null) {
                totalCount++;
                line = line.trim();
                if(datas.containsKey(line)) {
                    oldCount = datas.get(line);
                    datas.put(line, oldCount+1);
                } else {
                    datas.put(line, 1);
                }
            }
        }

//        System.out.println("totalCount:" + totalCount);
//        System.out.println("datas.size:" + datas.values().size());

        int count = 0;
        while(topK > 0) {
            Iterator<String> iter = datas.keySet().iterator();
            String key = "";
            int value = 0;
            String maxKey = "";
            int maxCount = 0;
            while(iter.hasNext()) {
                key = iter.next();
                value = datas.get(key);

                if(value > maxCount) {
                    maxKey = key;
                    maxCount = value;
                }

            }
            datas.remove(maxKey);

            res.add(maxKey + "_" + maxCount);
            if(print) {
                System.out.println(maxKey + "_" + maxCount);
            }
            if(datas.size() == 0) {
                break;
            }
            topK--;
        }

        return res;
    }

    public List<String> getTopK(List<String> arr, int topK) throws FileNotFoundException {
        List<String> res = new ArrayList<String>();

//        System.out.println("arr.size():" + arr.size());

        int count = 0;
        while(topK > 0) {
            Iterator<String> iter = arr.iterator();
            String element = "";
            String key = "";
            int value = 0;
            String maxKey = "";
            int maxCount = 0;
            String maxElement = "";

            while(iter.hasNext()) {
                element = iter.next();
                key = element.split("_")[0];
                value = Integer.parseInt(element.split("_")[1]);

                if(value > maxCount) {
                    maxKey = key;
                    maxCount = value;
                    maxElement = element;
                }
            }

            arr.remove(maxElement);

            res.add(maxKey + "_" + maxCount);
//            System.out.println(maxKey + "_" + maxCount);
            if(arr.size() == 0) {
                break;
            }

            topK--;
        }

        return res;
    }

    public void forkJoinParse() {

        System.out.println("forkJoin Parse task start...");
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        int fileCount = 1000;
        List<File> smallFileList = this.getSmallFileList(fileCount);
//        List<File> smallFileList = this.getCustomFileList();
        File[] smallFileArr = smallFileList.toArray(new File[0]);
        int begin = 0;
        int end = smallFileArr.length - 1;

        long beginTime = System.currentTimeMillis();

        ComputeTask computeTask = new ComputeTask(smallFileArr, begin, end);
        Future<List<String>> resFuture = forkJoinPool.submit(computeTask);
        if(resFuture != null) {
            try {
                List<String> resList = resFuture.get();
                int topK = 1000;
                List<String> topKList = this.getTopK(resList, topK);
                printList(topKList);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("beginTime:[" + DateUtils.formatYYYYMMDDHHMMSS_SSS(beginTime) + "], endTime:[" + DateUtils.formatYYYYMMDDHHMMSS_SSS(endTime) + "], time cost:[" + (endTime - beginTime) + "]ms, [" + (endTime - beginTime)/1000 + "]s, [" + ((endTime - beginTime)/1000)/60 + "]m");
        System.out.println("forkJoin Parse task finish!");

    }

    public void bigdataParse() {

    }

    public void close(List<RandomAccessFile> writerList) throws IOException {
        Iterator<RandomAccessFile> iterator = writerList.iterator();
        RandomAccessFile raf = null;
        while(iterator.hasNext()) {
            raf = iterator.next();
            if(raf != null) {
                iterator.remove();
                raf.close();
                raf = null;
            }
        }
    }

    public static void main(String[] args) {
        try {

//            System.out.println(Integer.MAX_VALUE); //2147483647
            String inFilePath = PhoneGenerator.outFilePath;
            PhoneDulplicateParse phoneDulplicateParse = new PhoneDulplicateParse(inFilePath);
//            phoneDulplicateParse.hashTest();
//            phoneDulplicateParse.splitDataToMultiFiles();
//            phoneDulplicateParse.violenceParse();
            phoneDulplicateParse.forkJoinParse();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
