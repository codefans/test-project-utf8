package com.codefans.practicetask.projectsetup;

import com.codefans.reusablecode.util.IOUtils;
import com.codefans.reusablecode.xml.Dom4jXmlFormater;
import com.codefans.reusablecode.xml.XercesXmlFormater;

import java.io.*;
import java.util.*;

/**
 * @author codefans
 * @date 2018/2/11 9:39
 */
public class ProjectSetupMain implements PropertyKeyConstants {

    private Properties properties;
    private Map<String, String> setupInfoMap;

    String projectRootDir;
    String propertyFileName;
    /**
     * 项目类型：pom和gradle
     */
    String projectType;

    String projectArtifactId;;
    String[] moduleArtifactIdArr;

    private String projectPath;
    private List<String> modulePaths = new ArrayList<String>();

    public static void main(String[] args) {
        ProjectSetupMain psm = new ProjectSetupMain();
        psm.setup();
    }

    public void setup() {

        try {

            this.initProperties();
            this.setupDir();
            if(projectType.equals(MAVEN)) {
                this.setupPom();
            } else {
                this.setupGradle();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public void initProperties() throws IOException {

        projectRootDir = "D:/github";
        propertyFileName = "setup.properties";
        projectType = "gradle";

        InputStream is = ProjectSetupMain.class.getResourceAsStream(propertyFileName);
//        InputStream is = ProjectSetupMain.class.getClassLoader().getResourceAsStream(propertyFileName);
        properties = new Properties();
        properties.load(is);

        setupInfoMap = new HashMap<String, String>((Map)properties);

    }



    public void setupDir() {
        projectArtifactId = this.getProperty("project.artifactId");
        projectPath = projectRootDir + File.separator + projectArtifactId;

        String moduleArtifactIds = this.getProperty(MODULE_ARTIFACTIDS);
        moduleArtifactIdArr = moduleArtifactIds.split(PROPERTY_SEPERATOR);

        String moduleArtifactId = "";
        String modulePath = "";
        boolean isSuccess = false;
        if(moduleArtifactIdArr != null && moduleArtifactIdArr.length > 0) {

            for (int i = 0; i < moduleArtifactIdArr.length; i++) {
                moduleArtifactId = moduleArtifactIdArr[i];
                modulePath = projectRootDir + File.separator + projectArtifactId + File.separator + moduleArtifactId;
                modulePaths.add(modulePath);
                isSuccess = this.mkdirs(modulePath);
                if (!isSuccess) {
                    System.out.println("module create fail, maybe module path already exists. module path=" + modulePath);
                } else {
                    System.out.println("module create success, module path=" + modulePath);
                }

                this.mkdirs(modulePath + File.separator + "src/main/java");
                this.mkdirs(modulePath + File.separator + "src/test/java");

            }
        }

    }

    public void setupPom() {
        this.setupProjectPom();
        this.setupModulePoms();
    }

    public void setupProjectPom() {

        try {
            ProjectPomBuilder projectPomBuilder = new ProjectPomBuilder(setupInfoMap);
            String projectPomStr = projectPomBuilder.build();
            String formatProjectPomStr = Dom4jXmlFormater.format(projectPomStr);

            String projectPomFilePath = projectPath + File.separator + "pom.xml";
            this.write(projectPomFilePath, formatProjectPomStr);

        } catch (Exception e) {
            System.out.println("setupProjectPom exception:");
            e.printStackTrace();

        }


    }

    public void setupModulePoms() {
        try {

            String moduleArtifactIdStr = setupInfoMap.get(MODULE_ARTIFACTIDS);
            String[] moduleArtifactIdArr = moduleArtifactIdStr.split(PROPERTY_SEPERATOR);
            if(moduleArtifactIdArr != null && moduleArtifactIdArr.length > 0) {
                String moduleArtifactId;
                for(int i = 0; i < moduleArtifactIdArr.length; i ++) {
                    moduleArtifactId = moduleArtifactIdArr[i];
                    ModulePomBuilder modulePomBuilder = new ModulePomBuilder(setupInfoMap, moduleArtifactId);
                    String modulePomStr = modulePomBuilder.build();
                    String formatModulePomStr = XercesXmlFormater.format(modulePomStr);

                    String modulePomFilePath = modulePaths.get(i) + File.separator + "pom.xml";
                    this.write(modulePomFilePath, formatModulePomStr);
                }
            }

        } catch (IOException e) {
            System.out.println("setupModulePoms exception:");
            e.printStackTrace();

        }
    }

    public void setupGradle() {
        this.setBuildGradle();
        this.setSettingsGradle();
        this.setDefaultFiles();
    }

    public void setBuildGradle() {
        try {

            ProjectGradleBuilder projectGradleBuilder = new ProjectGradleBuilder(setupInfoMap);
            String buildGradleStr = projectGradleBuilder.rootBuildGradle();
            String buildGradleFilePath = projectPath + File.separator + "build.gradle";
            this.write(buildGradleFilePath, buildGradleStr);

            String subProjectBuildGradleStr = projectGradleBuilder.subProjectBuildGradle();

            String moduleArtifactIdStr = setupInfoMap.get(MODULE_ARTIFACTIDS);
            String[] moduleArtifactIdArr = moduleArtifactIdStr.split(PROPERTY_SEPERATOR);
            if(moduleArtifactIdArr != null && moduleArtifactIdArr.length > 0) {
                for(int i = 0; i < moduleArtifactIdArr.length; i ++) {
                    String modulePomFilePath = modulePaths.get(i) + File.separator + "build.gradle";
                    this.write(modulePomFilePath, subProjectBuildGradleStr);
                }
            }

        } catch (Exception e) {
            System.out.println("setBuildGradle exception:");
            e.printStackTrace();
        }
    }


    public void setSettingsGradle() {
        try {

            ProjectGradleBuilder projectGradleBuilder = new ProjectGradleBuilder(setupInfoMap);
            String buildGradleStr = projectGradleBuilder.settingsGradle();
            String buildGradleFilePath = projectPath + File.separator + "settings.gradle";
            this.write(buildGradleFilePath, buildGradleStr);
        } catch (Exception e) {
            System.out.println("setSettingsGradle exception:");
            e.printStackTrace();
        }
    }

    public void setDefaultFiles() {

        try {
            String projectName = "test-project-utf8";
            String userDir = System.getProperty("user.dir");
            String rootPath = userDir.substring(0, userDir.indexOf(projectName) + projectName.length());
            System.out.println("rootPath=" + rootPath);

            String gradlePropertiesInPath = rootPath + File.separator + "gradle.properties";
            String gradlePropertiesOutPath = projectPath + File.separator + "gradle.properties";
            IOUtils.write(gradlePropertiesInPath, gradlePropertiesOutPath);

            String gradlewInPath = rootPath + File.separator + "gradlew";
            String gradlewOutPath = projectPath + File.separator + "gradlew";
            IOUtils.write(gradlewInPath, gradlewOutPath);

            String gradlewBatInPath = rootPath + File.separator + "gradlew.bat";
            String gradlewBatOutPath = projectPath + File.separator + "gradlew.bat";
            IOUtils.write(gradlewBatInPath, gradlewBatOutPath);
        } catch (IOException e) {
            System.out.println("setDefaultFiles exception");
            e.printStackTrace();
        }

    }

    public String getProperty(String key) {
        return String.valueOf(properties.get(key));
    }

    public boolean mkdirs(String dir) {
        boolean isSuccess = false;
        File dirFile = new File(dir);
        if(!dirFile.exists()) {
            isSuccess = dirFile.mkdirs();
        }
        return isSuccess;
    }

    public boolean write(String outFilePath, String content) throws IOException {
        return this.write(new File(outFilePath), content);
    }

    public boolean write(File outFile, String content) throws IOException {
        return this.write(new FileOutputStream(outFile), content);
    }

    public boolean write(OutputStream os, String content) throws IOException {
        boolean isSuccess = false;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        bw.write(content);
        bw.flush();
        bw.close();
        bw = null;
        isSuccess = true;

        return isSuccess;
    }

}
