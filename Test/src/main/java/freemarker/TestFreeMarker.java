package freemarker;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-08 14:34
 *  
 */
public class TestFreeMarker {
    public static void main(String[] args) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setDirectoryForTemplateLoading(new File("E:\\workspace\\Working\\Test\\target\\classes\\freemarker"));
        configuration.setObjectWrapper(new DefaultObjectWrapper());
        configuration.setDefaultEncoding("UTF-8");

        Template template = configuration.getTemplate("sss.html");
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("description","learnning freemarker ,我们重在学习freemarker");
        List<String> nameList = new ArrayList<String>();
        nameList.add("张三");
        nameList.add("李四");
        nameList.add("王五");

        paramMap.put("nameList",nameList);

        Map<String,Object> weaponMap = new HashMap();
        weaponMap.put("first", "轩辕剑");
        weaponMap.put("second", "崆峒印");
        weaponMap.put("third", "女娲石");
        weaponMap.put("fourth", "神农鼎");
        weaponMap.put("fifth", "伏羲琴");
        weaponMap.put("sixth", "昆仑镜");
        weaponMap.put("seventh", null);
        paramMap.put("weaponMap", weaponMap);

        Writer writer = new OutputStreamWriter(new FileOutputStream("E:\\workspace\\Working\\Test\\target\\classes\\freemarker\\success.html"),"UTF-8");
        template.process(paramMap,writer);

        System.out.println("congratulations ! you make it !");
    }
}
