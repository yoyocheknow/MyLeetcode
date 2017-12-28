package com.yoyocheknow.java;

/**
 * 类说明
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.

    Note: You may not slant the container and n is at least 2.
    意思是给了一组非负数字作为X-Y轴的纵坐标，还有一个横坐标i，(i, ai) and (i, 0)作为一条线，求两天这样的线使和X轴围城的容器面积最大。
 * @author zhangzhihua
 * @date 2017/12/28 15:42
 */
public class ContainerWithMostWater {
    public static  int maxArea(int[] height) {
    if(height.length==0)
    {
        return 0;
    }

        int max=0;
        //暴力解法，复杂度为O2.
//        for(int i =0;i<height.length;i++)
//        {
//            for(int j=i;j<height.length;j++)
//            {
//                int high=height[i]<height[j]?height[i]:height[j];
//                int sum=(j-i)*high;
//                if(sum>max)
//                    max=sum;
//            }
//        }


        //方法二：
        /*
    设置两个指针i, j, 一头一尾, 相向而行. 假设i指向的挡板较低, j指向的挡板较高(height[i] < height[j]).
    下一步移动哪个指针?
    -- 若移动j, 无论height[j-1]是何种高度, 形成的面积都小于之前的面积.
    -- 若移动i, 若height[i+1] <= height[i], 面积一定缩小; 但若height[i+1] > height[i], 面积则有可能增大.
    综上, 应该移动指向较低挡板的那个指针.
        */
        int i=0;
        int j=height.length-1;
        while (i<j)
        {
            max=Math.max(max,(j-i)*Math.min(height[j],height[i]));
            if(height[j]>height[i])//move i
            {
                int k;
                for(k=i+1;height[k]<height[i]&&k<j;k++){}
                i=k;
            }else{//move j
                int k;
                for(k=j-1;height[k]<height[j]&&k>i;k--){}
                j=k;
            }
        }

        return max;

    }

    public static void main(String args[])
    {
        int []height={1,2,3,4};
        System.out.print("max is:"+maxArea(height));
    }
}
