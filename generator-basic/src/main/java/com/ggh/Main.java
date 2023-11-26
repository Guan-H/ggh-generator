package com.ggh;

import com.ggh.generator.StaticGenerator;

import java.io.File;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //获取文件的根目录
        String property = System.getProperty("user.dir");
//        property += "\\generator-basic";   //如果可以生成在generator-basi目录就加上这个
        System.out.println(property);
        File projectPath = new File(property);
        //输入路径：ACM示例代码模板目录
        String inputPath = new File(projectPath, "generator-demo-project/acm-template").getAbsolutePath();
        //输出路径：直接输出到项目的根目录
        String outputPath = property;
        StaticGenerator.copyFilesByRecursive(inputPath,outputPath);
    }
}