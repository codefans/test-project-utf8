package com.codefans.practicetask.file;

import java.io.*;

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

        String rootPath = "G:\\GitHub\\test-project-utf8\\interview-case\\src\\main\\java\\com\\codefans\\interview\\algorithm\\";
//        String rootPath = "G:\\GitHub\\test-project-utf8\\interview-case\\src\\main\\java\\com\\codefans\\interview\\algorithm\\leetcode\\linkedlist\\";
//        String rootPath = "G:\\GitHub\\test-project-utf8 - 副本2\\interview-case\\src\\main\\java\\com\\codefans\\interview\\algorithm\\leetcode\\linkedlist\\";
//        String packageName = "com.codefans.interview.algorithm.common.ListNode";
//        String replacementName = "com.codefans.reusablecode.datastructure.ListNode";
        String packageName = "com.codefans.interview.algorithm.offer.TreeNode";
        String replacementName = "com.codefans.reusablecode.datastructure.TreeNode";
        replacementRecursion(rootPath, packageName, replacementName);
        String[][] arr = new String[][]{
//            {"com.codefans.interview.algorithm.common.ComplexListNode", "com.codefans.reusablecode.datastructure.ComplexListNode"},
//            {"com.codefans.interview.algorithm.common.ArrayUtils", "com.codefans.reusablecode.util.ArrayUtils"},
            {"com.codefans.interview.algorithm.common.ListUtils", "com.codefans.reusablecode.datastructure.ListUtils"},
        };
        for(String[] subArr : arr) {
            this.replacementRecursion(rootPath, subArr[0], subArr[1]);
        }

//        this.deleteBak(rootPath);
    }

    private void replacementRecursion(String path, String packageName, String replacementName) {
        File file = new File(path);
        if(file.isDirectory()) {
            File[] fileArr = file.listFiles();
            for(File f : fileArr) {
                if(f.isDirectory()) {
                    replacementRecursion(path + File.separator + f.getName(), packageName, replacementName);
                } else {
                    this.replacement(path + File.separator + f.getName(), packageName, replacementName);
                }
            }
        } else {
            this.replacement(path, packageName, replacementName);
        }
    }

    private void replacement(String filePath, String packageName, String replacementName) {
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

//            String packageName = "com.codefans.reusablecode.datastructure.ListNode";
//            String replacementPackageName = "com.codefans.reusablecode.datastructure.aaa.ListNode";

            br = new BufferedReader(new FileReader(sourceFile));
            bw = new BufferedWriter(new FileWriter(targetFile));
            String line = "";

            while((line = br.readLine()) != null) {
                if(line.contains(packageName)) {
                    line = line.replace(packageName, replacementName);
                    found = true;
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
