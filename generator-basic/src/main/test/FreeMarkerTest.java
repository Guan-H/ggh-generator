import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FreeMarkerTest {

    public static void main(String[] args) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        configuration.setDefaultEncoding("UTF-8");

        Template template = configuration.getTemplate("MyWeb.html.ftl");

        Map<String, Object> dataModel = new HashMap<String, Object>();
        dataModel.put("currentYear",2023);

        List<Map<String,Object>> menuItems= new ArrayList<Map<String,Object>>();
        Map<String,Object> menuItems1 = new HashMap<String,Object>();
        menuItems1.put("url","http://www.baidu.com");
        menuItems1.put("label","百度");
        Map<String,Object> menuItems2 = new HashMap<String,Object>();
        menuItems2.put("url","http://www.bilibili.com");
        menuItems2.put("label","BiliBili");

        Map<String,Object> menuItems3 = new HashMap<String,Object>();
        menuItems2.put("url","http://www.bilibili.com");
        menuItems2.put("label","BiliBili");

        menuItems.add(menuItems1);
        menuItems.add(menuItems2);
        menuItems.add(menuItems3);

        dataModel.put("menuItems",menuItems);

        Writer writer = new FileWriter("MyWeb.html");
        template.process(dataModel,writer);

        writer.close();

    }
}
