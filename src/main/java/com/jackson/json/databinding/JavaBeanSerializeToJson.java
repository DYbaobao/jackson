package com.jackson.json.databinding;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/7.
 */
public class JavaBeanSerializeToJson {
       public  static  void  convert() throws Exception {
           // 使用ObjectMapper来转化对象为Json
           ObjectMapper mapper = new ObjectMapper();
           // 添加功能，让时间格式更具有可读性
           SimpleDateFormat dateFormat  = new SimpleDateFormat("yyyy-MM-dd");
           mapper.setDateFormat(dateFormat);

           Country country = new Country();
           country.setBirthDate(dateFormat.parse("1949-10-02"));
           country.setLakes(new String[] {"Qinghai lake","Poyang lake","Dongting lake","Taihu lake"});

           List<String> nation = new ArrayList<String>();
           nation.add("Han");
           nation.add("Meng");
           nation.add("Hui");
           nation.add("Tang");
           nation.add("wang");
           country.setNation(nation);

           Province province = new Province();
           province.name="ShanXi";
           province.population=37751200;
           Province province1 = new Province();
           province1.name = "ZheJiang";
           province1.population=55080000;
           List<Province> provinces = new ArrayList<Province>();
           provinces.add(province);
           provinces.add(province1);

           Map<String,Integer> map = new HashMap<String, Integer>();
           map.put("Train(KM)",112000);
           map.put("HighWay(HM)",4240000);
           country.setTraffic(map);
           // 为了使JSON视觉上的可读性，增加一行如下代码，注意，在生产中不需要这样，因为这样会增大Json的内容
           mapper.configure(SerializationFeature.INDENT_OUTPUT,true);
           // 配置mapper忽略空属性
           mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
           // 默认情况，Jackson使用Java属性字段名称作为 Json的属性名称,也可以使用Jackson annotations(注解)改变Json属性名称
           mapper.writeValue(new File("country.json"),country);
       }

    public static void main(String[] args) throws Exception {
        convert();
    }
}
