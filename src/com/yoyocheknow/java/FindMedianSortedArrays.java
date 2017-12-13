package com.yoyocheknow.java;

import java.util.Arrays;

/**
 * 类说明
 *There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 *Example 1:
 *nums1 = [1, 3]
  nums2 = [2]
 The median is 2.0

 *Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 * 一开始我的思路是想用排序二叉树的思想来做，这样可以控制时间复杂度为O(log (m+n))，但是要首先找到中间那个点，但是这样的话，二叉树似乎有没有什么作用了。
 * @author zhangzhihua
 * @date 2017/12/11 17:31
 */
public class FindMedianSortedArrays {
    //方法一：
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res =0;
        int m=nums1.length;
        int n=nums2.length;
        if(m>n)
        {
            int [] temp=nums1;
            nums1=nums2;
            nums2=temp;
            int tmp;
            tmp=m;
            m=n;
            n=tmp;

        }
        int iMin=0,iMax=m,halfLen=(iMin+iMax)/2;
        while(iMin<=iMax)
        {
            int i=iMin;
            int j=halfLen-i;

            if(i<iMax&&nums2[j-1]>nums1[i])
            {
                iMin++;// i is too small
            }else if(i>iMin&&nums1[i-1]>nums2[j])
            {
                iMax--;//i is too big
            }else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = nums2[j-1]; }
                else if (j == 0) { maxLeft = nums1[i-1]; }
                else { maxLeft = Math.max(nums1[i-1], nums2[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = nums2[j]; }
                else if (j == n) { minRight = nums1[i]; }
                else { minRight = Math.min(nums2[j], nums1[i]); }

                return (maxLeft + minRight) / 2.0;
            }

        }
        return 0.0;
    }
    //方法二：感觉这个用到了array.sort()方法，有种作弊的感觉。
       public double findMedianSortedArrays1(int[] nums1, int[] nums2) {

        int[] sum = new int[nums1.length+nums2.length];
        for(int i=0;i<nums1.length;i++) {
            sum[i] = nums1[i];
        }
        for(int i=0;i<nums2.length;i++) {
            sum[i+nums1.length] = nums2[i];
        }
        Arrays.sort(sum);
        int n = sum.length / 2;
        if( sum.length % 2 == 0) {
            return ((double)sum[n] + sum[n-1]) / 2;
        } else {
            return (double)sum[n];
        }
    }
    public static  void main(String args[])
    {
        int[] n1 =new int[]{1,2};
        int[] n2 = new int[]{3,4};

        double d = findMedianSortedArrays(n1,n2);
        System.out.print("d="+d);
    }

}
