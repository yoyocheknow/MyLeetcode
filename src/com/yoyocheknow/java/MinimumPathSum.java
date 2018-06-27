package com.yoyocheknow.java;

/**
 * 类说明
 *Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * 已知一个二维数组，其中存储了非负整数，找到从左上角到右下角的一条路径，使得路径上的和最小。(移动过程中只能向下或向右)
 *设dp[i][j]为到达位置(i,j)时的最优解(最小值)：
 dp[i][j]与dp[i-1][j]、dp[i][j-1]、grid[i][j]之间的关系是什么？ 动态规划的边界条件是什么？
 dp[i][j]=Min(dp[i-1][j],dp[i][j-1])+grid[i][j];
 * @author zhangzhihua
 * @date 2018/6/27 18:48
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length==0)
        {
            return 0;
        }
        int row=grid.length;
        int col=grid[0].length;
        int[][] dp=new int[row][col];

        dp[0][0]=grid[0][0];

        for(int i=1;i<col;i++)
        {
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        for(int i=1;i<row;i++)
        {
            dp[i][0]=dp[i-1][0]+grid[i][0];

            for(int j=1;j<col;j++)
            {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }
}
