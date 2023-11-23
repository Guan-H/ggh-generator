package com.ggh.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class staticGenerator {


    /**
     * 拷贝文件（Hutool 实现，会将输入目录完整拷贝到输出目录下）
     *
     * @param inputPath
     * @param outputPath
     */
    public static void copyFileByHutool(String inputPath,String outputPath){
        FileUtil.copy(inputPath,outputPath,false);
    }

    /**
     * 递归拷贝文件（递归实现，会将输入目录完整拷贝到输出目录下）
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByRecursive(String inputPath,String outputPath){
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);

        try {
            copyFileByRecursive(inputFile,outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 文件 A => 目录 B，则文件 A 放在目录 B 下
     * 文件 A => 文件 B，则文件 A 覆盖文件 B
     * 目录 A => 目录 B，则目录 A 放在目录 B 下
     *
     * 核心思路：先创建目录，然后遍历目录内的文件，依次复制
     * @param inputFile
     * @param outputFile
     * @throws IOException
     */
    private static void copyFileByRecursive(File inputFile, File outputFile) throws IOException {
        //区分是文件还是目录
        if(inputFile.isDirectory()){
            System.out.println(inputFile.getName());
            File descOutputFile = new File(outputFile,inputFile.getName());
            // 如果是目录，首先创建目标目录
            if(!descOutputFile.exists()){
                descOutputFile.mkdirs();
            }
            // 获取目录下的所有文件和子目录
            File[] files = inputFile.listFiles();
            // 无子文件，直接结束
            if(ArrayUtil.isEmpty(files)){
                return;
            }
            for (File file : files) {
                // 递归拷贝下一层文件
                copyFileByRecursive(file,descOutputFile);
            }
        }else{
            // 是文件，直接复制到目标目录下
            Path descPath = outputFile.toPath().resolve(inputFile.getName());
            FileUtil.copy(inputFile.toPath(), descPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }



}
