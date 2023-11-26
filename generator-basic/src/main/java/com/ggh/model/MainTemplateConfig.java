package com.ggh.model;

import lombok.Data;

import java.util.Date;

/**
 * 动态模版配置
 */
@Data
public class MainTemplateConfig {
    /**
     * 是否生成循环
     */
    private boolean loop;

    /**
     * 作者注释
     */
    private String author = "GuanHao";

    /**
     * 输出信息
     */
    private String outputText = "sum = ";

    /**
     * 创建时间
     */
    private String createDate;
}
