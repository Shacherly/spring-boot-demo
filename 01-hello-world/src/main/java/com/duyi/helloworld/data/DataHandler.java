package com.duyi.helloworld.data;

import com.google.gson.Gson;

import java.util.Map;

public class DataHandler {

    public static String str = "{\"name\": \"shizehao\"}";

    public static void main(String[] args) {
        System.out.println(str);
        Gson gson = new Gson();
        Map map = gson.fromJson(str, Map.class);
        System.out.println(map);
    }
}
