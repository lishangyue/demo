package test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.io.*;
import java.util.*;

public class test1 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        try {
            File file = new File("C:\\Users\\l17584\\Desktop\\1.txt");
            InputStreamReader insReader = new InputStreamReader(
                    new FileInputStream(file), "UTF-8");
            BufferedReader br = new BufferedReader(insReader);
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(s.trim());
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // list<Map<String,List<String>>>
        List ts = (List) JSONArray.parseArray(result.toString());
        Map<String, List> map = (Map<String, List>) ts.get(0);
        List resultList = new ArrayList();
        for (String key : map.keySet()) {
            Map<String,Object> mapResult = new HashMap<>();
            mapResult.put("areaname",key);
            mapResult.put("shortname",key);
            mapResult.put("level",1);
            List list1 = new ArrayList();
            Map map2 = (Map) map.get(key);
            for (Object key2 : map2.keySet()) {
                Map<String,Object> map1 = new HashMap<>();
                map1.put("areaname",key2);
                map1.put("shortname",key2);
                map1.put("level",2);
                List list3 = (List) map2.get(key2);
                List list4 = new ArrayList();
                for (int i = 0; i < list3.size(); i++) {
                    Map map4 = new HashMap();
                    map4.put("areaname",list3.get(i));
                    map4.put("shortname",list3.get(i));
                    map4.put("level",3);
                    list4.add(map4);
                }
                map1.put("children",list4);
                list1.add(map1);
            }
            mapResult.put("children",list1);
            resultList.add(0,mapResult);
        }
        String str = JSON.toJSONString(resultList);
        System.out.println(str);
    }
}
