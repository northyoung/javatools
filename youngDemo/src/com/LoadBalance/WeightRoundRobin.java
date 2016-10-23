package com.LoadBalance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 加权轮询法
 * Created by young on 2016/10/23.
 */
public class WeightRoundRobin {

    private static Integer pos = 0;

    public String getServer(){
        HashMap<String,Integer> serverMap =  IpMap.serverWeightMap;
        ArrayList<String> keyList = new ArrayList<String>();

        Set serverMapSet =  serverMap.keySet();
        Iterator<String> iterator = serverMapSet.iterator();
        while(iterator.hasNext()){
            String server = iterator.next();
            Integer weight = serverMap.get(server);
            for(int weightCount = 0;weightCount < weight; weightCount++){
                keyList.add(server);
            }
        }
        String server = null;
        synchronized (pos){
            for( ; pos<keyList.size(); pos++){
                server =  keyList.get(pos);
            }
        }
        return server;
    }
}
