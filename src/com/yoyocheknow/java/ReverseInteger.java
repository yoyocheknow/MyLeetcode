package com.yoyocheknow.java;

/**
 * 类说明
 *Given a 32-bit signed integer, reverse digits of an integer.
 * Example 1:
 * Input: 123
 Output:  321

 Example 2:
 Input: -123
 Output: -321

 Example 3:
 Input: 120
 Output: 21
 Note:
 Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
 For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * @author zhangzhihua
 * @date 2017/12/22 16:21
 */
public class ReverseInteger {
    public static  int reverse(int x) {
        if(x==0)
            return 0;
        String s="";
        if(x<0)
        {
            s=String.valueOf(x);
            s=s.substring(1,s.length());
            System.out.println("s="+s);
        }else{
            s=String.valueOf(x);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=s.length();i>0;i--)
        {
            sb.append(s.charAt(i-1));

        }
        System.out.println("sb="+sb.toString());
        int res=0;
        try{
            res =Integer.parseInt(sb.toString());//如果int太大，反转时会出现异常
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        if(x<0)
        {
            return -res;

        }else{
            return  res;
        }


    }
    public static void main(String args[])
    {
        System.out.print("num="+reverse(123));
    }
}
