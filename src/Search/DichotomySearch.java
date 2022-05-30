package Search;

import java.util.ArrayList;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: Search
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/22 15:00
 * @Description:  二分查找（递归法）
 * @since JDK 1.8
 */
public class DichotomySearch {

    ArrayList Dichotomy(int[] array,int left,int right,int value){
        int mid = (left +right)/2;
        int tempValues = array[mid];

        if(left>right||value<array[0]||value>array[array.length-1]){
            return null;
        }
        if(value > tempValues){
          return   Dichotomy(array,mid+1,right,value);  //右递归
        }else if(value < tempValues){
        return     Dichotomy(array,left,mid-1,value); // 左递归
        }else {
            ArrayList<Integer> arrayList = new ArrayList();
            int temp = mid-1;
            while (temp>=0&&array[temp] == value){
                arrayList.add(temp);
                temp--;
            }
            arrayList.add(mid);
            temp = mid+1;
            while (temp<=right&&array[temp] == value){
                arrayList.add(temp);
                temp++;
            }

            return arrayList;
        }

    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,6,6,6,6,7,8,9,10};
        System.out.println( new DichotomySearch().Dichotomy(array,0, array.length-1, 11));
    }
}
