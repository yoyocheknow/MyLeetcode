package com.yoyocheknow.java.ZigZagConversion;

import java.util.Arrays;

/**
 * 类说明
 *The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *  P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:
 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 用一个字符串数组 string[rows] 来存储每一行，最后一拼接就是最终结果。

 用一个delta表示正向还是反向，即上图中从第一行到最后一行还是最后一行到第一行
 * @author zhangzhihua
 * @date 2017/12/21 15:13
 */
public class ZigZag {
    public static String convert(String s, int nRows) {
        int len = s.length();
        if (len == 0 || nRows <= 1) return s;

        String[] ans = new String[nRows];
        Arrays.fill(ans, "");
        int row = 0, delta = 1;
        for (int i = 0; i < len; i++) {
            ans[row] += s.charAt(i);
            row += delta;
            if (row >= nRows) {//说明此时该折回换行了
                row = nRows-2;
                delta = -1;
            }
            if (row < 0) {//折到头以后重新开始
                row = 1;
                delta = 1;
            }
        }

        String ret = "";
        for (int i = 0; i < nRows; i++) {
            ret += ans[i];
        }
        return ret;
    }

    //方法二：
   /* 这道题就是看坐标的变化。并且需要分块处理。

    n=2时，字符串坐标变成zigzag的走法就是：

            0 2 4 6

            1 3 5 7

    n=3时的走法是：

            0     4     8

            1  3  5  7  9

            2     6    10

    n=4时的走法是：

            0       6        12

            1    5  7     11 13

            2  4    8  10    14

            3       9        15

      可以发现规律，每个V形字符串的长度永远是 2n-2 （0，1，2，3，4，5和6，7，8，9，10，11各自组成的V字形，也就是说
      按行存储的话，第0行和第n-1行的间距一直是2n-2，比如n=4时0，6，12和3，9，15）。知道了首尾两行的计算规律那么现在计算中间
      斜线数字的规律。比如 1，5，7，11，13之间是什么规律，2，4，8，10，14之间是什么规律。
      可以看出，斜线之间的规律不仅关系的行n，还关系到列j。可以得出一下结论：
      斜线上的数字=j+(2n-2)-2i;

     按照上面的规律就可以写出代码了
      */
    public static String convert2(String s, int n) {
        if(s==null||s.length()==0||n<=0)
        {
            return "";
        }
        if(n==1)
        {
            return s;
        }

        int size =2*n-2;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<s.length();j+=size)
            {
                sb.append(s.charAt(j));
                if(i!=0&&i!=n-1)
                {
                    int temp=j+size-2*i;
                    if(temp<s.length())
                    {
                        sb.append(s.charAt(temp));
                    }
                }
            }
        }
        return sb.toString();
    }
    public static void main(String args[])
    {
        convert2("0123456789",4);
    }
}
