package com.x.redis;

import com.x.redis.dao.UserDAO;
import com.x.redis.obj.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * http://www.cnblogs.com/tankaixiong/p/3660075.html
 * Created by young on 2016/10/21.
 */
public class TestMain {
    public static void main(String[] args){
        ApplicationContext ac =  new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
        UserDAO userDAO = (UserDAO)ac.getBean("userDAO");
        User user1 = new User();
        user1.setId(1);
        user1.setName("obama");
        userDAO.saveUser(user1);
        User user2 = userDAO.getUser(1);
        System.out.println(user2.getName());
    }
}
