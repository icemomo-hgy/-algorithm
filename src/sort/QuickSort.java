package sort;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: sort
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/17 16:43
 * @Description:
 * @since JDK 1.8
 */
public class QuickSort {

     void Start(int[] array ,int left,int right ){
         int  l = left;
        int r = right;
        int temp =0;
        int pivot = array[(l+r)/2];
        while (l<r){
            while (array[l]<pivot){
                l++;
            }
            while (array[r]> pivot){
                r--;
            }
            if(l>=r){
                break;
            }
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;

             if(array[l]==pivot){
                 r--;
             }
             if(array[r]==pivot){
                 l++;
             }
        }
         if(l == r){
             l++;
             r--;
         }
         if(left < r){
             Start(array,left,r);
         }
         if(right>l){
             Start(array,l,right);
         }


     }

    public static void main(String[] args) {
        int [] is = new int[8000000];
        for (int i = 0; i < is.length; i++) {
            is[i] = ( (Double)(Math.random() * 80000000)).intValue();
        }
        QuickSort quickSort = new QuickSort();
        long l = System.currentTimeMillis();
        quickSort.Start(is,0, is.length-1);

        long l2 = System.currentTimeMillis();
        System.out.println(l2-l);
//        for (int i:is) {
//            System.out.print(i);
//            System.out.print(",");
//        }
    }
}
