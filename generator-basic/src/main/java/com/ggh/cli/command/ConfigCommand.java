package com.ggh.cli.command;


import cn.hutool.core.util.ReflectUtil;
import com.ggh.model.MainTemplateConfig;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.lang.reflect.Field;

@Command(name = "config", description="查看参数信息",mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable {

    @Override
    public void run() {
        //实现config命令的逻辑
        System.out.println("查看参数信息");

        //1、通过反射获取类的所有字段
//        Class<?> myClass = MainTemplateConfig.class;
//        Field[] declaredFields = myClass.getDeclaredFields();

        //2、通过工具获取类的所有字段
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);

        //遍历打印每个字段的信息
        for (Field field : fields) {
            System.out.println("字段名称 = " + field.getName());
            System.out.println("字段类型 = " + field.getType());
            System.out.println("----------------------------------------------------------------");
        }
    }



}
