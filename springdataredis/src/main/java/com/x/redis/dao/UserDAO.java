package com.x.redis.dao;

import com.x.redis.obj.User;

/**
 * Created by young on 2016/10/20.
 */
public interface UserDAO {
    public void savaUsee(User user);
    public User getUser(long id);
}
