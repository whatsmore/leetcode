package com.wcm.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyList {
    public static List<Integer> changeArrayToList(Integer[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>(arr.length);
        Collections.addAll(arrayList, arr);
        return arrayList;
    }

    public static List<List<Integer>> changeArrayToList(int[][] arr) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> columnList = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                columnList.add(j, arr[i][j]);
            }
            result.add(i, columnList);
        }
        return result;
    }
}
