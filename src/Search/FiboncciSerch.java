package Search;

import Test.Fibonacci;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: Search
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/22 21:31
 * @Description:
 * @since JDK 1.8
 */
public class FiboncciSerch {
    static int[] f(int n){
        int [] s = new int[n];
        s[0]=1;
        s[1]=1;
        for (int i = 2; i < n; i++) {
            s[i] = s[i-1]+s[i-2];
        }
        return s;
    }

    int FibonacciSearch(int [] array,int values){
        int[] f = FiboncciSerch.f(20);
        int low = 0;
        int height  = array.length-1;
        int k =0;
        int mid = 0;
        while (height>f[k]-1){
            k++;
        }
        int[] ints = Arrays.copyOf(array, f[k]);
        for (int i = height+1; i < ints.length ; i++) {
            ints[i] = array[height];
        }
        while (low<=height){
            mid = low + f[k-1]-1;
            if(values<ints[mid]){
                height=mid-1;
                k--;
            }else if (values>ints[mid]){
                low=mid+1;
                k-=2;
            }else {
                if(mid<=height){
                    return mid;
                }else{
                    return height;
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
            int [] array = {1,2,3,4,5,6,7,8};
            FiboncciSerch f = new FiboncciSerch();
        int i = f.FibonacciSearch(array, 348);
        System.out.println(i);
    }
}
