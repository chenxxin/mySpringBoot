package demo;

import java.util.ArrayList;
import java.util.List;

/**
 *  求数组arr中和为给定值sum的所有子数组
 *  n为数组的长度
 */
public class ArrayTest {
    public static void main(String[] args) {
        int n = 5;
        int sum = 15;
        int[] arr = {5,5,10,2,3};
        List<List> lists = new ArrayList<>();
        int[] record = new int[n];
        fun(arr, sum, 0, 0, lists,record);
        System.out.println(lists.size());
        for (List list: lists){
            System.out.println(list);
        }
    }
    private static void fun(int[] arr, int key, int sum, int n, List lists,int[] record) {
        if (n < arr.length) {
            for (int i = 0; i <= 1; i++) {
                sum += i * arr[n];
                record[n] = i;
                if (sum == key) {
                    List<Integer> list = new ArrayList<>();
                    for(int j=0; j<=n; j++){
                        if(record[j]==1){
                            list.add(arr[j]); // 返回数组元素
//                            list.add(j); // 返回数组元素下标
                        }
                    }
                    lists.add(list);
                }else if (sum < key) {
                    fun(arr, key, sum, n + 1, lists,record);
                }
                sum -= i * arr[n];
            }
        }
    }
}