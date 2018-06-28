package com.yoyocheknow.java;

/**
 * 类说明
 *  已知一个二维数组，左上角代表骑士的位置，右下角代表公主的位置，
 *  二维数组中存储整数，正数可以给骑士增加生命值，负数会减少骑士的生命值，
 *  问骑士初始时至少是多少生命值，才可保证骑士在行走的过程中至少保持生命值为1。(骑士只能向下或向右行走)
 *直接思考动态规划:
 * 从右下向左上递推: dp[i][j]即代表若要达到右下角， 至少有多少血量，能在行走的过程中至少保持生命值为1
     若代表地牢的二维数组为1*n或n*1的:
     1*n，i从n-2至0:
     dp[0][i] = max(1, dp[0][i+1] - dungeon[0][i])
     n*1，i从n-2至0:
     dp[i][0] = max(1, dp[i+1][0] - dungeon[i][0])

 * @author zhangzhihua
 * @date 2018/6/28 19:22
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int row=dungeon.length;
        int col=dungeon[0].length;

        int[][] dp=new int[row][col];
        dp[row-1][col-1]=Math.max(1,1-dungeon[row-1][col-1]);
        for(int i=row-2;i>=0;i--)
        {
            dp[i][col-1]=Math.max(1,dp[i+1][col-1]-dungeon[i][col-1]);
        }
        for(int j=col-2;j>=0;j--)
        {
            dp[row-1][j]=Math.max(1,dp[row-1][j+1]-dungeon[row-1][j]);
        }

        for(int i=row-2;i>=0;i--)
        {
            for(int j=col-2;j>=0;j--)
            {
                int dp_min=Math.min(dp[i+1][j],dp[i][j+1]);
                dp[i][j]=Math.max(1,dp_min-dungeon[i][j]);
            }
        }

        return dp[0][0];
    }
}
