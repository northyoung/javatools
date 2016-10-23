package com.LoadBalance;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 随机法
 * Created by young on 2016/10/23.
 */
public class Random {

    public static String getServer() {
        HashMap serverMap =  IpMap.serverWeightMap;
        ArrayList<String> keyList = new ArrayList<String>();
        keyList.add(serverMap.keySet().toString());
        String server = null;

        java.util.Random random = new java.util.Random();
        Integer randInt = random.nextInt(keyList.size());
        server = keyList.get(randInt);

        return server;
    }
}
