package com.yoyocheknow.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 类说明
 *Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 给定一个二维数组，其保存了一个数字三角形，求从数字三角形顶端到底
 端各数字和最小的路径之和，每次可以向下走相邻的两个位置


 * @author zhangzhihua
 * @date 2018/6/20 19:47
 */
public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0)
            return 0;

        for(int i=triangle.size()-2;i>=0;i--)
        {
            List<Integer> triangleRow = triangle.get(i);
            for(int j=0;j<triangleRow.size();j++)
            {
               int left=triangle.get(i+1).get(j);
               int right=triangle.get(i+1).get(j+1);
                triangleRow.set(j,triangleRow.get(j)+Math.min(left,right));
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String args[])
    {
        List<List<Integer>> triangle=new ArrayList<List<Integer>>();
        List<Integer> firstRow=new ArrayList<>();
        firstRow.add(2);
        List<Integer> firstRow1=new ArrayList<>();
        firstRow1.add(3);
        firstRow1.add(4);
        List<Integer> firstRow2=new ArrayList<>();
        firstRow2.add(6);
        firstRow2.add(5) ;
        firstRow2.add(7);

        List<Integer> firstRow3=new ArrayList<>();
        firstRow3.add(4);
        firstRow3.add(1);
        firstRow3.add(8);
        firstRow3.add(3);


        triangle.add(firstRow);
        triangle.add(firstRow1);
        triangle.add(firstRow2);triangle.add(firstRow3);
        System.out.print("num="+minimumTotal(triangle));

    }
}
