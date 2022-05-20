package sort.test;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: sort.test
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/19 13:11
 * @Description:
 * @since JDK 1.8
 */
public class GetArrat {
    public static int[] getArrat(int l){
        int [] ints = new int[l];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = ( (Double)(Math.random() * 800000)).intValue();
        }
        return ints;
    }
}
