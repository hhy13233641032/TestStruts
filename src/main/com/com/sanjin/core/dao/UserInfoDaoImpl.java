package com.sanjin.core.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserInfoDaoImpl implements UserInfoDao {
    public List getUserInfo(){
        List<Map<Integer,String>> lists = new ArrayList<Map<Integer, String>>();
        Map<Integer,String> maps= new LinkedHashMap<Integer,String>();
        maps.put(1,"huhy");
        maps.put(1,"zx");
        maps.put(1,"hx");
        maps.put(1,"zs");
        lists.add(maps);
        return lists;
    }
}
