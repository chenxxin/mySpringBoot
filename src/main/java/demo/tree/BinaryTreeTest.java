package demo.tree;

import java.util.*;

/**
 现在有一颗合法的二叉树，树的节点都是数字表示，现在给定这棵树上所有的父子关系，求这棵树的高度
 输入的第一行表示节点个数为n，节点的编号为0到n-1组成，下面是n-1行，每行有两个整数，第一个数表示父节点的编号，第二个数表示子节点的编号
 输出树的高度，为一个整数。
 样例输入：
 5
 0 1
 0 2
 1 3
 1 4
 样例输出: 3
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            Map<Integer,Integer> map = new HashMap<>();
            int n = in.nextInt();
            for (int i = 0; i<n-1; i++){
                int a = in.nextInt();
                int b = in.nextInt();
                if (map.containsKey(a)){
                    map.put(b,map.get(a)+1);
                }else {
                    map.put(a,1);
                    map.put(b,2);
                }
            }
            Collection<Integer> values = map.values();
            int max = 0;
            for (int value : values){
                if (value>0){
                    max = value;
                }
            }
            System.out.println(max);
        }
    }
}



