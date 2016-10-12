package com.ApacheUtilDemo;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by sunsy3 on 2015/2/12.
 */
public class SampleBean {
    public String name;
    public int age;
    public String[] array;
    public List list;
    public Map map;
    private NestedBean nestedBean;
    private URL url;

    public int getAge() {
        return age;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setNestedBean(NestedBean nestedBean) {
        this.nestedBean = nestedBean;
    }

    public NestedBean getNestedBean() {
        return nestedBean;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
