package com.x.redis.obj;

/**
 * Created by young on 2016/10/20.
 */
public class User {
    private long id ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name ;
}
