package sort;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: sort
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/18 21:07
 * @Description:
 * @since JDK 1.8
 */
public class RadixSort {

  public   void Radix(int[] array){
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i]>max){
             max = array[i];
            }
        }
        int maxlength = (max+"").length();
        int[][] bucket = new int [10][array.length];
        int [] bucketsCurrent = new int[10];

        for (int i = 0,n = 1; i < maxlength; i++, n*=10) {
            for (int j = 0; j < array.length; j++) {
                int index = (array[j] / n ) % 10;
                bucket[index][bucketsCurrent[index]] = array[j];
                bucketsCurrent[index]++;
            }
            int current = 0;
            for (int j = 0; j < bucketsCurrent.length; j++) {
                if(bucketsCurrent[j]!=0){
                    for (int k = 0; k < bucketsCurrent[j]; k++) {
                        array[current++] = bucket[j][k];
                    }
                }
                bucketsCurrent[j] = 0;
            }
        }



    }

    public static void main(String[] args) {
        int [] is = new int[8000000];
        for (int i = 0; i < is.length; i++) {
            is[i] = ( (Double)(Math.random() * 8000000)).intValue();
        }

        RadixSort  radixSort = new RadixSort();

        long l = System.currentTimeMillis();
        radixSort.Radix(is);
        System.out.println(System.currentTimeMillis()-l);

//        for (int i : is ) {
//            System.out.print(i);
//            System.out.print(",");
//        }
    }
}
