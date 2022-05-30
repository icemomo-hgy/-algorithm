package Search.Test;

import sort.RadixSort;

import java.util.Arrays;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: Search.Test
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/23 15:00
 * @Description:
 * @since JDK 1.8
 */
public class FibonacciSearchTest {
  static int current;

  int []  FibonacciArray(int n ){
     int [] array = new int[n];
     array[0] = 1;
     array[1] = 1 ;
     for (int i = 2; i <n ; i++) {
        array[i] = array[i-1] + array[i-2];
     }
     return array;

  }

 int FibonacciSearchTest(int [] array,int value){
     int low = 0;
     int height = array.length-1;
     int mid = 0;
     int k=  0;
     int[] ints = FibonacciArray(50);
     while (height>ints[k] -1){
        k++;
     }
     int[] ints1 = Arrays.copyOf(array, ints[k]);
     for (int i= array.length; i <ints1.length ; i++) {
        ints1[i]=array[array.length-1];
     }
     while (low<=height){
        current+=1;
        mid = low + ints[k-1] -1;
        if(value<array[mid]){
        height = mid-1;
           k--;
        }else if(value>array[mid]){
            low =mid+1;
            k -=2;
        } else {
            if(mid<height){
               return mid;
            }      else {
               return  height;
            }

        }
     }
     return  -1;

  }

   public static void main(String[] args) {
      int [] is = new int[8000000];
      for (int i = 0; i < is.length; i++) {
         is[i] = ( (Double)(Math.random() * 8000000)).intValue();
      }
      RadixSort r = new RadixSort();
      r.Radix(is);
     FibonacciSearchTest f = new  FibonacciSearchTest();

      System.out.println(f.FibonacciSearchTest(is,444434));
      System.out.println(FibonacciSearchTest.current+"次！");
   }

}
