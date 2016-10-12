package com.util.typetoolsutil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunsy3 on 2015/1/7.
 * 增强型的instanceof方法 可以判断基本的数据类型
 */
public class TypeTools {
    public static Map<String,String> getType(Object obj){
        Map<String,String> typeinfo = new HashMap<String,String>();
        typeinfo.put("类型", obj.getClass().getSimpleName());
        typeinfo.put("描述","引用类型");
        return typeinfo;
    }
    public static Map<String,String> getType(int i){
        Map<String,String> typeinfo = new HashMap<String,String>();
        typeinfo.put("类型", "int");
        typeinfo.put("描述","引用类型");
        return typeinfo;
    }
    public static Map<String,String> getType(long l)
    {
        Map<String,String> typeInfo=new HashMap<String,String>();
        typeInfo.put("类型", "long");
        typeInfo.put("描述", "长整型");
        return typeInfo;
    }

    public static Map<String,String> getType(boolean b)
    {
        Map<String,String> typeInfo=new HashMap<String,String>();
        typeInfo.put("类型", "boolean");
        typeInfo.put("描述", "布尔类型");
        return typeInfo;
    }

    public static Map<String,String> getType(char b)
    {
        Map<String,String> typeInfo=new HashMap<String,String>();
        typeInfo.put("类型", "char");
        typeInfo.put("描述", "字符");
        return typeInfo;
    }

    public static Map<String,String> getType(float f)
    {
        Map<String,String> typeInfo=new HashMap<String,String>();
        typeInfo.put("类型", "float");
        typeInfo.put("描述", "单精度浮点型");
        return typeInfo;
    }

    public static Map<String,String> getType(double d)
    {
        Map<String,String> typeInfo=new HashMap<String,String>();
        typeInfo.put("类型", "double");
        typeInfo.put("描述", "双精度浮点型");
        return typeInfo;
    }

    public static Map<String,String> getType(String s)
    {
        Map<String,String> typeInfo=new HashMap<String,String>();
        typeInfo.put("类型", "String");
        typeInfo.put("描述", "字符串类型");
        return typeInfo;
    }

}
