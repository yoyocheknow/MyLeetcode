package com.yoyocheknow.java;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 类说明
 *
 *Given a string, find the length of the longest substring without repeating characters
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 求一个字符串的最长的无重复子字符串
 总体思路是：声明一个arrayList来存放最长的字符串，每准备新加一个字符，就和之前的list中的字符比较，如果都不一致那么就加入。并记录每次list的长度，最后拿最长的即可。
 * @author zhangzhihua
 * @date 2017/12/6 17:57
 */
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        char[] param = s.toCharArray();
        ArrayList<Character> list = new ArrayList<Character>();
        ArrayList<Integer> array = new ArrayList<Integer>();
        int length=0;

        for(int i=0;i<param.length;i++)
        {

            list.add(param[i]);
            if(i+list.size()>param.length)//防止出现最后一串没有重复字符，在加入list后还从i+1加入新字符串的情况。示例“pwwkew”
            {
                break;
            }
            System.out.println("list[i循环中]="+list.toString());
            System.out.println("list.add(param[i])="+param[i]);
            array.add(list.size());
            out:
            for(int j=i+1;j<param.length;j++)
            {
                System.out.println("要加入list的字符="+param[j]);
                for(int k=0;k<list.size();k++)//判断下一个字符是否有与list中一致的，一致则跳出循环，记录长度、存档
                {
                    System.out.println("list[j循环中]="+list.toString()+",k="+k);
                    if(param[j]==list.get(k))
                    {
                        array.add(list.size());

                        System.out.println("list.get(k)="+list.get(k));
                        System.out.println("param[j]="+param[j]);
                        System.out.println("list.size()="+list.size());
                        list.clear();
                        System.out.println("list被清空"+list.toString());
                        break out;//下一个字符和list中有一致的，记录这次的list长度，跳出循环，从第i+1个再开始

                    }else{
                        if(k==(list.size()-1))//这么设置的目的是要加入的字符和list中比对一遍后没有一个和list中一致的，那么就在list中添加这个字符，并跳出这个循环
                        {
                            System.out.println("list.add(param[j]),param[j]="+param[j]);
                            list.add(param[j]);//如果下一个字符与list中没有一致的，则存入list中，然后继续往下面进行

                            break;
                        }
                    }
                }
                array.add(list.size());
            }
        }
        System.out.println("array="+array.toString());
        Collections.sort(array);
        System.out.println("array排序后："+array.toString());
        if(array.size()<1)
        {
            return 0;
        }else{
            return array.get(array.size()-1);
        }

    }

    public static void main(String arg[])
    {
        int len = lengthOfLongestSubstring("cd");
        System.out.println("len="+len);
    }
}
