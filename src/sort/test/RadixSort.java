package sort.test;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: sort.test
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/19 16:32
 * @Description:
 * @since JDK 1.8
 */
public class RadixSort {

    void RadixDemo(int[] array){
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(max<array[i]){
                max = array[i];
            }
        }
        int i = (max + "").length();

        int [][] buckets = new int[10][array.length];
        int [] bucketCurrent = new int[10];
        for (int j = 0, n = 1; j < i; j++,n*=10) {
            for (int k = 0; k < array.length; k++) {

                int index = (array[k]/n) % 10;
                buckets[index][bucketCurrent[index]] = array[k];
                bucketCurrent[index]++;
            }
            int current = 0;
            for (int k = 0; k < bucketCurrent.length; k++) {
                if(bucketCurrent[k]!=0){
                    for (int l = 0; l < bucketCurrent[k]; l++) {
                        array[current] = buckets[k][l];
                        current++;
                    }
                }
                bucketCurrent[k] = 0;
            }

        }

    }

    public static void main(String[] args) {
        int[] arrat = GetArrat.getArrat(8000000);
        RadixSort radixSort = new RadixSort();
        long l = System.currentTimeMillis();
        radixSort.RadixDemo(arrat);
        System.out.println(System.currentTimeMillis()-l+"毫秒！");
//        for (int i: arrat) {
//            System.out.println(i);
//        }
    }
}
