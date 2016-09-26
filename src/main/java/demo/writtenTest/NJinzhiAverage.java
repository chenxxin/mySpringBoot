package demo.writtenTest;

import java.util.Scanner;

/**
 * 自然数n，用2进制、3进制...n-1进制 表示的各个位数之和的平均。
 * 例：n=4,2进制：100  各位数和：1
 *         3进制：11   各位数和：2
 *     故结果为：(1+2)/2
 */
public class NJinzhiAverage
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int n;
        while(cin.hasNextInt())
        {
            n = cin.nextInt();
            fun(n);
        }
    }

    private static void fun(int n){
        int sum = 0;
        for (int i = 2;i<=n-1; i++){ // 求出sum 的值
            int m = n;
            while (m>0){
                sum += m%i;
                m = m/i;
            }
        }
        int gcd = getGcd(sum, n-2); // 求出 sum 和 (n-2) 的最大公约数 greatest common divisor
        sum = sum/gcd;
        int denominator = (n-2)/gcd; // 分母
        System.out.println(sum + "/" + denominator);

    }

    private static int getGcd(int a, int b){
        if (b==0){
            return a;
        }
        return getGcd(b, a%b);
    }
}
