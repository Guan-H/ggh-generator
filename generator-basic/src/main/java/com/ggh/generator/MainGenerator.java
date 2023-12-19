package com.ggh.generator;


import com.ggh.common.GenerateUtils;
import com.ggh.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainGenerator {
    /**
     * 生成
     *
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        // 整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径
        String inputPath = new File(parentFile, "ggh-generator/acm-template").getAbsolutePath();
        String outputPath = projectPath+"/generator-basic";
        // 生成静态文件
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);

        // 生成动态文件
        String inputDynamicFilePath = projectPath +"/generator-basic/"+ File.separator + "src/main/resources/templates/";
        String outputDynamicFilePath = outputPath + File.separator + "acm-template/src/com/yupi/acm/";
        GenerateUtils.doGenerate(inputDynamicFilePath, "mainTemplates.java.ftl",outputDynamicFilePath, model);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("GGH");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        Date date = new Date();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = simpleDate.format(date);
        mainTemplateConfig.setCreateDate(nowDate);
        doGenerate(mainTemplateConfig);
    }



}
