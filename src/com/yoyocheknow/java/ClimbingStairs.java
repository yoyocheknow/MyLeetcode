package com.yoyocheknow.java;

/**
 * 类说明
 *  动态规划解决爬楼梯问题
 *  你正在爬楼梯。需要 n 步你才能到达顶部。

    每次你可以爬 1 或 2 个台阶。你有多少种不同的方式可以爬到楼顶呢？

    注意：给定 n 将是一个正整数。
 * @author zhangzhihua
 * @date 2018/4/1 9:06
 */
public class ClimbingStairs {
    public static int solution(int stairs)
    {
        if(stairs==0)
            return 0;
        int []dp =new int[stairs+3];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<dp.length;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[stairs];
    }
    public static void main(String args[])
    {
        System.out.print("nums="+solution(3));
    }
}
