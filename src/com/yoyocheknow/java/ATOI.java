package com.yoyocheknow.java;

/**
 * 类说明
 *Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases.
 * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 *将字符串转化为int类型的数字。（要考虑各种情况）
 * @author zhangzhihua
 * @date 2017/12/25 17:15
 */
public class ATOI {
    //方法一，这个方法我考虑复杂了。而且没有考虑int越界的情况。

    public static int myAtoi(String str) {
        int sign=1;
        if(str.contains("-"))
        {
            sign=-1;
        }
        char ch[] =str.toCharArray();
        int temp=ch.length;
        int sum=0;
        int n=1;
        while (temp>0){
            if(isNumber(ch[temp-1]))
            {
                System.out.println("ch[temp-1]="+(ch[temp-1]-48));
                sum=sum+(ch[temp-1]-48)*n;
                n=n*10;
            }
            temp--;
        }
        return sum*sign;
    }
    public static boolean isNumber(char ch)
    {
        boolean bool = false;
        switch (ch)
        {
            case 48:bool=true;break;
            case 49:bool=true;break;
            case 50:bool=true;break;
            case 51:bool=true;break;
            case 52:bool=true;break;
            case 53:bool=true;break;
            case 54:bool=true;break;
            case 55:bool=true;break;
            case 56:bool=true;break;
            case 57:bool=true;break;
        }
        return bool;
    }

    public static int myAtoi2(String str) {
        if(str==null)
        {
            return 0;
        }
        str = str.trim();
        if(str.length()==0)
            return 0;
        boolean isNeg = false;
        int i = 0;
        if(str.charAt(0)=='-' || str.charAt(0)=='+')
        {
            i++;
            if(str.charAt(0)=='-')
                isNeg = true;
        }
        int res = 0;
        while(i<str.length())
        {
            if(str.charAt(i)<'0'||str.charAt(i)>'9')
                break;
            int digit = (int)(str.charAt(i)-'0');
            if(isNeg && res>-((Integer.MIN_VALUE+digit)/10))
                return Integer.MIN_VALUE;
            else if(!isNeg && res>(Integer.MAX_VALUE-digit)/10)
                return Integer.MAX_VALUE;
            res = res*10+digit;
            i++;
        }
        return isNeg?-res:res;
    }
    public static void main(String args[])
    {
        System.out.print("out="+myAtoi(" 1 23 "));
    }
}
