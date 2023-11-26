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
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates/exi"));
        configuration.setDefaultEncoding("UTF-8");

        Template template = configuration.getTemplate("demo.vue.ftl");

        Map<String, Object> dataModel = new HashMap<String, Object>();
        dataModel.put("title","新建查询页面");

        List<Map<String,Object>> menuItems= new ArrayList<Map<String,Object>>();
        Map<String,Object> menuItems1 = new HashMap<String,Object>();
        menuItems1.put("label","编号");
        menuItems1.put("queryParam","number");

        Map<String,Object> menuItems2 = new HashMap<String,Object>();
        menuItems2.put("label","申请人");
        menuItems2.put("queryParam","proposer");

        Map<String,Object> menuItems3 = new HashMap<String,Object>();
        menuItems3.put("label","接待对象");
        menuItems3.put("queryParam","receptiontarget");



        menuItems.add(menuItems1);
        menuItems.add(menuItems2);
        menuItems.add(menuItems3);

        dataModel.put("colList",menuItems);

        String name = template.getName();
        String newFileName = name.replace(".ftl", "");
        Writer writer = new FileWriter("src/main/resources/AfterGeneration/"+newFileName);
        template.process(dataModel,writer);

        writer.close();

    }
}
