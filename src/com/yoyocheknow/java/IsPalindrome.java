package com.yoyocheknow.java;

/**
 * 类说明
 *Determine whether an integer is a palindrome. Do this without extra space.
 * 判断一个数字是否是回文，要求不使用额外的空间
 * @author zhangzhihua
 * @date 2017/12/26 16:47
 */
public class IsPalindrome {
    public static boolean isPalindrome(int x) {
        if(x==0)
        {
            return true;
        }
        String s=String.valueOf(x);
        if(x<0)
        {
            return false;
           //s=s.substring(1,s.length());
        }
        System.out.print("s="+s);

        int n=0;
        while(n<=s.length()/2)
        {
            if(s.charAt(n)!=s.charAt(s.length()-n-1))
            {
                return false;
            }
            n++;
        }
        return true;
    }
    public static  void main(String args[])
    {
        System.out.print("result="+isPalindrome(-2147447412));
    }
}
