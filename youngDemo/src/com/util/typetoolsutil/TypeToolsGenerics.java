package com.cxyapi.generics;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by sunsy3 on 2015/1/7.
 * 增强型的instanceof方法 可以判断基本的数据类型
 */
public class TypeToolsGenerics
{
    private static final Map<String,String> typeMap=new HashMap<String,String>();
    static
    {
        typeMap.put("java.lang.Byte", "byte");
        typeMap.put("java.lang.Short", "short");
        typeMap.put("java.lang.Integer", "int");
        typeMap.put("java.lang.Long", "long");
        typeMap.put("java.lang.Double", "double");
        typeMap.put("java.lang.Float", "float");
        typeMap.put("java.lang.Character", "char");
        typeMap.put("java.lang.Boolean", "boolean");
    }
    public final static <T> String getType(T t)
    {
        if(t==null){return null;}
        String typeInfo=t.getClass().getName();
        return typeMap.containsKey(typeInfo)?typeMap.get(typeInfo):typeInfo;
    }
}