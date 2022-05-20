package sort.test;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: sort.test
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/19 15:23
 * @Description:
 * @since JDK 1.8
 */
public class MergeSortTest {

    void MergeSort(int[] array,int left,int right, int [] temp){
        int mid = (left+right)/2;
       if(left<right){
            MergeSort(array,left,mid,temp);
            MergeSort(array,mid+1,right,temp);
            merge(array,left,right,temp);
        }

    }
    void merge(int array[],int left ,int right,int []temp){
        int mid = (left+right)/2;

        int i = left;
        int j = mid+1;
        int t = 0;
        while (i<=mid&&j<=right){
            if(array[i]<array[j]){
                temp[t] = array[i];
                i++;
                t++;
            }else{
                temp[t] = array[j];
                j++;
                t++;
            }
        }
        while (i<=mid){
            temp[t] = array[i];
            t++;
            i++;
        }
        while ((j<=right)){
            temp[t] = array[j];
            j++;
            t++;
        }
        t = 0;
        int templeft = left;
        while (templeft<=right){
            array[templeft] = temp[t];
            t++;
            templeft++;
        }

    }

    public static void main(String[] args) {
        int[] arrat = GetArrat.getArrat(8000000);
        MergeSortTest m = new MergeSortTest();
        long l = System.currentTimeMillis();
        int []temp = new int[arrat.length];
        m.MergeSort(arrat,0, arrat.length-1,temp);
        System.out.println(System.currentTimeMillis()-l);
//        for (int i : arrat) {
//            System.out.println(i);
//        }
    }

}
