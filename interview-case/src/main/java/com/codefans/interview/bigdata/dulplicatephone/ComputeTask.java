package com.codefans.interview.bigdata.dulplicatephone;

import java.io.*;
import java.util.*;
import java.util.concurrent.RecursiveTask;

/**
 * @author: codefans
 * @date: 2019-09-17 19:14
 */
public class ComputeTask extends RecursiveTask<List<String>> {

    private static final int threadhold = 10;

    File[] smallFileArr;
    int begin = 0;
    int end = 0;

    public ComputeTask(File[] smallFileArr, int begin, int end) {
        this.smallFileArr = smallFileArr;
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected List<String> compute() {

        List<String> resList = new ArrayList<String>();

        boolean canCompute = end - begin <= threadhold;
        if(canCompute) {
            File file = null;
            List<String> phoneList = null;
            for(int i = begin; i <= end; i ++) {
                try {
                    file = smallFileArr[i];
                    phoneList = this.getTopK(smallFileArr[i], 100, false);
                    resList.addAll(phoneList);
                    System.out.println("收集第[" + (i + 1) + "]个文件, [" + file.getAbsolutePath() + "]文件收集结束, 手机号个数为:[" + phoneList.size() + "], threadName:[" + Thread.currentThread().getName() + "]");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } else {

            //如果任务大于阖值，就分裂成两个子任务
            int middle = (begin + end)/2;
            ComputeTask leftTask = new ComputeTask(smallFileArr, begin, middle);
            ComputeTask rightTask = new ComputeTask(smallFileArr, middle + 1, end);

            //执行子任务
            leftTask.fork();
            rightTask.fork();

            //等待子任务执行完,并得到其结果
            List<String> leftResult = leftTask.join();
            List<String> rightResult = rightTask.join();
            resList.addAll(leftResult);
            resList.addAll(rightResult);

        }

        return resList;
    }

    public List<String> getTopK(File file, int topK, boolean print) throws FileNotFoundException {
        List<String> res = new ArrayList<String>();

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




}
