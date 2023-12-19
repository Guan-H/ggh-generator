package com.ggh.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.ggh.generator.MainGenerator;
import com.ggh.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;


@Command(name="generate", description="生成代码",mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {


    @Option(names = {"-l","--loop"},arity = "0..1", description="是否生成循环",interactive = true)
    private boolean loop;

    @Option(names = {"-a","--author"},arity = "0..1", description="作者名字",interactive = true)
    private String author;


    @Option(names = {"-o","--outputText"},arity = "0..1", description="输出文本",interactive = true)
    private String outputText =  "sum = ";

    @Override
    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        Date date = new Date();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = simpleDate.format(date);
        mainTemplateConfig.setCreateDate(nowDate);
        BeanUtil.copyProperties(this, mainTemplateConfig);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }
}
