package com.ggh.generator;


import cn.hutool.http.webservice.SoapUtil;
import com.ggh.common.GenerateUtils;
import com.ggh.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.SimpleDate;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 动态文件生成
 */
public class DynamicGenerator {

    public static void main(String[] args) throws IOException, TemplateException {

        String property = System.getProperty("user.dir");
        File parentFile = new File(property);
        String inputPath = parentFile.getPath();
        System.out.println("Path"+parentFile.getPath());
        //模板路径
        String templatePath = inputPath+"/generator-basic/src/main/resources/templates/";
        //模板名字
        String templateName = inputPath+"/generator-basic/src/main/resources/templates/mainTemplates.java.ftl";
        //文件输出位置
        String outputPath = inputPath+"/generator-basic/src/main/resources/AfterGeneration/";

        //创建数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("GuanHao");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果");
        Date date = new Date();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = simpleDate.format(date);
        mainTemplateConfig.setCreateDate(nowDate);

        GenerateUtils.doGenerate(templatePath,templateName,outputPath,mainTemplateConfig);

    }



}
