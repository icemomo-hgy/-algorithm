package Leetcode;

import java.util.HashMap;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: Leetcode
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/30 21:07
 * @Description:
 * @since JDK 1.8
 */
public class romanToInt {
     int romanToInt(String s){
          char[] chars = s.toCharArray();
          int res = 0;
          System.out.println(chars);
         HashMap<Character, Integer> ha = new HashMap();
          ha.put('I',1);
          ha.put('V',5);
          ha.put('X',10);
          ha.put('L',50);
          ha.put('C',100);
          ha.put('D',500);
          ha.put('M',1000);
          for (int i = 0; i < chars.length; i++) {
               int j = i + 1 ;
             if(i<chars.length-1){
                    if(ha.get(chars[i])<ha.get(chars[j])){
                         res -= ha.get(chars[i]);
                    }else {
                         System.out.println(i);
                         res +=ha.get(chars[i]);
                    }
               }else {
                    res += ha.get(chars[i]);
               }

          }
          return res;
     }

     public static void main(String[] args) {
          System.out.println( new  romanToInt().romanToInt("IV"));

     }
}
