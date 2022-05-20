package sort;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: sort
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/15 14:03
 * @Description:
 * @since JDK 1.8
 */
public class InsertSort {
    void insertSortDemo(int[] ints){
        long l = System.currentTimeMillis();
        int temp = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = i; j >0 ; j--) {
                if(ints[j]<ints[j-1]){
                    if(ints[j]==ints[j-1]){continue;}
                    temp = ints[j];
                    ints[j] = ints[j-1];
                    ints[j-1] = temp;
                }else {
                    break;
                }
            }
        }
//        for (int i: ints) {
//            System.out.print(i);
//            System.out.print(",");
//        }
        long ll = System.currentTimeMillis();
        System.out.println();
        System.out.println(ll-l+"毫秒");
    }

    public static void main(String[] args) {
        int [] ints = new int[80000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = ( (Double)(Math.random() * 800000)).intValue();
        }
      new InsertSort().insertSortDemo(ints);

    }


}
