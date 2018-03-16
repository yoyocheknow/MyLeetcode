package com.yoyocheknow.java;

import java.util.Stack;

/**
 * 类说明
 *已知一个使用字符串表示的非负整数num，将num中的k个数字移除， 求移除k个数字后，可以获得的最小的可能的新数字。
 * (num不会以0开头,num长度小于10002)
 输入 : num = “1432219” , k = 3 在去掉3个数字后得到的很多很多可能里，
 如1432、4322、2219、1219、 1229...；去掉数字4、3、2得到的1219最小！

 * @author zhangzhihua
 * @date 2018/3/10 10:13
 */
public class Remove_K_Digits {
    public static String removeKdigits(String num, int k) {
        Stack stack=new Stack();
        StringBuilder result=new StringBuilder();
        for(int i=0;i<num.length();i++)
        {
            int number=num.charAt(i)-'0';
            while (stack.size()!=0&&k>0&&(Integer)stack.peek()>number)
            {
                stack.pop();
                k--;
            }
            if(number!=0||stack.size()!=0)
            {
                stack.push(number);
            }

        }
        while(stack.size()!=0&&k>0)
        {
            stack.pop();
            k--;
        }

        for(int i=0;i<stack.size();i++)
        {
            result.append(stack.get(i));
        }
        if("".equals(result.toString()))
        {
            result=new StringBuilder("0");
        }


        return result.toString();
    }
    public static void main(String args[])
    {
        String s=removeKdigits("10",2);
        System.out.print("s="+s);
    }
}
