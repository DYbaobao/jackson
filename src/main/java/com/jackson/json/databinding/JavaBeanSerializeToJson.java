package com.jackson.json.databinding;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
       }
}
