package com.LoadBalance;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 轮询法
 * Created by young on 2016/10/23.
 */
public class RoundRobin {

    private static Integer pos = 0;

    public String getServer(){
        HashMap serverMap =  IpMap.serverWeightMap;
        ArrayList<String> keyList = new ArrayList<String>();
        keyList.add(serverMap.keySet().toString());
        String server = null;
        synchronized (pos){
            for( ; pos<keyList.size(); pos++){
                server =  keyList.get(pos);
            }
        }
        return server;
    }
}
