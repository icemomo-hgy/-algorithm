package sort.test;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: sort.test
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/19 13:19
 * @Description:
 * @since JDK 1.8
 */
public class QuickSortTest {

    void QuickStart(int[] array,int left,int right){
        int l = left;
        int r = right;
        int temp = 0;
        int pivot = array[(l+r)/2];
        while (l<r){
            while (array[l]<pivot){
                l++;
            }
            while (array[r]>pivot){
                r--;
            }
            if(l>=r){
                break;
            }
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;

            if(array[l] == pivot){
                r--;
            }
            if(array[r] == pivot){
                l++;
            }
        }
        if(l==r){
            l++;
            r--;
        }
        if(left<r){
            QuickStart(array, left, r);
        }
        if(l<right){
            QuickStart(array, l, right);
        }

    }

    public static void main(String[] args) {
        int[] arrat = GetArrat.getArrat(8000000);
        QuickSortTest quickSortTest = new QuickSortTest();
        long l = System.currentTimeMillis();
        quickSortTest.QuickStart(arrat,0, arrat.length-1);
        System.out.println(System.currentTimeMillis()-l+"毫秒");
//        for (int i : arrat) {
//            System.out.print(i);
//            System.out.print(",");
//        }
    }
}
