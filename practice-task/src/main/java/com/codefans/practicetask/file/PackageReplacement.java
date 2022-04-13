package com.codefans.practicetask.file;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: codefans
 * @Date: 2022-04-02 18:09
 */

public class PackageReplacement {

    public static void main(String[] args) {
        PackageReplacement pr = new PackageReplacement();
        pr.startup();
    }

    public void startup() {

//        String rootPath = "G:\\GitHub\\test-project-utf8\\interview-case\\src\\main\\java\\com\\codefans\\interview\\algorithm\\";
        String rootPath = "G:\\GitHub\\test-project-utf8\\interview-case\\src\\test\\java\\com\\codefans\\interview\\";
//        String rootPath = "G:\\GitHub\\test-project-utf8\\interview-case\\src\\main\\java\\com\\codefans\\interview\\algorithm\\leetcode\\linkedlist\\";
//        String rootPath = "G:\\GitHub\\test-project-utf8 - 副本2\\interview-case\\src\\main\\java\\com\\codefans\\interview\\algorithm\\leetcode\\linkedlist\\";
        Map<String, String> dataMap = new HashMap<>(8);
        dataMap.put("com.codefans.interview.algorithm.common.TreeNode", "com.codefans.reusablecode.datastructure.TreeNode");
        dataMap.put("com.codefans.interview.algorithm.common.TreeNodeFactory", "com.codefans.reusablecode.datastructure.TreeNodeFactory");
        dataMap.put("com.codefans.interview.algorithm.common.TreeNodeUtils", "com.codefans.reusablecode.datastructure.TreeNodeUtils");
        dataMap.put("com.codefans.interview.algorithm.common.ComplexListNode", "com.codefans.reusablecode.datastructure.ComplexListNode");
        dataMap.put("com.codefans.interview.algorithm.common.ArrayUtils", "com.codefans.reusablecode.util.ArrayUtils");
        dataMap.put("com.codefans.interview.algorithm.common.ListUtils", "com.codefans.reusablecode.datastructure.ListUtils");
        dataMap.put("com.codefans.reusablecode.common.BinaryTreeFactory", "com.codefans.reusablecode.datastructure.BinaryTreeFactory");
        dataMap.put("com.codefans.reusablecode.common.TreeFactory", "com.codefans.reusablecode.datastructure.TreeFactory");
        dataMap.put("com.codefans.interview.algorithm.common.ListNodeUtils", "com.codefans.reusablecode.datastructure.ListNodeUtils");
        dataMap.put("com.codefans.interview.algorithm.common.ComplexListNodeFactory", "com.codefans.reusablecode.datastructure.ComplexListNodeFactory");
        dataMap.put("com.codefans.interview.algorithm.common.ListNode", "com.codefans.reusablecode.datastructure.ListNode");
        dataMap.put("com.codefans.interview.algorithm.common.ListNodeFactory", "com.codefans.reusablecode.datastructure.ListNodeFactory");
        this.replacementRecursion(rootPath, dataMap);

//        this.deleteBak(rootPath);
    }

    private void replacementRecursion(String path, Map<String, String> dataMap) {
        File file = new File(path);
        if(file.isDirectory()) {
            File[] fileArr = file.listFiles();
            for(File f : fileArr) {
                if(f.isDirectory()) {
                    replacementRecursion(path + File.separator + f.getName(), dataMap);
                } else {
                    this.replacement(path + File.separator + f.getName(), dataMap);
                }
            }
        } else {
            this.replacement(path, dataMap);
        }
    }

    private void replacement(String filePath, Map<String, String> dataMap) {
        File sourceFile = null;
        File targetFile = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        boolean found = false;
        try {
//            String filePath = "G:\\GitHub\\test-project-utf8\\practice-task\\src\\main\\java\\com\\codefans\\practicetask\\file\\TestFile.java";
            String tmpFilePath = filePath.substring(0, filePath.lastIndexOf("\\")) + File.separator + filePath.substring(filePath.lastIndexOf("\\") + 1) + ".bak";
            System.out.println("tmpFilePath=" + tmpFilePath);
            sourceFile = new File(filePath);
            targetFile = new File(tmpFilePath);

            br = new BufferedReader(new FileReader(sourceFile));
            bw = new BufferedWriter(new FileWriter(targetFile));
            String line = "";
            String packageName = "";
            String importPrefix = "import ";
            while((line = br.readLine()) != null) {
                if(line.startsWith(importPrefix) && line.endsWith(";")) {
                    packageName = line.substring(line.indexOf(importPrefix) + importPrefix.length(), line.indexOf(";"));
                    if(dataMap.containsKey(packageName)) {
                        line = line.replace(packageName, dataMap.get(packageName));
                        found = true;
                    }
                }
                bw.write(line);
                bw.newLine();
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                bw.flush();
                bw.close();

                if(found) {
                    boolean deleteSuccess = sourceFile.delete();
                    boolean renameSuccess = targetFile.renameTo(sourceFile);
                    System.out.println("deleteSuccess=" + deleteSuccess + ", renameSuccess=" + renameSuccess);
                } else {
                    boolean deleteSuccess = targetFile.delete();
                    System.out.println("deleteSuccess=" + deleteSuccess);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void deleteBak(String path) {
        File dir = new File(path);
        if(dir.isDirectory()) {
            File[] fileArr = dir.listFiles((dir1, name) -> name.endsWith(".bak"));
            for(File f : fileArr) {
                boolean deleteSuccess = f.delete();
                System.out.println(deleteSuccess + ", [" + f.getName() + "]");
            }
        }
    }

}
