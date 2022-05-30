package Search.Test;

import sort.RadixSort;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: Search.Test
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/23 13:39
 * @Description:
 * @since JDK 1.8
 */
public class InsertSearchTest {
      static   int current = 1;

        int InsertTest(int[]array,int left,int right,int values){
            current++;
            if(left>right||array[0]>values||array[array.length-1]<values){
                return -1;
            }


            int imd =(int) (left +((((double)values - array[left]) / (array[right] - array[left])) *(right - left)));
            int v = array[imd];

            if(v < values){
                return InsertTest(array,imd+1,right,values);
            }else if(v>values){
              return   InsertTest(array,left,imd -1,values);
            }else {
                return imd;
            }


        }

    public static void main(String[] args) {

        int [] is = new int[8000000];
        for (int i = 0; i < is.length; i++) {
            is[i] = ( (Double)(Math.random() * 8000000)).intValue();
        }
        RadixSort r = new RadixSort();
        r.Radix(is);
        int i = new InsertSearchTest().InsertTest(is, 0, is.length - 1, 4444586);
        System.out.println( InsertSearchTest.current);
        System.out.println(i+"次");
    }
}
