package com.LoadBalance;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 原地址HASH法
 * Created by young on 2016/10/23.
 */
public class Hash {
    public static String getServer(){

        String server = null;

        HashMap serverMap =  IpMap.serverWeightMap;
        ArrayList<String> keyList = new ArrayList<String>();
        keyList.add(serverMap.keySet().toString());

        String remoteIp = "127.0.0.1";
        int hashCode = remoteIp.hashCode();
        int serverMapSize = serverMap.size();
        server = keyList.get(serverMapSize/hashCode);

        return server;
    }
}
