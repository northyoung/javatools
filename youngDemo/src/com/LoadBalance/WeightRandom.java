package com.LoadBalance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by young on 2016/10/23.
 */
public class WeightRandom {

    public static String getServer() {
        HashMap<String,Integer> serverMap =  IpMap.serverWeightMap;
        ArrayList<String> keyList = new ArrayList<String>();
        Set serverMapSet = serverMap.keySet();

        keyList.add(serverMapSet.toString());
        String server = null;

        Iterator<String> iterator = serverMapSet.iterator();
        while(iterator.hasNext()){
            server = iterator.next();
            Integer weight = serverMap.get(server);
            for(int weightCount = 0;weightCount < weight; weightCount++){
                keyList.add(server);
            }
        }

        java.util.Random random = new java.util.Random();
        Integer randInt = random.nextInt(keyList.size());
        server = keyList.get(randInt);

        return server;
    }
}
