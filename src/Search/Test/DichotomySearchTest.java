package Search.Test;

import sort.RadixSort;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: Search.Test
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/23 13:25
 * @Description:
 * @since JDK 1.8
 */
public class DichotomySearchTest {
        static int current = 0;
    int test(int[] array,int left,int right,int values){
        current++;
        int mid = (left + right)/2;
        int Vm = array[mid];
        if(left>right){
            return -1;
        }
        if(values < Vm){
           return test(array,left,mid-1,values);
        }else if(values > Vm){
           return test(array,mid+1,right,values);
        }else {
            return mid;
        }


    }

    public static void main(String[] args) {

        int [] is = new int[8000000];
        for (int i = 0; i < is.length; i++) {
            is[i] = ( (Double)(Math.random() * 8000000)).intValue();
        }
        RadixSort r = new RadixSort();
        r.Radix(is);
        int test = new DichotomySearchTest().test(is, 0, is.length - 1, 543244);
        System.out.println(test);
        System.out.println(DichotomySearchTest.current+"次");
    }
}
