package com.ggh.common;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class GenerateUtils {

    /**
     *
     * @param templatePath  模板位置
     * @param templateName  模板文件名
     * @param outputPath    输出路径
     * @param model         数据模型
     * @throws IOException
     * @throws TemplateException
     */
    public static void doGenerate(String templatePath,String templateName,String outputPath,Object model) throws IOException, TemplateException {

        if(StringUtils.isEmpty(templateName)){
            throw new RuntimeException("模板路径不能为空");
        }
        if(StringUtils.isEmpty(templateName)){
            throw new RuntimeException("模板文件名不能为空");
        }
        if(model == null){
            throw new RuntimeException("数据不能为空");
        }
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration conf = new Configuration(Configuration.VERSION_2_3_32);
        // 指定模板文件所在的路径
        File FileTemplatePath = new File(templatePath);
        conf.setDirectoryForTemplateLoading(FileTemplatePath);

        //设置模板文件使用的字符集
        conf.setDefaultEncoding("UTF-8");

        // 创建模板对象，加载指定模板
        String name = new File(templateName).getName();
        System.out.println("模板名称:"+name);
        Template template =  conf.getTemplate(templateName);

        //生成
        String outputFileName = templateName.replace(".ftl", ".");
        Writer  writer = null;
        if(StringUtils.isNotBlank(outputPath)){
            writer = new FileWriter(outputPath+outputFileName);
        }else{
            //如果没传入输出路径，默认存放在resources目录
            String property = System.getProperty("user.dir")+"\\src\\main\\resources\\";
            System.out.println("文件路径："+property);
            writer = new FileWriter(property+outputFileName);
        }
        template.process(model,writer);
        writer.close();
    }

}
