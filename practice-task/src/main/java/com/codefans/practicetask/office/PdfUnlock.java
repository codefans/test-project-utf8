package com.codefans.practicetask.office;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: codefans
 * @date: 2020-02-05 11:21
 */
public class PdfUnlock {

    public static void main(String[] args) throws Exception {

        PdfUnlock pdfUnlock = new PdfUnlock();

        String[] passArr = new String[]{
           "hhhkkk", "xxxmmm"
        };
        String dirPath = "C:\\Users\\codefans\\Pictures\\Films\\";
        String[][] filePathArr = new String[][]{
           {"木瓜怎样选.pdf","山地车自由行.pdf","粉红小书包.pdf","網紅hungerlan户外演出1.pdf","網紅hungerlan户外演出2.pdf","網紅hungerlan户外演出3.pdf","網紅hungerlan户外演出4.pdf","網紅hungerlan户外演出5.pdf"},
           {"S小姐与疫情共勉，武汉加油.pdf","安徽-武汉加油.pdf","广西抗击疫情.pdf","河南抗击疫情.pdf","抗击疫情科普知识.pdf","抗疫不能成为恐鄂，加油湖北.pdf","李云龙的意大利炮炮击新型丙状病毒.pdf","密切接触者请配合隔离，后果严重.pdf","曝光2020疫情有多严重.pdf","齐心协力，战胜病毒，不负韶华.pdf"},
        };

        for(int i = 0; i < passArr.length; i ++) {
            for(int j = 0; j < filePathArr.length; j ++) {
                if(i == j) {
                    String[] pathArr = filePathArr[j];
                    pdfUnlock.unlock(passArr[i], pdfUnlock.addDirPath(dirPath, pathArr));
                }
            }
        }

    }

    public String[] addDirPath(String dir, String[] fileNameArr) {
        for(int i = 0;i < fileNameArr.length; i ++) {
            fileNameArr[i] = dir + File.separator + fileNameArr[i];
        }
        return fileNameArr;
    }

    public void unlock(Map<String, List<String>> dataMap) {

    }

    public void unlock(String pass, String lockedFilePath) {

    }

    public List<File> getFilePathList(String dirStr) {
        List<File> fileList = new ArrayList<File>();
        File dir = new File(dirStr);
        if(dir.isDirectory()) {
            File[] fileArr = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    if(name.endsWith(".pdf")) {
                        return true;
                    }
                    return false;
                }
            });
            for(int i = 0; i < fileArr.length; i ++) {
                File f = fileArr[i];
                fileList.add(f);
            }
        } else {
            System.out.println("dirStr:[" + dirStr + "] is not a directory!");
        }
        return fileList;
    }

    public void unlock(List<String> passList, List<List<File>> lockedFileList) {

    }

    public void unlock(String pass, String[] arr) throws Exception {
        List<File> fileList = new ArrayList<File>(arr.length);
        for(String path : arr) {
            fileList.add(new File(path));
        }
        this.unlock(pass, fileList);
    }

    public void unlock(String pass, List<File> lockedFileList) throws Exception {

        for(int i = 0; i < lockedFileList.size(); i ++) {
            unlock(pass, lockedFileList.get(i));
        }

    }

    public void unlock(String pass, File lockedFile) throws IOException {
        PDDocument load = PDDocument.load(lockedFile, pass);
        load.setAllSecurityToBeRemoved(true);

        String fileName = lockedFile.getName();
        String decryptFile = lockedFile.getParent() + File.separator + fileName.substring(0, fileName.indexOf(".pdf")) + "-已解密.pdf";

        load.save(new FileOutputStream(new File(decryptFile)));
        System.out.println("[" + lockedFile.getAbsolutePath() + "]-已解密！");
    }

}
