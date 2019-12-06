package com.ds.algorithms;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map;

public class FirstNoRepeat {
    private LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

    //Insert one char from stringstream
    public void Insert(char c)
    {
        if (map.containsKey(c)){
            map.put(c, map.get(c)+1);
        }
        map.put(c, 1);


    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char result = '#';
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry tmp = (Map.Entry)iter.next();
            if (tmp.getValue().equals(1)){
                return (Character)tmp.getKey();
            }
        }
        return '#';

    }
}