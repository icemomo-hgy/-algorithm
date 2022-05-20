package sort.test;

import sort.SelectSort;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: sort.test
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/19 14:12
 * @Description:
 * @since JDK 1.8
 */
public class SelectSortDemo {
    void SelectSort(int[] array){
        int temp;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            int min = array[i];
            for (int j = i+1; j < array.length-1 ; j++) {
                if(array[j]<min){
                   minIndex = j;
                   min = array[j];
                }
            }
            if(minIndex!=i){
            array[minIndex] = array[i];
            array[i] = min;
            }
        }

    }

    public static void main(String[] args) {
        int[] arrat = GetArrat.getArrat(80000);
        SelectSortDemo selectSortDemo = new SelectSortDemo();
        long l = System.currentTimeMillis();
        selectSortDemo.SelectSort(arrat);
        System.out.println(System.currentTimeMillis()-l+"毫秒");
//        for (int i : arrat) {
//            System.out.print(i);
//            System.out.print(",");
//        }
    }

}
