package com.jackson.json.databinding;

/**
 * Created by Administrator on 2018/4/8.
 */

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 将json串反序列化为java对象
 */
public class JsonDeserializeToJava {
          public static void main (String [] args) throws Exception {
              //ObjectMapper类用序列化与反序列化映射器
              ObjectMapper mapper = new ObjectMapper();
              File json = new File("country.json");
              //当反序列化json时，未知属性会引起的反序列化被打断，这里我们禁用未知属性打断反序列化功能，
              //因为，例如json里有10个属性，而我们的bean中只定义了2个属性，其它8个属性将被忽略
              mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

              //从json映射到java对象，得到country对象后就可以遍历查找,下面遍历部分内容，能说明问题就可以了

              Country country =mapper.readValue(json,Country.class);
              System.out.println("country_id"+country.getCountry_id());
              //设置时间格式，便于阅读
              SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
              String birthDate = dateFormat.format(country.getBirthDate());
              System.out.println("birthDate"+birthDate);

              List<Province> provinces = country.getProvinces();
              for (Province province : provinces) {
                  System.out.println("province:"+province.name + "\n" + "population:"+province.population);
              }
          }
}
