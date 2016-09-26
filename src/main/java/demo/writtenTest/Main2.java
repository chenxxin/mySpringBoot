package demo.writtenTest;

import java.util.Scanner;

/**
 * 对于给定值 n，二进制中1的个数为 N
 * 输出 二进制中1的个数 等于 N， 且大于n的最小正整数
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            fun(n);
        }
    }

    private static void fun(int n){
        int ns = fun2(n);
        int ms;
        while (true){
            ms = fun2(++n);
            if (ms==ns){
                System.out.println(n);
                break;
            }
        }
    }

    /**
     * 二进制中1的个数
     */
    private static int fun2(int n){
        int count = 0;
        while (n>0){
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
