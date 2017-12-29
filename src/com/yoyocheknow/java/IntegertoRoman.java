package com.yoyocheknow.java;

import java.util.HashMap;

/**
 * 类说明
 * Given an integer, convert it to a roman numeral.

    Input is guaranteed to be within the range from 1 to 3999.

    将数字转为罗马数字
    罗马数字规则：
 *  罗 马数字共有七个，即I(1)，V(5)，X(10)，L(50)，C(100)，D(500)，M(1000)。按照下面的规则可以表示任意正整数。
 *  重复数次：一个罗马数字重复几次，就表示这个数的几倍。
 *  右加左减：在一个较大的罗马数字的右边记上一个较小的罗马数字，表示大数字加小数字。在一个较大的数字的左边记上一个较小的罗马数字，表示大数字减小数字。
 *           但是，左减不能跨越等级。比如，99不可以用IC表示，用XCIX表示。
 *  加线乘千：在一个罗马数字的上方加上一条横线或者在右下方写M，表示将这个数字乘以1000，即是原数的1000倍。
 *            同理，如果上方有两条横线，即是原数的1000000倍。
 *  单位限制：同样单位只能出现3次，如40不能表示为XXXX，而要表示为XL。
 *
 * 例如整数 1437 的罗马数字为 MCDXXXVII， 我们不难发现，千位，百位，十位和个位上的数分别用罗马数字表示了。
 * 1000 - M, 400 - CD, 30 - XXX, 7 - VII。所以我们要做的就是用取商法分别提取各个位上的数字，然后分别表示出来：

         100 - C

         200 - CC

         300 - CCC

         400 - CD

         500 - D

         600 - DC

         700 - DCC

         800 - DCCC

         900 - CM

 我们可以分为四类，100到300一类，400一类，500到800一类，900最后一类。每一位上的情况都是类似的，代码如下：
 *
 *
 * @author zhangzhihua
 * @date 2017/12/28 17:31
 */
public class IntegertoRoman {
    public String intToRoman(int num) {
        String res="";
        char roman[]={'M','D','C','L','X','V','I'};
        int value[] ={1000,500,100,50,5,1};

        for(int n=0;n<7;n+=2)
        {
            int x = num/value[n];
            if(x<4){
                for(int i=1;i<=x;++i)
                    res+=roman[n];
            }else if(x==4)
                res=res+roman[n]+roman[n-1];
            else if(x>4&&x<9)
            {
                res+=roman[n-1];
                for(int i=6;i<=x;++i) res+=roman[n];
            }
            else if(x==9) res=res+roman[n]+roman[n-2];
            num%=value[n];
        }
        return res;


    }


}
