package sort;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: sort
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/18 15:55
 * @Description:
 * @since JDK 1.8
 */
public class MergeSort {

    void mergeSortDemo(int[] array,int left,int right,int[]temp){

     if(left<right){
         int mide = (left+right)/2;
         mergeSortDemo(array,left,mide,temp);
         mergeSortDemo(array,mide+1,right,temp);
         merge(array,left,mide,right,temp);
     }


    }
    void merge(int[] array,int left,int mide,int right,int[] temp){
        int i  = left;
        int j = mide+1;
        int t = 0;
        while (i<=mide&&j<=right){
            if(array[i]<=array[j]){
                temp[t] = array[i];
                t++;
                i++;
            }else {
                temp[t] = array[j];
                j++;
                t++;
            }
        }
        while (i<=mide){
            temp[t] = array[i];
            i++;
            t++;
        }
        while (j<=right){
            temp[t] = array[j];
            j++;
            t++;
        }
        t = 0;
        int templeft = left;
        while (templeft<=right){
            array[templeft] = temp[t];
            templeft++;
            t++;
        }
    }

    public static void main(String[] args) {
        int [] is = new int[8000000];
        for (int i = 0; i < is.length; i++) {
            is[i] = ( (Double)(Math.random() * 80000000)).intValue();
        }
        MergeSort mergeSort = new MergeSort();
        int [] temp = new int[is.length];
        long l = System.currentTimeMillis();
        mergeSort.mergeSortDemo(is,0,is.length-1,temp);
        System.out.println(System.currentTimeMillis()-l+"毫秒");
//        for (int i : is) {
//            System.out.print(i);
//            System.out.print(",");
//        }
    }
}
