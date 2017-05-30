package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>();
        list.add(1);
        list.add(Arrays.asList(1, 2, 3));
        list.add(Arrays.asList(1, 200, 3));
        List<Object> nestedList = new ArrayList<Object>();
        nestedList.add(1);
        nestedList.add(Arrays.asList(6, 6));
        nestedList.add(Arrays.asList(7, 7));
        list.add(nestedList);
        List<Integer> result = getAllNumbers(list);
        System.out.println(result);
    }

    private static List<Integer> getAllNumbers(List<Object> list) {
        List<Integer> result = new ArrayList<Integer>();
        for (Object instance:
             list) {
            nestedHandler(result, instance);
        }
        return result;
    }

    private static void nestedHandler(List<Integer> result, Object instance) {
        if (instance instanceof Integer) {
            result.add((Integer) instance);
        } else {
            for (Object nestedInstance:
                    (List<Integer>) instance) {
                nestedHandler(result, nestedInstance);
            }
        }
    }

}
