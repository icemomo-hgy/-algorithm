package sort;

import org.junit.jupiter.api.Test;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: sort
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/14 21:18
 * @Description:
 * @since JDK 1.8
 */
public class BubbleSort {

    public static void main(String[] args) {
        int [] is = new int[80000];
        for (int i = 0; i < is.length; i++) {
            is[i] = ( (Double)(Math.random() * 8000000)).intValue();
        }
        boolean flag = false;
        int tem = 0;
        long l = System.currentTimeMillis();
            for (int i = 0; i < is.length; i++) {
                flag  = false;
                for (int j = 0; j < is.length-1-i; j++) {
                    if(is[j]>=is[j+1]){
                        flag = true;
                        tem++;
                        Integer tar = is[j];
                        is[j] = is[j+1];
                        is[j+1] = tar;
                    }
                }
                if(!flag){
                    break;
                }
            }
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
//            for (int i:is) {
//                System.out.print(i);
//                System.out.print(",");
//            }
//        System.out.println();
//        System.out.println(tem+"次");

        }
    }


