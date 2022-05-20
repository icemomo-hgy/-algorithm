package sort;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: sort
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/14 22:19
 * @Description:
 * @since JDK 1.8
 */
public class SelectSort {
    public static void main(String[] args) {
        int [] is = new int[80000];
        for (int i = 0; i < is.length; i++) {
            is[i] = ( (Double)(Math.random() * 80000)).intValue();
        }
        int temp=0;
        long l = System.currentTimeMillis();
        for (int i = 0; i < is.length; i++) {
            int min = is[i];
            int minIndex=i;
            for (int j = i+1; j < is.length-1 ; j++) {

                if (is[j]<min){
                  min = is[j];
                  minIndex = j;

                }
            }
            is[minIndex] = is[i];
            is[i] = min;
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
//        for (int i : is) {
//            System.out.print(i);
//            System.out.print(",");
//        }

    }
}
