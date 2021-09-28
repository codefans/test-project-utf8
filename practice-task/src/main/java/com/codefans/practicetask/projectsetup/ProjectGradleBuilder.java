/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ProjectGradleBuilder
 * Author:   caishengzhi
 * Date:     2021/9/28 16:21
 * Description: 项目gradle配置文件构建
 */
package com.codefans.practicetask.projectsetup;


import java.util.Map;

/**
 *
 * 项目gradle配置文件构建
 *
 * @author: codefans
 * @Date: 2021/09/28 16:21
 * @since: 1.0.0
 */
public class ProjectGradleBuilder extends BasicGradleBuilder implements PropertyKeyConstants {

    private Map<String, String> infoMap;

    public ProjectGradleBuilder(Map<String, String> infoMap) {
        this.infoMap = infoMap;
    }

    public String rootBuildGradle() {
        this.clear();
        this.newLine("allprojects {");
        this.newLine("    group = '" + this.get(PROJECT_NAME) + "'");
        this.newLine("    version = '" + this.get(PROJECT_VERSION) + "'");
        this.newLine("     repositories {");
        this.newLine("        maven {");
        this.newLine("            url = uri('https://maven.aliyun.com/nexus/content/groups/public/')");
        this.newLine("        }");
        this.newLine("    }");
        this.newLine("}");
        this.newLine("");

        this.newLine("subprojects {");
        this.newLine("    apply plugin: 'java-library'");
        this.newLine("    compileJava.options.encoding = 'UTF-8'");
        this.newLine("     compileTestJava.options.encoding = 'UTF-8'");
        this.newLine("     sourceCompatibility = '1.8'");
        this.newLine("    tasks.withType(JavaCompile) {");
        this.newLine("        options.encoding = 'UTF-8'");
        this.newLine("        // Try to turn them all off automatically");
        this.newLine("        options.compilerArgs << '-Xlint:none'");
        this.newLine("        options.compilerArgs << '-nowarn' // same as '-Xlint:none'");
        this.newLine("        // Turn them off manually");
        this.newLine("        options.compilerArgs << '-Xlint:-auxiliaryclass'");
        this.newLine("        options.compilerArgs << '-Xlint:-cast'");
        this.newLine("        options.compilerArgs << '-Xlint:-classfile'");
        this.newLine("        options.compilerArgs << '-Xlint:-deprecation'");
        this.newLine("        options.compilerArgs << '-Xlint:-dep-ann'");
        this.newLine("        options.compilerArgs << '-Xlint:-divzero'");
        this.newLine("        options.compilerArgs << '-Xlint:-empty'");
        this.newLine("        options.compilerArgs << '-Xlint:-fallthrough'");
        this.newLine("        options.compilerArgs << '-Xlint:-finally'");
        this.newLine("        options.compilerArgs << '-Xlint:-options'");
        this.newLine("        options.compilerArgs << '-Xlint:-overloads'");
        this.newLine("        options.compilerArgs << '-Xlint:-overrides'");
        this.newLine("        options.compilerArgs << '-Xlint:-path'");
        this.newLine("        options.compilerArgs << '-Xlint:-processing'");
        this.newLine("        options.compilerArgs << '-Xlint:-rawtypes'");
        this.newLine("        options.compilerArgs << '-Xlint:-serial'");
        this.newLine("        options.compilerArgs << '-Xlint:-static'");
        this.newLine("        options.compilerArgs << '-Xlint:-try'");
        this.newLine("        options.compilerArgs << '-Xlint:-unchecked'");
        this.newLine("        options.compilerArgs << '-Xlint:-varargs'");
        this.newLine("    }");
        this.newLine("     dependencies {");
        this.newLine("        compile 'org.projectlombok:lombok:1.18.12'");
        this.newLine("        annotationProcessor 'org.projectlombok:lombok:1.18.12'");
        this.newLine("     }");
        this.newLine("}");

        return super.toString();
    }

    public String subProjectBuildGradle() {
        this.clear();
        this.newLine("apply plugin: 'java'");
        this.newLine("compileJava.options.encoding = 'UTF-8'");
        this.newLine("compileTestJava.options.encoding = 'UTF-8'");

        this.newLine("sourceSets {");
        this.newLine("    main {");
        this.newLine("        resources.srcDirs = ['src/main/resources', 'src/main/java']");
        this.newLine("    }");
        this.newLine("}");
        return super.toString();
    }

    public String settingsGradle() {

        this.clear();
        this.newLine("rootProject.name = '" + this.get(PROJECT_NAME) + "'");

        String moduleArtifactIds = this.get(MODULE_ARTIFACTIDS);
        String[] artifactIdArr = moduleArtifactIds.split(";");
        for(String artifactId : artifactIdArr) {
            if(artifactId != null && artifactId.trim().length() > 0) {
                this.newLine("include '" + artifactId.trim() + "'");
            }
        }

        return super.toString();
    }

    public String get(String key) {
        return infoMap.get(key);
    }

}