package com.company.JavaAdvanced.Stream;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicate {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("Test","123");
        map.put("Test1","123");
        map.put("Test2","124");
        map.put("Test3","125");
        map.put("Test4","125");

        Set<String> set = new HashSet<>();
        map = map.entrySet().stream()
                .filter(entry -> set.add(entry.getValue()))
                .collect(Collectors.toMap(Map.Entry :: getKey, Map.Entry :: getValue));
        System.out.println(map);

        Set<String> stringSet = map.keySet();
    }
}
