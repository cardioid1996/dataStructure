package com.ds.structure;
import java.util.ArrayList;
import java.lang.Thread;
import java.util.Arrays;
import java.util.List;

public class Generic {
    public static void main(String[] args) throws Exception{
        ArrayList<String> list = new ArrayList<>();
        list.getClass().getMethod("add", Object.class).invoke(list, "tt");
        list.getClass().getMethod("add", Object.class).invoke(list, 22.33);
        for (int i=0; i<list.size(); i++) {
            System.out.println((Object) list.get(i));
        }
    }
}
